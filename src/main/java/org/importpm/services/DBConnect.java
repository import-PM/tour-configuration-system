package org.importpm.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.importpm.models.*;
import org.importpm.models.enums.*;

public class DBConnect {
    private static Connection conn;
    private static List<Province> provinces;

    //-------------------------------- Open And Close DBConnect --------------------------------
    public static void loadDriver() {
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tour-configuration-system?" + "user=root");
            System.out.println("Connection Is Successful");
            provinces = getProvinces();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static void closeDriver() throws SQLException {
        conn.close();
        System.out.println("Connection Is Closed");
    }

    //-------------------------------- Print Result --------------------------------
    private static void printResults(ResultSet rs) {
        try {
            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();

            //print head
            for (int i = 0; i < cols; i++) {
                String name = md.getColumnLabel(i + 1);
                System.out.print(name + "\t");
            }
            System.out.println();

            //print data
            while (rs.next()) {
                for (int i = 0; i < cols; i++) {
                    String value = rs.getString(i + 1);
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error printing results: " + e.getMessage());
        }

    }

    //-------------------------------- Normal Query --------------------------------
    public static ResultSet query(String codeSQL) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(codeSQL);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;
    }

    //-------------------------------- CRUD Query --------------------------------
    public static void queryUpdate(String codeSQL) {
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(codeSQL);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    //-------------------------------- Get Data From Tourist Table  --------------------------------
    private static List<Tourist> createTouristList(String query) {
        List<Tourist> touristArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                touristArrayList.add(new Tourist(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("citizen_id"),
                                rs.getString("allergies"),
                                rs.getString("medical_note")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return touristArrayList;
    }

    private static Tourist createTourist(String query) {
        Tourist tourist = null;
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                tourist = new Tourist(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("citizen_id"),
                        rs.getString("allergies"),
                        rs.getString("medical_note")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tourist;
    }

    public static List<Tourist> getTourist() {
        return createTouristList("SELECT id,name,citizen_id,allergies,medical_note FROM tourist");
    }

    public static Tourist getTouristById(int id) {
        return createTourist("SELECT id,name,citizen_id,allergies,medical_note FROM tourist\n" +
                "WHERE id=" + id);
    }

    public static List<Tourist> getTouristsByTourId(int id) {
        return createTouristList("SELECT tt.fk_tour_id,tt.fk_tourist_id,t.id,t.name,t.citizen_id,t.allergies,t.medical_note FROM tour_tourist as tt\n" +
                "INNER JOIN tourist as t\n" +
                "ON t.id = tt.fk_tourist_id\n" +
                "WHERE tt.fk_tour_id = " + id);
    }

    //-------------------------------- Get Data From Hotel Table  --------------------------------
    private static List<Hotel> createHotelList(String query) {
        List<Hotel> hotelArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                Hotel hotel = new Hotel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getFloat("price"),
                        HotelType.getType(rs.getInt("type")),
                        HotelRate.getRating(rs.getInt("rate"))
                );
                hotel.setProvince(getProvinceById(rs.getInt("fk_province_id")));
                hotelArrayList.add(hotel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelArrayList;
    }

    private static Hotel createHotel(String query) {
        Hotel hotel = null;
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                hotel = new Hotel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getFloat("price"),
                        HotelType.getType(rs.getInt("type")),
                        HotelRate.getRating(rs.getInt("rate"))
                );
                hotel.setProvince(getProvinceById(rs.getInt("fk_province_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }

    public static List<Hotel> getHotels() {
        return createHotelList("SELECT id,fk_province_id,name,price,type,rate FROM hotel");
    }

    public static Hotel getHotelById(int id) {
        return createHotel("SELECT id,fk_province_id,name,price,type,rate FROM hotel\n" +
                "WHERE id=" + id);
    }

    public static Hotel getHotelByTourId(int id) {
        return createHotel("SELECT th.fk_tour_id,th.fk_hotel_id,h.id,h.fk_province_id,h.name,h.price,h.type,h.rate FROM tour_hotel as th\n" +
                "INNER JOIN hotel as h \n" +
                "ON th.fk_hotel_id = h.id\n" +
                "WHERE th.fk_tour_id = " + id);
    }


    //-------------------------------- Get Data From Province Table  --------------------------------
    private static List<Province> createProvinceList(String query) {
        List<Province> provinceArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                provinceArrayList.add(new Province(
                                rs.getInt("id"),
                                rs.getString("name")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinceArrayList;
    }

    private static Province createProvince(String query) {
        Province province = null;
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                province = new Province(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return province;
    }

    public static List<Province> getProvinces() {
        return createProvinceList("SELECT id,name FROM province");
    }

    public static Province getProvinceById(int id) {
        return createProvince("SELECT id,name FROM province\n" +
                "WHERE id =" + id);
    }

    //-------------------------------- Get Data From Quotation Table  --------------------------------
    private static List<Quotation> createQuotationList(String query) {
        List<Quotation> quotationArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                quotationArrayList.add(new Quotation(
                                rs.getInt("id"),
                                rs.getFloat("real_price"),
                                QuotationStatus.getQuotationStatus(rs.getInt("status"))
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quotationArrayList;
    }

    private static Quotation createQuotation(String query) {
        Quotation quotation = null;
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                quotation = new Quotation(
                        rs.getInt("id"),
                        rs.getFloat("real_price"),
                        QuotationStatus.getQuotationStatus(rs.getInt("status"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quotation;
    }

    public static List<Quotation> getQuotations() {
        return createQuotationList("SELECT id,real_price,status FROM quotation");
    }

    public static Quotation getQuotationById(int id) {
        return createQuotation("SELECT id,real_price,status FROM quotation\n" +
                "WHERE id=" + id);
    }

    //-------------------------------- Get Data From Transportation Table  --------------------------------
    private static List<Transportation> createTransportationList(String query) {
        List<Transportation> transportationArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                transportationArrayList.add(new Transportation(
                                rs.getInt("id"),
                                rs.getFloat("price"),
                                TransportationType.getTransportationType(rs.getInt("type")),
                                rs.getInt("amount")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transportationArrayList;
    }

    private static Transportation createTransportation(String query) {
        Transportation transportation = null;
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                transportation = new Transportation(
                        rs.getInt("id"),
                        rs.getFloat("price"),
                        TransportationType.getTransportationType(rs.getInt("type")),
                        rs.getInt("amount")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transportation;
    }

    public static List<Transportation> getTransportations() {
        return createTransportationList("SELECT tt.fk_tour_id,tt.fk_transportation_id,tt.amount,t.id,t.price,t.type FROM tour_transportation as tt\n" +
                "INNER JOIN transportation as t\n" +
                "ON t.id = tt.fk_transportation_id\n");
    }

    public static Transportation getTransportationById(int id) {
        return createTransportation("SELECT tt.fk_tour_id,tt.fk_transportation_id,tt.amount,t.id,t.price,t.type FROM tour_transportation as tt\n" +
                "INNER JOIN transportation as t\n" +
                "ON t.id = tt.fk_transportation_id\n" +
                "WHERE id=" + id);
    }

    public static List<Transportation> getTransportationByTourId(int id) {
        return createTransportationList("SELECT tt.fk_tour_id,tt.fk_transportation_id,tt.amount,t.id,t.price,t.type FROM tour_transportation as tt\n" +
                "INNER JOIN transportation as t\n" +
                "ON t.id = tt.fk_transportation_id\n" +
                "WHERE tt.fk_tour_id =" + id);
    }

    //-------------------------------- Get Data From Tour Table  --------------------------------
    private static List<Tour> createTourList(String query) {
        List<Tour> tourArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                Tour tour = new Tour(
                        rs.getInt("id"),
                        rs.getString("contact_name"),
                        rs.getString("contact_phone"),
                        rs.getString("contact_email"),
                        TourStatus.getTourStatus(rs.getInt("status")),
                        rs.getFloat("cost_price"),
                        rs.getInt("tourist_total"),
                        rs.getInt("insurance_status"),
                        rs.getFloat("budget"),
                        rs.getString("description"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate()
                );
                tour.setHotel(getHotelByTourId(rs.getInt("id")));
                tour.setTourists(getTouristsByTourId(rs.getInt("id")));
                tour.setTransportations(getTransportationByTourId(rs.getInt("id")));
                tour.setQuotation(getQuotationById(rs.getInt("fk_quotation_id")));
                tour.setProvince(getProvinceById(rs.getInt("fk_province_id")));
                tourArrayList.add(tour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tourArrayList;
    }

    private static Tour createTour(String query) {
        Tour tour = null;
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                tour = new Tour(
                        rs.getInt("id"),
                        rs.getString("contact_name"),
                        rs.getString("contact_phone"),
                        rs.getString("contact_email"),
                        TourStatus.getTourStatus(rs.getInt("status")),
                        rs.getFloat("cost_price"),
                        rs.getInt("tourist_total"),
                        rs.getInt("insurance_status"),
                        rs.getFloat("budget"),
                        rs.getString("description"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate()
                );
                tour.setHotel(getHotelByTourId(rs.getInt("id")));
                tour.setTourists(getTouristsByTourId(rs.getInt("id")));
                tour.setTransportations(getTransportationByTourId(rs.getInt("id")));
                tour.setQuotation(getQuotationById(rs.getInt("fk_quotation_id")));
                tour.setProvince(getProvinceById(rs.getInt("fk_province_id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }

    public static List<Tour> getTours() {
        return createTourList("SELECT id,fk_province_id,fk_quotation_id,contact_name,contact_phone,contact_email,status,insurance_status,cost_price,tourist_total,budget,description,start_date,end_date FROM tour");
    }

    public static List<Tour> getToursWithOutCancel() {
        return createTourList("SELECT id,fk_province_id,fk_quotation_id,contact_name,contact_phone,contact_email,status,insurance_status,cost_price,tourist_total,budget,description,start_date,end_date FROM tour\n" +
        "WHERE status != 9");
    }

    //-------------------------------- Insert Data To Table --------------------------------

    public static void insertTour(Tour tour) {
        try {
            queryUpdate("INSERT INTO tour(fk_province_id,fk_quotation_id,contact_name,contact_phone,contact_email,insurance_status,cost_price,tourist_total,budget,description,start_date,end_date) VALUES\n" +
                    "('" + tour.getProvince().getId() + "','" +
                    tour.getQuotation().getId() + "','" +
                    tour.getContactName() + "','" +
                    tour.getContactPhone() + "','" +
                    tour.getContactEmail() + "','" +
                    tour.getInsuranceStatus() + "','" +
                    tour.getCostPrice() + "','" +
                    tour.getTouristTotal() + "','" +
                    tour.getBudget() + "','" +
                    tour.getDescription() + "','" +
                    tour.getStartDate() + "','" +
                    tour.getEndDate() + "')"
            );
            insertTourTransportation(tour);
            insertTourHotel(tour);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertQuotation(Quotation quotation) {
        try {
            queryUpdate("INSERT INTO quotation(real_price) VALUE\n" +
                    "('" + quotation.getRealPrice() + "')");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertTourHotel(Tour tour) {
        try {
            queryUpdate("INSERT INTO tour_hotel(fk_tour_id,fk_hotel_id,cost_withholding) VALUE\n" +
                    "('" + tour.getId() + "','" +
                    tour.getHotel().getId() + "')");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertTourTransportation(Tour tour) {
        try {
            for (Transportation transportation : tour.getTransportations()) {
                queryUpdate("INSERT INTO tour_transportation(fk_tour_id,fk_transportation_id,cost_withholding,amount) VALUE\n" +
                        "('" + tour.getId() + "','" +
                        transportation.getId() + "','" +
                        transportation.getPrice() + "','" +
                        transportation.getAmount() + "')");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //-------------------------------- Update Data To Table --------------------------------
    public static void updateTourStatus(Tour tour) {
        try {
            queryUpdate("UPDATE tour\n" +
                    "SET status='" + tour.getStatus().getStatus() + "'\n" +
                    "WHERE id=" + tour.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateQuotationStatus(Quotation quotation) {
        try {
            queryUpdate("UPDATE quotation\n" +
                    "SET status='" + quotation.getQuotationStatus().getStatus() + "'\n" +
                    "WHERE id=" + quotation.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //-------------------------------- Test Data --------------------------------
    public static void test() throws SQLException {
        List<Hotel> hotels = getHotels();
        System.out.println("Hello");
        for (Hotel h : hotels) {
            System.out.println(h);
        }
    }
}

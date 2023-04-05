package org.importpm.services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.importpm.models.Quotation;
import org.importpm.models.Tour;
import org.importpm.models.Tourist;
import org.importpm.models.Transportation;

public class DBConnect {
    private static Connection conn;

    //-------------------------------- Open And Close DBConnect --------------------------------
    public static void loadDriver() {
        conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tour-configuration-system?" + "user=root");
            System.out.println("Connection Is Successful");
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
                                rs.getString("id"),
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
                        rs.getString("id"),
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

    //-------------------------------- Get Data From Hotel Table  --------------------------------
    private static List<Hotel> createHotelList(String query) {
        List<Hotel> hotelArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                hotelArrayList.add(new Hotel(
                                rs.getString("id"),
                                rs.getString("name"),
                                rs.getFloat("price"),
                                rs.getString("type"),
                                rs.getFloat("rate")
                        )
                );
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
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getFloat("price"),
                        rs.getString("type"),
                        rs.getFloat("rate")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }

    //-------------------------------- Get Data From Province Table  --------------------------------
    private static List<Province> createProvinceList(String query) {
        List<Province> provinceArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                provinceArrayList.add(new Province(
                                rs.getString("id"),
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
                        rs.getString("id"),
                        rs.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return province;
    }

    //-------------------------------- Get Data From Quotation Table  --------------------------------
    private static List<Quotation> createQuotationList(String query) {
        List<Quotation> quotationArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                quotationArrayList.add(new Quotation(
                                rs.getString("id"),
                                rs.getFloat("real_price"),
                                rs.getInt("status")
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
                        rs.getString("id"),
                        rs.getFloat("real_price"),
                        rs.getInt("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quotation;
    }

    //-------------------------------- Get Data From Transportation Table  --------------------------------
    private static List<Transportation> createTransportationList(String query) {
        List<Transportation> transportationArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                transportationArrayList.add(new Transportation(
                                rs.getString("id"),
                                rs.getFloat("price"),
                                rs.getInt("type")
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
                        rs.getString("id"),
                        rs.getFloat("price"),
                        rs.getInt("type")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transportation;
    }

    //-------------------------------- Get Data From Tour Table  --------------------------------
    private static List<Tour> createTourList(String query) {
        List<Tour> tourArrayList = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = query(query);
            while (rs.next()) {
                tourArrayList.add(new Tour(
                        rs.getString("id"),
                        rs.getString("contact_name"),
                        rs.getString("contact_phone"),
                        rs.getString("contact_email"),
                        rs.getInt("status"),
                        rs.getFloat("cost_price"),
                        rs.getInt("tourist_total"),
                        rs.getFloat("budget"),
                        rs.getString("desciption"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date")
                        )
                );
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
                        rs.getString("id"),
                        rs.getString("contact_name"),
                        rs.getString("contact_phone"),
                        rs.getString("contact_email"),
                        rs.getInt("status"),
                        rs.getFloat("cost_price"),
                        rs.getInt("tourist_total"),
                        rs.getFloat("budget"),
                        rs.getString("desciption"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date")
                );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
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
                    tour.getInsuranceStaus() + "','" +
                    tour.getCostPrice() + "','" +
                    tour.getTouristTotal() + "','" +
                    tour.getBudget() + "','" +
                    tour.getDescription() + "','" +
                    tour.getStartDate() + "','" +
                    tour.getEndDate() + "')"
            );
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

    //-------------------------------- Update Data To Table --------------------------------
    public static void updateTourStatus(Tour tour) {
        try {
            queryUpdate("UPDATE tour\n" +
                    "SET status='" + tour.getStatus() + "'\n" +
                    "WHERE id=" + tour.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateQuotationStatus(Quotation quotation) {
        try {
            queryUpdate("UPDATE quotation\n" +
                    "SET status='" + quotation.getStatus() + "'\n" +
                    "WHERE id=" + quotation.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package org.importpm.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.importpm.models.enums.TourStatus;

public class Tour {
    private int id;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private TourStatus status;
    private double costPrice;
    private int touristTotal;
    private int insuranceStatus;
    private double budget;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
//                                rs.getString("id"),
//                                        rs.getString("contact_name"),
//                                        rs.getString("contact_phone"),
//                                        rs.getString("contact_email"),
//                                        rs.getInt("status"),
//                                        rs.getFloat("cost_price"),
//                                        rs.getInt("tourist_total"),
//                                        rs.getFloat("budget"),
//                                        rs.getString("description"),
//                                        rs.getDate("start_date"),
//                                        rs.getDate("end_date")
    private Province province;
    private List<Tourist> tourists;
    private Hotel places;
    private List<Transportation> transportations;
    private Quotation quotation;

    public Tour(int id, String contactName, String contactPhone, String contactEmail, TourStatus status,
                double costPrice,  int touristTotal, int insuranceStatus, double budget, String description, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.status = status;
        this.description = description;
        this.costPrice = costPrice;
        this.touristTotal = touristTotal;
        this.insuranceStatus = insuranceStatus;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;

        this.tourists = new ArrayList<Tourist>();
        this.transportations = new ArrayList<Transportation>();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Province getProvince() {
        return this.province;
    }

    public TourStatus getStatus() {
        return this.status;
    }
    
    public int getTouristTotal() {
        return this.touristTotal;
    }

    public double getBudget() {
        return budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public int getInsuranceStatus() {
        return insuranceStatus;
    }

    public boolean addTourist(Tourist tourist) {
        return this.tourists.add(tourist);
    }

    public boolean removeTourist(Tourist tourist) {
        return this.tourists.remove(tourist);
    }

    public Hotel getHotel() {
        return places;
    }

    public void setHotel(Hotel places) {
        this.places = places;
    }

    public boolean addTransportation(Transportation transportation) {
        return this.transportations.add(transportation);
    }

    public boolean removeTransportation(Transportation transportation) {
        return this.transportations.remove(transportation);
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}

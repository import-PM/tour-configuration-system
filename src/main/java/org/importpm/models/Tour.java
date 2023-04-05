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
    private Province province;
    private List<Tourist> tourists;
    private Hotel hotel;
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
        this.province = new Province();
    }

    public Tour(String contactName, String contactPhone, String contactEmail, int touristTotal, int insuranceStatus, double budget, String description, LocalDate startDate, LocalDate endDate) {
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.touristTotal = touristTotal;
        this.insuranceStatus = insuranceStatus;
        this.budget = budget;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;

        this.tourists = new ArrayList<>();
        this.transportations = new ArrayList<>();
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
        return hotel;
    }

    public void setHotel(Hotel places) {
        this.hotel = places;
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

    public void setTourists(List<Tourist> tourists) {
        this.tourists = tourists;
    }

    public void setStatus(TourStatus status) {
        this.status = status;
    }

    public void setTransportations(List<Transportation> transportations) {
        this.transportations = transportations;
    }
}

package org.importpm.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.importpm.models.enums.TourStatus;

public class Tour {
    private int id;
    private String description;
    private String province;
    private TourStatus status;
    private int touristAmount;
    private double budget;
    
    private LocalDate startDate;
    private LocalDate endDate;

    private List<Tourist> tourists;
    private List<Hotel> places;
    private List<Quotation> quotations;
    private List<Transportation> transportations;
    private TravelInsurance travelInsurance;

    public Tour(String description, String province, TourStatus status, int touristAmount, double budget, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.province = province;
        this.status = status;
        this.touristAmount = touristAmount;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;

        this.tourists = new ArrayList<Tourist>();
        this.places = new ArrayList<Hotel>();
        this.quotations = new ArrayList<Quotation>();
        this.transportations = new ArrayList<Transportation>();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getProvince() {
        return province;
    }

    public TourStatus getStatus() {
        return status;
    }
    
    public int getTouristAmount() {
        return touristAmount;
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

    public TravelInsurance getTravelInsurance() {
        return travelInsurance;
    }

    public boolean addTourist(Tourist tourist) {
        return this.tourists.add(tourist);
    }

    public boolean removeTourist(Tourist tourist) {
        return this.tourists.remove(tourist);
    }

    public boolean addPlace(Hotel place) {
        return this.places.add(place);
    }

    public boolean removePlace(Hotel place) {
        return this.places.remove(place);
    }

    public boolean addQuotation(Quotation quotation) {
        return this.quotations.add(quotation);
    }

    public boolean removeQuotation(Quotation quotation) {
        return this.quotations.remove(quotation);
    }

    public boolean addTransportation(Transportation transportation) {
        return this.transportations.add(transportation);
    }

    public boolean removeTransportation(Transportation transportation) {
        return this.transportations.remove(transportation);
    }

    public void setTravelInsurance(TravelInsurance travelInsurance) {
        this.travelInsurance = travelInsurance;
    }

    public void setId(int id) {
        this.id = id;
    }

}

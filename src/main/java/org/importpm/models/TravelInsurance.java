package org.importpm.models;

public class TravelInsurance {
    private int id;
    private String companyName;
    private double price;

    private double fixedPrice;

    public TravelInsurance(String companyName, double price, double fixedPrice) {
        this.companyName = companyName;
        this.price = price;
        this.fixedPrice = fixedPrice;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    public double getFixedPrice() {
        return fixedPrice;
    }

}

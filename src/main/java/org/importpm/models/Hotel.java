package org.importpm.models;

import org.importpm.models.enums.PlaceType;

public class Hotel {
    private int id;
    private String name;
    private double price;
    private PlaceType type;
    private int rate;

    private double fixedPrice;

    public Hotel(String name, double price, PlaceType type, int rate) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.rate = rate;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public PlaceType getType() {
        return this.type;
    }

    public int getRate() {
        return this.rate;
    }

    public double getFixedPrice() {
        return this.fixedPrice;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

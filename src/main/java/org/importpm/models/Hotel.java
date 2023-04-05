package org.importpm.models;

import org.importpm.models.enums.HotelRate;
import org.importpm.models.enums.HotelType;

public class Hotel {
    private int id;
    private String name;
    private double price;
    private HotelType type;
    private HotelRate rate;

    private double fixedPrice;

    public Hotel(int id, String name, double price, HotelType type, HotelRate rate) {
        this.id = id;
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

    public HotelType getType() {
        return this.type;
    }

    public HotelRate getRate() {
        return this.rate;
    }

    public double getFixedPrice() {
        return this.fixedPrice;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

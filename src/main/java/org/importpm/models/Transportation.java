package org.importpm.models;

import org.importpm.models.enums.TransportationType;

public class Transportation {
    private int id;
    private String name;
    private double price;
    private TransportationType type;
    
    private double fixedPrice;

    public Transportation(String name, double price, TransportationType type, double fixedPrice) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.fixedPrice = fixedPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public TransportationType getType() {
        return type;
    }

    public double getFixedPrice() {
        return fixedPrice;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package org.importpm.models;

import org.importpm.models.enums.TransportationType;

public class Transportation {
    private int id;
    private double price;
    private TransportationType type;

    public Transportation(int id, double price, TransportationType type) {
        this.id = id;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public TransportationType getType() {
        return type;
    }
}

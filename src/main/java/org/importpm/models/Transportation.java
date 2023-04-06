package org.importpm.models;

import org.importpm.models.enums.TransportationType;

public class Transportation {
    private int id;
    private double price;
    private TransportationType type;
    private int amount;

    public Transportation(int id, double price, TransportationType type, int amount) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.amount = amount;
    }

    public Transportation(double price, TransportationType type, int amount) {
        this.price = price;
        this.type = type;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }
}

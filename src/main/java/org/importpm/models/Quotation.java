package org.importpm.models;

import org.importpm.models.enums.QuotationStatus;

public class Quotation {
    private int id;
    private double totalPrice;
    private QuotationStatus quotationStatus;

    public Quotation(double totalPrice, QuotationStatus quotationStatus) {
        this.totalPrice = totalPrice;
        this.quotationStatus = quotationStatus;
    }

    public int getId() {
        return id;
    }

    public QuotationStatus getQuotationStatus() {
        return quotationStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

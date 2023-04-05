package org.importpm.models;

import org.importpm.models.enums.QuotationStatus;

public class Quotation {
    private int id;
    private double realPrice;
    private QuotationStatus quotationStatus;

    public Quotation(int id, double realPrice, QuotationStatus quotationStatus) {
        this.id = id;
        this.realPrice = realPrice;
        this.quotationStatus = quotationStatus;
    }

    public int getId() {
        return id;
    }

    public QuotationStatus getQuotationStatus() {
        return quotationStatus;
    }

    public double getRealPrice() {
        return realPrice;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

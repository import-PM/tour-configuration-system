package org.importpm.models.enums;

import org.importpm.App;

public enum QuotationStatus {
    UNPAID("ยังไม่จ่ายเงิน", 0, App.class.getResource("/images/Accept.png").toString()),
    PAID("จ่ายเงินแล้ว", 1, App.class.getResource("/images/Bus.png").toString()),
    CANCEL("ยกเลิก", 9, App.class.getResource("/images/Car.png").toString());

    private String name;
    private int status;
    private String imagePath;

    QuotationStatus(String name, int status, String imagePath) {
        this.name = name;
        this.status = status;
        this.imagePath = imagePath;
    }

    public static QuotationStatus getQuotationStatus(int status) throws Exception {
        for (QuotationStatus quotationStatus : QuotationStatus.values()) {
            if (quotationStatus.getStatus() == status) {
                return quotationStatus;
            }
        }
        throw new Exception();
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getStatus() {
        return status;
    }
}

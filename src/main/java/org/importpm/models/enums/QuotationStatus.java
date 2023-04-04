package org.importpm.models.enums;

public enum QuotationStatus {
    // TODO: Images needed
    UNPAID("ยังไม่จ่ายเงิน", ""),
    PAID("จ่ายเงินแล้ว", ""),
    CANCEL("ยกเลิก", "");

    private String name;
    private String imagePath;

    QuotationStatus(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}

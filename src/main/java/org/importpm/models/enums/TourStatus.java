package org.importpm.models.enums;

public enum TourStatus {
    PROGRESS("กำลังดำเนิน",0),
    COMPLETE("เสร็จสิ้น",1),
    CANCEL("ยกเลิก",9);

    private String name;
    private int status;

    TourStatus(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public static TourStatus getTourStatus(int status) throws Exception {
        for (TourStatus tourStatus : TourStatus.values()) {
            if (tourStatus.getStatus() == status) {
                return tourStatus;
            }
        }
        throw new Exception();
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }
}

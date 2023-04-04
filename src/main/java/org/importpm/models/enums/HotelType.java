package org.importpm.models.enums;

public enum HotelType {
    // TODO: Images needed
    HOTEL(""),
    ATTRACTION("");

    private String imagePath;

    HotelType(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

}

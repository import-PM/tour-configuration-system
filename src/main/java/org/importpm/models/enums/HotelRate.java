package org.importpm.models.enums;

public enum HotelRate {
    // TODO: Images needed
    Five(5, ""),
    Four(4, ""),
    Three(3, ""),
    Two(2, ""),
    One(1, ""),
    Zero(0, "");

    private int rating;
    private String imagePath;

    HotelRate(int rating, String imagePath) {
        this.rating = rating;
        this.imagePath = imagePath;
    }

    public int getRating() {
        return rating;
    }

    public String getImagePath() {
        return imagePath;
    }

    public static HotelRate getRating(int type) throws Exception {
        for (HotelRate r : HotelRate.values()) {
            if (r.getRating() == type) {
                return r;
            }
        }
        throw new Exception();
    }
}
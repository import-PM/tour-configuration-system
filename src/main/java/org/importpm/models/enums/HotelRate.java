package org.importpm.models.enums;

import org.importpm.App;

public enum HotelRate {
    // TODO: Images needed
    Five(5, App.class.getResource("/images/Hotel - 5.png").toString()),
    Four(4, App.class.getResource("/images/Hotel - 4.png").toString()),
    Three(3, App.class.getResource("/images/Hotel - 3.png").toString()),
    Two(2, App.class.getResource("/images/Hotel - 2.png").toString()),
    One(1, App.class.getResource("/images/Hotel - 1.png").toString()),
    Zero(0, App.class.getResource("/images/Hotel - none.png").toString());

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

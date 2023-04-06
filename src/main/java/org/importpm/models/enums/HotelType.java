package org.importpm.models.enums;

import org.importpm.App;

public enum HotelType {
    // TODO: Images needed
    HOTEL(App.class.getResource("/images/Type_Hotel.png").toString(), 0),
    HOUSE(App.class.getResource("/images/Type_Home.png").toString(), 1);

    private String imagePath;
    private int type;

    HotelType(String imagePath, int type) {
        this.imagePath = imagePath;
        this.type = type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getType() {
        return type;
    }

    public static HotelType getType(int type) throws Exception {
        for (HotelType t : HotelType.values()) {
            if (t.getType() == type) {
                return t;
            }
        }
        throw new Exception();
    }

}

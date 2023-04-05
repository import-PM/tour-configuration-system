package org.importpm.models.enums;

public enum HotelType {
    // TODO: Images needed
    HOTEL("", 0),
    ATTRACTION("", 1);

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

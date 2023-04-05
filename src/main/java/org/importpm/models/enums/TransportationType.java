package org.importpm.models.enums;

public enum TransportationType {

    CAR("",0),
    VAN("",1),
    BUS("",2);

    private String imagePath;
    private int type;

    TransportationType(String imagePath, int type) {
        this.imagePath = imagePath;
        this.type = type;
    }

    public static TransportationType getTransportationType(int type) throws Exception {
        for (TransportationType t : TransportationType.values()) {
            if (t.getType() == type) {
                return t;
            }
        }
        throw new Exception();
    }
    public String getImagePath() {
        return imagePath;
    }

    public int getType() {
        return type;
    }
}

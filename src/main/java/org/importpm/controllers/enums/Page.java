package org.importpm.controllers.enums;

public enum Page {
    //TODO: Review Pages
    PRIMARY("fxml/primary.fxml"),
    SECONDARY("fxml/secondary.fxml"),
    
    BUILD_TOUR("fxml/buildtourpage.fxml"),
    HOTEL("fxml/hotelpage.fxml"),
    TRANSPORT("fxml/transportpage.fxml"),
    TOUR_LIST("fxml/tourlistpage.fxml"),
    TOUR_DETAIL("fxml/tourdetailpage.fxml");

    private final String fxmlPath;

    Page(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    public String getFxmlPath() {
        return fxmlPath;
    }

}

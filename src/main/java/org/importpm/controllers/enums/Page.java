package org.importpm.controllers.enums;

public enum Page {
    //TODO: Review Pages
    PRIMARY("fxml/primary"),
    SECONDARY("fxml/secondary");

    private final String fxmlPath;

    Page(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    public String getFxmlPath() {
        return fxmlPath;
    }

}

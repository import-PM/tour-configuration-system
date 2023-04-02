package org.importpm.controllers;

import java.io.IOException;

import org.importpm.App;
import org.importpm.controllers.enums.Page;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.goTo(Page.SECONDARY.getFxmlPath());
    }
}

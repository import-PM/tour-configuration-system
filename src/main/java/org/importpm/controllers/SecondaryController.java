package org.importpm.controllers;

import java.io.IOException;

import org.importpm.App;
import org.importpm.controllers.enums.Page;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.goTo(Page.PRIMARY);
    }
}
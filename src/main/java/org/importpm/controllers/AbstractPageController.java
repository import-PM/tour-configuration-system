package org.importpm.controllers;

import java.io.IOException;

import org.importpm.App;
import org.importpm.controllers.enums.Page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class AbstractPageController {
    @FXML private Button buildTourButton;
    @FXML private Button hotelButton;
    @FXML private Button transportButton;
    @FXML private Button tourListButton;

    @FXML
    protected void handleBuildtourButton(ActionEvent e) {
        try {
            App.goTo(Page.BUILD_TOUR);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    protected void handleHotelButton(ActionEvent e) {
        try {
            App.goTo(Page.HOTEL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    protected void handleTransportButton(ActionEvent e) {
        try {
            App.goTo(Page.TRANSPORT);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    protected void handleTourListButton(ActionEvent e) {
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    protected void handleExitButton(ActionEvent e) {
        System.exit(0);
    }

}

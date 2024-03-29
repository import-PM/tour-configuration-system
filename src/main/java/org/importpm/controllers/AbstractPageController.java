package org.importpm.controllers;

import java.io.IOException;

import org.importpm.App;
import org.importpm.controllers.enums.Page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class AbstractPageController {
    @FXML protected Button buildTourButton;
    @FXML protected Button hotelButton;
    @FXML protected Button transportButton;
    @FXML protected Button tourListButton;

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
    protected void handleTranspotButton(ActionEvent e) {
        try {
            App.goTo(Page.TRANSPORT);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    protected void handleTourlistButton(ActionEvent e) {
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    protected void handleTourDetailButton(ActionEvent e) {
        try {
            App.goTo(Page.TOUR_DETAIL);
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

package org.importpm.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.importpm.App;
import org.importpm.controllers.enums.Page;
import org.importpm.models.Tour;
import org.importpm.models.Transportation;
import org.importpm.models.enums.TransportationType;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TransportPageController extends AbstractPageController {
    @FXML TextField carTextField;
    @FXML TextField vanTextField;
    @FXML TextField busTextField;

    @FXML
    private void handleSaveButton(ActionEvent e) {
        Tour tour = App.getSelectedTour();
        List<Transportation> transportations = new ArrayList<>();
        
        if (carTextField.getText() != "" && Integer.parseInt(carTextField.getText()) > 0) {
            transportations.add(new Transportation(1,2500, TransportationType.CAR, Integer.parseInt(carTextField.getText())));
        }
        if (vanTextField.getText() != "" && Integer.parseInt(vanTextField.getText()) > 0) {
            transportations.add(new Transportation(2,5000, TransportationType.VAN, Integer.parseInt(vanTextField.getText())));
        }
        if (busTextField.getText() != "" && Integer.parseInt(busTextField.getText()) > 0) {
            transportations.add(new Transportation(3,10000, TransportationType.BUS, Integer.parseInt(busTextField.getText())));
        }

        if (transportations.size() > 0) {
            tour.setHotel(App.getSelectedHotel());
            tour.setTransportations(transportations);

            try {
                App.goTo(Page.TOUR_DETAIL);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    @FXML
    private void handleCancelButton(ActionEvent e) {
        try {
            App.goTo(Page.HOTEL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}

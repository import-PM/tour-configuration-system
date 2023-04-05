package org.importpm.controllers;

import java.io.IOException;
import java.time.LocalDate;

import org.importpm.App;
import org.importpm.models.Hotel;
import org.importpm.models.Quotation;
import org.importpm.models.Tour;
import org.importpm.models.Transportation;
import org.importpm.models.enums.HotelRate;
import org.importpm.models.enums.HotelType;
import org.importpm.models.enums.QuotationStatus;
import org.importpm.models.enums.TourStatus;
import org.importpm.models.enums.TransportationType;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TourDetailPageController extends AbstractPageController {
    
    @FXML protected Label nameLabel;
    @FXML protected Label emailLabel;
    @FXML protected Label telLabel;
    @FXML protected Label detailLabel;
    @FXML protected Label locationLabel;
    @FXML protected Label customerLabel;
    @FXML protected Label budgetLabel;
    @FXML protected ImageView typeimageview;
    @FXML protected Label namehotellabel;
    @FXML protected ImageView ratingimageview;
    @FXML protected Label priceLabel;

    protected Tour tour;
    
    public TourDetailPageController() {
        
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                tour = App.getSelectedTour();
                tour = new Tour(0, "null", "null", "null", TourStatus.PAID, 0, 0, 0, 0, "null", LocalDate.now(), LocalDate.now());
                tour.addTransportation(new Transportation(1, TransportationType.BUS, 2));
                tour.setHotel(new Hotel(0, "null", 0, HotelType.HOTEL, HotelRate.Five));
                initialize();
            }
            
        });
    }

    protected void initialize() {
        setValues();
    }

    protected void setValues() {
        nameLabel.setText(tour.getContactName());
        emailLabel.setText(tour.getContactEmail());
        telLabel.setText(tour.getContactPhone());

        detailLabel.setText(tour.getDescription());
        locationLabel.setText(tour.getProvince().getName());
        customerLabel.setText(String.valueOf(tour.getTouristTotal()));
        typeimageview.setImage(new Image(tour.getHotel().getType().getImagePath()));
        namehotellabel.setText(tour.getHotel().getName());
        ratingimageview.setImage(new Image(tour.getHotel().getRate().getImagePath()));
        priceLabel.setText(String.valueOf(tour.getHotel().getPrice()));

    }

    @FXML
    protected void handleBackPageButton(ActionEvent e) {
        try {
            App.goTo(App.getPreviousPage());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleSaveButton(ActionEvent e) {
        
    }

}

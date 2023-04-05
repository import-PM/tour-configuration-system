package org.importpm.controllers;

import java.io.IOException;

import org.importpm.App;
import org.importpm.models.Quotation;
import org.importpm.models.Tour;
import org.importpm.models.enums.QuotationStatus;

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
        tour = App.getSelectedTour();
        initialize();
    }

    protected void initialize() {
        setValues();
    }

    protected void setValues() {
        // TODO: More Information Needed
        nameLabel.setText(null);
        emailLabel.setText(null);
        telLabel.setText(null);

        detailLabel.setText(tour.getDescription());
        locationLabel.setText(tour.getProvince());
        customerLabel.setText(String.valueOf(tour.getTouristAmount()));
        budgetLabel.setText(String.valueOf(tour.getBudget()));
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
        // TODO: More Information Needed about totalPrice
        Quotation quotation = new Quotation(null, QuotationStatus.UNPAID);
    }

}

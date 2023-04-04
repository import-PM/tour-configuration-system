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
    
    @FXML private Label nameLabel;
    @FXML private Label emailLabel;
    @FXML private Label telLabel;
    @FXML private Label detailLabel;
    @FXML private Label locationLabel;
    @FXML private Label customerLabel;
    @FXML private Label budgetLabel;
    @FXML private ImageView typeimageview;
    @FXML private Label namehotellabel;
    @FXML private ImageView ratingimageview;
    @FXML private Label priceLabel;

    private Tour tour;
    
    public TourDetailPageController() {
        tour = App.getSelectedTour();
        initialize();
    }

    private void initialize() {
        setValues();
    }

    private void setValues() {
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
    private void handleBackPageButton(ActionEvent e) {
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

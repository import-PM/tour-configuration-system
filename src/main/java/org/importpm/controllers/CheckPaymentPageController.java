package org.importpm.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CheckPaymentPageController extends TourDetailPageController {
    @FXML private ImageView starImage;
    @FXML private Label paymentStatusLabel;

    public CheckPaymentPageController() {
        super();
        this.initialize();
    }

    protected void initialize() {
        starImage.setImage(new Image(tour.getQuotation().getQuotationStatus().getImagePath()));
        paymentStatusLabel.setText(tour.getQuotation().getQuotationStatus().getName());
    }

}

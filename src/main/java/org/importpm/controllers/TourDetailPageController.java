package org.importpm.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.importpm.App;
import org.importpm.controllers.enums.Page;
import org.importpm.models.Hotel;
import org.importpm.models.Quotation;
import org.importpm.models.Tour;
import org.importpm.models.Transportation;
import org.importpm.models.enums.HotelRate;
import org.importpm.models.enums.HotelType;
import org.importpm.models.enums.TourStatus;
import org.importpm.models.enums.TransportationType;
import org.importpm.services.DBConnect;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TourDetailPageController extends AbstractPageController {
    
    @FXML protected Label headerlabel;

    @FXML protected Label startDateLabel;
    @FXML protected Label endDateLabel;

    @FXML protected Label nameLabel;
    @FXML protected Label emailLabel;
    @FXML protected Label telLabel;
    @FXML protected Label detailLabel;
    @FXML protected Label locationLabel;
    @FXML protected Label customerLabel;
    @FXML protected Label budgetLabel;
    @FXML protected Label namehotellabel;
    @FXML protected ImageView ratingimageview;
    @FXML protected Label pricelabel;

    @FXML protected Label totalLabel;

    @FXML protected Label amountLabel;
    @FXML protected Label pricelabel1;
    @FXML protected Label amountLabel1;
    @FXML protected Label pricelabel11;
    @FXML protected Label amountLabel11;
    @FXML protected Label pricelabel111;
    protected Tour tour;

    @FXML protected Button savebutton;

    @FXML protected Label acceptOrDenyLabel;

    public TourDetailPageController() {
        
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                tour = App.getSelectedTour();
                initialize();
            }
            
        });
    }

    protected void initialize() {
        amountLabel.setText("0");
        pricelabel1.setText("0");
        amountLabel1.setText("0");
        pricelabel11.setText("0");
        amountLabel11.setText("0");
        pricelabel111.setText("0");

        if (tour.getStatus().name().equals(TourStatus.PROGRESS.name())) {
            savebutton.setVisible(true);
        } else if (tour.getStatus().name().equals(TourStatus.PAID.name())) {
            savebutton.setVisible(false);
        } else if (tour.getStatus().name().equals(TourStatus.CANCEL.name())) {
            savebutton.setVisible(false);
        }

        setValues();
    }

    protected void setValues() {
        double total = tour.getHotel().getPrice() * Math.ceil(tour.getTouristTotal()/2.0);

        startDateLabel.setText(tour.getStartDate().toString());
        endDateLabel.setText(tour.getEndDate().toString());

        nameLabel.setText(tour.getContactName());
        emailLabel.setText(tour.getContactEmail());
        telLabel.setText(tour.getContactPhone());

        headerlabel.setText(String.valueOf(tour.getId()));

        detailLabel.setText(tour.getDescription());
        locationLabel.setText(tour.getProvince().getName());
        customerLabel.setText(String.valueOf(tour.getTouristTotal()));
        namehotellabel.setText(tour.getHotel().getName());
        // ratingimageview.setImage(new Image(tour.getHotel().getRate().getImagePath()));
        pricelabel.setText(String.format("%.2f", tour.getHotel().getPrice()));

        List<Transportation> transportations = tour.getTransportations();
        for (Transportation transportation : transportations) {
            if (transportation.getType().equals(TransportationType.CAR)) {
                amountLabel.setText(String.valueOf(transportation.getAmount()));
                pricelabel1.setText(String.format("%.2f",transportation.getPrice() * transportation.getAmount()));
                total += transportation.getAmount() * transportation.getPrice();
            }
            if (transportation.getType().equals(TransportationType.VAN)) {
                amountLabel1.setText(String.valueOf(transportation.getAmount()));
                pricelabel11.setText(String.format("%.2f",transportation.getPrice() * transportation.getAmount()));
                total += transportation.getAmount() * transportation.getPrice();
            }
            if (transportation.getType().equals(TransportationType.BUS)) {
                amountLabel11.setText(String.valueOf(transportation.getAmount()));
                pricelabel111.setText(String.format("%.2f",transportation.getPrice() * transportation.getAmount()));
                total += transportation.getAmount() * transportation.getPrice();
            }
        }

        acceptOrDenyLabel.setText((tour.getInsuranceStatus() == 1) ? "รับประกันอุบัติเหตุ" : "ไม่รับประกัน");

        if (tour.getInsuranceStatus() == 1) {
            total += 1000 * tour.getTouristTotal();
        }

        totalLabel.setText(String.format("%.2f",total));
        Quotation quotation = new Quotation(total);
        DBConnect.insertQuotation(quotation);
        tour.setQuotation(DBConnect.getQuotationLastId());

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
        DBConnect.insertTour(tour);
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}

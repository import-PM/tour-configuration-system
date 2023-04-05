package org.importpm.controllers;

import java.io.IOException;

import org.importpm.App;
import org.importpm.models.enums.TourStatus;
import org.importpm.services.DBConnect;
import org.importpm.models.Tour;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class BuildTourPageController extends AbstractPageController {
    
    @FXML private MenuButton nameTitleMenuButton;
    @FXML private TextField nameTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField phoneNumberTextField;
    @FXML private TextArea detailTextArea;
    @FXML private TextField locationTextField;
    @FXML private TextField customerTextField;
    @FXML private TextField budgetTextField;
    @FXML private RadioButton acceptRadioButton;
    @FXML private RadioButton denyRadioButton;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker endDatePicker;

    public BuildTourPageController() {
        initialize();
    }

    private void initialize() {
        setValue();
    }

    private void setValue() {
        nameTitleMenuButton.getItems().add(new MenuItem("นาย"));
        nameTitleMenuButton.getItems().add(new MenuItem("นาง"));
        nameTitleMenuButton.getItems().add(new MenuItem("นางสาว"));
    }

    @FXML private void handleCancelButton(ActionEvent e) {
        try {
            App.goTo(App.getPreviousPage());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML private void handleSaveButton(ActionEvent e) {
        Tour tour = new Tour(detailTextArea.getText(), locationTextField.getText(), TourStatus.PROGRESS, Integer.parseInt(customerTextField.getText()), Double.parseDouble(budgetTextField.getText()), startDatePicker.getValue(), endDatePicker.getValue());
        
        try {
            DBConnect.insertTour(tour);
        } catch(Exception ex) {
            new Alert(AlertType.ERROR, ex.getMessage()).show();
        }
        
    }

}

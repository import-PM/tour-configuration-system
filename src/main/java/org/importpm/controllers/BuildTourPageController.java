package org.importpm.controllers;

import java.io.IOException;
import java.util.List;

import org.importpm.App;
import org.importpm.controllers.enums.Page;
import org.importpm.models.enums.TourStatus;
import org.importpm.services.DBConnect;
import org.importpm.models.Province;
import org.importpm.models.Tour;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
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
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                initialize();
            }
            
        });
    }

    private void initialize() {
        nameTitleMenuButton = new MenuButton();

        setValue();
    }

    private void setValue() {
        // nameTitleMenuButton.getItems().addAll("นาย", "นาง", "นางสาว");
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
        int isAcceptInsurance = 1;
        if (denyRadioButton.isSelected()) isAcceptInsurance = 0;

        try {
            Province province = DBConnect.getProvinceByName(locationTextField.getText());
            Tour tour = new Tour(nameTextField.getText(), phoneNumberTextField.getText(), emailTextField.getText(), Integer.parseInt(customerTextField.getText()), isAcceptInsurance, Double.parseDouble(budgetTextField.getText()), detailTextArea.getText(), province, startDatePicker.getValue(), endDatePicker.getValue());
            App.setSelectedTour(tour);
            App.setPreviousPage(Page.BUILD_TOUR);
            App.goTo(Page.HOTEL);
        } catch (Exception e1) {
            new Alert(AlertType.ERROR, "Something went wrong! Please try again.").show();
        }

    }

    // @FXML
    // private void handleChangeThemeDefault(ActionEvent actionEvent){
    //     try {
    //         FXRouter.setPath("default.css");
    //         App.goTo("homepage");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // @FXML
    // private void handleChangeThemeDark(ActionEvent actionEvent){
    //     try {
    //         FXRouter.setPath("dark.css");
    //         App.goTo("index");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    // @FXML
    // private void handleChangeThemeBlueSky(ActionEvent actionEvent){
    //     try {
    //         App.setPath("bluesky.css");
    //         App.goTo("homepage");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // @FXML
    // private void handleChangeThemeHotPink(ActionEvent actionEvent){
    //     try {
    //         FXRouter.setPath("hotpink.css");
    //         App.goTo("homepage");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

}

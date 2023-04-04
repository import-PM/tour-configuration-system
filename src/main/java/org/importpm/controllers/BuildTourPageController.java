package org.importpm.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    }

    @FXML private void handleSaveButton(ActionEvent e) {

    }

}

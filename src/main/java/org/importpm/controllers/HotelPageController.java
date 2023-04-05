package org.importpm.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.importpm.App;
import org.importpm.controllers.enums.Page;
import org.importpm.models.Hotel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class HotelPageController extends AbstractPageController {
    @FXML private ComboBox<String> typeComboBox;
    @FXML private ComboBox<String> nameComboBox;
    @FXML private ComboBox<String> ratingComboBox;
    @FXML private ComboBox<String> priceComboBox;
    @FXML private Label searchButtonLabel;

    @FXML private Button firstPageButton;
    @FXML private Button previousPageButton;
    @FXML private Label pageNumberLabel;
    @FXML private Button nextPageButton;
    @FXML private Button lastPageButton;

    @FXML private Pane listPane1;
    @FXML private Pane listPane2;
    @FXML private Pane listPane3;
    @FXML private Pane listPane4;
    @FXML private Pane listPane5;
    @FXML private Pane listPane6;
    @FXML private Pane listPane7;

    @FXML private ImageView typeImageView1;
    @FXML private ImageView typeImageView2;
    @FXML private ImageView typeImageView3;
    @FXML private ImageView typeImageView4;
    @FXML private ImageView typeImageView5;
    @FXML private ImageView typeImageView6;
    @FXML private ImageView typeImageView7;

    @FXML private Label nameLabel1;
    @FXML private Label nameLabel2;
    @FXML private Label nameLabel3;
    @FXML private Label nameLabel4;
    @FXML private Label nameLabel5;
    @FXML private Label nameLabel6;
    @FXML private Label nameLabel7;

    @FXML private ImageView ratingImageView1;
    @FXML private ImageView ratingImageView2;
    @FXML private ImageView ratingImageView3;
    @FXML private ImageView ratingImageView4;
    @FXML private ImageView ratingImageView5;
    @FXML private ImageView ratingImageView6;
    @FXML private ImageView ratingImageView7;

    @FXML private Label priceLabel1;
    @FXML private Label priceLabel2;
    @FXML private Label priceLabel3;
    @FXML private Label priceLabel4;
    @FXML private Label priceLabel5;
    @FXML private Label priceLabel6;
    @FXML private Label priceLabel7;

    @FXML private Button selectButton1;
    @FXML private Button selectButton2;
    @FXML private Button selectButton3;
    @FXML private Button selectButton4;
    @FXML private Button selectButton5;
    @FXML private Button selectButton6;
    @FXML private Button selectButton7;

    private List<Hotel> hotels;
    private List<Hotel> selectedHotels;

    private List<Pane> panes;
    private List<ImageView> typeImageViews;
    private List<Label> names;
    private List<ImageView> ratingImageViews;
    private List<Label> prices;

    private int currentPage;

    public HotelPageController() {
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                panes = new ArrayList<>();
                panes.add(listPane1);
                panes.add(listPane2);
                panes.add(listPane3);
                panes.add(listPane4);
                panes.add(listPane5);
                panes.add(listPane6);
                panes.add(listPane7);

                typeImageViews = new ArrayList<>();
                typeImageViews.add(typeImageView1);
                typeImageViews.add(typeImageView2);
                typeImageViews.add(typeImageView3);
                typeImageViews.add(typeImageView4);
                typeImageViews.add(typeImageView5);
                typeImageViews.add(typeImageView6);
                typeImageViews.add(typeImageView7);

                names = new ArrayList<>();
                names.add(nameLabel1);
                names.add(nameLabel2);
                names.add(nameLabel3);
                names.add(nameLabel4);
                names.add(nameLabel5);
                names.add(nameLabel6);
                names.add(nameLabel7);

                ratingImageViews = new ArrayList<>();
                ratingImageViews.add(ratingImageView1);
                ratingImageViews.add(ratingImageView2);
                ratingImageViews.add(ratingImageView3);
                ratingImageViews.add(ratingImageView4);
                ratingImageViews.add(ratingImageView5);
                ratingImageViews.add(ratingImageView6);
                ratingImageViews.add(ratingImageView7);

                prices = new ArrayList<>();
                prices.add(priceLabel1);
                prices.add(priceLabel2);
                prices.add(priceLabel3);
                prices.add(priceLabel4);
                prices.add(priceLabel5);
                prices.add(priceLabel6);
                prices.add(priceLabel7);

                hotels = new ArrayList<>();
                // hotels = Database.selectAllHotels();
                currentPage = 1;
            
                initialize();
            }
            
        });
    }

    private void initialize() {
        setValue();
    }

    private void setValue() {
        setPage();
    }

    private void setPage() {
        pageNumberLabel.setText(String.valueOf(currentPage));

        selectedHotels = new ArrayList<>();
        for (int i = ((currentPage - 1) * 7) ; i < currentPage * 7 ; ++i) {
            if (hotels.size() <= i) {
                panes.get(i%7).setVisible(false);
            } else {
                panes.get(i%7).setVisible(true);
                selectedHotels.add(hotels.get(i));
            }
        }

        if (currentPage > 1) {
            firstPageButton.setDisable(false);
            previousPageButton.setDisable(false);
        } else {
            firstPageButton.setDisable(true);
            previousPageButton.setDisable(true);
        }

        if (hotels.size() > currentPage * 7) {
            nextPageButton.setDisable(false);
            lastPageButton.setDisable(false);
        } else {
            nextPageButton.setDisable(true);
            lastPageButton.setDisable(true);
        }

        for (int i = 0 ; i < selectedHotels.size(); ++i) {
            typeImageViews.get(i).setImage(new Image(selectedHotels.get(i).getType().getImagePath()));
            names.get(i).setText(selectedHotels.get(i).getName());
            ratingImageViews.get(i).setImage(new Image(selectedHotels.get(i).getRate().getImagePath()));
            prices.get(i).setText(String.valueOf(selectedHotels.get(i).getPrice()));
        }

    }

    @FXML
    private void handleFirstPageButton(ActionEvent e) {
        currentPage = 1; setPage();
    }

    @FXML
    private void handlePreviousPageButton(ActionEvent e) {
        if (currentPage > 1) {
            currentPage--; setPage();
        }
    }

    @FXML
    private void handleNextPageButton(ActionEvent e) {
        currentPage++; setPage();
    }

    @FXML
    private void handleLastPageButton(ActionEvent e) {
        currentPage = (int)Math.ceil(hotels.size()/7); setPage();
    }

    @FXML
    private void handleselectbutton1(ActionEvent e) {
        App.setSelectedHotel(selectedHotels.get(0));
        try {
            App.goTo(Page.TRANSPORT);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleselectbutton2(ActionEvent e) {
        App.setSelectedHotel(selectedHotels.get(1));
        try {
            App.goTo(Page.TRANSPORT);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleselectbutton3(ActionEvent e) {
        App.setSelectedHotel(selectedHotels.get(2));
        try {
            App.goTo(Page.TRANSPORT);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleselectbutton4(ActionEvent e) {
        App.setSelectedHotel(selectedHotels.get(3));
        try {
            App.goTo(Page.TRANSPORT);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleselectbutton5(ActionEvent e) {
        App.setSelectedHotel(selectedHotels.get(4));
        try {
            App.goTo(Page.TRANSPORT);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleselectbutton6(ActionEvent e) {
        App.setSelectedHotel(selectedHotels.get(5));
        try {
            App.goTo(Page.TRANSPORT);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleselectbutton7(ActionEvent e) {
        App.setSelectedHotel(selectedHotels.get(6));
        try {
            App.goTo(Page.TRANSPORT);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClickSearchButton(MouseEvent e) {
        // TODO
    }

    @FXML
    private void handleCancelButton(ActionEvent e) {
        
    }

    @FXML
    private void handleSaveButton(ActionEvent e) {
        
    }

}

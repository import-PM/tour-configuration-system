package org.importpm.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.importpm.App;
import org.importpm.controllers.enums.Page;
import org.importpm.models.Tour;
import org.importpm.models.Transportation;
import org.importpm.models.enums.TourStatus;
import org.importpm.services.DBConnect;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TourListPageController extends AbstractPageController {
    
    @FXML private Label name0Label1;
    @FXML private Label name0Label11;
    @FXML private Label name0Label12;
    @FXML private Label name0Label13;
    @FXML private Label name0Label14;
    @FXML private Label name0Label15;
    @FXML private Label name0Label16;
    @FXML private Label name0Label17;
    @FXML private Label name0Label18;
    @FXML private Label name0Label19;

    @FXML private Label name0Label;
    @FXML private Label name1Label;
    @FXML private Label name2Label;
    @FXML private Label name3Label;
    @FXML private Label name4Label;
    @FXML private Label name5Label;
    @FXML private Label name6Label;
    @FXML private Label name7Label;
    @FXML private Label name8Label;
    @FXML private Label name9Label;

    @FXML private Label telephoneNumber0Label;
    @FXML private Label telephoneNumber1Label;
    @FXML private Label telephoneNumber2Label;
    @FXML private Label telephoneNumber3Label;
    @FXML private Label telephoneNumber4Label;
    @FXML private Label telephoneNumber5Label;
    @FXML private Label telephoneNumber6Label;
    @FXML private Label telephoneNumber7Label;
    @FXML private Label telephoneNumber8Label;
    @FXML private Label telephoneNumber9Label;

    @FXML private Label status0Label;
    @FXML private Label status1Label;
    @FXML private Label status2Label;
    @FXML private Label status3Label;
    @FXML private Label status4Label;
    @FXML private Label status5Label;
    @FXML private Label status6Label;
    @FXML private Label status7Label;
    @FXML private Label status8Label;
    @FXML private Label status9Label;

    @FXML private Button acceptButton0;
    @FXML private Button acceptButton1;
    @FXML private Button acceptButton2;
    @FXML private Button acceptButton3;
    @FXML private Button acceptButton4;
    @FXML private Button acceptButton5;
    @FXML private Button acceptButton6;
    @FXML private Button acceptButton7;
    @FXML private Button acceptButton8;
    @FXML private Button acceptButton9;
    
    @FXML private Button acceptButton01;
    @FXML private Button acceptButton11;
    @FXML private Button acceptButton21;
    @FXML private Button acceptButton31;
    @FXML private Button acceptButton41;
    @FXML private Button acceptButton51;
    @FXML private Button acceptButton61;
    @FXML private Button acceptButton71;
    @FXML private Button acceptButton81;
    @FXML private Button acceptButton91;

    @FXML private Pane tourListItem0Pane;
    @FXML private Pane tourListItem1Pane;
    @FXML private Pane tourListItem2Pane;
    @FXML private Pane tourListItem3Pane;
    @FXML private Pane tourListItem4Pane;
    @FXML private Pane tourListItem5Pane;
    @FXML private Pane tourListItem6Pane;
    @FXML private Pane tourListItem7Pane;
    @FXML private Pane tourListItem8Pane;
    @FXML private Pane tourListItem9Pane;
    
    private List<Pane> panes;
    private List<Label> ids;
    private List<Label> names;
    private List<Label> telephones;
    private List<Label> statuses;
    private List<Button> acceptButtons;
    private List<Button> denyButtons;

    private List<Tour> tours;
    private List<Tour> selectedTours;

    private int currentPage;

    @FXML private Label pageNumberLabel;
    @FXML private Button firstPageButton;
    @FXML private Button previousPageButton;
    @FXML private Button nextPageButton;
    @FXML private Button lastPageButton;

    public TourListPageController() {
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                panes = new ArrayList<>();
                panes.add(tourListItem0Pane);
                panes.add(tourListItem1Pane);
                panes.add(tourListItem2Pane);
                panes.add(tourListItem3Pane);
                panes.add(tourListItem4Pane);
                panes.add(tourListItem5Pane);
                panes.add(tourListItem6Pane);
                panes.add(tourListItem7Pane);
                panes.add(tourListItem8Pane);
                panes.add(tourListItem9Pane);

                ids = new ArrayList<>();
                ids.add(name0Label1);
                ids.add(name0Label11);
                ids.add(name0Label12);
                ids.add(name0Label13);
                ids.add(name0Label14);
                ids.add(name0Label15);
                ids.add(name0Label16);
                ids.add(name0Label17);
                ids.add(name0Label18);
                ids.add(name0Label19);

                names = new ArrayList<>();
                names.add(name0Label);
                names.add(name1Label);
                names.add(name2Label);
                names.add(name3Label);
                names.add(name4Label);
                names.add(name5Label);
                names.add(name6Label);
                names.add(name7Label);
                names.add(name8Label);
                names.add(name9Label);

                telephones = new ArrayList<>();
                telephones.add(telephoneNumber0Label);
                telephones.add(telephoneNumber1Label);
                telephones.add(telephoneNumber2Label);
                telephones.add(telephoneNumber3Label);
                telephones.add(telephoneNumber4Label);
                telephones.add(telephoneNumber5Label);
                telephones.add(telephoneNumber6Label);
                telephones.add(telephoneNumber7Label);
                telephones.add(telephoneNumber8Label);
                telephones.add(telephoneNumber9Label);

                statuses = new ArrayList<>();
                statuses.add(status0Label);
                statuses.add(status1Label);
                statuses.add(status2Label);
                statuses.add(status3Label);
                statuses.add(status4Label);
                statuses.add(status5Label);
                statuses.add(status6Label);
                statuses.add(status7Label);
                statuses.add(status8Label);
                statuses.add(status9Label);

                acceptButtons = new ArrayList<>();
                acceptButtons.add(acceptButton0);
                acceptButtons.add(acceptButton0);
                acceptButtons.add(acceptButton0);
                acceptButtons.add(acceptButton0);
                acceptButtons.add(acceptButton0);
                acceptButtons.add(acceptButton0);
                acceptButtons.add(acceptButton0);
                acceptButtons.add(acceptButton0);
                acceptButtons.add(acceptButton0);
                acceptButtons.add(acceptButton0);

                denyButtons = new ArrayList<>();
                denyButtons.add(acceptButton01);
                denyButtons.add(acceptButton11);
                denyButtons.add(acceptButton21);
                denyButtons.add(acceptButton31);
                denyButtons.add(acceptButton41);
                denyButtons.add(acceptButton51);
                denyButtons.add(acceptButton61);
                denyButtons.add(acceptButton71);
                denyButtons.add(acceptButton81);
                denyButtons.add(acceptButton91);

                tours = DBConnect.getTours();

                currentPage = 1;

                initialize();
            }

        });
    }

    private void initialize() {
        setPage();
    }

    private void setPage() {
        pageNumberLabel.setText(String.valueOf(currentPage));

        selectedTours = new ArrayList<>();
        for (int i = ((currentPage - 1) * 10) ; i < currentPage * 10 ; ++i) {
            if (tours.size() <= i) {
                panes.get(i%10).setVisible(false);
            } else {
                panes.get(i%10).setVisible(true);
                selectedTours.add(tours.get(i));
            }
        }

        if (currentPage > 1) {
            firstPageButton.setDisable(false);
            previousPageButton.setDisable(false);
        } else {
            firstPageButton.setDisable(true);
            previousPageButton.setDisable(true);
        }

        if (tours.size() > currentPage * 10) {
            nextPageButton.setDisable(false);
            lastPageButton.setDisable(false);
        } else {
            nextPageButton.setDisable(true);
            lastPageButton.setDisable(true);
        }

        for (int i = 0 ; i < selectedTours.size(); ++i) {
            ids.get(i).setText(String.valueOf(selectedTours.get(i).getId()));
            names.get(i).setText(selectedTours.get(i).getContactName());
            telephones.get(i).setText(selectedTours.get(i).getContactPhone());
            statuses.get(i).setText(selectedTours.get(i).getStatus().getName());
        }

    }
    
    @FXML
    private void handleCancelButton(ActionEvent e) {

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
        currentPage = (int)Math.ceil(tours.size()/7); setPage();
    }

    @FXML
    private void handleCancelButton0(ActionEvent e) {
        selectedTours.get(0).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(0));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButton1(ActionEvent e) {
        selectedTours.get(1).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(1));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButton2(ActionEvent e) {
        selectedTours.get(2).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(2));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButton3(ActionEvent e) {
        selectedTours.get(3).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(3));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButton4(ActionEvent e) {
        selectedTours.get(4).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(4));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButton5(ActionEvent e) {
        selectedTours.get(5).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(5));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButton6(ActionEvent e) {
        selectedTours.get(6).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(6));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButton7(ActionEvent e) {
        selectedTours.get(7).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(7));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButton8(ActionEvent e) {
        selectedTours.get(8).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(8));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleCancelButton9(ActionEvent e) {
        selectedTours.get(9).setStatus(TourStatus.CANCEL);
        DBConnect.updateTourStatus(selectedTours.get(9));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton0(ActionEvent e) {
        selectedTours.get(0).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(0));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton1(ActionEvent e) {
        selectedTours.get(1).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(1));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton2(ActionEvent e) {
        selectedTours.get(2).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(2));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton3(ActionEvent e) {
        selectedTours.get(3).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(3));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton4(ActionEvent e) {
        selectedTours.get(4).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(4));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton5(ActionEvent e) {
        selectedTours.get(5).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(5));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton6(ActionEvent e) {
        selectedTours.get(6).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(6));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton7(ActionEvent e) {
        selectedTours.get(7).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(7));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton8(ActionEvent e) {
        selectedTours.get(8).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(8));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleAcceptButton9(ActionEvent e) {
        selectedTours.get(9).setStatus(TourStatus.PAID);
        DBConnect.updateTourStatus(selectedTours.get(9));
        try {
            App.goTo(Page.TOUR_LIST);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick0(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(0));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick1(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(1));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick2(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(2));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick3(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(3));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick4(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(4));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick5(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(5));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick6(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(6));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick7(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(7));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick8(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(8));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleClick9(MouseEvent e) {
        App.setSelectedTour(selectedTours.get(9));
        try {
            App.goTo(Page.TOUR_DETAIL);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


}

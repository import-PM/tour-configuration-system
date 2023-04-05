package org.importpm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import org.importpm.controllers.enums.Page;
import org.importpm.models.Hotel;
import org.importpm.models.Tour;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Page previousPage;
    private static Hotel selectedHotel;
    private static Tour selectedTour;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(Page.HOTEL.getFxmlPath()), 1366, 768);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void goTo(Page page) throws IOException {
        scene.setRoot(loadFXML(page.getFxmlPath()));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void setPreviousPage(Page page) {
        previousPage = page;
    }

    public static Page getPreviousPage() {
        return previousPage;
    }

    public static Hotel getSelectedHotel() {
        return selectedHotel;
    }

    public static void setSelectedTour(Tour selectedTour) {
        App.selectedTour = selectedTour;
    }

    public static Tour getSelectedTour() {
        return selectedTour;
    }

    public static void setSelectedHotel(Hotel selectedHotel) {
        App.selectedHotel = selectedHotel;
    }

    public static void main(String[] args) {
        launch();
    }

}

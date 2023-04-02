package org.importpm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import org.importpm.controllers.enums.Page;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(Page.PRIMARY.getFxmlPath()), 1366, 768);
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

    public static void main(String[] args) {
        launch();
    }

}
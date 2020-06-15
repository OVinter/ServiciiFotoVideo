package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.Group;

import org.example.services.UserService;
import java.io.IOException;


/**
 * JavaFX App
 */
public class Main extends Application {

    public static String wlcmName;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        UserService.loadUsersFromFile();

        scene = new Scene(loadFXML("lgnbf"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
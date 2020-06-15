package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.example.exceptions.UsernameAlreadyExistsException;
import org.example.model.User;
import org.example.services.FileSystemService;
import org.example.services.UserService;
import javafx.fxml.FXMLLoader;

import org.example.Main;

import javafx.event.ActionEvent;



public class ThirdController extends Main {


    public TextField userText;
    public PasswordField passText;
    public Text LoginMsg;
    public ChoiceBox role;


    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Fotograf");
    }

    @FXML
    private void goFereastraFotograf() throws IOException {
        String nume_utilizator = userText.getText();
        String parola = passText.getText();

        wlcmName = nume_utilizator;


        if (nume_utilizator == null || nume_utilizator.isEmpty() || parola == null || parola.isEmpty()) {
            LoginMsg.setText("Username and password are required!");
        }
        else {
            if(Objects.equals(UserService.check(nume_utilizator, parola), "Fotograf")) {
                actionGoFereastraFotograf();
            }
            else {
                if(Objects.equals(UserService.check(nume_utilizator, parola), "Client")) {
                    actionGoFereastraClient();
            }
            else {
                LoginMsg.setText("Incorrect credentials");
            }
        }

        }

    }

    @FXML
    private void actionGoFereastraFotograf() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fotograf1st.fxml"));
            Parent root = loader.load();

            FourthController fourthController = loader.getController();
            fourthController.myFunction(userText.getText());

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            //stage.setTitle("Nou");
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void actionGoFereastraClient() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FereastraClient.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            //stage.setTitle("Nou");
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void backHome() throws IOException {
        Main.setRoot("lgnbf");
    }
}

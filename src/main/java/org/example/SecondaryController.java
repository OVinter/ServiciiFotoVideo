package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import org.example.exceptions.UsernameAlreadyExistsException;
import org.example.services.UserService;

public class SecondaryController {

    public TextField userText;
    public PasswordField passText;
    public Text LoginMsg;
    public ChoiceBox role;

    /*@FXML
    private void switchToPrimary() throws IOException {
        Main.setRoot("lgnbf");
    }*/


    @FXML
    public void initialize() {
        role.getItems().addAll("Client");
    }

    @FXML
    public void handleRegisterAction() {
        String nume_utilizator = userText.getText();
        String parola = passText.getText();
        if (nume_utilizator == null || nume_utilizator.isEmpty() || parola == null || parola.isEmpty()) {
            LoginMsg.setText("Username and password are required!");
        } else {
            try {
                UserService.addUser(userText.getText(), passText.getText(), (String) role.getValue());
                LoginMsg.setText("Account created successfully!");
            } catch (UsernameAlreadyExistsException e) {
                LoginMsg.setText(e.getMessage());
            }
        }
    }

    @FXML
    private void backHome() throws IOException {
        Main.setRoot("lgnbf");
    }
}
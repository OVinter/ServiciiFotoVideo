package org.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

    public Button btnButton;

    @FXML
    private void switchToSecondary() throws IOException {
            Main.setRoot("login");
    }

    @FXML
    private void switchToSecondary2() throws IOException {
        Main.setRoot("register");
    }

}

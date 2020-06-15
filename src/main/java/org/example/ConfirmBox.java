package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmBox {

    static boolean answer = false;
    @FXML
    private Button okButton = new Button();
    @FXML
    private Button noButton = new Button();
    @FXML
    private Label label = new Label();

    @FXML
    private void setOkButton() {
        answer = true;
        isAnswer();
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void setNoButton() {
        answer = false;
        isAnswer();
        Stage stage = (Stage) noButton.getScene().getWindow();
        stage.close();
    }

    public void setText(String s) {
        label.setWrapText(true);
        label.setText(s);
    }

    public boolean isAnswer() {
        return answer;
    }
}
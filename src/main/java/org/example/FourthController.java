package org.example;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.stage.Stage;
import org.example.Main;
import org.example.services.UserService;

public class FourthController extends Main {

    public Text firstwlmnume;
    public Button butonout;

    public void myFunction(String text) {
        firstwlmnume.setText(text);
    }


    @FXML
    private void backLog() {

        Stage stage = (Stage)butonout.getScene().getWindow();
        stage.close();
    }


}


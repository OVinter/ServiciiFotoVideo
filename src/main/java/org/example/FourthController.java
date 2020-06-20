package org.example;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.stage.Stage;
import org.example.Main;
import org.example.services.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FourthController extends Main {

    public Text firstwlmnume;
    public Button butonout;
    public TextArea agenda;
    public Button batan;

    public void myFunction(String text) {
        firstwlmnume.setText(text);
    }


    @FXML
    private void backLog() {

        Stage stage = (Stage)butonout.getScene().getWindow();
        stage.close();
    }

    /*public void showAgenda() {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("agenda.json"))
        {
            Object obj = jsonParser.parse(reader);


            JSONArray programari = (JSONArray) obj;
            agenda.setText(programari.toString());

            //programs = programari.toString();

            //Iterate over employee array
            //programari.forEach( emp -> parseProgramariObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }*/


}


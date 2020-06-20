package org.example;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
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


    public void showAgenda() {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("agenda.json"))
        {
            Object obj = jsonParser.parse(reader);


            JSONArray programari_agenda = (JSONArray) obj;

            //Iterate over employee array
            agenda.setWrapText(true);
            programari_agenda.forEach( emp -> agenda.appendText(parseProgramariAgendaObject( (JSONObject) emp ) ));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static String parseProgramariAgendaObject(JSONObject programari) {
        String nume = (String) programari.get("Nume client");
        String data = (String) programari.get("Data programare");
        String detalii = (String) programari.get("Servicii");

        return "Client: " + nume + "\n" + "Data progarmare: " + data + "\n" + "Detalii: " + detalii + "\n \n";
    }


}


package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;
import org.omg.CORBA.INITIALIZE;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class FereastraClient implements Initializable {

    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> PromoFotoVideo = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> nrFotografi = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> nrVideografi = new ChoiceBox<>();

    @FXML
    private void getDate() {
        datePicker.setConverter(new StringConverter<LocalDate>() {
            String pattern = "dd/MM/yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            {
                datePicker.setPromptText(pattern.toLowerCase());
            }

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        System.out.println(datePicker.getValue());
    }

    @FXML
    public void addDataInChoiceBox() {
        PromoFotoVideo.getItems().add("Promo");
        PromoFotoVideo.getItems().add("Foto");
        PromoFotoVideo.getItems().add("Video");
        nrFotografi.getItems().add(1);
        nrFotografi.getItems().add(2);
        nrVideografi.getItems().add(1);
        nrVideografi.getItems().add(2);
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addDataInChoiceBox();
    }
}

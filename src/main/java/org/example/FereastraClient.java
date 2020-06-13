package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class FereastraClient {

    private String tipServiciProgramare;
    private String tipServiciFotoProgramare;
    private String tipServiciVideoProgramare;
    private int nrFotografiProgramare;
    private int nrVideografiProgramare;
    private int nrTinuteProduseMinuteProgramare;
    private boolean studioProgramare = false;
    private boolean albumFotoProgramare = false;
    private int nrSecundeFilmareProgramare;
    private int nrPublicNrFaniProgramare;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ChoiceBox<String> PromoFotoVideo = new ChoiceBox<>();
    @FXML
    private Button PromoFotoVideoButton = new Button();
    @FXML
    private ChoiceBox<Integer> nrFotografi = new ChoiceBox<>();
    @FXML
    private Button nrFotografiVideografiButton = new Button();
    @FXML
    private ChoiceBox<Integer> nrVideografi = new ChoiceBox<>();
    private LocalDate data;
    @FXML
    private TextField nrTinuteProduseMinute = new TextField();
    @FXML
    private Button nrTinuteProduseMinuteButton = new Button();
    @FXML
    private TextField nrSecundeFilmare = new TextField();
    @FXML
    private Button nrSecundeFilmareButton = new Button();
    @FXML
    private TextField nrPublicNrFani = new TextField();
    @FXML
    private Button nrPublicNrFaniButton = new Button();
    @FXML
    private ChoiceBox<String> tipSedintaFoto = new ChoiceBox<>();
    @FXML
    private Button tipSedintaFotoButton = new Button();
    @FXML
    private ChoiceBox<String> tipFilmareVideo = new ChoiceBox<>();
    @FXML
    private Button tipFilmareVideoButton = new Button();
    @FXML
    private CheckBox studio = new CheckBox();
    @FXML
    private CheckBox albumFoto = new CheckBox();
    @FXML
    private Button serviciNou = new Button();
    @FXML
    private Button dorescOferta = new Button();



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
        data = datePicker.getValue();
        datePicker.setDisable(true);
    }

    @FXML
    public void addDataInChoiceBox() {
        PromoFotoVideo.getItems().clear();
        nrFotografi.getItems().clear();
        nrVideografi.getItems().clear();
        tipSedintaFoto.getItems().clear();
        tipFilmareVideo.getItems().clear();

        PromoFotoVideo.getItems().addAll(
                "Promo",
                "Foto",
                "Video"
        );
        nrFotografi.getItems().addAll(1, 2);
        nrVideografi.getItems().addAll(1, 2);
        tipSedintaFoto.getItems().addAll(
                "Sedinta foto simpla",
                "Sedinta foto cuplu",
                "Sedinta foto familie",
                "Sedinta foto produse"
        );
        tipFilmareVideo.getItems().addAll(
                "Video highlights",
                "Video advertising",
                "Video muzical"
        );

        PromoFotoVideo.setValue("Promo");
        nrFotografi.setValue(1);
        nrVideografi.setValue(1);
        tipSedintaFoto.setValue("Sedinta foto simpla");
        tipFilmareVideo.setValue("Video highlights");
        nrTinuteProduseMinute.setPromptText("Nr Tinute/Produse/Minute");
    }

    @FXML
    private <T> void getStringChoice(ChoiceBox<T> choiceBox) {
        T optiune = choiceBox.getValue();
        System.out.println(optiune);
    }

    @FXML
    private void actionForPromoFotoVideo() {
        getStringChoice(PromoFotoVideo);
        tipServiciProgramare = PromoFotoVideo.getValue();
        if(tipServiciProgramare.equals("Promo")) {
            PromoFotoVideo.setDisable(true);
            PromoFotoVideoButton.setDisable(true);
            nrFotografi.setDisable(false);
            nrFotografiVideografiButton.setDisable(false);
            nrVideografi.setDisable(false);
        }else if(tipServiciProgramare.equals("Foto")) {
            PromoFotoVideo.setDisable(true);
            PromoFotoVideoButton.setDisable(true);
            tipSedintaFoto.setDisable(false);
            tipSedintaFotoButton.setDisable(false);
            albumFoto.setDisable(false);
            studio.setDisable(false);
            nrTinuteProduseMinute.setDisable(false);
            nrTinuteProduseMinuteButton.setDisable(false);
        }else {
            PromoFotoVideo.setDisable(true);
            PromoFotoVideoButton.setDisable(true);
            tipFilmareVideo.setDisable(false);
            tipFilmareVideoButton.setDisable(false);
            nrSecundeFilmare.setDisable(false);
            nrSecundeFilmareButton.setDisable(false);
            nrPublicNrFani.setDisable(false);
            nrPublicNrFaniButton.setDisable(false);
        }
    }

    @FXML
    private void actionForFotografiVideografiButton() {
        getStringChoice(nrFotografi);
        getStringChoice(nrVideografi);
        nrFotografiProgramare = nrFotografi.getValue();
        nrVideografiProgramare = nrVideografi.getValue();
    }

    @FXML
    private void actionForTipSedintaFotoButton() {
        getStringChoice(tipSedintaFoto);
        tipServiciFotoProgramare = tipSedintaFoto.getValue();
        if(tipServiciFotoProgramare.equals("Sedinta foto simpla")) {
            nrTinuteProduseMinute.setPromptText("Minute");
            nrTinuteProduseMinute.setDisable(false);
            nrTinuteProduseMinuteButton.setDisable(false);
        }
        if(tipServiciFotoProgramare.equals("Sedinta foto cuplu")) {
            nrTinuteProduseMinute.setPromptText("90 min");
            nrTinuteProduseMinute.setDisable(true);
            nrTinuteProduseMinuteButton.setDisable(true);
        }
        if(tipServiciFotoProgramare.equals("Sedinta foto familie")) {
            nrTinuteProduseMinute.setPromptText("Tinute");
            nrTinuteProduseMinute.setDisable(false);
            nrTinuteProduseMinuteButton.setDisable(false);
        }
        if(tipServiciFotoProgramare.equals("Sedinta foto produse")) {
            nrTinuteProduseMinute.setPromptText("Produse");
            nrTinuteProduseMinute.setDisable(false);
            nrTinuteProduseMinuteButton.setDisable(false);
        }

    }

    @FXML
    private void actionForTipFilmareVideoButton() {
        getStringChoice(tipFilmareVideo);
        tipServiciVideoProgramare = tipFilmareVideo.getValue();
        if(tipServiciVideoProgramare.equals("Video highlights")) {
            nrPublicNrFani.setPromptText("TargetPublic/NumarFani");
            nrPublicNrFani.setDisable(true);
            nrPublicNrFaniButton.setDisable(true);
        }
        if(tipServiciVideoProgramare.equals("Video advertising")) {
            nrPublicNrFani.setPromptText("Numar public target");
            nrPublicNrFani.setDisable(false);
            nrPublicNrFaniButton.setDisable(false);
        }
        if(tipServiciVideoProgramare.equals("Video muzical")) {
            nrPublicNrFani.setPromptText("Numar fani");
            nrPublicNrFani.setDisable(false);
            nrPublicNrFaniButton.setDisable(false);
        }
    }

    @FXML
    private void actionForNrTinuteProduseMinuteButton() {
        nrTinuteProduseMinuteProgramare = Integer.parseInt(nrTinuteProduseMinute.getText());
        System.out.println(nrTinuteProduseMinuteProgramare);
    }

    @FXML
    private void actionForNrSecundeFilmareButton() {
        nrSecundeFilmareProgramare = Integer.parseInt(nrSecundeFilmare.getText());
        System.out.println(nrSecundeFilmareProgramare);
    }

    @FXML
    private void actionForNrPublicNrFaniButton() {
        nrPublicNrFaniProgramare = Integer.parseInt(nrPublicNrFani.getText());
        System.out.println(nrPublicNrFaniProgramare);
    }

    @FXML
    private void actionForStudioCheckBox() {
        if(studio.isSelected())
            studioProgramare = true;
        else
            studioProgramare = false;
        System.out.println(studioProgramare);
    }

    @FXML
    private void actionForAlbumFotoCheckBox() {
        if(albumFoto.isSelected())
            albumFotoProgramare = true;
        else
            albumFotoProgramare = false;
        System.out.println(albumFotoProgramare);
    }

    @FXML
    private void serviciNouButton() {
        initialize();
    }

    private AnchorPane anchorPane;

    @FXML
    private void actionForDorescOfertaButton() {
        /*if(tipServiciProgramare.equals("Promo")) {
            System.out.println(tipServiciFotoProgramare);
            //new Promo(,,,,);
        }else if(tipServiciFotoProgramare.equals("Sedinta foto simpla")) {
            System.out.println(tipServiciFotoProgramare);
            //new SedintaFotoSimpla(,,,,);
        }else if(tipServiciFotoProgramare.equals("Sedinta foto familie")) {
            System.out.println(tipServiciFotoProgramare);
            //new SedintaFotoFamilie(,,,,);
        }else if(tipServiciFotoProgramare.equals("Sedinta foto cuplu")) {
            System.out.println(tipServiciFotoProgramare);
            //new SedintaFotoCuplu(,,,,);
        }else if(tipServiciFotoProgramare.equals("Sedinta foto produse")) {
            System.out.println(tipServiciFotoProgramare);
            //new SedintaFotoProdus(,,,,);
        }else if(tipServiciVideoProgramare.equals("Video highlights")) {
            System.out.println(tipServiciVideoProgramare);
            //new videoHighlights(,,,,);
        }else if(tipServiciVideoProgramare.equals("Video muzical")) {
            System.out.println(tipServiciVideoProgramare);
            //new videoMuzical(,,,,);
        }else if(tipServiciVideoProgramare.equals("Video advertising")) {
            System.out.println(tipServiciVideoProgramare);
            //new videoAdvertising(,,,,);
        }*/
    }

    @FXML
    public void initialize() {
        addDataInChoiceBox();
        datePicker.setDisable(false);
        PromoFotoVideo.setDisable(false);
        PromoFotoVideoButton.setDisable(false);
        nrFotografi.setDisable(true);
        nrVideografi.setDisable(true);
        nrFotografiVideografiButton.setDisable(true);
        tipSedintaFoto.setDisable(true);
        tipSedintaFotoButton.setDisable(true);
        nrTinuteProduseMinute.setDisable(true);
        nrTinuteProduseMinuteButton.setDisable(true);
        studio.setDisable(true);
        albumFoto.setDisable(true);
        nrSecundeFilmare.setDisable(true);
        nrSecundeFilmareButton.setDisable(true);
        tipFilmareVideo.setDisable(true);
        tipFilmareVideoButton.setDisable(true);
        nrPublicNrFani.setDisable(true);
        nrPublicNrFaniButton.setDisable(true);
    }

}

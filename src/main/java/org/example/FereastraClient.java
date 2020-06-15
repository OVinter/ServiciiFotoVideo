package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import servicii.Servicii;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private String dataProgramare;
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
    private Button helpButton = new Button();

    @FXML
    private void getDate() {
        LocalDate data = datePicker.getValue();
        String dataProgramare = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(dataProgramare);
        datePicker.setDisable(true);
    }

    @FXML
    public void addDataInChoiceBox() {
        PromoFotoVideo.getItems().clear();
        nrFotografi.getItems().clear();
        nrVideografi.getItems().clear();
        tipSedintaFoto.getItems().clear();
        tipFilmareVideo.getItems().clear();
        datePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0 );
            }
        });

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
        if(nrTinuteProduseMinute.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Campul nu este completat");
            alert.setContentText("Campul trebuie sa fie completat inainte de a apasa butonul \"OK\".\n" +
                            "Te rugam sa completezi campul!");
            alert.showAndWait();
        } else {
            nrTinuteProduseMinuteProgramare = Integer.parseInt(nrTinuteProduseMinute.getText());
            System.out.println(nrTinuteProduseMinuteProgramare);
        }
    }

    @FXML
    private void actionForNrSecundeFilmareButton() {
        if(nrSecundeFilmare.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Campul nu este completat");
            alert.setContentText("Campul trebuie sa fie completat inainte de a apasa butonul \"OK\".\n" +
                    "Te rugam sa completezi campul!");
            alert.showAndWait();
        } else {
            nrSecundeFilmareProgramare = Integer.parseInt(nrSecundeFilmare.getText());
            System.out.println(nrSecundeFilmareProgramare);
        }
    }

    @FXML
    private void actionForNrPublicNrFaniButton() {
        if(nrPublicNrFani.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Campul nu este completat");
            alert.setContentText("Campul trebuie sa fie completat inainte de a apasa butonul \"OK\".\n" +
                    "Te rugam sa completezi campul!");
            alert.showAndWait();
        } else {
            nrPublicNrFaniProgramare = Integer.parseInt(nrPublicNrFani.getText());
            System.out.println(nrPublicNrFaniProgramare);
        }
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

    @FXML
    private void actionForHelpButton() {
        /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help window");
        alert.setHeaderText("Salvarea optiunilor");
        alert.setContentText("Pentru a salva optiunile foloseste butonul \"OK\" din dreapta fiecarui camp!\n" +
                "Pentru campurile \"Numar fotografi\" si \"Numar videografi\" exista un singur buton!");
        alert.showAndWait();*/
    }

    private Servicii checkServicii() {
        if(tipServiciProgramare.equals("Promo")) {
            System.out.println(tipServiciProgramare);
            //return new PachetPromo(",,,,");
        }else if(tipServiciFotoProgramare.equals("Sedinta foto simpla")) {
            System.out.println(tipServiciFotoProgramare);
            //new SedintaFotoSimpla(,,,,);
        }else if(tipServiciFotoProgramare.equals("Sedinta foto familie")) {
            System.out.println(tipServiciFotoProgramare);
            //new SedintaFotoFamilie(,,,,);
        }else if(tipServiciFotoProgramare.equals("Sedinta foto cuplu")) {
            System.out.println(tipServiciFotoProgramare);
            //new SedintaFotoCuplu(,,,,,);
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
        }
        return null;
    }

    @FXML
    private void actionForDorescOfertaButton() {
        Servicii s = checkServicii();
        boolean confirm = false;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfirmBox.fxml"));
            Parent root = loader.load();

            //The following both lines are the only addition we need to pass the arguments
            ConfirmBox confirmBox = loader.getController();
            confirmBox.setText("aaa");//s.informatiiServici());

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("-- Confirmare servici dorit --");
            stage.showAndWait();
            confirm = confirmBox.isAnswer();
            System.out.println(confirm);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
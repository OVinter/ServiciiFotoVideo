package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servicii.Servicii;
import servicii.foto.SedintaFotoCuplu;
import servicii.foto.SedintaFotoFamilie;
import servicii.foto.SedintaFotoProdus;
import servicii.foto.SedintaFotoSimpla;
import servicii.promo.PachetPromo;
import servicii.video.VideoAdvertising;

import org.json.simple.parser.JSONParser;
import servicii.video.VideoHighlights;
import servicii.video.VideoMuzical;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class FereastraClient extends Main {

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
    private static String dataProgramare;
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

    JSONObject serviciiObject = new JSONObject();

    private static void ReadFromAgenda (String d) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("agenda.json"))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray programari = (JSONArray) obj;
            System.out.println(programari);

            programari.forEach( emp -> parseProgramariObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    private static void parseProgramariObject(JSONObject programari) {
        String data = (String) programari.get("Data programare");
        System.out.println(data);
        if(data.equals(dataProgramare)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Aceasta data este rezervata!");
            alert.setContentText("Aceasta data este rezervata in agenda fotografului. Te rugam alege alta data!");
            alert.showAndWait();
        }
    }

    @FXML
    private void getDate() {
        LocalDate data = datePicker.getValue();
        dataProgramare = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        ReadFromAgenda(dataProgramare);

        datePicker.setDisable(false);
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
        albumFoto.setSelected(false);
        studio.setSelected(false);
        albumFotoProgramare = false;
        studioProgramare = false;
        nrSecundeFilmare.setPromptText("Numar secunde filmare");
        nrPublicNrFani.setPromptText("TargetPublic/NumarFani");
    }

    @FXML
    private <T> void getStringChoice(ChoiceBox<T> choiceBox) {
        T optiune = choiceBox.getValue();
        //System.out.println(optiune);
        //sir = sir + optiune + "\n";
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
        }
    }

    @FXML
    private void actionForStudioCheckBox() {
        if(studio.isSelected())
            studioProgramare = true;
        else
            studioProgramare = false;
    }

    @FXML
    private void actionForAlbumFotoCheckBox() {
        if(albumFoto.isSelected())
            albumFotoProgramare = true;
        else
            albumFotoProgramare = false;
    }

    @FXML
    private void serviciNouButton() {
        initialize();
    }

    @FXML
    private void actionForHelpButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help window");
        alert.setHeaderText("Salvarea optiunilor");
        alert.setContentText("Pentru a salva optiunile foloseste butonul \"OK\" din dreapta fiecarui camp!\n" +
                "Pentru campurile \"Numar fotografi\" si \"Numar videografi\" exista un singur buton!");
        alert.showAndWait();
    }

    private Servicii checkServicii() {
        if(tipServiciProgramare.equals("Promo")) {
            return new PachetPromo(userNume, dataProgramare, nrFotografiProgramare, nrVideografiProgramare);
        } else if (tipServiciProgramare.equals("Foto")) {
            if (tipServiciFotoProgramare.equals("Sedinta foto simpla")) {
                return new SedintaFotoSimpla(userNume, dataProgramare, studioProgramare, albumFotoProgramare, nrTinuteProduseMinuteProgramare);
            } else if (tipServiciFotoProgramare.equals("Sedinta foto familie")) {
                return new SedintaFotoFamilie(userNume, dataProgramare, studioProgramare, albumFotoProgramare, nrTinuteProduseMinuteProgramare);
            } else if (tipServiciFotoProgramare.equals("Sedinta foto cuplu")) {
                return new SedintaFotoCuplu(userNume, dataProgramare, studioProgramare, albumFotoProgramare);
            } else if (tipServiciFotoProgramare.equals("Sedinta foto produse")) {
                return new SedintaFotoProdus(userNume, dataProgramare, studioProgramare, albumFotoProgramare, nrTinuteProduseMinuteProgramare);
            }
        } else if(tipServiciProgramare.equals("Video")) {
            if (tipServiciVideoProgramare.equals("Video highlights")) {
                return new VideoHighlights(userNume, dataProgramare, nrSecundeFilmareProgramare);
            } else if (tipServiciVideoProgramare.equals("Video muzical")) {
                return new VideoMuzical(userNume, dataProgramare, nrSecundeFilmareProgramare, nrPublicNrFaniProgramare);
            } else if (tipServiciVideoProgramare.equals("Video advertising")) {
                return new VideoAdvertising(userNume, dataProgramare, nrSecundeFilmareProgramare, nrPublicNrFaniProgramare);
            }
        }
        return null;
    }

    @FXML
    private void actionForDorescOfertaButton() {
        JSONParser parser = new JSONParser();
        JSONArray array = new JSONArray();
        try {
            FileReader file = new FileReader("agenda.json");
            JSONArray json =  (JSONArray) parser.parse(file);
            array = (JSONArray) json;

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        serviciiObject.put("Nume client", userNume);
        serviciiObject.put("Data programare", dataProgramare);
        Servicii s = checkServicii();
        serviciiObject.put("Servicii", s.informatiiServici());
        array.add(serviciiObject);
        boolean confirm = false;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfirmBox.fxml"));
            Parent root = loader.load();
            ConfirmBox confirmBox = loader.getController();
            confirmBox.setText(s.informatiiServici());

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("-- Confirmare servici dorit --");
            stage.showAndWait();
            confirm = confirmBox.isAnswer();
            System.out.println(confirm);
            if(confirm == true) {
                try {
                    FileWriter file = new FileWriter("agenda.json");
                    file.write(array.toJSONString());
                    file.flush();
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

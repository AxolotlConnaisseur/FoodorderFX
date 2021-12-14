package com.example.foodorderfx.gui;

import com.example.foodorderfx.SpeiseplanApp;
import com.example.foodorderfx.pdf.FranziReport;
import com.example.foodorderfx.used.Gericht;
import com.example.foodorderfx.used.Speiseplan;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.ArrayList;


public class SpeiseplanController implements Serializable {
    static final long serialVersionUID = 1L;
    @FXML
    Spinner<Integer> kwSpinner;
    @FXML
    Label lblKW;
    @FXML
    GridPane gridPane;
    @FXML
    Button btErstellen;
    @FXML
    Button btCancel;
    @FXML
    Label lblTag1;
    @FXML
    Label lblTag2;
    @FXML
    Label lblTag3;
    @FXML
    Label lblTag4;
    @FXML
    Label lblTag5;
    @FXML
    Label lblNameA1;
    @FXML
    Label lblNameA2;
    @FXML
    Label lblNameA3;
    @FXML
    Label lblNameA4;
    @FXML
    Label lblNameA5;
    @FXML
    Label lblNameB1;
    @FXML
    Label lblNameB2;
    @FXML
    Label lblNameB3;
    @FXML
    Label lblNameB4;
    @FXML
    Label lblNameB5;
    @FXML
    ImageView imgViewA1;
    @FXML
    ImageView imgViewA2;
    @FXML
    ImageView imgViewA3;
    @FXML
    ImageView imgViewA4;
    @FXML
    ImageView imgViewA5;
    @FXML
    ImageView imgViewB1;
    @FXML
    ImageView imgViewB2;
    @FXML
    ImageView imgViewB3;
    @FXML
    ImageView imgViewB4;
    @FXML
    ImageView imgViewB5;
    @FXML
    Label preisA1;
    @FXML
    Label preisA2;
    @FXML
    Label preisA3;
    @FXML
    Label preisA4;
    @FXML
    Label preisA5;
    @FXML
    Label preisB1;
    @FXML
    Label preisB2;
    @FXML
    Label preisB3;
    @FXML
    Label preisB4;
    @FXML
    Label preisB5;
    @FXML
    Label lblHeadline;
    @FXML
    Button pdfErstellen;
    @FXML
    public static Gericht gerichtTransfer;
    public static LocalDate[] gewaehlteWoche = new LocalDate[5];

    ArrayList<Gericht> dialogData;

    static ClickedControls relevantControls;

    public static ArrayList<Gericht> showDialog(ArrayList<Gericht> gerichte) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(SpeiseplanApp.class.getResource("speiseplan.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        SpeiseplanController controller = fxmlLoader.getController();
        controller.initializeFields(gerichte);

        stage.setTitle("Speiseplan");
        stage.setScene(scene);
        SpeiseplanApp.skizzeStage = stage;
        stage.showAndWait();

        return gerichte;
    }

    private void initializeFields(ArrayList<Gericht> gerichte) {

        this.dialogData = gerichte;

        lblNameA1.setText(gerichte.get(0).gerichtName);
        preisA1.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(0).gerichtPreis));
        imgViewA1.setImage(gerichte.get(0).gerichtImg);

        lblNameB1.setText(gerichte.get(1).gerichtName);
        preisB1.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(1).gerichtPreis));
        imgViewB1.setImage(gerichte.get(1).gerichtImg);

        lblNameA2.setText(gerichte.get(2).gerichtName);
        preisA2.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(2).gerichtPreis));
        imgViewA2.setImage(gerichte.get(2).gerichtImg);

        lblNameB2.setText(gerichte.get(3).gerichtName);
        preisB2.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(3).gerichtPreis));
        imgViewB2.setImage(gerichte.get(3).gerichtImg);

        lblNameA3.setText(gerichte.get(4).gerichtName);
        preisA3.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(4).gerichtPreis));
        imgViewA3.setImage(gerichte.get(4).gerichtImg);

        lblNameB3.setText(gerichte.get(5).gerichtName);
        preisB3.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(5).gerichtPreis));
        imgViewB3.setImage(gerichte.get(5).gerichtImg);

        lblNameA4.setText(gerichte.get(6).gerichtName);
        preisA4.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(6).gerichtPreis));
        imgViewA4.setImage(gerichte.get(6).gerichtImg);

        lblNameB4.setText(gerichte.get(7).gerichtName);
        preisB4.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(7).gerichtPreis));
        imgViewB4.setImage(gerichte.get(7).gerichtImg);

        lblNameA5.setText(gerichte.get(8).gerichtName);
        preisA5.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(8).gerichtPreis));
        imgViewA5.setImage(gerichte.get(8).gerichtImg);

        lblNameB5.setText(gerichte.get(9).gerichtName);
        preisB5.setText(SpeiseBearbeitenController.formatPreis(gerichte.get(9).gerichtPreis));
        imgViewB5.setImage(gerichte.get(9).gerichtImg);

    }


    @FXML
    public void initialize() {
        relevantControls = new ClickedControls(this);
        setKwSpinner();
        datumAnpassen(null);
    }

    @FXML
    public void erstellePDF(ActionEvent event) {
        Speiseplan speiseplan = new Speiseplan();
        speiseplan.setKw(kwSpinner.getValue());
        for (int i = 0; i < 10; i++) {
            speiseplan.addGericht(i,
                    new Gericht(relevantControls.nameLabels.get(i).getText(),
                    relevantControls.imageViews.get(i).getImage(),
                    SpeiseBearbeitenController.calculatePreis(relevantControls.preisLabels.get(i).getText())));
        }

        FranziReport f = new FranziReport(speiseplan);
        for (int i = 0; i < 5; i++) {
            FranziReport.gerichteA[i] = speiseplan.gerichte[i];
        }
        for (int i = 0; i < 5; i++) {
            FranziReport.gerichteB[i] = speiseplan.gerichte[i + 5];
        }
        f.druckeSpeiseplan();
        f.druckePdfSpeiseplan();

    }

    @FXML
    public void openEditDialogue(MouseEvent event) throws IOException {

        if (event.getClickCount() == 2) {

            Node source = (Node) event.getSource();
            relevantControls.calculateIndex(source);

            Gericht aktuellesGericht = new Gericht(relevantControls.getLblName().getText(),
                    relevantControls.getImageView().getImage(),
                    SpeiseBearbeitenController.calculatePreis( relevantControls.getLblPreis().getText()));

            Gericht updatedGericht = showDialog(aktuellesGericht);

            relevantControls.getLblName().setText(updatedGericht.gerichtName);
            relevantControls.getLblPreis().setText(SpeiseBearbeitenController.formatPreis(updatedGericht.gerichtPreis));
            relevantControls.getImageView().setImage(updatedGericht.gerichtImg);

        }

    }



    private Gericht showDialog(Gericht gericht) throws IOException {

        Stage hauptfenster = (Stage) lblTag1.getScene().getWindow();
        Stage stage = new Stage();

        SpeiseplanController.gerichtTransfer = gericht;

        FXMLLoader fxmlLoader = new FXMLLoader(SpeiseplanApp.class.getResource("speiseBearbeiten.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Speiseplan bearbeiten");

        stage.setScene(new Scene(root));
        stage.initOwner(hauptfenster);
        stage.initModality(Modality.WINDOW_MODAL);

        stage.showAndWait();

        return SpeiseplanController.gerichtTransfer;
    }


    private void setKwSpinner() {
        kwSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 53, 1));
    }

    @FXML
    private void datumAnpassen(Event e) {
        try {
            LocalDate localDate = LocalDate.now();
            int wunschKW = kwSpinner.getValue();
            int currentKW = localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
            while (wunschKW != currentKW) {

                if (currentKW > wunschKW) {

                    localDate = localDate.minusDays(7);
                    currentKW = localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);

                } else if (currentKW < wunschKW) {

                    localDate = localDate.plusDays(7);
                    currentKW = localDate.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
                }


            }
            LocalDate angepassterMontag = getDateMonday(localDate);
            ArrayList<LocalDate> woche = createArrayListWeek(angepassterMontag);
            ArrayList<Label> tageLblReihe = tageReihe();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM");
            for (LocalDate tag : woche) {
                tageLblReihe.get(woche.indexOf(tag)).setText(tag.format(dtf));
                gewaehlteWoche[woche.indexOf(tag)] = tag;
            }

        } catch (NumberFormatException ignored) {

        }
    }

    private ArrayList<LocalDate> createArrayListWeek(LocalDate lDateMonday) {
        ArrayList<LocalDate> woche = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            woche.add(i, lDateMonday.plusDays(i));
        }
        return woche;
    }

    private LocalDate getDateMonday(LocalDate lDateMonday) {

        if (lDateMonday.getDayOfWeek() != DayOfWeek.MONDAY) {
            while (lDateMonday.getDayOfWeek() != DayOfWeek.MONDAY) {
                lDateMonday = lDateMonday.minusDays(1);
            }
        }
        return lDateMonday;
    }

    @FXML
    public void handleButtonCancel() {
        Scene scene = btCancel.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    public ArrayList<Label> tageReihe() {
        ArrayList<Label> wocheLabel = new ArrayList<>();
        wocheLabel.add(lblTag1);
        wocheLabel.add(lblTag2);
        wocheLabel.add(lblTag3);
        wocheLabel.add(lblTag4);
        wocheLabel.add(lblTag5);
        return wocheLabel;
    }

    @FXML
    private void handleButtonErstellen(ActionEvent e) {

        String montagMenuA1Gericht = lblNameA1.getText();
        String montagMenuB1Gericht = lblNameB1.getText();

        String montagMenuA2Gericht = lblNameA2.getText();
        String montagMenuB2Gericht = lblNameB2.getText();

        String montagMenuA3Gericht = lblNameA3.getText();
        String montagMenuB3Gericht = lblNameB3.getText();

        String montagMenuA4Gericht = lblNameA4.getText();
        String montagMenuB4Gericht = lblNameB4.getText();

        String montagMenuA5Gericht = lblNameA5.getText();
        String montagMenuB5Gericht = lblNameB5.getText();

        this.dialogData.get(0).setGerichtName(montagMenuA1Gericht);
        this.dialogData.get(1).setGerichtName(montagMenuB1Gericht);

        this.dialogData.get(2).setGerichtName(montagMenuA2Gericht);
        this.dialogData.get(3).setGerichtName(montagMenuB2Gericht);

        this.dialogData.get(4).setGerichtName(montagMenuA3Gericht);
        this.dialogData.get(5).setGerichtName(montagMenuB3Gericht);

        this.dialogData.get(6).setGerichtName(montagMenuA4Gericht);
        this.dialogData.get(7).setGerichtName(montagMenuB4Gericht);

        this.dialogData.get(8).setGerichtName(montagMenuA5Gericht);
        this.dialogData.get(9).setGerichtName(montagMenuB5Gericht);

        closeStage(e);


    }

    static void closeStage(ActionEvent e) {
        ((Stage) ((Button) e.getSource()).getScene().getWindow()).close();
    }


}

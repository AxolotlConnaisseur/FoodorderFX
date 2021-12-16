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

import java.io.*;
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
    public static String path = "C:\\Users\\Franzi\\FoodorderFX\\src\\main\\java\\com\\example\\foodorderfx\\pdf\\speiseplan.dat";

    ArrayList<Gericht> dialogData;
    Speiseplan speiseplanData;

    static ClickedControls relevantControls;

    //Evtl Speiseplan Objekt zurückgeben statt ArrayList Gerichte
    public static Speiseplan showDialog(Speiseplan speiseplan) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(SpeiseplanApp.class.getResource("speiseplan.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        SpeiseplanController controller = fxmlLoader.getController();
        controller.initializeFields(speiseplan);


        for (Gericht gericht : controller.dialogData) {
            speiseplan.setGerichtInArray(controller.dialogData.indexOf(gericht), gericht);
        }

        stage.setTitle("Speiseplan");
        stage.setScene(scene);
        SpeiseplanApp.skizzeStage = stage;
        stage.showAndWait();

        controller.aktualisiereSpeiseplanDialog();

        for (Gericht gericht : controller.dialogData) {
            speiseplan.setGerichtInArray(controller.dialogData.indexOf(gericht), gericht);
        }


        return speiseplan;
    }

    private void initializeFields(Speiseplan speiseplan) {

        ArrayList<Gericht> gerichte = new ArrayList<>();
        for (Gericht gericht : speiseplan.gerichte) {
            gerichte.add(gericht);
        }

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

    public static void serializeObject(Speiseplan speiseplan, String path) {

        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try {
            //temp_dir = Files.createTempDirectory("franziSpeiseplan");
            fos = new FileOutputStream(path);
            out = new ObjectOutputStream(fos);
            out.writeObject(speiseplan);
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Speiseplan deSerializeObject(String path) {

        Speiseplan speiseplan = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(path);
            in = new ObjectInputStream(fis);
            speiseplan = (Speiseplan) in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return speiseplan;
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
            speiseplan.setGerichtInArray(i,
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
                    SpeiseBearbeitenController.calculatePreis(relevantControls.getLblPreis().getText()));

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
    public void handleButtonCancel(ActionEvent e) {
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

        aktualisiereSpeiseplanDialog();

        closeStage(e);


    }

    private void aktualisiereSpeiseplanDialog() {
        String gerichtA1Name = lblNameA1.getText();
        String gerichtB1Name = lblNameB1.getText();

        String gerichtA2Name = lblNameA2.getText();
        String gerichtB2Name = lblNameB2.getText();

        String gerichtA3Name = lblNameA3.getText();
        String gerichtB3Name = lblNameB3.getText();

        String gerichtA4Name = lblNameA4.getText();
        String gerichtB4Name = lblNameB4.getText();

        String gerichtA5Name = lblNameA5.getText();
        String gerichtB5Name = lblNameB5.getText();

        String gerichtA1Preis = SpeiseBearbeitenController.normalizePreis(preisA1.getText());
        String gerichtB1Preis = SpeiseBearbeitenController.normalizePreis(preisB1.getText());

        String gerichtA2Preis = SpeiseBearbeitenController.normalizePreis(preisA2.getText());
        String gerichtB2Preis = SpeiseBearbeitenController.normalizePreis(preisB2.getText());

        String gerichtA3Preis = SpeiseBearbeitenController.normalizePreis(preisA3.getText());
        String gerichtB3Preis = SpeiseBearbeitenController.normalizePreis(preisB3.getText());

        String gerichtA4Preis = SpeiseBearbeitenController.normalizePreis(preisA4.getText());
        String gerichtB4Preis = SpeiseBearbeitenController.normalizePreis(preisB4.getText());

        String gerichtA5Preis = SpeiseBearbeitenController.normalizePreis(preisA5.getText());
        String gerichtB5Preis = SpeiseBearbeitenController.normalizePreis(preisB5.getText());

        this.dialogData.get(0).setGerichtName(gerichtA1Name);
        this.dialogData.get(0).setGerichtPreis(Double.parseDouble(gerichtA1Preis));
        this.dialogData.get(0).setGerichtImg(imgViewA1.getImage());

        this.dialogData.get(1).setGerichtName(gerichtB1Name);
        this.dialogData.get(1).setGerichtPreis(Double.parseDouble(gerichtB1Preis));
        this.dialogData.get(1).setGerichtImg(imgViewB1.getImage());

        this.dialogData.get(2).setGerichtName(gerichtA2Name);
        this.dialogData.get(2).setGerichtPreis(Double.parseDouble(gerichtA2Preis));
        this.dialogData.get(2).setGerichtImg(imgViewA2.getImage());

        this.dialogData.get(3).setGerichtName(gerichtB2Name);
        this.dialogData.get(3).setGerichtPreis(Double.parseDouble(gerichtB2Preis));
        this.dialogData.get(3).setGerichtImg(imgViewB2.getImage());

        this.dialogData.get(4).setGerichtName(gerichtA3Name);
        this.dialogData.get(4).setGerichtPreis(Double.parseDouble(gerichtA3Preis));
        this.dialogData.get(4).setGerichtImg(imgViewA3.getImage());

        this.dialogData.get(5).setGerichtName(gerichtB3Name);
        this.dialogData.get(5).setGerichtPreis(Double.parseDouble(gerichtB3Preis));
        this.dialogData.get(5).setGerichtImg(imgViewB3.getImage());

        this.dialogData.get(6).setGerichtName(gerichtA4Name);
        this.dialogData.get(6).setGerichtPreis(Double.parseDouble(gerichtA4Preis));
        this.dialogData.get(6).setGerichtImg(imgViewA4.getImage());

        this.dialogData.get(7).setGerichtName(gerichtB4Name);
        this.dialogData.get(7).setGerichtPreis(Double.parseDouble(gerichtB4Preis));
        this.dialogData.get(7).setGerichtImg(imgViewB4.getImage());

        this.dialogData.get(8).setGerichtName(gerichtA5Name);
        this.dialogData.get(8).setGerichtPreis(Double.parseDouble(gerichtA5Preis));
        this.dialogData.get(8).setGerichtImg(imgViewA5.getImage());

        this.dialogData.get(9).setGerichtName(gerichtB5Name);
        this.dialogData.get(9).setGerichtPreis(Double.parseDouble(gerichtB5Preis));
        this.dialogData.get(9).setGerichtImg(imgViewB5.getImage());
    }

    static void closeStage(ActionEvent e) {
        ((Stage) ((Button) e.getSource()).getScene().getWindow()).close();
    }


}

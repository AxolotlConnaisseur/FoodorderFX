package com.example.foodorderfx.gui;

import com.example.foodorderfx.SpeiseplanApp;
import com.example.foodorderfx.used.Gericht;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

public class SpeiseBearbeitenController implements Serializable {
    static final long serialVersionUID = 1L;
    @FXML
    private Button btCancel;
    @FXML
    private ImageView imgView;
    @FXML
    Label lblHeader;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPreis;
    @FXML
    private Button btUpdate;
    @FXML
    private Button btDelete;
    public String priceInput;

    private double correctedPriceInput;


    Image emptyFill = new Image("File:///C:/Users/franz/Pictures/Speiseplan/Pngs/Empty.png");
    Image blank = new Image("File:///C:/Users/franz/Pictures/Speiseplan/Pngs/Blank.png");

    public void initialize() {
        lblHeader.setStyle("-fx-font-size: 25;");
        if (SpeiseplanController.relevantControls.lblName.getText().contains("Name")) {

            lblHeader.setText("Gericht bearbeiten");
        } else {
            lblHeader.setText(SpeiseplanController.relevantControls.lblName.getText() + " bearbeiten");
        }
        Gericht gericht = SpeiseplanController.gerichtTransfer;
        txtName.setText(gericht.gerichtName);
        txtPreis.setText(SpeiseBearbeitenController.formatPreis(gericht.gerichtPreis));
        imgView.setImage(gericht.gerichtImg);
    }


    @FXML
    public void choosePic(MouseEvent mouseEvent) {

        if (mouseEvent.getClickCount() == 2) {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File file = fileChooser.showOpenDialog(stage);
            String path = file.getPath();
            Image image = new Image("File:///" + path);
            imgView.setImage(image);
        }

    }



    @FXML
    public void btCancelClick(ActionEvent e) {
        Stage s = (Stage) btCancel.getScene().getWindow();

        s.close();
    }

    @FXML
    public void btUpdateClick(ActionEvent e) {

        double preis = calculatePreis(this.txtPreis.getText());
        boolean nameRichtig = validateName();

        if (preis >= 0 && nameRichtig) {

            SpeiseplanController.gerichtTransfer = getGerichtFromControls();
            Stage s = (Stage) btCancel.getScene().getWindow();

            s.close();
        }
    }

    public Gericht getGerichtFromControls() {

        Gericht gericht = new Gericht(this.txtName.getText(),
                (this.imgView.getImage() == null) ? emptyFill : this.imgView.getImage(),
                SpeiseBearbeitenController.calculatePreis(this.txtPreis.getText())
        );

        return gericht;
    }

    static double calculatePreis(String text) {

        double preisDouble;
        String preis = normalizePreis(text);
        try {
            preisDouble = Double.parseDouble(preis);
        } catch(NumberFormatException e) {
            preisDouble = -1;
        }
        return preisDouble;
    }

    static String formatPreis(double value) {

        return String.format("%.2f €", value);
    }

    private static String normalizePreis(String text) {

        String result = text.replaceAll("\\h€", "");

        if (result.contains(",")) {
            result = result.replace(',', '.');
        }
        return result;
    }

    private boolean validateName() {

        boolean nameRichtig = false;

        //Validation of name input
        if (this.txtName.getText().matches("\\D++(\\s?\\D)*+")) {
            nameRichtig = true;
        } else {
            this.txtName.setText("Ungültiger Name");
            this.txtName.requestFocus();
        }
        return nameRichtig;
    }

    private boolean validatePreis() {

        boolean preisRichtig = false;

        String preis = this.txtPreis.getText();
        //Validation of price input
        if (preis.matches("^\\d{1,8}((,|.)\\d{1,2})?")) {
            preisRichtig = true;

        } else if (preis.matches("^\\d{1,8}((,|.)\\d{1,2})?.+?")) {

            String[] correctedInput = preis.split("^\\d{1,8}((,|.)\\d{1,2})?");
            this.txtPreis.setText(correctedInput[0]);
            preisRichtig = true;

        } else if (preis.matches("^\\d{1,8}((,|.)\\d{1,2})?\\s?€")) {

            String originalString = this.txtPreis.getText();
            originalString = originalString.replaceAll("\\s€", "");
            this.txtPreis.setText(originalString);
            preisRichtig = true;

        } else {
            this.txtPreis.setText("Ungültiger Preis");
            this.txtPreis.requestFocus();
        }
        return preisRichtig;
    }

    @FXML
    public void btDeleteClick(ActionEvent e) throws IOException {
        loeschenFensterOeffnen();
        if (DeleteCheckController.entscheidung) {
            gerichtLoeschen();
            Stage s = (Stage) btUpdate.getScene().getWindow();
            s.close();
        }
    }

    public void loeschenFensterOeffnen() throws IOException {
        Stage hauptfenster = (Stage) btDelete.getScene().getWindow();
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(SpeiseplanApp.class.getResource("deleteCheck.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Gericht wirklich löschen?");


        stage.setScene(new Scene(root));
        stage.initOwner(hauptfenster);
        stage.initModality(Modality.WINDOW_MODAL);

        stage.showAndWait();

    }

    public void gerichtLoeschen() {
        String name = SpeiseplanController.relevantControls.lblName.getId();
        char aOderB = name.charAt(name.length() - 2);
        char nummer = name.charAt(name.length() - 1);
        String koordinaten = aOderB + "" + nummer;
        String nameNeu = "Name " + koordinaten;
        SpeiseplanController.gerichtTransfer.setGerichtName(nameNeu);
        SpeiseplanController.gerichtTransfer.setGerichtImg(blank);
        SpeiseplanController.gerichtTransfer.setGerichtPreis(0);

    }
}

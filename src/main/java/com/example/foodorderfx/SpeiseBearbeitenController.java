package com.example.foodorderfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class SpeiseBearbeitenController {
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
        txtPreis.setText(gericht.gerichtPreis);
        imgView.setImage(gericht.gerichtImg);
    }

    @FXML
    public void choosePic() {

        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        String path = file.getPath();
        Image image = new Image("File:///" + path);
        imgView.setImage(image);
    }

    public void gerichtGiveBack() {
        Gericht gericht = new Gericht();
        if (this.imgView.getImage() == null) {
            this.imgView.setImage(emptyFill);
        }
        String parsedPreis = this.txtPreis.getText();
        if(parsedPreis.contains(",")){
            parsedPreis= parsedPreis.replace(',', '.');
        }
        String[] correctedInput = parsedPreis.split("\\h");
        System.out.println("SpeiseBearbeitenController gerichtGiveBack methode zeile 74 lässt grüßen" + correctedInput[0]);
        double preis = Double.parseDouble(correctedInput[0]);
        gericht.setGerichtName(this.txtName.getText());
        gericht.setGerichtImg(this.imgView.getImage());
        gericht.setGerichtPreis(DecimalFormat.getCurrencyInstance().format(preis));
        //5,0 €

        SpeiseplanController.gerichtTransfer = gericht;

    }

    @FXML
    public void btCancelClick(ActionEvent e) {
        Stage s = (Stage) btCancel.getScene().getWindow();

        s.close();
    }

    @FXML
    public void btUpdateClick(ActionEvent e) {
        boolean preisRichtig = false;
        boolean nameRichtig = false;

        if (this.txtPreis.getText().matches("^\\d{1,8}(,\\d{1,2})?")) {
            preisRichtig = true;

        } else if (this.txtPreis.getText().matches("^\\d{1,8}(,\\d{1,2})?.+?")) {

            String[] correctedInput = this.txtPreis.getText().split("^\\d{1,8}(,\\d{1,2})?");
            this.txtPreis.setText(correctedInput[0]);
            preisRichtig = true;

        } else {
            this.txtPreis.setText("Ungültiger Preis");
            this.txtPreis.requestFocus();
        }
        if (this.txtName.getText().matches("\\D++(\\s?\\D)*+")) {
            nameRichtig = true;
        } else {
            this.txtName.setText("Ungültiger Name");
            this.txtName.requestFocus();
        }

        if (preisRichtig && nameRichtig) {
            gerichtGiveBack();
            Stage s = (Stage) btCancel.getScene().getWindow();

            s.close();
        }

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

        FXMLLoader fxmlLoader = new FXMLLoader(DeleteCheckApp.class.getResource("deleteCheck.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Gericht wirklich löschen?");


        stage.setScene(new Scene(root));
        root.setStyle("-fx-background-image: url(File:///C:/Users/franz/Pictures/Speiseplan/Pngs/Warning.png); -fx-background-position: center center;-fx-background-size: 200 200;" +
                "-fx-background-repeat: no-repeat;");
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
        SpeiseplanController.gerichtTransfer.setGerichtPreis("Preis");

    }

    @FXML
    public void btFaelltAusClick() {
        this.txtName.setText("Gericht fällt aus");
        this.txtPreis.setText("0");
        this.imgView.setImage(new Image("File:///C:/Users/franz/Pictures/Speiseplan/Pngs/Sorry.png"));
    }

}

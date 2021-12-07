package com.example.foodorderfx;

import com.example.foodorderfx.gui.SpeiseplanController;
import com.example.foodorderfx.used.Gericht;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class SpeiseplanApp extends Application {
    public static Stage skizzeStage;
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        ArrayList<Gericht> gerichte = new ArrayList<>(Arrays.asList(
                new Gericht("Montag A", "1"),
                new Gericht("Montag B", "2"),
                new Gericht("Dienstag A", "0.3"),
                new Gericht("Dienstag B", "4"),
                new Gericht("Mittwoch A", "5"),
                new Gericht("Mittwoch B", "6"),
                new Gericht("Donnerstag A", "7"),
                new Gericht("Donnerstag B", "8"),
                new Gericht("Freitag A", "9"),
                new Gericht("Freitag B", "10")
                ));

        gerichte = SpeiseplanController.showDialog(gerichte);


    }

}


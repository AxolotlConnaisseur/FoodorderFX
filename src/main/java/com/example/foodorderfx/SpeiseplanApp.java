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
    public Image imageNotFound = new Image("file:/C:\\Users\\Franzi\\FoodorderFX\\src\\main\\resources\\com\\example\\foodorderfx\\Bilder\\no-image-found.png");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ArrayList<Gericht> gerichte = new ArrayList<>(Arrays.asList(
                new Gericht("Montag A", imageNotFound, "1"),
                new Gericht("Montag B", imageNotFound, "2"),
                new Gericht("Dienstag A", imageNotFound, "3"),
                new Gericht("Dienstag B", imageNotFound, "4"),
                new Gericht("Mittwoch A", imageNotFound, "5"),
                new Gericht("Mittwoch B", imageNotFound, "6"),
                new Gericht("Donnerstag A", imageNotFound, "7"),
                new Gericht("Donnerstag B", imageNotFound, "8"),
                new Gericht("Freitag A", imageNotFound, "9"),
                new Gericht("Freitag B", imageNotFound, "10")
        ));

        gerichte = SpeiseplanController.showDialog(gerichte);


    }

}


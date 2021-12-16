package com.example.foodorderfx;

import com.example.foodorderfx.gui.ExitCheckController;
import com.example.foodorderfx.gui.SpeiseplanController;
import com.example.foodorderfx.used.Gericht;
import com.example.foodorderfx.used.Speiseplan;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        Speiseplan speiseplan = SpeiseplanController.deSerializeObject(SpeiseplanController.path);

        if (speiseplan == null) {
            speiseplan = erzeugeDefaultSpeiseplan();
        }

        Speiseplan planBefore;
        Speiseplan planAfter;


        System.out.println("Vor show dialog" + speiseplan);
        speiseplan = SpeiseplanController.showDialog(speiseplan);
        planBefore = speiseplan;


        System.out.println("Nach Show Dialog" + speiseplan);
        SpeiseplanController.serializeObject(speiseplan, SpeiseplanController.path);
        planAfter = speiseplan;

        System.out.println("Serialisiert");

        if (Arrays.equals(planBefore.gerichte, planAfter.gerichte)) {

        }else{
            Stage exitStage = new Stage();
            FXMLLoader exitFxmlLoader = new FXMLLoader(SpeiseplanApp.class.getResource("exitCheck.fxml"));
            Scene exitScene = new Scene(exitFxmlLoader.load());

            ExitCheckController exitCheckController = exitFxmlLoader.getController();

            exitStage.setTitle("Ungespeicherte Änderungen");
            exitStage.setScene(exitScene);
            exitStage.showAndWait();
        }

    }

    public static Speiseplan erzeugeDefaultSpeiseplan() {

        Image imageNotFound = new Image("file:/C:\\Users\\Franzi\\FoodorderFX\\src\\main\\resources\\com\\example\\foodorderfx\\Bilder\\no-image-found.png");

        ArrayList<Gericht> gerichte = new ArrayList<>(Arrays.asList(
                new Gericht("Montag A", imageNotFound, 1),
                new Gericht("Montag B", imageNotFound, 2),
                new Gericht("Dienstag A", imageNotFound, 3),
                new Gericht("Dienstag B", imageNotFound, 4),
                new Gericht("Mittwoch A", imageNotFound, 5),
                new Gericht("Mittwoch B", imageNotFound, 6),
                new Gericht("Donnerstag A", imageNotFound, 7),
                new Gericht("Donnerstag B", imageNotFound, 8),
                new Gericht("Freitag A", imageNotFound, 9),
                new Gericht("Freitag B", imageNotFound, 10)
        ));

        Speiseplan speiseplan = new Speiseplan();
        for (Gericht gericht : gerichte) {
            speiseplan.setGerichtInArray(gerichte.indexOf(gericht), gericht);
        }
        return speiseplan;
    }
}


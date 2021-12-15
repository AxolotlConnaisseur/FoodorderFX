package com.example.foodorderfx.temp;

import com.example.foodorderfx.SpeiseplanApp;
import com.example.foodorderfx.gui.SpeiseplanController;
import com.example.foodorderfx.used.Speiseplan;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class PlaygroundSerialize extends Application {

    public static void main(String[] args) {
        String path = "C:\\Users\\Franzi\\FoodorderFX\\src\\main\\java\\com\\example\\foodorderfx\\pdf" + "\\testSerialisierung.dat";

        Speiseplan speiseplan = SpeiseplanApp.erzeugeDefaultSpeiseplan();
        System.out.println(speiseplan);

        SpeiseplanController.serializeObject(speiseplan, path);
        System.out.println("-".repeat(20));

        Speiseplan neuerSpeiseplan = SpeiseplanController.deSerializeObject(path);
        System.out.println(neuerSpeiseplan);

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Platform.exit();
    }
}

package com.example.foodorderfx;

import com.example.foodorderfx.gui.SpeiseplanController;
import com.example.foodorderfx.used.Gericht;
import javafx.application.Application;
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
                new Gericht("Schnitzel mit Pommes", "1"),
                new Gericht("Schnitzel mit Salzkartoffel", "2"),
                new Gericht("Pommes", "0.3"),
                new Gericht("Schnitzel", "4"),
                new Gericht("Schnitzel", "5"),
                new Gericht("Schnitzel", "6"),
                new Gericht("Schnitzel", "7"),
                new Gericht("Schnitzel", "8"),
                new Gericht("Schnitzel", "9"),
                new Gericht("Schnitzel", "10")
                ));

        gerichte = SpeiseplanController.showDialog(gerichte);

        Gericht montagA = gerichte.get(0);
        Gericht montagB = gerichte.get(1);

        System.out.println(montagA);
        System.out.println(montagB);

    }

}


package com.example.foodorderfx.logic;


import com.example.foodorderfx.SpeiseplanController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) throws IOException {

        launch();
    }

    /**
     * Anforderung A01
     * Erstellt ein Objekt der Klasse Person
     *
     * @param vorname  der Person
     * @param nachname der Person
     * @return Person
     */
    public static Person personAnlegen(String vorname, String nachname) {
        return new Person(vorname, nachname);
    }

    public static Woche sampleWocheErstellen() {
        Woche wTest = new Woche("kw40");

        Tag[] tage = new Tag[]{new Tag("Montag"), new Tag("Dienstag"), new Tag("Mittwoch"), new Tag("Donnerstag"), new Tag("Freitag")};

        tage[0].setSpeisen(new Speise[]{
                new Speise(0, "Apfelstrudel", 2.12, "Apfelstrudel.png"), new Speise(1, "Beef Stroganoff", 2.10, "Beef Stroganoff.png")});
        tage[1].setSpeisen(new Speise[]{
                new Speise(0, "Falafel", 2.22, "Falafel.png"), new Speise(1, "Nudelauflauf", 4.00, "Nudelauflauf.png")});
        tage[2].setSpeisen(new Speise[]{
                new Speise(0, "Nudelsuppe", 3.33, "Nudelsuppe.png"), new Speise(1, "Pommes", 2.23, "Pommes.png")});
        tage[3].setSpeisen(new Speise[]{
                new Speise(0, "Sandwich", 3.00, "Sandwich.png"), new Speise(1, "Soljanka", 2.88, "Soljanka.png")});
        tage[4].setSpeisen(new Speise[]{
                new Speise(0, "Spaghetti Bolognese", 1.22, "Spaghetti Bolognese.png"), new Speise(1, "Steak", 0.77, "Steak.png")});
        wTest.wochenPlanErstellen(tage);

        return wTest;
    }

    @Override
    public void start(Stage stage) throws Exception {



    }
}
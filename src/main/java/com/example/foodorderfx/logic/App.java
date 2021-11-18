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
                new Speise(0, "Tintenfisch", 2.12, "tintenfisch.jpg"), new Speise(1, "Nudelauflauf", 2.10, "nudelauflauf.jpg")});
        tage[1].setSpeisen(new Speise[]{
                new Speise(0, "Fleischbällchen", 2.22, "fleischbaellchen.jpg"), new Speise(1, "Nudeln mit Sauce", 4.00, "nudelMitSauce.jpg")});
        tage[2].setSpeisen(new Speise[]{
                new Speise(0, "Lasagne", 3.33, "lasagne.jpg"), new Speise(1, "Vegan-Burger", 2.23, "vBurger.jpg")});
        tage[3].setSpeisen(new Speise[]{
                new Speise(0, "Spaghetti Carbonara", 3.00, "carbonara.jpg"), new Speise(1, "Kürbissuppe", 2.88, "kuerbissuppe.jpg")});
        tage[4].setSpeisen(new Speise[]{
                new Speise(0, "Gulaschsuppe", 1.22, "gulaschsuppe.jpg"), new Speise(1, "Salatteller", 0.77, "salatteller.jpg")});
        wTest.wochenPlanErstellen(tage);

        return wTest;
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
package com.example.foodorderfx.output;


import com.example.foodorderfx.logic.Bestellung;
import com.example.foodorderfx.logic.Person;
import com.example.foodorderfx.logic.Speise;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class ReportTest {

    ArrayList<Speise> montag = new ArrayList<>(Arrays.asList(
            new Speise("Apfelstrudel", 1.8),
            new Speise("Steak", 24.0)));

    ArrayList<Speise> dienstag = new ArrayList<>(Arrays.asList(
            new Speise("Kartoffelpuffer", 2.0),
            new Speise("Nudelsuppe", 1.5)));

    ArrayList<Speise> mittwoch = new ArrayList<>(Arrays.asList(
            new Speise("Tortellini", 2.8),
            new Speise("Spaghetti", 4.0)));

    ArrayList<Speise> donnerstag = new ArrayList<>(Arrays.asList(
            new Speise("Tamals", 3.0),
            new Speise("Tortilla", 5.0)));

    ArrayList<Speise> freitag = new ArrayList<>(Arrays.asList(
            new Speise("Knödel", 3.0),
            new Speise("Pasta", 4.0)));

    Person f = new Person("Franz", "Beckenbauer");
    Person l = new Person("Ludwig", "Maier");
    Person r = new Person("Roland", "Bauer");




    ArrayList<Bestellung> bestellungen = new ArrayList<>();

    Bestellung b = new Bestellung(f, montag.get(0));
    Bestellung b2 = new Bestellung(f, dienstag.get(1));
    Bestellung b3 = new Bestellung(l, dienstag.get(1));
    Bestellung b4 = new Bestellung(r, dienstag.get(0));



    /**
     * A07.
     * Das Programm soll es ermöglichen, eine Liste der pro Person aufgelaufenen Kosten für
     * die gesamte Woche auszugeben.
     * Diese Liste wird von der Buchhaltung benötigt, um die
     * Kosten in Rechnung zu stellen
     */

    @Test
    void testListeAufrufen() {

        bestellungen.add(b);
        bestellungen.add(b2);
        bestellungen.add(b3);
        bestellungen.add(b4);

        Report.listeAufrufen(bestellungen);



    }

}
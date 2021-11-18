package com.example.foodorderfx.output;


import com.example.foodorderfx.logic.Bestellung;
import com.example.foodorderfx.logic.Speise;
import com.example.foodorderfx.logic.Speiseplan;

import java.util.ArrayList;

public class Report {
    private String inhalt;

    public Report(String inhalt) {
        this.inhalt = inhalt;
    }

    public String getInhalt() {
        return inhalt;
    }


    public static void druckeBestellungsListe(Speiseplan speiseplan) {

        System.out.println("--- Montag ---");
        if (speiseplan.getMontag() != null) {
            for (Speise y : speiseplan.getMontag()) {
                System.out.println(y.getName() + ":  " + y.getAnzahlBestellungen());
            }
        }

        System.out.println("--- Dienstag ---");
        if (speiseplan.getDienstag() != null) {
            for (Speise y : speiseplan.getDienstag()) {
                System.out.println(y.getName() + ":  " + y.getAnzahlBestellungen());
            }
        }

        System.out.println("--- Mittwoch ---");
        if (speiseplan.getMittwoch() != null) {
            for (Speise y : speiseplan.getMittwoch()) {
                System.out.println(y.getName() + ":  " + y.getAnzahlBestellungen());
            }
        }

        System.out.println("--- Donnerstag ---");
        if (speiseplan.getDonnerstag() != null) {
            for (Speise y : speiseplan.getDonnerstag()) {
                System.out.println(y.getName() + ":  " + y.getAnzahlBestellungen());
            }
        }

        System.out.println("--- Freitag ---");
        if (speiseplan.getFreitag() != null) {
            for (Speise y : speiseplan.getFreitag()) {
                System.out.println(y.getName() + ":  " + y.getAnzahlBestellungen());
            }
        }

    }

    public static void listeAufrufen(ArrayList<Bestellung> bestellungen) {

        double kosten = 0;

        for (Bestellung b : bestellungen) {

            kosten = kosten + b.getSpeise().getPreis();

        }

        System.out.println("Kosten: " + kosten);

    }
}

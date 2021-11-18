package com.example.foodorderfx.logic;



import com.example.foodorderfx.output.Report;

import java.security.InvalidParameterException;

public class Speise {

    String name;
    double preis;
    int anzahlBestellungen;
    private int menuNummer;

    public Speise(int menuNummer, String name) {
        this.menuNummer = menuNummer;
        this.name = name;

    }

    public Speise(int menuNummer, String name, double preis) {
        this.menuNummer = menuNummer;
        this.name = name;
        this.preis = preis;
    }

    public Speise(String bezeichnung, double preis) {
        this.name = bezeichnung;
        this.preis = preis;

        if (preis < 0) {
            throw new InvalidParameterException("Preis kleiner Null ist nicht möglich");
        }
    }
    public static Report anzahlBestellungenAusgeben(Woche w) {
        StringBuilder ausgabeString = new StringBuilder();
        for (Tag tag : w.getTage()) {
            for (Speise speise : tag.getSpeisen()) {
                ausgabeString.append(speise.getName()).append(": ").append(speise.anzahlBestellungen).append(" mal bestellt\n");
            }
        }

        return new Report(ausgabeString.toString());
    }

    public int getMenuNummer() {
        return menuNummer;
    }

    public double getPreis() {
        return preis;
    }

    public String getName() {
        return name;
    }

    public int getAnzahlBestellungen() {
        return anzahlBestellungen;
    }

    public void bestelle() {
        anzahlBestellungen++;
    }


    public void setPreis(double preis) {
        this.preis = preis;
    }
}

package com.example.foodorderfx.logic;

import com.example.foodorderfx.output.Report;

@SuppressWarnings("ALL")
public class Speise {
    public int anzahlBestellungen;
    private int menuNummer;
    private String name;
    private double preis;

    private String bild;

    public Speise(int menuNummer, String name, double preis) {
        this.menuNummer = menuNummer;
        this.name = name;
        this.preis = preis;

    }

    public Speise(int menuNummer, String name, double preis, String bild) {
        this(menuNummer, name, preis);
        this.bild = bild;
    }

    public static Report anzahlBestellungenAusgeben(Woche w) {
        StringBuilder ausgabeString = new StringBuilder();
        for (Tag tag : w.getTage()) {
            for (Speise speise : tag.getSpeisen()) {
                ausgabeString.append(speise.getName() + ": " + speise.anzahlBestellungen + " mal bestellt\n");
            }
        }

        return new Report("Anzahl der Bestellungen",ausgabeString.toString());
    }

    public int getMenuNummer() {
        return menuNummer;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBild() {
        return bild;
    }
}
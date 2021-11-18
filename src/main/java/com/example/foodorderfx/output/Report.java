package com.example.foodorderfx.output;

public class Report {
    public String getBeschreibung() {
        return beschreibung;
    }

    private String beschreibung;
    private String inhalt;

    public Report(String beschreibung, String inhalt) {
        this.beschreibung = beschreibung;
        this.inhalt = inhalt;
    }

    public String getInhalt() {
        return inhalt;
    }
}
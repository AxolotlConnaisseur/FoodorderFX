package com.example.foodorderfx.logic;

import com.example.foodorderfx.output.Report;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class Person {
    private String vorname;
    private String nachname;
    private ArrayList<Speise> ausgewaehlteSpeise;
    private double kostenInDerWoche;

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.ausgewaehlteSpeise = new ArrayList<>();
    }

    public double getKostenInDerWoche() {
        return kostenInDerWoche;
    }

    public ArrayList<Speise> getAusgewaehlteSpeisen() {
        return ausgewaehlteSpeise;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void speiseAuswaehlen(Tag t, int menuNummer) {
        this.ausgewaehlteSpeise.add(t.getSpeisen()[menuNummer]);
        t.getSpeisen()[menuNummer].anzahlBestellungen += 1;
    }

    public void speiseAendern(Woche woche, Tag tag, int neueMenuNr) {
        for (int i = 0; i < woche.getTage().length; i++) {
            if (woche.getTage()[i].equals(tag)) {
                ausgewaehlteSpeise.set(i, tag.getSpeisen()[neueMenuNr]);
            }
        }
    }

    public Report wochenrechnungAusgeben() {


        double gesamt = 0;
        StringBuilder ausgabeString = new StringBuilder();

        for (Speise speise : this.ausgewaehlteSpeise) {
            gesamt += speise.getPreis();
            ausgabeString.append(String.format("%s %.2f €\n",speise.getName(),speise.getPreis()));
        }
        ausgabeString.append(String.format("\nGesamt: %.2f €\n",gesamt));
        ausgabeString.append("-".repeat(50));
        this.kostenInDerWoche = gesamt;

        return new Report("Wochenrechnung für " + this.getVorname() + " "
                + this.getNachname(),ausgabeString.toString());

    }

}
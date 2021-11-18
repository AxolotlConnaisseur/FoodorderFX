package com.example.foodorderfx.logic;



import com.example.foodorderfx.output.Report;

import java.util.ArrayList;

public class Person {

    private String Vorname;
    private String Nachname;
    private ArrayList<Speise> ausgewaehlteSpeise;
    private double kostenInDerWoche;

    public Person(String vorname, String nachname) {
        this.Vorname = vorname;
        this.Nachname = nachname;
        this.ausgewaehlteSpeise = new ArrayList<>();
    }

    public double getKostenInDerWoche() {
        return kostenInDerWoche;
    }

    public void setKostenInDerWoche(double kostenInDerWoche) {
        this.kostenInDerWoche = kostenInDerWoche;
    }

    public ArrayList<Speise> getAusgewaehlteSpeise() {
        return ausgewaehlteSpeise;
    }

    public String getVorname() {
        return Vorname;
    }

    public String getNachname() {
        return Nachname;
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

    public Report wochenrechnungAusgeben(Tag[] tage) {
        double gesamt = 0;
        StringBuilder ausgabeString = new StringBuilder();
        for (int i = 0; i < tage.length; i++) {
            gesamt += tage[i].getSpeisen()[this.ausgewaehlteSpeise.get(i).getMenuNummer()].getPreis();
            ausgabeString.append(tage[i].getSpeisen()[this.ausgewaehlteSpeise.get(i).getMenuNummer()].getName()).append(": ").append(tage[i].getSpeisen()[this.ausgewaehlteSpeise.get(i).getMenuNummer()].getPreis()).append("\n");
        }
        ausgabeString.append("\n" + "Gesamt: ").append(gesamt);

        return new Report(ausgabeString.toString());

    }

}

package com.example.foodorderfx.logic;




import com.example.foodorderfx.output.Report;

import java.util.ArrayList;

public class Gruppe {

    private String bezeichnung;
    private ArrayList<Person> mitglieder;

    public Gruppe(String bezeichnung) {
        this.bezeichnung = bezeichnung;
        this.mitglieder = new ArrayList<>();
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public ArrayList<Person> getMitglieder() {
        return mitglieder;
    }

    public void mitgliederHinzufuegen(Person p) {
        mitglieder.add(p);
    }

    public Report bestellungenAusgeben() {
        StringBuilder bestellungen = new StringBuilder();
        for (Person einzelPerson : mitglieder) {
            bestellungen.append(einzelPerson.getVorname()).append(" ").append(einzelPerson.getNachname()).append(": \n");

            for (int i = 0; i < 5; i++) {
                bestellungen.append(einzelPerson.getAusgewaehlteSpeise().get(i).getName()).append("\n");
            }
            bestellungen.append("\n");
        }
        Report bestellungenReport = new Report(bestellungen.toString());
        System.out.println(bestellungenReport.getInhalt());
        return bestellungenReport;
    }

    public void mitgliedEntfernen(Person p) {
        mitglieder.removeIf(mitglied -> mitglied.equals(p));
    }
}


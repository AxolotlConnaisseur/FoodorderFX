package com.example.foodorderfx.logic;

import com.example.foodorderfx.output.Report;

import java.util.ArrayList;

@SuppressWarnings("ALL")
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
        String bestellungen = "";
        for (Person einzelPerson : mitglieder) {
            bestellungen += einzelPerson.getVorname() + " " + einzelPerson.getNachname() + ": \n";

            for (int i = 0; i < 5; i++) {
                bestellungen += einzelPerson.getAusgewaehlteSpeisen().get(i).getName() + "\n";
            }
            bestellungen += "\n";
        }
        Report bestellungenReport = new Report("Bestellungen der Gruppe",bestellungen);
        System.out.println(bestellungenReport.getInhalt());
        return bestellungenReport;
    }

    public void mitgliedEntfernen(Person p) {
        for (Person mitglied : mitglieder) {
            if (mitglied.equals(p)) {
                mitglieder.remove(mitglied);
            }

        }
    }
}
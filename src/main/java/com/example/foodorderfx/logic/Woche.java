package com.example.foodorderfx.logic;

import com.example.foodorderfx.output.Report;

import java.util.ArrayList;


@SuppressWarnings("ALL")
public class Woche {
    private String kalenderWoche;
    private Tag[] tage;

    public Woche(String kalenderWoche) {
        this.kalenderWoche = kalenderWoche;
    }

    /**
     * Anforderung A02
     * Übernimmt ein Array an Tagen in das Attribut tage[] von Woche
     *
     * @param tage der Woche
     */
    public void wochenPlanErstellen(Tag[] tage) {
        this.tage = tage;

    }

    public Report wochenPlanAendern(Tag tag, int zuErsetzendeSpeiseMenuNr, Speise ersetzendeSpeise, Person[] allePersonen) {
        ArrayList<Person> betroffenePersonen = new ArrayList<>();
//TODO
        for (int i = 0; i < tage.length; i++) {
            if (tage[i].equals(tag)) {
                for (Person einePerson : allePersonen) {
                   /* if (einePerson.getAusgewaehlteSpeisen()[i])) {
                        betroffenePersonen.add(einePerson);
                       }
                    */
                }
                tage[i].getSpeisen()[zuErsetzendeSpeiseMenuNr] = ersetzendeSpeise;
            }
        }
        StringBuilder inhalt = new StringBuilder();
        for (Person p : betroffenePersonen) {
            inhalt.append(p.getVorname() + " " + p.getNachname() + "\n");
        }

        return new Report("Platzhalter",inhalt.toString());
    }

    public Tag[] getTage() {
        return tage;
    }

    public String getKalenderWoche() {
        return kalenderWoche;
    }

    /**
     * Anforderung A07
     * Gibt Report zurück von den gesamtkosten je Person für die ganze Woche
     *
     * @param personen
     * @return
     */
    public Report kostenProPerson(Person[] personen) {
        ArrayList<String> kostenListe = new ArrayList<>();

        for (Person person : personen) {
            kostenListe.add(person.getVorname() + " " + person.getNachname() + ": " + person.getKostenInDerWoche());
        }

        return new Report("Kosten pro Person",kostenListe.toString());
    }
}
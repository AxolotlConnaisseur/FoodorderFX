package com.example.foodorderfx.logic;




import com.example.foodorderfx.output.Report;

import java.util.ArrayList;

public class Woche {
    private String kalenderWoche;
    private Tag[] tage;

    public Woche(String kalenderWoche) {
        this.kalenderWoche = kalenderWoche;
    }

    public Woche() {
    }

    public void wochenPlanErstellen(Tag[] tage) {
        this.tage = tage;

    }

    public Report wochenPlanAendern(Tag tag, int zuErsetzendeSpeiseMenuNr, Speise ersetzendeSpeise, Person[] allePersonen) {
        ArrayList<Person> betroffenePersonen = new ArrayList<>();

        for (int i = 0; i < tage.length; i++) {
            if (tage[i].equals(tag)) {
                for (Person einePerson : allePersonen) {
                    if (einePerson.getAusgewaehlteSpeise().get(i).equals(tage[i].getSpeisen()[zuErsetzendeSpeiseMenuNr])) {
                        betroffenePersonen.add(einePerson);
                    }
                }
                tage[i].getSpeisen()[zuErsetzendeSpeiseMenuNr] = ersetzendeSpeise;
            }
        }
        StringBuilder inhalt = new StringBuilder();
        for (Person p : betroffenePersonen) {
            inhalt.append(p.getVorname()).append(" ").append(p.getNachname()).append("\n");
        }

        return new Report(inhalt.toString());
    }

    public Tag[] getTage() {
        return tage;
    }

    public String getKalenderWoche() {
        return kalenderWoche;
    }


    public Report kostenProPerson(Tag[] tage, Person[] personen) {
        ArrayList<String> kostenListe = new ArrayList<>();
        for (int i = 0; i < tage.length; i++) {
            for (Person person : personen) {
                person.setKostenInDerWoche(person.getKostenInDerWoche() + tage[i].getSpeisen()[person.getAusgewaehlteSpeise().get(i).getMenuNummer()].getPreis());

            }
        }
        for (Person person : personen) {
            kostenListe.add(person.getVorname() + " " + person.getNachname() + ": " + person.getKostenInDerWoche());
        }

        return new Report(kostenListe.toString());
    }
}
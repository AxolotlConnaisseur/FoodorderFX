package com.example.foodorderfx.logic;

import java.util.ArrayList;

public class Bestellung {

    Person person;
    Speise speise;

    static ArrayList<Bestellung> bestellungen = new ArrayList<>();

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Speise getSpeise() {
        return speise;
    }

    public void setSpeise(Speise speise) {
        this.speise = speise;
    }

    public static void setBestellungen(ArrayList<Bestellung> bestellungen) {
        Bestellung.bestellungen = bestellungen;
    }

    public Bestellung(Person person, Speise speise) {
        this.person = person;
        this.speise = speise;
        bestellungen.add(this);
        speise.bestelle();

    }

    public static ArrayList<Bestellung> getBestellungen() {
        return bestellungen;
    }


}

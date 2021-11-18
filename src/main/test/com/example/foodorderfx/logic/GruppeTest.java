package com.example.foodorderfx.logic;

import org.junit.jupiter.api.Test;

class GruppeTest {

    @Test
    void mitgliederHinzufuegen() {
        Person p1 = new Person("Harald", "Hammer");
        Person p2 = new Person("Sandra", "Schande");

        Gruppe gruppeA = new Gruppe("gruppeA");

        gruppeA.mitgliederHinzufuegen(p1);
        gruppeA.mitgliederHinzufuegen(p2);

    }

    @Test
    void bestellungenAusgeben() {
        Woche wTest = App.sampleWocheErstellen();

        Person p1 = new Person("Harald", "Hammer");
        Person p2 = new Person("Sandra", "Schande");
        Gruppe gruppeA = new Gruppe("gruppeA");
        gruppeA.mitgliederHinzufuegen(p1);
        gruppeA.mitgliederHinzufuegen(p2);

        p1.speiseAuswaehlen(wTest.getTage()[0], 1);
        p1.speiseAuswaehlen(wTest.getTage()[1], 0); //Nuller = Platzhalter für Zwei
        p1.speiseAuswaehlen(wTest.getTage()[2], 1);
        p1.speiseAuswaehlen(wTest.getTage()[3], 1);
        p1.speiseAuswaehlen(wTest.getTage()[4], 1);

        p2.speiseAuswaehlen(wTest.getTage()[0], 0);
        p2.speiseAuswaehlen(wTest.getTage()[1], 0);
        p2.speiseAuswaehlen(wTest.getTage()[2], 0);
        p2.speiseAuswaehlen(wTest.getTage()[3], 1);
        p2.speiseAuswaehlen(wTest.getTage()[4], 0);


        gruppeA.bestellungenAusgeben();

    }

    @Test
    void mitgliedEntfernen() {
        Person p1 = new Person("Harald", "Hammer");
        Person p2 = new Person("Sandra", "Schande");

        Gruppe gruppeA = new Gruppe("gruppeA");

        gruppeA.mitgliederHinzufuegen(p1);
        gruppeA.mitgliederHinzufuegen(p2);

        gruppeA.mitgliedEntfernen(p1);
        for (Person p : gruppeA.getMitglieder()) {
            System.out.println(p.getVorname());
        }
    }
}
package com.example.foodorderfx.logic;

import org.junit.jupiter.api.Test;

class SpeiseTest {

    @Test
    void setPreis() {
        Speise sp = new Speise(1, "Tacos",3.8);
        sp.setPreis(4.99);
    }

    @Test
    void anzahlBestellungenAusgeben() {
        Person p1 = new Person("Dieter", "Reiter");
        Person p2 = new Person("Hans", "Hansi");


        Woche wTest = new Woche("kw30");

        Tag[] tage = new Tag[]{new Tag("Montag"), new Tag("Dienstag"), new Tag("Mittwoch"), new Tag("Donnerstag"), new Tag("Freitag")};
        tage[0].setSpeisen(new Speise[]{new Speise(1, "Hackbraten", 2.12), new Speise(0, "Gemueseauflauf", 2.10)});
        tage[1].setSpeisen(new Speise[]{new Speise(1, "Putensteak", 2.22), new Speise(0, "Knoedel mit Sosse", 4.00)});
        tage[2].setSpeisen(new Speise[]{new Speise(1, "Geschnetzeltes", 3.33), new Speise(0, "Pommes", 2.23)});
        tage[3].setSpeisen(new Speise[]{new Speise(1, "Hamburger", 3.00), new Speise(0, "vegan Schnitzel", 2.88)});
        tage[4].setSpeisen(new Speise[]{new Speise(1, "Fisch", 1.22), new Speise(0, "Salat", 0.77)});
        wTest.wochenPlanErstellen(tage);

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

        Speise.anzahlBestellungenAusgeben(wTest);

    }
}
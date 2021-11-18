package com.example.foodorderfx.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@SuppressWarnings("ALL")
class PersonTest {

    @Test
    void speiseAuswaehlen() {
        Person p = new Person("Hans", "Kapfer");
        Tag t = new Tag("Montag");
        t.setSpeisen(new Speise[]{new Speise(0, "Maultaschen", 2)});
        p.speiseAuswaehlen(t, 0);
    }

    @Test
    void wochenrechnungAusgeben() {
        Person p1 = new Person("Hans", "Hansi");


        Woche wTest = new Woche("kw50");
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

        p1.wochenrechnungAusgeben();
    }

    @Test
    void speiseAendern() {
        Woche wTest = App.sampleWocheErstellen();
        Person p1 = new Person("Peter", "Pauer");
        p1.speiseAuswaehlen(wTest.getTage()[0], 1);
        p1.speiseAuswaehlen(wTest.getTage()[1], 0);
        p1.speiseAuswaehlen(wTest.getTage()[2], 1);
        p1.speiseAuswaehlen(wTest.getTage()[3], 1);
        p1.speiseAuswaehlen(wTest.getTage()[4], 1);

        ArrayList<Speise> davor = p1.getAusgewaehlteSpeisen();
        p1.speiseAendern(wTest, wTest.getTage()[1], 1);
        ArrayList<Speise> danach = new ArrayList<>();
        danach = p1.getAusgewaehlteSpeisen();
        Assertions.assertNotEquals(davor.toArray(), danach.toArray());
    }
}
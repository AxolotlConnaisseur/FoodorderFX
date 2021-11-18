package com.example.foodorderfx.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WocheTest {

    @Test
    void wochenPlanErstellen() {
        {
            Woche wTest = new Woche();
            Tag[] tage = new Tag[]{new Tag("Montag"), new Tag("Dienstag"), new Tag("Mittwoch"), new Tag("Donnerstag"), new Tag("Freitag")};
            tage[0].setSpeisen(new Speise[]{new Speise(1, "Hackbraten"), new Speise(2, "Gemueseauflauf")});
            tage[1].setSpeisen(new Speise[]{new Speise(1, "Putensteak"), new Speise(2, "Knoedel mit Sosse")});
            tage[2].setSpeisen(new Speise[]{new Speise(1, "Geschnetzeltes"), new Speise(2, "Pommes")});
            tage[3].setSpeisen(new Speise[]{new Speise(1, "Hamburger"), new Speise(2, "vegan Schnitzel")});
            tage[4].setSpeisen(new Speise[]{new Speise(1, "Fisch"), new Speise(2, "Salat")});
            wTest.wochenPlanErstellen(tage);
        }
        {
            Woche wTest = new Woche();
            Tag[] tage = new Tag[]{new Tag("Montag"), new Tag("Dienstag"), new Tag("Mittwoch"), new Tag("Donnerstag"), new Tag("Freitag")};
            tage[0].setSpeisen(new Speise[]{new Speise(1, "Hackbraten"), new Speise(2, "Gemueseauflauf")});
            tage[1].setSpeisen(new Speise[]{new Speise(1, "Putensteak"), new Speise(2, "Knoedel mit Sosse")});

            tage[3].setSpeisen(new Speise[]{new Speise(1, "Hamburger"), new Speise(2, "vegan Schnitzel")});
            tage[4].setSpeisen(new Speise[]{new Speise(1, "Fisch"), new Speise(2, "Salat")});
            wTest.wochenPlanErstellen(tage);

        }
    }

    @Test
    void kostenProPerson() {
        Person p1 = new Person("Dieter", "Reiter");
        Person p2 = new Person("Hans", "Hansi");


        Woche wTest = App.sampleWocheErstellen();


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

        Person[] pArray = new Person[]{p1, p2};

        wTest.kostenProPerson(wTest.getTage(), pArray);


    }

    @Test
    void wochenPlanAendern() {
        Woche wTest = App.sampleWocheErstellen();
        Woche wTest2 = App.sampleWocheErstellen();

        Person p1 = new Person("Harald", "Hart");
        Person p2 = new Person("Dietmar", "Hart");
        Person[] pArray = new Person[]{p1, p2};

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

        wTest.wochenPlanAendern(wTest.getTage()[0], 1, new Speise(1, "Bananenbrot"), pArray);
        Assertions.assertNotEquals(wTest.getTage()[0].getSpeisen()[1].getName(), wTest2.getTage()[0].getSpeisen()[1].getName());
    }
}
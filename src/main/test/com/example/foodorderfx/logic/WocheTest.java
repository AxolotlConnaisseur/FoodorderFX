package com.example.foodorderfx.logic;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WocheTest {

    @Test
    void wochenPlanErstellen() {
        {
            Woche wTest = new Woche("kw10");
            Tag[] tage = new Tag[]{new Tag("Montag"), new Tag("Dienstag"), new Tag("Mittwoch"), new Tag("Donnerstag"), new Tag("Freitag")};
            tage[0].setSpeisen(new Speise[]{new Speise(1, "Hackbraten", 1), new Speise(2, "Gemueseauflauf", 1)});
            tage[1].setSpeisen(new Speise[]{new Speise(1, "Putensteak", 1), new Speise(2, "Knoedel mit Sosse", 1)});
            tage[2].setSpeisen(new Speise[]{new Speise(1, "Geschnetzeltes", 1), new Speise(2, "Pommes", 1)});
            tage[3].setSpeisen(new Speise[]{new Speise(1, "Hamburger", 1), new Speise(2, "vegan Schnitzel", 1)});
            tage[4].setSpeisen(new Speise[]{new Speise(1, "Fisch", 1), new Speise(2, "Salat", 1)});
            wTest.wochenPlanErstellen(tage);
        }
        {
            Woche wTest = new Woche("kw57");
            Tag[] tage = new Tag[]{new Tag("Montag"), new Tag("Dienstag"), new Tag("Mittwoch"), new Tag("Donnerstag"), new Tag("Freitag")};
            tage[0].setSpeisen(new Speise[]{new Speise(1, "Hackbraten", 1), new Speise(2, "Gemueseauflauf", 1)});
            tage[1].setSpeisen(new Speise[]{new Speise(1, "Putensteak", 1), new Speise(2, "Knoedel mit Sosse", 1)});

            tage[3].setSpeisen(new Speise[]{new Speise(1, "Hamburger", 1), new Speise(2, "vegan Schnitzel", 1)});
            tage[4].setSpeisen(new Speise[]{new Speise(1, "Fisch", 1), new Speise(2, "Salat", 1)});
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

        wTest.kostenProPerson(pArray);


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

        wTest.wochenPlanAendern(wTest.getTage()[0], 1, new Speise(1, "Bananenbrot", 1), pArray);
        Assertions.assertNotEquals(wTest.getTage()[0].getSpeisen()[1].getName(), wTest2.getTage()[0].getSpeisen()[1].getName());
    }
}
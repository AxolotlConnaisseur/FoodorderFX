package com.example.foodorderfx.logic;


public class App {
    public static void main(String[] args) {

    }

    public static Person personAnlegen(String vorname, String nachname) {
        return new Person(vorname, nachname);
    }

    public static Woche sampleWocheErstellen() {
        Woche wTest = new Woche();

        Tag[] tage = new Tag[]{new Tag("Montag"), new Tag("Dienstag"), new Tag("Mittwoch"), new Tag("Donnerstag"), new Tag("Freitag")};
        tage[0].setSpeisen(new Speise[]{new Speise(0, "Hackbraten", 2.12), new Speise(1, "Gemueseauflauf", 2.10)});
        tage[1].setSpeisen(new Speise[]{new Speise(0, "Putensteak", 2.22), new Speise(1, "Knoedel mit Sosse", 4.00)});
        tage[2].setSpeisen(new Speise[]{new Speise(0, "Geschnetzeltes", 3.33), new Speise(1, "Pommes", 2.23)});
        tage[3].setSpeisen(new Speise[]{new Speise(0, "Hamburger", 3.00), new Speise(1, "vegan Schnitzel", 2.88)});
        tage[4].setSpeisen(new Speise[]{new Speise(0, "Fisch", 1.22), new Speise(1, "Salat", 0.77)});
        wTest.wochenPlanErstellen(tage);

        return wTest;
    }

}

package com.example.foodorderfx.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonTest {

    Person f = new Person("Franz", "Beckenbauer");
    Person l = new Person("Ludwig", "Maier");
    Person r = new Person("Roland", "Bauer");

    ArrayList<Speise> montag = new ArrayList<>(Arrays.asList(
            new Speise("Spaghetti Bolognese", 1.8),
            new Speise("Steak", 24.0)));

    ArrayList<Speise> dienstag = new ArrayList<>(Arrays.asList(
            new Speise("Nudelsuppe", 2.0),
            new Speise("Beef Stroganoff", 1.5)));

    ArrayList<Speise> mittwoch = new ArrayList<>(Arrays.asList(
            new Speise("Soljanka", 2.8),
            new Speise("Apfelstrudel", 4.0)));

    ArrayList<Speise> donnerstag = new ArrayList<>(Arrays.asList(
            new Speise("Falafel", 3.0),
            new Speise("Pommes", 5.0)));

    ArrayList<Speise> freitag = new ArrayList<>(Arrays.asList(
            new Speise("Nudelauflauf", 3.0),
            new Speise("Sandwich", 4.0)));

    /* A01. Das Programm soll es ermöglichen, Personen mit Vornamen und Nachname anzulegen.  */

    @BeforeEach
    void setUp() {
        Bestellung.bestellungen = new ArrayList<>();
    }

    @Test
    void testAnlegenPerson() {

        Person p = new Person("Franz", "Beckenbauer");
        Person q = new Person("Sepp", "Meier");
        Assertions.assertEquals("Franz", p.getVorname());
        Assertions.assertEquals("Beckenbauer", p.getNachname());
    }

    /* A02. Das Programm soll es ermöglichen, für eine Woche (Montag bis Freitag)
    einen Speiseplan mit für jeden Tag mehreren möglichen Optionen einzugeben. */

    @Test
    void testErzeugeSpeiseplan() {

        Speiseplan s = new Speiseplan(montag, dienstag, mittwoch, donnerstag, freitag);

        String gericht = s.getMontag().get(0).getName();
        Assertions.assertEquals("Spaghetti Bolognese", gericht);
    }

    /* A03. Das Programm soll es ermöglichen, für jede Speise einen Preis festzulegen. */

    @Test
    void testPreisFuerGericht() {

        double preis;

        Assertions.assertEquals(5.0, new Speise("Rohrnudel", 5.0).getPreis());
        Assertions.assertThrows(InvalidParameterException.class, () -> new Speise("Gebratene Maiskolben", -2.0));
    }

    /**
     * A04. Der Speisplan soll auch funktionieren, wenn einzelne Tage ausfallen, z.B. wegen eines Feiertags.
     */
    @Test
    void testFeiertag() {

        // Legt einen Speiseplan an für eine Woche, in der Mittwoch ein Feiertag ist
        Speiseplan s = new Speiseplan(montag, dienstag, null, donnerstag, freitag);

    }

    /**
     * A05. Das Programm soll es ermöglichen, dass jede *Person* für einen Tag eine *Speise* aus dem *Speiseplan* auswählen kann,
     * und diese Speise bestellen kann. *
     */
    @Test
    void testGewaehlteSpeise() {

        Person p = new Person("Franz", "Beckenbauer");
        Speiseplan speiseplan = new Speiseplan(montag, dienstag, null, donnerstag, freitag);
        Speise speise = speiseplan.getMontag().get(0);

        Bestellung b = new Bestellung(p, speise);

    }

    /**
     * A06. Das Programm soll es ermöglichen, in Form einer Liste
     * für alle Speisen die Anzahl der jeweiligen Bestellungen aufzulisten
     * (für die Küche, um die Zutaten zu kaufen).
     */

    @Test
    void testBestellungsListe() {

        Person p = new Person("Franz", "Beckenbauer");
        Speiseplan speiseplan = new Speiseplan(montag, dienstag, null, donnerstag, freitag);
        Speise speise = speiseplan.getMontag().get(0);

        Assertions.assertEquals(0, Bestellung.getBestellungen().size());

        Bestellung b = new Bestellung(p, speise);
        ArrayList<Bestellung> bestellungen = Bestellung.getBestellungen();
        Assertions.assertEquals(1, bestellungen.size());

        Bestellung b2 = new Bestellung(p, speise);
        Assertions.assertEquals(2, Bestellung.getBestellungen().size());

        speiseplan.druckeBestellungListe();

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

        ArrayList<Speise> davor = p1.getAusgewaehlteSpeise();
        p1.speiseAendern(wTest, wTest.getTage()[1], 1);
        ArrayList<Speise> danach;
        danach = p1.getAusgewaehlteSpeise();
        Assertions.assertNotEquals(davor.toArray(), danach.toArray());
    }
}


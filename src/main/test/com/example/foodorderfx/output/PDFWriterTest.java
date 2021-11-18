package com.example.foodorderfx.output;

import com.example.foodorderfx.logic.App;
import com.example.foodorderfx.logic.Person;
import com.example.foodorderfx.logic.Woche;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

class PDFWriterTest {

    @Test
    void writePDF() throws FileNotFoundException {
        Woche wTest = App.sampleWocheErstellen();

        Person p1 = new Person("Heinz", "Kammerer");
        Person p2 = new Person("Frida", "Flamm");
        Person p3 = new Person("Tarpar", "Dingeldorfer");
        Person p4 = new Person("Plassic", "Krumer");


        int[] speiseAuswahl = {1,0,1,1,1};
        for (int i = 0; i < 5 ; i++) {
            p1.speiseAuswaehlen(wTest.getTage()[i], speiseAuswahl[i]);
        }


        p2.speiseAuswaehlen(wTest.getTage()[0], 0);
        p2.speiseAuswaehlen(wTest.getTage()[1], 0);
        p2.speiseAuswaehlen(wTest.getTage()[2], 0);
        p2.speiseAuswaehlen(wTest.getTage()[3], 1);
        p2.speiseAuswaehlen(wTest.getTage()[4], 0);

        p3.speiseAuswaehlen(wTest.getTage()[0], 1);
        p3.speiseAuswaehlen(wTest.getTage()[1], 0);
        p3.speiseAuswaehlen(wTest.getTage()[2], 1);
        p3.speiseAuswaehlen(wTest.getTage()[3], 0);
        p3.speiseAuswaehlen(wTest.getTage()[4], 1);

        p4.speiseAuswaehlen(wTest.getTage()[0], 1);
        p4.speiseAuswaehlen(wTest.getTage()[1], 0);
        p4.speiseAuswaehlen(wTest.getTage()[2], 0);
        p4.speiseAuswaehlen(wTest.getTage()[3], 1);
        p4.speiseAuswaehlen(wTest.getTage()[4], 0);

        Report[] alleReports = new Report[]{
                p1.wochenrechnungAusgeben(),
                p2.wochenrechnungAusgeben(),
                p3.wochenrechnungAusgeben(),
                p4.wochenrechnungAusgeben()

        };

        PDFWriter.writePDF(alleReports);


    }

    @Test
    void wochenplanPdfPrint() throws FileNotFoundException, MalformedURLException {
        Woche testW = App.sampleWocheErstellen();

        PDFWriter.printWochenplan(testW);

    }


}
package com.example.foodorderfx.output;

import com.example.foodorderfx.logic.Speise;
import com.example.foodorderfx.logic.Woche;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.VerticalAlignment;


import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;

public class PDFWriter {

    public static final String REPORT_PATH = "src/main/resources/com/example/foodorderfx/";
    public static final String IMAGE_PATH = REPORT_PATH + "Bilder/";
    public static final float IMAGE_HEIGTH = 115F;
    public static final float IMAGE_WIDTH = 130F;


    public static void printWochenplan(Woche w) throws FileNotFoundException, MalformedURLException {
        // Creating a PdfWriter
        String dest = REPORT_PATH + "Speiseplan.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(PageSize.A4.rotate());
        Document document = new Document(pdf);
        float[] pointColumnWidths = {150F, 150F, 150F, 150F, 150F, 150F};
        Table table = new Table(pointColumnWidths);
    //    table.setMarginTop(100F);
      //  table.setHeight(350F);

        Cell a0 = new Cell();
        Paragraph p0 = new Paragraph(w.getKalenderWoche());
        p0.setFontSize(16F);
        a0.add(p0);
        table.addCell(a0);

        String[] wochentage = new String[]{"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"};

        for (String tag : wochentage) {
            Cell a1 = new Cell();
            Paragraph p1 = new Paragraph(tag);
            p1.setFontSize(16F);
            a1.add(p1);
            table.addCell(a1);

        }

        erstelleZeileGericht(table, w, "Gericht A", 0);
        erstelleZeilePreis(table, w, 0);
        erstelleZeileGericht(table, w, "Gericht B", 1);
        erstelleZeilePreis(table, w, 1);

        document.add(table);
        document.close();


        System.out.println("Speiseplan erstellt");
    }

    private static void erstelleZeileGericht(Table table, Woche w, String menuName, int zeile) throws MalformedURLException {

        Cell b0 = new Cell();
        Paragraph pMenuA = new Paragraph(menuName);
        pMenuA.setFontSize(14F);
        b0.add(pMenuA);
        table.addCell(b0);

        for (int i = 0; i < 5; i++) {
            Speise dieseSpeise = w.getTage()[i].getSpeisen()[zeile];
            Cell b1 = new Cell();
            b1.add(createImage(IMAGE_HEIGTH, IMAGE_WIDTH, dieseSpeise.getBild()).setHorizontalAlignment(HorizontalAlignment.CENTER));
            b1.add(new Paragraph(dieseSpeise.getName()));
            table.addCell(b1);
        }
    }

    private static void erstelleZeilePreis(Table table, Woche w, int zeile) throws MalformedURLException {

        Cell b0 = new Cell();
        Paragraph preis = new Paragraph("Preis:");
        preis.setFontSize(14F);
        b0.add(preis);
        table.addCell(b0);

        for (int i = 0; i < 5; i++) {
            Speise dieseSpeise = w.getTage()[i].getSpeisen()[zeile];
            Cell b1 = new Cell();
            b1.add(new Paragraph(DecimalFormat.getCurrencyInstance().format(dieseSpeise.getPreis())).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.CENTER));
            table.addCell(b1);
        }
    }

    private static Image createImage(float imageHeigth, float imageWidth, String imageName) throws MalformedURLException {
        // Creating an ImageData object
        String imFile = IMAGE_PATH + imageName;
        ImageData data = ImageDataFactory.create(imFile);
        // Creating an Image object
        Image image = new Image(data);
        image.setHeight(imageHeigth);
        image.setWidth(imageWidth);
        image.setMarginLeft(5);
        image.setMarginTop(5);

        return image;
    }

    public static void writePDF(Report[] alleReports) throws FileNotFoundException {
        String dest = REPORT_PATH + "Reports.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        for (Report report : alleReports) {
            document.add(new Paragraph(report.getBeschreibung()));
            document.add(new Paragraph(report.getInhalt()));
        }
        document.close();
    }
}
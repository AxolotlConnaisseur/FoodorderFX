package com.example.foodorderfx.pdf;


import com.example.foodorderfx.gui.SpeiseplanController;
import com.example.foodorderfx.used.Gericht;
import com.example.foodorderfx.used.Speiseplan;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Dieses Klasse erzeugt ein PDF File für einen Speiseplan
 */

public class FranziReport implements Serializable {
    static final long serialVersionUID = 1L;

    public String dest = "C:\\Users\\Franzi\\OneDrive\\Desktop\\" + "Reports.pdf";
    private Speiseplan speiseplan;
    public static Gericht[] gerichteA = new Gericht[5];
    public static Gericht[] gerichteB = new Gericht[5];
    public static final float IMAGE_HEIGTH = 115F;
    public static final float IMAGE_WIDTH = 130F;

    public FranziReport(Speiseplan speiseplan) {
        this.speiseplan = speiseplan;
    }

    public void oeffnePdf() throws IOException {
        if (Desktop.isDesktopSupported()) {
            System.out.println("Hallo");
            Desktop d = Desktop.getDesktop();
            d.open(new File(dest));
        }

    }


    public void druckePdfSpeiseplan() {
        try {
            PdfWriter writer = new PdfWriter(dest);
            // Creating a PdfDocument
            PdfDocument pdf = new PdfDocument(writer);
            pdf.setDefaultPageSize(PageSize.A4.rotate());
            Document document = new Document(pdf);
            float[] pointColumnWidths = {290F, 150F, 150F, 150F, 150F, 150F};
            Table table = new Table(pointColumnWidths);

            addCellWithParagraph(table, "KW " + speiseplan.getKw(), 16F);


            for (LocalDate datum : SpeiseplanController.gewaehlteWoche) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM");
                addCellWithParagraph(table, datum.format(dtf), 16F);
            }
            addCellWithParagraph(table, "", 16F);

            String[] wochentage = new String[]{"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"};

            for (String tag : wochentage) {
                addCellWithParagraph(table, tag, 16F);
            }

            erstelleReihenVonGericht(table, "Gericht A", gerichteA);
            erstelleReihenVonGericht(table, "Gericht B", gerichteB);

            document.add(table);
            document.close();
            oeffnePdf();

            System.out.println("Speiseplan erstellt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void erstelleReihenVonGericht(Table table, String gerichtKategorie, Gericht[] gerichte) throws MalformedURLException {

        addCellWithParagraph(table, gerichtKategorie, 14F);

        for (Gericht gericht : gerichte) {
            Image img = createImage(IMAGE_HEIGTH, IMAGE_WIDTH, gericht.gerichtImg.getUrl());
            addCellWithImageAndParagraph(table, img,
                    gericht.gerichtName, 14F);

        }
        addCellWithParagraph(table, "Preis:", 14F);

        for (Gericht gericht : gerichte) {
            addCellWithParagraph(table, String.valueOf(gericht.gerichtPreis), 14F);

        }
    }

    private void addCellWithImageAndParagraph(Table table, Image image, String inhalt, float fontSize) {
        Cell cell = new Cell();
        Paragraph paragraph = new Paragraph(inhalt);
        paragraph.setFontSize(fontSize);
        image.setMarginLeft(5F);
        image.setMarginRight(5F);
        image.setMarginTop(5F);
        cell.add(image);
        cell.add(paragraph);
        table.addCell(cell);
    }

    private void addCellWithParagraph(Table table, String inhalt, float fontSize) {
        Cell cell = new Cell();
        Paragraph paragraph = new Paragraph(inhalt);
        paragraph.setFontSize(fontSize);
        cell.add(paragraph);
        table.addCell(cell);
    }

    private static Image createImage(float imageHeigth, float imageWidth, String imgPfad) throws MalformedURLException {
        ImageData data = ImageDataFactory.create(imgPfad);
        Image image = new Image(data);
        image.setHeight(imageHeigth);
        image.setWidth(imageWidth);

        return image;
    }

    public void druckeSpeiseplan() {

        System.out.println("Speiseplan für KW " + speiseplan.getKw());

        System.out.println("Montag");

        System.out.println(speiseplan.getGericht(0));
        System.out.println(speiseplan.getGericht(5));

        System.out.println("Dienstag");
        System.out.println(speiseplan.getGericht(1));
        System.out.println(speiseplan.getGericht(6));

        System.out.println("Mittwoch");
        System.out.println(speiseplan.getGericht(2));
        System.out.println(speiseplan.getGericht(7));

        System.out.println("Donnerstag");
        System.out.println(speiseplan.getGericht(3));
        System.out.println(speiseplan.getGericht(8));

        System.out.println("Freitag");
        System.out.println(speiseplan.getGericht(4));
        System.out.println(speiseplan.getGericht(9));


    }

}

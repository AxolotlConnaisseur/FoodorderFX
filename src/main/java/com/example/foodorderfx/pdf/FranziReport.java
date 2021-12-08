package com.example.foodorderfx.pdf;


import com.example.foodorderfx.gui.ClickedControls;
import com.example.foodorderfx.gui.SpeiseplanController;
import com.example.foodorderfx.logic.Woche;
import com.example.foodorderfx.output.Report;
import com.example.foodorderfx.used.Gericht;
import com.example.foodorderfx.used.Speiseplan;
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

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;

// Dieses Klasse erzeugt ein PDF File fuer einen Speiseplan
public class FranziReport {

    private Speiseplan speiseplan;
    public static final String REPORT_PATH = "src/main/resources/com/example/foodorderfx/";
    public static final String IMAGE_PATH = REPORT_PATH + "Bilder/";
    public static final float IMAGE_HEIGTH = 115F;
    public static final float IMAGE_WIDTH = 130F;

    public FranziReport(Speiseplan speiseplan) {
        this.speiseplan = speiseplan;
    }


    public void druckePdfSpeiseplan(ArrayList<String> bilderPfade) {

        String dest = "C:\\Users\\Franzi\\FoodorderFX\\src\\main\\resources\\com\\example\\foodorderfx\\generated\\" + "Reports.pdf";
        try {
            PdfWriter writer = new PdfWriter(dest);
            // Creating a PdfDocument
            PdfDocument pdf = new PdfDocument(writer);
            pdf.setDefaultPageSize(PageSize.A4.rotate());
            Document document = new Document(pdf);
            float[] pointColumnWidths = {190F, 150F, 150F, 150F, 150F, 150F};
            Table table = new Table(pointColumnWidths);

            addCellWithParagraph(table, "KW " + speiseplan.getKw(), 16F);


            String[] wochendaten = {"1", "2", "3", "4", "5"};
            for (String datum : wochendaten) {
                addCellWithParagraph(table, datum, 16F);
            }
            addCellWithParagraph(table, "", 16F);

            String[] wochentage = new String[]{"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag"};

            for (String tag : wochentage) {
                addCellWithParagraph(table, tag, 16F);
            }

            addCellWithParagraph(table, "Gericht A", 16F);
          //ArrayList<Gericht> gerichteA = new ArrayList<>();
          //for (int i = 0; i < 5; i++) {
          //    gerichteA.add(speiseplan.)
          //}
            for (int i = 0; i < 5; i++) {

                Image img = createImage(IMAGE_HEIGTH, IMAGE_WIDTH,bilderPfade.get(0));
                addCellWithImageAndParagraph(table, img,
                        speiseplan.getGericht(i).gerichtName, 14F);

            }

            //erstelleZeileGericht(table, w, "Gericht A", 0);
            //erstelleZeilePreis(table, w, 0);
            //erstelleZeileGericht(table, w, "Gericht B", 1);
            //erstelleZeilePreis(table, w, 1);

            document.add(table);
            document.close();


            System.out.println("Speiseplan erstellt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    private void addCellWithImageAndParagraph(Table table, Image image, String inhalt, float fontSize) {
        Cell cell = new Cell();
        Paragraph paragraph = new Paragraph(inhalt);
        paragraph.setFontSize(fontSize);
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
        // Creating an ImageData object
        ImageData data = ImageDataFactory.create(imgPfad);
        // Creating an Image object
        Image image = new Image(data);
        image.setHeight(imageHeigth);
        image.setWidth(imageWidth);
        image.setMarginLeft(5);
        image.setMarginTop(5);

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

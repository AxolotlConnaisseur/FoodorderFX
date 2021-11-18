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


import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class PDFWriter {
    public static void printReports(Report[] reports) throws FileNotFoundException {

        String dest = "wochenplanPDF\\Reports.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        for (Report report : reports) {
            document.add(new Paragraph(report.getInhalt()));
        }
        document.close();
    }

    public static void printWochenplan(Woche w) throws FileNotFoundException, MalformedURLException {
        // Creating a PdfWriter
        String dest = "wochenplanPDF\\Speiseplan.pdf";
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(PageSize.A4.rotate());
        Document document = new Document(pdf);
        float[] pointColumnWidths = {150F, 150F, 150F, 150F, 150F, 150F};
        Table table = new Table(pointColumnWidths);

        Cell a0 = new Cell();
        Paragraph p0 = new Paragraph(w.getKalenderWoche());
        p0.setFontSize(18F);
        a0.add(p0);
        table.addCell(a0);

        Cell a1 = new Cell();
        Paragraph p1 = new Paragraph("Montag");
        p1.setFontSize(18F);
        a1.add(p1);
        table.addCell(a1);

        Cell a2 = new Cell();
        Paragraph p2 = new Paragraph("Dienstag");
        p2.setFontSize(18F);
        a2.add(p2);
        table.addCell(a2);

        Cell a3 = new Cell();
        Paragraph p3 = new Paragraph("Mittwoch");
        p3.setFontSize(18F);
        a3.add(p3);
        table.addCell(a3);

        Cell a4 = new Cell();
        Paragraph p4 = new Paragraph("Donnerstag");
        p4.setFontSize(18F);
        a4.add(p4);
        table.addCell(a4);

        Cell a5 = new Cell();
        Paragraph p5 = new Paragraph("Freitag");
        p5.setFontSize(18F);
        a5.add(p5);
        table.addCell(a5);


        float imageHeigth = 100F;
        float imageWidth = 120F;

        Cell b0 = new Cell();
        Paragraph pMenuA = new Paragraph("Menü A");
        pMenuA.setFontSize(18F);
        b0.add(pMenuA);
        table.addCell(b0);

        {
            Speise dieseSpeise = w.getTage()[0].getSpeisen()[0];
            Cell b1 = new Cell();
            implementImage(imageHeigth, imageWidth, b1, dieseSpeise.getBild());
            b1.add(new Paragraph(dieseSpeise.getName()));
            b1.add(new Paragraph(dieseSpeise.getPreis() + "€"));
            table.addCell(b1);
        }
        {
            Speise dieseSpeise = w.getTage()[1].getSpeisen()[0];
            Cell b2 = new Cell();
            implementImage(imageHeigth, imageWidth, b2, dieseSpeise.getBild());
            b2.add(new Paragraph(dieseSpeise.getName()));
            b2.add(new Paragraph(String.format("%.2f€", dieseSpeise.getPreis())));
            table.addCell(b2);
        }
        {
            Speise dieseSpeise = w.getTage()[2].getSpeisen()[0];
            Cell b3 = new Cell();
            implementImage(imageHeigth, imageWidth, b3, dieseSpeise.getBild());
            b3.add(new Paragraph(dieseSpeise.getName()));
            b3.add(new Paragraph(String.format("%.2f€", dieseSpeise.getPreis())));
            table.addCell(b3);
        }
        {
            Speise dieseSpeise = w.getTage()[3].getSpeisen()[0];
            Cell b4 = new Cell();
            implementImage(imageHeigth, imageWidth, b4, dieseSpeise.getBild());
            b4.add(new Paragraph(dieseSpeise.getName()));
            b4.add(new Paragraph(String.format("%.2f€", dieseSpeise.getPreis())));
            table.addCell(b4);
        }
        {
            Speise dieseSpeise = w.getTage()[4].getSpeisen()[0];
            Cell b5 = new Cell();
            implementImage(imageHeigth, imageWidth, b5, dieseSpeise.getBild());
            b5.add(new Paragraph(dieseSpeise.getName()));
            b5.add(new Paragraph(String.format("%.2f€", dieseSpeise.getPreis())));
            table.addCell(b5);
        }

        Cell c0 = new Cell();
        Paragraph pMenuB = new Paragraph("Menü B");
        pMenuB.setFontSize(18F);
        c0.add(pMenuB);
        table.addCell(c0);
        {
            Speise dieseSpeise = w.getTage()[0].getSpeisen()[1];
            Cell c1 = new Cell();
            implementImage(imageHeigth, imageWidth, c1, dieseSpeise.getBild());
            c1.add(new Paragraph(dieseSpeise.getName()));
            c1.add(new Paragraph(String.format("%.2f€", dieseSpeise.getPreis())));
            table.addCell(c1);
        }
        {
            Speise dieseSpeise = w.getTage()[1].getSpeisen()[1];
            Cell c2 = new Cell();
            implementImage(imageHeigth, imageWidth, c2, dieseSpeise.getBild());
            c2.add(new Paragraph(dieseSpeise.getName()));
            c2.add(new Paragraph(String.format("%.2f€", dieseSpeise.getPreis())));
            table.addCell(c2);
        }
        {
            Speise dieseSpeise = w.getTage()[2].getSpeisen()[1];
            Cell c3 = new Cell();
            implementImage(imageHeigth, imageWidth, c3, dieseSpeise.getBild());
            c3.add(new Paragraph(dieseSpeise.getName()));
            c3.add(new Paragraph(String.format("%.2f€", dieseSpeise.getPreis())));
            table.addCell(c3);
        }
        {
            Speise dieseSpeise = w.getTage()[3].getSpeisen()[1];
            Cell c4 = new Cell();
            implementImage(imageHeigth, imageWidth, c4, dieseSpeise.getBild());
            c4.add(new Paragraph(dieseSpeise.getName()));
            c4.add(new Paragraph(String.format("%.2f€", dieseSpeise.getPreis())));
            table.addCell(c4);
        }
        {
            Speise dieseSpeise = w.getTage()[4].getSpeisen()[1];
            Cell c5 = new Cell();
            implementImage(imageHeigth, imageWidth, c5, dieseSpeise.getBild());
            c5.add(new Paragraph(dieseSpeise.getName()));
            c5.add(new Paragraph(String.format("%.2f€", dieseSpeise.getPreis())));
            table.addCell(c5);
        }
        table.setMarginTop(100F);
        table.setHeight(350F);
        document.add(table);
        document.close();


        System.out.println("Speiseplan erstellt");
    }

    private static void implementImage(float imageHeigth, float imageWidth, Cell b1, String imageName) throws MalformedURLException {
        // Creating an ImageData object
        String imFile = "wochenplanPDF\\Bilder\\" + imageName;
        ImageData data = ImageDataFactory.create(imFile);
        // Creating an Image object
        Image image = new Image(data);
        image.setHeight(imageHeigth);
        image.setWidth(imageWidth);
        image.setMarginLeft(5);
        image.setMarginTop(5);
        b1.add(image);
    }

    public void writePDF(Report[] alleReports) {

    }
}
package com.example.foodorderfx.temp;


import com.itextpdf.io.IOException;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class IText7Tests {

    public static void main(String args[]) throws Exception {

        createPdf();

    }

    private static com.itextpdf.layout.element.Image scaleImage(String path) throws IOException, java.io.IOException {

        java.awt.Image awtImage = ImageIO.read(new URL("file:" + path));

        int scaledWidth = 200;
        int scaledHeight = awtImage.getHeight(null) / (awtImage.getWidth(null) / scaledWidth);

        BufferedImage scaledAwtImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = scaledAwtImage.createGraphics();
        g.drawImage(awtImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();

        com.itextpdf.io.source.ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ImageIO.write(scaledAwtImage, "jpeg", bout);
        byte[] imageBytes = bout.toByteArray();

        ImageData imageData = ImageDataFactory.create(imageBytes);
        return new com.itextpdf.layout.element.Image(imageData);
    }


    private static void createPdf() throws java.io.IOException {

        String dest = "";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        String ravioliPng = "/Users/oliveroppitz/IdeaProjects/FoodOrder/src/main/resources/de/die_gfi/ab2020/foodorder/speisen/ravioli.png";
        com.itextpdf.layout.element.Image itextImage = scaleImage(ravioliPng);
        document.add(itextImage);

        Paragraph paragraph1 = new Paragraph("Some text for the first paragraph");
        document.add(paragraph1);

        Paragraph paragraph2 = new Paragraph("More text for the second paragraph!!!!!!");
        document.add(paragraph2);

        document.close();
        System.out.println("Document closed.");
    }

}
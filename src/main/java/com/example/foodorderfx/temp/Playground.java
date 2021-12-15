package com.example.foodorderfx.temp;

public class Playground {

    String testString = "1";


    public static void main(String[] args) {


        String text = "1,00 €"; // true

        double preis = calculatePreis(text);

        String preisAlsString = String.format("%.2f €", preis);
        System.out.println(preisAlsString);

    }

    private static double calculatePreis(String text) {

        double preisDouble;
        String preis = normalizePreis(text);
        try {
             preisDouble = Double.parseDouble(preis);
        } catch(NumberFormatException e) {
            preisDouble = -1;
        }
        return preisDouble;
    }

    private static String normalizePreis(String text) {

        String result = text.replaceAll("\\h€", "");

        if (result.contains(",")) {
            result = result.replace(',', '.');
        }
        return result;
    }

}

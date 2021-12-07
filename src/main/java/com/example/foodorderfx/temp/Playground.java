package com.example.foodorderfx.temp;

public class Playground {
    public static void main(String[] args) {

        String s = "5,0€";
        String parsedPreis = s.replace(',', '.');
        String[] correctedInput = parsedPreis.split("\\h?€");
        System.out.println(correctedInput[0]);
    }
}

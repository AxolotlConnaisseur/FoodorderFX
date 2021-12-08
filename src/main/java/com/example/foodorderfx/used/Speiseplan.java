package com.example.foodorderfx.used;

public class Speiseplan {

    public Gericht[] gerichte;
    private int kw;

    public Speiseplan() {
        this.gerichte = new Gericht[10];
    }

    public void addGericht(int index, Gericht gericht) {

        this.gerichte[index] = gericht;

    }

    public Gericht getGericht(int index) {

        return this.gerichte[index];

    }

    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
    }
}
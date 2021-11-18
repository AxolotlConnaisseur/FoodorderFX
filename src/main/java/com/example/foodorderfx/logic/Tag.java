package com.example.foodorderfx.logic;

public class Tag {
    private String wochentag;
    private Speise[] speisen;

    public Tag(String wochentag) {
        this.wochentag = wochentag;
    }

    public Speise[] getSpeisen() {
        return speisen;
    }

    public void setSpeisen(Speise[] speisen) {
        this.speisen = speisen;
    }
}

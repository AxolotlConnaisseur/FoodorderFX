package com.example.foodorderfx.used;


import javafx.scene.image.Image;

import java.io.Serializable;


public class Gericht implements Serializable {
    static final long serialVersionUID = 1L;
    public String gerichtName;
    public Image gerichtImg;
    public String gerichtPreis;

    public Gericht(String gerichtName, Image gerichtImg, String gerichtPreis) {
        this.gerichtName = gerichtName;
        this.gerichtImg = gerichtImg;
        this.gerichtPreis = gerichtPreis;
    }

    public Gericht(String gerichtName, String gerichtPreis) {
        this.gerichtName = gerichtName;
        this.gerichtPreis = gerichtPreis;
    }

    public Gericht() {
    }

    @Override
    public String toString() {
        return "Gericht:" +
                "gerichtName='" + gerichtName + '\'' +
                ", gerichtPreis='" + gerichtPreis + '\'';
    }

    public String getGerichtName() {
        return gerichtName;
    }

    public void setGerichtName(String gerichtName) {
        this.gerichtName = gerichtName;
    }

    public Image getGerichtImg() {
        return gerichtImg;
    }

    public void setGerichtImg(Image gerichtImg) {
        this.gerichtImg = gerichtImg;
    }

    public String getGerichtPreis() {
        return gerichtPreis;
    }

    public void setGerichtPreis(String gerichtPreis) {
        this.gerichtPreis = gerichtPreis;
    }
}

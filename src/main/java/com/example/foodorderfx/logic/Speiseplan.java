package com.example.foodorderfx.logic;



import com.example.foodorderfx.output.Report;

import java.util.ArrayList;

public class Speiseplan {

    ArrayList<Speise> montag;
    ArrayList<Speise> dienstag;
    ArrayList<Speise> mittwoch;
    ArrayList<Speise> donnerstag;
    ArrayList<Speise> freitag;

    public Speiseplan(ArrayList<Speise> montag, ArrayList<Speise> dienstag, ArrayList<Speise> mittwoch, ArrayList<Speise> donnerstag, ArrayList<Speise> freitag) {

        this.montag = montag;
        this.dienstag = dienstag;
        this.mittwoch = mittwoch;
        this.donnerstag = donnerstag;
        this.freitag = freitag;

    }

    public ArrayList<Speise> getMontag() {
        return montag;
    }

    public ArrayList<Speise> getDienstag() {
        return dienstag;
    }

    public ArrayList<Speise> getMittwoch() {
        return mittwoch;
    }

    public ArrayList<Speise> getDonnerstag() {
        return donnerstag;
    }

    public ArrayList<Speise> getFreitag() {
        return freitag;
    }


    void druckeBestellungListe() {

        Report.druckeBestellungsListe(this);

    }

}

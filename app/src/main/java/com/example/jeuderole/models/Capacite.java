package com.example.jeuderole.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

public class Capacite {

    private  long id;
private String abrev;
private String nomComplet;
private Integer maxPoints;

    public Capacite(String abrev, String nomComplet, Integer maxPoints) {
        this.abrev = abrev;
        this.nomComplet = nomComplet;
        this.maxPoints = maxPoints;
    }

    public Capacite(long id, String abrev, String nomComplet, Integer maxPoints) {
        this.id = id;
        this.abrev = abrev;
        this.nomComplet = nomComplet;
        this.maxPoints = maxPoints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public Integer getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }
}

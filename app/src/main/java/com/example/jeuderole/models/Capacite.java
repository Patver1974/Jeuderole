package com.example.jeuderole.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

public class Capacite {

    private long id;
    private String categorie;
    private String abrev;
    private String nomComplet;
    private Integer maxPoints;
    private String degats;

    private Integer pointActuel;
    private String regleSpeciale;
    private String initiation;
    private String entrainement;
    private String maitrise;
    private Integer initiationPoint;
    private Integer entrainementPoint;
    private Integer maitrisePoint;

    public Capacite(String categorie, String abrev, String nomComplet, Integer maxPoints, String degats, Integer pointActuel, String regleSpeciale, String initiation, String entrainement, String maitrise, Integer initiationPoint, Integer entrainementPoint, Integer maitrisePoint) {
        this.categorie = categorie;
        this.abrev = abrev;
        this.nomComplet = nomComplet;
        this.maxPoints = maxPoints;
        this.degats = degats;
        this.pointActuel = pointActuel;
        this.regleSpeciale = regleSpeciale;
        this.initiation = initiation;
        this.entrainement = entrainement;
        this.maitrise = maitrise;
        this.initiationPoint = initiationPoint;
        this.entrainementPoint = entrainementPoint;
        this.maitrisePoint = maitrisePoint;
    }

    public Capacite(long id, String categorie, String abrev, String nomComplet, Integer maxPoints, String degats, Integer pointActuel, String regleSpeciale, String initiation, String entrainement, String maitrise, Integer initiationPoint, Integer entrainementPoint, Integer maitrisePoint) {
        this.id = id;
        this.categorie = categorie;
        this.abrev = abrev;
        this.nomComplet = nomComplet;
        this.maxPoints = maxPoints;
        this.degats = degats;
        this.pointActuel = pointActuel;
        this.regleSpeciale = regleSpeciale;
        this.initiation = initiation;
        this.entrainement = entrainement;
        this.maitrise = maitrise;
        this.initiationPoint = initiationPoint;
        this.entrainementPoint = entrainementPoint;
        this.maitrisePoint = maitrisePoint;
    }

    public Capacite(long id, String categorie, String abrev, String nomComplet, Integer maxPoints) {
        this.id = id;
        this.categorie = categorie;
        this.abrev = abrev;
        this.nomComplet = nomComplet;
        this.maxPoints = maxPoints;
    }

    public Capacite(String categorie, String abrev, String nomComplet, Integer maxPoints) {
        this.categorie = categorie;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getPointActuel() {
        return pointActuel;
    }

    public void setPointActuel(Integer pointActuel) {
        this.pointActuel = pointActuel;
    }

    public String getRegleSpeciale() {
        return regleSpeciale;
    }

    public void setRegleSpeciale(String regleSpeciale) {
        this.regleSpeciale = regleSpeciale;
    }

    public String getInitiation() {
        return initiation;
    }

    public void setInitiation(String initiation) {
        this.initiation = initiation;
    }

    public String getEntrainement() {
        return entrainement;
    }

    public void setEntrainement(String entrainement) {
        this.entrainement = entrainement;
    }

    public String getMaitrise() {
        return maitrise;
    }

    public void setMaitrise(String maitrise) {
        this.maitrise = maitrise;
    }

    public Integer getInitiationPoint() {
        return initiationPoint;
    }

    public void setInitiationPoint(Integer initiationPoint) {
        this.initiationPoint = initiationPoint;
    }

    public Integer getEntrainementPoint() {
        return entrainementPoint;
    }

    public void setEntrainementPoint(Integer entrainementPoint) {
        this.entrainementPoint = entrainementPoint;
    }

    public Integer getMaitrisePoint() {
        return maitrisePoint;
    }

    public void setMaitrisePoint(Integer maitrisePoint) {
        this.maitrisePoint = maitrisePoint;
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

    public String getDegats() {
        return degats;
    }

    public void setDegats(String degats) {
        this.degats = degats;
    }
}


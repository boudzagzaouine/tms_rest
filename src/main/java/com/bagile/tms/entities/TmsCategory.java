package com.bagile.tms.entities;

import javax.persistence.*;

public class TmsCategory {
    private double consommationMoy;
    private int idCategory;
    private double hauteur;
    private double largeur;
    private DoorType porte;
    private double profondeur;
    private double tonnage;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_CategoryId", unique = true, nullable = false, precision = 10, scale = 0)

    public double getConsommationMoy() {
        return consommationMoy;
    }

    public void setConsommationMoy(double consommationMoy) {
        this.consommationMoy = consommationMoy;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public double getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(double profondeur) {
        this.profondeur = profondeur;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }
}

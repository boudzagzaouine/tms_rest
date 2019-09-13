package com.bagile.tms.entities;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="tms_vehiculecategorie")
public class TmsVehicleCategory   {


    @Id
    @GeneratedValue
    @Column(name = "tms_vehiculecategorieid")
    private int tmsVehicleCategoryid;
    @Column(name = "tms_vehiculecategoriecode")
    private String tmsVehicleCategorycode;
    @Column(name = "tms_vehiculecategorieconsumption")
    private  String tmsVehicleCategoryconsumption;
    @Column(name = "tms_vehiculecategorieweight")
    private BigDecimal tmsVehicleCategoryweight;
    @Column(name = "tms_vehiculecategoriewidth")
    private  BigDecimal tmsVehicleCategorywidth;
    @Column(name = "tms_vehiculecategoriedepth")
    private BigDecimal tmsVehicleCategorydepth;
    @Column(name = "tms_vehiculecategorietonnage")
    private BigDecimal tmsVehicleCategorytonnage;
    @Column(name = "tms_vehiculecategorieemptyWeight")
    private  BigDecimal tmsVehicleCategoryemptyWeight;
    @Column(name = "tms_vehiculecategorietotalWeight")
    private BigDecimal tmsVehicleCategorytotalWeight;



    public TmsVehicleCategory() {
    }

    public int getTmsVehicleCategoryid() {
        return tmsVehicleCategoryid;
    }

    public void setTmsVehicleCategoryid(int tmsVehicleCategoryid) {
        this.tmsVehicleCategoryid = tmsVehicleCategoryid;
    }

    public String getTmsVehicleCategorycode() {
        return tmsVehicleCategorycode;
    }

    public void setTmsVehicleCategorycode(String tmsVehicleCategorycode) {
        this.tmsVehicleCategorycode = tmsVehicleCategorycode;
    }

    public String getTmsVehicleCategoryconsumption() {
        return tmsVehicleCategoryconsumption;
    }

    public void setTmsVehicleCategoryconsumption(String tmsVehicleCategoryconsumption) {
        this.tmsVehicleCategoryconsumption = tmsVehicleCategoryconsumption;
    }

    public BigDecimal getTmsVehicleCategoryweight() {
        return tmsVehicleCategoryweight;
    }

    public void setTmsVehicleCategoryweight(BigDecimal tmsVehicleCategoryweight) {
        this.tmsVehicleCategoryweight = tmsVehicleCategoryweight;
    }

    public BigDecimal getTmsVehicleCategorywidth() {
        return tmsVehicleCategorywidth;
    }

    public void setTmsVehicleCategorywidth(BigDecimal tmsVehicleCategorywidth) {
        this.tmsVehicleCategorywidth = tmsVehicleCategorywidth;
    }

    public BigDecimal getTmsVehicleCategorydepth() {
        return tmsVehicleCategorydepth;
    }

    public void setTmsVehicleCategorydepth(BigDecimal tmsVehicleCategorydepth) {
        this.tmsVehicleCategorydepth = tmsVehicleCategorydepth;
    }

    public BigDecimal getTmsVehicleCategorytonnage() {
        return tmsVehicleCategorytonnage;
    }

    public void setTmsVehicleCategorytonnage(BigDecimal tmsVehicleCategorytonnage) {
        this.tmsVehicleCategorytonnage = tmsVehicleCategorytonnage;
    }

    public BigDecimal getTmsVehicleCategoryemptyWeight() {
        return tmsVehicleCategoryemptyWeight;
    }

    public void setTmsVehicleCategoryemptyWeight(BigDecimal tmsVehicleCategoryemptyWeight) {
        this.tmsVehicleCategoryemptyWeight = tmsVehicleCategoryemptyWeight;
    }

    public BigDecimal getTmsVehicleCategorytotalWeight() {
        return tmsVehicleCategorytotalWeight;
    }

    public void setTmsVehicleCategorytotalWeight(BigDecimal tmsVehicleCategorytotalWeight) {
        this.tmsVehicleCategorytotalWeight = tmsVehicleCategorytotalWeight;
    }
}

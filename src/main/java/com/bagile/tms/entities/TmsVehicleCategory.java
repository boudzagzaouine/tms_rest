package com.bagile.tms.entities;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="tms_vehiculecategorie")
public class TmsVehicleCategory  extends EmsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehiculecategorieid", allocationSize = 1)
    @Column(name = "tms_vehiculecategorieid", unique = true, nullable = false, precision = 10, scale = 0)
    private int tmsVehicleCategoryId;
    @Column(name = "tms_vehiculecategoriecode")
    private String tmsVehicleCategoryCode;
    @Column(name = "tms_vehiculecategorieconsumption")
    private  String tmsVehicleCategoryConsumption;
    @Column(name = "tms_vehiculecategorieweight")
    private BigDecimal tmsVehicleCategoryWeight;
    @Column(name = "tms_vehiculecategoriewidth")
    private  BigDecimal tmsVehicleCategoryWidth;
    @Column(name = "tms_vehiculecategoriedepth")
    private BigDecimal tmsVehicleCategoryDepth;
    @Column(name = "tms_vehiculecategorietonnage")
    private BigDecimal tmsVehicleCategoryTonnage;
    @Column(name = "tms_vehiculecategorieemptyweight")
    private  BigDecimal tmsVehicleCategoryEmptyWeight;
    @Column(name = "tms_vehiculecategorietotalweight")
    private BigDecimal tmsVehicleCategoryTotalWeight;



    public TmsVehicleCategory() {
    }

    public int getTmsVehicleCategoryId() {
        return tmsVehicleCategoryId;
    }

    public void setTmsVehicleCategoryId(int tmsVehicleCategoryId) {
        this.tmsVehicleCategoryId = tmsVehicleCategoryId;
    }

    public String getTmsVehicleCategoryCode() {
        return tmsVehicleCategoryCode;
    }

    public void setTmsVehicleCategoryCode(String tmsVehicleCategoryCode) {
        this.tmsVehicleCategoryCode = tmsVehicleCategoryCode;
    }

    public String getTmsVehicleCategoryConsumption() {
        return tmsVehicleCategoryConsumption;
    }

    public void setTmsVehicleCategoryConsumption(String tmsVehicleCategoryConsumption) {
        this.tmsVehicleCategoryConsumption = tmsVehicleCategoryConsumption;
    }

    public BigDecimal getTmsVehicleCategoryWeight() {
        return tmsVehicleCategoryWeight;
    }

    public void setTmsVehicleCategoryWeight(BigDecimal tmsVehicleCategoryWeight) {
        this.tmsVehicleCategoryWeight = tmsVehicleCategoryWeight;
    }

    public BigDecimal getTmsVehicleCategoryWidth() {
        return tmsVehicleCategoryWidth;
    }

    public void setTmsVehicleCategoryWidth(BigDecimal tmsVehicleCategoryWidth) {
        this.tmsVehicleCategoryWidth = tmsVehicleCategoryWidth;
    }

    public BigDecimal getTmsVehicleCategoryDepth() {
        return tmsVehicleCategoryDepth;
    }

    public void setTmsVehicleCategoryDepth(BigDecimal tmsVehicleCategoryDepth) {
        this.tmsVehicleCategoryDepth = tmsVehicleCategoryDepth;
    }

    public BigDecimal getTmsVehicleCategoryTonnage() {
        return tmsVehicleCategoryTonnage;
    }

    public void setTmsVehicleCategoryTonnage(BigDecimal tmsVehicleCategoryTonnage) {
        this.tmsVehicleCategoryTonnage = tmsVehicleCategoryTonnage;
    }

    public BigDecimal getTmsVehicleCategoryEmptyWeight() {
        return tmsVehicleCategoryEmptyWeight;
    }

    public void setTmsVehicleCategoryEmptyWeight(BigDecimal tmsVehicleCategoryEmptyWeight) {
        this.tmsVehicleCategoryEmptyWeight = tmsVehicleCategoryEmptyWeight;
    }

    public BigDecimal getTmsVehicleCategoryTotalWeight() {
        return tmsVehicleCategoryTotalWeight;
    }

    public void setTmsVehicleCategoryTotalWeight(BigDecimal tmsVehicleCategoryTotalWeight) {
        this.tmsVehicleCategoryTotalWeight = tmsVehicleCategoryTotalWeight;
    }
}

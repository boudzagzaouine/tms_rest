package com.bagile.tms.entities;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="tms_vehiclecategory")
public class TmsVehicleCategory  extends EmsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehicle_category_id", allocationSize = 1)
    @Column(name = "tms_vehiclecategoryid", unique = true, nullable = false, precision = 10, scale = 0)
    private long tmsVehicleCategoryId;
    @Column(name = "tms_vehiclecategorycode",  unique = true, nullable = false, length = 90)
    private String tmsVehicleCategoryCode;
    @Column(name = "tms_vehiclecategoryconsumption")
    private  String tmsVehicleCategoryConsumption;
    @Column(name = "tms_vehiclecategoryweight")
    private BigDecimal tmsVehicleCategoryWeight;
    @Column(name = "tms_vehiclecategorywidth")
    private  BigDecimal tmsVehicleCategoryWidth;
    @Column(name = "tms_vehiclecategorydepth")
    private BigDecimal tmsVehicleCategoryDepth;
    @Column(name = "tms_vehiclecategorytonnage")
    private BigDecimal tmsVehicleCategoryTonnage;
    @Column(name = "tms_vehiclecategoryemptyweight")
    private  BigDecimal tmsVehicleCategoryEmptyWeight;
    @Column(name = "tms_vehiclecategorytotalweight")
    private BigDecimal tmsVehicleCategoryTotalWeight;



    public TmsVehicleCategory() {
    }

    public long getTmsVehicleCategoryId() {
        return tmsVehicleCategoryId;
    }

    public void setTmsVehicleCategoryId(long tmsVehicleCategoryId) {
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

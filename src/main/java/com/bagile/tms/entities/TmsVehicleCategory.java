package com.bagile.tms.entities;

import com.bagile.tms.dto.DoorType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tms_vehiclecategory", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_vehiclecategoryId"}))
public class TmsVehicleCategory {
    private long tmsVehicleCategoryId;
    private BigDecimal tmsVehicleCategoryConsumption;
    private BigDecimal tmsVehicleCategoryWeight;
    private BigDecimal tmsVehicleCategoryWidth;
    private TmsDoorType tmsVehicleCategoryDoor;
    private BigDecimal tmsVehicleCategoryDepth;
    private BigDecimal tmsVehicleCategoryTonnage;
    private BigDecimal tmsVehicleCategoryEmptyWeight;
    private BigDecimal tmsVehicleCategoryTotalWeight;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tms_vehiclecategorysequence")
    @Column(name = "tms_vehiclecategoryId")


    public long getTmsVehicleCategoryId() {
        return tmsVehicleCategoryId;
    }

    public void setTmsVehicleCategoryId(long tmsVehicleCategoryId) {
        this.tmsVehicleCategoryId = tmsVehicleCategoryId;
    }


    @Column(name = "tms_vehiclecategorycunsumption")
    public BigDecimal getTmsVehicleCategoryConsumption() {
        return tmsVehicleCategoryConsumption;
    }

    public void setTmsVehicleCategoryConsumption(BigDecimal tmsVehicleCategoryConsumption) {
        this.tmsVehicleCategoryConsumption = tmsVehicleCategoryConsumption;
    }

    @Column(name = "tms_vehiclecategoryweight")
    public BigDecimal getTmsVehicleCategoryWeight() {
        return tmsVehicleCategoryWeight;
    }

    public void setTmsVehicleCategoryWeight(BigDecimal tmsVehicleCategoryWeight) {
        this.tmsVehicleCategoryWeight = tmsVehicleCategoryWeight;
    }


    @Column(name = "tms_vehiclecategorywidth")
    public BigDecimal getTmsVehicleCategoryWidth() {
        return tmsVehicleCategoryWidth;
    }

    public void setTmsVehicleCategoryWidth(BigDecimal tmsVehicleCategoryWidth) {
        this.tmsVehicleCategoryWidth = tmsVehicleCategoryWidth;
    }


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclecategorydoorid")
    public TmsDoorType getTmsVehicleCategoryDoor() {
        return tmsVehicleCategoryDoor;
    }

    public void setTmsVehicleCategoryDoor(TmsDoorType tmsVehicleCategoryDoor) {
        this.tmsVehicleCategoryDoor = tmsVehicleCategoryDoor;
    }

    @Column(name = "tms_vehiclecategorydepth")
    public BigDecimal getTmsVehicleCategoryDepth() {
        return tmsVehicleCategoryDepth;
    }

    public void setTmsVehicleCategoryDepth(BigDecimal tmsVehicleCategoryDepth) {
        this.tmsVehicleCategoryDepth = tmsVehicleCategoryDepth;
    }

    @Column(name = "tms_vehiclecategorytonnage")
    public BigDecimal getTmsVehicleCategoryTonnage() {
        return tmsVehicleCategoryTonnage;
    }

    public void setTmsVehicleCategoryTonnage(BigDecimal tmsVehicleCategoryTonnage) {
        this.tmsVehicleCategoryTonnage = tmsVehicleCategoryTonnage;
    }

    @Column(name = "tms_vehiclecategoryemptyweight")
    public BigDecimal getTmsVehicleCategoryEmptyWeight() {
        return tmsVehicleCategoryEmptyWeight;
    }

    public void setTmsVehicleCategoryEmptyWeight(BigDecimal tmsVehicleCategoryEmptyWeight) {
        this.tmsVehicleCategoryEmptyWeight = tmsVehicleCategoryEmptyWeight;
    }

    @Column(name = "tms_vehiclecategorytotalweight")
    public BigDecimal getTmsVehicleCategoryTotalWeight() {
        return tmsVehicleCategoryTotalWeight;
    }

    public void setTmsVehicleCategoryTotalWeight(BigDecimal tmsVehicleCategoryTotalWeight) {
        this.tmsVehicleCategoryTotalWeight = tmsVehicleCategoryTotalWeight;
    }

}

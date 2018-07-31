package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;

public class TmsCategory {
    private int tmsCategoryId;
    private BigDecimal tmsCategoryConsumption;
    private BigDecimal tmsCategoryWeight;
    private BigDecimal tmsCategoryWidth;
    private DoorType tmsCategoryDoor;
    private BigDecimal tmsCategoryDepth;
    private BigDecimal tmsCategoryTonnage;
    private BigDecimal tmsCategoryEmptyWeight;
    private BigDecimal tmsCategoryTotalWeight;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_CategoryId", unique = true, nullable = false, precision = 10, scale = 0)

    public int getTmsCategoryId() {
        return tmsCategoryId;
    }

    public void setTmsCategoryId(int tmsCategoryId) {
        this.tmsCategoryId = tmsCategoryId;
    }

    public BigDecimal getTmsCategoryConsumption() {
        return tmsCategoryConsumption;
    }

    public void setTmsCategoryConsumption(BigDecimal tmsCategoryConsumption) {
        this.tmsCategoryConsumption = tmsCategoryConsumption;
    }

    public BigDecimal getTmsCategoryWeight() {
        return tmsCategoryWeight;
    }

    public void setTmsCategoryWeight(BigDecimal tmsCategoryWeight) {
        this.tmsCategoryWeight = tmsCategoryWeight;
    }

    public BigDecimal getTmsCategoryWidth() {
        return tmsCategoryWidth;
    }

    public void setTmsCategoryWidth(BigDecimal tmsCategoryWidth) {
        this.tmsCategoryWidth = tmsCategoryWidth;
    }

    public DoorType getTmsCategoryDoor() {
        return tmsCategoryDoor;
    }

    public void setTmsCategoryDoor(DoorType tmsCategoryDoor) {
        this.tmsCategoryDoor = tmsCategoryDoor;
    }

    public BigDecimal getTmsCategoryDepth() {
        return tmsCategoryDepth;
    }

    public void setTmsCategoryDepth(BigDecimal tmsCategoryDepth) {
        this.tmsCategoryDepth = tmsCategoryDepth;
    }

    public BigDecimal getTmsCategoryTonnage() {
        return tmsCategoryTonnage;
    }

    public void setTmsCategoryTonnage(BigDecimal tmsCategoryTonnage) {
        this.tmsCategoryTonnage = tmsCategoryTonnage;
    }

    public BigDecimal getTmsCategoryEmptyWeight() {
        return tmsCategoryEmptyWeight;
    }

    public void setTmsCategoryEmptyWeight(BigDecimal tmsCategoryEmptyWeight) {
        this.tmsCategoryEmptyWeight = tmsCategoryEmptyWeight;
    }

    public BigDecimal getTmsCategoryTotalWeight() {
        return tmsCategoryTotalWeight;
    }

    public void setTmsCategoryTotalWeight(BigDecimal tmsCategoryTotalWeight) {
        this.tmsCategoryTotalWeight = tmsCategoryTotalWeight;
    }
}

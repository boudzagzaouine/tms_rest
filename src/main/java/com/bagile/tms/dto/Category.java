package com.bagile.tms.dto;

import java.math.BigDecimal;

public class Category {
    private int tmsCategoryId;
    private BigDecimal Consumption;
    private BigDecimal Weight;
    private BigDecimal Width;
    private DoorType Door;
    private BigDecimal Depth;
    private BigDecimal Tonnage;
    private BigDecimal EmptyWeight;
    private BigDecimal TotalWeight;

    public int getTmsCategoryId() {
        return tmsCategoryId;
    }

    public void setTmsCategoryId(int tmsCategoryId) {
        this.tmsCategoryId = tmsCategoryId;
    }

    public BigDecimal getConsumption() {
        return Consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        Consumption = consumption;
    }

    public BigDecimal getWeight() {
        return Weight;
    }

    public void setWeight(BigDecimal weight) {
        Weight = weight;
    }

    public BigDecimal getWidth() {
        return Width;
    }

    public void setWidth(BigDecimal width) {
        Width = width;
    }

    public DoorType getDoor() {
        return Door;
    }

    public void setDoor(DoorType door) {
        Door = door;
    }

    public BigDecimal getDepth() {
        return Depth;
    }

    public void setDepth(BigDecimal depth) {
        Depth = depth;
    }

    public BigDecimal getTonnage() {
        return Tonnage;
    }

    public void setTonnage(BigDecimal tonnage) {
        Tonnage = tonnage;
    }

    public BigDecimal getEmptyWeight() {
        return EmptyWeight;
    }

    public void setEmptyWeight(BigDecimal emptyWeight) {
        EmptyWeight = emptyWeight;
    }

    public BigDecimal getTotalWeight() {
        return TotalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        TotalWeight = totalWeight;
    }
}

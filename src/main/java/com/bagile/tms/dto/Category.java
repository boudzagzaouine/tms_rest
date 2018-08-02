package com.bagile.tms.dto;

import java.math.BigDecimal;

public class Category {
    private long id;
    private BigDecimal consumption;
    private BigDecimal weight;
    private BigDecimal width;
    private DoorType door;
    private BigDecimal depth;
    private BigDecimal tonnage;
    private BigDecimal emptyWeight;
    private BigDecimal totalWeight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public DoorType getDoor() {
        return door;
    }

    public void setDoor(DoorType door) {
        this.door = door;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getTonnage() {
        return tonnage;
    }

    public void setTonnage(BigDecimal tonnage) {
        this.tonnage = tonnage;
    }

    public BigDecimal getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(BigDecimal emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public BigDecimal getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(BigDecimal totalWeight) {
        this.totalWeight = totalWeight;
    }
}

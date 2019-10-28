package com.bagile.tms.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class VehicleCategory extends EmsDto implements Serializable {



    /**
     *
     */
    private static final long serialVersionUID = 1545447956689771754L;
    private Long id;
    private String code;
    private  String consumption;
    private BigDecimal weight;
    private  BigDecimal width;
    private BigDecimal depth;
    private BigDecimal tonnage;
    private  BigDecimal emptyWeight;
    private BigDecimal totalWeight;


    public VehicleCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
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

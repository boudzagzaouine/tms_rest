package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class VehicleFeature extends EmsDto implements Serializable {

private long id;
private String code;
private String description;
private BigDecimal value;
private Uom unit;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Uom getUnit() {
        return unit;
    }

    public void setUnit(Uom unit) {
        this.unit = unit;
    }
}

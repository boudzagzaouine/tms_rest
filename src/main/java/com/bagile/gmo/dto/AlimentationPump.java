package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class AlimentationPump extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
    //private String code;
    private FuelPump fuelPump;
    private BigDecimal quantity;
    private Date dateAlimentation;
    private ReceptionLine receptionLine;

    private Reception reception;
    public AlimentationPump() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }*/

    public FuelPump getFuelPump() {
        return fuelPump;
    }

    public void setFuelPump(FuelPump fuelPump) {
        this.fuelPump = fuelPump;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getDateAlimentation() {
        return dateAlimentation;
    }

    public void setDateAlimentation(Date dateAlimentation) {
        this.dateAlimentation = dateAlimentation;
    }


    public ReceptionLine getReceptionLine() {
        return receptionLine;
    }

    public void setReceptionLine(ReceptionLine receptionLine) {
        this.receptionLine = receptionLine;
    }


    public Reception getReception() {
        return reception;
    }

    public void setReception(Reception reception) {
        this.reception = reception;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlimentationPump badge = (AlimentationPump) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CatalogTransportType extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
    private TurnType turnType;
    private Ville villeSource ;
    private Ville villeDestination;
    private Transport transport;
    private VehicleCategory vehicleCategory;
    private BigDecimal amountHt;
    private BigDecimal amountTtc;
    private BigDecimal amountTva;
    private Vat vat;
    private BigDecimal groupingAmountHt;
    private BigDecimal groupingAmountTtc;
    private BigDecimal groupingAmountTva;
    private Vat groupingAVat;

    private Boolean interneOrExterne;
    private Owner owner;



    public CatalogTransportType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }


    public Ville getVilleSource() {
        return villeSource;
    }

    public void setVilleSource(Ville villeSource) {
        this.villeSource = villeSource;
    }

    public Ville getVilleDestination() {
        return villeDestination;
    }

    public void setVilleDestination(Ville villeDestination) {
        this.villeDestination = villeDestination;
    }

    public BigDecimal getAmountHt() {
        return amountHt;
    }

    public void setAmountHt(BigDecimal amountHt) {
        this.amountHt = amountHt;
    }

    public BigDecimal getAmountTtc() {
        return amountTtc;
    }

    public void setAmountTtc(BigDecimal amountTtc) {
        this.amountTtc = amountTtc;
    }

    public BigDecimal getAmountTva() {
        return amountTva;
    }

    public void setAmountTva(BigDecimal amountTva) {
        this.amountTva = amountTva;
    }

    public TurnType getTurnType() {
        return turnType;
    }

    public void setTurnType(TurnType turnType) {
        this.turnType = turnType;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    public Boolean getInterneOrExterne() {
        return interneOrExterne;
    }

    public void setInterneOrExterne(Boolean interneOrExterne) {
        this.interneOrExterne = interneOrExterne;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public BigDecimal getGroupingAmountHt() {
        return groupingAmountHt;
    }

    public void setGroupingAmountHt(BigDecimal groupingAmountHt) {
        this.groupingAmountHt = groupingAmountHt;
    }

    public BigDecimal getGroupingAmountTtc() {
        return groupingAmountTtc;
    }

    public void setGroupingAmountTtc(BigDecimal groupingAmountTtc) {
        this.groupingAmountTtc = groupingAmountTtc;
    }

    public BigDecimal getGroupingAmountTva() {
        return groupingAmountTva;
    }

    public void setGroupingAmountTva(BigDecimal groupingAmountTva) {
        this.groupingAmountTva = groupingAmountTva;
    }

    public Vat getGroupingAVat() {
        return groupingAVat;
    }

    public void setGroupingAVat(Vat groupingAVat) {
        this.groupingAVat = groupingAVat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogTransportType badge = (CatalogTransportType) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

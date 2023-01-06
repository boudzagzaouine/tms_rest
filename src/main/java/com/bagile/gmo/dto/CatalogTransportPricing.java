package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CatalogTransportPricing extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
    private Transport transport ;
    private TurnType turnType;
    private Pays paysSource;
    private Ville villeSource ;
    private Pays paysDestination;
    private Ville villeDestination;
    private VehicleCategory vehicleCategory;
    private VehicleTray vehicleTray;
    private LoadingType loadingType;
    private BigDecimal purchaseAmountHt;
    private BigDecimal purchaseAmountTtc;
    private BigDecimal purchaseAmountTva;
    private Vat purchaseVat;

    private Owner owner;

    public CatalogTransportPricing() {
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

    public TurnType getTurnType() {
        return turnType;
    }

    public void setTurnType(TurnType turnType) {
        this.turnType = turnType;
    }

    public Pays getPaysSource() {
        return paysSource;
    }

    public void setPaysSource(Pays paysSource) {
        this.paysSource = paysSource;
    }

    public Ville getVilleSource() {
        return villeSource;
    }

    public void setVilleSource(Ville villeSource) {
        this.villeSource = villeSource;
    }

    public Pays getPaysDestination() {
        return paysDestination;
    }

    public void setPaysDestination(Pays paysDestination) {
        this.paysDestination = paysDestination;
    }

    public Ville getVilleDestination() {
        return villeDestination;
    }

    public void setVilleDestination(Ville villeDestination) {
        this.villeDestination = villeDestination;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public VehicleTray getVehicleTray() {
        return vehicleTray;
    }

    public void setVehicleTray(VehicleTray vehicleTray) {
        this.vehicleTray = vehicleTray;
    }

    public LoadingType getLoadingType() {
        return loadingType;
    }

    public void setLoadingType(LoadingType loadingType) {
        this.loadingType = loadingType;
    }

    public BigDecimal getPurchaseAmountHt() {
        return purchaseAmountHt;
    }

    public void setPurchaseAmountHt(BigDecimal purchaseAmountHt) {
        this.purchaseAmountHt = purchaseAmountHt;
    }

    public BigDecimal getPurchaseAmountTtc() {
        return purchaseAmountTtc;
    }

    public void setPurchaseAmountTtc(BigDecimal purchaseAmountTtc) {
        this.purchaseAmountTtc = purchaseAmountTtc;
    }

    public BigDecimal getPurchaseAmountTva() {
        return purchaseAmountTva;
    }

    public void setPurchaseAmountTva(BigDecimal purchaseAmountTva) {
        this.purchaseAmountTva = purchaseAmountTva;
    }

    public Vat getPurchaseVat() {
        return purchaseVat;
    }

    public void setPurchaseVat(Vat purchaseVat) {
        this.purchaseVat = purchaseVat;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogTransportPricing badge = (CatalogTransportPricing) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

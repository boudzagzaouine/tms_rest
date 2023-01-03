package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CatalogPricing extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
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

    private BigDecimal saleAmountHt;
    private BigDecimal saleAmountTtc;
    private BigDecimal saleAmountTva;
    private Vat saleVat;

  private Owner owner;



    public CatalogPricing() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Pays getPaysSource() {
        return paysSource;
    }

    public void setPaysSource(Pays paysSource) {
        this.paysSource = paysSource;
    }

    public VehicleTray getVehicleTray() {
        return vehicleTray;
    }

    public void setVehicleTray(VehicleTray vehicleTray) {
        this.vehicleTray = vehicleTray;
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

    public TurnType getTurnType() {
        return turnType;
    }

    public void setTurnType(TurnType turnType) {
        this.turnType = turnType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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

    public BigDecimal getSaleAmountHt() {
        return saleAmountHt;
    }

    public void setSaleAmountHt(BigDecimal saleAmountHt) {
        this.saleAmountHt = saleAmountHt;
    }

    public BigDecimal getSaleAmountTtc() {
        return saleAmountTtc;
    }

    public void setSaleAmountTtc(BigDecimal saleAmountTtc) {
        this.saleAmountTtc = saleAmountTtc;
    }

    public BigDecimal getSaleAmountTva() {
        return saleAmountTva;
    }

    public void setSaleAmountTva(BigDecimal saleAmountTva) {
        this.saleAmountTva = saleAmountTva;
    }

    public Vat getSaleVat() {
        return saleVat;
    }

    public void setSaleVat(Vat saleVat) {
        this.saleVat = saleVat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogPricing badge = (CatalogPricing) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

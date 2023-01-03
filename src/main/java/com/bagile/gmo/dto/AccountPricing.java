package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountPricing extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private Company company ;

    private TurnType turnType;
    private Pays paysSource;
    private Ville villeSource ;
    private Pays paysDestination;
    private Ville villeDestination;
    private VehicleCategory vehicleCategory;
    private VehicleTray vehicleTray;
    private LoadingType loadingType;
    private BigDecimal saleAmountHt;
    private BigDecimal saleAmountTtc;
    private BigDecimal saleAmountTva;
    private Vat saleVat;

private Owner owner;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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
        AccountPricing badgeType = (AccountPricing) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

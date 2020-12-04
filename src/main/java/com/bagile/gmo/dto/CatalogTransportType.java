package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CatalogTransportType extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
    private Transport transport;
    private VehicleCategory vehicleCategory;
    private Zone zoneSource ;
    private Zone zoneDestination;
    private BigDecimal amountHt;
    private BigDecimal amountTtc;
    private BigDecimal amountTva;
    private Vat vat;
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

    public Zone getZoneSource() {
        return zoneSource;
    }

    public void setZoneSource(Zone zoneSource) {
        this.zoneSource = zoneSource;
    }

    public Zone getZoneDestination() {
        return zoneDestination;
    }

    public void setZoneDestination(Zone zoneDestination) {
        this.zoneDestination = zoneDestination;
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

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
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
        CatalogTransportType badge = (CatalogTransportType) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

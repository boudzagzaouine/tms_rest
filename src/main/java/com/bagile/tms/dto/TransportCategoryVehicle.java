package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Objects;

public class TransportCategoryVehicle extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;
    private long id;
    private Transport transport;
    private VehicleCategory vehicleCategory;
    private int quantity;


    public TransportCategoryVehicle() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportCategoryVehicle badge = (TransportCategoryVehicle) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

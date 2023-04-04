package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Objects;

public class OrderTransportAccompaniment extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;
    private OrderTransport orderTransport;
    private VehicleAccompaniment vehicleAccompaniment ;


    private Owner owner;

    public OrderTransportAccompaniment() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderTransport getOrderTransport() {
        return orderTransport;
    }

    public void setOrderTransport(OrderTransport orderTransport) {
        this.orderTransport = orderTransport;
    }

    public VehicleAccompaniment getVehicleAccompaniment() {
        return vehicleAccompaniment;
    }

    public void setVehicleAccompaniment(VehicleAccompaniment vehicleAccompaniment) {
        this.vehicleAccompaniment = vehicleAccompaniment;
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
        OrderTransportAccompaniment badge = (OrderTransportAccompaniment) o;
        return getId() == badge.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

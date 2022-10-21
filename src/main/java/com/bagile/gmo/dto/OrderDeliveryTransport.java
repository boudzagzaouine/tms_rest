package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class OrderDeliveryTransport extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8747248049547537558L;

    private long id;
    private Vehicle vehicle;
   private VehicleCategory vehicleCategory;
   private Transport transport;
    private Set<Driver> drivers=new HashSet<>();
 private OrderDelivery orderDelivery;
 private long numberOfPalette;


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderDelivery getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(OrderDelivery orderDelivery) {
        this.orderDelivery = orderDelivery;
    }

    public long getNumberOfPalette() {
        return numberOfPalette;
    }

    public void setNumberOfPalette(long numberOfPalette) {
        this.numberOfPalette = numberOfPalette;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDeliveryTransport turnSoPo = (OrderDeliveryTransport) o;
        return id == turnSoPo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
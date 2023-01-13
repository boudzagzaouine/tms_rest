package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class TransportPlanHistory extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3467898889038526418L;

    private long id;

    private OrderTransport orderTransport;
    private Vehicle vehicle ;
    private Driver driver;
    private VehicleCategory vehicleCategory;
    private Transport  transport;
    private TurnStatus turnStatus;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private Ville villeSource;
    private Ville villeDistination;
    private Date date ;
    private OrderTransportRejectType orderTransportRejectType;
    private long type ;
    public TransportPlanHistory() {
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Ville getVilleSource() {
        return villeSource;
    }

    public void setVilleSource(Ville villeSource) {
        this.villeSource = villeSource;
    }

    public void setVilleDistination(Ville villeDistination) {
        this.villeDistination = villeDistination;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public OrderTransportRejectType getOrderTransportRejectType() {
        return orderTransportRejectType;
    }

    public void setOrderTransportRejectType(OrderTransportRejectType orderTransportRejectType) {
        this.orderTransportRejectType = orderTransportRejectType;
    }

    public Ville getVilleDistination() {
        return villeDistination;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public TurnStatus getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(TurnStatus turnStatus) {
        this.turnStatus = turnStatus;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportPlanHistory turn = (TransportPlanHistory) o;
        return getId() == turn.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

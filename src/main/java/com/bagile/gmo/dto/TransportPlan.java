package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class TransportPlan extends EmsDto implements Serializable {

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

    private String villeSource;
    private String villeDistination;
    private Date date ;

    private List<TransportPlanProductService> transportPlanProductServices = new ArrayList<>();

    public TransportPlan() {
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

    public String getVilleSource() {
        return villeSource;
    }

    public void setVilleSource(String villeSource) {
        this.villeSource = villeSource;
    }

    public String getVilleDistination() {
        return villeDistination;
    }

    public void setVilleDistination(String villeDistination) {
        this.villeDistination = villeDistination;
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

    public List<TransportPlanProductService> getTransportPlanProductServices() {
        return transportPlanProductServices;
    }

    public void setTransportPlanProductServices(List<TransportPlanProductService> transportPlanProductServices) {
        this.transportPlanProductServices = transportPlanProductServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportPlan turn = (TransportPlan) o;
        return getId() == turn.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

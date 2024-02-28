package com.bagile.gmo.dto;

import java.util.Date;

public class TransportPlanLocation {

    private long id;

    private double latitude;
    private double longitude;
    private TransportPlan transportPlan;

    private OrderTransport orderTransport;
    private OrderTransportInfo orderTransportInfo;

    private OrderTransportInfoLine orderTransportInfoLine;

    private Vehicle vehicle;
    private Driver driver;
    private Long transportPlanId;

    private Long orderTransportId;
    private Long orderTransportInfoId;

    private Long orderTransportInfoLineId;

    private Long vehicleId;
    private Long driverId;


    private Date date;
    private String type;

    private Long accountId;
    private String accountName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getTransportPlanId() {
        return transportPlanId;
    }

    public void setTransportPlanId(Long transportPlanId) {
        this.transportPlanId = transportPlanId;
    }

    public Long getOrderTransportId() {
        return orderTransportId;
    }

    public void setOrderTransportId(Long orderTransportId) {
        this.orderTransportId = orderTransportId;
    }

    public Long getOrderTransportInfoId() {
        return orderTransportInfoId;
    }

    public void setOrderTransportInfoId(Long orderTransportInfoId) {
        this.orderTransportInfoId = orderTransportInfoId;
    }

    public Long getOrderTransportInfoLineId() {
        return orderTransportInfoLineId;
    }

    public void setOrderTransportInfoLineId(Long orderTransportInfoLineId) {
        this.orderTransportInfoLineId = orderTransportInfoLineId;
    }

    public TransportPlan getTransportPlan() {
        return transportPlan;
    }

    public void setTransportPlan(TransportPlan transportPlan) {
        this.transportPlan = transportPlan;
    }

    public OrderTransport getOrderTransport() {
        return orderTransport;
    }

    public void setOrderTransport(OrderTransport orderTransport) {
        this.orderTransport = orderTransport;
    }

    public OrderTransportInfo getOrderTransportInfo() {
        return orderTransportInfo;
    }

    public void setOrderTransportInfo(OrderTransportInfo orderTransportInfo) {
        this.orderTransportInfo = orderTransportInfo;
    }

    public OrderTransportInfoLine getOrderTransportInfoLine() {
        return orderTransportInfoLine;
    }

    public void setOrderTransportInfoLine(OrderTransportInfoLine orderTransportInfoLine) {
        this.orderTransportInfoLine = orderTransportInfoLine;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
}

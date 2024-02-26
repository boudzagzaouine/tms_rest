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
    private long transportPlanId;

    private long orderTransportId;
    private long orderTransportInfoId;

    private long orderTransportInfoLineId;

    private long vehicleId;
    private long driverId;


    private Date date;
    private String type;

    private long accountId;
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

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getTransportPlanId() {
        return transportPlanId;
    }

    public void setTransportPlanId(long transportPlanId) {
        this.transportPlanId = transportPlanId;
    }

    public long getOrderTransportId() {
        return orderTransportId;
    }

    public void setOrderTransportId(long orderTransportId) {
        this.orderTransportId = orderTransportId;
    }

    public long getOrderTransportInfoId() {
        return orderTransportInfoId;
    }

    public void setOrderTransportInfoId(long orderTransportInfoId) {
        this.orderTransportInfoId = orderTransportInfoId;
    }

    public long getOrderTransportInfoLineId() {
        return orderTransportInfoLineId;
    }

    public void setOrderTransportInfoLineId(long orderTransportInfoLineId) {
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

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }
}

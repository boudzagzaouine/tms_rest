package com.bagile.gmo.dto;

import java.util.Date;

public class TransportPlanLocation {

	private long id;

	private double latitude ;
	private double longitude ;
	private TransportPlan transportPlanId ;

	private OrderTransport orderTransportId ;
	private OrderTransportInfo orderTransportInfoId ;

	private OrderTransportInfoLine orderTransportInfoLineId ;

	private Vehicle vehicleId ;
	private Driver driverId ;
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

	public TransportPlan getTransportPlanId() {
		return transportPlanId;
	}

	public void setTransportPlanId(TransportPlan transportPlanId) {
		this.transportPlanId = transportPlanId;
	}

	public Vehicle getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Vehicle vehicleId) {
		this.vehicleId = vehicleId;
	}

	public OrderTransportInfo getOrderTransportInfoId() {
		return orderTransportInfoId;
	}

	public void setOrderTransportInfoId(OrderTransportInfo orderTransportInfoId) {
		this.orderTransportInfoId = orderTransportInfoId;
	}

	public OrderTransport getOrderTransportId() {
		return orderTransportId;
	}

	public void setOrderTransportId(OrderTransport orderTransportId) {
		this.orderTransportId = orderTransportId;
	}

	public OrderTransportInfoLine getOrderTransportInfoLineId() {
		return orderTransportInfoLineId;
	}

	public void setOrderTransportInfoLineId(OrderTransportInfoLine orderTransportInfoLineId) {
		this.orderTransportInfoLineId = orderTransportInfoLineId;
	}

	public Driver getDriverId() {
		return driverId;
	}

	public void setDriverId(Driver driverId) {
		this.driverId = driverId;
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
}

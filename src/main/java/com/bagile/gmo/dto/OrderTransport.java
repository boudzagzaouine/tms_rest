package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OrderTransport {

	private long id;
	private String code;
	private String description;

	private Date date ;
	private TurnType turnType;
	private String  loadingType ;
	private Account account;
	private TurnStatus turnStatus;
	private VehicleCategory vehicleCategory ;

	//private OrderTransportInfo orderTransportInfoAller;
	//private OrderTransportInfo orderTransportInfoRetour;

	private BigDecimal priceTTC;

	private Owner owner;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TurnType getTurnType() {
		return turnType;
	}

	public void setTurnType(TurnType turnType) {
		this.turnType = turnType;
	}

	public String getLoadingType() {
		return loadingType;
	}

	public void setLoadingType(String loadingType) {
		this.loadingType = loadingType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}

	public BigDecimal getPriceTTC() {
		return priceTTC;
	}

	public void setPriceTTC(BigDecimal priceTTC) {
		this.priceTTC = priceTTC;
	}

	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public TurnStatus getTurnStatus() {
		return turnStatus;
	}

	public void setTurnStatus(TurnStatus turnStatus) {
		this.turnStatus = turnStatus;
	}

//	public OrderTransportInfo getOrderTransportInfoAller() {
//		return orderTransportInfoAller;
//	}
//
//	public void setOrderTransportInfoAller(OrderTransportInfo orderTransportInfoAller) {
//		this.orderTransportInfoAller = orderTransportInfoAller;
//	}
//
//	public OrderTransportInfo getOrderTransportInfoRetour() {
//		return orderTransportInfoRetour;
//	}
//
//	public void setOrderTransportInfoRetour(OrderTransportInfo orderTransportInfoRetour) {
//		this.orderTransportInfoRetour = orderTransportInfoRetour;
//	}

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
		OrderTransport that = (OrderTransport) o;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

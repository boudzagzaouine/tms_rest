package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDelivery {

	private long id;
	private String code;
	private String description;

	private Date date ;
	private TurnType turnType;
	private String  loadingType ;
	private Account account;
	private TurnStatus turnStatus;

	private DeliveryInfo deliveryInfoAller;
	private DeliveryInfo deliveryInfoRetour;

	private List<OrderDeliveryTransport> orderDeliveryTransport = new ArrayList<>();
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


	public TurnStatus getTurnStatus() {
		return turnStatus;
	}

	public void setTurnStatus(TurnStatus turnStatus) {
		this.turnStatus = turnStatus;
	}

	public DeliveryInfo getDeliveryInfoAller() {
		return deliveryInfoAller;
	}

	public void setDeliveryInfoAller(DeliveryInfo deliveryInfoAller) {
		this.deliveryInfoAller = deliveryInfoAller;
	}

	public DeliveryInfo getDeliveryInfoRetour() {
		return deliveryInfoRetour;
	}

	public void setDeliveryInfoRetour(DeliveryInfo deliveryInfoRetour) {
		this.deliveryInfoRetour = deliveryInfoRetour;
	}

	public List<OrderDeliveryTransport> getOrderDeliveryTransport() {
		return orderDeliveryTransport;
	}

	public void setOrderDeliveryTransport(List<OrderDeliveryTransport> orderDeliveryTransport) {
		this.orderDeliveryTransport = orderDeliveryTransport;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}

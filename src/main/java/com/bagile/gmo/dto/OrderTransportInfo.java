package com.bagile.gmo.dto;

import com.querydsl.core.types.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderTransportInfo {

	private long id;

	private PackagingType packagingType;

	private List<PackageDetail> packageDetails=new ArrayList<>();
	private AddressContactOrderTransportInfo addressContactInitial;
	private AddressContactOrderTransportInfo addressContactFinal;

    private List<OrderTransportInfoLine> orderTransportInfoLines ;

	private BigDecimal weightTotal ;
	private BigDecimal capacityTotal;

	private String  type ; //Aller || retour
	private BigDecimal  priceTTC;

	private TurnStatus turnStatus;

	private Boolean trajetUnique;
	private OrderTransport orderTransport;
	private Owner owner;



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public PackagingType getPackagingType() {
		return packagingType;
	}

	public void setPackagingType(PackagingType packagingType) {
		this.packagingType = packagingType;
	}

	public List<PackageDetail> getPackageDetails() {
		return packageDetails;
	}

	public void setPackageDetails(List<PackageDetail> packageDetails) {
		this.packageDetails = packageDetails;
	}

	public AddressContactOrderTransportInfo getAddressContactInitial() {
		return addressContactInitial;
	}

	public Boolean getTrajetUnique() {
		return trajetUnique;
	}

	public TurnStatus getTurnStatus() {
		return turnStatus;
	}

	public void setTurnStatus(TurnStatus turnStatus) {
		this.turnStatus = turnStatus;
	}

	public void setTrajetUnique(Boolean trajetUnique) {
		this.trajetUnique = trajetUnique;
	}

	public void setAddressContactInitial(AddressContactOrderTransportInfo addressContactInitial) {
		this.addressContactInitial = addressContactInitial;
	}

	public AddressContactOrderTransportInfo getAddressContactFinal() {
		return addressContactFinal;
	}

	public void setAddressContactFinal(AddressContactOrderTransportInfo addressContactFinal) {
		this.addressContactFinal = addressContactFinal;
	}

	public BigDecimal getWeightTotal() {
		return weightTotal;
	}

	public void setWeightTotal(BigDecimal weightTotal) {
		this.weightTotal = weightTotal;
	}

	public BigDecimal getCapacityTotal() {
		return capacityTotal;
	}

	public void setCapacityTotal(BigDecimal capacityTotal) {
		this.capacityTotal = capacityTotal;
	}

	public BigDecimal getPriceTTC() {
		return priceTTC;
	}

	public void setPriceTTC(BigDecimal priceTTC) {
		this.priceTTC = priceTTC;
	}

	public List<OrderTransportInfoLine> getOrderTransportInfoLines() {
		return orderTransportInfoLines;
	}

	public void setOrderTransportInfoLines(List<OrderTransportInfoLine> orderTransportInfoLines) {
		this.orderTransportInfoLines = orderTransportInfoLines;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public OrderTransport getOrderTransport() {
		return orderTransport;
	}

	public void setOrderTransport(OrderTransport orderTransport) {
		this.orderTransport = orderTransport;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderTransportInfo that = (OrderTransportInfo) o;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

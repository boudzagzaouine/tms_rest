package com.bagile.gmo.dto;

import com.querydsl.core.types.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

	private BigDecimal numberOfPallet ;

	private OrderTransport orderTransport;
	private Owner owner;

	private Ville villeSource ;
	private Ville villeDistination;

 private Date date;

	private BigDecimal numberKm ;
	private BigDecimal time ;

	private BigDecimal numberKmRetour ;
	private BigDecimal timeRetour ;

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

	public BigDecimal getNumberKm() {
		return numberKm;
	}

	public void setNumberKm(BigDecimal numberKm) {
		this.numberKm = numberKm;
	}

	public BigDecimal getTime() {
		return time;
	}

	public void setTime(BigDecimal time) {
		this.time = time;
	}

	public BigDecimal getNumberKmRetour() {
		return numberKmRetour;
	}

	public void setNumberKmRetour(BigDecimal numberKmRetour) {
		this.numberKmRetour = numberKmRetour;
	}

	public BigDecimal getTimeRetour() {
		return timeRetour;
	}

	public void setTimeRetour(BigDecimal timeRetour) {
		this.timeRetour = timeRetour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AddressContactOrderTransportInfo getAddressContactInitial() {
		return addressContactInitial;
	}

	public Ville getVilleSource() {
		return villeSource;
	}

	public void setVilleSource(Ville villeSource) {
		this.villeSource = villeSource;
	}

	public Ville getVilleDistination() {
		return villeDistination;
	}

	public void setVilleDistination(Ville villeDistination) {
		this.villeDistination = villeDistination;
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

	public BigDecimal getNumberOfPallet() {
		return numberOfPallet;
	}

	public void setNumberOfPallet(BigDecimal numberOfPallet) {
		this.numberOfPallet = numberOfPallet;
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

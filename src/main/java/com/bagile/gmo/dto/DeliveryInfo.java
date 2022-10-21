package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DeliveryInfo {

	private long id;

	private PackagingType packagingType;

	private List<PackageDetail> packageDetails=new ArrayList<>();
	private AddressContactDeliveryInfo contactDeliveryInfoSource;
	private AddressContactDeliveryInfo contactDeliveryInfoDistination;

	private BigDecimal weightTotal ;
	private BigDecimal capacityTotal;

	private BigDecimal  priceTTC;
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

	public AddressContactDeliveryInfo getContactDeliveryInfoSource() {
		return contactDeliveryInfoSource;
	}

	public void setContactDeliveryInfoSource(AddressContactDeliveryInfo contactDeliveryInfoSource) {
		this.contactDeliveryInfoSource = contactDeliveryInfoSource;
	}

	public AddressContactDeliveryInfo getContactDeliveryInfoDistination() {
		return contactDeliveryInfoDistination;
	}

	public void setContactDeliveryInfoDistination(AddressContactDeliveryInfo contactDeliveryInfoDistination) {
		this.contactDeliveryInfoDistination = contactDeliveryInfoDistination;
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}


}

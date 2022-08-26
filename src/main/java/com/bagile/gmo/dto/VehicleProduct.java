package com.bagile.gmo.dto;

import java.util.ArrayList;
import java.util.List;

public class VehicleProduct {

	private long id;

	private ProductType productType;
	private Product Product;
	private String reference;
	private String referenceOther;

 private Owner owner;

 private Vehicle vehicle;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public com.bagile.gmo.dto.Product getProduct() {
		return Product;
	}

	public void setProduct(com.bagile.gmo.dto.Product product) {
		Product = product;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getReferenceOther() {
		return referenceOther;
	}

	public void setReferenceOther(String referenceOther) {
		this.referenceOther = referenceOther;
	}
}

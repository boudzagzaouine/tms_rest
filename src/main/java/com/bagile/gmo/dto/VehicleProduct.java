package com.bagile.gmo.dto;

import java.util.ArrayList;
import java.util.List;

public class VehicleProduct {

	private long id;

	private ProductType productType;
	private Product Product;

	private List<VehicleProductReference> vehicleProductReferences = new ArrayList<>();

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


	public List<VehicleProductReference> getVehicleProductReferences() {
		return vehicleProductReferences;
	}

	public void setVehicleProductReferences(List<VehicleProductReference> vehicleProductReferences) {
		this.vehicleProductReferences = vehicleProductReferences;
	}
}

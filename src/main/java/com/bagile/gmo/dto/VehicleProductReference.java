package com.bagile.gmo.dto;

public class VehicleProductReference {

	private long id;
	private String reference;
	private VehicleProduct vehicleProduct;

 private Owner owner;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public VehicleProduct getVehicleProduct() {
		return vehicleProduct;
	}

	public void setVehicleProduct(VehicleProduct vehicleProduct) {
		this.vehicleProduct = vehicleProduct;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}



	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
}

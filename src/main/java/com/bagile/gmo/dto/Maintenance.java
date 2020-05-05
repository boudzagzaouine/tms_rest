package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.List;

public class Maintenance extends EmsDto {

	private long id;
	private List<MaintenanceTask> maintenanceTasks;
	private String description;
	private MaintenanceCategory category;
	private MaintenanceType type;
	private BigDecimal kilometrage;
	private Vehicle vehicle;
	private String location;
	private Integer labourCost;
	private Integer productCost;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<MaintenanceTask> getMaintenanceTasks() {
		return maintenanceTasks;
	}
	public void setMaintenanceTasks(List<MaintenanceTask> maintenanceTasks) {
		this.maintenanceTasks = maintenanceTasks;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MaintenanceCategory getCategory() {
		return category;
	}
	public void setCategory(MaintenanceCategory category) {
		this.category = category;
	}
	public MaintenanceType getType() {
		return type;
	}
	public void setType(MaintenanceType type) {
		this.type = type;
	}
	public BigDecimal getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(BigDecimal kilometrage) {
		this.kilometrage = kilometrage;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getLabourCost() {
		return labourCost;
	}
	public void setLabourCost(Integer labourCost) {
		this.labourCost = labourCost;
	}
	public Integer getProductCost() {
		return productCost;
	}
	public void setProductCost(Integer productCost) {
		this.productCost = productCost;
	}
	
	

}

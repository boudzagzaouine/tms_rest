package com.bagile.tms.dto;

import java.util.Date;

public class Vehicle {

    private long id;
    private String registrationNumber;
    private BadgeType badgeType;
    private String code;
    private Date technicalVisit;

    private VehicleCategory vehicleCategory;
    private Traffic drivingLicence;

    private Date creationDate;
    private User creationUser;
    private Date upDateDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public BadgeType getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(BadgeType badge) {
        this.badgeType = badge;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTechnicalVisit() {
        return technicalVisit;
    }

    public void setTechnicalVisit(Date technicalVisit) {
        this.technicalVisit = technicalVisit;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Traffic getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(Traffic drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public Date getUpDateDate() {
        return upDateDate;
    }

    public void setUpDateDate(Date upDateDate) {
        this.upDateDate = upDateDate;
    }
}

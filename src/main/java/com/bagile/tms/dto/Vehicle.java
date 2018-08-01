package com.bagile.tms.dto;

import java.util.Date;

public class Vehicle {

    private long id;
    private String registrationNumber;
    private Badge badge;
    private String code;
    private Date technicalVisit;

    private Category category;
    private Traffic drivingLicence;

    private Date creationDate;
    private User creationUser;
    private User upDateDate;

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

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public User getUpDateDate() {
        return upDateDate;
    }

    public void setUpDateDate(User upDateDate) {
        this.upDateDate = upDateDate;
    }
}

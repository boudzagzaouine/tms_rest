package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;

public class Vehicle extends EmsDto implements Serializable {


    private long id;
    private String registrationNumber;
    private String code;
    private Date technicalVisit;
    private Date creationDate;
    private VehicleCategory vehiculeCategorie;
    private BadgeType badgeType;


    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public VehicleCategory getVehiculeCategorie() {
        return vehiculeCategorie;
    }

    public void setVehiculeCategorie(VehicleCategory vehiculeCategorie) {
        this.vehiculeCategorie = vehiculeCategorie;
    }

    public BadgeType getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(BadgeType badgeType) {
        this.badgeType = badgeType;
    }
}

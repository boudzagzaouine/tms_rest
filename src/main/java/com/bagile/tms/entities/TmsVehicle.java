package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tms_vehicule")
public class TmsVehicle implements Serializable {
    private long tmsVehicleId;
    @Size(max = 30)
    @NotNull
    private String tmsVehicleregistrationNumber;
    @Size(max = 30)
    @NotNull
    private TmsBadge tmsVehiclebadge;
    private String tmsVehicleCode;
    private Date tmsVehicletechnicalVisit;

    private TmsCategory tmsVehicleCategory;
    private TmsTraffic tmsVehicleDrivingLicence;

    private Date tmsVehicleCreationDate;
    private UsrUser tmsVehicleCreationUser;
    private UsrUser tmsVehicleUpDateDate;


    public TmsVehicle() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_vehicleid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsVehicleId() {
        return tmsVehicleId;
    }

    public void setTmsVehicleId(long tmsVehicleId) {
        this.tmsVehicleId = tmsVehicleId;
    }

    public String getTmsVehicleregistrationNumber() {
        return tmsVehicleregistrationNumber;
    }

    public void setTmsVehicleregistrationNumber(String tmsVehicleregistrationNumber) {
        this.tmsVehicleregistrationNumber = tmsVehicleregistrationNumber;
    }

    public TmsBadge getTmsVehiclebadge() {
        return tmsVehiclebadge;
    }

    public void setTmsVehiclebadge(TmsBadge tmsVehiclebadge) {
        this.tmsVehiclebadge = tmsVehiclebadge;
    }

    public String getTmsVehicleCode() {
        return tmsVehicleCode;
    }

    public void setTmsVehicleCode(String tmsVehicleCode) {
        this.tmsVehicleCode = tmsVehicleCode;
    }

    public Date getTmsVehicletechnicalVisit() {
        return tmsVehicletechnicalVisit;
    }

    public void setTmsVehicletechnicalVisit(Date tmsVehicletechnicalVisit) {
        this.tmsVehicletechnicalVisit = tmsVehicletechnicalVisit;
    }

    public TmsCategory getTmsVehicleCategory() {
        return tmsVehicleCategory;
    }

    public void setTmsVehicleCategory(TmsCategory tmsVehicleCategory) {
        this.tmsVehicleCategory = tmsVehicleCategory;
    }

    public TmsTraffic getTmsVehicleDrivingLicence() {
        return tmsVehicleDrivingLicence;
    }

    public void setTmsVehicleDrivingLicence(TmsTraffic tmsVehicleDrivingLicence) {
        this.tmsVehicleDrivingLicence = tmsVehicleDrivingLicence;
    }

    public Date getTmsVehicleCreationDate() {
        return tmsVehicleCreationDate;
    }

    public void setTmsVehicleCreationDate(Date tmsVehicleCreationDate) {
        this.tmsVehicleCreationDate = tmsVehicleCreationDate;
    }

    public UsrUser getTmsVehicleCreationUser() {
        return tmsVehicleCreationUser;
    }

    public void setTmsVehicleCreationUser(UsrUser tmsVehicleCreationUser) {
        this.tmsVehicleCreationUser = tmsVehicleCreationUser;
    }

    public UsrUser getTmsVehicleUpDateDate() {
        return tmsVehicleUpDateDate;
    }

    public void setTmsVehicleUpDateDate(UsrUser tmsVehicleUpDateDate) {
        this.tmsVehicleUpDateDate = tmsVehicleUpDateDate;
    }
}

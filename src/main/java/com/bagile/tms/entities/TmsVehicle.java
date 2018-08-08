package com.bagile.tms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tms_vehicule",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_vehicleId","tms_vehiclecode","tms_vehicleregistrationumber"}))
public class TmsVehicle implements Serializable {
    private long tmsVehicleId;
    @NotNull
    private String tmsVehicleRegistrationNumber;
    @Size(max = 30)
    @NotNull
    private TmsBadge tmsVehicleBadge;

    private String tmsVehicleCode;

    private Date tmsVehicleTechnicalVisit;

    private TmsCategory tmsVehicleCategory;
    private TmsTraffic tmsVehicleDrivingLicence;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tmsVehicleCreationDate;
    private UsrUser tmsVehicleCreationUser;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tmsVehicleUpDateDate;


    public TmsVehicle() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_vehicleId")

    public long getTmsVehicleId() {
        return tmsVehicleId;
    }

    public void setTmsVehicleId(long tmsVehicleId) {
        this.tmsVehicleId = tmsVehicleId;
    }

    @Column(name = "tms_vehicleregistrationnumber", unique = true, nullable = false, precision = 10, scale = 0)
    public String getTmsVehicleRegistrationNumber() {
        return tmsVehicleRegistrationNumber;
    }

    public void setTmsVehicleRegistrationNumber(String tmsVehicleRegistrationNumber) {
        this.tmsVehicleRegistrationNumber = tmsVehicleRegistrationNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclebadgeid", unique = true, nullable = false)
    public TmsBadge getTmsVehicleBadge() {
        return tmsVehicleBadge;
    }

    public void setTmsVehicleBadge(TmsBadge tmsVehicleBadge) {
        this.tmsVehicleBadge = tmsVehicleBadge;
    }

    @Column(name = "tms_vehiclecode", unique = true, nullable = false)
    public String getTmsVehicleCode() {
        return tmsVehicleCode;
    }

    public void setTmsVehicleCode(String tmsVehicleCode) {
        this.tmsVehicleCode = tmsVehicleCode;
    }

    @Column(name = "tms_vehicletechnicalvisit", unique = true, nullable = false)
    public Date getTmsVehicleTechnicalVisit() {
        return tmsVehicleTechnicalVisit;
    }

    public void setTmsVehicleTechnicalVisit(Date tmsVehicleTechnicalVisit) {
        this.tmsVehicleTechnicalVisit = tmsVehicleTechnicalVisit;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclecategoryid")
    public TmsCategory getTmsVehicleCategory() {
        return tmsVehicleCategory;
    }

    public void setTmsVehicleCategory(TmsCategory tmsVehicleCategory) {
        this.tmsVehicleCategory = tmsVehicleCategory;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehicledrivinglicenceid")
    public TmsTraffic getTmsVehicleDrivingLicence() {
        return tmsVehicleDrivingLicence;
    }

    public void setTmsVehicleDrivingLicence(TmsTraffic tmsVehicleDrivingLicence) {
        this.tmsVehicleDrivingLicence = tmsVehicleDrivingLicence;
    }

    @Column(name = "tms_vehiclecreationdate")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTmsVehicleCreationDate() {
        return tmsVehicleCreationDate;
    }

    public void setTmsVehicleCreationDate(Date tmsVehicleCreationDate) {
        this.tmsVehicleCreationDate = tmsVehicleCreationDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclecreationuser")
    public UsrUser getTmsVehicleCreationUser() {
        return tmsVehicleCreationUser;
    }

    public void setTmsVehicleCreationUser(UsrUser tmsVehicleCreationUser) {
        this.tmsVehicleCreationUser = tmsVehicleCreationUser;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_vehicleupdatedate")
    public Date getTmsVehicleUpDateDate() {
        return tmsVehicleUpDateDate;
    }

    public void setTmsVehicleUpDateDate(Date tmsVehicleUpDateDate) {
        this.tmsVehicleUpDateDate = tmsVehicleUpDateDate;
    }
}

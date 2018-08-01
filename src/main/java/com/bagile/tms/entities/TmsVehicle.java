package com.bagile.tms.entities;

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
    @Column(name = "tms_vehicleId", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsVehicleId() {
        return tmsVehicleId;
    }

    public void setTmsVehicleId(long tmsVehicleId) {
        this.tmsVehicleId = tmsVehicleId;
    }

    @Column(name = "tms_vehicleregistrationnumber", unique = true, nullable = false, precision = 10, scale = 0)
    public String getTmsVehicleregistrationNumber() {
        return tmsVehicleregistrationNumber;
    }

    public void setTmsVehicleregistrationNumber(String tmsVehicleregistrationNumber) {
        this.tmsVehicleregistrationNumber = tmsVehicleregistrationNumber;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "tms_vehiclebadge", unique = true, nullable = false)
    public TmsBadge getTmsVehiclebadge() {
        return tmsVehiclebadge;
    }

    public void setTmsVehiclebadge(TmsBadge tmsVehiclebadge) {
        this.tmsVehiclebadge = tmsVehiclebadge;
    }

    @Column(name = "tms_vehiclecode", unique = true, nullable = false)
    public String getTmsVehicleCode() {
        return tmsVehicleCode;
    }

    public void setTmsVehicleCode(String tmsVehicleCode) {
        this.tmsVehicleCode = tmsVehicleCode;
    }

    @Column(name = "tms_vehicletechnicalvisit", unique = true, nullable = false)
    public Date getTmsVehicletechnicalVisit() {
        return tmsVehicletechnicalVisit;
    }

    public void setTmsVehicletechnicalVisit(Date tmsVehicletechnicalVisit) {
        this.tmsVehicletechnicalVisit = tmsVehicletechnicalVisit;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "tms_vehiclecategory", unique = true, nullable = false)
    public TmsCategory getTmsVehicleCategory() {
        return tmsVehicleCategory;
    }

    public void setTmsVehicleCategory(TmsCategory tmsVehicleCategory) {
        this.tmsVehicleCategory = tmsVehicleCategory;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "tms_vehicledrivinglicence", unique = true, nullable = false)
    public TmsTraffic getTmsVehicleDrivingLicence() {
        return tmsVehicleDrivingLicence;
    }

    public void setTmsVehicleDrivingLicence(TmsTraffic tmsVehicleDrivingLicence) {
        this.tmsVehicleDrivingLicence = tmsVehicleDrivingLicence;
    }

    @Column(name = "tms_vehiclecreationdate", unique = true, nullable = false)
    public Date getTmsVehicleCreationDate() {
        return tmsVehicleCreationDate;
    }

    public void setTmsVehicleCreationDate(Date tmsVehicleCreationDate) {
        this.tmsVehicleCreationDate = tmsVehicleCreationDate;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_vehiclecreationuser", unique = true, nullable = false)
    public UsrUser getTmsVehicleCreationUser() {
        return tmsVehicleCreationUser;
    }

    public void setTmsVehicleCreationUser(UsrUser tmsVehicleCreationUser) {
        this.tmsVehicleCreationUser = tmsVehicleCreationUser;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_vehicleupdatedate", unique = true, nullable = false)
    public UsrUser getTmsVehicleUpDateDate() {
        return tmsVehicleUpDateDate;
    }

    public void setTmsVehicleUpDateDate(UsrUser tmsVehicleUpDateDate) {
        this.tmsVehicleUpDateDate = tmsVehicleUpDateDate;
    }
}

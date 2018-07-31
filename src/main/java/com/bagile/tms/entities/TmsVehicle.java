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
    private String registrationNumber;
    @Size(max = 30)
    @NotNull
    private TmsBadge badge;
    private String tmsVehicleCode;
    private Date technicalVisit;

    private TmsCategory categoryvehicle;
    private TmsTraffic drivingLicence;

    private Date tmsRoadCreationDate;
    private UsrUser tmsRoadCreationUser;
    private UsrUser tmsRoadUpDateDate;


    public TmsVehicle() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_vehicleid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsVehicleId() {
        return tmsVehicleId;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public TmsBadge getBadge() {
        return badge;
    }

    public void setBadge(TmsBadge badge) {
        this.badge = badge;
    }

    public Date getTechnicalVisit() {
        return technicalVisit;
    }

    public void setTechnicalVisit(Date technicalVisit) {
        this.technicalVisit = technicalVisit;
    }

    public TmsCategory getCategoryvehicle() {
        return categoryvehicle;
    }

    public void setCategoryvehicle(TmsCategory categoryvehicle) {
        this.categoryvehicle = categoryvehicle;
    }

    public void setTmsVehicleId(long tmsVehicleId) {
        this.tmsVehicleId = tmsVehicleId;
    }
    @Column(name = "tms_vehiclecode", nullable = false, length = 30)
    public String getTmsVehicleCode() {
        return tmsVehicleCode;
    }

    public void setTmsVehicleCode(String tmsVehicleCode) {
        this.tmsVehicleCode = tmsVehicleCode;
    }
    @Column(name = "tms_vehiclenbreessieux", nullable = false, length = 30)
    public Long getTmsVehicleNbreEssieux() {
        return tmsVehicleNbreEssieux;
    }

    public void setTmsVehicleNbreEssieux(Long tmsVehicleNbreEssieux) {
        this.tmsVehicleNbreEssieux = tmsVehicleNbreEssieux;
    }
    @Column(name = "tms_vehicleemptyweight", nullable = false, length = 30)
    public BigDecimal getTmsVehicleEmptyWeight() {
        return tmsVehicleEmptyWeight;
    }

    public void setTmsVehicleEmptyWeight(BigDecimal tmsVehicleEmptyWeight) {
        this.tmsVehicleEmptyWeight = tmsVehicleEmptyWeight;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_vehicledateofregistration")
    public Date getTmsVehicleDateOfRegistration() {
        return tmsVehicleDateOfRegistration;
    }

    public void setTmsVehicleDateOfRegistration(Date tmsVehicleDateOfRegistration) {
        this.tmsVehicleDateOfRegistration = tmsVehicleDateOfRegistration;
    }
    @Column(name = "tms_vehiclebrand")
    public String getTmsVehicleBrand() {
        return tmsVehicleBrand;
    }

    public void setTmsVehicleBrand(String tmsVehicleBrand) {
        this.tmsVehicleBrand = tmsVehicleBrand;
    }
    @Column(name = "tms_vehiclemodel")
    public String getTmsVehicleModel() {
        return tmsVehicleModel;
    }

    public void setTmsVehicleModel(String tmsVehicleModel) {
        this.tmsVehicleModel = tmsVehicleModel;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclevehiclestatusid", nullable = false)
    public TmsVehicleStatus getTmsVehicleStatus() {
        return tmsVehicleStatus;
    }

    public void setTmsVehicleStatus(TmsVehicleStatus tmsVehicleStatus) {
        this.tmsVehicleStatus = tmsVehicleStatus;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclevehicletypeid", nullable = false)
    public TmsVehicleType getTmsVehicleType() {
        return tmsVehicleType;
    }

    public void setTmsVehicleType(TmsVehicleType tmsVehicleType) {
        this.tmsVehicleType = tmsVehicleType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tms_vehiclebadgeid",nullable = false)
    public TmsBadge getTmsBadge() {
        return tmsBadge;
    }

    public void setTmsBadge(TmsBadge tmsBadge) {
        this.tmsBadge = tmsBadge;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclemaintenanceplanid", nullable = false)
    public TmsMaintenancePlan getTmsVehicleMaintenancePlan() {
        return tmsVehicleMaintenancePlan;
    }

    public void setTmsVehicleMaintenancePlan(TmsMaintenancePlan tmsVehicleMaintenancePlan) {
        this.tmsVehicleMaintenancePlan = tmsVehicleMaintenancePlan;
    }
    @Column(name = "tms_vehiclematricule")
    public String getTmsVehicleMatricule() {
        return tmsVehicleMatricule;
    }

    public void setTmsVehicleMatricule(String tmsVehicleMatricule) {
        this.tmsVehicleMatricule = tmsVehicleMatricule;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_vehicledatecreation")
    public Date getTmsVehicleDateCreation() {
        return tmsVehicleDateCreation;
    }

    public void setTmsVehicleDateCreation(Date tmsVehicleDateCreation) {
        this.tmsVehicleDateCreation = tmsVehicleDateCreation;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_vehicledateupdate")
    public Date getTmsVehicleDateUpDate() {
        return tmsVehicleDateUpDate;
    }

    public void setTmsVehicleDateUpDate(Date tmsVehicleDateUpDate) {
        this.tmsVehicleDateUpDate = tmsVehicleDateUpDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclecreationuserid")
    public UsrUser getTmsVehicleCreationUser() {
        return tmsVehicleCreationUser;
    }

    public void setTmsVehicleCreationUser(UsrUser tmsVehicleCreationUser) {
        this.tmsVehicleCreationUser = tmsVehicleCreationUser;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehicleupdateuserid")
    public UsrUser getTmsVehicleUpDateUser() {
        return tmsVehicleUpDateUser;
    }

    public void setTmsVehicleUpDateUser(UsrUser tmsVehicleUpDateUser) {
        this.tmsVehicleUpDateUser = tmsVehicleUpDateUser;
    }
}

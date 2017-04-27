package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 */
public class TmsVehicle implements Serializable {
    private long tmsVehicleId;
    @Size(max = 30)
    @NotNull
    private String tmsVehicleCode;
    @Size(max = 30)
    @NotNull
    private Long tmsVehicleNbreEssieux;
    @Size(max = 30)
    @NotNull
    private BigDecimal tmsVehicleEmptyWeight;
    private Date tmsVehicleDateOfRegistration;
    @Size(max = 255)
    private String tmsVehicleBrand;
    @Size(max = 255)
    private String tmsVehicleModel;
    @NotNull
    private TmsVehicleStatus tmsVehicleStatus;
    @NotNull
    private TmsVehicleType tmsVehicleType;
    @NotNull
    private Set<TmsBadge> tmsVehicleBadges;
    @NotNull
    private TmsPoliceInsurance tmsVehiclePoliceAssurance;
    @NotNull
    private TmsMaintenancePlan tmsVehicleMaintenancePlan;
    @Size(max = 30)
    @NotNull
    private String tmsVehicleMatricule;
    private Date tmsVehicleDateCreation;
    private Date tmsVehicleDateUpDate;
    private UsrUser tmsVehicleCreationUser;
    private UsrUser tmsVehicleUpDateUser;



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
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsBadgeVehicule")
    public Set<TmsBadge> getTmsVehicleBadges() {
        return tmsVehicleBadges;
    }

    public void setTmsVehicleBadges(Set<TmsBadge> tmsVehicleBadges) {
        this.tmsVehicleBadges = tmsVehicleBadges;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclepoliceassuranceid", nullable = false)
    public TmsPoliceInsurance getTmsVehiclePoliceAssurance() {
        return tmsVehiclePoliceAssurance;
    }

    public void setTmsVehiclePoliceAssurance(TmsPoliceInsurance tmsVehiclePoliceAssurance) {
        this.tmsVehiclePoliceAssurance = tmsVehiclePoliceAssurance;
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

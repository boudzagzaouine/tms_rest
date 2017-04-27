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
public class PrmVehicle implements Serializable {
    private long prmVehicleId;
    @Size(max = 30)
    @NotNull
    private String prmVehicleCode;
    @Size(max = 30)
    @NotNull
    private Long prmVehicleNbreEssieux;
    @Size(max = 30)
    @NotNull
    private BigDecimal prmVehicleEmptyWeight;
    private Date prmVehicleDateOfRegistration;
    @Size(max = 255)
    private String prmVehicleBrand;
    @Size(max = 255)
    private String prmVehicleModel;
    @NotNull
    private PrmVehicleStatus prmVehicleStatus;
    @NotNull
    private PrmVehicleType prmVehicleType;
    @NotNull
    private Set<PrmBadge> prmVehicleBadges;
    @NotNull
    private AsrPoliceInsurance prmVehiclePoliceAssurance;
    @NotNull
    private MntMaintenancePlan prmVehicleMaintenancePlan;
    @Size(max = 30)
    @NotNull
    private String prmVehicleMatricule;
    private Date prmVehicleDateCreation;
    private Date prmVehicleDateUpDate;
    private UsrUser prmVehicleCreationUser;
    private UsrUser prmVehicleUpDateUser;



    public PrmVehicle() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "prm_vehicleid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmVehicleId() {
        return prmVehicleId;
    }

    public void setPrmVehicleId(long prmVehicleId) {
        this.prmVehicleId = prmVehicleId;
    }
    @Column(name = "prm_vehiclecode", nullable = false, length = 30)
    public String getPrmVehicleCode() {
        return prmVehicleCode;
    }

    public void setPrmVehicleCode(String prmVehicleCode) {
        this.prmVehicleCode = prmVehicleCode;
    }
    @Column(name = "prm_vehiclenbreessieux", nullable = false, length = 30)
    public Long getPrmVehicleNbreEssieux() {
        return prmVehicleNbreEssieux;
    }

    public void setPrmVehicleNbreEssieux(Long prmVehicleNbreEssieux) {
        this.prmVehicleNbreEssieux = prmVehicleNbreEssieux;
    }
    @Column(name = "prm_vehicleemptyweight", nullable = false, length = 30)
    public BigDecimal getPrmVehicleEmptyWeight() {
        return prmVehicleEmptyWeight;
    }

    public void setPrmVehicleEmptyWeight(BigDecimal prmVehicleEmptyWeight) {
        this.prmVehicleEmptyWeight = prmVehicleEmptyWeight;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_vehicledateofregistration")
    public Date getPrmVehicleDateOfRegistration() {
        return prmVehicleDateOfRegistration;
    }

    public void setPrmVehicleDateOfRegistration(Date prmVehicleDateOfRegistration) {
        this.prmVehicleDateOfRegistration = prmVehicleDateOfRegistration;
    }
    @Column(name = "prm_vehiclebrand")
    public String getPrmVehicleBrand() {
        return prmVehicleBrand;
    }

    public void setPrmVehicleBrand(String prmVehicleBrand) {
        this.prmVehicleBrand = prmVehicleBrand;
    }
    @Column(name = "prm_vehiclemodel")
    public String getPrmVehicleModel() {
        return prmVehicleModel;
    }

    public void setPrmVehicleModel(String prmVehicleModel) {
        this.prmVehicleModel = prmVehicleModel;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehiclevehiclestatusid", nullable = false)
    public PrmVehicleStatus getPrmVehicleStatus() {
        return prmVehicleStatus;
    }

    public void setPrmVehicleStatus(PrmVehicleStatus prmVehicleStatus) {
        this.prmVehicleStatus = prmVehicleStatus;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehiclevehicletypeid", nullable = false)
    public PrmVehicleType getPrmVehicleType() {
        return prmVehicleType;
    }

    public void setPrmVehicleType(PrmVehicleType prmVehicleType) {
        this.prmVehicleType = prmVehicleType;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prmBadgeVehicule")
    public Set<PrmBadge> getPrmVehicleBadges() {
        return prmVehicleBadges;
    }

    public void setPrmVehicleBadges(Set<PrmBadge> prmVehicleBadges) {
        this.prmVehicleBadges = prmVehicleBadges;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehiclepoliceassuranceid", nullable = false)
    public AsrPoliceInsurance getPrmVehiclePoliceAssurance() {
        return prmVehiclePoliceAssurance;
    }

    public void setPrmVehiclePoliceAssurance(AsrPoliceInsurance prmVehiclePoliceAssurance) {
        this.prmVehiclePoliceAssurance = prmVehiclePoliceAssurance;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehiclemaintenanceplanid", nullable = false)
    public MntMaintenancePlan getPrmVehicleMaintenancePlan() {
        return prmVehicleMaintenancePlan;
    }

    public void setPrmVehicleMaintenancePlan(MntMaintenancePlan prmVehicleMaintenancePlan) {
        this.prmVehicleMaintenancePlan = prmVehicleMaintenancePlan;
    }
    @Column(name = "prm_vehiclematricule")
    public String getPrmVehicleMatricule() {
        return prmVehicleMatricule;
    }

    public void setPrmVehicleMatricule(String prmVehicleMatricule) {
        this.prmVehicleMatricule = prmVehicleMatricule;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_vehicledatecreation")
    public Date getPrmVehicleDateCreation() {
        return prmVehicleDateCreation;
    }

    public void setPrmVehicleDateCreation(Date prmVehicleDateCreation) {
        this.prmVehicleDateCreation = prmVehicleDateCreation;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_vehicledateupdate")
    public Date getPrmVehicleDateUpDate() {
        return prmVehicleDateUpDate;
    }

    public void setPrmVehicleDateUpDate(Date prmVehicleDateUpDate) {
        this.prmVehicleDateUpDate = prmVehicleDateUpDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehiclecreationuserid")
    public UsrUser getPrmVehicleCreationUser() {
        return prmVehicleCreationUser;
    }

    public void setPrmVehicleCreationUser(UsrUser prmVehicleCreationUser) {
        this.prmVehicleCreationUser = prmVehicleCreationUser;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehicleupdateuserid")
    public UsrUser getPrmVehicleUpDateUser() {
        return prmVehicleUpDateUser;
    }

    public void setPrmVehicleUpDateUser(UsrUser prmVehicleUpDateUser) {
        this.prmVehicleUpDateUser = prmVehicleUpDateUser;
    }
}

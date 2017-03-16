package com.sinno.ems.entities;

import com.sinno.ems.dto.*;

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
    private VehiculeStatus prmVehicleStatus;
    @NotNull
    private VehiculeType prmVehicleType;
    @NotNull
    private Set<Badge> prmVehicleBadges;
    @NotNull
    private PoliceAssurance prmVehiclePoliceAssurance;
    @NotNull
    private MaintenancePlan prmVehicleMaintenancePlan;

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
    public VehiculeStatus getPrmVehicleStatus() {
        return prmVehicleStatus;
    }

    public void setPrmVehicleStatus(VehiculeStatus prmVehicleStatus) {
        this.prmVehicleStatus = prmVehicleStatus;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehiclevehicletypeid", nullable = false)
    public VehiculeType getPrmVehicleType() {
        return prmVehicleType;
    }

    public void setPrmVehicleType(VehiculeType prmVehicleType) {
        this.prmVehicleType = prmVehicleType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehiclebadgeid", nullable = false)
    public Set<Badge> getPrmVehicleBadges() {
        return prmVehicleBadges;
    }

    public void setPrmVehicleBadges(Set<Badge> prmVehicleBadges) {
        this.prmVehicleBadges = prmVehicleBadges;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehiclepoliceassuranceid", nullable = false)
    public PoliceAssurance getPrmVehiclePoliceAssurance() {
        return prmVehiclePoliceAssurance;
    }

    public void setPrmVehiclePoliceAssurance(PoliceAssurance prmVehiclePoliceAssurance) {
        this.prmVehiclePoliceAssurance = prmVehiclePoliceAssurance;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_vehiclemaintenanceplanid", nullable = false)
    public MaintenancePlan getPrmVehicleMaintenancePlan() {
        return prmVehicleMaintenancePlan;
    }

    public void setPrmVehicleMaintenancePlan(MaintenancePlan prmVehicleMaintenancePlan) {
        this.prmVehicleMaintenancePlan = prmVehicleMaintenancePlan;
    }
}

package com.bagile.tms.entities;

import com.bagile.tms.entities.TmsTypeMaintenance;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tms_maintenanceState", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_maintenanceStateId"}))

public class TmsMaintenanceState implements java.io.Serializable {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_maintenanceStateId")
    private long idMaintenanceState;

    @NotNull
    @Column(name = "tms_maintenanceState")
    private String tmsMaintenanceState;

    @Column(name = "tms_maintenanceStateCode")
    private String tmsMaintenanceStateCode;

    @Column(name = "tms_maintenanceStateDescriptif")
    private String tmsMaintenanceStateDescriptif;

    @Column(name = "tms_maintenanceStateDate")
    private Date tmsMaintenanceStateDate;

    @Column(name = "tms_maintenanceStateTitle")
    private String tmsMaintenanceStateTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tms_maintenanceStateCreationDate")
    private Date tmsMaintenanceStateCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenanceStateCreationUser")
    private UsrUser tmsMaintenanceStateCreationUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "tms_maintenanceStateUpdateDate")
    private Date tmsMaintenanceStateUpDateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenanceStateType")
    private TmsTypeMaintenance tmsMaintenanceStateType;

    @OneToOne(mappedBy = "tms_maintenancePlanState")
    private TmsMaintenancePlan tmsMaintenanceStatePlan;

    public TmsMaintenanceState() {
    }

    public long getIdMaintenanceState() {
        return idMaintenanceState;
    }

    public void setIdMaintenanceState(long idMaintenanceState) {
        this.idMaintenanceState = idMaintenanceState;
    }

    public String getTmsMaintenanceState() {
        return tmsMaintenanceState;
    }

    public void setTmsMaintenanceState(String tmsMaintenanceState) {
        this.tmsMaintenanceState = tmsMaintenanceState;
    }

    public String getTmsMaintenanceStateCode() {
        return tmsMaintenanceStateCode;
    }

    public void setTmsMaintenanceStateCode(String tmsMaintenanceStateCode) {
        this.tmsMaintenanceStateCode = tmsMaintenanceStateCode;
    }

    public String getTmsMaintenanceStateDescriptif() {
        return tmsMaintenanceStateDescriptif;
    }

    public void setTmsMaintenanceStateDescriptif(String tmsMaintenanceStateDescriptif) {
        this.tmsMaintenanceStateDescriptif = tmsMaintenanceStateDescriptif;
    }

    public Date getTmsMaintenanceStateDate() {
        return tmsMaintenanceStateDate;
    }

    public void setTmsMaintenanceStateDate(Date tmsMaintenanceStateDate) {
        this.tmsMaintenanceStateDate = tmsMaintenanceStateDate;
    }

    public String getTmsMaintenanceStateTitle() {
        return tmsMaintenanceStateTitle;
    }

    public void setTmsMaintenanceStateTitle(String tmsMaintenanceStateTitle) {
        this.tmsMaintenanceStateTitle = tmsMaintenanceStateTitle;
    }

    public Date getTmsMaintenanceStateCreationDate() {
        return tmsMaintenanceStateCreationDate;
    }

    public void setTmsMaintenanceStateCreationDate(Date tmsMaintenanceStateCreationDate) {
        this.tmsMaintenanceStateCreationDate = tmsMaintenanceStateCreationDate;
    }

    public UsrUser getTmsMaintenanceStateCreationUser() {
        return tmsMaintenanceStateCreationUser;
    }

    public void setTmsMaintenanceStateCreationUser(UsrUser tmsMaintenanceStateCreationUser) {
        this.tmsMaintenanceStateCreationUser = tmsMaintenanceStateCreationUser;
    }

    public Date getTmsMaintenanceStateUpDateDate() {
        return tmsMaintenanceStateUpDateDate;
    }

    public void setTmsMaintenanceStateUpDateDate(Date tmsMaintenanceStateUpDateDate) {
        this.tmsMaintenanceStateUpDateDate = tmsMaintenanceStateUpDateDate;
    }

    public TmsTypeMaintenance getTmsMaintenanceStateType() {
        return tmsMaintenanceStateType;
    }

    public void setTmsMaintenanceStateType(TmsTypeMaintenance tmsMaintenanceStateType) {
        this.tmsMaintenanceStateType = tmsMaintenanceStateType;
    }

    public TmsMaintenancePlan getTmsMaintenanceStatePlan() {
        return tmsMaintenanceStatePlan;
    }

    public void setTmsMaintenanceStatePlan(TmsMaintenancePlan tmsMaintenanceStatePlan) {
        this.tmsMaintenanceStatePlan = tmsMaintenanceStatePlan;
    }
}

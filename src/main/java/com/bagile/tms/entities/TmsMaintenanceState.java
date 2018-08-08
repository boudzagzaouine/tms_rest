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
@Table(name = "tms_maintenancestate", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_maintenanceStateId"}))

public class TmsMaintenanceState implements java.io.Serializable {

    @NotNull
    private long idMaintenanceState;
    @NotNull
    private String tmsMaintenanceState;

    private String tmsMaintenanceStateCode;

    private String tmsMaintenanceStateDescriptif;

    private Date tmsMaintenanceStateDate;

    private String tmsMaintenanceStateTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tmsMaintenanceStateCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private UsrUser tmsMaintenanceStateCreationUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tmsMaintenanceStateUpDateDate;

    private TmsTypeMaintenance tmsMaintenanceStateType;

    public TmsMaintenanceState() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_maintenanceStateId", unique = true, nullable = false, precision = 10, scale = 0)

    public long getIdMaintenanceState() {
        return idMaintenanceState;
    }

    public void setIdMaintenanceState(long idMaintenanceState) {
        this.idMaintenanceState = idMaintenanceState;
    }

    @Column(name = "tms_maintenancestate", unique = true, nullable = false)
    public String getTmsMaintenanceState() {
        return tmsMaintenanceState;
    }

    public void setTmsMaintenanceState(String tmsMaintenanceState) {
        this.tmsMaintenanceState = tmsMaintenanceState;
    }

    @Column(name = "tms_maintenancestatecode", unique = true, nullable = false)
    public String getTmsMaintenanceStateCode() {
        return tmsMaintenanceStateCode;
    }

    public void setTmsMaintenanceStateCode(String tmsMaintenanceStateCode) {
        this.tmsMaintenanceStateCode = tmsMaintenanceStateCode;
    }
    @Column(name = "tms_maintenancestatedescriptif", unique = true, nullable = false)
    public String getTmsMaintenanceStateDescriptif() {
        return tmsMaintenanceStateDescriptif;
    }

    public void setTmsMaintenanceStateDescriptif(String tmsMaintenanceStateDescriptif) {
        this.tmsMaintenanceStateDescriptif = tmsMaintenanceStateDescriptif;
    }

    @Column(name = "tms_maintenancestatedate",nullable = false)
    public Date getTmsMaintenanceStateDate() {
        return tmsMaintenanceStateDate;
    }

    public void setTmsMaintenanceStateDate(Date tmsMaintenanceStateDate) {
        this.tmsMaintenanceStateDate = tmsMaintenanceStateDate;
    }

    @Column(name = "tms_maintenancestatetitle", unique = true, nullable = false)
    public String getTmsMaintenanceStateTitle() {
        return tmsMaintenanceStateTitle;
    }

    public void setTmsMaintenanceStateTitle(String tmsMaintenanceStateTitle) {
        this.tmsMaintenanceStateTitle = tmsMaintenanceStateTitle;
    }

    @Column(name = "tms_maintenancestatecreationdate", unique = true, nullable = false)
    public Date getTmsMaintenanceStateCreationDate() {
        return tmsMaintenanceStateCreationDate;
    }

    public void setTmsMaintenanceStateCreationDate(Date tmsMaintenanceStateCreationDate) {
        this.tmsMaintenanceStateCreationDate = tmsMaintenanceStateCreationDate;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_maintenancestatecreationuser", unique = true, nullable = false)
    public UsrUser getTmsMaintenanceStateCreationUser() {
        return tmsMaintenanceStateCreationUser;
    }

    public void setTmsMaintenanceStateCreationUser(UsrUser tmsMaintenanceStateCreationUser) {
        this.tmsMaintenanceStateCreationUser = tmsMaintenanceStateCreationUser;
    }

    @Column(name = "tms_maintenancestateupdatedate", unique = true, nullable = false)
    public Date getTmsMaintenanceStateUpDateDate() {
        return tmsMaintenanceStateUpDateDate;
    }

    public void setTmsMaintenanceStateUpDateDate(Date tmsMaintenanceStateUpDateDate) {
        this.tmsMaintenanceStateUpDateDate = tmsMaintenanceStateUpDateDate;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_maintenancestatetype", unique = true, nullable = false)
    public TmsTypeMaintenance getTmsMaintenanceStateType() {
        return tmsMaintenanceStateType;
    }

    public void setTmsMaintenanceStateType(TmsTypeMaintenance tmsMaintenanceStateType) {
        this.tmsMaintenanceStateType = tmsMaintenanceStateType;
    }
}

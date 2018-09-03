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
import java.util.Set;

@Entity
@Table(name = "tms_maintenanceState", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_maintenanceStateId"}))

public class TmsMaintenanceState implements java.io.Serializable {

    private long idMaintenanceState;

    @NotNull
    private String tmsMaintenanceState;

    private String tmsMaintenanceStateCode;

    private String tmsMaintenanceStateDescriptif;

    private Date tmsMaintenanceStateDate;

    private String tmsMaintenanceStateTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tmsMaintenanceStateCreationDate;

    private UsrUser tmsMaintenanceStateCreationUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmsMaintenanceStateUpDateDate;

    private TmsTypeMaintenance tmsMaintenanceStateType;

    private Set<TmsMaintenancePlan> tmsMaintenanceStatePlans;

    public TmsMaintenanceState() {
    }

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tms_maintenancestatesequence")
    @Column(name = "tms_maintenanceStateId")
    public long getIdMaintenanceState() {
        return idMaintenanceState;
    }

    public void setIdMaintenanceState(long idMaintenanceState) {
        this.idMaintenanceState = idMaintenanceState;
    }

    @Column(name = "tms_maintenancestate")
    public String getTmsMaintenanceState() {
        return tmsMaintenanceState;
    }

    public void setTmsMaintenanceState(String tmsMaintenanceState) {
        this.tmsMaintenanceState = tmsMaintenanceState;
    }

    @Column(name = "tms_maintenancestatecode")
    public String getTmsMaintenanceStateCode() {
        return tmsMaintenanceStateCode;
    }

    public void setTmsMaintenanceStateCode(String tmsMaintenanceStateCode) {
        this.tmsMaintenanceStateCode = tmsMaintenanceStateCode;
    }

    @Column(name = "tms_maintenancestatedescriptif")
    public String getTmsMaintenanceStateDescriptif() {
        return tmsMaintenanceStateDescriptif;
    }

    public void setTmsMaintenanceStateDescriptif(String tmsMaintenanceStateDescriptif) {
        this.tmsMaintenanceStateDescriptif = tmsMaintenanceStateDescriptif;
    }

    @Column(name = "tms_maintenancestatedate")
    public Date getTmsMaintenanceStateDate() {
        return tmsMaintenanceStateDate;
    }

    public void setTmsMaintenanceStateDate(Date tmsMaintenanceStateDate) {
        this.tmsMaintenanceStateDate = tmsMaintenanceStateDate;
    }

    @Column(name = "tms_maintenancestatetitle")
    public String getTmsMaintenanceStateTitle() {
        return tmsMaintenanceStateTitle;
    }

    public void setTmsMaintenanceStateTitle(String tmsMaintenanceStateTitle) {
        this.tmsMaintenanceStateTitle = tmsMaintenanceStateTitle;
    }

    @Column(name = "tms_maintenancestatecreationdate")
    public Date getTmsMaintenanceStateCreationDate() {
        return tmsMaintenanceStateCreationDate;
    }

    public void setTmsMaintenanceStateCreationDate(Date tmsMaintenanceStateCreationDate) {
        this.tmsMaintenanceStateCreationDate = tmsMaintenanceStateCreationDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenancestatecreationuserid")
    public UsrUser getTmsMaintenanceStateCreationUser() {
        return tmsMaintenanceStateCreationUser;
    }

    public void setTmsMaintenanceStateCreationUser(UsrUser tmsMaintenanceStateCreationUser) {
        this.tmsMaintenanceStateCreationUser = tmsMaintenanceStateCreationUser;
    }

    @Column(name = "tms_maintenancestateupdatedate")
    public Date getTmsMaintenanceStateUpDateDate() {
        return tmsMaintenanceStateUpDateDate;
    }

    public void setTmsMaintenanceStateUpDateDate(Date tmsMaintenanceStateUpDateDate) {
        this.tmsMaintenanceStateUpDateDate = tmsMaintenanceStateUpDateDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenancestatetypeid")
    public TmsTypeMaintenance getTmsMaintenanceStateType() {
        return tmsMaintenanceStateType;
    }

    public void setTmsMaintenanceStateType(TmsTypeMaintenance tmsMaintenanceStateType) {
        this.tmsMaintenanceStateType = tmsMaintenanceStateType;
    }

    @OneToMany(mappedBy = "tmsMaintenanceState")
    public Set<TmsMaintenancePlan> getTmsMaintenanceStatePlans() {
        return tmsMaintenanceStatePlans;
    }

    public void setTmsMaintenanceStatePlans(Set<TmsMaintenancePlan> tmsMaintenanceStatePlans) {
        this.tmsMaintenanceStatePlans = tmsMaintenanceStatePlans;
    }
}

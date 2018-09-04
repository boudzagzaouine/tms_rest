package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tms_maintenanceplan", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_maintenanceplancode"}))
public class TmsMaintenancePlan implements java.io.Serializable{

    private long tmsMaintenancePlanId;
    
    @NotNull
    private TmsVehicle tmsMaintenancePlanVehicle;
    
    @NotNull
    private String tmsMaintenancePlanCode;

    private String tmsMaintenancePlanDescriptif;

    private Date tmsMaintenancePlanDate;
    

    private TmsMaintenanceState tmsMaintenancePlanState;
    
    @NotNull
    private String tmsMaintenancePlanTitle;
    
    @NotNull
    private Date tmsMaintenanceCreationDate;

    private UsrUser tmsMaintenanceCreationUser;

    private Date tmsMaintenanceUpDateDate;

    private TmsTypeMaintenance tmsMaintenanceTypeMaintenance;

    public TmsMaintenancePlan(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tms_maintenanceplansequence")
    @Column(name = "tms_maintenanceplanId")
    public long getTmsMaintenancePlanId() {
        return tmsMaintenancePlanId;
    }

    public void setTmsMaintenancePlanId(long tmsMaintenancePlanId) {
        this.tmsMaintenancePlanId = tmsMaintenancePlanId;
    }

    @JoinColumn(name = "tms_vehicleid")
    public TmsVehicle getTmsMaintenancePlanVehicle() {
        return tmsMaintenancePlanVehicle;
    }

    public void setTmsMaintenancePlanVehicle(TmsVehicle tmsMaintenancePlanVehicle) {
        this.tmsMaintenancePlanVehicle = tmsMaintenancePlanVehicle;
    }

    @Column(name = "tms_maintenanceplancode")
    public String getTmsMaintenancePlanCode() {
        return tmsMaintenancePlanCode;
    }

    public void setTmsMaintenancePlanCode(String tmsMaintenancePlanCode) {
        this.tmsMaintenancePlanCode = tmsMaintenancePlanCode;
    }

    @Column(name = "tms_maintenanceplandescriptif")
    public String getTmsMaintenancePlanDescriptif() {
        return tmsMaintenancePlanDescriptif;
    }

    public void setTmsMaintenancePlanDescriptif(String tmsMaintenancePlanDescriptif) {
        this.tmsMaintenancePlanDescriptif = tmsMaintenancePlanDescriptif;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_maintenanceplandate")
    public Date getTmsMaintenancePlanDate() {
        return tmsMaintenancePlanDate;
    }

    public void setTmsMaintenancePlanDate(Date tmsMaintenancePlanDate) {
        this.tmsMaintenancePlanDate = tmsMaintenancePlanDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenanceplanstateid")
    public TmsMaintenanceState getTmsMaintenancePlanState() {
        return tmsMaintenancePlanState;
    }

    public void setTmsMaintenancePlanState(TmsMaintenanceState tmsMaintenancePlanState) {
        this.tmsMaintenancePlanState = tmsMaintenancePlanState;
    }

    @Column(name = "tms_maintenanceplantitle")
    public String getTmsMaintenancePlanTitle() {
        return tmsMaintenancePlanTitle;
    }

    public void setTmsMaintenancePlanTitle(String tmsMaintenancePlanTitle) {
        this.tmsMaintenancePlanTitle = tmsMaintenancePlanTitle;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_maintenanceplancreationdate" )
    public Date getTmsMaintenanceCreationDate() {
        return tmsMaintenanceCreationDate;
    }

    public void setTmsMaintenanceCreationDate(Date tmsMaintenanceCreationDate) {
        this.tmsMaintenanceCreationDate = tmsMaintenanceCreationDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenanceplancreationuserid")
    public UsrUser getTmsMaintenanceCreationUser() {
        return tmsMaintenanceCreationUser;
    }

    public void setTmsMaintenanceCreationUser(UsrUser tmsMaintenanceCreationUser) {
        this.tmsMaintenanceCreationUser = tmsMaintenanceCreationUser;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_maintenanceplanupdatedate")
    public Date getTmsMaintenanceUpDateDate() {
        return tmsMaintenanceUpDateDate;
    }

    public void setTmsMaintenanceUpDateDate(Date tmsMaintenanceUpDateDate) {
        this.tmsMaintenanceUpDateDate = tmsMaintenanceUpDateDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenancetypemaintenanceid")
    public TmsTypeMaintenance getTmsMaintenanceTypeMaintenance() {
        return tmsMaintenanceTypeMaintenance;
    }

    public void setTmsMaintenanceTypeMaintenance(TmsTypeMaintenance tmsMaintenanceTypeMaintenance) {
        this.tmsMaintenanceTypeMaintenance = tmsMaintenanceTypeMaintenance;
    }


}

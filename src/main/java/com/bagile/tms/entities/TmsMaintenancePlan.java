package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "tms_maintenanceplan", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_maintenanceplanId","tms_maintenancepalncode"}))
public class TmsMaintenancePlan implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_maintenanceplanId")
    private long tmsMaintenancePlanId;
    
    @NotNull
    @JoinColumn(name = "tms_vehicle")
    private TmsVehicle tmsMaintenancePlanVehicle;
    
    @NotNull
    @Column(name = "tms_maintenanceplancode")
    private String tmsMaintenancePlanCode;

    @Column(name = "tms_maintenanceplandescriptif")
    private String tmsMaintenancePlanDescriptif;

    private Date tmsMaintenancePlanDate;
    
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenanceplanstate")
    private TmsMaintenanceState tmsMaintenancePlanState;
    
    @NotNull
    @Column(name = "tms_maintenanceplantitle")
    private String tmsMaintenancePlanTitle;
    
    @NotNull
    @Column(name = "tms_maintenanceplandate")
    private Date tmsMaintenanceCreationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenanceplancreationuser")
    private UsrUser tmsMaintenanceCreationUser;

    @Column(name = "tms_maintenanceplanupdatedate")
    private Date tmsMaintenanceUpDateDate;

    @JoinColumn(name = "tms_maintenancetypemaintenance")
    private TmsTypeMaintenance tmsMaintenanceTypeMaintenance;



    public TmsMaintenancePlan(){

    }

    public long getTmsMaintenancePlanId() {
        return tmsMaintenancePlanId;
    }

    public void setTmsMaintenancePlanId(long tmsMaintenancePlanId) {
        this.tmsMaintenancePlanId = tmsMaintenancePlanId;
    }

    public TmsVehicle getTmsMaintenancePlanVehicle() {
        return tmsMaintenancePlanVehicle;
    }

    public void setTmsMaintenancePlanVehicle(TmsVehicle tmsMaintenancePlanVehicle) {
        this.tmsMaintenancePlanVehicle = tmsMaintenancePlanVehicle;
    }

    public String getTmsMaintenancePlanCode() {
        return tmsMaintenancePlanCode;
    }

    public void setTmsMaintenancePlanCode(String tmsMaintenancePlanCode) {
        this.tmsMaintenancePlanCode = tmsMaintenancePlanCode;
    }

    public String getTmsMaintenancePlanDescriptif() {
        return tmsMaintenancePlanDescriptif;
    }

    public void setTmsMaintenancePlanDescriptif(String tmsMaintenancePlanDescriptif) {
        this.tmsMaintenancePlanDescriptif = tmsMaintenancePlanDescriptif;
    }

    public Date getTmsMaintenancePlanDate() {
        return tmsMaintenancePlanDate;
    }

    public void setTmsMaintenancePlanDate(Date tmsMaintenancePlanDate) {
        this.tmsMaintenancePlanDate = tmsMaintenancePlanDate;
    }

    public TmsMaintenanceState getTmsMaintenancePlanState() {
        return tmsMaintenancePlanState;
    }

    public void setTmsMaintenancePlanState(TmsMaintenanceState tmsMaintenancePlanState) {
        this.tmsMaintenancePlanState = tmsMaintenancePlanState;
    }

    public String getTmsMaintenancePlanTitle() {
        return tmsMaintenancePlanTitle;
    }

    public void setTmsMaintenancePlanTitle(String tmsMaintenancePlanTitle) {
        this.tmsMaintenancePlanTitle = tmsMaintenancePlanTitle;
    }

    public Date getTmsMaintenanceCreationDate() {
        return tmsMaintenanceCreationDate;
    }

    public void setTmsMaintenanceCreationDate(Date tmsMaintenanceCreationDate) {
        this.tmsMaintenanceCreationDate = tmsMaintenanceCreationDate;
    }

    public UsrUser getTmsMaintenanceCreationUser() {
        return tmsMaintenanceCreationUser;
    }

    public void setTmsMaintenanceCreationUser(UsrUser tmsMaintenanceCreationUser) {
        this.tmsMaintenanceCreationUser = tmsMaintenanceCreationUser;
    }

    public Date getTmsMaintenanceUpDateDate() {
        return tmsMaintenanceUpDateDate;
    }

    public void setTmsMaintenanceUpDateDate(Date tmsMaintenanceUpDateDate) {
        this.tmsMaintenanceUpDateDate = tmsMaintenanceUpDateDate;
    }

    public TmsTypeMaintenance getTmsMaintenanceTypeMaintenance() {
        return tmsMaintenanceTypeMaintenance;
    }

    public void setTmsMaintenanceTypeMaintenance(TmsTypeMaintenance tmsMaintenanceTypeMaintenance) {
        this.tmsMaintenanceTypeMaintenance = tmsMaintenanceTypeMaintenance;
    }


}

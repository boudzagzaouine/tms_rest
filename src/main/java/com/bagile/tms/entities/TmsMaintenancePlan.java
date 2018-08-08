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
    private long tmsMaintenancePlanId;
    @NotNull
    private TmsVehicle tmsMaintenancePlanVehicle;
    @NotNull
    private String tmsMaintenancePlanCode;

    private String tmsMaintenancePlanDescriptif;

    private Date tmsMaintenancePlanDate;
    @NotNull
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
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_maintenanceplanId", unique = true, nullable = false, precision = 10, scale = 0)

    public long getTmsMaintenancePlanId() {
        return tmsMaintenancePlanId;
    }

    public void setTmsMaintenancePlanId(long tmsMaintenancePlanId) {
        this.tmsMaintenancePlanId = tmsMaintenancePlanId;
    }

    @Column(name = "tms_vehicle", unique = true, nullable = false)
    public TmsVehicle getTmsMaintenancePlanVehicle() {
        return tmsMaintenancePlanVehicle;
    }

    public void setTmsMaintenancePlanVehicle(TmsVehicle tmsMaintenancePlanVehicle) {
        this.tmsMaintenancePlanVehicle = tmsMaintenancePlanVehicle;
    }

    @Column(name = "tms_maintenanceplancode", unique = true, nullable = false)
    public String getTmsMaintenancePlanCode() {
        return tmsMaintenancePlanCode;
    }

    public void setTmsMaintenancePlanCode(String tmsMaintenancePlanCode) {
        this.tmsMaintenancePlanCode = tmsMaintenancePlanCode;
    }

    @Column(name = "tms_maintenanceplandescriptif", unique = true, nullable = false)
    public String getTmsMaintenancePlanDescriptif() {
        return tmsMaintenancePlanDescriptif;
    }

    public void setTmsMaintenancePlanDescriptif(String tmsMaintenancePlanDescriptif) {
        this.tmsMaintenancePlanDescriptif = tmsMaintenancePlanDescriptif;
    }

    @Column(name = "tms_maintenanceplandate", unique = true, nullable = false)
    public Date getTmsMaintenancePlanDate() {
        return tmsMaintenancePlanDate;
    }

    public void setTmsMaintenancePlanDate(Date tmsMaintenancePlanDate) {
        this.tmsMaintenancePlanDate = tmsMaintenancePlanDate;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "tms_maintenanceplanstate", unique = true, nullable = false)
    public TmsMaintenanceState getTmsMaintenancePlanState() {
        return tmsMaintenancePlanState;
    }

    public void setTmsMaintenancePlanState(TmsMaintenanceState tmsMaintenancePlanState) {
        this.tmsMaintenancePlanState = tmsMaintenancePlanState;
    }

    @Column(name = "tms_maintenanceplantitle")
    public String getTmsMaintenancePlantitle() {
        return tmsMaintenancePlanTitle;
    }

    public void setTmsMaintenancePlanTitle(String tmsMaintenancePlantitle) {
        this.tmsMaintenancePlanTitle = tmsMaintenancePlantitle;
    }

    @Column(name = "tms_maintenanceplancreationdate", unique = true, nullable = false)
    public Date getTmsMaintenanceCreationDate() {
        return tmsMaintenanceCreationDate;
    }

    public void setTmsMaintenanceCreationDate(Date tmsMaintenanceCreationDate) {
        this.tmsMaintenanceCreationDate = tmsMaintenanceCreationDate;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_maintenanceplancreationuser", unique = true, nullable = false)
    public UsrUser getTmsMaintenanceCreationUser() {
        return tmsMaintenanceCreationUser;
    }

    public void setTmsMaintenanceCreationUser(UsrUser tmsMaintenanceCreationUser) {
        this.tmsMaintenanceCreationUser = tmsMaintenanceCreationUser;
    }


    @Column(name = "tms_maintenanceplanupdatedate", unique = true, nullable = false)
    public Date getTmsMaintenanceUpDateDate() {
        return tmsMaintenanceUpDateDate;
    }

    public void setTmsMaintenanceUpDateDate(Date tmsMaintenanceUpDateDate) {
        this.tmsMaintenanceUpDateDate = tmsMaintenanceUpDateDate;
    }


    @Column(name = "tms_maintenanceplancreationdate", unique = true, nullable = false)
    public TmsTypeMaintenance getTypeMaintenance() {
        return tmsMaintenanceTypeMaintenance;
    }

    public void setTypeMaintenance(TmsTypeMaintenance tmsMaintenanceTypeMaintenance) {
        this.tmsMaintenanceTypeMaintenance = tmsMaintenanceTypeMaintenance;
    }
}

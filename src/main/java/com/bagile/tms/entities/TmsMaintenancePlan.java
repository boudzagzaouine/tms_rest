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
    private TmsVehicle tmsVehicle;
    @Size(max = 30)
    @NotNull
    private String tmsMaintenancePlanCode;
    @Size(max = 255)
    private String tmsMaintenancePlanDescriptif;

    private Date tmsMaintenancePlanDate;
    @NotNull
    private TmsMaintenanceState tmsMaintenancePlanState;
    @NotNull
    private String tmsMaintenancePlantitle;
    @NotNull

    private Date tmsMaintenanceCreationDate;

    private UsrUser tmsMaintenanceCreationUser;

    private UsrUser tmsMaintenanceUpDateUser;

    private TmsTypeMaintenance typeMaintenance;

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
    public TmsVehicle getTmsVehicle() {
        return tmsVehicle;
    }

    public void setTmsVehicle(TmsVehicle tmsVehicle) {
        this.tmsVehicle = tmsVehicle;
    }

    @Column(name = "tms_maintenanceplancode", unique = true, nullable = false, precision = 10, scale = 0)
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

    @Column(name = "tms_maintenanceplandate", unique = true, nullable = false, precision = 10, scale = 0)
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
        return tmsMaintenancePlantitle;
    }

    public void setTmsMaintenancePlantitle(String tmsMaintenancePlantitle) {
        this.tmsMaintenancePlantitle = tmsMaintenancePlantitle;
    }

    @Column(name = "tms_maintenanceplancreationdate", unique = true, nullable = false)
    public Date getTmsMaintenanceCreationDate() {
        return tmsMaintenanceCreationDate;
    }

    public void setTmsMaintenanceCreationDate(Date tmsMaintenanceCreationDate) {
        this.tmsMaintenanceCreationDate = tmsMaintenanceCreationDate;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_maintenanceplancreationuser", unique = true, nullable = false)
    public UsrUser getTmsMaintenanceCreationUser() {
        return tmsMaintenanceCreationUser;
    }

    public void setTmsMaintenanceCreationUser(UsrUser tmsMaintenanceCreationUser) {
        this.tmsMaintenanceCreationUser = tmsMaintenanceCreationUser;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "tms_maintenanceplanupdateuser", unique = true, nullable = false)
    public UsrUser getTmsMaintenanceUpDateUser() {
        return tmsMaintenanceUpDateUser;
    }

    public void setTmsMaintenanceUpDateUser(UsrUser tmsMaintenanceUpDateUser) {
        this.tmsMaintenanceUpDateUser = tmsMaintenanceUpDateUser;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "tms_maintenanceplancreationdate", unique = true, nullable = false)
    public TmsTypeMaintenance getTypeMaintenance() {
        return typeMaintenance;
    }

    public void setTypeMaintenance(TmsTypeMaintenance typeMaintenance) {
        this.typeMaintenance = typeMaintenance;
    }
}

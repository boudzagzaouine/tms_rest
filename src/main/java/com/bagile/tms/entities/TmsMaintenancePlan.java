package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "tms_maintenanceplan")
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

    private UsrUser tmsMaintenanceUpDateDate;

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

    public TmsVehicle getTmsVehicle() {
        return tmsVehicle;
    }

    public void setTmsVehicle(TmsVehicle tmsVehicle) {
        this.tmsVehicle = tmsVehicle;
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

    public String getTmsMaintenancePlantitle() {
        return tmsMaintenancePlantitle;
    }

    public void setTmsMaintenancePlantitle(String tmsMaintenancePlantitle) {
        this.tmsMaintenancePlantitle = tmsMaintenancePlantitle;
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

    public UsrUser getTmsMaintenanceUpDateDate() {
        return tmsMaintenanceUpDateDate;
    }

    public void setTmsMaintenanceUpDateDate(UsrUser tmsMaintenanceUpDateDate) {
        this.tmsMaintenanceUpDateDate = tmsMaintenanceUpDateDate;
    }

    public TmsTypeMaintenance getTypeMaintenance() {
        return typeMaintenance;
    }

    public void setTypeMaintenance(TmsTypeMaintenance typeMaintenance) {
        this.typeMaintenance = typeMaintenance;
    }
}

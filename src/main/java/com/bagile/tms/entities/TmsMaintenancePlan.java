package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="tms_maintenanceplan")
public class TmsMaintenancePlan extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1640304759359470684L;
    @Id
    @GeneratedValue
    @Column(name = "tms_maintenanceplanid")
    private int tmsMaintenancePlanid;
    @Column(name = "tms_maintenanceplancode")
    private String tmsMaintenancePlancode;
    @Column(name = "tms_maintenanceplandescriptif")
    private String tmsMaintenancePlandescriptif;
    @Column(name = "tms_maintenanceplancreationdatae")
    private Date tmsMaintenancePlancreationDatae;
    @Column(name = "tms_maintenanceplanupdatedate")
    private Date tmsMaintenancePlanupDate;
    @Column(name = "tms_maintenanceplanbegin")
    private Date tmsMaintenancePlanbegin;
    @Column(name = "Tms_MaintenancePlanEnd")
    private Date tmsMaintenancePlanend;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenancetypeid")
    private TmsMaintenanceType tmsMaintenanceType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_maintenancestateid")
    private TmsMaintenanceState tmsMaintenanceState;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiculeid")
   private TmsVehicle tmsVehicle;


    public TmsMaintenancePlan() {
    }

    public int getTmsMaintenancePlanid() {
        return tmsMaintenancePlanid;
    }

    public void setTmsMaintenancePlanid(int tmsMaintenancePlanid) {
        this.tmsMaintenancePlanid = tmsMaintenancePlanid;
    }

    public String getTmsMaintenancePlancode() {
        return tmsMaintenancePlancode;
    }

    public void setTmsMaintenancePlancode(String tmsMaintenancePlancode) {
        this.tmsMaintenancePlancode = tmsMaintenancePlancode;
    }

    public String getTmsMaintenancePlandescriptif() {
        return tmsMaintenancePlandescriptif;
    }

    public void setTmsMaintenancePlandescriptif(String tmsMaintenancePlandescriptif) {
        this.tmsMaintenancePlandescriptif = tmsMaintenancePlandescriptif;
    }

    public Date getTmsMaintenancePlancreationDatae() {
        return tmsMaintenancePlancreationDatae;
    }

    public void setTmsMaintenancePlancreationDatae(Date tmsMaintenancePlancreationDatae) {
        this.tmsMaintenancePlancreationDatae = tmsMaintenancePlancreationDatae;
    }

    public Date getTmsMaintenancePlanupDate() {
        return tmsMaintenancePlanupDate;
    }

    public void setTmsMaintenancePlanupDate(Date tmsMaintenancePlanupDateDate) {
        this.tmsMaintenancePlanupDate = tmsMaintenancePlanupDateDate;
    }

    public Date getTmsMaintenancePlanbegin() {
        return tmsMaintenancePlanbegin;
    }

    public void setTmsMaintenancePlanbegin(Date tmsMaintenancePlanbegin) {
        this.tmsMaintenancePlanbegin = tmsMaintenancePlanbegin;
    }

    public Date getTmsMaintenancePlanend() {
        return tmsMaintenancePlanend;
    }

    public void setTmsMaintenancePlanend(Date tmsMaintenancePlanend) {
        this.tmsMaintenancePlanend = tmsMaintenancePlanend;
    }

    public TmsMaintenanceType getTmsMaintenanceType() {
        return tmsMaintenanceType;
    }

    public void setTmsMaintenanceType(TmsMaintenanceType tmsMaintenanceType) {
        this.tmsMaintenanceType = tmsMaintenanceType;
    }

    public TmsMaintenanceState getTmsMaintenanceState() {
        return tmsMaintenanceState;
    }

    public void setTmsMaintenanceState(TmsMaintenanceState tmsMaintenanceState) {
        this.tmsMaintenanceState = tmsMaintenanceState;
    }

    public TmsVehicle getTmsVehicle() {
        return tmsVehicle;
    }

    public void setTmsVehicle(TmsVehicle tmsVehicle) {
        this.tmsVehicle = tmsVehicle;
    }
}

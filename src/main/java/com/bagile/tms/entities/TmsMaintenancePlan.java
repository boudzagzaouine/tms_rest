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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_maintenance_plan_id", allocationSize = 1)
    @Column(name = "tms_maintenanceplanid", unique = true, nullable = false, precision = 10, scale = 0)
    private int tmsMaintenancePlanId;
    @Column(name = "tms_maintenanceplancode")
    private String tmsMaintenancePlanCode;
    @Column(name = "tms_maintenanceplandescription")
    private String tmsMaintenancePlanDescription;
    @Column(name = "tms_maintenanceplancreationdatae")
    private Date tmsMaintenancePlancreationDatae;
    @Column(name = "tms_maintenanceplanupdatedate")
    private Date tmsMaintenancePlanUpdateDate;
    @Column(name = "tms_maintenanceplanstartdate")
    private Date tmsMaintenancePlanStartDate;
    @Column(name = "Tms_Maintenanceplanenddate")
    private Date tmsMaintenancePlanEndDate;
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

    public int getTmsMaintenancePlanId() {
        return tmsMaintenancePlanId;
    }

    public void setTmsMaintenancePlanId(int tmsMaintenancePlanId) {
        this.tmsMaintenancePlanId = tmsMaintenancePlanId;
    }

    public String getTmsMaintenancePlanCode() {
        return tmsMaintenancePlanCode;
    }

    public void setTmsMaintenancePlanCode(String tmsMaintenancePlanCode) {
        this.tmsMaintenancePlanCode = tmsMaintenancePlanCode;
    }

    public String getTmsMaintenancePlanDescription() {
        return tmsMaintenancePlanDescription;
    }

    public void setTmsMaintenancePlanDescription(String tmsMaintenancePlanDescription) {
        this.tmsMaintenancePlanDescription = tmsMaintenancePlanDescription;
    }

    public Date getTmsMaintenancePlancreationDatae() {
        return tmsMaintenancePlancreationDatae;
    }

    public void setTmsMaintenancePlancreationDatae(Date tmsMaintenancePlancreationDatae) {
        this.tmsMaintenancePlancreationDatae = tmsMaintenancePlancreationDatae;
    }

    public Date getTmsMaintenancePlanUpdateDate() {
        return tmsMaintenancePlanUpdateDate;
    }

    public void setTmsMaintenancePlanUpdateDate(Date tmsMaintenancePlanupDateDate) {
        this.tmsMaintenancePlanUpdateDate = tmsMaintenancePlanupDateDate;
    }

    public Date getTmsMaintenancePlanStartDate() {
        return tmsMaintenancePlanStartDate;
    }

    public void setTmsMaintenancePlanStartDate(Date tmsMaintenancePlanStartDate) {
        this.tmsMaintenancePlanStartDate = tmsMaintenancePlanStartDate;
    }

    public Date getTmsMaintenancePlanEndDate() {
        return tmsMaintenancePlanEndDate;
    }

    public void setTmsMaintenancePlanEndDate(Date tmsMaintenancePlanEndDate) {
        this.tmsMaintenancePlanEndDate = tmsMaintenancePlanEndDate;
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

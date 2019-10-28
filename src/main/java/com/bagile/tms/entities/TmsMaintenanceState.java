package com.bagile.tms.entities;

import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name="tms_maintenancestate")
public class TmsMaintenanceState  extends EmsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_maintenancestateid", allocationSize = 1)
    @Column(name = "tms_maintenancestateid", unique = true, nullable = false, precision = 10, scale = 0)
    private int tmsMaintenanceStateId;
    @Column(name = "tms_maintenancestatecode")
    private String tmsMaintenanceStateCode;
    @Column(name = "tms_maintenancestatedescription")
    private String tmsMaintenanceStateDescription;
    @Column(name = "tms_maintenancestatecreationDate")
    private Date tmsMaintenanceStateCreationDate;


    public TmsMaintenanceState() {
    }

    public int getTmsMaintenanceStateId() {
        return tmsMaintenanceStateId;
    }

    public void setTmsMaintenanceStateId(int tmsMaintenanceStateId) {
        tmsMaintenanceStateId = tmsMaintenanceStateId;
    }

    public String getTmsMaintenanceStateCode() {
        return tmsMaintenanceStateCode;
    }

    public void setTmsMaintenanceStateCode(String tmsMaintenanceStateCode) {
        tmsMaintenanceStateCode = tmsMaintenanceStateCode;
    }

    public String getTmsMaintenanceStateDescription() {
        return tmsMaintenanceStateDescription;
    }

    public void setTmsMaintenanceStateDescription(String tmsMaintenanceStateDescription) {
        tmsMaintenanceStateDescription = tmsMaintenanceStateDescription;
    }

    public Date getTmsMaintenanceStateCreationDate() {
        return tmsMaintenanceStateCreationDate;
    }

    public void setTmsMaintenanceStateCreationDate(Date tmsMaintenanceStateCreationDate) {
        tmsMaintenanceStateCreationDate = tmsMaintenanceStateCreationDate;
    }
}

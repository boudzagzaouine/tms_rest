package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;

public class MaintenancePlan extends EmsDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6036580510935986433L;
    private int id;
    private String code;
    private String descriptif;
    private Date creationDatae;
    private Date upDate;
    private Date begin;
    private Date end;
    private MaintenanceType maintenanceType;
    private MaintenanceState maintenanceState;
   private Vehicle vehicule;


    public MaintenancePlan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public Date getCreationDatae() {
        return creationDatae;
    }

    public void setCreationDatae(Date creationDatae) {
        this.creationDatae = creationDatae;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDateDate) {
        this.upDate = upDateDate;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public MaintenanceType getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(MaintenanceType maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public MaintenanceState getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(MaintenanceState maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public Vehicle getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicle vehicule) {
        this.vehicule = vehicule;
    }
}

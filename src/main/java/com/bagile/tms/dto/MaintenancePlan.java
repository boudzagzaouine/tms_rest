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
    private String description;
    private Date begin;
    private Date end;
    private MaintenanceType maintenanceType;
    private MaintenanceState maintenanceState;
   private Vehicle vehicle;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

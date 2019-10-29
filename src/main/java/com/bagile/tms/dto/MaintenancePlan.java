package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class MaintenancePlan extends EmsDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6036580510935986433L;
    private Long id;
    private String code;
    private String description;
    private Date begin;
    private Date end;
    private MaintenanceType maintenanceType;
    private MaintenanceState maintenanceState;
   private Vehicle vehicle;


    public MaintenancePlan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenancePlan that = (MaintenancePlan) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

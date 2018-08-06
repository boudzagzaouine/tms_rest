package com.bagile.tms.dto;

import com.bagile.tms.entities.TmsMaintenanceState;
import com.bagile.tms.entities.TmsTypeMaintenance;
import com.bagile.tms.entities.TmsVehicle;
import com.bagile.tms.entities.UsrUser;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class MaintenancePlan implements Serializable {

    private long id;
    private Vehicle vehicle;
    private String code;
    private String descriptif;

    private Date date;
    private MaintenanceState state;
    private String title;

    private Date creationDate;

    private UsrUser creationUser;

    private UsrUser upDateUser;

    private TmsTypeMaintenance typeMaintenance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MaintenanceState getState() {
        return state;
    }

    public void setState(MaintenanceState state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UsrUser getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(UsrUser creationUser) {
        this.creationUser = creationUser;
    }

    public UsrUser getUpDateUser() {
        return upDateUser;
    }

    public void setUpDateUser(UsrUser upDateUser) {
        this.upDateUser = upDateUser;
    }

    public TmsTypeMaintenance getTypeMaintenance() {
        return typeMaintenance;
    }

    public void setTypeMaintenance(TmsTypeMaintenance typeMaintenance) {
        this.typeMaintenance = typeMaintenance;
    }
}

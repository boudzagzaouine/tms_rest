package com.sinno.ems.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "mnt_MaintenancePlan", uniqueConstraints = @UniqueConstraint(columnNames = {"mnt_maintenanceplancode","mnt_maintenanceplanvehicleid"}))
public class MntMaintenancePlan implements java.io.Serializable{
    private long mntMaintenancePlanId;
    @NotNull
    private Vehicle Vehicle;
    @Size(max = 30)
    @NotNull
    private String mntMaintenancePlanCode;
    @Size(max = 255)
    private String mntDescription;
    //acte

    public MntMaintenancePlan(){

    }
    public MntMaintenancePlan(long mntMaintenancePlanId,Vehicle Vehicle,String mntMaintenancePlanCode){
        this.mntMaintenancePlanId=mntMaintenancePlanId;
        this.Vehicle=Vehicle;
        this.mntMaintenancePlanCode=mntMaintenancePlanCode;

    }
    public MntMaintenancePlan(long mntMaintenancePlanId,Vehicle Vehicle,String mntMaintenancePlanCode,String mntDescription){
        this.mntMaintenancePlanId=mntMaintenancePlanId;
        this.Vehicle=Vehicle;
        this.mntMaintenancePlanCode=mntMaintenancePlanCode;
        this.mntDescription=mntDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_mnt_maintenanceplan", allocationSize = 1)
    @Column(name = "mnt_maintenanceplanid", unique = true, nullable = false, precision = 10, scale = 0)


    public long getMntMaintenancePlanId() {
        return mntMaintenancePlanId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mnt_maintenanceplanvehicleid", nullable = false)

    public com.sinno.ems.entities.Vehicle getVehicle() {
        return Vehicle;
    }

    public void setMntMaintenancePlanId(long mntMaintenancePlanId) {
        this.mntMaintenancePlanId = mntMaintenancePlanId;
    }

    public void setVehicle(com.sinno.ems.entities.Vehicle vehicle) {
        Vehicle = vehicle;
    }

    public void setMntMaintenancePlanCode(String mntMaintenancePlanCode) {
        this.mntMaintenancePlanCode = mntMaintenancePlanCode;
    }

    public void setMntDescription(String mntDescription) {
        this.mntDescription = mntDescription;
    }

    @Column(name = "mnt_maintenanceplancode", nullable = false, length = 30)
    public String getMntMaintenancePlanCode() {
        return mntMaintenancePlanCode;
    }

    @Column(name = "mntDescription")
    public String getMntDescription() {
        return mntDescription;
    }
}

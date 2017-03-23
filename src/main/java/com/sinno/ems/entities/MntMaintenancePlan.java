package com.sinno.ems.entities;

import com.sinno.ems.dto.Acte;
import com.sinno.ems.dto.Vehicule;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 */
@Entity
@Table(name = "mnt_maintenanceplan")
public class MntMaintenancePlan implements java.io.Serializable{
    private long mntMaintenancePlanId;
    @NotNull
    private PrmVehicle vehicle;
    @Size(max = 30)
    @NotNull
    private String mntMaintenancePlanCode;
    @Size(max = 255)
    private String mntDescription;
    private Set<Acte> mntMaintenancePlanActes;

    public MntMaintenancePlan(){

    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_mnt_maintenanceplan", allocationSize = 1)
    @Column(name = "mnt_maintenanceplanid", unique = true, nullable = false, precision = 10, scale = 0)


    public long getMntMaintenancePlanId() {
        return mntMaintenancePlanId;
    }

    public void setMntMaintenancePlanId(long mntMaintenancePlanId) {
        this.mntMaintenancePlanId = mntMaintenancePlanId;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mnt_maintenanceplanvehicleid", nullable = false)
    public PrmVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(PrmVehicle vehicle) {
        this.vehicle = vehicle;
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

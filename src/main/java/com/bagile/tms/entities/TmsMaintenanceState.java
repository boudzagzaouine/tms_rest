package com.bagile.tms.entities;

import com.bagile.tms.dto.TypeMaintenance;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tms_maintenancestate", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_maintenanceStateId"}))

public class TmsMaintenanceState implements java.io.Serializable {

    @NotNull
    private long idMaintenanceState;
    @NotNull
    private String tmsMaintenanceState;

    private TmsVehicle tmsMaintenanceStateVehicle;

    private String tmsMaintenanceStateCode;

    private String tmsMaintenanceStateDescriptif;

    private Date tmsMaintenanceStateDate;

    private String tmsMaintenanceStateTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tmsMaintenanceStateCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private UsrUser tmsMaintenanceStateCreationUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private UsrUser tmsMaintenanceStateUpDateDate;

    private TypeMaintenance tmsMaintenanceStateType;

    public TmsMaintenanceState() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_maintenanceStateId", unique = true, nullable = false, precision = 10, scale = 0)

    public long getIdMaintenanceState() {
        return idMaintenanceState;
    }

    public void setIdMaintenanceState(long idMaintenanceState) {
        this.idMaintenanceState = idMaintenanceState;
    }

    @Column(name = "tms_maintenancestate", unique = true, nullable = false)
    public String getTmsMaintenanceState() {
        return tmsMaintenanceState;
    }

    public void setTmsMaintenanceState(String tmsMaintenanceState) {
        this.tmsMaintenanceState = tmsMaintenanceState;
    }

    public TmsVehicle getTmsMaintenanceStateVehicle() {
        return tmsMaintenanceStateVehicle;
    }

    public void setTmsMaintenanceStateVehicle(TmsVehicle tmsMaintenanceStateVehicle) {
        this.tmsMaintenanceStateVehicle = tmsMaintenanceStateVehicle;
    }

    public String getTmsMaintenanceStateCode() {
        return tmsMaintenanceStateCode;
    }

    public void setTmsMaintenanceStateCode(String tmsMaintenanceStateCode) {
        this.tmsMaintenanceStateCode = tmsMaintenanceStateCode;
    }

    public String getTmsMaintenanceStateDescriptif() {
        return tmsMaintenanceStateDescriptif;
    }

    public void setTmsMaintenanceStateDescriptif(String tmsMaintenanceStateDescriptif) {
        this.tmsMaintenanceStateDescriptif = tmsMaintenanceStateDescriptif;
    }

    public Date getTmsMaintenanceStateDate() {
        return tmsMaintenanceStateDate;
    }

    public void setTmsMaintenanceStateDate(Date tmsMaintenanceStateDate) {
        this.tmsMaintenanceStateDate = tmsMaintenanceStateDate;
    }

    public String getTmsMaintenanceStateTitle() {
        return tmsMaintenanceStateTitle;
    }

    public void setTmsMaintenanceStateTitle(String tmsMaintenanceStateTitle) {
        this.tmsMaintenanceStateTitle = tmsMaintenanceStateTitle;
    }

    public Date getTmsMaintenanceStateCreationDate() {
        return tmsMaintenanceStateCreationDate;
    }

    public void setTmsMaintenanceStateCreationDate(Date tmsMaintenanceStateCreationDate) {
        this.tmsMaintenanceStateCreationDate = tmsMaintenanceStateCreationDate;
    }

    public UsrUser getTmsMaintenanceStateCreationUser() {
        return tmsMaintenanceStateCreationUser;
    }

    public void setTmsMaintenanceStateCreationUser(UsrUser tmsMaintenanceStateCreationUser) {
        this.tmsMaintenanceStateCreationUser = tmsMaintenanceStateCreationUser;
    }

    public UsrUser getTmsMaintenanceStateUpDateDate() {
        return tmsMaintenanceStateUpDateDate;
    }

    public void setTmsMaintenanceStateUpDateDate(UsrUser tmsMaintenanceStateUpDateDate) {
        this.tmsMaintenanceStateUpDateDate = tmsMaintenanceStateUpDateDate;
    }

    public TypeMaintenance getTmsMaintenanceStateType() {
        return tmsMaintenanceStateType;
    }

    public void setTmsMaintenanceStateType(TypeMaintenance tmsMaintenanceStateType) {
        this.tmsMaintenanceStateType = tmsMaintenanceStateType;
    }
}

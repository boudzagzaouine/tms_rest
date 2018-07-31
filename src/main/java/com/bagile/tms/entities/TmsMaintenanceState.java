package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

    @Entity
    @Table(name = "tms_maintenancestate")

    public class TmsMaintenanceState implements java.io.Serializable{
    private long idMaintenanceState;
    @NotNull
    private String state;
    @NotNull

    public TmsMaintenanceState() { }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_maintenanceStateId", unique = true, nullable = false, precision = 10, scale = 0)

    public int getIdMaintenance() {
        return idMaintenance;
    }
    public void setIdMaintenance(int idMaintenance) {
        this.idMaintenance = idMaintenance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

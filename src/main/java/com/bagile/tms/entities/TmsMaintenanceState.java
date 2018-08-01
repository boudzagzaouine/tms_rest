package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

    @Entity
    @Table(name = "tms_maintenancestate",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_maintenanceStateId"}))

    public class TmsMaintenanceState implements java.io.Serializable{
    private long idMaintenanceState;
    @NotNull
    private String tmsMaintenanceState;
    @NotNull

    public TmsMaintenanceState() { }
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
    }

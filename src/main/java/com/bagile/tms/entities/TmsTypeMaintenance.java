package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class TmsTypeMaintenance {
    private int tmsTypeMaintenanceId;
    @NotNull
    private String tmsTypeMaintenancetype;
    @NotNull

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_TypeMaintenanceId", unique = true, nullable = false, precision = 10, scale = 0)

    public int getTmsTypeMaintenanceId() {
        return tmsTypeMaintenanceId;
    }

    public void setTmsTypeMaintenanceId(int tmsTypeMaintenanceId) {
        this.tmsTypeMaintenanceId = tmsTypeMaintenanceId;
    }

    public String getTmsTypeMaintenancetype() {
        return tmsTypeMaintenancetype;
    }

    public void setTmsTypeMaintenancetype(String tmsTypeMaintenancetype) {
        this.tmsTypeMaintenancetype = tmsTypeMaintenancetype;
    }
}

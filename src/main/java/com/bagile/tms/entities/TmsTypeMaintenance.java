package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tms_typeMaintenance",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_typeMaintenanceId"}))
public class TmsTypeMaintenance {

    @NotNull
    private int tmsTypeMaintenanceId;

    @NotNull
    private String tmsTypeMaintenancetype;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_typeMaintenanceId", unique = true, nullable = false, precision = 10, scale = 0)

    public int getTmsTypeMaintenanceId() {
        return tmsTypeMaintenanceId;
    }

    public void setTmsTypeMaintenanceId(int tmsTypeMaintenanceId) {
        this.tmsTypeMaintenanceId = tmsTypeMaintenanceId;
    }

    @Column(name = "tms_TypeMaintenancetype", unique = true, nullable = false)
    public String getTmsTypeMaintenancetype() {
        return tmsTypeMaintenancetype;
    }

    public void setTmsTypeMaintenancetype(String tmsTypeMaintenancetype) {
        this.tmsTypeMaintenancetype = tmsTypeMaintenancetype;
    }
}

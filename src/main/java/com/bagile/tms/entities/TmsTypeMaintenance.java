package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="tms_typeMaintenance",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_typeMaintenanceId"}))
public class TmsTypeMaintenance {

    @NotNull
    private int tmsTypeMaintenanceId;

    @NotNull
    private String tmsTypeMaintenanceType;
    
    @OneToMany(mappedBy = "tmsMaintenanceStateType")
    private Set<TmsMaintenanceState> tmsTypeMaintenanceStates;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tms_typemaintenancesequence")
    @Column(name = "tms_typeMaintenanceId", unique = true, nullable = false, precision = 10, scale = 0)

    public int getTmsTypeMaintenanceId() {
        return tmsTypeMaintenanceId;
    }

    public void setTmsTypeMaintenanceId(int tmsTypeMaintenanceId) {
        this.tmsTypeMaintenanceId = tmsTypeMaintenanceId;
    }

    @Column(name = "tms_TypeMaintenanceType", unique = true, nullable = false)
    public String getTmsTypeMaintenanceType() {
        return tmsTypeMaintenanceType;
    }

    public void setTmsTypeMaintenanceType(String tmsTypeMaintenanceType) {
        this.tmsTypeMaintenanceType = tmsTypeMaintenanceType;
    }
}

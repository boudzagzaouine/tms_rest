package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class TmsTypeMaintenance {
    private int idTypeMaintenance;
    @NotNull
    private String type;
    @NotNull

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_TypeMaintenanceId", unique = true, nullable = false, precision = 10, scale = 0)
    public int getIdTypeMaintenance() {
        return idTypeMaintenance;
    }

    public void setIdTypeMaintenance(int idTypeMaintenance) {
        this.idTypeMaintenance = idTypeMaintenance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

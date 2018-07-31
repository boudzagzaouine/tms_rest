package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Set;

public class TmsZone {
    private int idZone;
    private String zoneName;
    private Set<TmsDriver> tmsDrivers;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_idZone", unique = true, nullable = false, scale = 0)
    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @OneToMany(FetchType=FetchType.LAZY,mappedBy = "workArea")
    public Set<TmsDriver> getTmsDrivers() {
        return tmsDrivers;
    }

    public void setTmsDrivers(Set<TmsDriver> tmsDrivers) {
        this.tmsDrivers = tmsDrivers;
    }

    @Override
    public String toString() {
        return "TmsZone{" +
                "idZone=" + idZone +
                ", zoneName='" + zoneName + '\'' +
                '}';
    }
}

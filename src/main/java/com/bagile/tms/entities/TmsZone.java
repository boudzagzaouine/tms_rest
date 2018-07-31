package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Set;

public class TmsZone {
    private int tmsZoneId;
    private String tmsZoneName;
    private Set<TmsDriver> tmsZoneDrivers;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_idZone", unique = true, nullable = false, scale = 0)

    public int getTmsZoneId() {
        return tmsZoneId;
    }

    public void setTmsZoneId(int tmsZoneId) {
        this.tmsZoneId = tmsZoneId;
    }

    public String getTmsZoneName() {
        return tmsZoneName;
    }

    public void setTmsZoneName(String tmsZoneName) {
        this.tmsZoneName = tmsZoneName;
    }

    public Set<TmsDriver> getTmsZoneDrivers() {
        return tmsZoneDrivers;
    }

    public void setTmsZoneDrivers(Set<TmsDriver> tmsZoneDrivers) {
        this.tmsZoneDrivers = tmsZoneDrivers;
    }
}

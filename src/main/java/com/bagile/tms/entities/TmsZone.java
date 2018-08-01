package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tms_zone",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_zoneId"}))

public class TmsZone {
    private long tmsZoneId;
    private String tmsZoneName;
    private Set<TmsDriver> tmsZoneDrivers;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_zoneId", unique = true, nullable = false, scale = 0)

    public long getTmsZoneId() {
        return tmsZoneId;
    }

    public void setTmsZoneId(int tmsZoneId) {
        this.tmsZoneId = tmsZoneId;
    }

    @Column(name = "tms_zonename")
    public String getTmsZoneName() {
        return tmsZoneName;
    }

    public void setTmsZoneName(String tmsZoneName) {
        this.tmsZoneName = tmsZoneName;
    }

    @Column(name = "tms_zonedrivers")
    public Set<TmsDriver> getTmsZoneDrivers() {
        return tmsZoneDrivers;
    }

    public void setTmsZoneDrivers(Set<TmsDriver> tmsZoneDrivers) {
        this.tmsZoneDrivers = tmsZoneDrivers;
    }
}

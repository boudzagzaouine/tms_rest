package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_zone")
public class TmsZone   extends EmsEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_zoneid", allocationSize = 1)
    @Column(name = "tms_zoneid", unique = true, nullable = false, precision = 10, scale = 0)
    private int tmsZoneId;
    @Column(name = "tms_zonename")
    private String tmsZoneName;

    public TmsZone() {
    }

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
}

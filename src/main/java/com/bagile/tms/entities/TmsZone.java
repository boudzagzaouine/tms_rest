package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_zone")
public class TmsZone   extends EmsEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_zone_id", allocationSize = 1)
    @Column(name = "tms_zoneid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long tmsZoneId;
    @Column(name = "tms_zonename",  unique = true, nullable = false, length = 90)
    private String tmsZoneName;

    public TmsZone() {
    }

    public Long getTmsZoneId() {
        return tmsZoneId;
    }

    public void setTmsZoneId(Long tmsZoneId) {
        this.tmsZoneId = tmsZoneId;
    }

    public String getTmsZoneName() {
        return tmsZoneName;
    }

    public void setTmsZoneName(String tmsZoneName) {
        this.tmsZoneName = tmsZoneName;
    }
}

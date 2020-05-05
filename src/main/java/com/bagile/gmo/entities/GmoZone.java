package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name="gmo_zone")
public class GmoZone   extends EmsEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_zone_id", allocationSize = 1)
    @Column(name = "gmo_zoneid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long gmoZoneId;
    @Column(name = "gmo_zonename",  unique = true, nullable = false, length = 90)
    private String gmoZoneName;

    public GmoZone() {
    }

    public Long getGmoZoneId() {
        return gmoZoneId;
    }

    public void setGmoZoneId(Long gmoZoneId) {
        this.gmoZoneId = gmoZoneId;
    }

    public String getGmoZoneName() {
        return gmoZoneName;
    }

    public void setGmoZoneName(String gmoZoneName) {
        this.gmoZoneName = gmoZoneName;
    }
}

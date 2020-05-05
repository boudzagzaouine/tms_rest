package com.bagile.gmo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "gmo_diverzone")
public class GmoDriverZone extends EmsEntity {
    /**
     *
     */
    private static final long serialVersionUID = 7073980697050572481L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_diver_zone_id", allocationSize = 1)
    @Column(name = "gmo_diverzoneid", unique = true, nullable = false, precision = 10, scale = 0)
    private long gmoDriverZoneId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_driverid")
    private GmoDriver gmoDriverZoneDriver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_zoneid")
    private GmoZone gmoDriverZoneZone;



    public GmoDriverZone() {
    }

    public Long getGmoDriverZoneId() {
        return gmoDriverZoneId;
    }

    public void setGmoDriverZoneId(Long gmoDriverZoneId) {
        this.gmoDriverZoneId = gmoDriverZoneId;
    }

    public GmoDriver getGmoDriverZoneDriver() {
        return gmoDriverZoneDriver;
    }

    public void setGmoDriverZoneDriver(GmoDriver gmoDriverZoneDriver) {
        this.gmoDriverZoneDriver = gmoDriverZoneDriver;
    }

    public GmoZone getGmoDriverZoneZone() {
        return gmoDriverZoneZone;
    }

    public void setGmoDriverZoneZone(GmoZone gmoDriverZoneZone) {
        this.gmoDriverZoneZone = gmoDriverZoneZone;
    }


}

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
@Table(name = "tms_diverzone")
public class TmsDriverZone extends EmsEntity {
    /**
     *
     */
    private static final long serialVersionUID = 7073980697050572481L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_diver_zone_id", allocationSize = 1)
    @Column(name = "tms_diverzoneid", unique = true, nullable = false, precision = 10, scale = 0)
    private long tmsDriverZoneId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverid")
    private GmoDriver gmoDriverZoneDriver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_zoneid")
    private TmsZone tmsDriverZoneZone;



    public TmsDriverZone() {
    }

    public Long getTmsDriverZoneId() {
        return tmsDriverZoneId;
    }

    public void setTmsDriverZoneId(Long tmsDriverZoneId) {
        this.tmsDriverZoneId = tmsDriverZoneId;
    }

    public GmoDriver getGmoDriverZoneDriver() {
        return gmoDriverZoneDriver;
    }

    public void setTmsDriverZoneDriver(GmoDriver gmoDriverZoneDriver) {
        this.gmoDriverZoneDriver = gmoDriverZoneDriver;
    }

    public TmsZone getTmsDriverZoneZone() {
        return tmsDriverZoneZone;
    }

    public void setTmsDriverZoneZone(TmsZone tmsDriverZoneZone) {
        this.tmsDriverZoneZone = tmsDriverZoneZone;
    }


}

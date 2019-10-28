package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tms_diverzone")
public class TmsDriverZone extends EmsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_diverzone_id", allocationSize = 1)
    @Column(name = "tms_diverzoneid", unique = true, nullable = false, precision = 10, scale = 0)
    private int tmsDriverZoneId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverid")
    private TmsDriver tmsDriverZoneDriver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_zoneid")
    private TmsZone tmsDriverZoneZone;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_drivercreationdate")
    private Date tmsDriverZoneCreationDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_driverupdate")
    private Date tmsDriverZoneUpdateDate;


    public TmsDriverZone() {
    }

    public int getTmsDriverZoneId() {
        return tmsDriverZoneId;
    }

    public void setTmsDriverZoneId(int tmsDriverZoneId) {
        this.tmsDriverZoneId = tmsDriverZoneId;
    }

    public TmsDriver getTmsDriverZoneDriver() {
        return tmsDriverZoneDriver;
    }

    public void setTmsDriverZoneDriver(TmsDriver tmsDriverZoneDriver) {
        this.tmsDriverZoneDriver = tmsDriverZoneDriver;
    }

    public TmsZone getTmsDriverZoneZone() {
        return tmsDriverZoneZone;
    }

    public void setTmsDriverZoneZone(TmsZone tmsDriverZoneZone) {
        this.tmsDriverZoneZone = tmsDriverZoneZone;
    }

    public Date getTmsDriverZoneCreationDate() {
        return tmsDriverZoneCreationDate;
    }

    public void setTmsDriverZoneCreationDate(Date tmsDriverZoneCreationDate) {
        this.tmsDriverZoneCreationDate = tmsDriverZoneCreationDate;
    }

    public Date getTmsDriverZoneUpdateDate() {
        return tmsDriverZoneUpdateDate;
    }

    public void setTmsDriverZoneUpdateDate(Date tmsDriverZoneUpdateDate) {
        this.tmsDriverZoneUpdateDate = tmsDriverZoneUpdateDate;
    }
}

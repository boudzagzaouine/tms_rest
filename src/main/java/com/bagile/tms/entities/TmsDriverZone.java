package com.bagile.tms.entities;

import javax.persistence.*;


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
    private Long tmsDriverZoneId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverid")
    private TmsDriver tmsDriverZoneDriver;

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


}

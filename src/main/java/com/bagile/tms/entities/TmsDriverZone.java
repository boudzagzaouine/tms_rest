package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_diverzone")
public class TmsDriverZone extends EmsEntity{

    /**
     *
     */
    private static final long serialVersionUID = 7073980697050572481L;

    @Id
    @GeneratedValue
    @Column(name = "tms_diverzone")
    private int  tmsDriverZoneid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverid")
    private TmsDriver tmsDriverZonedriver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_zoneid")
    private  TmsZone  tmsDriverZonezone ;


    public TmsDriverZone() {
    }

    public int getTmsDriverZoneid() {
        return tmsDriverZoneid;
    }

    public void setTmsDriverZoneid(int tmsDriverZoneid) {
        this.tmsDriverZoneid = tmsDriverZoneid;
    }

    public TmsDriver getTmsDriverZonedriver() {
        return tmsDriverZonedriver;
    }

    public void setTmsDriverZonedriver(TmsDriver tmsDriverZonedriver) {
        this.tmsDriverZonedriver = tmsDriverZonedriver;
    }

    public TmsZone getTmsDriverZonezone() {
        return tmsDriverZonezone;
    }

    public void setTmsDriverZonezone(TmsZone tmsDriverZonezone) {
        this.tmsDriverZonezone = tmsDriverZonezone;
    }
}

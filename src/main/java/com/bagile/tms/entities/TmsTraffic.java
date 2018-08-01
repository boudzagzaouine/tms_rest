package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tms_roadTraffic",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_roadTrafficId"}))
public class TmsTraffic {
    private int tmsTrafficId;
    private boolean tmsTrafficActive;
    private Date tmsTrafficDate;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_trafficId", unique = true, nullable = false, precision = 10, scale = 0)
    public int getTmsTrafficId() {
        return tmsTrafficId;
    }

    public void setTmsTrafficId(int tmsTrafficId) {
        this.tmsTrafficId = tmsTrafficId;
    }

    @Column(name = "tms_trafficactive")
    public boolean isTmsTrafficActive() {
        return tmsTrafficActive;
    }

    public void setTmsTrafficActive(boolean tmsTrafficActive) {
        this.tmsTrafficActive = tmsTrafficActive;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_trafficdate", unique = true, nullable = false)
    public Date getTmsTrafficDate() {
        return tmsTrafficDate;
    }

    public void setTmsTrafficDate(Date tmsTrafficDate) {
        this.tmsTrafficDate = tmsTrafficDate;
    }
}

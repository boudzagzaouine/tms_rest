package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tms_traffic",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_trafficid"}))
public class TmsTraffic {
    private long tmsTrafficId;
    private boolean tmsTrafficActive;
    private Date tmsTrafficDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_trafficid")
    public long getTmsTrafficId() {
        return tmsTrafficId;
    }

    public void setTmsTrafficId(long tmsTrafficId) {
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
    @Column(name = "tms_trafficdate")
    public Date getTmsTrafficDate() {
        return tmsTrafficDate;
    }

    public void setTmsTrafficDate(Date tmsTrafficDate) {
        this.tmsTrafficDate = tmsTrafficDate;
    }
}

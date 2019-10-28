package com.bagile.tms.entities;

import com.bagile.tms.dto.BadgeType;
import com.bagile.tms.dto.Driver;

import javax.persistence.*;


@Entity
@Table(name="tms_badge")
public class TmsBadge  extends EmsEntity{

    @Id
    @GeneratedValue
    @Column(name = "tms_badgeid")
    private long tmsBadgeId;
    @Column(name = "tms_badgecode")
    private String tmsBadgeCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_badgetypeid")
    private TmsBadgeType tmsBadgeType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverid")
    private TmsDriver tmsDriver;


    public TmsBadge() {
    }

    public long getTmsBadgeId() {
        return tmsBadgeId;
    }

    public void setTmsBadgeId(int tmsBadgeId) {
        this.tmsBadgeId = tmsBadgeId;
    }

    public String getTmsBadgeCode() {
        return tmsBadgeCode;
    }

    public void setTmsBadgeCode(String tmsBadgeCode) {
        this.tmsBadgeCode = tmsBadgeCode;
    }

    public TmsBadgeType getTmsBadgeType() {
        return tmsBadgeType;
    }

    public void setTmsBadgeType(TmsBadgeType tmsBadgeType) {
        this.tmsBadgeType = tmsBadgeType;
    }

    public TmsDriver getTmsDriver() {
        return tmsDriver;
    }

    public void setTmsDriver(TmsDriver tmsDriver) {
        this.tmsDriver = tmsDriver;
    }
}

package com.bagile.tms.entities;

import com.bagile.tms.dto.Driver;

import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tms_badgeA", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_badgeTypecode", "tms_badgeTypeId"}))

public class TmsBadge {
    private String tmsBadgecode;
    private long tmsBadgeId;
    @NotNull
    private TmsBadgeType tmsBadgeType;
    private TmsDriver tmsDriver;
    private Date tmsDateBadge;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "tms_badgesequence")
    @Column(name = "tms_BadgeTypecode", unique = true, nullable = false)

    public String getTmsBadgecode() {
        return tmsBadgecode;
    }

    public void setTmsBadgecode(String tmsBadgecode) {
        this.tmsBadgecode = tmsBadgecode;
    }

    @Column(name = "tms_BadgeTypeId")
    public long getTmsBadgeId() {
        return tmsBadgeId;
    }

    public void setTmsBadgeId(long tmsBadgeId) {
        this.tmsBadgeId = tmsBadgeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_BadgeTypetypeid")
    public TmsBadgeType getTmsBadgeType() {
        return tmsBadgeType;
    }

    public void setTmsBadgeType(TmsBadgeType tmsBadgeType) {
        this.tmsBadgeType = tmsBadgeType;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "tms_badgeDriverid")

    public TmsDriver getTmsDriver() {
        return tmsDriver;
    }

    public void setTmsDriver(TmsDriver tmsDriver) {
        this.tmsDriver = tmsDriver;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_badgeDate")
    public Date getTmsDateBadge() {
        return tmsDateBadge;
    }

    public void setTmsDateBadge(Date tmsDateBadge) {
        this.tmsDateBadge = tmsDateBadge;
    }
}

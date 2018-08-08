package com.bagile.tms.entities;

import com.bagile.tms.dto.Driver;

import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "tms_badgeA", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_badgeTypecode", "tms_badgeTypeId"}))

public class TmsBadge {
    private String tmsBadgecode;
    private long tmsBadgeId;
    @NotNull
    private TmsBadgeType tmsBadgeType;
    private Driver driver;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

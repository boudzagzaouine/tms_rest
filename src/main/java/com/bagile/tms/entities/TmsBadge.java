package com.bagile.tms.entities;

import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "tms_badgeA", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_badgeTypecode", "tms_badgeTypeId"}))

public class TmsBadge {
    private String tmsBadgeTypecode;
    private long tmsBadgeTypeId;
    @NotNull
    private TmsBadgeType tmsBadgeType;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")

    @Column(name = "tms_BadgeTypecode", unique = true, nullable = false)

    public String getTmsBadgeTypecode() {
        return tmsBadgeTypecode;
    }

    public void setTmsBadgeTypecode(String tmsBadgeTypecode) {
        this.tmsBadgeTypecode = tmsBadgeTypecode;
    }

    @Column(name = "tms_BadgeTypeId", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsBadgeTypeId() {
        return tmsBadgeTypeId;
    }

    public void setTmsBadgeTypeId(int tmsBadgeTypeId) {
        this.tmsBadgeTypeId = tmsBadgeTypeId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "tms_BadgeTypetype", unique = true, nullable = false, precision = 10, scale = 0)
    public TmsBadgeType getTmsBadgeType() {
        return tmsBadgeType;
    }

    public void setTmsBadgeType(TmsBadgeType tmsBadgeType) {
        this.tmsBadgeType = tmsBadgeType;
    }
}

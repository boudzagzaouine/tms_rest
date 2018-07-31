package com.bagile.tms.entities;

import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "tms_badgeA", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_badgeTypeCode", "tms_badgeTypeId"}))

public class TmsBadgeA {
    private String tmsBadgeTypecode;
    private int tmsBadgeTypeId;
    @NotNull
    private TmsBadgeType tmsBadgeType;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_BadgeTypeId", unique = true, nullable = false, precision = 10, scale = 0)

    public String getTmsBadgeTypecode() {
        return tmsBadgeTypecode;
    }

    public void setTmsBadgeTypecode(String tmsBadgeTypecode) {
        this.tmsBadgeTypecode = tmsBadgeTypecode;
    }

    public int getTmsBadgeTypeId() {
        return tmsBadgeTypeId;
    }

    public void setTmsBadgeTypeId(int tmsBadgeTypeId) {
        this.tmsBadgeTypeId = tmsBadgeTypeId;
    }

    public TmsBadgeType getTmsBadgeType() {
        return tmsBadgeType;
    }

    public void setTmsBadgeType(TmsBadgeType tmsBadgeType) {
        this.tmsBadgeType = tmsBadgeType;
    }
}

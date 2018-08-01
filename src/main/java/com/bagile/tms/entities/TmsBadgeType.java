package com.bagile.tms.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tms_badgetype",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_badgetypeId"}))
public class TmsBadgeType {
    private long tmsBadgeTypeId;
    private String tmsBadgeTypeCode;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_badgetypeId", unique = true, nullable = false, scale = 0)

    public long getTmsBadgeTypeId() {
        return tmsBadgeTypeId;
    }

    public void setTmsBadgeTypeId(long tmsBadgeTypeId) {
        this.tmsBadgeTypeId = tmsBadgeTypeId;
    }

    @Column(name = "tms_badgetypecode", unique = true, nullable = false, scale = 0)
    public String getTmsBadgeTypeCode() {
        return tmsBadgeTypeCode;
    }

    public void setTmsBadgeTypeCode(String tmsBadgeTypeCode) {
        this.tmsBadgeTypeCode = tmsBadgeTypeCode;
    }
}

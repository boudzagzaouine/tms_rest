package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name = "tms_badgetype")
public class TmsBadgeType extends EmsEntity {
    private long tmsBadgeTypeId;

    private String tmsBadgeTypeCode;
    private String tmsBadgeTypeDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_badge_type_id", allocationSize = 1)
    @Column(name = "tms_badgetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsBadgeTypeId() {
        return tmsBadgeTypeId;
    }

    public void setTmsBadgeTypeId(long tmsBadgeTypeId) {
        this.tmsBadgeTypeId = tmsBadgeTypeId;
    }

    @Column(name = "tms_badgetypecode", unique = true, nullable = false, length = 90)
    public String getTmsBadgeTypeCode() {
        return tmsBadgeTypeCode;
    }

    public void setTmsBadgeTypeCode(String tmsBadgeTypeCode) {
        this.tmsBadgeTypeCode = tmsBadgeTypeCode;
    }

    @Column(name = "tms_badgetypedescription")
    public String getTmsBadgeTypeDescription() {
        return tmsBadgeTypeDescription;
    }

    public void setTmsBadgeTypeDescription(String tmsBadgeTypeDescription) {
        this.tmsBadgeTypeDescription = tmsBadgeTypeDescription;
    }
}

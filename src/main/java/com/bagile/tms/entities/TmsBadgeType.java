package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_badgetype")
public class TmsBadgeType extends EmsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_badgetype", allocationSize = 1)
    @Column(name = "tms_badgetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    private long tmsBadgeTypeId;
    @Column(name = "tms_badgetypecode")
    private String tmsBadgeTypeCode;


    public TmsBadgeType() {
    }

    public long getTmsBadgeTypeId() {
        return tmsBadgeTypeId;
    }

    public void setTmsBadgeTypeId(long tmsBadgeTypeId) {
        this.tmsBadgeTypeId = tmsBadgeTypeId;
    }

    public String getTmsBadgeTypeCode() {
        return tmsBadgeTypeCode;
    }

    public void setTmsBadgeTypeCode(String tmsBadgeTypeCode) {
        this.tmsBadgeTypeCode = tmsBadgeTypeCode;
    }
}

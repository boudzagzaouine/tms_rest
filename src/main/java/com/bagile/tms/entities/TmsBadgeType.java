package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_badgetype")
public class TmsBadgeType extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = 5946978378448415395L;
    @Id
    @GeneratedValue
    @Column(name = "tms_badgetypeid")
    private long tmsBadgeTypeid;
    @Column(name = "tms_badgetypecode")
    private String tmsBadgeTypecode;


    public TmsBadgeType() {
    }

    public long getTmsBadgeTypeid() {
        return tmsBadgeTypeid;
    }

    public void setTmsBadgeTypeid(long tmsBadgeTypeid) {
        this.tmsBadgeTypeid = tmsBadgeTypeid;
    }

    public String getTmsBadgeTypecode() {
        return tmsBadgeTypecode;
    }

    public void setTmsBadgeTypecode(String tmsBadgeTypecode) {
        this.tmsBadgeTypecode = tmsBadgeTypecode;
    }
}

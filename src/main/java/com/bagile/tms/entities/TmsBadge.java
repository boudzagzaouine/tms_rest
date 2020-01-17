package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tms_badge")
public class TmsBadge  extends EmsEntity{

    private long tmsBadgeId;
    private String tmsBadgeCode;
    private String tmsBadgeDescription;
    private TmsBadgeType tmsBadgeType;
   // private List<TmsDriver> tmsDrivers = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_badge_id", allocationSize = 1)
    @Column(name = "tms_badgeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsBadgeId() {
        return tmsBadgeId;
    }

    public void setTmsBadgeId(long tmsBadgeId) {
        this.tmsBadgeId = tmsBadgeId;
    }

    @Column(name = "tms_badgecode", unique = true, nullable = false, length = 90)
    public String getTmsBadgeCode() {
        return tmsBadgeCode;
    }

    public void setTmsBadgeCode(String tmsBadgeCode) {
        this.tmsBadgeCode = tmsBadgeCode;
    }

    @ManyToOne
    @JoinColumn(name = "tms_badgetypeid")
    public TmsBadgeType getTmsBadgeType() {
        return tmsBadgeType;
    }

    public void setTmsBadgeType(TmsBadgeType tmsBadgeType) {
        this.tmsBadgeType = tmsBadgeType;
    }

   /* @OneToMany(mappedBy = "tmsBadge")
    public List<TmsDriver> getTmsDrivers() {
        return tmsDrivers;
    }

    public void setTmsDrivers(List<TmsDriver> tmsDrivers) {
        this.tmsDrivers = tmsDrivers;
    }*/

    @Column(name = "tms_badgedescription")
    public String getTmsBadgeDescription() {
        return tmsBadgeDescription;
    }

    public void setTmsBadgeDescription(String tmsBadgeDescription) {
        this.tmsBadgeDescription = tmsBadgeDescription;
    }
}

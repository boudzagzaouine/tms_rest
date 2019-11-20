package com.bagile.tms.entities;

import com.bagile.tms.dto.Driver;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="tms_badge")
public class TmsBadge  extends EmsEntity{

    /**
     *
     */
    private static final long serialVersionUID = -2793176710957792974L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_badge_id", allocationSize = 1)
    @Column(name = "tms_badgeid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long tmsBadgeId;

    @Column(name = "tms_badgecode", unique = true, nullable = false, length = 90)
    private String tmsBadgeCode;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tms_badgetypeid")
    private TmsBadgeType tmsBadgeType;

    @OneToMany(mappedBy = "tmsBadge")
    private List<TmsDriver> tmsDrivers = new ArrayList<>();



    public TmsBadge() {
    }

    public Long getTmsBadgeId() {
        return tmsBadgeId;
    }

    public void setTmsBadgeId(Long tmsBadgeId) {
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

    public List<TmsDriver> getTmsDrivers() {
        return tmsDrivers;
    }

    public void setTmsDrivers(List<TmsDriver> tmsDrivers) {
        this.tmsDrivers = tmsDrivers;
    }
}

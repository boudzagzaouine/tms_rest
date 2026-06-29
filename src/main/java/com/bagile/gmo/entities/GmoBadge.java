package com.bagile.gmo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="gmo_badge")
public class GmoBadge  extends EmsEntity{

    private Long gmoBadgeId;
    private String gmoBadgeCode;
    private String gmoBadgeDescription;
    private GmoBadgeType gmoBadgeType;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_badge_id", allocationSize = 1)
    @Column(name = "gmo_badgeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoBadgeId() {
        return gmoBadgeId;
    }

    public void setGmoBadgeId(Long gmoBadgeId) {
        this.gmoBadgeId = gmoBadgeId;
    }

    @Column(name = "gmo_badgecode", unique = true, nullable = false, length = 90)
    public String getGmoBadgeCode() {
        return gmoBadgeCode;
    }

    public void setGmoBadgeCode(String gmoBadgeCode) {
        this.gmoBadgeCode = gmoBadgeCode;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_badgetypeid")
    public GmoBadgeType getGmoBadgeType() {
        return gmoBadgeType;
    }

    public void setGmoBadgeType(GmoBadgeType gmoBadgeType) {
        this.gmoBadgeType = gmoBadgeType;
    }

   /* @OneToMany(mappedBy = "gmoBadge")
    public List<GmoDriver> getGmoDrivers() {
        return gmoDrivers;
    }

    public void setGmoDrivers(List<GmoDriver> gmoDrivers) {
        this.gmoDrivers = gmoDrivers;
    }*/

    @Column(name = "gmo_badgedescription")
    public String getGmoBadgeDescription() {
        return gmoBadgeDescription;
    }

    public void setGmoBadgeDescription(String gmoBadgeDescription) {
        this.gmoBadgeDescription = gmoBadgeDescription;
    }
}

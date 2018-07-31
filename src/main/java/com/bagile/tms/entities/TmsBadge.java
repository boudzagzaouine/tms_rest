package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by khalil on 15/03/2017.
 */
@Entity
@Table(name = "tms_badge", uniqueConstraints = @UniqueConstraint(columnNames = {"tms_badgecode", "tms_badgeid"}))


public class TmsBadge implements java.io.Serializable {
    private long tmsBadgeId;
    @NotNull
    private String tmsBadgeCode;
    private String tmsBadgeLibelle;
    private String tmsBadgeDescription;
    private Set<TmsVehicle> tmsBadgeVehicule;
    private Set<TmsBadge> tmsDriverBadges;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_badgeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsBadgeId() {
        return tmsBadgeId;
    }
    public void setTmsBadgeId(long tmsBadgeId) {
        this.tmsBadgeId = tmsBadgeId;
    }

    @Column(name = "tms_badgecode", nullable = false, length = 30)
    public String getTmsBadgeCode() {
        return tmsBadgeCode;
    }

    public void setTmsBadgeCode(String tmsBadgeCode) {
        this.tmsBadgeCode = tmsBadgeCode;
    }

    @Column(name = "tms_badgedescription", nullable = false, length = 30)
    public String getTmsBadgeDescription() {
        return tmsBadgeDescription;
    }

    public void setTmsBadgeDescription(String tmsBadgeDescription) {
        this.tmsBadgeDescription = tmsBadgeDescription;
    }

    @Column(name = "tms_badgelibelle", nullable = false, length = 30)
    public String getTmsBadgeLibelle() {
        return tmsBadgeLibelle;
    }

    public void setTmsBadgeLibelle(String tmsBadgeLibelle) {
        this.tmsBadgeLibelle = tmsBadgeLibelle;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tmsBadge")
    public Set<TmsVehicle> getTmsBadgeVehicule() {
        return tmsBadgeVehicule;
    }

    public void setTmsBadgeVehicule(Set<TmsVehicle> tmsBadgeVehicule) {
        this.tmsBadgeVehicule = tmsBadgeVehicule;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tmsDriverBadgeBadge")

    public Set<TmsBadge> getTmsDriverBadges() {
        return tmsDriverBadges;
    }

    public void setTmsDriverBadges(Set<TmsBadge> tmsDriverBadges) {
        this.tmsDriverBadges = tmsDriverBadges;
    }


}

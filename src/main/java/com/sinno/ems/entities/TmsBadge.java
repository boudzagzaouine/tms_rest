package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by khalil on 15/03/2017.
 */
@Entity
@Table(name="prm_badge",uniqueConstraints= @UniqueConstraint(columnNames = {"prm_badgecode","prm_badgeid"}))


public class TmsBadge implements java.io.Serializable{
    private long prmBadgeId;
    @NotNull
    private String prmBadgeCode;
    private String prmBadgeLibelle;
    private String prmBadgeDescription;
    private Set<TmsVehicle> prmBadgeVehicule;
    private Set<TmsDriver> prmBadgeDriver;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")

    @Column(name = "prm_badgeid", unique = true, nullable = false, precision = 10, scale = 0)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_badgeid", nullable = false)
    public long getPrmBadgeId() {
        return prmBadgeId;
    }
    public void setPrmBadgeId(long prmBadgeId) {
        this.prmBadgeId = prmBadgeId;
    }
    @Column(name = "prm_badgecode", nullable = false, length = 30)
    public String getPrmBadgeCode() {
        return prmBadgeCode;
    }
    public void setPrmBadgeCode(String prmBadgeCode) {
        this.prmBadgeCode = prmBadgeCode;
    }
    @Column(name = "prm_badgedescription",nullable=false,length=30)
    public String getPrmBadgeDescription() {
        return prmBadgeDescription;
    }
    public void setPrmBadgeDescription(String prmBadgeDescription) {
        this.prmBadgeDescription = prmBadgeDescription;
    }
    @Column(name="prm_badgelibelle",nullable=false,length=30)
    public String getPrmBadgeLibelle() {
        return prmBadgeLibelle;
    }
    public void setPrmBadgeLibelle(String prmBadgeLibelle) {
        this.prmBadgeLibelle = prmBadgeLibelle;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prmVehicleBadges")
    public Set<TmsVehicle> getPrmBadgeVehicule() {
        return prmBadgeVehicule;
    }

    public void setPrmBadgeVehicule(Set<TmsVehicle> prmBadgeVehicule) {
        this.prmBadgeVehicule = prmBadgeVehicule;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "drvDriverBadges")

    public Set<TmsDriver> getPrmBadgeDriver() {
        return prmBadgeDriver;
    }

    public void setPrmBadgeDriver(Set<TmsDriver> prmBadgeDriver) {
        this.prmBadgeDriver = prmBadgeDriver;
    }


}

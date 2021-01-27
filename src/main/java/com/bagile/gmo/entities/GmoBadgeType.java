package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "gmo_badgetype")
public class GmoBadgeType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoBadgeTypeId;
    private String gmoBadgeTypeCode;
    private String gmoBadgeTypeDescription;

    private Set<GmoBadgeTypeDriver> gmoBadgeTypeDrivers=new HashSet<>();
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_badge_type_id", allocationSize = 1)
    @Column(name = "gmo_badgetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoBadgeTypeId() {
        return gmoBadgeTypeId;
    }

    public void setGmoBadgeTypeId(Long gmoBadgeTypeId) {
        this.gmoBadgeTypeId = gmoBadgeTypeId;
    }

    @Column(name = "gmo_badgetypecode", unique = true, nullable = false, length = 90)
    public String getGmoBadgeTypeCode() {
        return gmoBadgeTypeCode;
    }

    public void setGmoBadgeTypeCode(String gmoBadgeTypeCode) {
        this.gmoBadgeTypeCode = gmoBadgeTypeCode;
    }

    @Column(name = "gmo_badgetypedescription")
    public String getGmoBadgeTypeDescription() {
        return gmoBadgeTypeDescription;
    }

    public void setGmoBadgeTypeDescription(String gmoBadgeTypeDescription) {
        this.gmoBadgeTypeDescription = gmoBadgeTypeDescription;
    }

    @OneToMany(mappedBy = "gmoBadgeType", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<GmoBadgeTypeDriver> getGmoBadgeTypeDrivers() {
        return gmoBadgeTypeDrivers;
    }

    public void setGmoBadgeTypeDrivers(Set<GmoBadgeTypeDriver> gmoBadgeTypeDrivers) {
        this.gmoBadgeTypeDrivers = gmoBadgeTypeDrivers;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}

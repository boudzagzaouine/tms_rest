package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name="gmo_zone")
public class GmoZone   extends EmsEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_zone_id", allocationSize = 1)
    @Column(name = "gmo_zoneid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long gmoZoneId;
    @Column(name = "gmo_zonecode",  unique = true, nullable = false, length = 90)
    private String gmoZoneCode;

    @Column(name = "gmo_zonedescription", length = 90)
    private String gmoZoneDescription;

    @ManyToOne()
    @JoinColumn(name="gmo_ownowner")
    private OwnOwner ownOwner;

    public GmoZone() {
    }

    public Long getGmoZoneId() {
        return gmoZoneId;
    }

    public void setGmoZoneId(Long gmoZoneId) {
        this.gmoZoneId = gmoZoneId;
    }

    public String getGmoZoneCode() {
        return gmoZoneCode;
    }

    public void setGmoZoneCode(String gmoZoneCode) {
        this.gmoZoneCode = gmoZoneCode;
    }

    public String getGmoZoneDescription() {
        return gmoZoneDescription;
    }

    public void setGmoZoneDescription(String gmoZoneDescription) {
        this.gmoZoneDescription = gmoZoneDescription;
    }

    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}

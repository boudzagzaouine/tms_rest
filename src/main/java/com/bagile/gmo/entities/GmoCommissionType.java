package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "gmo_commissiontype")
public class GmoCommissionType extends EmsEntity {

    private long gmoCommissionTypeId;
    private String gmoCommissionTypeCode;
    private String gmoCommissionTypeDescription;
    private long gmoCommissionTypeMinDistance;
    private long gmoCommissionTypeMaxDistance;
    private BigDecimal gmoCommissionTypePercentage;
    private Set<GmoCommissionDriver> gmoCommissions = new HashSet<>();

    private OwnOwner ownOwner;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_commission_type_id", allocationSize = 1)
    @Column(name = "gmo_CommissionTypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoCommissionTypeId() {
        return gmoCommissionTypeId;
    }
    public void setGmoCommissionTypeId(long gmoCommissionTypeId) {
        this.gmoCommissionTypeId = gmoCommissionTypeId;
    }

    @Column(name = "gmo_Commissiontypecode", unique = true ,length = 90)
    public String getGmoCommissionTypeCode() {
        return gmoCommissionTypeCode;
    }
    public void setGmoCommissionTypeCode(String gmoCommissionTypeCode) {
        this.gmoCommissionTypeCode = gmoCommissionTypeCode;
    }

    @Column(name = "gmo_commissiontypedescription"  )
    public String getGmoCommissionTypeDescription() {
        return gmoCommissionTypeDescription;
    }

    public void setGmoCommissionTypeDescription(String gmoCommissionTypeDescription) {
        this.gmoCommissionTypeDescription = gmoCommissionTypeDescription;
    }
    @Column(name = "gmo_commissiontypepourcentage")
    public BigDecimal getGmoCommissionTypepercentage() {
        return gmoCommissionTypePercentage;
    }

    public void setGmoCommissionTypepercentage(BigDecimal gmoCommissionTypepercentage) {
        this.gmoCommissionTypePercentage = gmoCommissionTypepercentage;
    }

    @Column(name = "gmo_commissiontypemindistance")
    public long getGmoCommissionTypeMinDistance() {
        return gmoCommissionTypeMinDistance;
    }

    public void setGmoCommissionTypeMinDistance(long gmoCommissionTypeMinDistance) {
        this.gmoCommissionTypeMinDistance = gmoCommissionTypeMinDistance;
    }

    @Column(name = "gmo_commissiontypemaxdistance")
    public long getGmoCommissionTypeMaxDistance() {
        return gmoCommissionTypeMaxDistance;
    }

    public void setGmoCommissionTypeMaxDistance(long gmoCommissionTypeMaxDistance) {
        this.gmoCommissionTypeMaxDistance = gmoCommissionTypeMaxDistance;
    }

    @OneToMany(mappedBy = "gmoCommissionType",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<GmoCommissionDriver> getGmoCommissions() {
        return gmoCommissions;
    }

    public void setGmoCommissions(Set<GmoCommissionDriver> gmoCommissions) {
        this.gmoCommissions = gmoCommissions;
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

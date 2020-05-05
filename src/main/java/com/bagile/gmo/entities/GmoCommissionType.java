package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "gmo_commissiontype")
public class GmoCommissionType extends EmsEntity {

    private long gmoCommissionTypeId;
    private String gmoCommissionTypeCode;
    private String gmoCommissionTypeDescription;
    private BigDecimal gmoCommissionTypePercentage;
    private Set<GmoCommissionDriver> gmoCommissions = new HashSet<>();



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
    @Column(name = "gmo_commissiontypepourcentage", length = 90)
    public BigDecimal getGmoCommissionTypepercentage() {
        return gmoCommissionTypePercentage;
    }

    public void setGmoCommissionTypepercentage(BigDecimal gmoCommissionTypepercentage) {
        this.gmoCommissionTypePercentage = gmoCommissionTypepercentage;
    }

    @OneToMany(mappedBy = "gmoCommissionType",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<GmoCommissionDriver> getGmoCommissions() {
        return gmoCommissions;
    }

    public void setGmoCommissions(Set<GmoCommissionDriver> gmoCommissions) {
        this.gmoCommissions = gmoCommissions;
    }

}

package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tms_commissiontype")
public class TmsCommissionType extends EmsEntity {

    private long tmsCommissionTypeId;
    private String tmsCommissionTypeCode;
    private String tmsCommissionTypeDescription;
    private BigDecimal tmsCommissionTypePercentage;
    private List<TmsCommission> tmsCommissions = new ArrayList<>();



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_commission_type_id", allocationSize = 1)
    @Column(name = "tms_CommissionTypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsCommissionTypeId() {
        return tmsCommissionTypeId;
    }
    public void setTmsCommissionTypeId(long tmsCommissionTypeId) {
        this.tmsCommissionTypeId = tmsCommissionTypeId;
    }

    @Column(name = "tms_Commissiontypecode", unique = true, nullable = false, length = 90)
    public String getTmsCommissionTypeCode() {
        return tmsCommissionTypeCode;
    }
    public void setTmsCommissionTypeCode(String tmsCommissionTypeCode) {
        this.tmsCommissionTypeCode = tmsCommissionTypeCode;
    }

    @Column(name = "tms_commissiontypedescription", unique = true, nullable = false, length = 90)
    public String getTmsCommissionTypeDescription() {
        return tmsCommissionTypeDescription;
    }

    public void setTmsCommissionTypeDescription(String tmsCommissionTypeDescription) {
        this.tmsCommissionTypeDescription = tmsCommissionTypeDescription;
    }
    @Column(name = "tms_commissiontypepourcentage", unique = true, nullable = false, length = 90)
    public BigDecimal getTmsCommissionTypepercentage() {
        return tmsCommissionTypePercentage;
    }

    public void setTmsCommissionTypepercentage(BigDecimal tmsCommissionTypepercentage) {
        this.tmsCommissionTypePercentage = tmsCommissionTypepercentage;
    }

    @OneToMany(mappedBy = "tmsCommissionType",cascade = CascadeType.ALL)
    public List<TmsCommission> getTmsCommissions() {
        return tmsCommissions;
    }

    public void setTmsCommissions(List<TmsCommission> tmsCommissions) {
        this.tmsCommissions = tmsCommissions;
    }

}

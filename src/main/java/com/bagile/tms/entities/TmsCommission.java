package com.bagile.tms.entities;

import com.bagile.tms.dto.Driver;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tms_commission")
public class TmsCommission extends EmsEntity {

    private long tmsCommissionId;
    private TmsDriver tmsDriver;
    private TmsCommissionType tmsCommissionType;
    private BigDecimal tmsAmount;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_commission_id", allocationSize = 1)
    @Column(name = "tms_Commissionid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsCommissionId() {
        return tmsCommissionId;
    }

    public void setTmsCommissionId(long tmsCommissionTypeId) {
        this.tmsCommissionId = tmsCommissionTypeId;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_driverid")
    public TmsDriver getTmsDriver() {
        return tmsDriver;
    }
    public void setTmsDriver(TmsDriver tmsDriver) {
        this.tmsDriver = tmsDriver;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_commissiontypeid")
    public TmsCommissionType getTmsCommissionType() {
        return tmsCommissionType;
    }

    public void setTmsCommissionType(TmsCommissionType tmsCommissionType) {
        this.tmsCommissionType = tmsCommissionType;
    }


    @Column(name = "tms_Commissionamount", unique = true, nullable = false, precision = 10, scale = 0)
    public BigDecimal getTmsAmount() {
        return tmsAmount;
    }

    public void setTmsAmount(BigDecimal tmsAmount) {
        this.tmsAmount = tmsAmount;
    }
}

package com.bagile.tms.entities;

import com.bagile.tms.dto.Driver;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "tms_commissiondriver")
public class TmsCommissionDriver extends EmsEntity {

    private long tmsCommissionId;
    private TmsDriver tmsDriver;
    private TmsCommissionType tmsCommissionType;
    private Date tmsDatee;


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




    @Column(name = "tms_commissiondate", nullable = false, precision = 10, scale = 0)
    public Date getTmsDatee() {
        return tmsDatee;
    }

    public void setTmsDatee(Date tmsDatee) {
        this.tmsDatee = tmsDatee;
    }
}

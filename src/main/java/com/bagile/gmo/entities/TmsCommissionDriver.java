package com.bagile.gmo.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tms_commissiondriver")
public class TmsCommissionDriver extends EmsEntity {

	private static final long serialVersionUID = -8643467091485336055L;

	private long tmsCommissionId;
    private GmoDriver gmoDriver;
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
    public GmoDriver getTmsDriver() {
        return gmoDriver;
    }
    public void setTmsDriver(GmoDriver gmoDriver) {
        this.gmoDriver = gmoDriver;
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

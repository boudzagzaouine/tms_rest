package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "gmo_commissiondriver")
public class GmoCommissionDriver extends EmsEntity {

	private static final long serialVersionUID = -8643467091485336055L;

	private Long gmoCommissionId;
    private GmoDriver gmoDriver;
    private GmoCommissionType gmoCommissionType;
    private Date gmoDatee;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_commission_id", allocationSize = 1)
    @Column(name = "gmo_Commissionid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoCommissionId() {
        return gmoCommissionId;
    }

    public void setGmoCommissionId(Long gmoCommissionTypeId) {
        this.gmoCommissionId = gmoCommissionTypeId;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_driverid")
    public GmoDriver getGmoDriver() {
        return gmoDriver;
    }
    public void setGmoDriver(GmoDriver gmoDriver) {
        this.gmoDriver = gmoDriver;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_commissiontypeid")
    public GmoCommissionType getGmoCommissionType() {
        return gmoCommissionType;
    }

    public void setGmoCommissionType(GmoCommissionType gmoCommissionType) {
        this.gmoCommissionType = gmoCommissionType;
    }




    @Column(name = "gmo_commissiondate", nullable = false, precision = 10, scale = 0)
    public Date getGmoDatee() {
        return gmoDatee;
    }

    public void setGmoDatee(Date gmoDatee) {
        this.gmoDatee = gmoDatee;
    }
}

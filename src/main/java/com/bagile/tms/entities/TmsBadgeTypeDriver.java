package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tms_badgetypedriver")
public class TmsBadgeTypeDriver extends EmsEntity {

    private long tmsBadgeTypeDriverId;
    private TmsDriver tmsDriver;
    private TmsBadgeType tmsBadgeType;
    private String tmsBadgeNumber;
    private Date tmsDeliveranceDate;
    private Date tmsValidityEndDate;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_badgetypedriver_id", allocationSize = 1)
    @Column(name = "tms_badgetypedriverid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsBadgeTypeDriverId() {
        return tmsBadgeTypeDriverId;
    }

    public void setTmsBadgeTypeDriverId(long tmsBadgeTypeDriverId) {
        this.tmsBadgeTypeDriverId = tmsBadgeTypeDriverId;
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
    @JoinColumn(name = "tms_badgetypeid")
    public TmsBadgeType getTmsBadgeType() {
        return tmsBadgeType;
    }

    public void setTmsBadgeType(TmsBadgeType tmsBadgeType) {
        this.tmsBadgeType = tmsBadgeType;
    }

    @Column(name = "tms_badgetypedriverbadgenumber")
    public String getTmsBadgeNumber() {
        return tmsBadgeNumber;
    }

    public void setTmsBadgeNumber(String tmsNumeroBadge) {
        this.tmsBadgeNumber = tmsNumeroBadge;
    }

    @Column(name = "tms_badgetypedriverdeliverancedate")
    public Date getTmsDeliveranceDate() {
        return tmsDeliveranceDate;
    }

    public void setTmsDeliveranceDate(Date tmsdateDeliverance) {
        this.tmsDeliveranceDate = tmsdateDeliverance;
    }

    @Column(name = "tms_badgetypedrivervalidityenddate")
    public Date getTmsValidityEndDate() {
        return tmsValidityEndDate;
    }

    public void setTmsValidityEndDate(Date tmsdateFinValidite) {
        this.tmsValidityEndDate = tmsdateFinValidite;
    }


}

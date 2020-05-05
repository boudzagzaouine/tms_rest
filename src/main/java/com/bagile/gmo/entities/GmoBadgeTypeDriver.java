package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "gmo_badgetypedriver")
public class GmoBadgeTypeDriver extends EmsEntity {

	private static final long serialVersionUID = -1006213047251860151L;

	private long gmoBadgeTypeDriverId;
    private GmoDriver gmoDriver;
    private GmoBadgeType gmoBadgeType;
    private String gmoBadgeNumber;
    private Date gmoDeliveranceDate;
    private Date gmoValidityEndDate;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_badgetypedriver_id", allocationSize = 1)
    @Column(name = "gmo_badgetypedriverid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoBadgeTypeDriverId() {
        return gmoBadgeTypeDriverId;
    }

    public void setGmoBadgeTypeDriverId(long gmoBadgeTypeDriverId) {
        this.gmoBadgeTypeDriverId = gmoBadgeTypeDriverId;
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
    @JoinColumn(name = "gmo_badgetypeid")
    public GmoBadgeType getGmoBadgeType() {
        return gmoBadgeType;
    }

    public void setGmoBadgeType(GmoBadgeType gmoBadgeType) {
        this.gmoBadgeType = gmoBadgeType;
    }

    @Column(name = "gmo_badgetypedriverbadgenumber")
    public String getGmoBadgeNumber() {
        return gmoBadgeNumber;
    }

    public void setGmoBadgeNumber(String gmoNumeroBadge) {
        this.gmoBadgeNumber = gmoNumeroBadge;
    }

    @Column(name = "gmo_badgetypedriverdeliverancedate")
    public Date getGmoDeliveranceDate() {
        return gmoDeliveranceDate;
    }

    public void setGmoDeliveranceDate(Date gmodateDeliverance) {
        this.gmoDeliveranceDate = gmodateDeliverance;
    }

    @Column(name = "gmo_badgetypedrivervalidityenddate")
    public Date getGmoValidityEndDate() {
        return gmoValidityEndDate;
    }

    public void setGmoValidityEndDate(Date gmodateFinValidite) {
        this.gmoValidityEndDate = gmodateFinValidite;
    }


}

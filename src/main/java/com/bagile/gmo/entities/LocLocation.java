package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * LocLocation generated by hbm2java
 */
@Entity
@Table(name = "loc_location", uniqueConstraints = {
        @UniqueConstraint(columnNames = "loc_locationcode")})
public class LocLocation extends EmsEntity implements Serializable  {

    private static final long serialVersionUID = 5020328395529036536L;

    private long locLocationId;

   // private LocZone locZone;
    @NotNull
    private WrhWarehouse wrhWarehouse;
    @Size(max = 30)
    @NotNull
    private String locLocationCode;
    @NotNull
    private Boolean locLocationIsActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date locLocationCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Boolean locLocationPicking;
    private Boolean locLocationReserve;
   private PrmLocationStatus prmLocationStatus;
    private Boolean locLocationDefaultLocation;


    private Date locLocationUpdateDate;
    public LocLocation() {
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_loc_location", allocationSize = 1)
    @Column(name = "loc_locationid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getLocLocationId() {
        return this.locLocationId;
    }


    public void setLocLocationId(long locLocationId) {
        this.locLocationId = locLocationId;
    }

    @Column(name = "loc_locationpicking")
    public Boolean getLocLocationPicking() {
        return locLocationPicking;
    }

    public void setLocLocationPicking(Boolean locLocationPicking) {
        this.locLocationPicking = locLocationPicking;
    }

    @Column(name = "loc_locationreserve")
    public Boolean getLocLocationReserve() {
        return locLocationReserve;
    }

    public void setLocLocationReserve(Boolean locLocationReserve) {
        this.locLocationReserve = locLocationReserve;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loc_locationlocationstatusid")
    public PrmLocationStatus getPrmLocationStatus() {
        return prmLocationStatus;
    }

    public void setPrmLocationStatus(PrmLocationStatus prmLocationStatus) {
        this.prmLocationStatus = prmLocationStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loc_locationwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return this.wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Column(name = "loc_locationcode", unique = true, nullable = false, length = 30)
    public String getLocLocationCode() {
        return this.locLocationCode;
    }

    public void setLocLocationCode(String locLocationCode) {
        this.locLocationCode = locLocationCode;
    }

    public void setLocLocationIsActive(Boolean locLocationIsActive) {
        this.locLocationIsActive = locLocationIsActive;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "loc_locationcreationdate")
    public Date getLocLocationCreationDate() {
        return this.locLocationCreationDate;
    }

    public void setLocLocationCreationDate(Date locLocationCreationDate) {
        this.locLocationCreationDate = locLocationCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "loc_locationupdatedate")
    public Date getLocLocationUpdateDate() {
        return this.locLocationUpdateDate;
    }

    public void setLocLocationUpdateDate(Date locLocationUpdateDate) {
        this.locLocationUpdateDate = locLocationUpdateDate;
    }




    @Column(name="loc_locationisactive",nullable = false)
    public Boolean getLocLocationIsActive() {
        return locLocationIsActive;
    }

    @Column(name="loc_locationdefault")

    public Boolean getLocLocationDefaultLocation() {
        return locLocationDefaultLocation;
    }

    public void setLocLocationDefaultLocation(Boolean locLocationDefaultLocation) {
        this.locLocationDefaultLocation = locLocationDefaultLocation;
    }


    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            LocLocation obj = (LocLocation) object;
            if (this.getLocLocationId() == obj.getLocLocationId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.getLocLocationId();
        hash = 7 * hash + (int) this.getLocLocationId();
        return hash;
    }
}

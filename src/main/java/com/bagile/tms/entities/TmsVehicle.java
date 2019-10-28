package com.bagile.tms.entities;

import com.bagile.tms.dto.BadgeType;
import com.bagile.tms.dto.VehicleCategory;

import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name="tms_vehicule")
public class TmsVehicle   {

    @Id
    @GeneratedValue
    @Column(name = "tms_vehiculeid")
    private long tmsVehicleid;
    @Column(name = "tms_vehiculeregistrationnumber")
    private String  registrationNumber;
    @Column(name = "tms_vehiculecode")
   private String tmsVehiclecode;
    @Column(name = "tms_vehiculetechnicalvisit")
   private Date tmsVehicletechnicalVisit;
    @Column(name = "tms_vehiculecreationdate")
   private Date tmsVehiclecreationDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_vehiculecategorieid")
   private TmsVehicleCategory tmsVehicleCategory;

    @ManyToOne(fetch = FetchType.LAZY, cascade =CascadeType.MERGE)
    @JoinColumn(name = "tms_badgetypeid")
   private TmsBadgeType tmsBadgeType;



    public TmsVehicle() {
    }

    public long getTmsVehicleid() {
        return tmsVehicleid;
    }

    public void setTmsVehicleid(long tmsVehicleid) {
        this.tmsVehicleid = tmsVehicleid;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getTmsVehiclecode() {
        return tmsVehiclecode;
    }

    public void setTmsVehiclecode(String tmsVehiclecode) {
        this.tmsVehiclecode = tmsVehiclecode;
    }

    public Date getTmsVehicletechnicalVisit() {
        return tmsVehicletechnicalVisit;
    }

    public void setTmsVehicletechnicalVisit(Date tmsVehicletechnicalVisit) {
        this.tmsVehicletechnicalVisit = tmsVehicletechnicalVisit;
    }

    public Date getTmsVehiclecreationDate() {
        return tmsVehiclecreationDate;
    }

    public void setTmsVehiclecreationDate(Date tmsVehiclecreationDate) {
        this.tmsVehiclecreationDate = tmsVehiclecreationDate;
    }

    public TmsVehicleCategory getTmsVehicleCategory() {
        return tmsVehicleCategory;
    }

    public void setTmsVehicleCategory(TmsVehicleCategory tmsVehicleCategory) {
        this.tmsVehicleCategory = tmsVehicleCategory;
    }

    public TmsBadgeType getTmsBadgeType() {
        return tmsBadgeType;
    }

    public void setTmsBadgeType(TmsBadgeType tmsBadgeType) {
        this.tmsBadgeType = tmsBadgeType;
    }
}

package com.bagile.tms.entities;

import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name="tms_vehicule")
public class TmsVehicle   extends EmsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehicule_id", allocationSize = 1)
    @Column(name = "tms_vehiculeid", unique = true, nullable = false, precision = 10, scale = 0)
    private long tmsVehicleId;
    @Column(name = "tms_vehiculeregistrationnumber")
    private String tmsRegistrationNumber;
    @Column(name = "tms_vehiculecode")
   private String tmsVehicleCode;
    @Column(name = "tms_vehiculetechnicalvisit")
   private Date tmsVehicleTechnicalVisit;
    @Column(name = "tms_vehiculecreationdate")
   private Date tmsVehicleCreationDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_vehiculecategorieid")
   private TmsVehicleCategory tmsVehicleCategory;

    @ManyToOne(fetch = FetchType.LAZY, cascade =CascadeType.MERGE)
    @JoinColumn(name = "tms_badgetypeid")
   private TmsBadgeType tmsBadgeType;



    public TmsVehicle() {
    }

    public long getTmsVehicleId() {
        return tmsVehicleId;
    }

    public void setTmsVehicleId(long tmsVehicleId) {
        this.tmsVehicleId = tmsVehicleId;
    }

    public String getTmsRegistrationNumber() {
        return tmsRegistrationNumber;
    }

    public void setTmsRegistrationNumber(String tmsRegistrationNumber) {
        this.tmsRegistrationNumber = tmsRegistrationNumber;
    }

    public String getTmsVehicleCode() {
        return tmsVehicleCode;
    }

    public void setTmsVehicleCode(String tmsVehicleCode) {
        this.tmsVehicleCode = tmsVehicleCode;
    }

    public Date getTmsVehicleTechnicalVisit() {
        return tmsVehicleTechnicalVisit;
    }

    public void setTmsVehicleTechnicalVisit(Date tmsVehicleTechnicalVisit) {
        this.tmsVehicleTechnicalVisit = tmsVehicleTechnicalVisit;
    }

    public Date getTmsVehicleCreationDate() {
        return tmsVehicleCreationDate;
    }

    public void setTmsVehicleCreationDate(Date tmsVehicleCreationDate) {
        this.tmsVehicleCreationDate = tmsVehicleCreationDate;
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

package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tms_vehicule")
public class TmsVehicle extends EmsEntity {

    private long tmsVehicleId;
    private String tmsRegistrationNumber;
    private String tmsVehicleCode;
    private Date tmsVehicleTechnicalVisit;
    private TmsVehicleCategory tmsVehicleCategory;
    private TmsBadgeType tmsBadgeType;
    private TmsInsurance tmsInsurance;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehicule_id", allocationSize = 1)
    @Column(name = "tms_vehiculeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsVehicleId() {
        return tmsVehicleId;
    }

    public void setTmsVehicleId(long tmsVehicleId) {
        this.tmsVehicleId = tmsVehicleId;
    }

    @Column(name = "tms_vehiculeregistrationnumber")
    public String getTmsRegistrationNumber() {
        return tmsRegistrationNumber;
    }

    public void setTmsRegistrationNumber(String tmsRegistrationNumber) {
        this.tmsRegistrationNumber = tmsRegistrationNumber;
    }

    @Column(name = "tms_vehiculecode", unique = true, nullable = false, length = 90)
    public String getTmsVehicleCode() {
        return tmsVehicleCode;
    }

    public void setTmsVehicleCode(String tmsVehicleCode) {
        this.tmsVehicleCode = tmsVehicleCode;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tms_vehiculetechnicalvisit")
    public Date getTmsVehicleTechnicalVisit() {
        return tmsVehicleTechnicalVisit;
    }

    public void setTmsVehicleTechnicalVisit(Date tmsVehicleTechnicalVisit) {
        this.tmsVehicleTechnicalVisit = tmsVehicleTechnicalVisit;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_vehiculecategorieid")

    public TmsVehicleCategory getTmsVehicleCategory() {
        return tmsVehicleCategory;
    }

    public void setTmsVehicleCategory(TmsVehicleCategory tmsVehicleCategory) {
        this.tmsVehicleCategory = tmsVehicleCategory;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_badgetypeid")
    public TmsBadgeType getTmsBadgeType() {
        return tmsBadgeType;
    }

    public void setTmsBadgeType(TmsBadgeType tmsBadgeType) {
        this.tmsBadgeType = tmsBadgeType;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_vehicleinsuranceid")
    public TmsInsurance getTmsInsurance() {
        return tmsInsurance;
    }

    public void setTmsInsurance(TmsInsurance tmsInsurance) {
        this.tmsInsurance = tmsInsurance;
    }
}

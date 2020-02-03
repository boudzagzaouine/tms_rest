package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_insurancetermvehile")
public class TmsInsuranceTermsVehicule extends  EmsEntity{


    private Long tmsInsuranceTermVehicleId;
    private TmsVehicle tmsVehicle;
    private TmsInsuranceTerm tmsInsuranceTerm;
 private BigDecimal tmsAmount;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_insurancetermvehicle_id", allocationSize = 1)
    @Column(name = "tms_insurancetermvehicle_id", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsInsuranceTermVehicleId() {
        return tmsInsuranceTermVehicleId;
    }

    public void setTmsInsuranceTermVehicleId(Long tmsInsuranceTermVehicleId) {
        this.tmsInsuranceTermVehicleId = tmsInsuranceTermVehicleId;
    }
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehicleid")
    public TmsVehicle getTmsVehicle() {
        return tmsVehicle;
    }

    public void setTmsVehicle(TmsVehicle tmsVehicle) {
        this.tmsVehicle = tmsVehicle;
    }

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_inserancetermid")
    public TmsInsuranceTerm getTmsInsuranceTerm() {
        return tmsInsuranceTerm;
    }

    public void setTmsInsuranceTerm(TmsInsuranceTerm tmsInsuranceTerm) {
        this.tmsInsuranceTerm = tmsInsuranceTerm;
    }

    @Column(name = "tms_insurancetermsvehcleamount")
    public BigDecimal getTmsAmount() {
        return tmsAmount;
    }

    public void setTmsAmount(BigDecimal tmsAmount) {
        this.tmsAmount = tmsAmount;
    }
}

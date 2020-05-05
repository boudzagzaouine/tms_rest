package com.bagile.gmo.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gmo_insurancetermvehile")
public class TmsInsuranceTermsVehicule extends  EmsEntity{

    private static final long serialVersionUID = 2686609119214199162L;
	
    private Long gmoInsuranceTermVehicleId;
    private GmoVehicle gmoVehicle;
    private TmsInsuranceTerm tmsInsuranceTerm;
    private BigDecimal gmoAmount;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_insurancetermvehicle_id", allocationSize = 1)
    @Column(name = "gmo_insurancetermvehicle_id", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoInsuranceTermVehicleId() {
        return gmoInsuranceTermVehicleId;
    }

    public void setGmoInsuranceTermVehicleId(Long gmoInsuranceTermVehicleId) {
        this.gmoInsuranceTermVehicleId = gmoInsuranceTermVehicleId;
    }
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_vehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_inserancetermid")
    public TmsInsuranceTerm getTmsInsuranceTerm() {
        return tmsInsuranceTerm;
    }

    public void setTmsInsuranceTerm(TmsInsuranceTerm tmsInsuranceTerm) {
        this.tmsInsuranceTerm = tmsInsuranceTerm;
    }

    @Column(name = "gmo_insurancetermsvehcleamount")
    public BigDecimal getGmoAmount() {
        return gmoAmount;
    }

    public void setGmoAmount(BigDecimal gmoAmount) {
        this.gmoAmount = gmoAmount;
    }
}

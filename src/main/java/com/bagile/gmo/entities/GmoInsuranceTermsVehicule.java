package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="gmo_insurancetermvehile")
public class GmoInsuranceTermsVehicule extends  EmsEntity{

    private static final long serialVersionUID = 2686609119214199162L;
	
    private Long gmoInsuranceTermVehicleId;
    //private GmoVehicle gmoVehicle;
    private GmoInsuranceTerm gmoInsuranceTerm;
    private BigDecimal gmoAmount;
// private GmoInsurance gmoInsurance;

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

  /* @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_insuranceid")
    public GmoInsurance getGmoInsurance() {
        return gmoInsurance;
    }

    public void setGmoInsurance(GmoInsurance gmoInsurance) {
        this.gmoInsurance = gmoInsurance;
    }*/





  /*  @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_vehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }*/

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_inserancetermid")
    public GmoInsuranceTerm getGmoInsuranceTerm() {
        return gmoInsuranceTerm;
    }

    public void setGmoInsuranceTerm(GmoInsuranceTerm gmoInsuranceTerm) {
        this.gmoInsuranceTerm = gmoInsuranceTerm;
    }

    @Column(name = "gmo_insurancetermsvehcleamount")
    public BigDecimal getGmoAmount() {
        return gmoAmount;
    }

    public void setGmoAmount(BigDecimal gmoAmount) {
        this.gmoAmount = gmoAmount;
    }
}

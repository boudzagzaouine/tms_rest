package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tms_insurancetypeterms")
public class TmsInsuranceTypeTerms extends  EmsEntity{


    private Long tmsInsuranceTypeTermId;
    private TmsInsuranceTerm tmsInsuranceTerm;
    private TmsInsuranceType tmsInsuranceType;
    private BigDecimal tmsAmount;




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_insurancetypeterms_id", allocationSize = 1)
    @Column(name = "tms_insurancetypetermsid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsInsuranceTypeTermId() {
        return tmsInsuranceTypeTermId;
    }

    public void setTmsInsuranceTypeTermId(Long tmsInsuranceTypeTermId) {
        this.tmsInsuranceTypeTermId = tmsInsuranceTypeTermId;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tms_insurancetermsid")
    public TmsInsuranceTerm getTmsInsuranceTerm() {
        return tmsInsuranceTerm;
    }

    public void setTmsInsuranceTerm(TmsInsuranceTerm tmsInsuranceTerm) {
        this.tmsInsuranceTerm = tmsInsuranceTerm;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_insurancetypeid")
    public TmsInsuranceType getTmsInsuranceType() {
        return tmsInsuranceType;
    }

    public void setTmsInsuranceType(TmsInsuranceType tmsInsuranceType) {
        this.tmsInsuranceType = tmsInsuranceType;
    }

    @Column(name = "tms_insurancetypetermsamount",  nullable = false, precision = 10, scale = 0)
    public BigDecimal getTmsAmount() {
        return tmsAmount;
    }

    public void setTmsAmount(BigDecimal tmsAmount) {
        this.tmsAmount = tmsAmount;
    }

/* @OneToOne
    public TmsInsurance getTmsInsurance() {
        return tmsInsurance;
    }

    public void setTmsInsurance(TmsInsurance tmsInsurance) {
        this.tmsInsurance = tmsInsurance;
    }*/

}

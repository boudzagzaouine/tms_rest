package com.bagile.gmo.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="gmo_insurancetypeterms")
public class GmoInsuranceTypeTerms extends  EmsEntity{


    private Long gmoInsuranceTypeTermId;
    private GmoInsuranceTerm gmoInsuranceTerm;
    private GmoInsuranceType gmoInsuranceType;
    private BigDecimal gmoAmount;




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_insurancetypeterms_id", allocationSize = 1)
    @Column(name = "gmo_insurancetypetermsid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoInsuranceTypeTermId() {
        return gmoInsuranceTypeTermId;
    }

    public void setGmoInsuranceTypeTermId(Long gmoInsuranceTypeTermId) {
        this.gmoInsuranceTypeTermId = gmoInsuranceTypeTermId;
    }

    @ManyToOne()
    @JoinColumn(name = "gmo_insurancetermsid")
    public GmoInsuranceTerm getGmoInsuranceTerm() {
        return gmoInsuranceTerm;
    }

    public void setGmoInsuranceTerm(GmoInsuranceTerm gmoInsuranceTerm) {
        this.gmoInsuranceTerm = gmoInsuranceTerm;
    }

    @ManyToOne()
    @JoinColumn(name = "gmo_insurancetypeid")
    public GmoInsuranceType getGmoInsuranceType() {
        return gmoInsuranceType;
    }

    public void setGmoInsuranceType(GmoInsuranceType gmoInsuranceType) {
        this.gmoInsuranceType = gmoInsuranceType;
    }

    @Column(name = "gmo_insurancetypetermsamount", precision = 10, scale = 0)
    public BigDecimal getGmoAmount() {
        return gmoAmount;
    }

    public void setGmoAmount(BigDecimal gmoAmount) {
        this.gmoAmount = gmoAmount;
    }

/* @OneToOne
    public GmoInsurance getGmoInsurance() {
        return gmoInsurance;
    }

    public void setGmoInsurance(GmoInsurance gmoInsurance) {
        this.gmoInsurance = gmoInsurance;
    }*/

}

package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "gmo_insurancetermligne")
public class GmoInsuranceTermLigne extends EmsEntity {

    private long gmoInsuranceTermLigneId;
    private GmoInsurance gmoInsurance;
    private GmoInsuranceTerm gmoInsuranceTerm;
    private BigDecimal gmoAmount;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_insurancetermligne_id", allocationSize = 1)
    @Column(name = "gmo_insurancetermligneid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoInsuranceTermLigneId() {
        return gmoInsuranceTermLigneId;
    }
    public void setGmoInsuranceTermLigneId(long gmoInsuranceTermLigneId) {
        this.gmoInsuranceTermLigneId = gmoInsuranceTermLigneId;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_insuranceid")
    public GmoInsurance getGmoInsurance() {
        return gmoInsurance;
    }

    public void setGmoInsurance(GmoInsurance gmoInsurance) {
        this.gmoInsurance = gmoInsurance;
    }
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_insurancetermid")
    public GmoInsuranceTerm getGmoInsuranceTerm() {
        return gmoInsuranceTerm;
    }

    public void setGmoInsuranceTerm(GmoInsuranceTerm gmoInsuranceTerm) {
        this.gmoInsuranceTerm = gmoInsuranceTerm;
    }

    @Column(name = "gmo_insurancetermligneamount" )
    public BigDecimal getGmoAmount() {
        return gmoAmount;
    }

    public void setGmoAmount(BigDecimal gmoAmount) {
        this.gmoAmount = gmoAmount;
    }
}

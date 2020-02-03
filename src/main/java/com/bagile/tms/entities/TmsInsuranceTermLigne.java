package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tms_insurancetermligne")
public class TmsInsuranceTermLigne extends EmsEntity {

    private long tmsInsuranceTermLigneId;
    private TmsInsurance tmsInsurance;
    private TmsInsuranceTerm tmsInsuranceTerm;
    private BigDecimal tmsAmount;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_insurancetermligne_id", allocationSize = 1)
    @Column(name = "tms_insurancetermligneid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsInsuranceTermLigneId() {
        return tmsInsuranceTermLigneId;
    }
    public void setTmsInsuranceTermLigneId(long tmsInsuranceTermLigneId) {
        this.tmsInsuranceTermLigneId = tmsInsuranceTermLigneId;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_insuranceid")
    public TmsInsurance getTmsInsurance() {
        return tmsInsurance;
    }

    public void setTmsInsurance(TmsInsurance tmsInsurance) {
        this.tmsInsurance = tmsInsurance;
    }
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_insurancetermid")
    public TmsInsuranceTerm getTmsInsuranceTerm() {
        return tmsInsuranceTerm;
    }

    public void setTmsInsuranceTerm(TmsInsuranceTerm tmsInsuranceTerm) {
        this.tmsInsuranceTerm = tmsInsuranceTerm;
    }

    @Column(name = "tms_insurancetermligneamount" )
    public BigDecimal getTmsAmount() {
        return tmsAmount;
    }

    public void setTmsAmount(BigDecimal tmsAmount) {
        this.tmsAmount = tmsAmount;
    }
}

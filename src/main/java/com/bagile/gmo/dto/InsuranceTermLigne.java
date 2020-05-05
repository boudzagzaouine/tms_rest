package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class InsuranceTermLigne extends EmsDto implements Serializable {
    /**
     *
     */

    private long id;
    private Insurance insurance;
    private InsuranceTerm insuranceTerm;
    private BigDecimal amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public InsuranceTerm getInsuranceTerm() {
        return insuranceTerm;
    }

    public void setInsuranceTerm(InsuranceTerm insuranceTerm) {
        this.insuranceTerm = insuranceTerm;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

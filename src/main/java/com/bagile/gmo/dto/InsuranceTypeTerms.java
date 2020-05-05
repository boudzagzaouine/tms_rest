package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class InsuranceTypeTerms extends EmsDto implements Serializable {
    /**
     *
     */

    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private InsuranceType insuranceType;
    private InsuranceTerm insuranceTerm;
    private BigDecimal amount;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceTypeTerms badgeType = (InsuranceTypeTerms) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

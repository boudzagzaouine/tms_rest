package com.bagile.tms.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Insurance extends EmsDto{

    private long id;
    private String code;
    private Date startDate;
    private Date endDate;
    private BigDecimal amount;
    private ContractType contractType;
    private TermInsurance termInsurance;


    public Insurance() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public TermInsurance getTermInsurance() {
        return termInsurance;
    }

    public void setTermInsurance(TermInsurance termInsurance) {
        this.termInsurance = termInsurance;
    }
}

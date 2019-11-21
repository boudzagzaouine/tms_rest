package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tms_insurance")
public class TmsInsurance extends  EmsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_insurance_id", allocationSize = 1)
    @Column(name = "tms_insuranceid", unique = true, nullable = false, precision = 10, scale = 0)
    private long tmsInsuranceId;
    @Column(name = "tms_insurancecode", unique = true, nullable = false, length = 90)
    private String tmsInsuranceCode;
    @Column(name = "tms_insurancestartdate")
    private Date tmsInsuranceStartDate;
    @Column(name = "tms_insuranceenddate")
    private Date tmsInsuranceEndDate;
    @Column(name = "tms_insuranceamount")
    private BigDecimal tmsInsuranceAmount;
    @Column(name = "tms_contracttypeid")
    private TmsContractType tmsContractType;
    private TmsTermInsurance tmsTermInsurance;
    private RcpSupplier rcpSupplier;

    public long getTmsInsuranceId() {
        return tmsInsuranceId;
    }

    public void setTmsInsuranceId(long tmsInsuranceId) {
        this.tmsInsuranceId = tmsInsuranceId;
    }

    public String getTmsInsuranceCode() {
        return tmsInsuranceCode;
    }

    public void setTmsInsuranceCode(String tmsInsuranceCode) {
        this.tmsInsuranceCode = tmsInsuranceCode;
    }

    public Date getTmsInsuranceStartDate() {
        return tmsInsuranceStartDate;
    }

    public void setTmsInsuranceStartDate(Date tmsInsuranceStartDate) {
        this.tmsInsuranceStartDate = tmsInsuranceStartDate;
    }

    public Date getTmsInsuranceEndDate() {
        return tmsInsuranceEndDate;
    }

    public void setTmsInsuranceEndDate(Date tmsInsuranceEndDate) {
        this.tmsInsuranceEndDate = tmsInsuranceEndDate;
    }

    public BigDecimal getTmsInsuranceAmount() {
        return tmsInsuranceAmount;
    }

    public void setTmsInsuranceAmount(BigDecimal tmsInsuranceAmount) {
        this.tmsInsuranceAmount = tmsInsuranceAmount;
    }

    public TmsContractType getTmsContractType() {
        return tmsContractType;
    }

    public void setTmsContractType(TmsContractType tmsContractType) {
        this.tmsContractType = tmsContractType;
    }

    @OneToMany(mappedBy = "tmsInsurance")
    public TmsTermInsurance getTmsTermInsurance() {
        return tmsTermInsurance;
    }

    public void setTmsTermInsurance(TmsTermInsurance tmsTermInsurance) {
        this.tmsTermInsurance = tmsTermInsurance;
    }

    @ManyToOne
    @JoinColumn(name = "tms_insurancesupplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }
}

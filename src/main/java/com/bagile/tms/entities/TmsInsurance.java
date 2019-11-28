package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tms_insurance")
public class TmsInsurance extends  EmsEntity{
    private long tmsInsuranceId;

    private String tmsInsuranceCode;
    private String tmsInsuranceDescription;
    private Date tmsInsuranceStartDate;
    private Date tmsInsuranceEndDate;
    private BigDecimal tmsInsuranceAmount;
    private TmsContractType tmsContractType;
    private TmsInsuranceTerm tmsInsuranceTerm;
    private RcpSupplier rcpSupplier;
    private TmsVehicle tmsVehicle;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_insurance_id", allocationSize = 1)
    @Column(name = "tms_insuranceid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsInsuranceId() {
        return tmsInsuranceId;
    }

    public void setTmsInsuranceId(long tmsInsuranceId) {
        this.tmsInsuranceId = tmsInsuranceId;
    }
    @Column(name = "tms_insurancecode", unique = true, nullable = false, length = 90)
    public String getTmsInsuranceCode() {
        return tmsInsuranceCode;
    }

    public void setTmsInsuranceCode(String tmsInsuranceCode) {
        this.tmsInsuranceCode = tmsInsuranceCode;
    }
    @Column(name = "tms_insurancedescription")
    public String getTmsInsuranceDescription() {
        return tmsInsuranceDescription;
    }

    public void setTmsInsuranceDescription(String tmsInsuranceDescription) {
        this.tmsInsuranceDescription = tmsInsuranceDescription;
    }

    @Temporal (TemporalType.TIMESTAMP)
    @Column(name = "tms_insurancestartdate")
    public Date getTmsInsuranceStartDate() {
        return tmsInsuranceStartDate;
    }

    public void setTmsInsuranceStartDate(Date tmsInsuranceStartDate) {
        this.tmsInsuranceStartDate = tmsInsuranceStartDate;
    }
    @Temporal (TemporalType.TIMESTAMP)
    @Column(name = "tms_insuranceenddate")
    public Date getTmsInsuranceEndDate() {
        return tmsInsuranceEndDate;
    }

    public void setTmsInsuranceEndDate(Date tmsInsuranceEndDate) {
        this.tmsInsuranceEndDate = tmsInsuranceEndDate;
    }
    @Column(name = "tms_insuranceamount")
    public BigDecimal getTmsInsuranceAmount() {
        return tmsInsuranceAmount;
    }

    public void setTmsInsuranceAmount(BigDecimal tmsInsuranceAmount) {
        this.tmsInsuranceAmount = tmsInsuranceAmount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_contracttypeid")
    public TmsContractType getTmsContractType() {
        return tmsContractType;
    }

    public void setTmsContractType(TmsContractType tmsContractType) {
        this.tmsContractType = tmsContractType;
    }

    @OneToOne
    @JoinColumn(name = "tms_insuranceinsurancetermid")
    public TmsInsuranceTerm getTmsInsuranceTerm() {
        return tmsInsuranceTerm;
    }

    public void setTmsInsuranceTerm(TmsInsuranceTerm tmsInsuranceTerm) {
        this.tmsInsuranceTerm = tmsInsuranceTerm;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_insurancesupplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @OneToOne(mappedBy = "tmsInsurance", cascade = CascadeType.ALL)
    public TmsVehicle getTmsVehicle() {
        return tmsVehicle;
    }

    public void setTmsVehicle(TmsVehicle tmsVehicle) {
        this.tmsVehicle = tmsVehicle;
    }
}

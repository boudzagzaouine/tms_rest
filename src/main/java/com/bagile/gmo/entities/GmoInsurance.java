package com.bagile.gmo.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gmo_insurance")
public class GmoInsurance extends EmsEntity {
    private long gmoInsuranceId;

    private String gmoInsuranceCode;
    private String gmoInsuranceNumber;
    private String gmoInsuranceDescription;
    private Date gmoInsuranceStartDate;
    private Date gmoInsuranceEndDate;
    private BigDecimal gmoInsuranceAmount;
   // private GmoInsuranceTerm gmoInsuranceTerm;
    private RcpSupplier rcpSupplier;
    private GmoVehicle gmoVehicle;
    private String gmoInsuranceVehicleCode;
    //private GmoInsuranceType gmoInsuranceType;

    //private Set<GmoInsuranceTermLigne> gmoInsuranceTermInsurances = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_insurance_id", allocationSize = 1)
    @Column(name = "gmo_insuranceid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoInsuranceId() {
        return gmoInsuranceId;
    }

    public void setGmoInsuranceId(long gmoInsuranceId) {
        this.gmoInsuranceId = gmoInsuranceId;
    }

    @Column(name = "gmo_insurancecode", unique = true, nullable = false, length = 90)
    public String getGmoInsuranceCode() {
        return gmoInsuranceCode;
    }

    public void setGmoInsuranceCode(String gmoInsuranceCode) {
        this.gmoInsuranceCode = gmoInsuranceCode;
    }

    @Column(name = "gmo_insurancedescription")
    public String getGmoInsuranceDescription() {
        return gmoInsuranceDescription;
    }

    public void setGmoInsuranceDescription(String gmoInsuranceDescription) {
        this.gmoInsuranceDescription = gmoInsuranceDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmo_insurancestartdate")
    public Date getGmoInsuranceStartDate() {
        return gmoInsuranceStartDate;
    }

    public void setGmoInsuranceStartDate(Date gmoInsuranceStartDate) {
        this.gmoInsuranceStartDate = gmoInsuranceStartDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmo_insuranceenddate")
    public Date getGmoInsuranceEndDate() {
        return gmoInsuranceEndDate;
    }

    public void setGmoInsuranceEndDate(Date gmoInsuranceEndDate) {
        this.gmoInsuranceEndDate = gmoInsuranceEndDate;
    }

    @Column(name = "gmo_insuranceamount")
    public BigDecimal getGmoInsuranceAmount() {
        return gmoInsuranceAmount;
    }

    public void setGmoInsuranceAmount(BigDecimal gmoInsuranceAmount) {
        this.gmoInsuranceAmount = gmoInsuranceAmount;
    }

   /* @OneToOne
    @JoinColumn(name = "gmo_insuranceinsurancetermid")
    public GmoInsuranceTerm getGmoInsuranceTerm() {
        return gmoInsuranceTerm;
    }

    public void setGmoInsuranceTerm(GmoInsuranceTerm gmoInsuranceTerm) {
        this.gmoInsuranceTerm = gmoInsuranceTerm;
    }*/

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_insurancesupplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    /*@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_insurancetypeid")
    public GmoInsuranceType getGmoInsuranceType() {
        return gmoInsuranceType;
    }

    public void setGmoInsuranceType(GmoInsuranceType gmoInsuranceType) {
        this.gmoInsuranceType = gmoInsuranceType;
    }*/

    @OneToOne(mappedBy = "gmoInsurance",cascade = CascadeType.ALL)
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;

    }

    @Column(name = "gmo_insurancenumber")
    public String getGmoInsuranceNumber() {
        return gmoInsuranceNumber;
    }

    public void setGmoInsuranceNumber(String gmoInsuranceNumber) {
        this.gmoInsuranceNumber = gmoInsuranceNumber;
    }


    @Column(name = "gmo_insurancevehiclecode")
    public String getGmoInsuranceVehicleCode() {
        return gmoInsuranceVehicleCode;
    }

    public void setGmoInsuranceVehicleCode(String gmoInsuranceVehicleCode) {
        this.gmoInsuranceVehicleCode = gmoInsuranceVehicleCode;
    }

   /* @OneToMany(mappedBy = "gmoInsurance",cascade = CascadeType.ALL)
    public Set<GmoInsuranceTermLigne> getGmoInsuranceTermLigne() {
        return gmoInsuranceTermInsurances;
    }

    public void setGmoInsuranceTermLigne(Set<GmoInsuranceTermLigne> gmoInsuranceTermInsurances) {
        this.gmoInsuranceTermInsurances = gmoInsuranceTermInsurances;
    }*/


/*  @PrePersist
    @PreUpdate
    void prePersist() {
        if (gmoVehicle != null) {
            this.setGmoInsuranceVehicleCode(gmoVehicle.getGmoVehicleCode());
        } else {
            this.setGmoInsuranceVehicleCode(null);
        }
    }*/
}

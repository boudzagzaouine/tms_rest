package com.bagile.tms.entities;

import javax.persistence.*;

@Entity
@Table(name="tms_terminsurance")
public class TmsTermInsurance extends  EmsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_terminsurance_id", allocationSize = 1)
    @Column(name = "tms_terminsuranceid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long tmsTermInsuranceId;
    @Column(name = "tms_terminsurancecode")
    private String tmsTermInsuranceCode;
    @Column(name = "tms_terminsurancedescription")
    private String tmsTermInsuranceDescription;
    private TmsInsurance tmsInsurance;


    public TmsTermInsurance() {
    }


    public Long getTmsTermInsuranceId() {
        return tmsTermInsuranceId;
    }

    public void setTmsTermInsuranceId(Long tmsTermInsuranceId) {
        this.tmsTermInsuranceId = tmsTermInsuranceId;
    }

    public String getTmsTermInsuranceCode() {
        return tmsTermInsuranceCode;
    }

    public void setTmsTermInsuranceCode(String tmsTermInsuranceCode) {
        this.tmsTermInsuranceCode = tmsTermInsuranceCode;
    }

    public String getTmsTermInsuranceDescription() {
        return tmsTermInsuranceDescription;
    }

    public void setTmsTermInsuranceDescription(String tmsTermInsuranceDescription) {
        this.tmsTermInsuranceDescription = tmsTermInsuranceDescription;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_terminsuranceinsuranceid")
    public TmsInsurance getTmsInsurance() {
        return tmsInsurance;
    }

    public void setTmsInsurance(TmsInsurance tmsInsurance) {
        this.tmsInsurance = tmsInsurance;
    }
}

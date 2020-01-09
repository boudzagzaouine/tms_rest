package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tms_terminsurance")
public class TmsInsuranceTerm extends  EmsEntity{


    private Long tmsInsuranceTermId;
    private String tmsInsuranceTermCode;
    private String tmsInsuranceTermDescription;
  //  private TmsInsurance tmsInsurance;
    private List<TmsInsuranceTermLigne> tmsInsuranceTermInsurances=new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_terminsurance_id", allocationSize = 1)
    @Column(name = "tms_terminsuranceid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsInsuranceTermId() {
        return tmsInsuranceTermId;
    }

    public void setTmsInsuranceTermId(Long tmsInsuranceTermId) {
        this.tmsInsuranceTermId = tmsInsuranceTermId;
    }
    @Column(name = "tms_terminsurancecode", unique = true, nullable = false, length = 90)
    public String getTmsInsuranceTermCode() {
        return tmsInsuranceTermCode;
    }

    public void setTmsInsuranceTermCode(String tmsInsuranceTermCode) {
        this.tmsInsuranceTermCode = tmsInsuranceTermCode;
    }
    @Column(name = "tms_terminsurancedescription")
    public String getTmsInsuranceTermDescription() {
        return tmsInsuranceTermDescription;
    }

    public void setTmsInsuranceTermDescription(String tmsInsuranceTermDescription) {
        this.tmsInsuranceTermDescription = tmsInsuranceTermDescription;
    }

    @OneToMany(mappedBy = "tmsInsuranceTerm")
    public List<TmsInsuranceTermLigne> getTmsInsuranceTermLigne() {
        return tmsInsuranceTermInsurances;
    }

    public void setTmsInsuranceTermLigne(List<TmsInsuranceTermLigne> tmsInsuranceTermInsurances) {
        this.tmsInsuranceTermInsurances = tmsInsuranceTermInsurances;
    }
   /* @OneToOne
    public TmsInsurance getTmsInsurance() {
        return tmsInsurance;
    }

    public void setTmsInsurance(TmsInsurance tmsInsurance) {
        this.tmsInsurance = tmsInsurance;
    }*/

}

package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tms_terminsurance")
public class TmsInsuranceTerm extends  EmsEntity{


    private Long tmsInsuranceTermId;
    private String tmsInsuranceTermCode;
    private String tmsInsuranceTermDescription;
    private boolean tmsInsuranceTermRoofed=false;
  //  private TmsInsurance tmsInsurance;
   // private List<TmsInsuranceTermLigne> tmsInsuranceTermInsurances=new ArrayList<>();

    private Set<TmsInsuranceTypeTerms> tmsInsuranceTypeTerms=new HashSet<>();


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

   /* @OneToMany(mappedBy = "tmsInsuranceTerm")
    public List<TmsInsuranceTermLigne> getTmsInsuranceTermLigne() {
        return tmsInsuranceTermInsurances;
    }

    public void setTmsInsuranceTermLigne(List<TmsInsuranceTermLigne> tmsInsuranceTermInsurances) {
        this.tmsInsuranceTermInsurances = tmsInsuranceTermInsurances;
    }*/

    @OneToMany(mappedBy = "tmsInsuranceTerm", cascade = CascadeType.ALL)
    public Set<TmsInsuranceTypeTerms> getTmsInsuranceTypeTerms() {
        return tmsInsuranceTypeTerms;
    }

    public void setTmsInsuranceTypeTerms(Set<TmsInsuranceTypeTerms> tmsInsuranceTypeTerms) {
        this.tmsInsuranceTypeTerms = tmsInsuranceTypeTerms;
    }

    @Column(name = "tms_terminsuranceroofed", columnDefinition = "boolean default false")
    public boolean isTmsInsuranceTermRoofed() {
        return tmsInsuranceTermRoofed;
    }

    public void setTmsInsuranceTermRoofed(boolean tmsInsuranceTermIsValue) {

        this.tmsInsuranceTermRoofed = tmsInsuranceTermIsValue;


    }

    /* @OneToOne
    public TmsInsurance getTmsInsurance() {
        return tmsInsurance;
    }

    public void setTmsInsurance(TmsInsurance tmsInsurance) {
        this.tmsInsurance = tmsInsurance;
    }*/

}

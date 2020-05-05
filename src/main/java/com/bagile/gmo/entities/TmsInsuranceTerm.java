package com.bagile.gmo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gmo_terminsurance")
public class TmsInsuranceTerm extends  EmsEntity{


    private Long gmoInsuranceTermId;
    private String gmoInsuranceTermCode;
    private String gmoInsuranceTermDescription;
    private boolean gmoInsuranceTermRoofed=false;
  //  private GmoInsurance gmoInsurance;
   // private List<GmoInsuranceTermLigne> gmoInsuranceTermInsurances=new ArrayList<>();

    private Set<TmsInsuranceTypeTerms> tmsInsuranceTypeTerms=new HashSet<>();

    private Set<TmsInsuranceTermsVehicule> tmsInsuranceTermsVehicules=new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_terminsurance_id", allocationSize = 1)
    @Column(name = "gmo_terminsuranceid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoInsuranceTermId() {
        return gmoInsuranceTermId;
    }

    public void setGmoInsuranceTermId(Long gmoInsuranceTermId) {
        this.gmoInsuranceTermId = gmoInsuranceTermId;
    }
    @Column(name = "gmo_terminsurancecode", unique = true, nullable = false, length = 90)
    public String getGmoInsuranceTermCode() {
        return gmoInsuranceTermCode;
    }

    public void setGmoInsuranceTermCode(String gmoInsuranceTermCode) {
        this.gmoInsuranceTermCode = gmoInsuranceTermCode;
    }
    @Column(name = "gmo_terminsurancedescription")
    public String getGmoInsuranceTermDescription() {
        return gmoInsuranceTermDescription;
    }

    public void setGmoInsuranceTermDescription(String gmoInsuranceTermDescription) {
        this.gmoInsuranceTermDescription = gmoInsuranceTermDescription;
    }

   /* @OneToMany(mappedBy = "gmoInsuranceTerm")
    public List<GmoInsuranceTermLigne> getGmoInsuranceTermLigne() {
        return gmoInsuranceTermInsurances;
    }

    public void setGmoInsuranceTermLigne(List<GmoInsuranceTermLigne> gmoInsuranceTermInsurances) {
        this.gmoInsuranceTermInsurances = gmoInsuranceTermInsurances;
    }*/

    @OneToMany(mappedBy = "tmsInsuranceTerm", cascade = CascadeType.ALL)
    public Set<TmsInsuranceTypeTerms> getTmsInsuranceTypeTerms() {
        return tmsInsuranceTypeTerms;
    }

    public void setTmsInsuranceTypeTerms(Set<TmsInsuranceTypeTerms> tmsInsuranceTypeTerms) {
        this.tmsInsuranceTypeTerms = tmsInsuranceTypeTerms;
    }

    @Column(name = "gmo_terminsuranceroofed", columnDefinition = "boolean default false")
    public boolean isGmoInsuranceTermRoofed() {
        return gmoInsuranceTermRoofed;
    }

    public void setGmoInsuranceTermRoofed(boolean gmoInsuranceTermIsValue) {

        this.gmoInsuranceTermRoofed = gmoInsuranceTermIsValue;


    }

    @OneToMany(mappedBy = "tmsInsuranceTerm", cascade = CascadeType.ALL)
    public Set<TmsInsuranceTermsVehicule> getTmsInsuranceTermsVehicules() {
        return tmsInsuranceTermsVehicules;
    }

    public void setTmsInsuranceTermsVehicules(Set<TmsInsuranceTermsVehicule> tmsInsuranceTermsVehicules) {
        this.tmsInsuranceTermsVehicules = tmsInsuranceTermsVehicules;
    }
}

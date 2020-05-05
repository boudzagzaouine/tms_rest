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
public class GmoInsuranceTerm extends  EmsEntity{


    private Long gmoInsuranceTermId;
    private String gmoInsuranceTermCode;
    private String gmoInsuranceTermDescription;
    private boolean gmoInsuranceTermRoofed=false;
  //  private GmoInsurance gmoInsurance;
   // private List<GmoInsuranceTermLigne> gmoInsuranceTermInsurances=new ArrayList<>();

    private Set<GmoInsuranceTypeTerms> gmoInsuranceTypeTerms=new HashSet<>();

    private Set<GmoInsuranceTermsVehicule> gmoInsuranceTermsVehicules=new HashSet<>();


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

    @OneToMany(mappedBy = "gmoInsuranceTerm", cascade = CascadeType.ALL)
    public Set<GmoInsuranceTypeTerms> getGmoInsuranceTypeTerms() {
        return gmoInsuranceTypeTerms;
    }

    public void setGmoInsuranceTypeTerms(Set<GmoInsuranceTypeTerms> gmoInsuranceTypeTerms) {
        this.gmoInsuranceTypeTerms = gmoInsuranceTypeTerms;
    }

    @Column(name = "gmo_terminsuranceroofed", columnDefinition = "boolean default false")
    public boolean isGmoInsuranceTermRoofed() {
        return gmoInsuranceTermRoofed;
    }

    public void setGmoInsuranceTermRoofed(boolean gmoInsuranceTermIsValue) {

        this.gmoInsuranceTermRoofed = gmoInsuranceTermIsValue;


    }

    @OneToMany(mappedBy = "gmoInsuranceTerm", cascade = CascadeType.ALL)
    public Set<GmoInsuranceTermsVehicule> getGmoInsuranceTermsVehicules() {
        return gmoInsuranceTermsVehicules;
    }

    public void setGmoInsuranceTermsVehicules(Set<GmoInsuranceTermsVehicule> gmoInsuranceTermsVehicules) {
        this.gmoInsuranceTermsVehicules = gmoInsuranceTermsVehicules;
    }
}

package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tms_insurancetype")
public class TmsInsuranceType extends EmsEntity {

    private long tmsInsuranceTypeId;
    private String tmsInsuranceTypeCode;
    private String tmsInsuranceTypeDescription;
   // private Set<TmsInsurance> tmsInsurances= new HashSet<>();

   // private Set<TmsVehicleCategory> tmsVehicleCategories= new HashSet<>();

 private Set<TmsInsuranceTypeTerms> tmsInsuranceTypeTerms=new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_insurancetype_id", allocationSize = 1)
    @Column(name = "tms_insurancetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsInsuranceTypeId() {
        return tmsInsuranceTypeId;
    }

    public void setTmsInsuranceTypeId(long tmsInsuranceTypeId) {
        this.tmsInsuranceTypeId = tmsInsuranceTypeId;
    }
    @Column(name = "tms_insurancetypecode")
    public String getTmsInsuranceTypeCode() {
        return tmsInsuranceTypeCode;
    }

    public void setTmsInsuranceTypeCode(String tmsInsuranceTypeCode) {
        this.tmsInsuranceTypeCode = tmsInsuranceTypeCode;
    }
    @Column(name = "tms_insurancetypedescription")
    public String getTmsInsuranceTypeDescription() {
        return tmsInsuranceTypeDescription;
    }

    public void setTmsInsuranceTypeDescription(String tmsInsuranceTypeDescription) {
        this.tmsInsuranceTypeDescription = tmsInsuranceTypeDescription;
    }

    /*

  /* @OneToMany(mappedBy = "tmsInsuranceType",)
    public Set<TmsVehicleCategory> getTmsVehicleCategories() {
        return tmsVehicleCategories;
    }

    public void setTmsVehicleCategories(Set<TmsVehicleCategory> tmsVehicleCategories) {
        this.tmsVehicleCategories = tmsVehicleCategories;
    }*/

    @OneToMany(mappedBy = "tmsInsuranceType", cascade = CascadeType.ALL,orphanRemoval = true)
    public Set<TmsInsuranceTypeTerms> getTmsInsuranceTypeTerms() {
        return tmsInsuranceTypeTerms;
    }

    public void setTmsInsuranceTypeTerms(Set<TmsInsuranceTypeTerms> tmsInsuranceTypeTerms) {
        this.tmsInsuranceTypeTerms = tmsInsuranceTypeTerms;
    }

}

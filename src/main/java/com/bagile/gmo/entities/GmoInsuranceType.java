package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "gmo_insurancetype")
public class GmoInsuranceType extends EmsEntity {

    private Long gmoInsuranceTypeId;
    private String gmoInsuranceTypeCode;
    private String gmoInsuranceTypeDescription;
   // private Set<GmoInsurance> gmoInsurances= new HashSet<>();

   // private Set<GmoVehicleCategory> gmoVehicleCategories= new HashSet<>();

    private Set<GmoInsuranceTypeTerms> gmoInsuranceTypeTerms=new HashSet<>();

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_insurancetype_id", allocationSize = 1)
    @Column(name = "gmo_insurancetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoInsuranceTypeId() {
        return gmoInsuranceTypeId;
    }

    public void setGmoInsuranceTypeId(Long gmoInsuranceTypeId) {
        this.gmoInsuranceTypeId = gmoInsuranceTypeId;
    }

    @Column(name = "gmo_insurancetypecode", unique = true, nullable = false, length = 90)
    public String getGmoInsuranceTypeCode() {
        return gmoInsuranceTypeCode;
    }

    public void setGmoInsuranceTypeCode(String gmoInsuranceTypeCode) {
        this.gmoInsuranceTypeCode = gmoInsuranceTypeCode;
    }
    @Column(name = "gmo_insurancetypedescription")
    public String getGmoInsuranceTypeDescription() {
        return gmoInsuranceTypeDescription;
    }

    public void setGmoInsuranceTypeDescription(String gmoInsuranceTypeDescription) {
        this.gmoInsuranceTypeDescription = gmoInsuranceTypeDescription;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_ownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    /*

  /* @OneToMany(mappedBy = "gmoInsuranceType",)
    public Set<GmoVehicleCategory> getGmoVehicleCategories() {
        return gmoVehicleCategories;
    }

    public void setGmoVehicleCategories(Set<GmoVehicleCategory> gmoVehicleCategories) {
        this.gmoVehicleCategories = gmoVehicleCategories;
    }*/

    @OneToMany(mappedBy = "gmoInsuranceType", cascade = CascadeType.ALL,orphanRemoval = true)
    public Set<GmoInsuranceTypeTerms> getGmoInsuranceTypeTerms() {
        return gmoInsuranceTypeTerms;
    }

    public void setGmoInsuranceTypeTerms(Set<GmoInsuranceTypeTerms> gmoInsuranceTypeTerms) {
        this.gmoInsuranceTypeTerms = gmoInsuranceTypeTerms;
    }

}

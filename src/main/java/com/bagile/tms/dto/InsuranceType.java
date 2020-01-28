package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.*;

public class InsuranceType extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private String code;
    private String description;
    private Set<Insurance> insurances=new HashSet<>();
   // private Set<VehicleCategory> vehicleCategories = new HashSet<>();

    private List<InsuranceTypeTerms> insuranceTypeTermsSet=new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Set<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(Set<Insurance> insurances) {
        this.insurances = insurances;
    }

  /*  public Set<VehicleCategory> getVehicleCategories() {
        return vehicleCategories;
    }

    public void setVehicleCategories(Set<VehicleCategory> vehicleCategories) {
        this.vehicleCategories = vehicleCategories;
    }
*/
    public List<InsuranceTypeTerms> getInsuranceTypeTermsSet() {
        return insuranceTypeTermsSet;
    }

    public void setInsuranceTypeTermsSet(List<InsuranceTypeTerms> insuranceTypeTermsSet) {
        this.insuranceTypeTermsSet = insuranceTypeTermsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceType badgeType = (InsuranceType) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

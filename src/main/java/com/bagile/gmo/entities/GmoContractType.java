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
@Table(name="gmo_contracttype")
public class GmoContractType extends EmsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_contracttype_id", allocationSize = 1)
    @Column(name = "gmo_contracttypeid", unique = true, nullable = false, precision = 10, scale = 0)
     private long gmoContractTypeId;
    @Column(name = "gmo_contracttypecode", unique = true, nullable = false, length = 90)
    private String gmoContractTypeCode;

    @Column(name = "gmo_contracttypedescription")
    private String gmoContractTypeDescription;

    @OneToMany(mappedBy = "gmoContractType",cascade = CascadeType.ALL)
    private Set<GmoVehicle> gmoVehicles = new HashSet<>();


    public GmoContractType() {
    }

    public Set<GmoVehicle> getGmoVehicles() {
        return gmoVehicles;
    }

    public void setGmoVehicles(Set<GmoVehicle> gmoVehicles) {
        this.gmoVehicles = gmoVehicles;
    }

    public long getGmoContractTypeId() {
        return gmoContractTypeId;
    }

    public void setGmoContractTypeId(long gmoContractTypeId) {
        this.gmoContractTypeId = gmoContractTypeId;
    }

    public String getGmoContractTypeCode() {
        return gmoContractTypeCode;
    }

    public void setGmoContractTypeCode(String gmoContractTypeCode) {
        this.gmoContractTypeCode = gmoContractTypeCode;
    }

    public String getGmoContractTypeDescription() {
        return gmoContractTypeDescription;
    }

    public void setGmoContractTypeDescription(String gmoContractTypeDescription) {
        this.gmoContractTypeDescription = gmoContractTypeDescription;
    }
}

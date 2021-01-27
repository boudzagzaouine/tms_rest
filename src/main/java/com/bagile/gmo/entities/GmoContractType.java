package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="gmo_contracttype")
public class GmoContractType extends EmsEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_contracttype_id", allocationSize = 1)
    @Column(name = "gmo_contracttypeid", unique = true, nullable = false, precision = 10, scale = 0)
     private Long gmoContractTypeId;
    @Column(name = "gmo_contracttypecode", unique = true, nullable = false, length = 90)
    private String gmoContractTypeCode;

    @Column(name = "gmo_contracttypedescription")
    private String gmoContractTypeDescription;

    @OneToMany(mappedBy = "gmoContractType",cascade = CascadeType.ALL)
    private Set<GmoVehicle> gmoVehicles = new HashSet<>();


    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    private OwnOwner ownOwner;

    public GmoContractType() {
    }

    public Set<GmoVehicle> getGmoVehicles() {
        return gmoVehicles;
    }

    public void setGmoVehicles(Set<GmoVehicle> gmoVehicles) {
        this.gmoVehicles = gmoVehicles;
    }

    public Long getGmoContractTypeId() {
        return gmoContractTypeId;
    }

    public void setGmoContractTypeId(Long gmoContractTypeId) {
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


    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}

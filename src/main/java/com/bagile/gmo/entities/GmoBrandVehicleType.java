package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "gmo_brandvehicletype")
public class GmoBrandVehicleType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoBrandVehicleTypeId;
    private String gmoBrandVehicleTypeCode;
    private String gmoBrandVehicleTypeDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_brand_vehicle_type_id", allocationSize = 1)
    @Column(name = "gmo_brandvehicletypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoBrandVehicleTypeId() {
        return gmoBrandVehicleTypeId;
    }

    public void setGmoBrandVehicleTypeId(Long gmoBrandVehicleTypeId) {
        this.gmoBrandVehicleTypeId = gmoBrandVehicleTypeId;
    }

    @Column(name = "gmo_brandvehicletypecode", unique = true, nullable = false, length = 90)
    public String getGmoBrandVehicleTypeCode() {
        return gmoBrandVehicleTypeCode;
    }

    public void setGmoBrandVehicleTypeCode(String gmoBrandVehicleTypeCode) {
        this.gmoBrandVehicleTypeCode = gmoBrandVehicleTypeCode;
    }

    @Column(name = "gmo_brandvehicletypedescription")
    public String getGmoBrandVehicleTypeDescription() {
        return gmoBrandVehicleTypeDescription;
    }

    public void setGmoBrandVehicleTypeDescription(String gmoBrandVehicleTypeDescription) {
        this.gmoBrandVehicleTypeDescription = gmoBrandVehicleTypeDescription;
    }


    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}

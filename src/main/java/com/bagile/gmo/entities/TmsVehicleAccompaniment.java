package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_vehicleaccompaniment")
public class TmsVehicleAccompaniment extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsVehicleAccompanimentId;
    private String tmsVehicleAccompanimentCode;
    private String tmsVehicleAccompanimentDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehicleaccompaniment_id", allocationSize = 1)
    @Column(name = "tms_vehicleaccompanimentid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoVehicleAccompanimentId() {
        return tmsVehicleAccompanimentId;
    }

    public void setGmoVehicleAccompanimentId(Long tmsVehicleAccompanimentId) {
        this.tmsVehicleAccompanimentId = tmsVehicleAccompanimentId;
    }

    @Column(name = "tms_vehicleaccompanimentcode", unique = true, nullable = false, length = 90)
    public String getGmoVehicleAccompanimentCode() {
        return tmsVehicleAccompanimentCode;
    }

    public void setGmoVehicleAccompanimentCode(String tmsVehicleAccompanimentCode) {
        this.tmsVehicleAccompanimentCode = tmsVehicleAccompanimentCode;
    }

    @Column(name = "tms_vehicleaccompanimentdescription")
    public String getGmoVehicleAccompanimentDescription() {
        return tmsVehicleAccompanimentDescription;
    }

    public void setGmoVehicleAccompanimentDescription(String tmsVehicleAccompanimentDescription) {
        this.tmsVehicleAccompanimentDescription = tmsVehicleAccompanimentDescription;
    }



    @ManyToOne()
    @JoinColumn(name="tms_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}

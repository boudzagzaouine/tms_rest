package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "tms_vehicletray")
public class TmsVehicleTray extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsVehicleTrayId;
    private String tmsVehicleTrayCode;
    private String tmsVehicleTrayDescription;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehicle_tray_id", allocationSize = 1)
    @Column(name = "tms_vehicletrayid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsVehicleTrayId() {
        return tmsVehicleTrayId;
    }

    public void setTmsVehicleTrayId(Long tmsVehicleTrayId) {
        this.tmsVehicleTrayId = tmsVehicleTrayId;
    }

    @Column(name = "tms_vehicletraycode", unique = true, nullable = false, length = 90)
    public String getTmsVehicleTrayCode() {
        return tmsVehicleTrayCode;
    }

    public void setTmsVehicleTrayCode(String tmsVehicleTrayCode) {
        this.tmsVehicleTrayCode = tmsVehicleTrayCode;
    }

    @Column(name = "tms_vehicletraydescription")
    public String getTmsVehicleTrayDescription() {
        return tmsVehicleTrayDescription;
    }

    public void setTmsVehicleTrayDescription(String tmsVehicleTrayDescription) {
        this.tmsVehicleTrayDescription = tmsVehicleTrayDescription;
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

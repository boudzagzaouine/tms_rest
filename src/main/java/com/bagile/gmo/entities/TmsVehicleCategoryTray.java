package com.bagile.gmo.entities;


import javax.persistence.*;


@Entity
@Table(name = "tms_vehiclecategorytray")
public class TmsVehicleCategoryTray extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsVehicleCategoryTrayId;
    private GmoVehicleCategory gmoVehicleCategory;
    private TmsVehicleTray tmsVehicleTray;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vehiclecategorytray_id", allocationSize = 1)
    @Column(name = "tms_vehiclecategorytrayid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsVehicleCategoryTrayId() {
        return tmsVehicleCategoryTrayId;
    }

    public void setTmsVehicleCategoryTrayId(Long tmsMarchandiseTypeId) {
        this.tmsVehicleCategoryTrayId = tmsMarchandiseTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "tms_gmovehiclecategory")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }
    @ManyToOne
    @JoinColumn(name = "tms_tmsvehicletray")
    public TmsVehicleTray getTmsVehicleTray() {
        return tmsVehicleTray;
    }

    public void setTmsVehicleTray(TmsVehicleTray tmsVehicleTray) {
        this.tmsVehicleTray = tmsVehicleTray;
    }

    @ManyToOne
    @JoinColumn(name = "tms_notificationtypeownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }


}

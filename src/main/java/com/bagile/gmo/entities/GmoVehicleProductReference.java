package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "gmo_vehicleproductreference")
public class GmoVehicleProductReference extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoVehicleProductReferenceId;

  private GmoVehicleProduct gmoVehicleProduct;

    private String gmoVehicleProductReference;


    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_vehicle_product_reference_id", allocationSize = 1)
    @Column(name = "gmo_gmovehicleproductreferenceeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoVehicleProductReferenceId() {
        return gmoVehicleProductReferenceId;
    }

    public void setGmoVehicleProductReferenceId(Long gmoActionTypeId) {
        this.gmoVehicleProductReferenceId = gmoActionTypeId;
    }


    @ManyToOne
    @JoinColumn(name = "gmo_gmovehicleproductid")
    public GmoVehicleProduct getGmoVehicleProduct() {
        return gmoVehicleProduct;
    }

    public void setGmoVehicleProduct(GmoVehicleProduct gmoVehicleProduct) {
        this.gmoVehicleProduct = gmoVehicleProduct;
    }


    @Column(name = "gmo_gmovehicleproductreferencereference")
    public String getGmoVehicleProductReference() {
        return gmoVehicleProductReference;
    }

    public void setGmoVehicleProductReference(String gmoVehicleProductReference) {
        this.gmoVehicleProductReference = gmoVehicleProductReference;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_notificationtypeownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }


}

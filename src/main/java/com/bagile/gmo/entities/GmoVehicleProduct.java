package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "gmo_vehicleproduct")
public class GmoVehicleProduct extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoVehicleProductId;

    private PdtProductType pdtProductType;

    private PdtProduct pdtProduct;
    private String gmoVehicleProductReference;

    private String gmoVehicleProductReferenceOther;
    private OwnOwner ownOwner;
    private GmoVehicle gmoVehicle;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_vehicle_product_id", allocationSize = 1)
    @Column(name = "gmo_vehicleproducteid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoVehicleProductId() {
        return gmoVehicleProductId;
    }

    public void setGmoVehicleProductId(Long gmoActionTypeId) {
        this.gmoVehicleProductId = gmoActionTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_pdtproductid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_vehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }

    @Column(name = "gmo_vehicleproductreference")
    public String getGmoVehicleProductReference() {
        return gmoVehicleProductReference;
    }

    public void setGmoVehicleProductReference(String gmoVehicleProductReference) {
        this.gmoVehicleProductReference = gmoVehicleProductReference;
    }

    @ManyToOne
    @JoinColumn(name = "pdt_producttypeid")
    public PdtProductType getPdtProductType() {
        return pdtProductType;
    }

    public void setPdtProductType(PdtProductType pdtProductType) {
        this.pdtProductType = pdtProductType;
    }

    @Column(name = "gmo_vehicleproductreferenceother")
    public String getGmoVehicleProductReferenceOther() {
        return gmoVehicleProductReferenceOther;
    }

    public void setGmoVehicleProductReferenceOther(String gmoVehicleProductReferenceOther) {
        this.gmoVehicleProductReferenceOther = gmoVehicleProductReferenceOther;
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

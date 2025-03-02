package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "gmo_transportcategoryvehicle",uniqueConstraints ={@UniqueConstraint(columnNames ={"gmo_vehiclecategoryid","trp_transportid"})} )

public class GmoTransportCategoryVehicle extends EmsEntity {


    private Long gmoCatalogTransportCategorieVehicleId;
    private GmoVehicleCategory gmoVehicleCategory;
    private TrpTransport trpTransport;
    private int gmoTransportCategorieVehicleQuantity;

    private OwnOwner ownOwner;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_badge_type_id", allocationSize = 1)
    @Column(name = "gmo_transportcategoryvehicleid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoCatalogTransportCategorieVehicleId() {
        return gmoCatalogTransportCategorieVehicleId;
    }

    public void setGmoCatalogTransportCategorieVehicleId(Long gmoCatalogTransportCategorieVehicleId) {
        this.gmoCatalogTransportCategorieVehicleId = gmoCatalogTransportCategorieVehicleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_vehiclecategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trp_transportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }



    @Column(name = "gmo_transportcategoryvehiclequantity")
    public int getGmoTransportCategorieVehicleQuantity() {
        return gmoTransportCategorieVehicleQuantity;
    }

    public void setGmoTransportCategorieVehicleQuantity(int gmoTransportCategorieVehicleQuantit) {
        this.gmoTransportCategorieVehicleQuantity = gmoTransportCategorieVehicleQuantit;
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

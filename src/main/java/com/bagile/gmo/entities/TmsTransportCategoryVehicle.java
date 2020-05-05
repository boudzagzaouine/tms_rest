package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "tms_transportcategoryvehicle",uniqueConstraints ={@UniqueConstraint(columnNames ={"tms_vehiclecategoryid","trp_transportid"})} )

public class TmsTransportCategoryVehicle extends EmsEntity {


    private long tmsCatalogTransportCategorieVehicleId;
    private GmoVehicleCategory tmsVehicleCategory;
    private TrpTransport trpTransport;
    private int tmsTransportCategorieVehicleQuantity;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_badge_type_id", allocationSize = 1)
    @Column(name = "tms_transportcategoryvehicleid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsCatalogTransportCategorieVehicleId() {
        return tmsCatalogTransportCategorieVehicleId;
    }

    public void setTmsCatalogTransportCategorieVehicleId(long tmsCatalogTransportCategorieVehicleId) {
        this.tmsCatalogTransportCategorieVehicleId = tmsCatalogTransportCategorieVehicleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclecategoryid")
    public GmoVehicleCategory getTmsVehicleCategory() {
        return tmsVehicleCategory;
    }

    public void setTmsVehicleCategory(GmoVehicleCategory tmsVehicleCategory) {
        this.tmsVehicleCategory = tmsVehicleCategory;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trp_transportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }



    @Column(name = "tms_transportcategoryvehiclequantity")
    public int getTmsTransportCategorieVehicleQuantity() {
        return tmsTransportCategorieVehicleQuantity;
    }

    public void setTmsTransportCategorieVehicleQuantity(int tmsTransportCategorieVehicleQuantit) {
        this.tmsTransportCategorieVehicleQuantity = tmsTransportCategorieVehicleQuantit;
    }
}

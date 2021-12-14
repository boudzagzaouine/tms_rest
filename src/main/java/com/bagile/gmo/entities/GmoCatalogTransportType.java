package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="gmo_catalogtransport",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"gmo_vehiclecategoryid","trp_transportid",
                               "gmo_zonesournceid","gmo_zonedistinationid"})})
public class GmoCatalogTransportType extends EmsEntity{

    private Long gmoCatalogTransportId;
    private TrpTransport trpTransport;
    private GmoVehicleCategory gmoVehicleCategory;
    private GmoZone gmoZoneSource ;
    private GmoZone gmoZoneDestination;
    private BigDecimal gmoCatalogTransportAmountHt;
    private BigDecimal gmoCatalogTransportAmountTtc;
    private BigDecimal gmoCatalogTransportAmountTva;
    private PrmVat prmvat;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_catalogtransportcategoryvehicle_id", allocationSize = 1)
    @Column(name = "gmo_catalogtransportcategoryvehicleid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoCatalogTransportCategoryVehicleId() {
        return gmoCatalogTransportId;
    }

    public void setGmoCatalogTransportCategoryVehicleId(Long gmoCatalogTransportCategoryVehicleId) {
        this.gmoCatalogTransportId = gmoCatalogTransportCategoryVehicleId;
    }

    @ManyToOne()
    @JoinColumn(name = "trp_transportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_vehiclecategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_zonesournceid")
    public GmoZone getGmoZoneSource() {
        return gmoZoneSource;
    }

    public void setGmoZoneSource(GmoZone gmoZoneSource) {
        this.gmoZoneSource = gmoZoneSource;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_zonedistinationid")
    public GmoZone getGmoZoneDestination() {
        return gmoZoneDestination;
    }

    public void setGmoZoneDestination(GmoZone gmoZoneDestination) {
        this.gmoZoneDestination = gmoZoneDestination;
    }

    @Column(name = "gmo_catalogtransportamountht")
    public BigDecimal getGmoCatalogTransportCategoryVehicleAmountHt() {
        return gmoCatalogTransportAmountHt;
    }

    public void setGmoCatalogTransportCategoryVehicleAmountHt(BigDecimal gmoCatalogTransportCategoryVehicleAmountHt) {
        this.gmoCatalogTransportAmountHt = gmoCatalogTransportCategoryVehicleAmountHt;
    }

    @Column(name = "gmo_catalogtransportamountttc")
    public BigDecimal getGmoCatalogTransportCategoryVehicleAmountTtc() {
        return gmoCatalogTransportAmountTtc;
    }

    public void setGmoCatalogTransportCategoryVehicleAmountTtc(BigDecimal gmoCatalogTransportCategoryVehicleAmountTtc) {
        this.gmoCatalogTransportAmountTtc = gmoCatalogTransportCategoryVehicleAmountTtc;
    }

    @Column(name = "gmo_catalogtransportamounttva")
    public BigDecimal getGmoCatalogTransportCategoryVehicleAmountTva() {
        return gmoCatalogTransportAmountTva;
    }

    public void setGmoCatalogTransportCategoryVehicleAmountTva(BigDecimal gmoCatalogTransportCategoryVehicleAmountTva) {
        this.gmoCatalogTransportAmountTva = gmoCatalogTransportCategoryVehicleAmountTva;
    }
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "prm_vatid")
    public PrmVat getPrmvat() {
        return prmvat;
    }

    public void setPrmvat(PrmVat prmvat) {
        this.prmvat = prmvat;
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


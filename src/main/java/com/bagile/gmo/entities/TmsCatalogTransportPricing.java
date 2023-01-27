package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tms_catalog_transport_pricing",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"trp_transportid","gmo_vehiclecategoryid","tms_vehicletrayid",
                        "tms_trajetid","tms_turntypeid","tms_loadingtypeid"})})
public class TmsCatalogTransportPricing extends EmsEntity{

    private Long tmsCatalogTransportId;
    private TrpTransport trpTransport;
    private GmoVehicleCategory gmoVehicleCategory;
    private TmsVehicleTray tmsVehicleTray;
    private TmsTurnType tmsTurnType;
   private  TmsTrajet tmsTrajet;
    private TmsLoadingType tmsLoadingType ;

    private BigDecimal tmsCatalogTransportPricingPurchaseAmountHt;
    private BigDecimal tmsCatalogTransportPricingPurchaseAmountTtc;
    private BigDecimal tmsCatalogTransportPricingPurchaseAmountTva;
    private PrmVat prmPurchaseVat;
    private OwnOwner ownOwner;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_catalogtransportpricing_id", allocationSize = 1)
    @Column(name = "tms_catalogtransportpricingid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsCatalogTransportId() {
        return tmsCatalogTransportId;
    }

    public void setTmsCatalogTransportId(Long gmoCatalogTransportId) {
        this.tmsCatalogTransportId = gmoCatalogTransportId;
    }

    @ManyToOne()
    @JoinColumn(name = "trp_transportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }

    @ManyToOne()
    @JoinColumn(name = "gmo_vehiclecategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_vehicletrayid")
    public TmsVehicleTray getTmsVehicleTray() {
        return tmsVehicleTray;
    }

    public void setTmsVehicleTray(TmsVehicleTray tmsVehicleTray) {
        this.tmsVehicleTray = tmsVehicleTray;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_turntypeid")
    public TmsTurnType getTmsTurnType() {
        return tmsTurnType;
    }

    public void setTmsTurnType(TmsTurnType tmsTurnType) {
        this.tmsTurnType = tmsTurnType;
    }



    @ManyToOne()
    @JoinColumn(name = "tms_trajetid")
    public TmsTrajet getTmsTrajet() {
        return tmsTrajet;
    }

    public void setTmsTrajet(TmsTrajet tmsTrajet) {
        this.tmsTrajet = tmsTrajet;
    }




    @ManyToOne()
    @JoinColumn(name = "tms_loadingtypeid")
    public TmsLoadingType getTmsLoadingType() {
        return tmsLoadingType;
    }

    public void setTmsLoadingType(TmsLoadingType tmsLoadingType) {
        this.tmsLoadingType = tmsLoadingType;
    }

    @Column(name="tms_catalogtransportpricingpurchaseammountht")
    public BigDecimal getTmsCatalogTransportPricingPurchaseAmountHt() {
        return tmsCatalogTransportPricingPurchaseAmountHt;
    }

    public void setTmsCatalogTransportPricingPurchaseAmountHt(BigDecimal tmsCatalogTransportPricingPurchaseAmountHt) {
        this.tmsCatalogTransportPricingPurchaseAmountHt = tmsCatalogTransportPricingPurchaseAmountHt;
    }
    @Column(name="tms_catalogtransportpricingpurchaseammountttc")
    public BigDecimal getTmsCatalogTransportPricingPurchaseAmountTtc() {
        return tmsCatalogTransportPricingPurchaseAmountTtc;
    }

    public void setTmsCatalogTransportPricingPurchaseAmountTtc(BigDecimal tmsCatalogTransportPricingPurchaseAmountTtc) {
        this.tmsCatalogTransportPricingPurchaseAmountTtc = tmsCatalogTransportPricingPurchaseAmountTtc;
    }
    @Column(name="tms_catalogtransportpricingpurchaseammounttva")

    public BigDecimal getTmsCatalogTransportPricingPurchaseAmountTva() {
        return tmsCatalogTransportPricingPurchaseAmountTva;
    }

    public void setTmsCatalogTransportPricingPurchaseAmountTva(BigDecimal tmsCatalogTransportPricingPurchaseAmountTva) {
        this.tmsCatalogTransportPricingPurchaseAmountTva = tmsCatalogTransportPricingPurchaseAmountTva;
    }

    @ManyToOne()
    @JoinColumn(name = "prm_purchasevatid")
    public PrmVat getPrmPurchaseVat() {
        return prmPurchaseVat;
    }

    public void setPrmPurchaseVat(PrmVat prmPurchaseVat) {
        this.prmPurchaseVat = prmPurchaseVat;
    }

    @ManyToOne()
    @JoinColumn(name = "own_ownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}


package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tms_catalog_transport_pricing",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"trp_transportid","gmo_vehiclecategoryid","tms_vehicletrayid",
                        "prm_villesourceid","prm_villedestinationid","tms_turntypeid","tms_loadingtypeid"})})
public class TmsCatalogTransportPricing extends EmsEntity{

    private Long tmsCatalogTransportId;
    private TrpTransport trpTransport;
    private GmoVehicleCategory gmoVehicleCategory;
    private TmsVehicleTray tmsVehicleTray;
    private TmsTurnType tmsTurnType;
    private PrmPays prmPaysSource;
    private PrmVille tmsVilleSource ;
    private PrmPays prmPaysDestination;
    private PrmVille tmsVilleDestination;
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
    @JoinColumn(name = "prm_payssourceid")
    public PrmPays getPrmPaysSource() {
        return prmPaysSource;
    }

    public void setPrmPaysSource(PrmPays prmPaysSource) {
        this.prmPaysSource = prmPaysSource;
    }
    @ManyToOne()
    @JoinColumn(name = "prm_villesourceid")
    public PrmVille getTmsVilleSource() {
        return tmsVilleSource;
    }

    public void setTmsVilleSource(PrmVille tmsVilleSource) {
        this.tmsVilleSource = tmsVilleSource;
    }

    @ManyToOne()
    @JoinColumn(name = "prm_paysdestinationid")
    public PrmPays getPrmPaysDestination() {
        return prmPaysDestination;
    }

    public void setPrmPaysDestination(PrmPays prmPaysDestination) {
        this.prmPaysDestination = prmPaysDestination;
    }

    @ManyToOne()
    @JoinColumn(name = "prm_villedestinationid")
    public PrmVille getTmsVilleDestination() {
        return tmsVilleDestination;
    }

    public void setTmsVilleDestination(PrmVille tmsVilleDestination) {
        this.tmsVilleDestination = tmsVilleDestination;
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


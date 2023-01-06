package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tms_catalog_account_transport_pricing",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"trp_transportid","gmo_vehiclecategoryid","tms_vehicletrayid",
                        "prm_villesourceid","prm_villedestinationid","tms_turntypeid","tms_loadingtypeid"})})
public class TmsCatalogTransportAccountPricing extends EmsEntity{

    private Long tmsCatalogTransportAccountPricingId;
    private TrpTransport trpTransport;
    private CmdCompany cmdCompany;
    private GmoVehicleCategory gmoVehicleCategory;
    private TmsVehicleTray tmsVehicleTray;
    private TmsTurnType tmsTurnType;
    private PrmPays prmPaysSource;
    private PrmVille tmsVilleSource ;
    private PrmPays prmPaysDestination;
    private PrmVille tmsVilleDestination;
    private TmsLoadingType tmsLoadingType ;

    private BigDecimal tmsCatalogTransportAccountPricingPurchaseAmountHt;
    private BigDecimal tmsCatalogTransportAccountPricingPurchaseAmountTtc;
    private BigDecimal tmsCatalogTransportAccountPricingPurchaseAmountTva;
    private PrmVat prmPurchaseVat;
    private OwnOwner ownOwner;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_catalogtransportaccountpricing_id", allocationSize = 1)
    @Column(name = "tms_catalogtransportaccountpricingid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsCatalogTransportAccountPricingId() {
        return tmsCatalogTransportAccountPricingId;
    }

    public void setTmsCatalogTransportAccountPricingId(Long gmoCatalogTransportAccountPricingId) {
        this.tmsCatalogTransportAccountPricingId = gmoCatalogTransportAccountPricingId;
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
    @JoinColumn(name = "cmd_companyid")
    public CmdCompany getCmdCompany() {
        return cmdCompany;
    }

    public void setCmdCompany(CmdCompany cmdCompany) {
        this.cmdCompany = cmdCompany;
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

    @Column(name="tms_catalogtransportaccountpricingpurchaseammountht")
    public BigDecimal getTmsCatalogTransportAccountPricingPurchaseAmountHt() {
        return tmsCatalogTransportAccountPricingPurchaseAmountHt;
    }

    public void setTmsCatalogTransportAccountPricingPurchaseAmountHt(BigDecimal tmsCatalogTransportAccountPricingPurchaseAmountHt) {
        this.tmsCatalogTransportAccountPricingPurchaseAmountHt = tmsCatalogTransportAccountPricingPurchaseAmountHt;
    }

    @Column(name="tms_catalogtransportaccountpricingpurchaseammountttc")
    public BigDecimal getTmsCatalogTransportAccountPricingPurchaseAmountTtc() {
        return tmsCatalogTransportAccountPricingPurchaseAmountTtc;
    }

    public void setTmsCatalogTransportAccountPricingPurchaseAmountTtc(BigDecimal tmsCatalogTransportAccountPricingPurchaseAmountTtc) {
        this.tmsCatalogTransportAccountPricingPurchaseAmountTtc = tmsCatalogTransportAccountPricingPurchaseAmountTtc;
    }


    @Column(name="tms_catalogtransportaccountpricingpurchaseammounttva")
    public BigDecimal getTmsCatalogTransportAccountPricingPurchaseAmountTva() {
        return tmsCatalogTransportAccountPricingPurchaseAmountTva;
    }

    public void setTmsCatalogTransportAccountPricingPurchaseAmountTva(BigDecimal tmsCatalogTransportAccountPricingPurchaseAmountTva) {
        this.tmsCatalogTransportAccountPricingPurchaseAmountTva = tmsCatalogTransportAccountPricingPurchaseAmountTva;
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


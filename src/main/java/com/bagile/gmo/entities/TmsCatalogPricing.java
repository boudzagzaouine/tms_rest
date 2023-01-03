package com.bagile.gmo.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tms_catalogpricing",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"tms_vehiclecategoryid",
                               "tms_villesournceid","tms_villedistinationid","tms_turntypeid","tms_vehicletrayid","tms_loadingtypeid"})})
public class TmsCatalogPricing extends EmsEntity {

    private Long tmsCatalogPricingId;
    private GmoVehicleCategory gmoVehicleCategory;
    private TmsVehicleTray tmsVehicleTray;
    private TmsTurnType tmsTurnType;
    private PrmPays prmPaysSource;
    private PrmVille tmsVilleSource ;
    private PrmPays prmPaysDestination;
    private PrmVille tmsVilleDestination;

    private TmsLoadingType tmsLoadingType ;
    private BigDecimal tmsCatalogPricingPurchaseAmountHt;
    private BigDecimal tmsCatalogPricingPurchaseAmountTtc;
    private BigDecimal tmsCatalogPricingPurchaseAmountTva;
    private PrmVat prmPurchaseVat;



    private BigDecimal tmsCatalogPricingSaleAmountHt;
    private BigDecimal tmsCatalogPricingSaleAmountTtc;
    private BigDecimal tmsCatalogPricingSaleAmountTva;
    private PrmVat prmPricingSaleVat;

    private OwnOwner ownOwner;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_catalogpricing_id", allocationSize = 1)
    @Column(name = "tms_catalogpricingid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsCatalogPricingId() {
        return tmsCatalogPricingId;
    }

    public void setTmsCatalogPricingId(Long tmsCatalogPricingId) {
        this.tmsCatalogPricingId = tmsCatalogPricingId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehiclecategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_loadingtypeid")
    public TmsLoadingType getTmsLoadingType() {
        return tmsLoadingType;
    }

    public void setTmsLoadingType(TmsLoadingType tmsLoadingType) {
        this.tmsLoadingType = tmsLoadingType;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_payssourceid")
    public PrmPays getPrmPaysSource() {
        return prmPaysSource;
    }

    public void setPrmPaysSource(PrmPays prmPaysSource) {
        this.prmPaysSource = prmPaysSource;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vehicletrayid")
    public TmsVehicleTray getTmsVehicleTray() {
        return tmsVehicleTray;
    }

    public void setTmsVehicleTray(TmsVehicleTray tmsVehicleTray) {
        this.tmsVehicleTray = tmsVehicleTray;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_villesournceid")
    public PrmVille getTmsVilleSource() {
        return tmsVilleSource;
    }

    public void setTmsVilleSource(PrmVille tmsVilleSource) {
        this.tmsVilleSource = tmsVilleSource;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_paysdestinationid")
    public PrmPays getPrmPaysDestination() {
        return prmPaysDestination;
    }

    public void setPrmPaysDestination(PrmPays prmPaysDestination) {
        this.prmPaysDestination = prmPaysDestination;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_villedistinationid")
    public PrmVille getTmsVilleDestination() {
        return tmsVilleDestination;
    }

    public void setTmsVilleDestination(PrmVille tmsVilleDestination) {
        this.tmsVilleDestination = tmsVilleDestination;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_turntypeid")
    public TmsTurnType getTmsTurnType() {
        return tmsTurnType;
    }

    public void setTmsTurnType(TmsTurnType tmsTurnType) {
        this.tmsTurnType = tmsTurnType;
    }

    @Column(name = "tms_catalogpricingpurchaseamountht")
    public BigDecimal getTmsCatalogPricingPurchaseAmountHt() {
        return tmsCatalogPricingPurchaseAmountHt;
    }

    public void setTmsCatalogPricingPurchaseAmountHt(BigDecimal tmsCatalogPricingPurchaseAmountHt) {
        this.tmsCatalogPricingPurchaseAmountHt = tmsCatalogPricingPurchaseAmountHt;
    }


    @Column(name = "tms_catalogpricingpurchaseamountttc")
    public BigDecimal getTmsCatalogPricingPurchaseAmountTtc() {
        return tmsCatalogPricingPurchaseAmountTtc;
    }

    public void setTmsCatalogPricingPurchaseAmountTtc(BigDecimal tmsCatalogPricingPurchaseAmountTtc) {
        this.tmsCatalogPricingPurchaseAmountTtc = tmsCatalogPricingPurchaseAmountTtc;
    }

    @Column(name = "tms_catalogpricingpurchaseamountvat")
    public BigDecimal getTmsCatalogPricingPurchaseAmountTva() {
        return tmsCatalogPricingPurchaseAmountTva;
    }

    public void setTmsCatalogPricingPurchaseAmountTva(BigDecimal tmsCatalogPricingPurchaseAmountTva) {
        this.tmsCatalogPricingPurchaseAmountTva = tmsCatalogPricingPurchaseAmountTva;
    }

    @ManyToOne()
    @JoinColumn(name="tms_purchasevatid")
    public PrmVat getPrmPurchaseVat() {
        return prmPurchaseVat;
    }

    public void setPrmPurchaseVat(PrmVat prmPurchaseVat) {
        this.prmPurchaseVat = prmPurchaseVat;
    }


    @Column(name = "tms_catalogpricingsaleamountht")
    public BigDecimal getTmsCatalogPricingSaleAmountHt() {
        return tmsCatalogPricingSaleAmountHt;
    }

    public void setTmsCatalogPricingSaleAmountHt(BigDecimal tmsCatalogPricingSaleAmountHt) {
        this.tmsCatalogPricingSaleAmountHt = tmsCatalogPricingSaleAmountHt;
    }

    @Column(name = "tms_catalogpricingsaleamountttc")
    public BigDecimal getTmsCatalogPricingSaleAmountTtc() {
        return tmsCatalogPricingSaleAmountTtc;
    }

    public void setTmsCatalogPricingSaleAmountTtc(BigDecimal tmsCatalogPricingSaleAmountTtc) {
        this.tmsCatalogPricingSaleAmountTtc = tmsCatalogPricingSaleAmountTtc;
    }

    @Column(name = "tms_catalogpricingsaleamounttva")
    public BigDecimal getTmsCatalogPricingSaleAmountTva() {
        return tmsCatalogPricingSaleAmountTva;
    }

    public void setTmsCatalogPricingSaleAmountTva(BigDecimal tmsCatalogPricingSaleAmountTva) {
        this.tmsCatalogPricingSaleAmountTva = tmsCatalogPricingSaleAmountTva;
    }

    @ManyToOne()
    @JoinColumn(name="tms_salevatid")
    public PrmVat getPrmPricingSaleVat() {
        return prmPricingSaleVat;
    }

    public void setPrmPricingSaleVat(PrmVat prmPricingSaleVat) {
        this.prmPricingSaleVat = prmPricingSaleVat;
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


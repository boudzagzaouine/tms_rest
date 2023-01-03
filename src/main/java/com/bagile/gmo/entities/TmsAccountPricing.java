package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_account_pricing",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"tms_cmdcompanyid","tms_vehiclecategoryid",
                        "tms_villesourceid","tms_villedestinationid","tms_turntypeid","tms_vehicletrayid","tms_loadingtypeid"})})

public class TmsAccountPricing extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsAccountPricingId;
    private CmdCompany cmdCompany;

    private GmoVehicleCategory gmoVehicleCategory;
    private TmsVehicleTray tmsVehicleTray;
    private TmsTurnType tmsTurnType;
    private PrmPays prmPaysSource;
    private PrmVille tmsVilleSource ;
    private PrmPays prmPaysDestination;
    private PrmVille tmsVilleDestination;
    private TmsLoadingType tmsLoadingType ;

    private BigDecimal tmsAccountPricingSaleAmountHt;
    private BigDecimal tmsAccountPricingSaleAmountTtc;
    private BigDecimal tmsAccountPricingSaleAmountTva;
    private PrmVat prmSaleVat;





    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_account_pricing_id", allocationSize = 1)
    @Column(name = "gmo_accountpricingid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsAccountPricingId() {
        return tmsAccountPricingId;
    }

    public void setTmsAccountPricingId(Long tmsAccountPricingId) {
        this.tmsAccountPricingId = tmsAccountPricingId;
    }

    @ManyToOne()
    @JoinColumn(name="tms_cmdcompanyid")
    public CmdCompany getCmdCompany() {
        return cmdCompany;
    }

    public void setCmdCompany(CmdCompany cmdCompany) {
        this.cmdCompany = cmdCompany;
    }




    @ManyToOne()
    @JoinColumn(name="tms_vehiclecategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }

    @ManyToOne()
    @JoinColumn(name="tms_vehicletrayid")
    public TmsVehicleTray getTmsVehicleTray() {
        return tmsVehicleTray;
    }

    public void setTmsVehicleTray(TmsVehicleTray tmsVehicleTray) {
        this.tmsVehicleTray = tmsVehicleTray;
    }

    @ManyToOne()
    @JoinColumn(name="tms_turntypeid")
    public TmsTurnType getTmsTurnType() {
        return tmsTurnType;
    }

    public void setTmsTurnType(TmsTurnType tmsTurnType) {
        this.tmsTurnType = tmsTurnType;
    }

    @ManyToOne()
    @JoinColumn(name="tms_payssourceid")
    public PrmPays getPrmPaysSource() {
        return prmPaysSource;
    }

    public void setPrmPaysSource(PrmPays prmPaysSource) {
        this.prmPaysSource = prmPaysSource;
    }
    @ManyToOne()
    @JoinColumn(name="tms_villesourceid")
    public PrmVille getTmsVilleSource() {
        return tmsVilleSource;
    }

    public void setTmsVilleSource(PrmVille tmsVilleSource) {
        this.tmsVilleSource = tmsVilleSource;
    }
    @ManyToOne()
    @JoinColumn(name="tms_paysdestinationid")
    public PrmPays getPrmPaysDestination() {
        return prmPaysDestination;
    }

    public void setPrmPaysDestination(PrmPays prmPaysDestination) {
        this.prmPaysDestination = prmPaysDestination;
    }
    @ManyToOne()
    @JoinColumn(name="tms_villedestinationid")
    public PrmVille getTmsVilleDestination() {
        return tmsVilleDestination;
    }

    public void setTmsVilleDestination(PrmVille tmsVilleDestination) {
        this.tmsVilleDestination = tmsVilleDestination;
    }
    @ManyToOne()
    @JoinColumn(name="tms_loadingtypeid")
    public TmsLoadingType getTmsLoadingType() {
        return tmsLoadingType;
    }

    public void setTmsLoadingType(TmsLoadingType tmsLoadingType) {
        this.tmsLoadingType = tmsLoadingType;
    }

    @Column(name="tms_accountpricingsaleamountht")
    public BigDecimal getTmsAccountPricingSaleAmountHt() {
        return tmsAccountPricingSaleAmountHt;
    }

    public void setTmsAccountPricingSaleAmountHt(BigDecimal tmsAccountPricingSaleAmountHt) {
        this.tmsAccountPricingSaleAmountHt = tmsAccountPricingSaleAmountHt;
    }
    @Column(name="tms_accountpricingsaleamountttc")
    public BigDecimal getTmsAccountPricingSaleAmountTtc() {
        return tmsAccountPricingSaleAmountTtc;
    }

    public void setTmsAccountPricingSaleAmountTtc(BigDecimal tmsAccountPricingSaleAmountTtc) {
        this.tmsAccountPricingSaleAmountTtc = tmsAccountPricingSaleAmountTtc;
    }
    @Column(name="tms_accountpricingsaleamounttva")
    public BigDecimal getTmsAccountPricingSaleAmountTva() {
        return tmsAccountPricingSaleAmountTva;
    }

    public void setTmsAccountPricingSaleAmountTva(BigDecimal tmsAccountPricingSaleAmountTva) {
        this.tmsAccountPricingSaleAmountTva = tmsAccountPricingSaleAmountTva;
    }

    @ManyToOne()
    @JoinColumn(name="tms_salevatid")
    public PrmVat getPrmSaleVat() {
        return prmSaleVat;
    }

    public void setPrmSaleVat(PrmVat prmSaleVat) {
        this.prmSaleVat = prmSaleVat;
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

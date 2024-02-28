package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tms_transportplan")
public class TmsTransportPlan extends EmsEntity {

    private Long tmsTransportPlanId;

    private TmsOrderTransport tmsOrderTransport;
    private CmdAccount cmdAccount;
    private GmoVehicle gmoVehicle;
    private String gmoVehicleExterne;
    private GmoDriver gmoDriver;
    private String gmoDriverExterne;

    private GmoVehicleCategory gmoVehicleCategory;
    private TrpTransport trpTransport;

    private TmsTrajet tmsTrajet;
//    private PrmVille prmVilleSource;
//    private PrmVille prmVilleDistination;
    private TmsTurnStatus tmsTurnStatus;
    private BigDecimal tmsTransportPlanPurchasePrice;
    private BigDecimal tmsTransportPlanPurchasePriceNegotiated;
    private PrmVat tmsTransportPlanPurchaseVat;
    private BigDecimal tmsTransportPlanPurchasePriceTtc;
    private BigDecimal tmsTransportPlanPurchasePriceVat;

    private String tmsTransportPlanRemark;

    private BigDecimal tmsTransportPlanSalePrice;

    private  Date tmsTransportPlanDateDepart;
    private  Date tmsTransportPlanCloseDate;

    private  Date tmsTransportPlanDateValidate;

    private BigDecimal tmsTransportPlanMarginRate;
    private BigDecimal tmsTransportPlanmargineService;


    private BigDecimal tmsTransportPlanTotalPriceHT;
    private BigDecimal tmsTransportPlanTotalPriceTTC;
    private BigDecimal tmsTransportPlanTotalPriceVAT;

    private BigDecimal tmsTransportPlanTotalServiceHT;
    private BigDecimal tmsTransportPlanTotalServiceTTC;
    private BigDecimal tmsTransportPlanTotalServiceVAT;

    private Double tmsTransportPlanlatitude=0.0 ;
    private Double tmsTransportPlanlongitude =0.0;



   // private Set<TmsTransportPlanServiceCatalog> transportPlanServiceCatalogs = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_transportplan_id", allocationSize = 1)
    @Column(name = "tms_transportplanid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTransportPlanId() {
        return tmsTransportPlanId;
    }

    public void setTmsTransportPlanId(Long tmsTransportPlanId) {
        this.tmsTransportPlanId = tmsTransportPlanId;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_ordertransportid")
    public TmsOrderTransport getTmsOrderTransport() {
        return tmsOrderTransport;
    }

    public void setTmsOrderTransport(TmsOrderTransport tmsOrderTransport) {
        this.tmsOrderTransport = tmsOrderTransport;
    }

//    @ManyToOne()
//    @JoinColumn(name = "tms_prmvillesourceid")
//    public PrmVille getPrmVilleSource() {
//        return prmVilleSource;
//    }
//
//    public void setPrmVilleSource(PrmVille prmVilleSource) {
//        this.prmVilleSource = prmVilleSource;
//    }
//    @ManyToOne()
//    @JoinColumn(name = "tms_prmvilledistinationid")
//    public PrmVille getPrmVilleDistination() {
//        return prmVilleDistination;
//    }
//
//    public void setPrmVilleDistination(PrmVille prmVilleDistination) {
//        this.prmVilleDistination = prmVilleDistination;
//    }
    @ManyToOne()
    @JoinColumn(name = "tms_transportplantrajetid")

    public TmsTrajet getTmsTrajet() {
        return tmsTrajet;
    }

    public void setTmsTrajet(TmsTrajet tmsTrajet) {
        this.tmsTrajet = tmsTrajet;
    }

    @Column(name = "tms_transportplanclosedate")
    public Date getTmsTransportPlanCloseDate() {
        return tmsTransportPlanCloseDate;
    }

    public void setTmsTransportPlanCloseDate(Date tmsTransportPlanCloseDate) {
        this.tmsTransportPlanCloseDate = tmsTransportPlanCloseDate;
    }

    @Column(name = "tms_transportplanvehicleexterne")
    public String getGmoVehicleExterne() {
        return gmoVehicleExterne;
    }

    public void setGmoVehicleExterne(String gmoVehicleExterne) {
        this.gmoVehicleExterne = gmoVehicleExterne;
    }

    @Column(name = "tms_transportplandriverexterne")
    public String getGmoDriverExterne() {
        return gmoDriverExterne;
    }


    @Column(name = "tms_transportplanlocationlatitude")
    public Double getTmsTransportPlanlatitude() {
        return tmsTransportPlanlatitude;
    }

    public void setTmsTransportPlanlatitude(Double tmsTransportPlanlatitude) {
        this.tmsTransportPlanlatitude = tmsTransportPlanlatitude;
    }

    @Column(name = "tms_transportplanlocationlontitude")
    public Double getTmsTransportPlanlongitude() {
        return tmsTransportPlanlongitude;
    }

    public void setTmsTransportPlanlongitude(Double tmsTransportPlanlongitude) {
        this.tmsTransportPlanlongitude = tmsTransportPlanlongitude;
    }

    public void setGmoDriverExterne(String gmoDriverExterne) {
        this.gmoDriverExterne = gmoDriverExterne;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_cmdaccount")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }




    @ManyToOne()
    @JoinColumn(name = "tms_gmovehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }




//    @OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL,CascadeType.MERGE},mappedBy = "tmsTransportPlan", orphanRemoval=true)
//    public Set<TmsTransportPlanServiceCatalog> getTransportPlanServiceCatalogs() {
//        return transportPlanServiceCatalogs;
//    }
//
//    public void setTransportPlanServiceCatalogs(Set<TmsTransportPlanServiceCatalog> transportPlanServiceCatalogs) {
//        this.transportPlanServiceCatalogs = transportPlanServiceCatalogs;
//    }


    @ManyToOne()
    @JoinColumn(name = "tms_gmodriverid")
    public GmoDriver getGmoDriver() {
        return gmoDriver;
    }

    public void setGmoDriver(GmoDriver gmoDriver) {
        this.gmoDriver = gmoDriver;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_vehiclecategryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_turnstatusid")
    public TmsTurnStatus getTmsTurnStatus() {
        return tmsTurnStatus;
    }

    public void setTmsTurnStatus(TmsTurnStatus tmsTurnStatus) {
        this.tmsTurnStatus = tmsTurnStatus;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_trptransportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }

    @Column(name = "tms_transportplanpurchasepriceht")
    public BigDecimal getTmsTransportPlanPurchasePrice() {
        return tmsTransportPlanPurchasePrice;
    }

    public void setTmsTransportPlanPurchasePrice(BigDecimal tmsTransportPlanPriceTTC) {
        this.tmsTransportPlanPurchasePrice = tmsTransportPlanPriceTTC;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_prmpurchasevatid")
    public PrmVat getTmsTransportPlanPurchaseVat() {
        return tmsTransportPlanPurchaseVat;
    }

    public void setTmsTransportPlanPurchaseVat(PrmVat tmsTransportPlanPurchaseVat) {
        this.tmsTransportPlanPurchaseVat = tmsTransportPlanPurchaseVat;
    }

    @Column(name = "tms_transportplanpurchasepricettc")

    public BigDecimal getTmsTransportPlanPurchasePriceTtc() {
        return tmsTransportPlanPurchasePriceTtc;
    }

    public void setTmsTransportPlanPurchasePriceTtc(BigDecimal tmsTransportPlanPurchasePriceTtc) {
        this.tmsTransportPlanPurchasePriceTtc = tmsTransportPlanPurchasePriceTtc;
    }
    @Column(name = "tms_transportplanpurchasepricevat")

    public BigDecimal getTmsTransportPlanPurchasePriceVat() {
        return tmsTransportPlanPurchasePriceVat;
    }

    public void setTmsTransportPlanPurchasePriceVat(BigDecimal tmsTransportPlanPurchasePriceVat) {
        this.tmsTransportPlanPurchasePriceVat = tmsTransportPlanPurchasePriceVat;
    }

    @Column(name = "tms_transportplanmarginrate")
    public BigDecimal getTmsTransportPlanMarginRate() {
        return tmsTransportPlanMarginRate;
    }

    public void setTmsTransportPlanMarginRate(BigDecimal tmsTransportPlanMarginRate) {
        this.tmsTransportPlanMarginRate = tmsTransportPlanMarginRate;
    }


    @Column(name = "tms_transportplanremark")

    public String getTmsTransportPlanRemark() {
        return tmsTransportPlanRemark;
    }

    public void setTmsTransportPlanRemark(String tmsTransportPlanRemark) {
        this.tmsTransportPlanRemark = tmsTransportPlanRemark;
    }

    @Column(name = "tms_transportplanpurchasepricenegotiated")
    public BigDecimal getTmsTransportPlanPurchasePriceNegotiated() {
        return tmsTransportPlanPurchasePriceNegotiated;
    }

    public void setTmsTransportPlanPurchasePriceNegotiated(BigDecimal tmsTransportPlanPurchasePriceNegotiated) {
        this.tmsTransportPlanPurchasePriceNegotiated = tmsTransportPlanPurchasePriceNegotiated;
    }

    @Column(name = "tms_transportplantotalpriceht")

    public BigDecimal getTmsTransportPlanTotalPriceHT() {
        return tmsTransportPlanTotalPriceHT;
    }

    public void setTmsTransportPlanTotalPriceHT(BigDecimal totalPriceHT) {
        this.tmsTransportPlanTotalPriceHT = totalPriceHT;
    }
    @Column(name = "tms_transportplantotalpricettc")

    public BigDecimal getTmsTransportPlanTotalPriceTTC() {
        return tmsTransportPlanTotalPriceTTC;
    }

    public void setTmsTransportPlanTotalPriceTTC(BigDecimal totalPriceTTC) {
        this.tmsTransportPlanTotalPriceTTC = totalPriceTTC;
    }

    @Column(name = "tms_transportplantotalpricevat")
    public BigDecimal getTmsTransportPlanTotalPriceVAT() {
        return tmsTransportPlanTotalPriceVAT;
    }

    public void setTmsTransportPlanTotalPriceVAT(BigDecimal totalPriceVAT) {
        this.tmsTransportPlanTotalPriceVAT = totalPriceVAT;
    }
    @Column(name = "tms_transportplantotalserviceht")

    public BigDecimal getTmsTransportPlanTotalServiceHT() {
        return tmsTransportPlanTotalServiceHT;
    }

    public void setTmsTransportPlanTotalServiceHT(BigDecimal tmsTransportPlanTotalServiceHT) {
        this.tmsTransportPlanTotalServiceHT = tmsTransportPlanTotalServiceHT;
    }
    @Column(name = "tms_transportplantotalservicettc")

    public BigDecimal getTmsTransportPlanTotalServiceTTC() {
        return tmsTransportPlanTotalServiceTTC;
    }

    public void setTmsTransportPlanTotalServiceTTC(BigDecimal tmsTransportPlanTotalServiceTTC) {
        this.tmsTransportPlanTotalServiceTTC = tmsTransportPlanTotalServiceTTC;
    }

    @Column(name = "tms_transportplantotalservicevat")

    public BigDecimal getTmsTransportPlanTotalServiceVAT() {
        return tmsTransportPlanTotalServiceVAT;
    }

    public void setTmsTransportPlanTotalServiceVAT(BigDecimal tmsTransportPlanTotalServiceVAT) {
        this.tmsTransportPlanTotalServiceVAT = tmsTransportPlanTotalServiceVAT;
    }

    @Column(name = "tms_transportplanmarginservice")
    public BigDecimal getTmsTransportPlanmargineService() {
        return tmsTransportPlanmargineService;
    }

    public void setTmsTransportPlanmargineService(BigDecimal tmsTransportPlanmargineService) {
        this.tmsTransportPlanmargineService = tmsTransportPlanmargineService;
    }

    @Column(name = "tms_transportplansaleprice")
    public BigDecimal getTmsTransportPlanSalePrice() {
        return tmsTransportPlanSalePrice;
    }

    public void setTmsTransportPlanSalePrice(BigDecimal tmsTransportPlanSalePrice) {
        this.tmsTransportPlanSalePrice = tmsTransportPlanSalePrice;
    }

    @Column(name = "tms_transportplandatedepart")

    public Date getTmsTransportPlanDateDepart() {
        return tmsTransportPlanDateDepart;
    }

    public void setTmsTransportPlanDateDepart(Date tmsTransportPlanDate) {
        this.tmsTransportPlanDateDepart = tmsTransportPlanDate;
    }
    @Column(name = "tms_transportplandatevalidate")

    public Date getTmsTransportPlanDateValidate() {
        return tmsTransportPlanDateValidate;
    }

    public void setTmsTransportPlanDateValidate(Date tmsTransportPlanDateValidate) {
        this.tmsTransportPlanDateValidate = tmsTransportPlanDateValidate;
    }
}

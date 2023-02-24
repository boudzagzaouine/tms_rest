package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_transportplan")
public class TmsTransportPlan extends EmsEntity {

    private Long tmsTransportPlanId;

    private TmsOrderTransport tmsOrderTransport;
    private CmdCompany cmdCompany;
    private GmoVehicle gmoVehicle;
    private GmoDriver gmoDriver;
    private GmoVehicleCategory gmoVehicleCategory;
    private TrpTransport trpTransport;

    private PrmVille prmVilleSource;
    private PrmVille prmVilleDistination;
    private TmsTurnStatus tmsTurnStatus;
    private BigDecimal tmsTransportPlanPurchasePrice;

    private BigDecimal tmsTransportPlanSalePrice;

    private  Date tmsTransportPlanDateDepart;
    private  Date tmsTransportPlanDateValidate;

    private BigDecimal tmsTransportPlanMarginRate;
    private BigDecimal tmsTransportPlanmargineService;


    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal totalPriceVAT;

    private Set<TmsTransportPlanServiceCatalog> transportPlanServiceCatalogs = new HashSet<>();

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

    @ManyToOne()
    @JoinColumn(name = "tms_prmvillesourceid")
    public PrmVille getPrmVilleSource() {
        return prmVilleSource;
    }

    public void setPrmVilleSource(PrmVille prmVilleSource) {
        this.prmVilleSource = prmVilleSource;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_prmvilledistinationid")
    public PrmVille getPrmVilleDistination() {
        return prmVilleDistination;
    }

    public void setPrmVilleDistination(PrmVille prmVilleDistination) {
        this.prmVilleDistination = prmVilleDistination;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_cmdcompany")
    public CmdCompany getCmdCompany() {
        return cmdCompany;
    }

    public void setCmdCompany(CmdCompany cmdCompany) {
        this.cmdCompany = cmdCompany;
    }



    @ManyToOne()
    @JoinColumn(name = "tms_gmovehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }




    @OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL,CascadeType.MERGE},mappedBy = "tmsTransportPlan", orphanRemoval=true)
    public Set<TmsTransportPlanServiceCatalog> getTransportPlanServiceCatalogs() {
        return transportPlanServiceCatalogs;
    }

    public void setTransportPlanServiceCatalogs(Set<TmsTransportPlanServiceCatalog> transportPlanServiceCatalogs) {
        this.transportPlanServiceCatalogs = transportPlanServiceCatalogs;
    }


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

    @Column(name = "tms_transportplanpricettc")
    public BigDecimal getTmsTransportPlanPurchasePrice() {
        return tmsTransportPlanPurchasePrice;
    }

    public void setTmsTransportPlanPurchasePrice(BigDecimal tmsTransportPlanPriceTTC) {
        this.tmsTransportPlanPurchasePrice = tmsTransportPlanPriceTTC;
    }

    @Column(name = "tms_transportplanmarginrate")
    public BigDecimal getTmsTransportPlanMarginRate() {
        return tmsTransportPlanMarginRate;
    }

    public void setTmsTransportPlanMarginRate(BigDecimal tmsTransportPlanMarginRate) {
        this.tmsTransportPlanMarginRate = tmsTransportPlanMarginRate;
    }

    @Column(name = "tms_transportplantotalpriceht")

    public BigDecimal getTotalPriceHT() {
        return totalPriceHT;
    }

    public void setTotalPriceHT(BigDecimal totalPriceHT) {
        this.totalPriceHT = totalPriceHT;
    }
    @Column(name = "tms_transportplantotalpricettc")

    public BigDecimal getTotalPriceTTC() {
        return totalPriceTTC;
    }

    public void setTotalPriceTTC(BigDecimal totalPriceTTC) {
        this.totalPriceTTC = totalPriceTTC;
    }

    @Column(name = "tms_transportplantotalpricevat")

    public BigDecimal getTotalPriceVAT() {
        return totalPriceVAT;
    }

    public void setTotalPriceVAT(BigDecimal totalPriceVAT) {
        this.totalPriceVAT = totalPriceVAT;
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

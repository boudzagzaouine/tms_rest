package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_transportplanhistory")
public class TmsTransportPlanHistory extends EmsEntity {

    private Long tmsTransportPlanHistoryId;

    private TmsOrderTransport tmsOrderTransport;
    private GmoVehicle gmoVehicle;
    private GmoDriver gmoDriver;
    private GmoVehicleCategory gmoVehicleCategory;
    private TrpTransport trpTransport;

    private PrmVille prmVilleSource;
    private PrmVille prmVilleDistination;
    private TmsTurnStatus tmsTurnStatus;
    private BigDecimal tmsTransportPlanHistoryPurchasePrice;

    private BigDecimal tmsTransportPlanHistorySalePrice;

    private  Date tmsTransportPlanHistoryDate;

    private TmsOrderTransportRejectType tmsOrderTransportRejectType;
 private long tmsTransportPlanHistoryType ;
    private BigDecimal tmsTransportPlanHistoryMarginRate;
    private BigDecimal tmsTransportPlanHistorymargineService;
 private String tmsTransportPlanHistoryRemark;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_transportplanhistory_id", allocationSize = 1)
    @Column(name = "tms_transportplanhistoryid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTransportPlanHistoryId() {
        return tmsTransportPlanHistoryId;
    }

    public void setTmsTransportPlanHistoryId(Long tmsTransportPlanHistoryId) {
        this.tmsTransportPlanHistoryId = tmsTransportPlanHistoryId;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_ordertransportid")
    public TmsOrderTransport getTmsOrderTransport() {
        return tmsOrderTransport;
    }

    public void setTmsOrderTransport(TmsOrderTransport tmsOrderTransport) {
        this.tmsOrderTransport = tmsOrderTransport;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tms_prmvillesourceid")
    public PrmVille getPrmVilleSource() {
        return prmVilleSource;
    }

    public void setPrmVilleSource(PrmVille prmVilleSource) {
        this.prmVilleSource = prmVilleSource;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tms_prmvilledistinationid")
    public PrmVille getPrmVilleDistination() {
        return prmVilleDistination;
    }

    public void setPrmVilleDistination(PrmVille prmVilleDistination) {
        this.prmVilleDistination = prmVilleDistination;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tms_gmovehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "tms_ordertransportrejecttypeid")
    public TmsOrderTransportRejectType getTmsOrderTransportRejectType() {
        return tmsOrderTransportRejectType;
    }

    public void setTmsOrderTransportRejectType(TmsOrderTransportRejectType tmsOrderTransportRejectType) {
        this.tmsOrderTransportRejectType = tmsOrderTransportRejectType;
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

    @Column(name = "tms_transportplanhistorypricettc")
    public BigDecimal getTmsTransportPlanHistoryPurchasePrice() {
        return tmsTransportPlanHistoryPurchasePrice;
    }

    public void setTmsTransportPlanHistoryPurchasePrice(BigDecimal tmsTransportPlanHistoryPriceTTC) {
        this.tmsTransportPlanHistoryPurchasePrice = tmsTransportPlanHistoryPriceTTC;
    }

    @Column(name = "tms_transportplanhistoryremark")

    public String getTmsTransportPlanHistoryRemark() {
        return tmsTransportPlanHistoryRemark;
    }

    public void setTmsTransportPlanHistoryRemark(String tmsTransportPlanHistoryRemark) {
        this.tmsTransportPlanHistoryRemark = tmsTransportPlanHistoryRemark;
    }

    @Column(name = "tms_transportplanhistorymarginerate")

    public BigDecimal getTmsTransportPlanHistoryMarginRate() {
        return tmsTransportPlanHistoryMarginRate;
    }

    public void setTmsTransportPlanHistoryMarginRate(BigDecimal tmsTransportPlanHistoryMarginRate) {
        this.tmsTransportPlanHistoryMarginRate = tmsTransportPlanHistoryMarginRate;
    }

    @Column(name = "tms_transportplanhistorymargineservice")
    public BigDecimal getTmsTransportPlanHistorymargineService() {
        return tmsTransportPlanHistorymargineService;
    }

    public void setTmsTransportPlanHistorymargineService(BigDecimal tmsTransportPlanHistorymargineService) {
        this.tmsTransportPlanHistorymargineService = tmsTransportPlanHistorymargineService;
    }

    @Column(name = "tms_transportplanhistorytype")

    public long getTmsTransportPlanHistoryType() {
        return tmsTransportPlanHistoryType;
    }

    public void setTmsTransportPlanHistoryType(long tmsTransportPlanHistoryType) {
        this.tmsTransportPlanHistoryType = tmsTransportPlanHistoryType;
    }

    @Column(name = "tms_transportplanhistorysaleprice")
    public BigDecimal getTmsTransportPlanHistorySalePrice() {
        return tmsTransportPlanHistorySalePrice;
    }

    public void setTmsTransportPlanHistorySalePrice(BigDecimal tmsTransportPlanHistorySalePrice) {
        this.tmsTransportPlanHistorySalePrice = tmsTransportPlanHistorySalePrice;
    }

    @Column(name = "tms_transportplanhistorydate")

    public Date getTmsTransportPlanHistoryDate() {
        return tmsTransportPlanHistoryDate;
    }

    public void setTmsTransportPlanHistoryDate(Date tmsTransportPlanHistoryDate) {
        this.tmsTransportPlanHistoryDate = tmsTransportPlanHistoryDate;
    }
}

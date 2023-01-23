package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tms_ordertransport")
public class TmsOrderTransport extends EmsEntity {

    private Long tmsOrderTransportId;
    private String tmsOrderTransportCode;
    private Date tmsOrderTransportDate;
    private TmsTurnType tmsOrderTransportType;
    private TmsLoadingType  tmsOrderTransportLoadingType;
    private CmdCompany cmdCompany;

    private TmsTurnStatus tmsTurnStatus;
    private GmoVehicleCategory gmoVehicleCategory ;
    private TmsVehicleTray tmsVehicleTray;

  // private TmsOrderTransportInfo tmsOrderTransportInfoAller;
   //private TmsOrderTransportInfo tmsOrderTransportInfoRetour;


   private BigDecimal tmsOrderTransportPriceHT;

    private BigDecimal tmsOrderTransportMarginRate;


    private BigDecimal tmsOrderTransportMarginValue;




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_ordertransport_id", allocationSize = 1)
    @Column(name = "tms_ordertransportid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderTransportId() {
        return tmsOrderTransportId;
    }

    public void setTmsOrderTransportId(Long tmsOrderTransportId) {
        this.tmsOrderTransportId = tmsOrderTransportId;
    }

    @Column(name = "tms_ordertransportcode",nullable = false)
    public String getTmsOrderTransportCode() {
        return tmsOrderTransportCode;
    }

    public void setTmsOrderTransportCode(String tmsOrderTransportCode) {
        this.tmsOrderTransportCode = tmsOrderTransportCode;
    }

    @Column(name="tms_ordertransportdate")
    public Date getTmsOrderTransportDate() {
        return tmsOrderTransportDate;
    }

    public void setTmsOrderTransportDate(Date dateDelivery) {
        this.tmsOrderTransportDate = dateDelivery;
    }

    @Column(name="tms_ordertransportpriceht")
    public BigDecimal getTmsOrderTransportPriceHT() {
        return tmsOrderTransportPriceHT;
    }

    public void setTmsOrderTransportPriceHT(BigDecimal tmsOrderTransportPriceTTC) {
        this.tmsOrderTransportPriceHT = tmsOrderTransportPriceTTC;
    }
    @Column(name="tms_ordertransportmarginrate")
    public BigDecimal getTmsOrderTransportMarginRate() {
        return tmsOrderTransportMarginRate;
    }
    public void setTmsOrderTransportMarginRate(BigDecimal tmsOrderTransportMarginRate) {
        this.tmsOrderTransportMarginRate = tmsOrderTransportMarginRate;
    }
    @Column(name="tms_ordertransportmarginvalue")

    public BigDecimal getTmsOrderTransportMarginValue() {
        return tmsOrderTransportMarginValue;
    }

    public void setTmsOrderTransportMarginValue(BigDecimal tmsOrderTransportMarginValue) {
        this.tmsOrderTransportMarginValue = tmsOrderTransportMarginValue;
    }

    @ManyToOne()
 @JoinColumn(name = "tms_ordertransportTypeid")
    public TmsTurnType getTmsOrderTransportType() {
        return tmsOrderTransportType;
    }


    public void setTmsOrderTransportType(TmsTurnType tmsOrderTransportType) {
        this.tmsOrderTransportType = tmsOrderTransportType;
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
    @JoinColumn(name = "tms_vehiclecategoryid")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }
    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tms_ordertransportdeliveryinfoaller")
//    public TmsOrderTransportInfo getTmsOrderTransportInfoAller() {
//        return tmsOrderTransportInfoAller;
//    }
//
//    public void setTmsOrderTransportInfoAller(TmsOrderTransportInfo tmsOrderTransportInfoAller) {
//        this.tmsOrderTransportInfoAller = tmsOrderTransportInfoAller;
//    }




//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "tms_ordertransportdeliveryinforetour")
//    public TmsOrderTransportInfo getTmsOrderTransportInfoRetour() {
//        return tmsOrderTransportInfoRetour;
//    }
//
//    public void setTmsOrderTransportInfoRetour(TmsOrderTransportInfo tmsOrderTransportInfoRetour) {
//        this.tmsOrderTransportInfoRetour = tmsOrderTransportInfoRetour;
//    }




    @ManyToOne()
    @JoinColumn(name = "tms_turnstatusid")
    public TmsTurnStatus getTmsTurnStatus() {
        return tmsTurnStatus;
    }

    public void setTmsTurnStatus(TmsTurnStatus tmsTurnStatus) {
        this.tmsTurnStatus = tmsTurnStatus;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_loadingtypeid")
    public TmsLoadingType getTmsOrderTransportLoadingType() {
        return tmsOrderTransportLoadingType;
    }

    public void setTmsOrderTransportLoadingType(TmsLoadingType tmsOrderTransportLoadingType) {
        this.tmsOrderTransportLoadingType = tmsOrderTransportLoadingType;
    }

    @ManyToOne()
    @JoinColumn(name = "cmd_companyid")
    public CmdCompany getCmdCompany() {
        return cmdCompany;
    }

    public void setCmdCompany(CmdCompany cmdCompany) {
        this.cmdCompany = cmdCompany;
    }
}

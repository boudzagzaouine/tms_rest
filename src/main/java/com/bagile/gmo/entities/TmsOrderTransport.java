package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="tms_ordertransport")
public class TmsOrderTransport extends EmsEntity {

    private Long tmsOrderTransportId;
    private String tmsOrderTransportCode;

    private Date tmsOrderTransportDate;



    private TmsTurnType tmsOrderTransportType;
    private String  tmsOrderTransportLoadingType;
    private CmdAccount cmdAccount;

    private TmsTurnStatus tmsTurnStatus;
    private GmoVehicleCategory gmoVehicleCategory ;

  // private TmsOrderTransportInfo tmsOrderTransportInfoAller;
   //private TmsOrderTransportInfo tmsOrderTransportInfoRetour;


   private BigDecimal tmsOrderTransportPriceTTC;








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

    @Column(name="tms_ordertransportpricettc")
    public BigDecimal getTmsOrderTransportPriceTTC() {
        return tmsOrderTransportPriceTTC;
    }

    public void setTmsOrderTransportPriceTTC(BigDecimal tmsOrderTransportPriceTTC) {
        this.tmsOrderTransportPriceTTC = tmsOrderTransportPriceTTC;
    }

    @ManyToOne()
 @JoinColumn(name = "tms_ordertransportType")
    public TmsTurnType getTmsOrderTransportType() {
        return tmsOrderTransportType;
    }


    public void setTmsOrderTransportType(TmsTurnType tmsOrderTransportType) {
        this.tmsOrderTransportType = tmsOrderTransportType;
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

    @Column(name="tms_ordertransportloadingtype")
    public String getTmsOrderTransportLoadingType() {
        return tmsOrderTransportLoadingType;
    }

    public void setTmsOrderTransportLoadingType(String tmsOrderTransportLoadingType) {
        this.tmsOrderTransportLoadingType = tmsOrderTransportLoadingType;
    }



    @ManyToOne()
    @JoinColumn(name = "cmd_accountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }









}

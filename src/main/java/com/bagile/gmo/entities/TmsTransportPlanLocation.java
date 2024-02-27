package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tms_transportplanlocation")
public class TmsTransportPlanLocation extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTransportPlanLocationId;
    private double tmsTransportPlanLocationlatitude ;
    private double tmsTransportPlanLocationlongitude ;
    private Long tmsTransportPlanLocationtransportPlanId ;
    private Long tmsTransportPlanLocationOrderTransportId ;

    private Long tmsTransportPlanLocationOrderTransportInfoId ;

    private Long tmsTransportPlanLocationOrderTransportInfoLineID ;

    private Long tmsTransportPlanLocationvehicleId ;
    private Long tmsTransportPlanLocationdriverId ;



    private TmsTransportPlan tmsTransportPlanLocationtransportPlan ;
    private TmsOrderTransport tmsTransportPlanLocationOrderTransport ;

    private TmsOrderTransportInfo tmsTransportPlanLocationOrderTransportInfo;

    private TmsOrderTransportInfoLine tmsTransportPlanLocationOrderTransportInfoLine ;

    private GmoVehicle tmsTransportPlanLocationVehicle;
    private GmoDriver tmsTransportPlanLocationDriver;

    private Date tmsTransportPlanLocationdate;

    private String tmsTransportPlanLocationType;

    private Long accountId;
    private String accountName ;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_transportplanlocation_id", allocationSize = 1)
    @Column(name = "tms_transportplanlocationid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTransportPlanLocationId() {
        return tmsTransportPlanLocationId;
    }

    public void setTmsTransportPlanLocationId(Long tmsTransportPlanLocationId) {
        this.tmsTransportPlanLocationId = tmsTransportPlanLocationId;
    }
    @Column(name = "tms_transportplanlocationlatitude", nullable = false, length = 90)

    public double getTmsTransportPlanLocationlatitude() {
        return tmsTransportPlanLocationlatitude;
    }

    public void setTmsTransportPlanLocationlatitude(double tmsTransportPlanLocationlatitude) {
        this.tmsTransportPlanLocationlatitude = tmsTransportPlanLocationlatitude;
    }


    @Column(name = "tms_transportplanlocationtype")
    public String getTmsTransportPlanLocationType() {
        return tmsTransportPlanLocationType;
    }

    public void setTmsTransportPlanLocationType(String tmsTransportPlanLocationType) {
        this.tmsTransportPlanLocationType = tmsTransportPlanLocationType;
    }

    @Column(name = "tms_transportplanlocationlongtitude", nullable = false, length = 90)

    public double getTmsTransportPlanLocationlongitude() {
        return tmsTransportPlanLocationlongitude;
    }

    public void setTmsTransportPlanLocationlongitude(double tmsTransportPlanLocationlongitude) {
        this.tmsTransportPlanLocationlongitude = tmsTransportPlanLocationlongitude;
    }


    //@ManyToOne()
    @Column(name = "tms_transportplanlocationtransportplanid")
    public Long getTmsTransportPlanLocationtransportPlanId() {
        return tmsTransportPlanLocationtransportPlanId;
    }

    public void setTmsTransportPlanLocationtransportPlanId(Long tmsTransportPlanLocationtransportPlanId) {
        this.tmsTransportPlanLocationtransportPlanId = tmsTransportPlanLocationtransportPlanId;
    }


   // @ManyToOne()
    @Column(name = "tms_transportplanlocationordertransportid")
    public Long getTmsTransportPlanLocationOrderTransportId() {
        return tmsTransportPlanLocationOrderTransportId;
    }

    public void setTmsTransportPlanLocationOrderTransportId(Long tmsTransportPlanLocationOrderTransportId) {
        this.tmsTransportPlanLocationOrderTransportId = tmsTransportPlanLocationOrderTransportId;
    }

    //@ManyToOne()
    @Column(name = "tms_transportplanlocationordertransportinfoid")
    public Long getTmsTransportPlanLocationOrderTransportInfoId() {
        return tmsTransportPlanLocationOrderTransportInfoId;
    }

    public void setTmsTransportPlanLocationOrderTransportInfoId(Long tmsTransportPlanLocationOrderTransportInfoId) {
        this.tmsTransportPlanLocationOrderTransportInfoId = tmsTransportPlanLocationOrderTransportInfoId;
    }

    //@ManyToOne()
    @Column(name = "tms_transportplanlocationordertransportinfolineid")
    public Long getTmsTransportPlanLocationOrderTransportInfoLineID() {
        return tmsTransportPlanLocationOrderTransportInfoLineID;
    }

    public void setTmsTransportPlanLocationOrderTransportInfoLineID(Long tmsTransportPlanLocationOrderTransportInfoLineID) {
        this.tmsTransportPlanLocationOrderTransportInfoLineID = tmsTransportPlanLocationOrderTransportInfoLineID;
    }

    //@ManyToOne()
    @Column(name = "tms_transportplanlocationvehicleid")
    public Long getTmsTransportPlanLocationvehicleId() {
        return tmsTransportPlanLocationvehicleId;
    }

    public void setTmsTransportPlanLocationvehicleId(Long tmsTransportPlanLocationvehicleId) {
        this.tmsTransportPlanLocationvehicleId = tmsTransportPlanLocationvehicleId;
    }





   // @ManyToOne()
    @Column(name = "tms_transportplanlocationdriverid")
    public Long getTmsTransportPlanLocationdriverId() {
        return tmsTransportPlanLocationdriverId;
    }

    public void setTmsTransportPlanLocationdriverId(Long tmsTransportPlanLocationdriverId) {
        this.tmsTransportPlanLocationdriverId = tmsTransportPlanLocationdriverId;
    }

    @Column(name = "tms_transportplanlocationdate", nullable = false, length = 90)

    public Date getTmsTransportPlanLocationdate() {
        return tmsTransportPlanLocationdate;
    }

    public void setTmsTransportPlanLocationdate(Date tmsTransportPlanLocationdate) {
        this.tmsTransportPlanLocationdate = tmsTransportPlanLocationdate;
    }


    @Column(name = "tms_transportplanlocationaccountid")

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Column(name = "tms_transportplanlocationaccountname")

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationtransportplan")
    public TmsTransportPlan getTmsTransportPlanLocationtransportPlan() {
        return tmsTransportPlanLocationtransportPlan;
    }

    public void setTmsTransportPlanLocationtransportPlan(TmsTransportPlan tmsTransportPlanLocationtransportPlan) {
        this.tmsTransportPlanLocationtransportPlan = tmsTransportPlanLocationtransportPlan;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationordertransport")
    public TmsOrderTransport getTmsTransportPlanLocationOrderTransport() {
        return tmsTransportPlanLocationOrderTransport;
    }

    public void setTmsTransportPlanLocationOrderTransport(TmsOrderTransport tmsTransportPlanLocationOrderTransport) {
        this.tmsTransportPlanLocationOrderTransport = tmsTransportPlanLocationOrderTransport;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationordertransportinfo")
    public TmsOrderTransportInfo getTmsTransportPlanLocationOrderTransportInfo() {
        return tmsTransportPlanLocationOrderTransportInfo;
    }

    public void setTmsTransportPlanLocationOrderTransportInfo(TmsOrderTransportInfo tmsTransportPlanLocationOrderTransportInfo) {
        this.tmsTransportPlanLocationOrderTransportInfo = tmsTransportPlanLocationOrderTransportInfo;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationordertransportinfoline")
    public TmsOrderTransportInfoLine getTmsTransportPlanLocationOrderTransportInfoLine() {
        return tmsTransportPlanLocationOrderTransportInfoLine;
    }

    public void setTmsTransportPlanLocationOrderTransportInfoLine(TmsOrderTransportInfoLine tmsTransportPlanLocationOrderTransportInfoLine) {
        this.tmsTransportPlanLocationOrderTransportInfoLine = tmsTransportPlanLocationOrderTransportInfoLine;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationvehicle")
    public GmoVehicle getTmsTransportPlanLocationVehicle() {
        return tmsTransportPlanLocationVehicle;
    }

    public void setTmsTransportPlanLocationVehicle(GmoVehicle tmsTransportPlanLocationvehicle) {
        this.tmsTransportPlanLocationVehicle = tmsTransportPlanLocationvehicle;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationdriver")
    public GmoDriver getTmsTransportPlanLocationDriver() {
        return tmsTransportPlanLocationDriver;
    }

    public void setTmsTransportPlanLocationDriver(GmoDriver tmsTransportPlanLocationdriver) {
        this.tmsTransportPlanLocationDriver = tmsTransportPlanLocationdriver;
    }
}



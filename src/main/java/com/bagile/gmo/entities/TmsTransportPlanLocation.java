package com.bagile.gmo.entities;

import com.bagile.gmo.dto.TransportPlan;
import com.bagile.gmo.entities.EmsEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_transportplanlocation")
public class TmsTransportPlanLocation extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTransportPlanLocationId;
    private double tmsTransportPlanLocationlatitude ;
    private double tmsTransportPlanLocationlongitude ;
    private TmsTransportPlan tmsTransportPlanLocationtransportPlanId ;
    private TmsOrderTransport tmsTransportPlanLocationOrderTransportId ;

    private TmsOrderTransportInfo tmsTransportPlanLocationOrderTransportInfoId ;

    private TmsOrderTransportInfoLine tmsTransportPlanLocationOrderTransportInfoLineID ;

    private GmoVehicle tmsTransportPlanLocationvehicleId ;
    private GmoDriver tmsTransportPlanLocationdriverId ;
    private Date tmsTransportPlanLocationdate;

    private String tmsTransportPlanLocationType;

    private long accountId;
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


    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationtransportplanid")
    public TmsTransportPlan getTmsTransportPlanLocationtransportPlanId() {
        return tmsTransportPlanLocationtransportPlanId;
    }

    public void setTmsTransportPlanLocationtransportPlanId(TmsTransportPlan tmsTransportPlanLocationtransportPlanId) {
        this.tmsTransportPlanLocationtransportPlanId = tmsTransportPlanLocationtransportPlanId;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationordertransportid")
    public TmsOrderTransport getTmsTransportPlanLocationOrderTransportId() {
        return tmsTransportPlanLocationOrderTransportId;
    }

    public void setTmsTransportPlanLocationOrderTransportId(TmsOrderTransport tmsTransportPlanLocationOrderTransportId) {
        this.tmsTransportPlanLocationOrderTransportId = tmsTransportPlanLocationOrderTransportId;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationordertransportinfoid")
    public TmsOrderTransportInfo getTmsTransportPlanLocationOrderTransportInfoId() {
        return tmsTransportPlanLocationOrderTransportInfoId;
    }

    public void setTmsTransportPlanLocationOrderTransportInfoId(TmsOrderTransportInfo tmsTransportPlanLocationOrderTransportInfoId) {
        this.tmsTransportPlanLocationOrderTransportInfoId = tmsTransportPlanLocationOrderTransportInfoId;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationordertransportinfolineid")
    public TmsOrderTransportInfoLine getTmsTransportPlanLocationOrderTransportInfoLineID() {
        return tmsTransportPlanLocationOrderTransportInfoLineID;
    }

    public void setTmsTransportPlanLocationOrderTransportInfoLineID(TmsOrderTransportInfoLine tmsTransportPlanLocationOrderTransportInfoLineID) {
        this.tmsTransportPlanLocationOrderTransportInfoLineID = tmsTransportPlanLocationOrderTransportInfoLineID;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationvehicleid")
    public GmoVehicle getTmsTransportPlanLocationvehicleId() {
        return tmsTransportPlanLocationvehicleId;
    }

    public void setTmsTransportPlanLocationvehicleId(GmoVehicle tmsTransportPlanLocationvehicleId) {
        this.tmsTransportPlanLocationvehicleId = tmsTransportPlanLocationvehicleId;
    }





    @ManyToOne()
    @JoinColumn(name = "tms_transportplanlocationdriverid")
    public GmoDriver getTmsTransportPlanLocationdriverId() {
        return tmsTransportPlanLocationdriverId;
    }

    public void setTmsTransportPlanLocationdriverId(GmoDriver tmsTransportPlanLocationdriverId) {
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

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Column(name = "tms_transportplanlocationaccountname")

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}

package com.bagile.gmo.entities;

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
    private long tmsTransportPlanLocationtransportPlanId ;
    private long tmsTransportPlanLocationvehicleId ;
    private long tmsTransportPlanLocationdriverId ;
    private Date tmsTransportPlanLocationdate;


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

    @Column(name = "tms_transportplanlocationlongtitude", nullable = false, length = 90)

    public double getTmsTransportPlanLocationlongitude() {
        return tmsTransportPlanLocationlongitude;
    }

    public void setTmsTransportPlanLocationlongitude(double tmsTransportPlanLocationlongitude) {
        this.tmsTransportPlanLocationlongitude = tmsTransportPlanLocationlongitude;
    }
    @Column(name = "tms_transportplanlocationtransportplanid", nullable = false, length = 90)

    public long getTmsTransportPlanLocationtransportPlanId() {
        return tmsTransportPlanLocationtransportPlanId;
    }

    public void setTmsTransportPlanLocationtransportPlanId(long tmsTransportPlanLocationtransportPlanId) {
        this.tmsTransportPlanLocationtransportPlanId = tmsTransportPlanLocationtransportPlanId;
    }
    @Column(name = "tms_transportplanlocationvehicleid", nullable = false, length = 90)

    public long getTmsTransportPlanLocationvehicleId() {
        return tmsTransportPlanLocationvehicleId;
    }

    public void setTmsTransportPlanLocationvehicleId(long tmsTransportPlanLocationvehicleId) {
        this.tmsTransportPlanLocationvehicleId = tmsTransportPlanLocationvehicleId;
    }
    @Column(name = "tms_transportplanlocationdriverid", nullable = false, length = 90)

    public long getTmsTransportPlanLocationdriverId() {
        return tmsTransportPlanLocationdriverId;
    }

    public void setTmsTransportPlanLocationdriverId(long tmsTransportPlanLocationdriverId) {
        this.tmsTransportPlanLocationdriverId = tmsTransportPlanLocationdriverId;
    }
    @Column(name = "tms_transportplanlocationdate", nullable = false, length = 90)

    public Date getTmsTransportPlanLocationdate() {
        return tmsTransportPlanLocationdate;
    }

    public void setTmsTransportPlanLocationdate(Date tmsTransportPlanLocationdate) {
        this.tmsTransportPlanLocationdate = tmsTransportPlanLocationdate;
    }








}

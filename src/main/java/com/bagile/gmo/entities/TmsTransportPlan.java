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
    private GmoVehicle gmoVehicle;
    private GmoDriver gmoDriver;
    private GmoVehicleCategory gmoVehicleCategory;
    private TrpTransport trpTransport;

    private String prmVilleSource;
    private String prmVilleDistination;
    private TmsTurnStatus tmsTurnStatus;
    private BigDecimal tmsTransportPlanPriceTTC ;

    private  Date tmsTransportPlanDate;



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

    @Column(name = "tms_transportplanvillesource")
    public String getPrmVilleSource() {
        return prmVilleSource;
    }


    public void setPrmVilleSource(String prmVilleSource) {
        this.prmVilleSource = prmVilleSource;
    }
    @Column(name = "tms_transportplanvilledistination")

    public String getPrmVilleDistination() {
        return prmVilleDistination;
    }

    public void setPrmVilleDistination(String prmVilleDistination) {
        this.prmVilleDistination = prmVilleDistination;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_gmovehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle gmoVehicle) {
        this.gmoVehicle = gmoVehicle;
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
    public BigDecimal getTmsTransportPlanPriceTTC() {
        return tmsTransportPlanPriceTTC;
    }

    public void setTmsTransportPlanPriceTTC(BigDecimal tmsTransportPlanPriceTTC) {
        this.tmsTransportPlanPriceTTC = tmsTransportPlanPriceTTC;
    }

    @Column(name = "tms_transportplandate")

    public Date getTmsTransportPlanDate() {
        return tmsTransportPlanDate;
    }

    public void setTmsTransportPlanDate(Date tmsTransportPlanDate) {
        this.tmsTransportPlanDate = tmsTransportPlanDate;
    }
}

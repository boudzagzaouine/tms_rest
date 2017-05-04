package com.sinno.ems.entities;

import com.sinno.ems.dto.Delivery;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 *
 */
@Entity
@Table(name="tms_road")
public class TmsRoad implements Serializable {

    private long tmsRoadId;
    @Size(max = 30)
    @NotNull
    private String tmsRoadCode;
    @NotNull
    @Size(max = 30)
    private BigDecimal tmsRoadDuration;
    @NotNull
    @Size(max = 30)
    private BigDecimal tmsRoadCost;
    @NotNull
    @Size(max = 30)
    private BigDecimal tmsRoadDistance;
    @Size(max = 30)
    private Set<TmsIncident>tmsRoadIncident;
    @NotNull
    private TmsDriver tmsRoadPrincialDriver;
    @NotNull
    private TmsDriver tmsRoadSuppleantDriver;
    @NotNull
    private Set<CmdDelivery> cmdDeliveries;
    @NotNull
    private TmsVehicle tmsRoadVehicle;

    public TmsRoad() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name =  "seq")
    @Column(name = "tms_roadid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsRoadId() {
        return tmsRoadId;
    }

    public void setTmsRoadId(long tmsRoadId) {
        this.tmsRoadId = tmsRoadId;
    }
    @Column(name = "tms_roadcode", nullable = false, length = 30)

    public String getTmsRoadCode() {
        return tmsRoadCode;
    }

    public void setTmsRoadCode(String tmsRoadCode) {
        this.tmsRoadCode = tmsRoadCode;
    }
    @Column(name = "tms_roadduration", nullable = false, length = 30)
    public BigDecimal getTmsRoadDuration() {
        return tmsRoadDuration;
    }

    public void setTmsRoadDuration(BigDecimal tmsRoadDuration) {
        this.tmsRoadDuration = tmsRoadDuration;
    }
    @Column(name = "tms_roadcost", nullable = false, length = 30)
    public BigDecimal getTmsRoadCost() {
        return tmsRoadCost;
    }

    public void setTmsRoadCost(BigDecimal tmsRoadCost) {
        this.tmsRoadCost = tmsRoadCost;
    }
    @Column(name = "tms_roaddistance", nullable = false, length = 30)
    public BigDecimal getTmsRoadDistance() {
        return tmsRoadDistance;
    }

    public void setTmsRoadDistance(BigDecimal tmsRoadDistance) {
        this.tmsRoadDistance = tmsRoadDistance;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsIncidentRoad")
    public Set<TmsIncident> getTmsRoadIncident() {
        return tmsRoadIncident;
    }

    public void setTmsRoadIncident(Set<TmsIncident> tmsRoadIncident) {
        this.tmsRoadIncident = tmsRoadIncident;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roaddriverid", nullable = false)
    public TmsDriver getTmsRoadPrincialDriver() {
        return tmsRoadPrincialDriver;
    }

    public void setTmsRoadPrincialDriver(TmsDriver tmsRoadPrincialDriver) {
        this.tmsRoadPrincialDriver = tmsRoadPrincialDriver;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadsecondarydriverid", nullable = false)
    public TmsDriver getTmsRoadSuppleantDriver() {
        return tmsRoadSuppleantDriver;
    }

    public void setTmsRoadSuppleantDriver(TmsDriver tmsRoadSuppleantDriver) {
        this.tmsRoadSuppleantDriver = tmsRoadSuppleantDriver;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tmsRoad")
    public Set<CmdDelivery> getCmdDeliveries() {
        return cmdDeliveries;
    }

    public void setCmdDeliveries(Set<CmdDelivery> cmdDeliveries) {
        this.cmdDeliveries = cmdDeliveries;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_roadvehicleid", nullable = false)

    public TmsVehicle getTmsRoadVehicle() {
        return tmsRoadVehicle;
    }

    public void setTmsRoadVehicle(TmsVehicle tmsRoadVehicle) {
        this.tmsRoadVehicle = tmsRoadVehicle;
    }


}

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
public class TmsRoad implements Serializable {

    private long prmRoadId;
    @Size(max = 30)
    @NotNull
    private String prmRoadCode;
    @NotNull
    @Size(max = 30)
    private BigDecimal prmRoadDuration;
    @NotNull
    @Size(max = 30)
    private BigDecimal prmRoadCost;
    @NotNull
    @Size(max = 30)
    private BigDecimal prmRoadDistance;
    @Size(max = 30)
    private Set<TmsIncident>prmRoadIncident;
    @NotNull
    private TmsDriver prmRoadPrincialDriver;
    @NotNull
    private TmsDriver prmRoadSuppleantDriver;
    @NotNull
    private Set<Delivery> prmRoadDelivery;
    @NotNull
    private TmsVehicle prmRoadVehicle;

    public TmsRoad() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name =  "seq")
    @Column(name = "prm_roadid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmRoadId() {
        return prmRoadId;
    }

    public void setPrmRoadId(long prmRoadId) {
        this.prmRoadId = prmRoadId;
    }
    @Column(name = "prm_roadcode", nullable = false, length = 30)

    public String getPrmRoadCode() {
        return prmRoadCode;
    }

    public void setPrmRoadCode(String prmRoadCode) {
        this.prmRoadCode = prmRoadCode;
    }
    @Column(name = "prm_roadduration", nullable = false, length = 30)
    public BigDecimal getPrmRoadDuration() {
        return prmRoadDuration;
    }

    public void setPrmRoadDuration(BigDecimal prmRoadDuration) {
        this.prmRoadDuration = prmRoadDuration;
    }
    @Column(name = "prm_roadcost", nullable = false, length = 30)
    public BigDecimal getPrmRoadCost() {
        return prmRoadCost;
    }

    public void setPrmRoadCost(BigDecimal prmRoadCost) {
        this.prmRoadCost = prmRoadCost;
    }
    @Column(name = "prm_roaddistance", nullable = false, length = 30)
    public BigDecimal getPrmRoadDistance() {
        return prmRoadDistance;
    }

    public void setPrmRoadDistance(BigDecimal prmRoadDistance) {
        this.prmRoadDistance = prmRoadDistance;
    }
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "prmIncidentRoad")
    public Set<TmsIncident> getPrmRoadIncident() {
        return prmRoadIncident;
    }

    public void setPrmRoadIncident(Set<TmsIncident> prmRoadIncident) {
        this.prmRoadIncident = prmRoadIncident;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_roaddriverid", nullable = false)
    public TmsDriver getPrmRoadPrincialDriver() {
        return prmRoadPrincialDriver;
    }

    public void setPrmRoadPrincialDriver(TmsDriver prmRoadPrincialDriver) {
        this.prmRoadPrincialDriver = prmRoadPrincialDriver;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_roaddriverid", nullable = false)
    public TmsDriver getPrmRoadSuppleantDriver() {
        return prmRoadSuppleantDriver;
    }

    public void setPrmRoadSuppleantDriver(TmsDriver prmRoadSuppleantDriver) {
        this.prmRoadSuppleantDriver = prmRoadSuppleantDriver;
    }
    //TODO@OneToMany(fetch = FetchType.LAZY,mappedBy = "")
    public Set<Delivery> getPrmRoadDelivery() {
        return prmRoadDelivery;
    }

    public void setPrmRoadDelivery(Set<Delivery> prmRoadDelivery) {
        this.prmRoadDelivery = prmRoadDelivery;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_roadvehicleid", nullable = false)

    public TmsVehicle getPrmRoadVehicle() {
        return prmRoadVehicle;
    }

    public void setPrmRoadVehicle(TmsVehicle prmRoadVehicle) {
        this.prmRoadVehicle = prmRoadVehicle;
    }


}

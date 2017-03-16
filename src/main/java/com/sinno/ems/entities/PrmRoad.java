package com.sinno.ems.entities;

import com.sinno.ems.dto.Delivery;
import com.sinno.ems.dto.Driver;
import com.sinno.ems.dto.Incident;
import com.sinno.ems.dto.Vehicule;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by bouzi on 3/15/2017.
 * private long id;
 private String code;
 private BigDecimal duration;
 private BigDecimal cost;
 private BigDecimal distance;
 private Set<Incident> incidents;
 private Driver PrincipalDriver;
 private Driver suppleantDriver;
 private Set<Delivery> deliveries;
 private Vehicule vehicule;
 */
public class PrmRoad implements Serializable {

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
    private Set<Incident>prmRoadIncident;
    @NotNull
    private Driver prmRoadPrincialDriver;
    @NotNull
    private Driver prmRoadSuppleantDriver;
    @NotNull
    private Set<Delivery> prmRoadDeliveries;
    @NotNull
    private Vehicule prmRoadVehicle;

    public PrmRoad() {

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_roadincidentid", nullable = false)
    public Set<Incident> getPrmRoadIncident() {
        return prmRoadIncident;
    }

    public void setPrmRoadIncident(Set<Incident> prmRoadIncident) {
        this.prmRoadIncident = prmRoadIncident;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_roaddriverid", nullable = false)
    public Driver getPrmRoadPrincialDriver() {
        return prmRoadPrincialDriver;
    }

    public void setPrmRoadPrincialDriver(Driver prmRoadPrincialDriver) {
        this.prmRoadPrincialDriver = prmRoadPrincialDriver;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_roaddriverid", nullable = false)
    public Driver getPrmRoadSuppleantDriver() {
        return prmRoadSuppleantDriver;
    }

    public void setPrmRoadSuppleantDriver(Driver prmRoadSuppleantDriver) {
        this.prmRoadSuppleantDriver = prmRoadSuppleantDriver;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_roaddeliveryid", nullable = false)
    public Set<Delivery> getPrmRoadDeliveries() {
        return prmRoadDeliveries;
    }

    public void setPrmRoadDeliveries(Set<Delivery> prmRoadDeliveries) {
        this.prmRoadDeliveries = prmRoadDeliveries;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_roadvehicleid", nullable = false)
    public Vehicule getPrmRoadVehicle() {
        return prmRoadVehicle;
    }

    public void setPrmRoadVehicle(Vehicule prmRoadVehicle) {
        this.prmRoadVehicle = prmRoadVehicle;
    }
}

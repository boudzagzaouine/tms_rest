package com.sinno.ems.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by yasser on 22/09/2016.
 */
public class Road implements Serializable {
    private long id;
    private String code;
    private BigDecimal duration;
    private BigDecimal cost;
    private BigDecimal distance;
    private Set<Incident> incidents;
    private Driver PrincipalDriver;
    private Driver suppleantDriver;
    private Set<Delivery> deliveries;
    private Vehicule vehicule;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Set<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Set<Incident> incidents) {
        this.incidents = incidents;
    }

    public Driver getPrincipalDriver() {
        return PrincipalDriver;
    }

    public void setPrincipalDriver(Driver principalDriver) {
        PrincipalDriver = principalDriver;
    }

    public Driver getSuppleantDriver() {
        return suppleantDriver;
    }

    public void setSuppleantDriver(Driver suppleantDriver) {
        this.suppleantDriver = suppleantDriver;
    }

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Road obj = (Road) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }
}

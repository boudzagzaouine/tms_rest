package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by yasser on 22/09/2016.
 */
public class Badge implements Serializable {
    private long id;
    private String code;
    private String libelle;
    private String description;
    private Set<Vehicule> vehicules;
    private Set<DriverBadge> driverBadges;

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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public Set<DriverBadge> getDriverBadges() {
        return driverBadges;
    }

    public void setDriverBadges(Set<DriverBadge> driverBadges) {
        this.driverBadges = driverBadges;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Badge obj = (Badge) object;
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


package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by yasser on 22/09/2016.
 */
public class MaintenancePlan implements Serializable {
    private long id;
    private String code;
    private String description;
    private Set<Acte> actes;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Acte> getActes() {
        return actes;
    }

    public void setActes(Set<Acte> actes) {
        this.actes = actes;
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
            MaintenancePlan obj = (MaintenancePlan) object;
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

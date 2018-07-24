package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by yasser on 22/09/2016.
 */
public class VehiculeStatus implements Serializable {
    private long id;
    private String codeStatusVehicule;
    private String activity; //roulant, disponible, en maintenance, Indisponible
    private String description;
    private Set<Vehicule> vehicules;

    public Set<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodeStatusVehicule() {
        return codeStatusVehicule;
    }

    public void setCodeStatusVehicule(String codeStatusVehicule) {
        this.codeStatusVehicule = codeStatusVehicule;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            VehiculeStatus obj = (VehiculeStatus) object;
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

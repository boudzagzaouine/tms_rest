package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by yasser on 22/09/2016.
 */
public class VehiculeStatus implements Serializable {
    private long id;
    private String codeStatusVehicule;
    private String activity; //roulant, disponible, en maintenance, Indisponible
    private String descritpion;
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

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
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

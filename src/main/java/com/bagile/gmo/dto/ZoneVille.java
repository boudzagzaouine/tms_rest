package com.bagile.gmo.dto;

import com.bagile.gmo.entities.GmoZone;
import com.bagile.gmo.entities.PrmVille;

import java.io.Serializable;

public class ZoneVille extends EmsDto implements Serializable {

    private long id;
    private Zone zone;
    private Ville ville;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}

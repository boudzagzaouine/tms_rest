package com.sinno.ems.dto;

import java.io.Serializable;

/**
 * Created by adadi on 6/21/2016.
 */
public class ZoneWarehouse implements Serializable {

    private long id;
    private Zone zone;
    private Warehouse warehouse;

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

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}

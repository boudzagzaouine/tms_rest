package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Zone implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 815364711086959941L;

    private long id;
    private String code;
    private Date updateDate;
    private Date creationDate;
    private String description;
    private Set<Location> locations;
    private Set<Aisle> aisles;
    private Set<ZoneWarehouse> zoneWarehouses;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<ZoneWarehouse> getZoneWarehouses() {
        return zoneWarehouses;
    }

    public void setZoneWarehouses(Set<ZoneWarehouse> zoneWarehouses) {
        this.zoneWarehouses = zoneWarehouses;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the locations
     */
    public Set<Location> getLocations() {
        return locations;
    }

    /**
     * @param locations the locations to set
     */
    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    /**
     * @return the aisles
     */
    public Set<Aisle> getAisles() {
        return aisles;
    }

    /**
     * @param aisles the aisles to set
     */
    public void setAisles(Set<Aisle> aisles) {
        this.aisles = aisles;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Zone obj = (Zone) object;
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
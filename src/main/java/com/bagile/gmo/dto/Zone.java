package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Objects;

public class Zone extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5610360676318237078L;
    private long id;
    private String code;
    private String description;
  private Owner owner;
    public Zone() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return id == zone.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

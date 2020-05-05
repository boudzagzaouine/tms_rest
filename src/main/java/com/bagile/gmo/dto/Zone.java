package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Objects;

public class Zone extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5610360676318237078L;
    private long id;
    private String name;

    public Zone() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

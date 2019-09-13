package com.bagile.tms.dto;

import java.io.Serializable;

public class Zone implements Serializable {

    private int id;
    private String name;

    public Zone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

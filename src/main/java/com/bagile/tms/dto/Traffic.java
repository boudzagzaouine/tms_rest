package com.bagile.tms.dto;

import java.util.Date;

public class Traffic {

    private int id;
    private boolean active;
    private Date dsate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDsate() {
        return dsate;
    }

    public void setDsate(Date dsate) {
        this.dsate = dsate;
    }
}

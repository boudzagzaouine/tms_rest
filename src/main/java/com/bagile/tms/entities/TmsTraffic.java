package com.bagile.tms.entities;

import java.util.Date;

public class TmsTraffic {
    private int idTraffic;
    private boolean active;
    private Date date;

    public int getIdTraffic() {
        return idTraffic;
    }

    public void setIdTraffic(int idTraffic) {
        this.idTraffic = idTraffic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

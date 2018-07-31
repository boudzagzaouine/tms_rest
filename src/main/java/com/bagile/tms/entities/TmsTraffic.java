package com.bagile.tms.entities;

import java.util.Date;

public class TmsTraffic {
    private int tmsTrafficId;
    private boolean tmsTrafficActive;
    private Date tmsTrafficDate;

    public int getTmsTrafficId() {
        return tmsTrafficId;
    }

    public void setTmsTrafficId(int tmsTrafficId) {
        this.tmsTrafficId = tmsTrafficId;
    }

    public boolean isTmsTrafficActive() {
        return tmsTrafficActive;
    }

    public void setTmsTrafficActive(boolean tmsTrafficActive) {
        this.tmsTrafficActive = tmsTrafficActive;
    }

    public Date getTmsTrafficDate() {
        return tmsTrafficDate;
    }

    public void setTmsTrafficDate(Date tmsTrafficDate) {
        this.tmsTrafficDate = tmsTrafficDate;
    }
}

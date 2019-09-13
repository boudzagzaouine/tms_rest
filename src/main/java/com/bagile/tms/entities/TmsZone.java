package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_zone")
public class TmsZone   {

    @Id
    @GeneratedValue
    @Column(name = "tms_zoneid")
    private int tmsZoneid;
    @Column(name = "tms_zonename")
    private String tmsZonename;

    public TmsZone() {
    }

    public int getTmsZoneid() {
        return tmsZoneid;
    }

    public void setTmsZoneid(int tmsZoneid) {
        this.tmsZoneid = tmsZoneid;
    }

    public String getTmsZonename() {
        return tmsZonename;
    }

    public void setTmsZonename(String tmsZonename) {
        this.tmsZonename = tmsZonename;
    }
}

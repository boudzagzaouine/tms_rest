package com.bagile.tms.entities;

import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name="tms_maintenancestate")
public class TmsMaintenanceState  extends EmsEntity {

    @Id
    @GeneratedValue
    @Column(name = "tms_maintenancestateid")
    private int tmsMaintenanceStateid;
    @Column(name = "tms_maintenancestatecode")
    private String tmsMaintenanceStatecode;
    @Column(name = "tms_maintenancestatedescriptif")
    private String tmsMaintenanceStatedescriptif;
    @Column(name = "tms_maintenancestatecreationDate")
    private Date tmsMaintenanceStatecreationDate;


    public TmsMaintenanceState() {
    }

    public int getTmsMaintenanceStateid() {
        return tmsMaintenanceStateid;
    }

    public void setTmsMaintenanceStateid(int tmsMaintenanceStateid) {
        tmsMaintenanceStateid = tmsMaintenanceStateid;
    }

    public String getTmsMaintenanceStatecode() {
        return tmsMaintenanceStatecode;
    }

    public void setTmsMaintenanceStatecode(String tmsMaintenanceStatecode) {
        tmsMaintenanceStatecode = tmsMaintenanceStatecode;
    }

    public String getTmsMaintenanceStatedescriptif() {
        return tmsMaintenanceStatedescriptif;
    }

    public void setTmsMaintenanceStatedescriptif(String tmsMaintenanceStatedescriptif) {
        tmsMaintenanceStatedescriptif = tmsMaintenanceStatedescriptif;
    }

    public Date getTmsMaintenanceStatecreationDate() {
        return tmsMaintenanceStatecreationDate;
    }

    public void setTmsMaintenanceStatecreationDate(Date tmsMaintenanceStatecreationDate) {
        tmsMaintenanceStatecreationDate = tmsMaintenanceStatecreationDate;
    }
}

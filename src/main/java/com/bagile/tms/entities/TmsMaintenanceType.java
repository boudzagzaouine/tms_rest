package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_maintenancetype")
public class TmsMaintenanceType  extends EmsEntity {

    @Id
    @GeneratedValue
    @Column(name = "tms_maintenancetypeid")
    private int tmsMaintenanceTypeid;
    @Column(name = "tms_maintenancetypecode")
    private String tmsMaintenanceTypecode;
    @Column(name = "tms_maintenancetypedescription")
    private String tmsMaintenanceTypedescription;


    public TmsMaintenanceType() {
    }

    public int getTmsMaintenanceTypeid() {
        return tmsMaintenanceTypeid;
    }

    public void setTmsMaintenanceTypeid(int tmsMaintenanceTypeid) {
        this.tmsMaintenanceTypeid = tmsMaintenanceTypeid;
    }

    public String getTmsMaintenanceTypecode() {
        return tmsMaintenanceTypecode;
    }

    public void setTmsMaintenanceTypecode(String tmsMaintenanceTypecode) {
        this.tmsMaintenanceTypecode = tmsMaintenanceTypecode;
    }

    public String getTmsMaintenanceTypedescription() {
        return tmsMaintenanceTypedescription;
    }

    public void setTmsMaintenanceTypedescription(String tmsMaintenanceTypedescription) {
        this.tmsMaintenanceTypedescription = tmsMaintenanceTypedescription;
    }
}

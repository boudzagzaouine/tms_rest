package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;

public class MaintenanceState extends EmsDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6010435708905017454L;
    private int id;
    private String code;
    private String descriptif;
    private Date creationDate;


    public MaintenanceState() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

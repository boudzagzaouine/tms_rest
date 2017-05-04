package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Enissay on 04/11/2016.
 */
public class GenerateInvoice implements Serializable {
    private Owner owner;
    private Date startDate;
    private Date endDate;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

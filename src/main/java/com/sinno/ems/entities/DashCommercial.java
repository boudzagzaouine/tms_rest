package com.sinno.ems.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Enissay on 04/01/2017.
 */
@Entity
public class DashCommercial {
    @Id
    private String commercial;
    private long amount;
     @Column(name = "usr_usercode")
    public String getCommercial() {
        return commercial;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }
    @Column(name="amount")
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public DashCommercial(String commercial, long amount) {
        this.commercial = commercial;
        this.amount = amount;
    }

    public DashCommercial() {
    }
}

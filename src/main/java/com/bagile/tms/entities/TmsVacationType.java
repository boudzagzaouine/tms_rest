package com.bagile.tms.entities;

import javax.persistence.*;


@Entity
@Table(name="tms_vacationtype")
public class TmsVacationType   {
    @Id
    @GeneratedValue
    @Column(name = "tms_vacationtypeid")
    private int id;
    @Column(name = "tms_vacationtypetype")
    private String type;

    public TmsVacationType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

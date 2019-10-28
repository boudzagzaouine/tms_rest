package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;

public class Vacation implements Serializable {

   private int id;
   private Date begin;
   private Date end;
   private VacationType vacationType;
   private Driver driver;

    public Vacation() {
    }



    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public VacationType getVacationtype() {
        return vacationType;
    }

    public void setVacationtype(VacationType vacationtype) {
        this.vacationType = vacationtype;
    }
}

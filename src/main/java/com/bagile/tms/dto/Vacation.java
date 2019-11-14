package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vacation extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7433270658093374012L;
    private long id;
   private Date startDate;
   private Date endDate;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public VacationType getVacationtype() {
        return vacationType;
    }

    public void setVacationtype(VacationType vacationtype) {
        this.vacationType = vacationtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return getId()==(vacation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

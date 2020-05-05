package com.bagile.gmo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="gmo_vacation")
public class GmoVacation extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -8961215785900000465L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_vacation_id", allocationSize = 1)
    @Column(name = "gmo_gmovacationid", unique = true, nullable = false, precision = 10, scale = 0)
   private Long gmoVacationId;
    @Column(name = "gmo_vacationbegin")
   private Date gmoVacationStartDate;
    @Column(name = "gmo_vacationend")
   private Date gmoVacationEndDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_vacationtypeid")
   private GmoVacationType gmoVacationType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_driverid")
   private GmoDriver gmoDriver;

    public Long getGmoVacationId() {
        return gmoVacationId;
    }

    public void setGmoVacationId(Long gmoVacationId) {
        this.gmoVacationId = gmoVacationId;
    }

    public Date getGmoVacationStartDate() {
        return gmoVacationStartDate;
    }

    public void setGmoVacationStartDate(Date gmoVacationStartDate) {
        this.gmoVacationStartDate = gmoVacationStartDate;
    }

    public Date getGmoVacationEndDate() {
        return gmoVacationEndDate;
    }

    public void setGmoVacationEndDate(Date gmoVacationEndDate) {
        this.gmoVacationEndDate = gmoVacationEndDate;
    }

    public GmoVacationType getGmoVacationType() {
        return gmoVacationType;
    }

    public void setGmoVacationType(GmoVacationType gmoVacationType) {
        this.gmoVacationType = gmoVacationType;
    }

    public GmoDriver getGmoDriver() {
        return gmoDriver;
    }

    public void setGmoDriver(GmoDriver gmoDriver) {
        this.gmoDriver = gmoDriver;
    }
}

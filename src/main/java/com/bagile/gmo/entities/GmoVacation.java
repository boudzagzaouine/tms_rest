package com.bagile.gmo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


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

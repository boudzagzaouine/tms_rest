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
@Table(name="tms_vacation")
public class TmsVacation extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -8961215785900000465L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vacation_id", allocationSize = 1)
    @Column(name = "tms_tmsvacationid", unique = true, nullable = false, precision = 10, scale = 0)
   private Long tmsVacationId;
    @Column(name = "tms_vacationbegin")
   private Date tmsVacationStartDate;
    @Column(name = "tms_vacationend")
   private Date tmsVacationEndDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vacationtypeid")
   private TmsVacationType tmsVacationType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverid")
   private GmoDriver gmoDriver;

    public Long getTmsVacationId() {
        return tmsVacationId;
    }

    public void setTmsVacationId(Long tmsVacationId) {
        this.tmsVacationId = tmsVacationId;
    }

    public Date getTmsVacationStartDate() {
        return tmsVacationStartDate;
    }

    public void setTmsVacationStartDate(Date tmsVacationStartDate) {
        this.tmsVacationStartDate = tmsVacationStartDate;
    }

    public Date getTmsVacationEndDate() {
        return tmsVacationEndDate;
    }

    public void setTmsVacationEndDate(Date tmsVacationEndDate) {
        this.tmsVacationEndDate = tmsVacationEndDate;
    }

    public TmsVacationType getTmsVacationType() {
        return tmsVacationType;
    }

    public void setTmsVacationType(TmsVacationType tmsVacationType) {
        this.tmsVacationType = tmsVacationType;
    }

    public GmoDriver getGmoDriver() {
        return gmoDriver;
    }

    public void setGmoDriver(GmoDriver gmoDriver) {
        this.gmoDriver = gmoDriver;
    }
}

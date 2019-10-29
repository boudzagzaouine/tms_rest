package com.bagile.tms.entities;

import javax.persistence.*;

import java.util.Date;


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
   private TmsDriver tmsDriver;

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

    public TmsDriver getTmsDriver() {
        return tmsDriver;
    }

    public void setTmsDriver(TmsDriver tmsDriver) {
        this.tmsDriver = tmsDriver;
    }
}

package com.bagile.tms.entities;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="tms_vacation")
public class TmsVacation  extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -8961215785900000465L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_vacationid", allocationSize = 1)
    @Column(name = "tms_tmsvacationid", unique = true, nullable = false, precision = 10, scale = 0)
   private int tmsVacationId;
    @Column(name = "tms_vacationbegin")
   private Date tmsVacationBegin;
    @Column(name = "tms_vacationend")
   private Date tmsVacationEnd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vacationtypeid")
   private TmsVacationType tmsVacationType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverid")
   private TmsDriver tmsDriver;

    public TmsVacation() {
    }


    public int getTmsVacationId() {
        return tmsVacationId;
    }

    public void setTmsVacationId(int tmsVacationId) {
        this.tmsVacationId = tmsVacationId;
    }

    public Date getTmsVacationBegin() {
        return tmsVacationBegin;
    }

    public void setTmsVacationBegin(Date tmsVacationBegin) {
        this.tmsVacationBegin = tmsVacationBegin;
    }

    public Date getTmsVacationEnd() {
        return tmsVacationEnd;
    }

    public void setTmsVacationEnd(Date tmsVacationEnd) {
        this.tmsVacationEnd = tmsVacationEnd;
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

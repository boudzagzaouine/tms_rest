package com.bagile.tms.entities;

import com.bagile.tms.dto.Driver;
import com.bagile.tms.dto.VacationType;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="tms_vacation")
public class TmsVacation  extends EmsEntity {

    @Id
    @GeneratedValue
    @Column(name = "tms_vacationid")
   private int tmsVacationid;
    @Column(name = "tms_vacationbegin")
   private Date tmsVacationbegin;
    @Column(name = "tms_vacationend")
   private Date tmsVacationend;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_vacationtypeid")
   private TmsVacationType tmsVacationType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_driverid")
   private TmsDriver tmsdriver;

    public TmsVacation() {
    }


    public int getTmsVacationid() {
        return tmsVacationid;
    }

    public void setTmsVacationid(int tmsVacationid) {
        tmsVacationid = tmsVacationid;
    }

    public Date getTmsVacationbegin() {
        return tmsVacationbegin;
    }

    public void setTmsVacationbegin(Date tmsVacationbegin) {
        tmsVacationbegin = tmsVacationbegin;
    }

    public Date getTmsVacationend() {
        return tmsVacationend;
    }

    public void setTmsVacationend(Date tmsVacationend) {
        tmsVacationend = tmsVacationend;
    }

    public TmsVacationType getTmsVacationType() {
        return tmsVacationType;
    }

    public void setTmsVacationType(TmsVacationType tmsVacationType) {
        this.tmsVacationType = tmsVacationType;
    }

    public TmsDriver getTmsdriver() {
        return tmsdriver;
    }

    public void setTmsdriver(TmsDriver tmsdriver) {
        tmsdriver = tmsdriver;
    }
}

package com.bagile.tms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tms_vacation")
public class TmsVacation {

    private int tmsVacationId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmsVacationBegin;

    private Date tmsVacationEnd;

    private String tmsVacationType;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_idVacation")
    public int getTmsVacationId() {
        return tmsVacationId;
    }

    public void setTmsVacationId(int tmsVacationId) {
        this.tmsVacationId = tmsVacationId;
    }

    @Column(name = "tms_vacationbegin")
    public Date getTmsVacationBegin() {
        return tmsVacationBegin;
    }

    public void setTmsVacationBegin(Date tmsVacationBegin) {
        this.tmsVacationBegin = tmsVacationBegin;
    }

    @Column(name = "tms_vacationend")
    public Date getTmsVacationEnd() {
        return tmsVacationEnd;
    }

    public void setTmsVacationEnd(Date tmsVacationEnd) {
        this.tmsVacationEnd = tmsVacationEnd;
    }

    @Column(name = "tms_vacationtype")
    public String getTmsVacationType() {
        return tmsVacationType;
    }

    public void setTmsVacationType(String tmsVacationType) {
        this.tmsVacationType = tmsVacationType;
    }

}

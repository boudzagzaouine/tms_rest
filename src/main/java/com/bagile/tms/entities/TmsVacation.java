package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Date;

public class TmsVacation {
    private int tmsVacationId;
    private Date tmsVacationBegin;
    private Date tmsVacationEnd;
    private String tmsVacationType;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_idVacation", unique = true, nullable = false, scale = 0)

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

    public String getTmsVacationType() {
        return tmsVacationType;
    }

    public void setTmsVacationType(String tmsVacationType) {
        this.tmsVacationType = tmsVacationType;
    }

}

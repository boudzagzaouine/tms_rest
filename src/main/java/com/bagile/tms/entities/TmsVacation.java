package com.bagile.tms.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tms_vacation",uniqueConstraints = @UniqueConstraint(columnNames = {"tms_vacationId"}))
public class TmsVacation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq")
    @Column(name = "tms_idVacation")
    private int tmsVacationId;
    
    @Column(name = "tms_vacationbegin")
    private Date tmsVacationBegin;
    
    @Column(name = "tms_vacationend")
    private Date tmsVacationEnd;
    
    @Column(name = "tms_vacationtype")
    private String tmsVacationType;

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

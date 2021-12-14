package com.bagile.gmo.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "prm_pays", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"prm_payscode"})})
public class PrmPays extends EmsEntity implements Serializable {
    private long prmPaysId;
    private String prmPaysCode;
    private String prmPaysDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmPaysCreationDate; 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmPaysUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_pays", allocationSize = 1)
    @Column(name = "prm_paysid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmPaysId() {
        return prmPaysId;
    }

    public void setPrmPaysId(long prmPaysId) {
        this.prmPaysId = prmPaysId;
    }

    @Column(name = "prm_payscode", unique = true, nullable = false)
    public String getPrmPaysCode() {
        return prmPaysCode;
    }

    public void setPrmPaysCode(String prmPaysCode) {
        this.prmPaysCode = prmPaysCode;
    }

    @Column(name = "prm_paysdescription")
    public String getPrmPaysDescription() {
        return prmPaysDescription;
    }

    public void setPrmPaysDescription(String prmPaysDescription) {
        this.prmPaysDescription = prmPaysDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_payscreationdate")
    public Date getPrmPaysCreationDate() {
        return prmPaysCreationDate;
    }

    public void setPrmPaysCreationDate(Date prmPaysCreationDate) {
        this.prmPaysCreationDate = prmPaysCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_paysupdatedate")
    public Date getPrmPaysUpdateDate() {
        return prmPaysUpdateDate;
    }

    public void setPrmPaysUpdateDate(Date prmPaysUpdateDate) {
        this.prmPaysUpdateDate = prmPaysUpdateDate;
    }
}

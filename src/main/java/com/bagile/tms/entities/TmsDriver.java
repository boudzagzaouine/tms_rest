package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tms_driver")
public class TmsDriver extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = 7465274138053290715L;

    private long tmsDriverId;

    private String tmsDriverCode;
    private String tmsDriverCin;

    private Date tmsDriverbirthDate;

    private Date tmsDriverLastMedicalVisit;

    private BigDecimal tmsDriverCommission;

    private PrmContact prmContact;

    private boolean tmsWorking;

    private TmsBadge tmsBadge;


    public TmsDriver() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_driver_id", allocationSize = 1)
    @Column(name = "tms_driverid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getTmsDriverId() {
        return tmsDriverId;
    }

    public void setTmsDriverId(long tmsDriverId) {
        this.tmsDriverId = tmsDriverId;
    }

    @Column(name = "tms_drivercode", unique = true, nullable = false, length = 90)
    public String getTmsDriverCode() {
        return tmsDriverCode;
    }

    public void setTmsDriverCode(String tmsDriverCode) {
        this.tmsDriverCode = tmsDriverCode;
    }

    @Column(name = "tms_drivercin")
    public String getTmsDriverCin() {
        return tmsDriverCin;
    }

    public void setTmsDriverCin(String tmsDriverCin) {
        this.tmsDriverCin = tmsDriverCin;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tms_driverbirthdate")
    public Date getTmsDriverbirthDate() {
        return tmsDriverbirthDate;
    }

    public void setTmsDriverbirthDate(Date tmsDriverbirthDate) {
        this.tmsDriverbirthDate = tmsDriverbirthDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "tms_driverlastmedicalvisit")
    public Date getTmsDriverLastMedicalVisit() {
        return tmsDriverLastMedicalVisit;
    }

    public void setTmsDriverLastMedicalVisit(Date tmsDriverLastMedicalVisit) {
        this.tmsDriverLastMedicalVisit = tmsDriverLastMedicalVisit;
    }

    @Column(name = "tms_drivercommission")
    public BigDecimal getTmsDriverCommission() {
        return tmsDriverCommission;
    }

    public void setTmsDriverCommission(BigDecimal tmsDriverCommission) {
        this.tmsDriverCommission = tmsDriverCommission;
    }


    @OneToOne
    @JoinColumn(name = "prm_contactid")
    public PrmContact getPrmContact() {
        return prmContact;
    }

    public void setPrmContact(PrmContact prmContact) {
        this.prmContact = prmContact;
    }

    public boolean isTmsWorking() {
        return tmsWorking;
    }

    public void setTmsWorking(boolean tmsWorking) {
        this.tmsWorking = tmsWorking;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "tms_badgeid")
    public TmsBadge getTmsBadge() {
        return tmsBadge;
    }

    public void setTmsBadge(TmsBadge tmsbadge) {
        this.tmsBadge = tmsbadge;
    }
}

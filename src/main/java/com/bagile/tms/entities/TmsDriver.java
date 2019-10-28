package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="tms_driver")
public class TmsDriver  extends EmsEntity{

    /**
     *
     */
    private static final long serialVersionUID = 7465274138053290715L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_driver_id", allocationSize = 1)
    @Column(name = "tms_driverid", unique = true, nullable = false, precision = 10, scale = 0)
    private long tmsDriverId;
    @Column(name = "tms_drivercode")
    private String tmsDriverCode;
    @Column(name = "tms_drivercin")
    private String tmsDriverCin;
    @Temporal(TemporalType.DATE)
    @Column(name = "tms_driverbirthdate")
    private Date tmsDriverbirthDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "tms_driverlastmedicalvisit")
    private Date tmsDriverLastMedicalVisit;
    @Column(name = "tms_drivercommission")
    private BigDecimal tmsDriverCommission;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_drivercreationdate")
    private Date tmsDriverCreationDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tms_driverupdate")
    private Date tmsDriverUpdateDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_contactid")
    private PrmContact prmContact;
    @Column(name = "tms_driverworkin")
    private boolean tmsWorking;






    public TmsDriver() {
    }

    public boolean isTmsWorking() {
        return tmsWorking;
    }

    public void setTmsWorking(boolean tmsWorking) {
        this.tmsWorking = tmsWorking;
    }

    public long getTmsDriverId() {
        return tmsDriverId;
    }

    public void setTmsDriverId(long tmsDriverId) {
        this.tmsDriverId = tmsDriverId;
    }

    public String getTmsDriverCode() {
        return tmsDriverCode;
    }

    public void setTmsDriverCode(String tmsDriverCode) {
        this.tmsDriverCode = tmsDriverCode;
    }

    public String getTmsDriverCin() {
        return tmsDriverCin;
    }

    public void setTmsDriverCin(String tmsDriverCin) {
        this.tmsDriverCin = tmsDriverCin;
    }

    public Date getTmsDriverbirthDate() {
        return tmsDriverbirthDate;
    }

    public void setTmsDriverbirthDate(Date tmsDriverbirthDate) {
        this.tmsDriverbirthDate = tmsDriverbirthDate;
    }

    public Date getTmsDriverLastMedicalVisit() {
        return tmsDriverLastMedicalVisit;
    }

    public void setTmsDriverLastMedicalVisit(Date tmsDriverLastMedicalVisit) {
        this.tmsDriverLastMedicalVisit = tmsDriverLastMedicalVisit;
    }

    public BigDecimal getTmsDriverCommission() {
        return tmsDriverCommission;
    }

    public void setTmsDriverCommission(BigDecimal tmsDriverCommission) {
        this.tmsDriverCommission = tmsDriverCommission;
    }

    public Date getTmsDriverCreationDate() {
        return tmsDriverCreationDate;
    }

    public void setTmsDriverCreationDate(Date tmsDriverCreationDate) {
        this.tmsDriverCreationDate = tmsDriverCreationDate;
    }

    public Date getTmsDriverUpdateDate() {
        return tmsDriverUpdateDate;
    }

    public void setTmsDriverupDateDate(Date tmsDriverupDateDate) {
        this.tmsDriverUpdateDate = tmsDriverupDateDate;
    }

    public PrmContact getprmContact() {
        return prmContact;
    }

    public void setTmsContact(PrmContact prmContact) {
        this.prmContact = prmContact;
    }


}

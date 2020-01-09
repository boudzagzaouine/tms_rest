package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private Date tmsDriverBirthDate;

    private Date tmsDriverLastMedicalVisit;

    private BigDecimal tmsDriverCommission;

   // private PrmContact prmContact;

    private boolean tmsWorking;

    private TmsBadge tmsBadge;


    private String tmsDriverName;

    private String tmsDriverSurname;
    private String tmsDriverTele1;

    private String tmsDriverFax;
    private String tmsDriverType;
    private String tmsDriverEmail;
    private String tmsDriverComment;

    private List<TmsCommission> tmsCommissions = new ArrayList<>();
    private List<TmsBadgeTypeDriver> tmsBadgeTypeDrivers=new ArrayList<>();

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
    public Date getTmsDriverBirthDate() {
        return tmsDriverBirthDate;
    }

    public void setTmsDriverBirthDate(Date tmsDriverBirthDate) {
        this.tmsDriverBirthDate = tmsDriverBirthDate;
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

    @Column(name = "tms_drivername")
    public String getTmsDriverName() {
        return tmsDriverName;
    }

    public void setTmsDriverName(String tmsDriverName) {
        this.tmsDriverName = tmsDriverName;
    }
    @Column(name = "tms_driversurname")
    public String getTmsDriverSurname() {
        return tmsDriverSurname;
    }

    public void setTmsDriverSurname(String tmsDriverSurname) {
        this.tmsDriverSurname = tmsDriverSurname;
    }
    @Column(name = "tms_drivertele1")

    public String getTmsDriverTele1() {
        return tmsDriverTele1;
    }

    public void setTmsDriverTele1(String tmsDriverTele1) {
        this.tmsDriverTele1 = tmsDriverTele1;
    }
    @Column(name = "tms_driverfax")

    public String getTmsDriverFax() {
        return tmsDriverFax;
    }

    public void setTmsDriverFax(String tmsDriverFax) {
        this.tmsDriverFax = tmsDriverFax;
    }
    @Column(name = "tms_drivertype")

    public String getTmsDriverType() {
        return tmsDriverType;
    }

    public void setTmsDriverType(String tmsDriverType) {
        this.tmsDriverType = tmsDriverType;
    }
    @Column(name = "tms_driveremail")

    public String getTmsDriverEmail() {
        return tmsDriverEmail;
    }

    public void setTmsDriverEmail(String tmsDriverEmail) {
        this.tmsDriverEmail = tmsDriverEmail;
    }
    @Column(name = "tms_drivercomment")

    public String getTmsDriverComment() {
        return tmsDriverComment;
    }

    public void setTmsDriverComment(String tmsDriverComment) {
        this.tmsDriverComment = tmsDriverComment;
    }

    @OneToMany (mappedBy = "tmsDriver")
    public List<TmsCommission> getTmsCommissions() {
        return tmsCommissions;
    }

    public void setTmsCommissions(List<TmsCommission> tmsCommissions) {
        this.tmsCommissions = tmsCommissions;
    }

    @OneToMany(mappedBy = "tmsDriver",cascade = CascadeType.MERGE)
    public List<TmsBadgeTypeDriver> getTmsBadgeTypeDrivers() {
        return tmsBadgeTypeDrivers;
    }

    public void setTmsBadgeTypeDrivers(List<TmsBadgeTypeDriver> tmsBadgeTypeDrivers) {
        this.tmsBadgeTypeDrivers = tmsBadgeTypeDrivers;
    }
}

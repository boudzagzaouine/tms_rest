package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "gmo_driver")
public class GmoDriver extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = 7465274138053290715L;

    private long gmoDriverId;

    private String gmoDriverCode;
    private String gmoDriverCin;

    private Date gmoDriverBirthDate;

    private Date gmoDriverLastMedicalVisit;

    private BigDecimal gmoDriverCommission;

   // private PrmContact prmContact;

    private Boolean gmoWorking=false;

    //private GmoBadge gmoBadge;

    private String gmoCarte;

    private String gmoDriverName;

    private String gmoDriverSurname;
    private String gmoDriverTele1;

    private String gmoDriverFax;
    private String gmoDriverType;
    private String gmoDriverEmail;
    private String gmoDriverComment;

   // private Set<GmoCommissionDriver> gmoCommissions = new HashSet<>();
    private Set<GmoBadgeTypeDriver> gmoBadgeTypeDrivers=new HashSet<>();

    private Set<GmoTurn> gmoTurns = new HashSet<>();


    public GmoDriver() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_driver_id", allocationSize = 1)
    @Column(name = "gmo_driverid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoDriverId() {
        return gmoDriverId;
    }

    public void setGmoDriverId(long gmoDriverId) {
        this.gmoDriverId = gmoDriverId;
    }

    @Column(name = "gmo_drivercode", unique = true, nullable = false, length = 90)
    public String getGmoDriverCode() {
        return gmoDriverCode;
    }

    public void setGmoDriverCode(String gmoDriverCode) {
        this.gmoDriverCode = gmoDriverCode;
    }

    @Column(name = "gmo_drivercin")
    public String getGmoDriverCin() {
        return gmoDriverCin;
    }

    public void setGmoDriverCin(String gmoDriverCin) {
        this.gmoDriverCin = gmoDriverCin;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "gmo_driverbirthdate")
    public Date getGmoDriverBirthDate() {
        return gmoDriverBirthDate;
    }

    public void setGmoDriverBirthDate(Date gmoDriverBirthDate) {
        this.gmoDriverBirthDate = gmoDriverBirthDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "gmo_driverlastmedicalvisit")
    public Date getGmoDriverLastMedicalVisit() {
        return gmoDriverLastMedicalVisit;
    }

    public void setGmoDriverLastMedicalVisit(Date gmoDriverLastMedicalVisit) {
        this.gmoDriverLastMedicalVisit = gmoDriverLastMedicalVisit;
    }

    @Column(name = "gmo_drivercommission")

    public BigDecimal getGmoDriverCommission() {
        return gmoDriverCommission;
    }

    public void setGmoDriverCommission(BigDecimal gmoDriverCommission) {
        this.gmoDriverCommission = gmoDriverCommission;
    }

    @Column(name = "gmo_driverisworking")
    public Boolean isGmoWorking() {
        return gmoWorking;
    }

    public void setGmoWorking(Boolean gmoWorking) {
        if(gmoWorking==null){
            this.gmoWorking=false;
        }
        else {this.gmoWorking = gmoWorking;}
    }

  /*  @ManyToOne(optional = false)
    @JoinColumn(name = "gmo_badgeid")
    public GmoBadge getGmoBadge() {
        return gmoBadge;
    }

    public void setGmoBadge(GmoBadge gmobadge) {
        this.gmoBadge = gmobadge;
    }*/

    @Column(name = "gmo_drivername")
    public String getGmoDriverName() {
        return gmoDriverName;
    }

    public void setGmoDriverName(String gmoDriverName) {
        this.gmoDriverName = gmoDriverName;
    }
    @Column(name = "gmo_driversurname")
    public String getGmoDriverSurname() {
        return gmoDriverSurname;
    }

    public void setGmoDriverSurname(String gmoDriverSurname) {
        this.gmoDriverSurname = gmoDriverSurname;
    }
    @Column(name = "gmo_drivertele1")

    public String getGmoDriverTele1() {
        return gmoDriverTele1;
    }

    public void setGmoDriverTele1(String gmoDriverTele1) {
        this.gmoDriverTele1 = gmoDriverTele1;
    }
    @Column(name = "gmo_driverfax")

    public String getGmoDriverFax() {
        return gmoDriverFax;
    }

    public void setGmoDriverFax(String gmoDriverFax) {
        this.gmoDriverFax = gmoDriverFax;
    }
    @Column(name = "gmo_drivertype")

    public String getGmoDriverType() {
        return gmoDriverType;
    }

    public void setGmoDriverType(String gmoDriverType) {
        this.gmoDriverType = gmoDriverType;
    }
    @Column(name = "gmo_driveremail")

    public String getGmoDriverEmail() {
        return gmoDriverEmail;
    }

    public void setGmoDriverEmail(String gmoDriverEmail) {
        this.gmoDriverEmail = gmoDriverEmail;
    }
    @Column(name = "gmo_drivercomment")

    public String getGmoDriverComment() {
        return gmoDriverComment;
    }

    public void setGmoDriverComment(String gmoDriverComment) {
        this.gmoDriverComment = gmoDriverComment;
    }

   /* @OneToMany (mappedBy = "gmoDriver",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<GmoCommissionDriver> getGmoCommissions() {
        return gmoCommissions;
    }

    public void setGmoCommissions(Set<GmoCommissionDriver> gmoCommissions) {
        this.gmoCommissions = gmoCommissions;
    }*/

    @OneToMany(mappedBy = "gmoDriver",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<GmoBadgeTypeDriver> getGmoBadgeTypeDrivers() {
        return gmoBadgeTypeDrivers;
    }

    public void setGmoBadgeTypeDrivers(Set<GmoBadgeTypeDriver> gmoBadgeTypeDrivers) {
        this.gmoBadgeTypeDrivers = gmoBadgeTypeDrivers;
    }


    @Column(name = "gmo_drivercarte")
    public String getGmoCarte() {
        return gmoCarte;
    }

    public void setGmoCarte(String gmoCarte) {
        this.gmoCarte = gmoCarte;
    }

    @ManyToMany(mappedBy = "gmoDrivers")
    public Set<GmoTurn> getGmoTurns() {
        return gmoTurns;
    }

    public void setGmoTurns(Set<GmoTurn> gmoTurns) {
        this.gmoTurns = gmoTurns;
    }
}

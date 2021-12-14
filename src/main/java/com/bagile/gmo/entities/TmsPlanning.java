package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tms_planning")
public class TmsPlanning extends EmsEntity{

    private Long tmsPlanningId;
    private String tmsPlanningDay;
    private String tmsPlanningMorning;
    private Date tmsPlanningMorningTimeStart;
    private Date tmsPlanningMorningTimeEnd;
    private String tmsPlanningEvering;
    private Date tmsPlanningEveringTimeStart;
    private Date tmsPlanningEveringTimeEnd;
    private OwnOwner ownOwner;
  private Boolean tmsPlanningClosingDay;
    private CmdAccount cmdAccount;
    private RcpSupplier rcpSupplier;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_planning_id", allocationSize = 1)
    @Column(name = "tms_planningid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsPlanningId() {
        return tmsPlanningId;
    }

    public void setTmsPlanningId(Long tmsHolidayId) {
        this.tmsPlanningId = tmsHolidayId;
    }

    @Column(name = "tms_planningday",nullable = false)
    public String getTmsPlanningDay() {
        return tmsPlanningDay;
    }

    public void setTmsPlanningDay(String tmsPlanninDay) {
        this.tmsPlanningDay = tmsPlanninDay;
    }

    @Column(name = "tms_planningmorning")
    public String getTmsPlanningMorning() {
        return tmsPlanningMorning;
    }

    public void setTmsPlanningMorning(String tmsPlanninMorning) {
        this.tmsPlanningMorning = tmsPlanninMorning;
    }
    @Column(name = "tms_planningmorningtimestart")
    public Date getTmsPlanningMorningTimeStart() {
        return tmsPlanningMorningTimeStart;
    }

    public void setTmsPlanningMorningTimeStart(Date tmsPlanninMorningTimeStart) {
        this.tmsPlanningMorningTimeStart = tmsPlanninMorningTimeStart;
    }

    public Boolean getTmsPlanningClosingDay() {
        return tmsPlanningClosingDay;
    }
    @Column(name = "tms_planningclosingday")
    public void setTmsPlanningClosingDay(Boolean tmsPlanningClosingDay) {
        this.tmsPlanningClosingDay = tmsPlanningClosingDay;
    }

    @Column(name = "tms_planningmorningtimeend")
    public Date getTmsPlanningMorningTimeEnd() {
        return tmsPlanningMorningTimeEnd;
    }

    public void setTmsPlanningMorningTimeEnd(Date tmsPlanninMorningTimeEnd) {
        this.tmsPlanningMorningTimeEnd = tmsPlanninMorningTimeEnd;
    }
    @Column(name = "tms_planningevering")
    public String getTmsPlanningEvering() {
        return tmsPlanningEvering;
    }

    public void setTmsPlanningEvering(String tmsPlanninEvering) {
        this.tmsPlanningEvering = tmsPlanninEvering;
    }

    @Column(name = "tms_planningeveringstart")
    public Date getTmsPlanningEveringTimeStart() {
        return tmsPlanningEveringTimeStart;
    }

    public void setTmsPlanningEveringTimeStart(Date tmsPlanninEveringTimeStart) {
        this.tmsPlanningEveringTimeStart = tmsPlanninEveringTimeStart;
    }

    @Column(name = "tms_planningeveringtimeend")
    public Date getTmsPlanningEveringTimeEnd() {
        return tmsPlanningEveringTimeEnd;
    }

    public void setTmsPlanningEveringTimeEnd(Date tmsPlanninEveringTimeEnd) {
        this.tmsPlanningEveringTimeEnd = tmsPlanninEveringTimeEnd;
    }

    @ManyToOne()
    @JoinColumn(name="tms_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne()
    @JoinColumn(name="tms_accountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }

    @ManyToOne()
    @JoinColumn(name="tms_supplierid")
    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }
}

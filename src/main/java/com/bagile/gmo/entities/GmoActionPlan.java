package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gmo_actionplan")
public class GmoActionPlan extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1640304759359470684L;

    private Long gmoActionPlanId;
    private Date gmoActionPlanStartDate;
    private Date gmoActionPlanEndDate;
    private GmoMaintenanceType gmoMaintenanceType;
    private GmoProgramType gmoProgramType;
    private GmoServiceProvider gmoServiceProvider;
    private GmoResponsability gmoResponsability;
    private GmoResponsability gmoService;
    private GmoPeriodicityType gmoPeriodicityType;
    private BigDecimal gmoActionPlanTriggerDay;
    private Date gmoActionPlanTriggerDate;
    private Date gmoActionPlanInterventionDate;
    private Double gmoActionPlanMileage = 0.0;
    private BigDecimal gmoActionPlanTotalPrice = BigDecimal.ZERO;
    private String gmoActionPlanAgent;
    private String gmoActionPlanEmployer;
    private String gmoActionPlanObservation;
    private Date gmoActionPlanDeclaredDate;
    private BigDecimal gmoActionPlanDuration;
    private Long gmoActionPlanDayOfMonth;
    private Set<GmoMonth> gmoMonths = new HashSet<>();
    private Set<GmoDay> gmoDays = new HashSet<>();
    private GmoMaintenancePlan gmoMaintenancePlan;
    private  GmoActionType gmoActionType;

    private GmoConditionalType gmoConditionalType;
    private BigDecimal gmoActionPlanValueconditionalType;
 private OwnOwner  ownOwner;
    public GmoActionPlan() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_ActionPlan__id", allocationSize = 1)
    @Column(name = "gmo_ActionPlanid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoActionPlanId() {
        return gmoActionPlanId;
    }

    public void setGmoActionPlanId(Long gmoActionPlanId) {
        this.gmoActionPlanId = gmoActionPlanId;
    }


    @Column(name = "gmo_ActionPlanstartdate")
    @Temporal(TemporalType.DATE)
    public Date getGmoActionPlanStartDate() {
        return gmoActionPlanStartDate;
    }

    public void setGmoActionPlanStartDate(Date gmoActionPlanStartDate) {
        this.gmoActionPlanStartDate = gmoActionPlanStartDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_serviceid")
    public GmoResponsability getGmoService() {
        return gmoService;
    }

    @ManyToMany()
    @JoinTable(name="gmo_day_plan", joinColumns=@JoinColumn(name="gmo_ActionPlanid"),
            inverseJoinColumns=@JoinColumn(name="gmo_dayid"))
    public Set<GmoDay> getGmoDays() {
        return gmoDays;
    }

    public void setGmoDays(Set<GmoDay> gmoDays) {
        this.gmoDays = gmoDays;
    }

    @ManyToMany()
    @JoinTable(name="gmo_month_plan", joinColumns=@JoinColumn(name="gmo_ActionPlanid"),
            inverseJoinColumns=@JoinColumn(name="gmo_monthid"))
    public Set<GmoMonth> getGmoMonths() {
        return gmoMonths;
    }

    public void setGmoMonths(Set<GmoMonth> gmoMonths) {
        this.gmoMonths = gmoMonths;
    }

    public void setGmoService(GmoResponsability gmoService) {
        this.gmoService = gmoService;
    }

    @Column(name = "Gmo_ActionPlanenddate")
    @Temporal(TemporalType.DATE)
    public Date getGmoActionPlanEndDate() {
        return gmoActionPlanEndDate;
    }

    public void setGmoActionPlanEndDate(Date gmoActionPlanEndDate) {
        this.gmoActionPlanEndDate = gmoActionPlanEndDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_programetypeid")
    public GmoProgramType getGmoProgramType() {
        return gmoProgramType;
    }

    public void setGmoProgramType(GmoProgramType gmoProgramType) {
        this.gmoProgramType = gmoProgramType;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_serviceproviderid")
    public GmoServiceProvider getGmoServiceProvider() {
        return gmoServiceProvider;
    }

    public void setGmoServiceProvider(GmoServiceProvider gmoServiceProvider) {
        this.gmoServiceProvider = gmoServiceProvider;
    }

    @ManyToOne()
    @JoinColumn(name = "gmo_conditionaltypeid")
    public GmoConditionalType getGmoConditionalType() {
        return gmoConditionalType;
    }

    public void setGmoConditionalType(GmoConditionalType gmoConditionalType) {
        this.gmoConditionalType = gmoConditionalType;
    }

    @Column(name = "gmo_actionplanvalueconditionaltype")
    public BigDecimal getGmoActionPlanValueconditionalType() {
        return gmoActionPlanValueconditionalType;
    }

    public void setGmoActionPlanValueconditionalType(BigDecimal gmoActionPlanValueconditionalType) {
        this.gmoActionPlanValueconditionalType = gmoActionPlanValueconditionalType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_responsabilityid")
    public GmoResponsability getGmoResponsability() {
        return gmoResponsability;
    }

    public void setGmoResponsability(GmoResponsability gmoResponsability) {
        this.gmoResponsability = gmoResponsability;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_periodicitytypeid")
    public GmoPeriodicityType getGmoPeriodicityType() {
        return gmoPeriodicityType;
    }

    public void setGmoPeriodicityType(GmoPeriodicityType gmoPeriodicityType) {
        this.gmoPeriodicityType = gmoPeriodicityType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_ActionPlantypeid")
    public GmoMaintenanceType getGmoMaintenanceType() {
        return gmoMaintenanceType;
    }

    public void setGmoMaintenanceType(GmoMaintenanceType gmoMaintenanceType) {
        this.gmoMaintenanceType = gmoMaintenanceType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_actiontypeid")
    public GmoActionType getGmoActionType() {
        return gmoActionType;
    }

    public void setGmoActionType(GmoActionType gmoActionType) {
        this.gmoActionType = gmoActionType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenanceplanid")
    public GmoMaintenancePlan getGmoMaintenancePlan() {
        return gmoMaintenancePlan;
    }

    public void setGmoMaintenancePlan(GmoMaintenancePlan gmoMaintenancePlan) {
        this.gmoMaintenancePlan = gmoMaintenancePlan;
    }

    @Column(name = "gmo_ActionPlantotalprice")
    public BigDecimal getGmoActionPlanTotalPrice() {
        return gmoActionPlanTotalPrice;
    }

    public void setGmoActionPlanTotalPrice(BigDecimal gmoActionPlanTotalPrice) {
        this.gmoActionPlanTotalPrice = gmoActionPlanTotalPrice;
    }



    @Column(name = "gmo_ActionPlanmileage")
    public Double getGmoActionPlanMileage() {
        return gmoActionPlanMileage;
    }

    public void setGmoActionPlanMileage(Double gmoActionPlanMileage) {
        this.gmoActionPlanMileage = gmoActionPlanMileage;
    }

    @Column(name = "gmo_ActionPlaninterventiondate")
    public Date getGmoActionPlanInterventionDate() {
        return gmoActionPlanInterventionDate;
    }

    public void setGmoActionPlanInterventionDate(Date interventionDate) {
        this.gmoActionPlanInterventionDate = interventionDate;
    }

    @Column(name = "gmo_ActionPlantriggerday")
    public BigDecimal getGmoActionPlanTriggerDay() {
        return gmoActionPlanTriggerDay;
    }

    public void setGmoActionPlanTriggerDay(BigDecimal gmoDateTrigger) {
        this.gmoActionPlanTriggerDay = gmoDateTrigger;
    }

    @Column(name = "gmo_ActionPlantriggerdate")
    public Date getGmoActionPlanTriggerDate() {
        return gmoActionPlanTriggerDate;
    }

    public void setGmoActionPlanTriggerDate(Date gmoDayTrigger) {
        this.gmoActionPlanTriggerDate = gmoDayTrigger;
    }


    @Column(name = "gmo_ActionPlanagent")
    public String getGmoActionPlanAgent() {
        return gmoActionPlanAgent;
    }

    public void setGmoActionPlanAgent(String gmoAgent) {
        this.gmoActionPlanAgent = gmoAgent;
    }

    @Column(name = "gmo_ActionPlanemployer")
    public String getGmoActionPlanEmployer() {
        return gmoActionPlanEmployer;
    }

    public void setGmoActionPlanEmployer(String gmoEmployer) {
        this.gmoActionPlanEmployer = gmoEmployer;
    }

    @Column(name = "gmo_ActionPlanobservation")
    public String getGmoActionPlanObservation() {
        return gmoActionPlanObservation;
    }

    public void setGmoActionPlanObservation(String gmoObservation) {
        this.gmoActionPlanObservation = gmoObservation;
    }

    @Column(name = "gmo_ActionPlandeclaredate")
    public Date getGmoActionPlanDeclaredDate() {
        return gmoActionPlanDeclaredDate;
    }

    public void setGmoActionPlanDeclaredDate(Date gmoDeclaredDate) {
        this.gmoActionPlanDeclaredDate = gmoDeclaredDate;
    }

    @Column(name = "gmo_ActionPlandduration")
    public BigDecimal getGmoActionPlanDuration() {
        return gmoActionPlanDuration;
    }

    public void setGmoActionPlanDuration(BigDecimal gmoDuration) {
        this.gmoActionPlanDuration = gmoDuration;
    }

    @Column(name = "gmo_maintenancedayofmonth")
    public Long getGmoActionPlanDayOfMonth() {
        return gmoActionPlanDayOfMonth;
    }

    public void setGmoActionPlanDayOfMonth(Long gmoDayOfMonth) {
        this.gmoActionPlanDayOfMonth = gmoDayOfMonth;
    }

   @ManyToOne()
   @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}

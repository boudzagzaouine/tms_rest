package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gmo_maintenanceplan")
public class GmoMaintenancePlan extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1640304759359470684L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_maintenanceplan__id", allocationSize = 1)
    @Column(name = "gmo_maintenanceplanid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long gmoMaintenancePlanId;
    @Column(name = "gmo_maintenanceplancode", nullable = false, length = 90)
    private String gmoMaintenancePlanCode;
    @Column(name = "gmo_maintenanceplandescription")
    private String gmoMaintenancePlanDescription;
    @Column(name = "gmo_maintenanceplanstartdate")
    private Date gmoMaintenancePlanStartDate;
    @Column(name = "Gmo_MaintenancePlanenddate")
    private Date gmoMaintenancePlanEndDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenanceplantypeid")
    private GmoMaintenanceType gmoMaintenanceType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_programetypeid")
    private GmoProgramType gmoProgramType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_operationtypeid")
    private GmoService gmoOperationType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_serviceproviderid")
    private GmoServiceProvider gmoServiceProvider;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_responsabilityid")
    private GmoResponsability gmoResponsability;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_serviceid")
    private GmoResponsability gmoService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_periodicitytypeid")
    private GmoPeriodicityType gmoPeriodicityType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenanceplanstateid")
    private GmoMaintenanceState gmoMaintenanceState;

    @ManyToOne(cascade = CascadeType.MERGE)
    private GmoPatrimony gmoPatrimony;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gmoMaintenancePlan", orphanRemoval=true)
    private Set<GmoAction> gmoActions = new HashSet<> ();
    @Column(name = "gmo_maintenanceplantotalprice")
    private BigDecimal gmoMaintenancePlanTotalPrice = BigDecimal.ZERO;
    @Column(name = "gmo_maintenanceplanmileage")
    private Double gmoMaintenancePlanMileage = 0.0;

    @Column(name = "gmo_maintenanceplantriggerday")
    private BigDecimal gmoTriggerDay;
    @Column(name = "gmo_maintenanceplantriggerdate")
    private Date gmoTriggerDate;

    @Column(name = "gmo_maintenanceplaninterventiondate")
    private Date gmoInterventionDate;

    @Column(name = "gmo_maintenanceplanagent")
private String gmoAgent ;
    @Column(name = "gmo_maintenanceplanemployer")
    private String gmoEmployer ;
    @Column(name = "gmo_maintenanceplanobservation")
    private String gmoObservation ;

    @Column(name = "gmo_maintenanceplandeclaredate")
    private Date gmoDeclaredDate;

    @Column(name = "gmo_maintenanceplandduration")
    private BigDecimal gmoDuration;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name="gmo_day_plan", joinColumns=@JoinColumn(name="gmo_maintenanceplanid"),
            inverseJoinColumns=@JoinColumn(name="gmo_dayid"))
    private Set<GmoDay> gmoDays = new HashSet<>();

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name="gmo_month_plan", joinColumns=@JoinColumn(name="gmo_maintenanceplanid"),
            inverseJoinColumns=@JoinColumn(name="gmo_monthid"))
    private Set<GmoMonth> gmoMonths = new HashSet<>();

    @Column(name = "gmo_maintenancedayofmonth")
    private long gmoDayOfMonth ;

    public GmoMaintenancePlan() {
    }

    public Long getGmoMaintenancePlanId() {
        return gmoMaintenancePlanId;
    }

    public void setGmoMaintenancePlanId(Long gmoMaintenancePlanId) {
        this.gmoMaintenancePlanId = gmoMaintenancePlanId;
    }

    public String getGmoMaintenancePlanCode() {
        return gmoMaintenancePlanCode;
    }

    public void setGmoMaintenancePlanCode(String gmoMaintenancePlanCode) {
        this.gmoMaintenancePlanCode = gmoMaintenancePlanCode;
    }

    public String getGmoMaintenancePlanDescription() {
        return gmoMaintenancePlanDescription;
    }

    public void setGmoMaintenancePlanDescription(String gmoMaintenancePlanDescription) {
        this.gmoMaintenancePlanDescription = gmoMaintenancePlanDescription;
    }


    public Date getGmoMaintenancePlanStartDate() {
        return gmoMaintenancePlanStartDate;
    }

    public void setGmoMaintenancePlanStartDate(Date gmoMaintenancePlanStartDate) {
        this.gmoMaintenancePlanStartDate = gmoMaintenancePlanStartDate;
    }

    public GmoResponsability getGmoService() {
        return gmoService;
    }

    public Set<GmoDay> getGmoDays() {
        return gmoDays;
    }

    public void setGmoDays(Set<GmoDay> gmoDays) {
        this.gmoDays = gmoDays;
    }

    public Set<GmoMonth> getGmoMonths() {
        return gmoMonths;
    }

    public void setGmoMonths(Set<GmoMonth> gmoMonths) {
        this.gmoMonths = gmoMonths;
    }

    public void setGmoService(GmoResponsability gmoService) {
        this.gmoService = gmoService;
    }

    public Date getGmoMaintenancePlanEndDate() {
        return gmoMaintenancePlanEndDate;
    }

    public void setGmoMaintenancePlanEndDate(Date gmoMaintenancePlanEndDate) {
        this.gmoMaintenancePlanEndDate = gmoMaintenancePlanEndDate;
    }

    public GmoProgramType getGmoProgramType() {
        return gmoProgramType;
    }

    public void setGmoProgramType(GmoProgramType gmoProgramType) {
        this.gmoProgramType = gmoProgramType;
    }

    public GmoService getGmoOperationType() {
        return gmoOperationType;
    }

    public void setGmoOperationType(GmoService gmoOperationType) {
        this.gmoOperationType = gmoOperationType;
    }

    public GmoServiceProvider getGmoServiceProvider() {
        return gmoServiceProvider;
    }

    public void setGmoServiceProvider(GmoServiceProvider gmoServiceProvider) {
        this.gmoServiceProvider = gmoServiceProvider;
    }

    public GmoResponsability getGmoResponsability() {
        return gmoResponsability;
    }

    public void setGmoResponsability(GmoResponsability gmoResponsability) {
        this.gmoResponsability = gmoResponsability;
    }

    public GmoPeriodicityType getGmoPeriodicityType() {
        return gmoPeriodicityType;
    }

    public void setGmoPeriodicityType(GmoPeriodicityType gmoPeriodicityType) {
        this.gmoPeriodicityType = gmoPeriodicityType;
    }

    public GmoMaintenanceType getGmoMaintenanceType() {
        return gmoMaintenanceType;
    }

    public void setGmoMaintenanceType(GmoMaintenanceType gmoMaintenanceType) {
        this.gmoMaintenanceType = gmoMaintenanceType;
    }

    public GmoMaintenanceState getGmoMaintenanceState() {
        return gmoMaintenanceState;
    }

    public void setGmoMaintenanceState(GmoMaintenanceState gmoMaintenanceState) {
        this.gmoMaintenanceState = gmoMaintenanceState;
    }

    public GmoPatrimony getGmoPatrimony() {
        return gmoPatrimony;
    }

    public void setGmoPatrimony(GmoPatrimony gmoPatrimony) {
        this.gmoPatrimony = gmoPatrimony;
    }

    public Set<GmoAction> getGmoActions() {
        return gmoActions;
    }

    public BigDecimal getGmoMaintenancePlanTotalPrice() {
        return gmoMaintenancePlanTotalPrice;
    }

    public void setGmoMaintenancePlanTotalPrice(BigDecimal gmoMaintenancePlanTotalPrice) {
        this.gmoMaintenancePlanTotalPrice = gmoMaintenancePlanTotalPrice;
    }

    public void setGmoActions(Set<GmoAction> gmoMaintenancePlanLines) {
        this.gmoActions = gmoMaintenancePlanLines;
    }

    public Double getGmoMaintenancePlanMileage() {
        return gmoMaintenancePlanMileage;
    }

    public void setGmoMaintenancePlanMileage(Double gmoMaintenancePlanMileage) {
        this.gmoMaintenancePlanMileage = gmoMaintenancePlanMileage;
    }

    public Date getGmoInterventionDate() {
        return gmoInterventionDate;
    }

    public void setGmoInterventionDate(Date interventionDate) {
        this.gmoInterventionDate = interventionDate;
    }

    public BigDecimal getGmoTriggerDay() {
        return gmoTriggerDay;
    }

    public void setGmoTriggerDay(BigDecimal gmoDateTrigger) {
        this.gmoTriggerDay = gmoDateTrigger;
    }

    public Date getGmoTriggerDate() {
        return gmoTriggerDate;
    }

    public void setGmoTriggerDate(Date gmoDayTrigger) {
        this.gmoTriggerDate = gmoDayTrigger;
    }


    public String getGmoAgent() {
        return gmoAgent;
    }

    public void setGmoAgent(String gmoAgent) {
        this.gmoAgent = gmoAgent;
    }

    public String getGmoEmployer() {
        return gmoEmployer;
    }

    public void setGmoEmployer(String gmoEmployer) {
        this.gmoEmployer = gmoEmployer;
    }

    public String getGmoObservation() {
        return gmoObservation;
    }

    public void setGmoObservation(String gmoObservation) {
        this.gmoObservation = gmoObservation;
    }

    public Date getGmoDeclaredDate() {
        return gmoDeclaredDate;
    }

    public void setGmoDeclaredDate(Date gmoDeclaredDate) {
        this.gmoDeclaredDate = gmoDeclaredDate;
    }

    public BigDecimal getGmoDuration() {
        return gmoDuration;
    }

    public void setGmoDuration(BigDecimal gmoDuration) {
        this.gmoDuration = gmoDuration;
    }

    public long getGmoDayOfMonth() {
        return gmoDayOfMonth;
    }

    public void setGmoDayOfMonth(long gmoDayOfMonth) {
        this.gmoDayOfMonth = gmoDayOfMonth;
    }
}

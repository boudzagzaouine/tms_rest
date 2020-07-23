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

    private Long gmoMaintenancePlanId;

    private String gmoMaintenancePlanCode;
    private String gmoMaintenancePlanDescription;
    private Date gmoMaintenancePlanStartDate;
    private Date gmoMaintenancePlanEndDate;

    private GmoMaintenanceType gmoMaintenanceType;

    private GmoProgramType gmoProgramType;


    private GmoService gmoOperationType;

    private GmoServiceProvider gmoServiceProvider;

    private GmoResponsability gmoResponsability;

    private GmoResponsability gmoService;


    private GmoPeriodicityType gmoPeriodicityType;


    private GmoMaintenanceState gmoMaintenanceState;


    private GmoPatrimony gmoPatrimony;


    private Set<GmoAction> gmoActions = new HashSet<> ();
    private BigDecimal gmoMaintenancePlanTotalPrice = BigDecimal.ZERO;
    private Double gmoMaintenancePlanMileage = 0.0;


    private BigDecimal gmoTriggerDay;
    private Date gmoTriggerDate;

    private Date gmoInterventionDate;


private String gmoAgent ;
    private String gmoEmployer ;
    private String gmoObservation ;

    private Date gmoDeclaredDate;

    private BigDecimal gmoDuration;


    private Set<GmoDay> gmoDays = new HashSet<>();


    private Set<GmoMonth> gmoMonths = new HashSet<>();

    private long gmoDayOfMonth ;

    public GmoMaintenancePlan() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_maintenanceplan__id", allocationSize = 1)
    @Column(name = "gmo_maintenanceplanid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoMaintenancePlanId() {
        return gmoMaintenancePlanId;
    }

    public void setGmoMaintenancePlanId(Long gmoMaintenancePlanId) {
        this.gmoMaintenancePlanId = gmoMaintenancePlanId;
    }


    @Column(name = "gmo_maintenanceplancode", nullable = false, length = 90)
    public String getGmoMaintenancePlanCode() {
        return gmoMaintenancePlanCode;
    }

    public void setGmoMaintenancePlanCode(String gmoMaintenancePlanCode) {
        this.gmoMaintenancePlanCode = gmoMaintenancePlanCode;
    }

    @Column(name = "gmo_maintenanceplandescription")
    public String getGmoMaintenancePlanDescription() {
        return gmoMaintenancePlanDescription;
    }

    public void setGmoMaintenancePlanDescription(String gmoMaintenancePlanDescription) {
        this.gmoMaintenancePlanDescription = gmoMaintenancePlanDescription;
    }


    @Column(name = "gmo_maintenanceplanstartdate")
    public Date getGmoMaintenancePlanStartDate() {
        return gmoMaintenancePlanStartDate;
    }

    public void setGmoMaintenancePlanStartDate(Date gmoMaintenancePlanStartDate) {
        this.gmoMaintenancePlanStartDate = gmoMaintenancePlanStartDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_serviceid")
    public GmoResponsability getGmoService() {
        return gmoService;
    }
    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name="gmo_day_plan", joinColumns=@JoinColumn(name="gmo_maintenanceplanid"),
            inverseJoinColumns=@JoinColumn(name="gmo_dayid"))
    public Set<GmoDay> getGmoDays() {
        return gmoDays;
    }

    public void setGmoDays(Set<GmoDay> gmoDays) {
        this.gmoDays = gmoDays;
    }

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(name="gmo_month_plan", joinColumns=@JoinColumn(name="gmo_maintenanceplanid"),
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

    @Column(name = "Gmo_MaintenancePlanenddate")
    public Date getGmoMaintenancePlanEndDate() {
        return gmoMaintenancePlanEndDate;
    }

    public void setGmoMaintenancePlanEndDate(Date gmoMaintenancePlanEndDate) {
        this.gmoMaintenancePlanEndDate = gmoMaintenancePlanEndDate;
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
    @JoinColumn(name = "gmo_operationtypeid")
    public GmoService getGmoOperationType() {
        return gmoOperationType;
    }

    public void setGmoOperationType(GmoService gmoOperationType) {
        this.gmoOperationType = gmoOperationType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_serviceproviderid")
    public GmoServiceProvider getGmoServiceProvider() {
        return gmoServiceProvider;
    }

    public void setGmoServiceProvider(GmoServiceProvider gmoServiceProvider) {
        this.gmoServiceProvider = gmoServiceProvider;
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
    @JoinColumn(name = "gmo_maintenanceplantypeid")
    public GmoMaintenanceType getGmoMaintenanceType() {
        return gmoMaintenanceType;
    }

    public void setGmoMaintenanceType(GmoMaintenanceType gmoMaintenanceType) {
        this.gmoMaintenanceType = gmoMaintenanceType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenanceplanstateid")
    public GmoMaintenanceState getGmoMaintenanceState() {
        return gmoMaintenanceState;
    }

    public void setGmoMaintenanceState(GmoMaintenanceState gmoMaintenanceState) {
        this.gmoMaintenanceState = gmoMaintenanceState;
    }

    @ManyToOne()
    public GmoPatrimony getGmoPatrimony() {
        return gmoPatrimony;
    }

    public void setGmoPatrimony(GmoPatrimony gmoPatrimony) {
        this.gmoPatrimony = gmoPatrimony;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "gmoMaintenancePlan", orphanRemoval=true)
    public Set<GmoAction> getGmoActions() {
        return gmoActions;
    }

    @Column(name = "gmo_maintenanceplantotalprice")
    public BigDecimal getGmoMaintenancePlanTotalPrice() {
        return gmoMaintenancePlanTotalPrice;
    }

    public void setGmoMaintenancePlanTotalPrice(BigDecimal gmoMaintenancePlanTotalPrice) {
        this.gmoMaintenancePlanTotalPrice = gmoMaintenancePlanTotalPrice;
    }

    public void setGmoActions(Set<GmoAction> gmoMaintenancePlanLines) {
        this.gmoActions = gmoMaintenancePlanLines;
    }


    @Column(name = "gmo_maintenanceplanmileage")
    public Double getGmoMaintenancePlanMileage() {
        return gmoMaintenancePlanMileage;
    }

    public void setGmoMaintenancePlanMileage(Double gmoMaintenancePlanMileage) {
        this.gmoMaintenancePlanMileage = gmoMaintenancePlanMileage;
    }

    @Column(name = "gmo_maintenanceplaninterventiondate")
    public Date getGmoInterventionDate() {
        return gmoInterventionDate;
    }

    public void setGmoInterventionDate(Date interventionDate) {
        this.gmoInterventionDate = interventionDate;
    }

    @Column(name = "gmo_maintenanceplantriggerday")
    public BigDecimal getGmoTriggerDay() {
        return gmoTriggerDay;
    }

    public void setGmoTriggerDay(BigDecimal gmoDateTrigger) {
        this.gmoTriggerDay = gmoDateTrigger;
    }

    @Column(name = "gmo_maintenanceplantriggerdate")
    public Date getGmoTriggerDate() {
        return gmoTriggerDate;
    }

    public void setGmoTriggerDate(Date gmoDayTrigger) {
        this.gmoTriggerDate = gmoDayTrigger;
    }


    @Column(name = "gmo_maintenanceplanagent")
    public String getGmoAgent() {
        return gmoAgent;
    }

    public void setGmoAgent(String gmoAgent) {
        this.gmoAgent = gmoAgent;
    }

    @Column(name = "gmo_maintenanceplanemployer")
    public String getGmoEmployer() {
        return gmoEmployer;
    }

    public void setGmoEmployer(String gmoEmployer) {
        this.gmoEmployer = gmoEmployer;
    }

    @Column(name = "gmo_maintenanceplanobservation")
    public String getGmoObservation() {
        return gmoObservation;
    }

    public void setGmoObservation(String gmoObservation) {
        this.gmoObservation = gmoObservation;
    }

    @Column(name = "gmo_maintenanceplandeclaredate")
    public Date getGmoDeclaredDate() {
        return gmoDeclaredDate;
    }

    public void setGmoDeclaredDate(Date gmoDeclaredDate) {
        this.gmoDeclaredDate = gmoDeclaredDate;
    }

    @Column(name = "gmo_maintenanceplandduration")
    public BigDecimal getGmoDuration() {
        return gmoDuration;
    }

    public void setGmoDuration(BigDecimal gmoDuration) {
        this.gmoDuration = gmoDuration;
    }

    @Column(name = "gmo_maintenancedayofmonth")
    public long getGmoDayOfMonth() {
        return gmoDayOfMonth;
    }

    public void setGmoDayOfMonth(long gmoDayOfMonth) {
        this.gmoDayOfMonth = gmoDayOfMonth;
    }
}

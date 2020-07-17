package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gmo_maintenancepreventive")
public class GmoMaintenancePreventive extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1640304759359470684L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_maintenance_preventive_id", allocationSize = 1)
    @Column(name = "gmo_maintenancepreventiveid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long gmoMaintenancePreventiveId;
    @Column(name = "gmo_maintenancepreventivecode", nullable = false, length = 90)
    private String gmoMaintenancePreventiveCode;
    @Column(name = "gmo_maintenancepreventivedescription")
    private String gmoMaintenancePreventiveDescription;
    @Column(name = "gmo_maintenancepreventivestartdate")
    private Date gmoMaintenancePreventiveStartDate;
    @Column(name = "Gmo_Maintenancepreventiveenddate")
    private Date gmoMaintenancePreventiveEndDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenancetypeid")
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
    @JoinColumn(name = "gmo_maintenancestateid")
    private GmoMaintenanceState gmoMaintenanceState;

    @ManyToOne(cascade = CascadeType.MERGE)
    private GmoPatrimony gmoPatrimony;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gmoMaintenancePreventive", orphanRemoval=true)
    private Set<GmoAction> gmoActions = new HashSet<> ();
    @Column(name = "gmo_maintenancepreventivetotalprice")
    private BigDecimal gmoMaintenancePreventiveTotalPrice = BigDecimal.ZERO;
    @Column(name = "gmo_maintenancepreventivemileage")
    private Double gmoMaintenancePreventiveMileage = 0.0;

    @Column(name = "gmo_maintenancepreventivetriggerday")
    private BigDecimal gmoTriggerDay;
    @Column(name = "gmo_maintenancepreventivetriggerdate")
    private Date gmoTriggerDate;

    @Column(name = "gmo_maintenancepreventiveinterventiondate")
    private Date gmoInterventionDate;

    @Column(name = "gmo_maintenancepreventiveagent")
private String gmoAgent ;
    @Column(name = "gmo_maintenancepreventiveemployer")
    private String gmoEmployer ;
    @Column(name = "gmo_maintenancepreventiveobservation")
    private String gmoObservation ;

    @Column(name = "gmo_maintenancepreventivedeclaredate")
    private Date gmoDeclaredDate;

    @Column(name = "gmo_maintenancepreventivedduration")
    private BigDecimal gmoDuration;

    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<GmoDay> gmoDays = new HashSet<>();

    @OneToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<GmoMonth> gmoMonths = new HashSet<>();


    public GmoMaintenancePreventive() {
    }

    public Long getGmoMaintenancePreventiveId() {
        return gmoMaintenancePreventiveId;
    }

    public void setGmoMaintenancePreventiveId(Long gmoMaintenancePreventiveId) {
        this.gmoMaintenancePreventiveId = gmoMaintenancePreventiveId;
    }

    public String getGmoMaintenancePreventiveCode() {
        return gmoMaintenancePreventiveCode;
    }

    public void setGmoMaintenancePreventiveCode(String gmoMaintenancePreventiveCode) {
        this.gmoMaintenancePreventiveCode = gmoMaintenancePreventiveCode;
    }

    public String getGmoMaintenancePreventiveDescription() {
        return gmoMaintenancePreventiveDescription;
    }

    public void setGmoMaintenancePreventiveDescription(String gmoMaintenancePreventiveDescription) {
        this.gmoMaintenancePreventiveDescription = gmoMaintenancePreventiveDescription;
    }


    public Date getGmoMaintenancePreventiveStartDate() {
        return gmoMaintenancePreventiveStartDate;
    }

    public void setGmoMaintenancePreventiveStartDate(Date gmoMaintenancePreventiveStartDate) {
        this.gmoMaintenancePreventiveStartDate = gmoMaintenancePreventiveStartDate;
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

    public Date getGmoMaintenancePreventiveEndDate() {
        return gmoMaintenancePreventiveEndDate;
    }

    public void setGmoMaintenancePreventiveEndDate(Date gmoMaintenancePreventiveEndDate) {
        this.gmoMaintenancePreventiveEndDate = gmoMaintenancePreventiveEndDate;
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

    public BigDecimal getGmoMaintenancePreventiveTotalPrice() {
        return gmoMaintenancePreventiveTotalPrice;
    }

    public void setGmoMaintenancePreventiveTotalPrice(BigDecimal gmoMaintenancePreventiveTotalPrice) {
        this.gmoMaintenancePreventiveTotalPrice = gmoMaintenancePreventiveTotalPrice;
    }

    public void setGmoActions(Set<GmoAction> gmoMaintenanceLines) {
        this.gmoActions = gmoMaintenanceLines;
    }

    public Double getGmoMaintenancePreventiveMileage() {
        return gmoMaintenancePreventiveMileage;
    }

    public void setGmoMaintenancePreventiveMileage(Double gmoMaintenancePreventiveMileage) {
        this.gmoMaintenancePreventiveMileage = gmoMaintenancePreventiveMileage;
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


}

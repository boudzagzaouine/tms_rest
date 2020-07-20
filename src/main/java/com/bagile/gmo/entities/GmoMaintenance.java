package com.bagile.gmo.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "gmo_maintenance")
public class GmoMaintenance extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1640304759359470684L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_maintenance__id", allocationSize = 1)
    @Column(name = "gmo_maintenanceid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long gmoMaintenanceId;
    @Column(name = "gmo_maintenancecode", nullable = false, length = 90)
    private String gmoMaintenanceCode;
    @Column(name = "gmo_maintenancedescription")
    private String gmoMaintenanceDescription;
    @Column(name = "gmo_maintenancestartdate")
    private Date gmoMaintenanceStartDate;
    @Column(name = "Gmo_Maintenanceenddate")
    private Date gmoMaintenanceEndDate;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gmoMaintenance", orphanRemoval=true)
    private Set<GmoAction> gmoActions = new HashSet<> ();
    @Column(name = "gmo_maintenancetotalprice")
    private BigDecimal gmoMaintenanceTotalPrice = BigDecimal.ZERO;
    @Column(name = "gmo_maintenancemileage")
    private Double gmoMaintenanceMileage = 0.0;

    @Column(name = "gmo_maintenancetriggerday")
    private BigDecimal gmoTriggerDay;
    @Column(name = "gmo_maintenancetriggerdate")
    private Date gmoTriggerDate;

    @Column(name = "gmo_maintenanceinterventiondate")
    private Date gmoInterventionDate;

    @Column(name = "gmo_maintenanceagent")
private String gmoAgent ;
    @Column(name = "gmo_maintenanceemployer")
    private String gmoEmployer ;
    @Column(name = "gmo_maintenanceobservation")
    private String gmoObservation ;

    @Column(name = "gmo_maintenancedeclaredate")
    private Date gmoDeclaredDate;

    @Column(name = "gmo_maintenancedduration")
    private BigDecimal gmoDuration;
    public GmoMaintenance() {
    }

    public Long getGmoMaintenanceId() {
        return gmoMaintenanceId;
    }

    public void setGmoMaintenanceId(Long gmoMaintenanceId) {
        this.gmoMaintenanceId = gmoMaintenanceId;
    }

    public String getGmoMaintenanceCode() {
        return gmoMaintenanceCode;
    }

    public void setGmoMaintenanceCode(String gmoMaintenanceCode) {
        this.gmoMaintenanceCode = gmoMaintenanceCode;
    }

    public String getGmoMaintenanceDescription() {
        return gmoMaintenanceDescription;
    }

    public void setGmoMaintenanceDescription(String gmoMaintenanceDescription) {
        this.gmoMaintenanceDescription = gmoMaintenanceDescription;
    }


    public Date getGmoMaintenanceStartDate() {
        return gmoMaintenanceStartDate;
    }

    public void setGmoMaintenanceStartDate(Date gmoMaintenanceStartDate) {
        this.gmoMaintenanceStartDate = gmoMaintenanceStartDate;
    }

    public GmoResponsability getGmoService() {
        return gmoService;
    }

    public void setGmoService(GmoResponsability gmoService) {
        this.gmoService = gmoService;
    }

    public Date getGmoMaintenanceEndDate() {
        return gmoMaintenanceEndDate;
    }

    public void setGmoMaintenanceEndDate(Date gmoMaintenanceEndDate) {
        this.gmoMaintenanceEndDate = gmoMaintenanceEndDate;
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

    public BigDecimal getGmoMaintenanceTotalPrice() {
        return gmoMaintenanceTotalPrice;
    }

    public void setGmoMaintenanceTotalPrice(BigDecimal gmoMaintenanceTotalPrice) {
        this.gmoMaintenanceTotalPrice = gmoMaintenanceTotalPrice;
    }

    public void setGmoActions(Set<GmoAction> gmoMaintenanceLines) {
        this.gmoActions = gmoMaintenanceLines;
    }

    public Double getGmoMaintenanceMileage() {
        return gmoMaintenanceMileage;
    }

    public void setGmoMaintenanceMileage(Double gmoMaintenanceMileage) {
        this.gmoMaintenanceMileage = gmoMaintenanceMileage;
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

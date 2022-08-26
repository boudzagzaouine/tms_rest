package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne()
    private GmoPatrimony gmoPatrimony;


    @Column(name = "gmo_maintenancetotalprice")
    private BigDecimal gmoMaintenanceTotalPrice = BigDecimal.ZERO;
    @Column(name = "gmo_maintenancemileage")
    private Double gmoMaintenanceMileage = 0.0;
    @Column(name = "gmo_maintenancemileagenext")
    private Double gmoMaintenanceMileageNext = 0.0;

    @Column(name = "gmo_maintenancetriggerday")
    private BigDecimal gmoTriggerDay;
    @Column(name = "gmo_maintenancetriggerdate")
    private Date gmoTriggerDate;

    @Column(name = "gmo_maintenanceinterventiondate")
    private Date gmoInterventionDate;

    @Column(name = "gmo_maintenancemaintenancedate")
    private Date gmoMaintenanceDate;

    /*@Column(name = "gmo_maintenanceagent")
    private String gmoAgent ;*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenanceagentid")
    private GmoAgent gmoAgent;

    @Column(name = "gmo_maintenanceemployer")
    private String gmoEmployer ;
    @Column(name = "gmo_maintenanceobservation")
    private String gmoObservation ;

    @Column(name = "gmo_maintenancedeclaredate")
    private Date gmoDeclaredDate;

    @Column(name = "gmo_maintenancedduration")
    private BigDecimal gmoDuration;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenanceplanid")
    private GmoMaintenancePlan gmoMaintenancePlan;

    @OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL,CascadeType.MERGE},mappedBy = "gmoMaintenance", orphanRemoval=true)
    private Set<GmoActionLineMaintenance> gmoActionLineMaintenances = new HashSet<> ();
    //private Set<GmoActionMaintenance> gmoActionMaintenances = new HashSet<> ();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_actiontypeid")
    private GmoActionType gmoActionType;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    @JoinColumn(name = "gmo_conditionaltypeid")
    private GmoConditionalType gmoConditionalType;

    @Column(name = "gmo_maintenancevalueconditionaltype")
    private BigDecimal gmoMaintenanceValueconditionalType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_supplierid")
    private RcpSupplier rcpSupplier;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_purchaseorderid")
    private RcpPurshaseOrder rcpPurshaseOrder;
    @ManyToOne()
    @JoinColumn(name = "gmo_ownownerid")
      private OwnOwner ownOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_driverid")
    private GmoDriver gmoDriver;

    @Column(name = "gmo_maintenancebloking")
    private String blocking;
    public GmoMaintenance() {
    }


    public GmoDriver getGmoDriver() {
        return gmoDriver;
    }

    public void setGmoDriver(GmoDriver gmoDriver) {
        this.gmoDriver = gmoDriver;
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

    public String getBlocking() {
        return blocking;
    }

    public void setBlocking(String blocking) {
        this.blocking = blocking;
    }

    public String getGmoMaintenanceDescription() {
        return gmoMaintenanceDescription;
    }

    public void setGmoMaintenanceDescription(String gmoMaintenanceDescription) {
        this.gmoMaintenanceDescription = gmoMaintenanceDescription;
    }

    public GmoConditionalType getGmoConditionalType() {
        return gmoConditionalType;
    }

    public void setGmoConditionalType(GmoConditionalType gmoConditionalType) {
        this.gmoConditionalType = gmoConditionalType;
    }

    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    public BigDecimal getGmoMaintenanceValueconditionalType() {
        return gmoMaintenanceValueconditionalType;
    }

    public void setGmoMaintenanceValueconditionalType(BigDecimal gmoActionPlanValueconditionalType) {
        this.gmoMaintenanceValueconditionalType = gmoActionPlanValueconditionalType;
    }

    public Date getGmoMaintenanceDate() {
        return gmoMaintenanceDate;
    }

    public void setGmoMaintenanceDate(Date gmoMaintenanceDate) {
        this.gmoMaintenanceDate = gmoMaintenanceDate;
    }

    public RcpSupplier getRcpSupplier() {
        return rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    public RcpPurshaseOrder getRcpPurshaseOrder() {
        return rcpPurshaseOrder;
    }

    public void setRcpPurshaseOrder(RcpPurshaseOrder rcpPurshaseOrder) {
        this.rcpPurshaseOrder = rcpPurshaseOrder;
    }

    public GmoActionType getGmoActionType() {
        return gmoActionType;
    }

    public void setGmoActionType(GmoActionType gmoActionType) {
        this.gmoActionType = gmoActionType;
    }

    public Set<GmoActionLineMaintenance> getGmoActionLineMaintenances() {
        return gmoActionLineMaintenances;
    }

    public void setGmoActionLineMaintenances(Set<GmoActionLineMaintenance> gmoActionLineMaintenances) {
        this.gmoActionLineMaintenances = gmoActionLineMaintenances;
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

    public Double getGmoMaintenanceMileageNext() {
        return gmoMaintenanceMileageNext;
    }

    public void setGmoMaintenanceMileageNext(Double gmoMaintenanceMileageNext) {
        this.gmoMaintenanceMileageNext = gmoMaintenanceMileageNext;
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

   /* public Set<GmoActionMaintenance> getGmoActionMaintenances() {
        return gmoActionMaintenances;
    }

    public void setGmoActionMaintenances(Set<GmoActionMaintenance> gmoActionMaintenances) {
        this.gmoActionMaintenances = gmoActionMaintenances;
    }*/

    public BigDecimal getGmoMaintenanceTotalPrice() {
        return gmoMaintenanceTotalPrice;
    }

    public void setGmoMaintenanceTotalPrice(BigDecimal gmoMaintenanceTotalPrice) {
        this.gmoMaintenanceTotalPrice = gmoMaintenanceTotalPrice;
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


    /*public String getGmoAgent() {
        return gmoAgent;
    }

    public void setGmoAgent(String gmoAgent) {
        this.gmoAgent = gmoAgent;
    }*/

    public GmoAgent getGmoAgent() {
        return gmoAgent;
    }

    public void setGmoAgent(GmoAgent gmoAgent) {
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


    public GmoMaintenancePlan getGmoMaintenancePlan() {
        return gmoMaintenancePlan;
    }

    public void setGmoMaintenancePlan(GmoMaintenancePlan gmoMaintenancePlan) {
        this.gmoMaintenancePlan = gmoMaintenancePlan;
    }
}

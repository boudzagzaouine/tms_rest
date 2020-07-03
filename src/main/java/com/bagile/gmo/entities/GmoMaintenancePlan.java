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
@Table(name = "gmo_maintenanceplan")
public class GmoMaintenancePlan extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1640304759359470684L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_maintenance_plan_id", allocationSize = 1)
    @Column(name = "gmo_maintenanceplanid", unique = true, nullable = false, precision = 10, scale = 0)
    private Long gmoMaintenancePlanId;
    @Column(name = "gmo_maintenanceplancode", unique = true, nullable = false, length = 90)
    private String gmoMaintenancePlanCode;
    @Column(name = "gmo_maintenanceplandescription")
    private String gmoMaintenancePlanDescription;
    @Column(name = "gmo_maintenanceplanstartdate")
    private Date gmoMaintenancePlanStartDate;
    @Column(name = "Gmo_Maintenanceplanenddate")
    private Date gmoMaintenancePlanEndDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenancetypeid")
    private GmoMaintenanceType gmoMaintenanceType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_programetypeid")
    private GmoProgramType gmoProgramType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_operationtypeid")
    private GmoOperationType gmoOperationType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_serviceproviderid")
    private GmoServiceProvider gmoServiceProvider;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_responsabilityid")
    private GmoResponsability gmoResponsability;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_periodicitytypeid")
    private GmoPeriodicityType gmoPeriodicityType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenancestateid")
    private GmoMaintenanceState gmoMaintenanceState;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private GmoPatrimony gmoPatrimony;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gmoMaintenancePlan")
    private Set<GmoMaintenanceLine> gmoMaintenanceLines = new HashSet<> ();
    @Column(name = "gmo_maintenanceplantotalprice")
    private BigDecimal gmoMaintenancePlanTotalPrice = BigDecimal.ZERO;
    @Column(name = "gmo_maintenanceplanmileage")
    private Double gmoMaintenancePlanMileage = 0.0;


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

    public GmoOperationType getGmoOperationType() {
        return gmoOperationType;
    }

    public void setGmoOperationType(GmoOperationType gmoOperationType) {
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

    public Set<GmoMaintenanceLine> getGmoMaintenanceLines() {
        return gmoMaintenanceLines;
    }

    public BigDecimal getGmoMaintenancePlanTotalPrice() {
        return gmoMaintenancePlanTotalPrice;
    }

    public void setGmoMaintenancePlanTotalPrice(BigDecimal gmoMaintenancePlanTotalPrice) {
        this.gmoMaintenancePlanTotalPrice = gmoMaintenancePlanTotalPrice;
    }

    public void setGmoMaintenanceLines(Set<GmoMaintenanceLine> gmoMaintenanceLines) {
        this.gmoMaintenanceLines = gmoMaintenanceLines;
    }

    public Double getGmoMaintenancePlanMileage() {
        return gmoMaintenancePlanMileage;
    }

    public void setGmoMaintenancePlanMileage(Double gmoMaintenancePlanMileage) {
        this.gmoMaintenancePlanMileage = gmoMaintenancePlanMileage;
    }
}

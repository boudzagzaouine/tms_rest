package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Maintenance extends EmsDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6036580510935986433L;
    private long id;
    private String code;
    private String description;
    private Date startDate;
    private Date endDate;
    private MaintenanceType maintenanceType;
    private ProgramType programType;
    private ServiceProvider serviceProvider;
    private Responsability responsability;
    private Responsability service;
    private PeriodicityType periodicityType;
    private MaintenanceState maintenanceState;
    private BigDecimal triggerDay;
    private Date triggerDate;
    private Date interventionDate;
    private Date maintenanceDate;
    private Patrimony patrimony;
    private Double mileage = 0.0;
    private Double mileageNext = 0.0;
    private BigDecimal totalPrice;
   // private List<ActionMaintenance> actionMaintenances;
    private  String  agent ;
    private   String  employer ;
    private   String  observation;
    private Date declaredDate;
    private BigDecimal duration;
    private MaintenancePlan maintenancePlan ;
    private ActionType actionType ;
     private List<ActionLineMaintenance> actionLineMaintenances;
    private ConditionalType conditionalType;
    private BigDecimal valueconditionalType;

    private Supplier supplier;
    private PurshaseOrder purshaseOrder;

    public Maintenance() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public MaintenanceType getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(MaintenanceType maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public MaintenanceState getMaintenanceState() {
        return maintenanceState;
    }

    public void setMaintenanceState(MaintenanceState maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public PurshaseOrder getPurshaseOrder() {
        return purshaseOrder;
    }

    public void setPurshaseOrder(PurshaseOrder purshaseOrder) {
        this.purshaseOrder = purshaseOrder;
    }

    public Patrimony getPatrimony() {
        return patrimony;
    }

    public void setPatrimony(Patrimony patrimony) {
        this.patrimony = patrimony;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Double getMileageNext() {
        return mileageNext;
    }

    public void setMileageNext(Double mileageNext) {
        this.mileageNext = mileageNext;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public List<ActionLineMaintenance> getActionLineMaintenances() {
        return actionLineMaintenances;
    }

    public void setActionLineMaintenances(List<ActionLineMaintenance> actionLineMaintenances) {
        this.actionLineMaintenances = actionLineMaintenances;
    }

    public ConditionalType getConditionalType() {
        return conditionalType;
    }

    public void setConditionalType(ConditionalType conditionalType) {
        this.conditionalType = conditionalType;
    }

    public BigDecimal getValueconditionalType() {
        return valueconditionalType;
    }

    public void setValueconditionalType(BigDecimal valueconditionalType) {
        this.valueconditionalType = valueconditionalType;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    /*public List<ActionMaintenance> getActionMaintenances() {
        return actionMaintenances;
    }

    public void setActionMaintenances(List<ActionMaintenance> actionMaintenances) {
        this.actionMaintenances = actionMaintenances;
    }*/

    public ProgramType getProgramType() {
        return programType;
    }

    public void setProgramType(ProgramType programType) {
        this.programType = programType;
    }

    public Responsability getService() {
        return service;
    }

    public void setService(Responsability service) {
        this.service = service;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public Responsability getResponsability() {
        return responsability;
    }

    public void setResponsability(Responsability responsability) {
        this.responsability = responsability;
    }

    public PeriodicityType getPeriodicityType() {
        return periodicityType;
    }

    public void setPeriodicityType(PeriodicityType periodicityType) {
        this.periodicityType = periodicityType;
    }



    public BigDecimal getTriggerDay() {
        return triggerDay;
    }

    public void setTriggerDay(BigDecimal triggerDay) {
        this.triggerDay = triggerDay;
    }

    public Date getInterventionDate() {
        return interventionDate;
    }

    public void setInterventionDate(Date interventionDate) {
        this.interventionDate = interventionDate;
    }

    public Date getTriggerDate() {
        return triggerDate;
    }

    public void setTriggerDate(Date triggerDate) {
        this.triggerDate = triggerDate;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getDeclaredDate() {
        return declaredDate;
    }

    public void setDeclaredDate(Date declaredDate) {
        this.declaredDate = declaredDate;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public MaintenancePlan getMaintenancePlan() {
        return maintenancePlan;
    }

    public void setMaintenancePlan(MaintenancePlan maintenancePlan) {
        this.maintenancePlan = maintenancePlan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        Maintenance that = (Maintenance) o;
        return getId ( ) == that.getId ( );
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId ( ));
    }
}

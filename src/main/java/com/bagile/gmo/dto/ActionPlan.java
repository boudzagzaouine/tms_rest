package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ActionPlan extends EmsDto implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6036580510935986433L;
    private long id;
    private Date startDate;
    private Date endDate;
    private MaintenanceType maintenanceType;
    private ProgramType programType;
    private ServiceProvider serviceProvider;
    private Responsability responsability;
    private Responsability service;
    private PeriodicityType periodicityType;
    private BigDecimal triggerDay;
    private Date triggerDate;
    private Date interventionDate;
    private Double mileage = 0.0;
    private BigDecimal totalPrice;
   // private  String  agent ;
    private Agent agent;
    private   String  employer ;
    private   String  observation;
    private Date declaredDate;
    private BigDecimal duration;
    private long dayOfMonth;
    private List<Month>months = new ArrayList<>();
    private List<Day> days    = new ArrayList<>();
    private MaintenancePlan maintenancePlan;
    private ActionType actionType ;
 private ConditionalType conditionalType;
 private BigDecimal valueconditionalType;
 private Owner owner;

 private String blocking;

    public ActionPlan() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getBlocking() {
        return blocking;
    }

    public void setBlocking(String blocking) {
        this.blocking = blocking;
    }

    public MaintenanceType getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(MaintenanceType maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

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

   /* public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }*/

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
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


    public List<Month> getMonths() {
        return months;
    }

    public void setMonths(List<Month> months) {
        this.months = months;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public long getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(long dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public MaintenancePlan getMaintenancePlan() {
        return maintenancePlan;
    }

    public void setMaintenancePlan(MaintenancePlan maintenancePlan) {
        this.maintenancePlan = maintenancePlan;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass ( ) != o.getClass ( )) return false;
        ActionPlan that = (ActionPlan) o;
        return getId ( ) == that.getId ( );
    }

    @Override
    public int hashCode() {
        return Objects.hash (getId ( ));
    }
}

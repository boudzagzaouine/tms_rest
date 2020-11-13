package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ActionPlan;
import com.bagile.gmo.entities.GmoActionPlan;

import java.util.*;

public class ActionPlanMapper {
    public ActionPlanMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoActionPlanId");
        map.put("startDate", "gmoActionPlanStartDate");
        map.put("endDate", "gmoActionPlanEndDate");
        map.put("actionPlanType", "gmoActionPlanType");
        map.put("programType", "gmoProgramType");
        map.put("serviceProvider", "gmoServiceProvider");
        map.put("responsability", "gmoResponsability");
        map.put("service", "gmoService");
        map.put("periodicityType", "gmoPeriodicityType");
        map.put("triggerDay", "gmoActionPlanTriggerDay");
        map.put("triggerDate", "gmoActionPlanTriggerDate");
        map.put("interventionDate", "gmoActionPlanInterventionDate");
        map.put("mileage", "gmoActionPlanMileage");
        map.put("totalPrice", "gmoActionPlanTotalPrice");
        map.put("agent", "gmoActionPlanAgent");
        map.put("employer", "gmoActionPlanEmployer");
        map.put("observation", "gmoActionPlanObservation");
        map.put("declaredDate", "gmoActionPlanDeclaredDate");
        map.put("duration", "gmoActionPlanDuration");
        map.put("dayOfMonth", "gmoActionPlanDayOfMonth");
        map.put("months", "gmoMonths");
        map.put("days", "gmoDays");
        map.put("ActionPlan", "GmoActionPlan");
        map.put("actionType", "gmoActionType");

        map.put("conditionalType", "gmoConditionalType");
        map.put("valueconditionalType", "gmoActionPlanValueconditionalType");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");


    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoActionPlan toEntity(ActionPlan actionPlan, boolean lazy) {
        if (null == actionPlan) {
            return null;
        }
        GmoActionPlan gmoActionPlan = new GmoActionPlan();
        gmoActionPlan.setGmoActionPlanId(actionPlan.getId());
        gmoActionPlan.setGmoActionPlanStartDate(actionPlan.getStartDate ());
        gmoActionPlan.setGmoActionPlanEndDate(actionPlan.getEndDate ());
        gmoActionPlan.setGmoActionPlanTotalPrice (actionPlan.getTotalPrice ());
        gmoActionPlan.setGmoActionPlanMileage (actionPlan.getMileage ());
        gmoActionPlan.setGmoActionPlanInterventionDate (actionPlan.getInterventionDate ());
        gmoActionPlan.setGmoActionPlanAgent (actionPlan.getAgent ());
        gmoActionPlan.setGmoActionPlanEmployer (actionPlan.getEmployer ());
        gmoActionPlan.setGmoActionPlanTriggerDay(actionPlan.getTriggerDay());
        gmoActionPlan.setGmoActionPlanTriggerDate(actionPlan.getTriggerDate());
        gmoActionPlan.setGmoActionPlanDeclaredDate(actionPlan.getDeclaredDate());
        gmoActionPlan.setGmoActionPlanObservation(actionPlan.getObservation());
        gmoActionPlan.setGmoActionPlanDayOfMonth(actionPlan.getDayOfMonth());
        gmoActionPlan.setGmoActionPlanInterventionDate(actionPlan.getInterventionDate());
        gmoActionPlan.setGmoActionPlanValueconditionalType(actionPlan.getValueconditionalType());

        gmoActionPlan.setGmoActionPlanDuration(actionPlan.getDuration());
        gmoActionPlan.setCreatedBy(actionPlan.getCreatedBy());
        gmoActionPlan.setUpdatedBy(actionPlan.getUpdatedBy());
        gmoActionPlan.setCreationDate(actionPlan.getCreationDate());
        gmoActionPlan.setUpdateDate(actionPlan.getUpdateDate());

        if (!lazy) {

            gmoActionPlan.setGmoPeriodicityType(PeriodicityTypeMapper.toEntity(actionPlan.getPeriodicityType(),false));
            gmoActionPlan.setGmoResponsability (ResponsabilityMapper.toEntity (actionPlan.getResponsability(), false));
            gmoActionPlan.setGmoServiceProvider(ServiceProviderMapper.toEntity(actionPlan.getServiceProvider(),false));
            gmoActionPlan.setGmoService (ResponsabilityMapper.toEntity (actionPlan.getService(), false));
            gmoActionPlan.setGmoProgramType(ProgramTypeMapper.toEntity(actionPlan.getProgramType(),false));
            gmoActionPlan.setGmoMonths(MonthMapper.toEntities (actionPlan.getMonths(), false));
            gmoActionPlan.setGmoDays(DayMapper.toEntities (actionPlan.getDays(), false));
            gmoActionPlan.setGmoMaintenancePlan(MaintenancePlanMapper.toEntity (actionPlan.getMaintenancePlan(), false));
            gmoActionPlan.setGmoMaintenanceType(MaintenanceTypeMapper.toEntity (actionPlan.getMaintenanceType(), false));

            gmoActionPlan.setGmoActionType(ActionTypeMapper.toEntity (actionPlan.getActionType(), false));
            gmoActionPlan.setGmoConditionalType(ConditionalTypeMapper.toEntity (actionPlan.getConditionalType(), false));

            // oneToMany(gmoActionPlan);

        }
        return gmoActionPlan;
    }
 /*   private static void oneToMany(GmoActionPlan GmoActionPlan) {
     //  if(null !=GmoActionPlan.getGmoActions()){
        GmoActionPlan.getGmoActions().forEach(
                e -> {
                   // if(0 >= GmoActionPlan.getGmoActionPlanId()) {
                    //   e.setGmoActionId(0);
                        e.setCreationDate(EmsDate.getDateNow());
                        e.setGmoActionPlan(GmoActionPlan);
                   // }
                }
        );}
   // }*/

    public static ActionPlan toDto(GmoActionPlan gmoActionPlan, boolean lazy) {
        if (null == gmoActionPlan) {
            return null;
        }
        ActionPlan actionPlan = new ActionPlan();
        actionPlan.setId(gmoActionPlan.getGmoActionPlanId());
        actionPlan.setStartDate (gmoActionPlan.getGmoActionPlanStartDate());
        actionPlan.setEndDate (gmoActionPlan.getGmoActionPlanEndDate());
        actionPlan.setTotalPrice (gmoActionPlan.getGmoActionPlanTotalPrice ());
        actionPlan.setMileage (gmoActionPlan.getGmoActionPlanMileage ());
        actionPlan.setTriggerDay(gmoActionPlan.getGmoActionPlanTriggerDay());
        actionPlan.setTriggerDate(gmoActionPlan.getGmoActionPlanTriggerDate());
        actionPlan.setInterventionDate (gmoActionPlan.getGmoActionPlanInterventionDate ());
        actionPlan.setAgent (gmoActionPlan.getGmoActionPlanAgent ());
        actionPlan.setEmployer (gmoActionPlan.getGmoActionPlanEmployer ());
        actionPlan.setDuration (gmoActionPlan.getGmoActionPlanDuration ()  );
        actionPlan.setDeclaredDate (gmoActionPlan.getGmoActionPlanDeclaredDate ());
        actionPlan.setObservation (gmoActionPlan.getGmoActionPlanObservation ());
        actionPlan.setDayOfMonth (gmoActionPlan.getGmoActionPlanDayOfMonth ());
        actionPlan.setCreatedBy(gmoActionPlan.getCreatedBy());
        actionPlan.setUpdatedBy(gmoActionPlan.getUpdatedBy());
        actionPlan.setCreationDate(gmoActionPlan.getCreationDate());
        actionPlan.setUpdateDate(gmoActionPlan.getUpdateDate());
        actionPlan.setValueconditionalType(gmoActionPlan.getGmoActionPlanValueconditionalType());


        if (!lazy) {


            actionPlan.setPeriodicityType(PeriodicityTypeMapper.toDto(gmoActionPlan.getGmoPeriodicityType(),false));
            actionPlan.setResponsability (ResponsabilityMapper.toDto (gmoActionPlan.getGmoResponsability (), true));
            actionPlan.setServiceProvider(ServiceProviderMapper.toDto(gmoActionPlan.getGmoServiceProvider(),true));
            actionPlan.setMaintenanceType(MaintenanceTypeMapper.toDto(gmoActionPlan.getGmoMaintenanceType(),true));

            actionPlan.setService(ResponsabilityMapper.toDto (gmoActionPlan.getGmoService (), true));
            actionPlan.setProgramType(ProgramTypeMapper.toDto(gmoActionPlan.getGmoProgramType(),false));
            actionPlan.setDays(DayMapper.toDtos(gmoActionPlan.getGmoDays(),true));
            actionPlan.setMonths(MonthMapper.toDtos(gmoActionPlan.getGmoMonths(),false));
            actionPlan.setMaintenancePlan(MaintenancePlanMapper.toDto(gmoActionPlan.getGmoMaintenancePlan(),true));
            actionPlan.setActionType(ActionTypeMapper.toDto(gmoActionPlan.getGmoActionType(),false));
            actionPlan.setConditionalType(ConditionalTypeMapper.toDto(gmoActionPlan.getGmoConditionalType(),false));

        }

        return actionPlan;
    }

    public static List<ActionPlan> toDtos(Iterable<? extends GmoActionPlan> mntactionPlans, boolean lazy) {
        if (null == mntactionPlans) {
            return null;
        }
        List<ActionPlan> actionPlans = new ArrayList<>();
        for (GmoActionPlan gmoActionPlan : mntactionPlans) {
            actionPlans.add(toDto(gmoActionPlan, lazy));
        }
        return actionPlans;
    }

    public static Set<GmoActionPlan> toEntities(List<? extends ActionPlan> actionPlans, boolean lazy) {
        if (null == actionPlans) {
            return null;
        }
        Set<GmoActionPlan> gmoActionPlans = new HashSet<>();

        for (ActionPlan actionPlan : actionPlans) {
            gmoActionPlans.add(toEntity(actionPlan, lazy));
        }
        return gmoActionPlans;
    }

   /* public static Set<ActionPlan> toDtos(Set<? extends GmoActionPlan> gmoActionPlans, boolean lazy) {
        if (null == gmoActionPlans) {
            return null;
        }
        Set<ActionPlan> actionPlans = new HashSet<>();
        for (GmoActionPlan gmoActionPlan : gmoActionPlans) {
            actionPlans.add(toDto(gmoActionPlan, lazy));
        }
        return actionPlans;
    }*/

}

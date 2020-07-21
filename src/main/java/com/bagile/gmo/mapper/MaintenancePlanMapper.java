package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.entities.GmoMaintenancePlan;

import java.util.*;

public class MaintenancePlanMapper {
    public MaintenancePlanMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoMaintenanceId");
        map.put("code", "gmoMaintenanceCode");
        map.put("description", "gmoMaintenanceDescription");
        map.put("beginDate", "gmoMaintenanceStartDate");
        map.put("endDate", "gmoMaintenanceEndDate");
        map.put("maintenanceType", "gmoMaintenanceType");
        map.put("maintenanceState", "gmoMaintenanceState");
        map.put("programType", "gmoMaintenanceType");
        map.put("operationType", "gmoOperationType");
        map.put("serviceProvider", "gmoServiceProvider");
        map.put("responsability", "gmoResponsability");
        map.put("service", "gmoService");
        map.put("periodicityType", "gmoPeriodicityType");
        map.put("triggerDay", "gmoTriggerDay");
        map.put("triggerDate", "gmoTriggerDate");
        map.put("interventionDate", "gmoInterventionDate");
        map.put("patrimony", "gmoPatrimony");
        map.put("totalPrice", "gmoMaintenanceTotalPrice");
        map.put("declaredDate", "gmoDeclaredDate");
        map.put("observation", "gmoObservation");
        map.put("duration", "gmoDuration");
        map.put("creationDate", "creationDate");
        map.put("months", "gmoMonths");
        map.put("days", "gmoDays");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");
        map.put("agent", "gmoAgent");
        map.put("employer", "gmoEmployer");
        map.put("dayOfMonth", "gmoDayOfMonth");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoMaintenancePlan toEntity(MaintenancePlan maintenance, boolean lazy) {
        if (null == maintenance) {
            return null;
        }
        GmoMaintenancePlan gmoMaintenance = new GmoMaintenancePlan();
        gmoMaintenance.setGmoMaintenancePlanId(maintenance.getId());
        gmoMaintenance.setGmoMaintenancePlanCode(maintenance.getCode() != null ? maintenance.getCode().toUpperCase() : null);
        gmoMaintenance.setGmoMaintenancePlanDescription(maintenance.getDescription());
        gmoMaintenance.setGmoMaintenancePlanStartDate(maintenance.getStartDate ());
        gmoMaintenance.setGmoMaintenancePlanEndDate(maintenance.getEndDate ());
        gmoMaintenance.setGmoMaintenancePlanTotalPrice (maintenance.getTotalPrice ());
        gmoMaintenance.setGmoMaintenancePlanMileage (maintenance.getMileage ());
        gmoMaintenance.setGmoInterventionDate (maintenance.getInterventionDate ());
        gmoMaintenance.setGmoAgent (maintenance.getAgent ());
        gmoMaintenance.setGmoEmployer (maintenance.getEmployer ());
        gmoMaintenance.setGmoTriggerDay(maintenance.getTriggerDay());
        gmoMaintenance.setGmoTriggerDate(maintenance.getTriggerDate());
        gmoMaintenance.setGmoDeclaredDate(maintenance.getDeclaredDate());
        gmoMaintenance.setGmoObservation(maintenance.getObservation());
        gmoMaintenance.setGmoDayOfMonth(maintenance.getDayOfMonth());

        gmoMaintenance.setGmoDuration(maintenance.getDuration());
        gmoMaintenance.setCreatedBy(maintenance.getCreatedBy());
        gmoMaintenance.setUpdatedBy(maintenance.getUpdatedBy());
        gmoMaintenance.setCreationDate(maintenance.getCreationDate());
        gmoMaintenance.setUpdateDate(maintenance.getUpdateDate());

        if (!lazy) {
            gmoMaintenance.setGmoMaintenanceType(MaintenanceTypeMapper.toEntity(maintenance.getMaintenanceType(), true));
            gmoMaintenance.setGmoMaintenanceState(MaintenanceStateMapper.toEntity(maintenance.getMaintenanceState(), true));
            gmoMaintenance.setGmoPatrimony(PatrimonyMapper.toEntity(maintenance.getPatrimony(),true));
            gmoMaintenance.setGmoActions(ActionMapper.toEntities (maintenance.getActions(), false));

            gmoMaintenance.setGmoPeriodicityType(PeriodicityTypeMapper.toEntity(maintenance.getPeriodicityType(),false));
            gmoMaintenance.setGmoResponsability (ResponsabilityMapper.toEntity (maintenance.getResponsability(), false));
            gmoMaintenance.setGmoServiceProvider(ServiceProviderMapper.toEntity(maintenance.getServiceProvider(),false));
            gmoMaintenance.setGmoService (ResponsabilityMapper.toEntity (maintenance.getService(), false));
            gmoMaintenance.setGmoProgramType(ProgramTypeMapper.toEntity(maintenance.getProgramType(),false));
            gmoMaintenance.setGmoMonths(MonthMapper.toEntities (maintenance.getMonths(), false));
            gmoMaintenance.setGmoDays(DayMapper.toEntities (maintenance.getDays(), false));

        }
        return gmoMaintenance;
    }

    public static MaintenancePlan toDto(GmoMaintenancePlan gmoMaintenance, boolean lazy) {
        if (null == gmoMaintenance) {
            return null;
        }
        MaintenancePlan maintenance = new MaintenancePlan();
        maintenance.setId(gmoMaintenance.getGmoMaintenancePlanId());
        maintenance.setCode(gmoMaintenance.getGmoMaintenancePlanCode());
        maintenance.setDescription(gmoMaintenance.getGmoMaintenancePlanDescription());
        maintenance.setStartDate (gmoMaintenance.getGmoMaintenancePlanStartDate());
        maintenance.setEndDate (gmoMaintenance.getGmoMaintenancePlanEndDate());
        maintenance.setTotalPrice (gmoMaintenance.getGmoMaintenancePlanTotalPrice ());
        maintenance.setMileage (gmoMaintenance.getGmoMaintenancePlanMileage ());

        maintenance.setTriggerDay(gmoMaintenance.getGmoTriggerDay());
        maintenance.setTriggerDate(gmoMaintenance.getGmoTriggerDate());
        maintenance.setInterventionDate (gmoMaintenance.getGmoInterventionDate ());
        maintenance.setAgent (gmoMaintenance.getGmoAgent ());
        maintenance.setEmployer (gmoMaintenance.getGmoEmployer ());
        maintenance.setDuration (gmoMaintenance.getGmoDuration ()  );
        maintenance.setDeclaredDate (gmoMaintenance.getGmoDeclaredDate ());
        maintenance.setObservation (gmoMaintenance.getGmoObservation ());
        maintenance.setDayOfMonth (gmoMaintenance.getGmoDayOfMonth ());


        maintenance.setCreatedBy(gmoMaintenance.getCreatedBy());
        maintenance.setUpdatedBy(gmoMaintenance.getUpdatedBy());
        maintenance.setCreationDate(gmoMaintenance.getCreationDate());
        maintenance.setUpdateDate(gmoMaintenance.getUpdateDate());


        if (!lazy) {
            maintenance.setMaintenanceType(MaintenanceTypeMapper.toDto(gmoMaintenance.getGmoMaintenanceType(), true));
            maintenance.setMaintenanceState(MaintenanceStateMapper.toDto(gmoMaintenance.getGmoMaintenanceState(), true));
            maintenance.setPatrimony(PatrimonyMapper.toDto(gmoMaintenance.getGmoPatrimony(),true));
            maintenance.setActions (ActionMapper.toDtos (gmoMaintenance.getGmoActions(), false));

            maintenance.setPeriodicityType(PeriodicityTypeMapper.toDto(gmoMaintenance.getGmoPeriodicityType(),true));
            maintenance.setResponsability (ResponsabilityMapper.toDto (gmoMaintenance.getGmoResponsability (), true));
            maintenance.setServiceProvider(ServiceProviderMapper.toDto(gmoMaintenance.getGmoServiceProvider(),true));
            maintenance.setService(ResponsabilityMapper.toDto (gmoMaintenance.getGmoService (), true));
            maintenance.setProgramType(ProgramTypeMapper.toDto(gmoMaintenance.getGmoProgramType(),true));
            maintenance.setDays(DayMapper.toDtos(gmoMaintenance.getGmoDays(),true));
            maintenance.setMonths(MonthMapper.toDtos(gmoMaintenance.getGmoMonths(),false));

        }

        return maintenance;
    }

    public static List<MaintenancePlan> toDtos(Iterable<? extends GmoMaintenancePlan> mntMaintenances, boolean lazy) {
        if (null == mntMaintenances) {
            return null;
        }
        List<MaintenancePlan> maintenances = new ArrayList<>();
        for (GmoMaintenancePlan gmoMaintenance : mntMaintenances) {
            maintenances.add(toDto(gmoMaintenance, lazy));
        }
        return maintenances;
    }

    public static Set<GmoMaintenancePlan> toEntities(Set<? extends MaintenancePlan> maintenances, boolean lazy) {
        if (null == maintenances) {
            return null;
        }
        Set<GmoMaintenancePlan> gmoMaintenances = new HashSet<>();

        for (MaintenancePlan maintenance : maintenances) {
            gmoMaintenances.add(toEntity(maintenance, lazy));
        }
        return gmoMaintenances;
    }

    public static Set<MaintenancePlan> toDtos(Set<? extends GmoMaintenancePlan> gmoMaintenances, boolean lazy) {
        if (null == gmoMaintenances) {
            return null;
        }
        Set<MaintenancePlan> maintenances = new HashSet<>();
        for (GmoMaintenancePlan gmoMaintenance : gmoMaintenances) {
            maintenances.add(toDto(gmoMaintenance, lazy));
        }
        return maintenances;
    }

}

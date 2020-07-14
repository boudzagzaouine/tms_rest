package com.bagile.gmo.mapper;

import java.util.*;

import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.entities.GmoMaintenancePlan;

public class MaintenancePlanMapper {
    public MaintenancePlanMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoMaintenancePlanId");
        map.put("code", "gmoMaintenancePlanCode");
        map.put("description", "gmoMaintenancePlanDescription");
        map.put("beginDate", "gmoMaintenancePlanStartDate");
        map.put("endDate", "gmoMaintenancePlanEndDate");
        map.put("maintenanceType", "gmoMaintenanceType");
        map.put("maintenanceState", "gmoMaintenanceState");
        map.put("programType", "gmoMaintenanceType");
        map.put("operationType", "gmoOperationType");
        map.put("serviceProvider", "gmoServiceProvider");
        map.put("responsability", "gmoResponsability");
        map.put("service", "gmoService");
        map.put("periodicityType", "gmoPeriodicityType");
        map.put("alert", "gmoAlert");
        map.put("triggerDate", "gmoTriggerDate");
        map.put("interventionDate", "gmoInterventionDate");
        map.put("patrimony", "gmoPatrimony");
        map.put("totalPrice", "gmoMaintenancePlanTotalPrice");
        map.put("declaredDate", "gmoDeclaredDate");
        map.put("observation", "gmoObservation");
        map.put("duration", "gmoDuration");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");

        map.put("agent", "gmoAgent");
        map.put("employer", "gmoEmployer");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoMaintenancePlan toEntity(MaintenancePlan maintenancePlan, boolean lazy) {
        if (null == maintenancePlan) {
            return null;
        }
        GmoMaintenancePlan gmoMaintenancePlan = new GmoMaintenancePlan();
        gmoMaintenancePlan.setGmoMaintenancePlanId(maintenancePlan.getId());
        gmoMaintenancePlan.setGmoMaintenancePlanCode(maintenancePlan.getCode() != null ? maintenancePlan.getCode().toUpperCase() : null);
        gmoMaintenancePlan.setGmoMaintenancePlanDescription(maintenancePlan.getDescription());
        gmoMaintenancePlan.setGmoMaintenancePlanStartDate(maintenancePlan.getStartDate ());
        gmoMaintenancePlan.setGmoMaintenancePlanEndDate(maintenancePlan.getEndDate ());
        gmoMaintenancePlan.setGmoMaintenancePlanTotalPrice (maintenancePlan.getTotalPrice ());
        gmoMaintenancePlan.setGmoMaintenancePlanMileage (maintenancePlan.getMileage ());
        gmoMaintenancePlan.setGmoInterventionDate (maintenancePlan.getInterventionDate ());
        gmoMaintenancePlan.setGmoAgent (maintenancePlan.getAgent ());
        gmoMaintenancePlan.setGmoEmployer (maintenancePlan.getEmployer ());
        gmoMaintenancePlan.setGmoAlert(maintenancePlan.getAlert());
        gmoMaintenancePlan.setGmoTriggerDate(maintenancePlan.getTriggerDate());
        gmoMaintenancePlan.setGmoDeclaredDate(maintenancePlan.getDeclaredDate());
        gmoMaintenancePlan.setGmoObservation(maintenancePlan.getObservation());
        gmoMaintenancePlan.setGmoDuration(maintenancePlan.getDuration());

        gmoMaintenancePlan.setCreatedBy(maintenancePlan.getCreatedBy());
        gmoMaintenancePlan.setUpdatedBy(maintenancePlan.getUpdatedBy());
        gmoMaintenancePlan.setCreationDate(maintenancePlan.getCreationDate());
        gmoMaintenancePlan.setUpdateDate(maintenancePlan.getUpdateDate());

        if (!lazy) {
            gmoMaintenancePlan.setGmoMaintenanceType(MaintenanceTypeMapper.toEntity(maintenancePlan.getMaintenanceType(), true));
            gmoMaintenancePlan.setGmoMaintenanceState(MaintenanceStateMapper.toEntity(maintenancePlan.getMaintenanceState(), true));
            gmoMaintenancePlan.setGmoPatrimony(PatrimonyMapper.toEntity(maintenancePlan.getPatrimony(),true));
            gmoMaintenancePlan.setGmoActions(ActionMapper.toEntities (maintenancePlan.getActions(), false));

            gmoMaintenancePlan.setGmoPeriodicityType(PeriodicityTypeMapper.toEntity(maintenancePlan.getPeriodicityType(),false));
            gmoMaintenancePlan.setGmoResponsability (ResponsabilityMapper.toEntity (maintenancePlan.getResponsability(), false));
            gmoMaintenancePlan.setGmoServiceProvider(ServiceProviderMapper.toEntity(maintenancePlan.getServiceProvider(),false));
            gmoMaintenancePlan.setGmoService (ResponsabilityMapper.toEntity (maintenancePlan.getService(), false));
            gmoMaintenancePlan.setGmoProgramType(ProgramTypeMapper.toEntity(maintenancePlan.getProgramType(),false));
            oneToMany(gmoMaintenancePlan);
        }
        return gmoMaintenancePlan;
    }
    private static void oneToMany(GmoMaintenancePlan plan) {
        plan.getGmoActions().forEach(
                e -> {
                    e.setCreationDate(new Date());
                    e.setGmoMaintenancePlan(plan);
                }
        );
    }
    public static MaintenancePlan toDto(GmoMaintenancePlan gmoMaintenancePlan, boolean lazy) {
        if (null == gmoMaintenancePlan) {
            return null;
        }
        MaintenancePlan maintenancePlan = new MaintenancePlan();
        maintenancePlan.setId(gmoMaintenancePlan.getGmoMaintenancePlanId());
        maintenancePlan.setCode(gmoMaintenancePlan.getGmoMaintenancePlanCode());
        maintenancePlan.setDescription(gmoMaintenancePlan.getGmoMaintenancePlanDescription());
        maintenancePlan.setStartDate (gmoMaintenancePlan.getGmoMaintenancePlanStartDate());
        maintenancePlan.setEndDate (gmoMaintenancePlan.getGmoMaintenancePlanEndDate());
        maintenancePlan.setTotalPrice (gmoMaintenancePlan.getGmoMaintenancePlanTotalPrice ());
        maintenancePlan.setMileage (gmoMaintenancePlan.getGmoMaintenancePlanMileage ());

        maintenancePlan.setAlert(gmoMaintenancePlan.getGmoAlert());
        maintenancePlan.setTriggerDate(gmoMaintenancePlan.getGmoTriggerDate());
        maintenancePlan.setInterventionDate (gmoMaintenancePlan.getGmoInterventionDate ());
        maintenancePlan.setAgent (gmoMaintenancePlan.getGmoAgent ());
        maintenancePlan.setEmployer (gmoMaintenancePlan.getGmoEmployer ());

        maintenancePlan.setDuration (gmoMaintenancePlan.getGmoDuration ()  );

        maintenancePlan.setDeclaredDate (gmoMaintenancePlan.getGmoDeclaredDate ());
        maintenancePlan.setObservation (gmoMaintenancePlan.getGmoObservation ());

        maintenancePlan.setCreatedBy(gmoMaintenancePlan.getCreatedBy());
        maintenancePlan.setUpdatedBy(gmoMaintenancePlan.getUpdatedBy());
        maintenancePlan.setCreationDate(gmoMaintenancePlan.getCreationDate());
        maintenancePlan.setUpdateDate(gmoMaintenancePlan.getUpdateDate());
        if (!lazy) {
            maintenancePlan.setMaintenanceType(MaintenanceTypeMapper.toDto(gmoMaintenancePlan.getGmoMaintenanceType(), true));
            maintenancePlan.setMaintenanceState(MaintenanceStateMapper.toDto(gmoMaintenancePlan.getGmoMaintenanceState(), true));
            maintenancePlan.setPatrimony(PatrimonyMapper.toDto(gmoMaintenancePlan.getGmoPatrimony(),true));
            maintenancePlan.setActions (ActionMapper.toDtos (gmoMaintenancePlan.getGmoActions(), false));

            maintenancePlan.setPeriodicityType(PeriodicityTypeMapper.toDto(gmoMaintenancePlan.getGmoPeriodicityType(),true));
            maintenancePlan.setResponsability (ResponsabilityMapper.toDto (gmoMaintenancePlan.getGmoResponsability (), true));
            maintenancePlan.setServiceProvider(ServiceProviderMapper.toDto(gmoMaintenancePlan.getGmoServiceProvider(),true));
            maintenancePlan.setService(ResponsabilityMapper.toDto (gmoMaintenancePlan.getGmoService (), true));
            maintenancePlan.setProgramType(ProgramTypeMapper.toDto(gmoMaintenancePlan.getGmoProgramType(),true));

        }

        return maintenancePlan;
    }

    public static List<MaintenancePlan> toDtos(Iterable<? extends GmoMaintenancePlan> mntMaintenancePlans, boolean lazy) {
        if (null == mntMaintenancePlans) {
            return null;
        }
        List<MaintenancePlan> maintenancePlans = new ArrayList<>();
        for (GmoMaintenancePlan gmoMaintenancePlan : mntMaintenancePlans) {
            maintenancePlans.add(toDto(gmoMaintenancePlan, lazy));
        }
        return maintenancePlans;
    }

    public static Set<GmoMaintenancePlan> toEntities(Set<? extends MaintenancePlan> maintenancePlans, boolean lazy) {
        if (null == maintenancePlans) {
            return null;
        }
        Set<GmoMaintenancePlan> gmoMaintenancePlans = new HashSet<>();

        for (MaintenancePlan maintenancePlan : maintenancePlans) {
            gmoMaintenancePlans.add(toEntity(maintenancePlan, lazy));
        }
        return gmoMaintenancePlans;
    }

    public static Set<MaintenancePlan> toDtos(Set<? extends GmoMaintenancePlan> gmoMaintenancePlans, boolean lazy) {
        if (null == gmoMaintenancePlans) {
            return null;
        }
        Set<MaintenancePlan> maintenancePlans = new HashSet<>();
        for (GmoMaintenancePlan gmoMaintenancePlan : gmoMaintenancePlans) {
            maintenancePlans.add(toDto(gmoMaintenancePlan, lazy));
        }
        return maintenancePlans;
    }

}

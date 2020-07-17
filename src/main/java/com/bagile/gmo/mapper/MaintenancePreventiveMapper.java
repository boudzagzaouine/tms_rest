package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Day;
import com.bagile.gmo.dto.MaintenancePreventive;
import com.bagile.gmo.entities.GmoMaintenancePreventive;

import java.util.*;

public class MaintenancePreventiveMapper {
    public MaintenancePreventiveMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoMaintenancePreventiveId");
        map.put("code", "gmoMaintenancePreventiveCode");
        map.put("description", "gmoMaintenancePreventiveDescription");
        map.put("beginDate", "gmoMaintenancePreventiveStartDate");
        map.put("endDate", "gmoMaintenancePreventiveEndDate");
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
        map.put("totalPrice", "gmoMaintenancePreventiveTotalPrice");
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

    public static GmoMaintenancePreventive toEntity(MaintenancePreventive maintenancePreventive, boolean lazy) {
        if (null == maintenancePreventive) {
            return null;
        }
        GmoMaintenancePreventive gmoMaintenancePreventive = new GmoMaintenancePreventive();
        gmoMaintenancePreventive.setGmoMaintenancePreventiveId(maintenancePreventive.getId());
        gmoMaintenancePreventive.setGmoMaintenancePreventiveCode(maintenancePreventive.getCode() != null ? maintenancePreventive.getCode().toUpperCase() : null);
        gmoMaintenancePreventive.setGmoMaintenancePreventiveDescription(maintenancePreventive.getDescription());
        gmoMaintenancePreventive.setGmoMaintenancePreventiveStartDate(maintenancePreventive.getStartDate ());
        gmoMaintenancePreventive.setGmoMaintenancePreventiveEndDate(maintenancePreventive.getEndDate ());
        gmoMaintenancePreventive.setGmoMaintenancePreventiveTotalPrice (maintenancePreventive.getTotalPrice ());
        gmoMaintenancePreventive.setGmoMaintenancePreventiveMileage (maintenancePreventive.getMileage ());
        gmoMaintenancePreventive.setGmoInterventionDate (maintenancePreventive.getInterventionDate ());
        gmoMaintenancePreventive.setGmoAgent (maintenancePreventive.getAgent ());
        gmoMaintenancePreventive.setGmoEmployer (maintenancePreventive.getEmployer ());
        gmoMaintenancePreventive.setGmoTriggerDay(maintenancePreventive.getTriggerDay());
        gmoMaintenancePreventive.setGmoTriggerDate(maintenancePreventive.getTriggerDate());
        gmoMaintenancePreventive.setGmoDeclaredDate(maintenancePreventive.getDeclaredDate());
        gmoMaintenancePreventive.setGmoObservation(maintenancePreventive.getObservation());
        gmoMaintenancePreventive.setGmoDuration(maintenancePreventive.getDuration());
        gmoMaintenancePreventive.setCreatedBy(maintenancePreventive.getCreatedBy());
        gmoMaintenancePreventive.setUpdatedBy(maintenancePreventive.getUpdatedBy());
        gmoMaintenancePreventive.setCreationDate(maintenancePreventive.getCreationDate());
        gmoMaintenancePreventive.setUpdateDate(maintenancePreventive.getUpdateDate());

        if (!lazy) {
            gmoMaintenancePreventive.setGmoMaintenanceType(MaintenanceTypeMapper.toEntity(maintenancePreventive.getMaintenanceType(), true));
            gmoMaintenancePreventive.setGmoMaintenanceState(MaintenanceStateMapper.toEntity(maintenancePreventive.getMaintenanceState(), true));
            gmoMaintenancePreventive.setGmoPatrimony(PatrimonyMapper.toEntity(maintenancePreventive.getPatrimony(),true));
            gmoMaintenancePreventive.setGmoActions(ActionMapper.toEntities (maintenancePreventive.getActions(), false));

            gmoMaintenancePreventive.setGmoPeriodicityType(PeriodicityTypeMapper.toEntity(maintenancePreventive.getPeriodicityType(),false));
            gmoMaintenancePreventive.setGmoResponsability (ResponsabilityMapper.toEntity (maintenancePreventive.getResponsability(), false));
            gmoMaintenancePreventive.setGmoServiceProvider(ServiceProviderMapper.toEntity(maintenancePreventive.getServiceProvider(),false));
            gmoMaintenancePreventive.setGmoService (ResponsabilityMapper.toEntity (maintenancePreventive.getService(), false));
            gmoMaintenancePreventive.setGmoProgramType(ProgramTypeMapper.toEntity(maintenancePreventive.getProgramType(),false));
            gmoMaintenancePreventive.setGmoMonths(MonthMapper.toEntities (maintenancePreventive.getMonths(), false));
            gmoMaintenancePreventive.setGmoDays(DayMapper.toEntities (maintenancePreventive.getDays(), false));

        }
        return gmoMaintenancePreventive;
    }

    public static MaintenancePreventive toDto(GmoMaintenancePreventive gmoMaintenancePreventive, boolean lazy) {
        if (null == gmoMaintenancePreventive) {
            return null;
        }
        MaintenancePreventive maintenancePreventive = new MaintenancePreventive();
        maintenancePreventive.setId(gmoMaintenancePreventive.getGmoMaintenancePreventiveId());
        maintenancePreventive.setCode(gmoMaintenancePreventive.getGmoMaintenancePreventiveCode());
        maintenancePreventive.setDescription(gmoMaintenancePreventive.getGmoMaintenancePreventiveDescription());
        maintenancePreventive.setStartDate (gmoMaintenancePreventive.getGmoMaintenancePreventiveStartDate());
        maintenancePreventive.setEndDate (gmoMaintenancePreventive.getGmoMaintenancePreventiveEndDate());
        maintenancePreventive.setTotalPrice (gmoMaintenancePreventive.getGmoMaintenancePreventiveTotalPrice ());
        maintenancePreventive.setMileage (gmoMaintenancePreventive.getGmoMaintenancePreventiveMileage ());

        maintenancePreventive.setTriggerDay(gmoMaintenancePreventive.getGmoTriggerDay());
        maintenancePreventive.setTriggerDate(gmoMaintenancePreventive.getGmoTriggerDate());
        maintenancePreventive.setInterventionDate (gmoMaintenancePreventive.getGmoInterventionDate ());
        maintenancePreventive.setAgent (gmoMaintenancePreventive.getGmoAgent ());
        maintenancePreventive.setEmployer (gmoMaintenancePreventive.getGmoEmployer ());

        maintenancePreventive.setDuration (gmoMaintenancePreventive.getGmoDuration ()  );

        maintenancePreventive.setDeclaredDate (gmoMaintenancePreventive.getGmoDeclaredDate ());
        maintenancePreventive.setObservation (gmoMaintenancePreventive.getGmoObservation ());

        maintenancePreventive.setCreatedBy(gmoMaintenancePreventive.getCreatedBy());
        maintenancePreventive.setUpdatedBy(gmoMaintenancePreventive.getUpdatedBy());
        maintenancePreventive.setCreationDate(gmoMaintenancePreventive.getCreationDate());
        maintenancePreventive.setUpdateDate(gmoMaintenancePreventive.getUpdateDate());
        if (!lazy) {
            maintenancePreventive.setMaintenanceType(MaintenanceTypeMapper.toDto(gmoMaintenancePreventive.getGmoMaintenanceType(), true));
            maintenancePreventive.setMaintenanceState(MaintenanceStateMapper.toDto(gmoMaintenancePreventive.getGmoMaintenanceState(), true));
            maintenancePreventive.setPatrimony(PatrimonyMapper.toDto(gmoMaintenancePreventive.getGmoPatrimony(),true));
            maintenancePreventive.setActions (ActionMapper.toDtos (gmoMaintenancePreventive.getGmoActions(), false));

            maintenancePreventive.setPeriodicityType(PeriodicityTypeMapper.toDto(gmoMaintenancePreventive.getGmoPeriodicityType(),true));
            maintenancePreventive.setResponsability (ResponsabilityMapper.toDto (gmoMaintenancePreventive.getGmoResponsability (), true));
            maintenancePreventive.setServiceProvider(ServiceProviderMapper.toDto(gmoMaintenancePreventive.getGmoServiceProvider(),true));
            maintenancePreventive.setService(ResponsabilityMapper.toDto (gmoMaintenancePreventive.getGmoService (), true));
            maintenancePreventive.setProgramType(ProgramTypeMapper.toDto(gmoMaintenancePreventive.getGmoProgramType(),true));
            maintenancePreventive.setDays(DayMapper.toDtos(gmoMaintenancePreventive.getGmoDays(),true));
            maintenancePreventive.setMonths(MonthMapper.toDtos(gmoMaintenancePreventive.getGmoMonths(),true));

        }

        return maintenancePreventive;
    }

    public static List<MaintenancePreventive> toDtos(Iterable<? extends GmoMaintenancePreventive> mntMaintenancePreventives, boolean lazy) {
        if (null == mntMaintenancePreventives) {
            return null;
        }
        List<MaintenancePreventive> maintenancePreventives = new ArrayList<>();
        for (GmoMaintenancePreventive gmoMaintenancePreventive : mntMaintenancePreventives) {
            maintenancePreventives.add(toDto(gmoMaintenancePreventive, lazy));
        }
        return maintenancePreventives;
    }

    public static Set<GmoMaintenancePreventive> toEntities(Set<? extends MaintenancePreventive> maintenancePreventives, boolean lazy) {
        if (null == maintenancePreventives) {
            return null;
        }
        Set<GmoMaintenancePreventive> gmoMaintenancePreventives = new HashSet<>();

        for (MaintenancePreventive maintenancePreventive : maintenancePreventives) {
            gmoMaintenancePreventives.add(toEntity(maintenancePreventive, lazy));
        }
        return gmoMaintenancePreventives;
    }

    public static Set<MaintenancePreventive> toDtos(Set<? extends GmoMaintenancePreventive> gmoMaintenancePreventives, boolean lazy) {
        if (null == gmoMaintenancePreventives) {
            return null;
        }
        Set<MaintenancePreventive> maintenancePreventives = new HashSet<>();
        for (GmoMaintenancePreventive gmoMaintenancePreventive : gmoMaintenancePreventives) {
            maintenancePreventives.add(toDto(gmoMaintenancePreventive, lazy));
        }
        return maintenancePreventives;
    }

}

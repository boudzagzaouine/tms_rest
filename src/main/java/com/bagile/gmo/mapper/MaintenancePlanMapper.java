package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        map.put("patrimony", "gmoPatrimony");
        map.put("totalPrice", "gmoMaintenancePlanTotalPrice");

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

        gmoMaintenancePlan.setCreatedBy(maintenancePlan.getCreatedBy());
        gmoMaintenancePlan.setUpdatedBy(maintenancePlan.getUpdatedBy());
        gmoMaintenancePlan.setCreationDate(maintenancePlan.getCreationDate());
        gmoMaintenancePlan.setUpdateDate(maintenancePlan.getUpdateDate());

        if (!lazy) {
            gmoMaintenancePlan.setGmoMaintenanceType(MaintenanceTypeMapper.toEntity(maintenancePlan.getMaintenanceType(), true));
            gmoMaintenancePlan.setGmoMaintenanceState(MaintenanceStateMapper.toEntity(maintenancePlan.getMaintenanceState(), true));
            gmoMaintenancePlan.setGmoPatrimony(PatrimonyMapper.toEntity(maintenancePlan.getPatrimony(),false));
            gmoMaintenancePlan.setGmoMaintenanceLines (MaintenanceLineMapper.toEntities (maintenancePlan.getMaintenanceLines(), false));

        }
        return gmoMaintenancePlan;
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

        maintenancePlan.setCreatedBy(gmoMaintenancePlan.getCreatedBy());
        maintenancePlan.setUpdatedBy(gmoMaintenancePlan.getUpdatedBy());
        maintenancePlan.setCreationDate(gmoMaintenancePlan.getCreationDate());
        maintenancePlan.setUpdateDate(gmoMaintenancePlan.getUpdateDate());
        if (!lazy) {
            maintenancePlan.setMaintenanceType(MaintenanceTypeMapper.toDto(gmoMaintenancePlan.getGmoMaintenanceType(), lazy));
            maintenancePlan.setMaintenanceState(MaintenanceStateMapper.toDto(gmoMaintenancePlan.getGmoMaintenanceState(), lazy));
            maintenancePlan.setPatrimony(PatrimonyMapper.toDto(gmoMaintenancePlan.getGmoPatrimony(),lazy));
            maintenancePlan.setMaintenanceLineList (MaintenanceLineMapper.toDtos (gmoMaintenancePlan.getGmoMaintenanceLines (), lazy));
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

package com.bagile.tms.mapper;

import com.bagile.tms.dto.MaintenancePlan;
import com.bagile.tms.entities.TmsMaintenancePlan;

import java.util.*;

public class MaintenancePlanMapper {
    public MaintenancePlanMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsMaintenancePlanId");
        map.put("code", "tmsMaintenancePlanCode");
        map.put("description", "tmsMaintenancePlanDescription");
        map.put("begin", "tmsMaintenancePlanStartDate");
        map.put("end", "tmsMaintenancePlanEndDate");
        map.put("maintenanceType", "tmsMaintenanceType");
        map.put("maintenanceState", "tmsMaintenanceState");
        map.put("vehicle", "tmsVehicle");

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

    public static TmsMaintenancePlan toEntity(MaintenancePlan maintenancePlan, boolean lazy) {
        if (null == maintenancePlan) {
            return null;
        }
        TmsMaintenancePlan tmsMaintenancePlan = new TmsMaintenancePlan();
        tmsMaintenancePlan.setTmsMaintenancePlanId(maintenancePlan.getId());
        tmsMaintenancePlan.setTmsMaintenancePlanCode(maintenancePlan.getCode() != null ? maintenancePlan.getCode().toUpperCase() : null);
        tmsMaintenancePlan.setTmsMaintenancePlanDescription(maintenancePlan.getDescription());
        tmsMaintenancePlan.setTmsMaintenancePlanStartDate(maintenancePlan.getBegin());
        tmsMaintenancePlan.setTmsMaintenancePlanEndDate(maintenancePlan.getEnd());


        tmsMaintenancePlan.setCreatedBy(maintenancePlan.getCreatedBy());
        tmsMaintenancePlan.setUpdatedBy(maintenancePlan.getUpdatedBy());
        tmsMaintenancePlan.setCreationDate(maintenancePlan.getCreationDate());
        tmsMaintenancePlan.setUpdateDate(maintenancePlan.getUpdateDate());

        if (!lazy) {
            tmsMaintenancePlan.setTmsMaintenanceType(MaintenanceTypeMapper.toEntity(maintenancePlan.getMaintenanceType(), true));
            tmsMaintenancePlan.setTmsMaintenanceState(MaintenanceStateMapper.toEntity(maintenancePlan.getMaintenanceState(), true));
            tmsMaintenancePlan.setTmsVehicle(VehicleMapper.toEntity(maintenancePlan.getVehicle(),true));
        }
        return tmsMaintenancePlan;
    }

    public static MaintenancePlan toDto(TmsMaintenancePlan tmsMaintenancePlan, boolean lazy) {
        if (null == tmsMaintenancePlan) {
            return null;
        }
        MaintenancePlan maintenancePlan = new MaintenancePlan();
        maintenancePlan.setId(tmsMaintenancePlan.getTmsMaintenancePlanId());
        maintenancePlan.setCode(tmsMaintenancePlan.getTmsMaintenancePlanCode());
        maintenancePlan.setDescription(tmsMaintenancePlan.getTmsMaintenancePlanDescription());
        maintenancePlan.setBegin(tmsMaintenancePlan.getTmsMaintenancePlanStartDate());
        maintenancePlan.setEnd(tmsMaintenancePlan.getTmsMaintenancePlanEndDate());

        maintenancePlan.setCreatedBy(tmsMaintenancePlan.getCreatedBy());
        maintenancePlan.setUpdatedBy(tmsMaintenancePlan.getUpdatedBy());
        maintenancePlan.setCreationDate(tmsMaintenancePlan.getCreationDate());
        maintenancePlan.setUpdateDate(tmsMaintenancePlan.getUpdateDate());
        if (!lazy) {
            maintenancePlan.setMaintenanceType(MaintenanceTypeMapper.toDto(tmsMaintenancePlan.getTmsMaintenanceType(), true));
            maintenancePlan.setMaintenanceState(MaintenanceStateMapper.toDto(tmsMaintenancePlan.getTmsMaintenanceState(), true));
            //maintenancePlan.setActes(ActeMapper.toDtos(tmsMaintenancePlan.getTmsMaintenancePlanActes(),true));
            maintenancePlan.setVehicle(VehicleMapper.toDto(tmsMaintenancePlan.getTmsVehicle(),true));
        }

        return maintenancePlan;
    }



    public static List<MaintenancePlan> toDtos(Iterable<? extends TmsMaintenancePlan> mntMaintenancePlans, boolean lazy) {
        if (null == mntMaintenancePlans) {
            return null;
        }
        List<MaintenancePlan> maintenancePlans = new ArrayList<>();
        for (TmsMaintenancePlan tmsMaintenancePlan : mntMaintenancePlans) {
            maintenancePlans.add(toDto(tmsMaintenancePlan, lazy));
        }
        return maintenancePlans;
    }

    public static Set<TmsMaintenancePlan> toEntities(Set<? extends MaintenancePlan> maintenancePlans, boolean lazy) {
        if (null == maintenancePlans) {
            return null;
        }
        Set<TmsMaintenancePlan> tmsMaintenancePlans = new HashSet<>();

        for (MaintenancePlan maintenancePlan : maintenancePlans) {
            tmsMaintenancePlans.add(toEntity(maintenancePlan, lazy));
        }
        return tmsMaintenancePlans;
    }

    public static Set<MaintenancePlan> toDtos(Set<? extends TmsMaintenancePlan> tmsMaintenancePlans, boolean lazy) {
        if (null == tmsMaintenancePlans) {
            return null;
        }
        Set<MaintenancePlan> maintenancePlans = new HashSet<>();
        for (TmsMaintenancePlan tmsMaintenancePlan : tmsMaintenancePlans) {
            maintenancePlans.add(toDto(tmsMaintenancePlan, lazy));
        }
        return maintenancePlans;
    }


}

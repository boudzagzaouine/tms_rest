package com.bagile.tms.mapper;

import com.bagile.tms.dto.MaintenancePlan;
import com.bagile.tms.dto.MaintenanceState;
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
        map.put("descriptif", "tmsMaintenancePlanDescriptif");
        map.put("vehicleId", "tmsMaintenancePlanVehicleId");
        map.put("date", "tmsMaintenancePlanDate");
        map.put("state", "tmsMaintenancePlanState");
        map.put("title", "tmsMaintenancePlanTitle");
        map.put("creationDate", "tmsMaintenanceCreationDate");
        map.put("creationUser", "tmsMaintenanceCreationUser");
        map.put("upDateDate", "tmsMaintenanceUpDateDate");
        map.put("typeMaintenance", "tmsMaintenanceTypeMaintenance");
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
        tmsMaintenancePlan.setTmsMaintenancePlanDescriptif(maintenancePlan.getDescriptif());
        tmsMaintenancePlan.setTmsMaintenancePlanTitle(maintenancePlan.getTitle());
        tmsMaintenancePlan.setTmsMaintenanceCreationDate(maintenancePlan.getCreationDate());
        tmsMaintenancePlan.setTmsMaintenancePlanDate(maintenancePlan.getDate());
            tmsMaintenancePlan.setTmsMaintenanceUpDateDate(maintenancePlan.getUpDateDate());
        if (!lazy) {
            tmsMaintenancePlan.setTmsMaintenanceCreationUser(UserMapper.toEntity( maintenancePlan.getCreationUser(),true));
            tmsMaintenancePlan.setTmsMaintenancePlanState(MaintenanceStateMapper.toEntity(maintenancePlan.getState(), true));
            // tmsMaintenancePlan.setTmsMaintenancePlanActes(ActeMapper.toEntities(maintenancePlan.getActes(),true));
            tmsMaintenancePlan.setTmsMaintenancePlanVehicle(VehicleMapper.toEntity(maintenancePlan.getVehicle(),true));
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
        maintenancePlan.setDescriptif(tmsMaintenancePlan.getTmsMaintenancePlanDescriptif());
        maintenancePlan.setCreationDate(tmsMaintenancePlan.getTmsMaintenanceCreationDate());
        maintenancePlan.setDate(tmsMaintenancePlan.getTmsMaintenancePlanDate());
        maintenancePlan.setTitle(tmsMaintenancePlan.getTmsMaintenancePlanTitle());
        maintenancePlan.setUpDateDate(tmsMaintenancePlan.getTmsMaintenanceUpDateDate());
        if (!lazy) {
            maintenancePlan.setCreationUser(UserMapper.toDto(tmsMaintenancePlan.getTmsMaintenanceCreationUser(), true));
            maintenancePlan.setState(MaintenanceStateMapper.toDto(tmsMaintenancePlan.getTmsMaintenancePlanState(), true));
            //maintenancePlan.setActes(ActeMapper.toDtos(tmsMaintenancePlan.getTmsMaintenancePlanActes(),true));
            maintenancePlan.setVehicle(VehicleMapper.toDto(tmsMaintenancePlan.getTmsMaintenancePlanVehicle(),true));
        }

        return maintenancePlan;
    }

    public static List<MaintenancePlan> toDtos(List<TmsMaintenancePlan> tmsMaintenancePlans, boolean lazy) {
        if (null == tmsMaintenancePlans) {
            return null;
        }
        List<MaintenancePlan> maintenancePlans = new ArrayList<>();
        for (TmsMaintenancePlan tmsMaintenancePlan : tmsMaintenancePlans) {
            maintenancePlans.add(toDto(tmsMaintenancePlan, lazy));
        }
        return maintenancePlans;
    }

    public static List<MaintenancePlan> toDtos(Iterable<TmsMaintenancePlan> mntMaintenancePlans, boolean lazy) {
        if (null == mntMaintenancePlans) {
            return null;
        }
        List<MaintenancePlan> maintenancePlans = new ArrayList<>();
        for (TmsMaintenancePlan tmsMaintenancePlan : mntMaintenancePlans) {
            maintenancePlans.add(toDto(tmsMaintenancePlan, lazy));
        }
        return maintenancePlans;
    }

    public static Set<TmsMaintenancePlan> toEntities(Set<MaintenancePlan> maintenancePlans, boolean lazy) {
        if (null == maintenancePlans) {
            return null;
        }
        Set<TmsMaintenancePlan> tmsMaintenancePlans = new HashSet<>();

        for (MaintenancePlan maintenancePlan : maintenancePlans) {
            tmsMaintenancePlans.add(toEntity(maintenancePlan, lazy));
        }
        return tmsMaintenancePlans;
    }

    public static Set<MaintenancePlan> toDtos(Set<TmsMaintenancePlan> tmsMaintenancePlans, boolean lazy) {
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

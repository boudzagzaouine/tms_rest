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

        map.put("id", "tmsMaintenancePlanid");
        map.put("code", "tmsMaintenancePlancode");
        map.put("descriptif", "tmsMaintenancePlandescriptif");
        map.put("creationDate", "tmsMaintenancePlancreationDatae");
        map.put("upDate", "tmsMaintenancePlanupDate");
        map.put("begin", "tmsMaintenancePlanbegin");
        map.put("end", "tmsMaintenancePlanend");
        map.put("maintenanceType", "tmsMaintenanceType");
        map.put("maintenanceState", "tmsMaintenanceState");
        map.put("vehicule", "tmsVehicle");


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
        tmsMaintenancePlan.setTmsMaintenancePlanid(maintenancePlan.getId());
        tmsMaintenancePlan.setTmsMaintenancePlancode(maintenancePlan.getCode() != null ? maintenancePlan.getCode().toUpperCase() : null);
        tmsMaintenancePlan.setTmsMaintenancePlandescriptif(maintenancePlan.getDescriptif());
        tmsMaintenancePlan.setTmsMaintenancePlancreationDatae(maintenancePlan.getCreationDatae());
        tmsMaintenancePlan.setTmsMaintenancePlanupDate(maintenancePlan.getUpDate());
        tmsMaintenancePlan.setTmsMaintenancePlanbegin(maintenancePlan.getBegin());
        tmsMaintenancePlan.setTmsMaintenancePlanend(maintenancePlan.getEnd());

        if (!lazy) {
            tmsMaintenancePlan.setTmsMaintenanceType(MaintenanceTypeMapper.toEntity(maintenancePlan.getMaintenanceType(), true));
            tmsMaintenancePlan.setTmsMaintenanceState(MaintenanceStateMapper.toEntity(maintenancePlan.getMaintenanceState(), true));
            tmsMaintenancePlan.setTmsVehicle(VehicleMapper.toEntity(maintenancePlan.getVehicule(),true));
        }
        return tmsMaintenancePlan;
    }

    public static MaintenancePlan toDto(TmsMaintenancePlan tmsMaintenancePlan, boolean lazy) {
        if (null == tmsMaintenancePlan) {
            return null;
        }
        MaintenancePlan maintenancePlan = new MaintenancePlan();
        maintenancePlan.setId(tmsMaintenancePlan.getTmsMaintenancePlanid());
        maintenancePlan.setCode(tmsMaintenancePlan.getTmsMaintenancePlancode());
        maintenancePlan.setDescriptif(tmsMaintenancePlan.getTmsMaintenancePlandescriptif());
        maintenancePlan.setCreationDatae(tmsMaintenancePlan.getTmsMaintenancePlancreationDatae());
        maintenancePlan.setUpDate(tmsMaintenancePlan.getTmsMaintenancePlanupDate());
        maintenancePlan.setBegin(tmsMaintenancePlan.getTmsMaintenancePlanbegin());
        maintenancePlan.setEnd(tmsMaintenancePlan.getTmsMaintenancePlanend());
        if (!lazy) {
            maintenancePlan.setMaintenanceType(MaintenanceTypeMapper.toDto(tmsMaintenancePlan.getTmsMaintenanceType(), true));
            maintenancePlan.setMaintenanceState(MaintenanceStateMapper.toDto(tmsMaintenancePlan.getTmsMaintenanceState(), true));
            //maintenancePlan.setActes(ActeMapper.toDtos(tmsMaintenancePlan.getTmsMaintenancePlanActes(),true));
            maintenancePlan.setVehicule(VehicleMapper.toDto(tmsMaintenancePlan.getTmsVehicle(),true));
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

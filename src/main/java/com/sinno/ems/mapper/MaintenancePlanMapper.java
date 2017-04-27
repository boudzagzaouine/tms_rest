package com.sinno.ems.mapper;

import com.sinno.ems.dto.MaintenancePlan;
import com.sinno.ems.entities.TmsMaintenancePlan;

import java.util.*;

/**
 * Created by bouzi on 3/22/2017.
 */
public class MaintenancePlanMapper {
    public MaintenancePlanMapper() {
    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "mntMaintenancePlanId");
        map.put("code", "mntMaintenancePlanCode");
        map.put("description", "mntMaintenancePlanDescription");
        map.put("vehicule", "vehicules");
        map.put("acte", "mntMaintenancePlanActes");

    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsMaintenancePlan toEntity(MaintenancePlan maintenancePlan, boolean lazy){
        if (null == maintenancePlan) {
            return null;
        }
        TmsMaintenancePlan tmsMaintenancePlan = new TmsMaintenancePlan();
       tmsMaintenancePlan.setTmsMaintenancePlanId(maintenancePlan.getId());
       maintenancePlan.setCode(maintenancePlan.getCode() != null ? maintenancePlan.getCode().toUpperCase() : null );
       maintenancePlan.setDescription(maintenancePlan.getDescription());

        if (!lazy) {
          tmsMaintenancePlan.setVehicle(VehicleMapper.toEntity(maintenancePlan.getVehicule(),true));
       tmsMaintenancePlan.setTmsMaintenancePlanActes(ActeMapper.toEntities(maintenancePlan.getActes(),true));
        }
        return tmsMaintenancePlan;
    }

    public static MaintenancePlan toDto(TmsMaintenancePlan tmsMaintenancePlan, boolean lazy){
        if (null == tmsMaintenancePlan) {
            return null;
        }
        MaintenancePlan maintenancePlan = new MaintenancePlan();

        maintenancePlan.setId(tmsMaintenancePlan.getTmsMaintenancePlanId());
        maintenancePlan.setCode(tmsMaintenancePlan.getTmsMaintenancePlanCode());
        maintenancePlan.setDescription(tmsMaintenancePlan.getTmsDescription());
    if (!lazy){
        maintenancePlan.setVehicule(VehicleMapper.toDto(tmsMaintenancePlan.getVehicle(),true));
        maintenancePlan.setActes(ActeMapper.toDtos(tmsMaintenancePlan.getTmsMaintenancePlanActes(),true));
    }

        return maintenancePlan;
    }
    public static List<MaintenancePlan> toDtos(List<TmsMaintenancePlan> tmsMaintenancePlans, boolean lazy){
        if (null == tmsMaintenancePlans) {
            return null;
        }
        List<MaintenancePlan>maintenancePlans = new ArrayList<>();
        for (TmsMaintenancePlan tmsMaintenancePlan : tmsMaintenancePlans) {
            maintenancePlans.add(toDto(tmsMaintenancePlan, lazy));
        }
        return maintenancePlans;
    }
    public static List<MaintenancePlan>toDtos(Iterable<TmsMaintenancePlan>mntMaintenancePlans , boolean lazy){
        if (null == mntMaintenancePlans) {
            return null;
        }
        List<MaintenancePlan>maintenancePlans = new ArrayList<>();
        for (TmsMaintenancePlan tmsMaintenancePlan : mntMaintenancePlans) {
            maintenancePlans.add(toDto(tmsMaintenancePlan,lazy));
        }
        return maintenancePlans;
    }
    public static Set<TmsMaintenancePlan>toEntities(Set<MaintenancePlan>maintenancePlans, boolean lazy){
        if (null == maintenancePlans) {
            return null;
        }
        Set<TmsMaintenancePlan> tmsMaintenancePlans = new HashSet<>();

        for (MaintenancePlan maintenancePlan:maintenancePlans) {
            tmsMaintenancePlans.add(toEntity(maintenancePlan,lazy));
        }
        return tmsMaintenancePlans;
    }
    public static Set<MaintenancePlan>toDtos(Set<TmsMaintenancePlan> tmsMaintenancePlans, boolean lazy){
        if (null == tmsMaintenancePlans) {
            return null;
        }
        Set<MaintenancePlan>maintenancePlans = new HashSet<>();
        for (TmsMaintenancePlan tmsMaintenancePlan : tmsMaintenancePlans) {
            maintenancePlans.add(toDto(tmsMaintenancePlan,lazy));
        }
        return maintenancePlans;
    }




}

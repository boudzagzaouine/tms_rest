package com.sinno.ems.mapper;

import com.sinno.ems.dto.MaintenancePlan;
import com.sinno.ems.entities.MntMaintenancePlan;

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

    public static MntMaintenancePlan toEntity(MaintenancePlan maintenancePlan, boolean lazy){
        if (null == maintenancePlan) {
            return null;
        }
        MntMaintenancePlan mntMaintenancePlan = new MntMaintenancePlan();
       mntMaintenancePlan.setMntMaintenancePlanId(maintenancePlan.getId());
       maintenancePlan.setCode(maintenancePlan.getCode() != null ? maintenancePlan.getCode().toUpperCase() : null );
       maintenancePlan.setDescription(maintenancePlan.getDescription());

        if (!lazy) {
          mntMaintenancePlan.setVehicle(VehicleMapper.toEntity(maintenancePlan.getVehicule(),true));
       mntMaintenancePlan.setMntMaintenancePlanActes(ActeMapper.toEntities(maintenancePlan.getActes(),true));
        }
        return mntMaintenancePlan;
    }

    public static MaintenancePlan toDto(MntMaintenancePlan mntMaintenancePlan , boolean lazy){
        if (null == mntMaintenancePlan) {
            return null;
        }
        MaintenancePlan maintenancePlan = new MaintenancePlan();

        maintenancePlan.setId(mntMaintenancePlan.getMntMaintenancePlanId());
        maintenancePlan.setCode(mntMaintenancePlan.getMntMaintenancePlanCode());
        maintenancePlan.setDescription(mntMaintenancePlan.getMntDescription());
    if (!lazy){
        maintenancePlan.setVehicule(VehicleMapper.toDto(mntMaintenancePlan.getVehicle(),true));
        maintenancePlan.setActes(ActeMapper.toDtos(mntMaintenancePlan.getMntMaintenancePlanActes(),true));
    }

        return maintenancePlan;
    }
    public static List<MaintenancePlan> toDtos(List<MntMaintenancePlan>mntMaintenancePlans , boolean lazy){
        if (null == mntMaintenancePlans) {
            return null;
        }
        List<MaintenancePlan>maintenancePlans = new ArrayList<>();
        for (MntMaintenancePlan mntMaintenancePlan : mntMaintenancePlans) {
            maintenancePlans.add(toDto(mntMaintenancePlan , lazy));
        }
        return maintenancePlans;
    }
    public static List<MaintenancePlan>toDtos(Iterable<MntMaintenancePlan>mntMaintenancePlans , boolean lazy){
        if (null == mntMaintenancePlans) {
            return null;
        }
        List<MaintenancePlan>maintenancePlans = new ArrayList<>();
        for (MntMaintenancePlan mntMaintenancePlan : mntMaintenancePlans) {
            maintenancePlans.add(toDto(mntMaintenancePlan,lazy));
        }
        return maintenancePlans;
    }
    public static Set<MntMaintenancePlan>toEntities(Set<MaintenancePlan>maintenancePlans,boolean lazy){
        if (null == maintenancePlans) {
            return null;
        }
        Set<MntMaintenancePlan>mntMaintenancePlans = new HashSet<>();

        for (MaintenancePlan maintenancePlan:maintenancePlans) {
            mntMaintenancePlans.add(toEntity(maintenancePlan,lazy));
        }
        return mntMaintenancePlans;
    }
    public static Set<MaintenancePlan>toDtos(Set<MntMaintenancePlan>mntMaintenancePlans,boolean lazy){
        if (null == mntMaintenancePlans) {
            return null;
        }
        Set<MaintenancePlan>maintenancePlans = new HashSet<>();
        for (MntMaintenancePlan mntMaintenancePlan : mntMaintenancePlans) {
            maintenancePlans.add(toDto(mntMaintenancePlan,lazy));
        }
        return maintenancePlans;
    }




}

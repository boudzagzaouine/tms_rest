package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.entities.GmoMaintenancePlan;
import com.bagile.gmo.util.EmsDate;

import java.util.*;

public class MaintenancePlanMapper {
    public MaintenancePlanMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoMaintenancePlanId");
        map.put("code", "gmoMaintenancePlanCode");
        map.put("description", "gmoMaintenancePlanDescription");
        map.put("actionPlans", "gmoActionPlans");

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

    public static GmoMaintenancePlan toEntity(MaintenancePlan maintenance, boolean lazy) {
        if (null == maintenance) {
            return null;
        }
        GmoMaintenancePlan gmoMaintenance = new GmoMaintenancePlan();
        gmoMaintenance.setGmoMaintenancePlanId(maintenance.getId());
        gmoMaintenance.setGmoMaintenancePlanCode(maintenance.getCode() != null ? maintenance.getCode().toUpperCase() : null);
        gmoMaintenance.setGmoMaintenancePlanDescription(maintenance.getDescription());

        gmoMaintenance.setCreatedBy(maintenance.getCreatedBy());
        gmoMaintenance.setUpdatedBy(maintenance.getUpdatedBy());
        gmoMaintenance.setCreationDate(maintenance.getCreationDate());
        gmoMaintenance.setUpdateDate(maintenance.getUpdateDate());

        if (!lazy) {

            gmoMaintenance.setGmoActionPlans(ActionPlanMapper.toEntities (maintenance.getActionPlans(), false));
           oneToMany(gmoMaintenance);

        }
        return gmoMaintenance;
    }
    private static void oneToMany(GmoMaintenancePlan gmoMaintenancePlan) {
     // if(null !=gmoMaintenancePlan.getGmoActions()){
        gmoMaintenancePlan.getGmoActionPlans().forEach(
                e -> {
                   // if(0 >= gmoMaintenancePlan.getGmoMaintenancePlanId()) {
                    //   e.setGmoActionId(0);
                        e.setCreationDate(EmsDate.getDateNow());
                        e.setGmoMaintenancePlan(gmoMaintenancePlan);
                   // }
                }
        );}
   // }
    public static MaintenancePlan toDto(GmoMaintenancePlan gmoMaintenance, boolean lazy) {
        if (null == gmoMaintenance) {
            return null;
        }
        MaintenancePlan maintenance = new MaintenancePlan();
        maintenance.setId(gmoMaintenance.getGmoMaintenancePlanId());
        maintenance.setCode(gmoMaintenance.getGmoMaintenancePlanCode());
        maintenance.setDescription(gmoMaintenance.getGmoMaintenancePlanDescription());

        maintenance.setCreatedBy(gmoMaintenance.getCreatedBy());
        maintenance.setUpdatedBy(gmoMaintenance.getUpdatedBy());
        maintenance.setCreationDate(gmoMaintenance.getCreationDate());
        maintenance.setUpdateDate(gmoMaintenance.getUpdateDate());


        if (!lazy) {


            maintenance.setActionPlans(ActionPlanMapper.toDtos(gmoMaintenance.getGmoActionPlans(),false));

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

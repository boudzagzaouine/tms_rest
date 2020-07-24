package com.bagile.gmo.mapper;

import java.util.*;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.entities.GmoActionLine;
import com.bagile.gmo.entities.GmoMaintenance;
import com.bagile.gmo.util.EmsClone;
import com.bagile.gmo.util.EmsDate;

public class MaintenanceMapper {
    public MaintenanceMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoMaintenanceId");
        map.put("code", "gmoMaintenanceCode");
        map.put("description", "gmoMaintenanceDescription");
        map.put("startDate", "gmoMaintenanceStartDate");
        map.put("endDate", "gmoMaintenanceEndDate");
        map.put("maintenanceType", "gmoMaintenanceType");
        map.put("programType", "gmoProgramType");
        map.put("operationType", "gmoOperationType");
        map.put("serviceProvider", "gmoServiceProvider");
        map.put("responsability", "gmoResponsability");
        map.put("service", "gmoService");
        map.put("periodicityType", "gmoPeriodicityType");
        map.put("maintenanceState", "gmoMaintenanceState");
        map.put("patrimony", "gmoPatrimony");
        map.put("actionMaintenances", "gmoActionMaintenances");
        map.put("totalPrice", "gmoMaintenanceTotalPrice");
        map.put("mileage", "gmoMaintenanceMileage");
        map.put("triggerDay", "gmoTriggerDay");
        map.put("triggerDate", "gmoTriggerDate");
        map.put("interventionDate", "gmoInterventionDate");



        map.put("agent", "gmoAgent");
        map.put("employer", "gmoEmployer");
        map.put("observation", "gmoObservation");
        map.put("declaredDate", "gmoDeclaredDate");
        map.put("duration", "gmoDuration");
        map.put("maintenancePlan", "gmoMaintenancePlan");




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

    public static GmoMaintenance toEntity(Maintenance maintenance, boolean lazy) {
        if (null == maintenance) {
            return null;
        }
        GmoMaintenance gmoMaintenance = new GmoMaintenance();
        gmoMaintenance.setGmoMaintenanceId(maintenance.getId());
        gmoMaintenance.setGmoMaintenanceCode(maintenance.getCode() != null ? maintenance.getCode().toUpperCase() : null);
        gmoMaintenance.setGmoMaintenanceDescription(maintenance.getDescription());
        gmoMaintenance.setGmoMaintenanceStartDate(maintenance.getStartDate ());
        gmoMaintenance.setGmoMaintenanceEndDate(maintenance.getEndDate ());
        gmoMaintenance.setGmoMaintenanceTotalPrice (maintenance.getTotalPrice ());
        gmoMaintenance.setGmoMaintenanceMileage (maintenance.getMileage ());
        gmoMaintenance.setGmoInterventionDate (maintenance.getInterventionDate ());
        gmoMaintenance.setGmoAgent (maintenance.getAgent ());
        gmoMaintenance.setGmoEmployer (maintenance.getEmployer ());
        gmoMaintenance.setGmoTriggerDay(maintenance.getTriggerDay());
        gmoMaintenance.setGmoTriggerDate(maintenance.getTriggerDate());
        gmoMaintenance.setGmoDeclaredDate(maintenance.getDeclaredDate());
        gmoMaintenance.setGmoObservation(maintenance.getObservation());
        gmoMaintenance.setGmoDuration(maintenance.getDuration());
        gmoMaintenance.setCreatedBy(maintenance.getCreatedBy());
        gmoMaintenance.setUpdatedBy(maintenance.getUpdatedBy());
        gmoMaintenance.setCreationDate(maintenance.getCreationDate());
        gmoMaintenance.setUpdateDate(maintenance.getUpdateDate());

        if (!lazy) {
            gmoMaintenance.setGmoMaintenanceType(MaintenanceTypeMapper.toEntity(maintenance.getMaintenanceType(), true));
            gmoMaintenance.setGmoMaintenanceState(MaintenanceStateMapper.toEntity(maintenance.getMaintenanceState(), true));
            gmoMaintenance.setGmoPatrimony(PatrimonyMapper.toEntity(maintenance.getPatrimony(),true));

            gmoMaintenance.setGmoPeriodicityType(PeriodicityTypeMapper.toEntity(maintenance.getPeriodicityType(),false));
            gmoMaintenance.setGmoResponsability (ResponsabilityMapper.toEntity (maintenance.getResponsability(), false));
            gmoMaintenance.setGmoServiceProvider(ServiceProviderMapper.toEntity(maintenance.getServiceProvider(),false));
            gmoMaintenance.setGmoService (ResponsabilityMapper.toEntity (maintenance.getService(), false));
            gmoMaintenance.setGmoProgramType(ProgramTypeMapper.toEntity(maintenance.getProgramType(),false));
            gmoMaintenance.setGmoMaintenancePlan(MaintenancePlanMapper.toEntity(maintenance.getMaintenancePlan(),true));
            gmoMaintenance.setGmoActionMaintenances(ActionMaintenanceMapper.toEntities (maintenance.getActionMaintenances(), false));
            oneToMany(gmoMaintenance);

        }
        return gmoMaintenance;
    }
    private static void oneToMany(GmoMaintenance gmoMaintenance) {
       // if(null !=gmoMaintenance.getGmoActionMaintenances()){
            gmoMaintenance.getGmoActionMaintenances().forEach(
                gmoAction -> {
                //  if(0>=gmoMaintenance.getGmoMaintenanceId()) {
                      //  gmoAction.setGmoActionMaintenanceId(0);
                       // gmoAction.getGmoActionLineMaintenances().forEach(
                     //           gmoActionLine->{
                      //              gmoActionLine.setGmoActionLineId(0);
                       //         }
                      //  );
                        gmoAction.setCreationDate(EmsDate.getDateNow());
                        gmoAction.setGmoMaintenance(gmoMaintenance);
                    //}
              }
        );}
   // }
    public static Maintenance toDto(GmoMaintenance gmoMaintenance, boolean lazy) {
        if (null == gmoMaintenance) {
            return null;
        }
        Maintenance maintenance = new Maintenance();
        maintenance.setId(gmoMaintenance.getGmoMaintenanceId());
        maintenance.setCode(gmoMaintenance.getGmoMaintenanceCode());
        maintenance.setDescription(gmoMaintenance.getGmoMaintenanceDescription());
        maintenance.setStartDate (gmoMaintenance.getGmoMaintenanceStartDate());
        maintenance.setEndDate (gmoMaintenance.getGmoMaintenanceEndDate());
        maintenance.setTotalPrice (gmoMaintenance.getGmoMaintenanceTotalPrice ());
        maintenance.setMileage (gmoMaintenance.getGmoMaintenanceMileage ());

        maintenance.setTriggerDay(gmoMaintenance.getGmoTriggerDay());
        maintenance.setTriggerDate(gmoMaintenance.getGmoTriggerDate());
        maintenance.setInterventionDate (gmoMaintenance.getGmoInterventionDate ());
        maintenance.setAgent (gmoMaintenance.getGmoAgent ());
        maintenance.setEmployer (gmoMaintenance.getGmoEmployer ());

        maintenance.setDuration (gmoMaintenance.getGmoDuration ()  );

        maintenance.setDeclaredDate (gmoMaintenance.getGmoDeclaredDate ());
        maintenance.setObservation (gmoMaintenance.getGmoObservation ());

        maintenance.setCreatedBy(gmoMaintenance.getCreatedBy());
        maintenance.setUpdatedBy(gmoMaintenance.getUpdatedBy());
        maintenance.setCreationDate(gmoMaintenance.getCreationDate());
        maintenance.setUpdateDate(gmoMaintenance.getUpdateDate());
        if (!lazy) {
            maintenance.setMaintenanceType(MaintenanceTypeMapper.toDto(gmoMaintenance.getGmoMaintenanceType(), true));
            maintenance.setMaintenanceState(MaintenanceStateMapper.toDto(gmoMaintenance.getGmoMaintenanceState(), true));
            maintenance.setPatrimony(PatrimonyMapper.toDto(gmoMaintenance.getGmoPatrimony(),true));
            maintenance.setActionMaintenances (ActionMaintenanceMapper.toDtos (gmoMaintenance.getGmoActionMaintenances(), false));

            maintenance.setPeriodicityType(PeriodicityTypeMapper.toDto(gmoMaintenance.getGmoPeriodicityType(),true));
            maintenance.setResponsability (ResponsabilityMapper.toDto (gmoMaintenance.getGmoResponsability (), true));
            maintenance.setServiceProvider(ServiceProviderMapper.toDto(gmoMaintenance.getGmoServiceProvider(),true));
            maintenance.setService(ResponsabilityMapper.toDto (gmoMaintenance.getGmoService (), true));
            maintenance.setProgramType(ProgramTypeMapper.toDto(gmoMaintenance.getGmoProgramType(),true));

            maintenance.setMaintenancePlan(MaintenancePlanMapper.toDto(gmoMaintenance.getGmoMaintenancePlan(),true));

        }

        return maintenance;
    }

    public static List<Maintenance> toDtos(Iterable<? extends GmoMaintenance> mntMaintenances, boolean lazy) {
        if (null == mntMaintenances) {
            return null;
        }
        List<Maintenance> maintenances = new ArrayList<>();
        for (GmoMaintenance gmoMaintenance : mntMaintenances) {
            maintenances.add(toDto(gmoMaintenance, lazy));
        }
        return maintenances;
    }

    public static Set<GmoMaintenance> toEntities(Set<? extends Maintenance> maintenances, boolean lazy) {
        if (null == maintenances) {
            return null;
        }
        Set<GmoMaintenance> gmoMaintenances = new HashSet<>();

        for (Maintenance maintenance : maintenances) {
            gmoMaintenances.add(toEntity(maintenance, lazy));
        }
        return gmoMaintenances;
    }

    public static Set<Maintenance> toDtos(Set<? extends GmoMaintenance> gmoMaintenances, boolean lazy) {
        if (null == gmoMaintenances) {
            return null;
        }
        Set<Maintenance> maintenances = new HashSet<>();
        for (GmoMaintenance gmoMaintenance : gmoMaintenances) {
            maintenances.add(toDto(gmoMaintenance, lazy));
        }
        return maintenances;
    }

}

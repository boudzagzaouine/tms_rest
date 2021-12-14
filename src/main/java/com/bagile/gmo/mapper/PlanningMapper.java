package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Planning;
import com.bagile.gmo.entities.TmsPlanning;

import java.util.*;

public class PlanningMapper {
    public PlanningMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsPlanningId");
        map.put("code", "tmsPlanningCode");
        map.put("description", "tmsPlanningDescription");
        map.put("day", "tmsPlanningDay");
        map.put("closingDay", "tmsPlanningClosingDay");
        map.put("account", "cmdAccount");
        map.put("supplier", "rcpSupplier");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsPlanning toEntity(Planning planning, boolean lazy) {
        if (null == planning) {
            return null;
        }
        TmsPlanning tmsPlanning = new TmsPlanning();
        tmsPlanning.setTmsPlanningId(planning.getId());
        tmsPlanning.setTmsPlanningDay(planning.getDay() != null ? planning.getDay().toUpperCase() : null);
        tmsPlanning.setTmsPlanningMorning (planning.getMorning ());
        tmsPlanning.setTmsPlanningMorningTimeStart (planning.getMorningTimeStart ());
        tmsPlanning.setTmsPlanningMorningTimeEnd (planning.getMorningTimeEnd ());
        tmsPlanning.setTmsPlanningEvering (planning.getEvering ());
        tmsPlanning.setTmsPlanningEveringTimeStart (planning.getEveringTimeStart ());
        tmsPlanning.setTmsPlanningEveringTimeEnd (planning.getEveringTimeEnd ());
        tmsPlanning.setTmsPlanningClosingDay (planning.getClosingDay());

        tmsPlanning.setCreatedBy(planning.getCreatedBy());
        tmsPlanning.setUpdatedBy(planning.getUpdatedBy());
        tmsPlanning.setCreationDate(planning.getCreationDate());
        tmsPlanning.setUpdateDate(planning.getUpdateDate());

          if(!lazy){
              tmsPlanning.setOwnOwner(OwnerMapper.toEntity(planning.getOwner(),true));
              tmsPlanning.setCmdAccount(AccountMapper.toEntity(planning.getAccount(),true));
              tmsPlanning.setRcpSupplier(SupplierMapper.toEntity(planning.getSupplier(),true));



          }

        return tmsPlanning;

    }



    public static Planning toDto(TmsPlanning tmsPlanning, boolean lazy) {
        if (null == tmsPlanning) {
            return null;
        }
        Planning planning = new Planning();
        planning.setId(tmsPlanning.getTmsPlanningId());
        planning.setDay(tmsPlanning.getTmsPlanningDay());
        planning.setMorning (tmsPlanning.getTmsPlanningMorning ());
        planning.setMorningTimeStart (tmsPlanning.getTmsPlanningMorningTimeStart ());
        planning.setMorningTimeEnd (tmsPlanning.getTmsPlanningMorningTimeEnd ());
        planning.setClosingDay(tmsPlanning.getTmsPlanningClosingDay ());

        planning.setEvering (tmsPlanning.getTmsPlanningEvering ());
        planning.setEveringTimeStart (tmsPlanning.getTmsPlanningEveringTimeStart ());
        planning.setEveringTimeEnd (tmsPlanning.getTmsPlanningEveringTimeEnd ());

        if(!lazy){
      planning.setOwner(OwnerMapper.toDto(tmsPlanning.getOwnOwner(),true));
            planning.setAccount(AccountMapper.toDto(tmsPlanning.getCmdAccount(),true));
            planning.setSupplier(SupplierMapper.toDto(tmsPlanning.getRcpSupplier(),true));


        }
        return planning;

    }





    public static List<Planning> toDtos(Iterable<? extends TmsPlanning> gmoPlannings, boolean lazy) {
        if (null == gmoPlannings) {
            return null;
        }
        List<Planning> plannings = new ArrayList<>();

        for (TmsPlanning gmoPlanning : gmoPlannings) {
            plannings.add(toDto(gmoPlanning, lazy));
        }
        return plannings;
    }

    public static Set<TmsPlanning> toEntities(Iterable<? extends Planning> planningType, boolean lazy) {
        if (null == planningType) {
            return null;
        }
        Set<TmsPlanning> gmoPlannings = new HashSet<>();
        for (Planning planning : planningType) {
            gmoPlannings.add(toEntity(planning, lazy));
        }
        return gmoPlannings;
    }

}

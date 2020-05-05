package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.MaintenanceState;
import com.bagile.gmo.entities.GmoMaintenanceState;

public class MaintenanceStateMapper {
    private MaintenanceStateMapper(){

    }
    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }
    static {
        map = new HashMap<>();
        map.put("id","tmsMaintenanceStateId");
        map.put("code","tmsMaintenanceStateCode");
        map.put("descriptif","tmsMaintenanceStateDescription");



        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static MaintenanceState toDto(GmoMaintenanceState gmoState, boolean lazy) {
        if (null == gmoState) {
            return null;
        }
        MaintenanceState state = new MaintenanceState();
        state.setId(gmoState.getGmoMaintenanceStateId());
        state.setCode(gmoState.getGmoMaintenanceStateCode());
        state.setDescription(gmoState.getGmoMaintenanceStateDescription());

        state.setCreatedBy(gmoState.getCreatedBy());
        state.setUpdatedBy(gmoState.getUpdatedBy());
        state.setCreationDate(gmoState.getCreationDate());
        state.setUpdateDate(gmoState.getUpdateDate());
        if(!lazy) {
           // state.setCreationDate(tmsState.getTmsMaintenanceStateCreationDate());
          //  state.setCreationUser(UserMapper.toDto(tmsState.getTmsMaintenanceStateCreationUser(),true));
           // state.setTypeMaintenance(TypeMaintenanceMapper.toDto(tmsState.getTmsMaintenanceStateType()));
           // state.setMaintenancePlans(MaintenancePlanMapper.toDtos(tmsState.getTmsMaintenanceStatePlans(),true));
           // state.setUpDateDate(tmsState.getTmsMaintenanceStateUpDateDate());
        }
        return state;
    }

    public static GmoMaintenanceState toEntity(MaintenanceState state, boolean lazy) {
        if(null == state) {
            return null;
        }
        GmoMaintenanceState gmoState = new GmoMaintenanceState();
        gmoState.setGmoMaintenanceStateId(state.getId());
        gmoState.setGmoMaintenanceStateCode(state.getCode());
        gmoState.setGmoMaintenanceStateDescription(state.getDescription());


        gmoState.setCreatedBy(state.getCreatedBy());
        gmoState.setUpdatedBy(state.getUpdatedBy());
        gmoState.setCreationDate(state.getCreationDate());
        gmoState.setUpdateDate(state.getUpdateDate());

        if(!lazy) {
           // tmsState.setTmsMaintenanceStateCreationDate(state.getCreationDate());
           // tmsState.setTmsMaintenanceStateCreationUser(UserMapper.toEntity(state.getCreationUser(),true));
           // tmsState.setTmsMaintenanceStateType(TypeMaintenanceMapper.toEntity(state.getTypeMaintenance()));
           // tmsState.setTmsMaintenanceStateUpDateDate(state.getUpDateDate());
           // tmsState.setTmsMaintenanceStatePlans(MaintenancePlanMapper.toEntities(state.getMaintenancePlans(),true));
        }
        return gmoState;
    }

    public static Set<MaintenanceState> toDtos(Set<? extends GmoMaintenanceState> gmoStates, boolean lazy) {
        if(null == gmoStates) {
            return null;
        }
        Set<MaintenanceState> list = new HashSet<MaintenanceState>();
        for(GmoMaintenanceState gmoState: gmoStates) {
            list.add(toDto(gmoState, lazy));
        }
        return list;
    }



    public static List<MaintenanceState> toDtos(Iterable<? extends GmoMaintenanceState> gmoStates, boolean lazy) {
        if(null == gmoStates) {
            return null;
        }
        List<MaintenanceState> list = new ArrayList<MaintenanceState>();
        for(GmoMaintenanceState gmoState: gmoStates) {
            list.add(toDto(gmoState, lazy));
        }
        return list;
    }

    public static Set<GmoMaintenanceState> toEntities(Set<? extends MaintenanceState> states, boolean lazy) {
        if(null == states) {
            return null;
        }
        Set<GmoMaintenanceState> list = new HashSet<GmoMaintenanceState>();
        for(MaintenanceState state: states) {
            list.add(toEntity(state, lazy));
        }
        return list;
    }
}

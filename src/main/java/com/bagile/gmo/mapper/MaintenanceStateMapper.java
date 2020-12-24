package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.MaintenanceState;
import com.bagile.gmo.entities.GmoMaintenanceState;

import java.util.*;

public class MaintenanceStateMapper {
    private MaintenanceStateMapper(){

    }
    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }
    static {
        map = new HashMap<>();
        map.put("id","gmoMaintenanceStateId");
        map.put("code","gmoMaintenanceStateCode");
        map.put("description","gmoMaintenanceStateDescription");



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
           // state.setCreationDate(gmoState.getGmoMaintenanceStateCreationDate());
          //  state.setCreationUser(UserMapper.toDto(gmoState.getGmoMaintenanceStateCreationUser(),true));
           // state.setTypeMaintenance(TypeMaintenanceMapper.toDto(gmoState.getGmoMaintenanceStateType()));
            state.setOwner(OwnerMapper.toDto(gmoState.getOwnOwner(),true));
           // state.setUpDateDate(gmoState.getGmoMaintenanceStateUpDateDate());
        }
        return state;
    }

    public static GmoMaintenanceState toEntity(MaintenanceState state, boolean lazy) {
        if(null == state) {
            return null;
        }
        GmoMaintenanceState gmoState = new GmoMaintenanceState();
        gmoState.setGmoMaintenanceStateId(state.getId());
        gmoState.setGmoMaintenanceStateCode(state.getCode().toUpperCase());
        gmoState.setGmoMaintenanceStateDescription(state.getDescription());


        gmoState.setCreatedBy(state.getCreatedBy());
        gmoState.setUpdatedBy(state.getUpdatedBy());
        gmoState.setCreationDate(state.getCreationDate());
        gmoState.setUpdateDate(state.getUpdateDate());

        if(!lazy) {
           // gmoState.setGmoMaintenanceStateCreationDate(state.getCreationDate());
           // gmoState.setGmoMaintenanceStateCreationUser(UserMapper.toEntity(state.getCreationUser(),true));
            gmoState.setOwnOwner(OwnerMapper.toEntity(state.getOwner(),true));
           // gmoState.setGmoMaintenanceStateUpDateDate(state.getUpDateDate());
           // gmoState.setGmoMaintenanceStatePlans(MaintenancePlanMapper.toEntities(state.getMaintenancePlans(),true));
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

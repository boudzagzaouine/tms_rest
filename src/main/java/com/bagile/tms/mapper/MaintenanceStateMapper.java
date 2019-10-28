package com.bagile.tms.mapper;

import com.bagile.tms.dto.MaintenanceState;
import com.bagile.tms.entities.TmsMaintenanceState;

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
        map.put("id","TmsMaintenanceStateid");
        map.put("code","TmsMaintenanceStatecode");
        map.put("descriptif","TmsMaintenanceStatedescriptif");
        map.put("creationDate","tmsMaintenanceStateDescriptif");

    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static MaintenanceState toDto(TmsMaintenanceState tmsState, boolean lazy) {
        if (null == tmsState) {
            return null;
        }
        MaintenanceState state = new MaintenanceState();
        state.setId(tmsState.getTmsMaintenanceStateId());
        state.setCode(tmsState.getTmsMaintenanceStateCode());
        state.setDescriptif(tmsState.getTmsMaintenanceStateDescription());
        state.setCreationDate(tmsState.getTmsMaintenanceStateCreationDate());
        if(!lazy) {
           // state.setCreationDate(tmsState.getTmsMaintenanceStateCreationDate());
          //  state.setCreationUser(UserMapper.toDto(tmsState.getTmsMaintenanceStateCreationUser(),true));
           // state.setTypeMaintenance(TypeMaintenanceMapper.toDto(tmsState.getTmsMaintenanceStateType()));
           // state.setMaintenancePlans(MaintenancePlanMapper.toDtos(tmsState.getTmsMaintenanceStatePlans(),true));
           // state.setUpDateDate(tmsState.getTmsMaintenanceStateUpDateDate());
        }
        return state;
    }

    public static TmsMaintenanceState toEntity(MaintenanceState state, boolean lazy) {
        if(null == state) {
            return null;
        }
        TmsMaintenanceState tmsState = new TmsMaintenanceState();
        tmsState.setTmsMaintenanceStateId(state.getId());
        tmsState.setTmsMaintenanceStateCode(state.getCode());
        tmsState.setTmsMaintenanceStateDescription(state.getDescriptif());
        tmsState.setTmsMaintenanceStateCreationDate(state.getCreationDate());

        if(!lazy) {
           // tmsState.setTmsMaintenanceStateCreationDate(state.getCreationDate());
           // tmsState.setTmsMaintenanceStateCreationUser(UserMapper.toEntity(state.getCreationUser(),true));
           // tmsState.setTmsMaintenanceStateType(TypeMaintenanceMapper.toEntity(state.getTypeMaintenance()));
           // tmsState.setTmsMaintenanceStateUpDateDate(state.getUpDateDate());
           // tmsState.setTmsMaintenanceStatePlans(MaintenancePlanMapper.toEntities(state.getMaintenancePlans(),true));
        }
        return tmsState;
    }

    public static Set<MaintenanceState> toDtos(Set<TmsMaintenanceState> tmsStates, boolean lazy) {
        if(null == tmsStates) {
            return null;
        }
        Set<MaintenanceState> list = new HashSet<MaintenanceState>();
        for(TmsMaintenanceState tmsState: tmsStates) {
            list.add(toDto(tmsState, lazy));
        }
        return list;
    }

    public static List<MaintenanceState> toDtos(List<TmsMaintenanceState> tmsStates, boolean lazy) {
        if(null == tmsStates) {
            return null;
        }
        List<MaintenanceState> list = new ArrayList<MaintenanceState>();
        for(TmsMaintenanceState tmsState: tmsStates) {
            list.add(toDto(tmsState, lazy));
        }
        return list;
    }

    public static List<MaintenanceState> toDtos(Iterable<TmsMaintenanceState> tmsStates, boolean lazy) {
        if(null == tmsStates) {
            return null;
        }
        List<MaintenanceState> list = new ArrayList<MaintenanceState>();
        for(TmsMaintenanceState tmsState: tmsStates) {
            list.add(toDto(tmsState, lazy));
        }
        return list;
    }

    public static Set<TmsMaintenanceState> toEntities(Set<MaintenanceState> states, boolean lazy) {
        if(null == states) {
            return null;
        }
        Set<TmsMaintenanceState> list = new HashSet<TmsMaintenanceState>();
        for(MaintenanceState state: states) {
            list.add(toEntity(state, lazy));
        }
        return list;
    }
}

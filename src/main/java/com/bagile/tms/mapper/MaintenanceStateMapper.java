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
        map.put("id","idMaintenanceState");
        map.put("state","tmsMaintenanceState");
        map.put("vehicle","tmsMaintenanceStateVehicle");
        map.put("code","tmsMaintenanceStateCode");
        map.put("descriptif","tmsMaintenanceStateDescriptif");
        map.put("date","tmsMaintenanceStateDate");
        map.put("title","tmsMaintenanceStateTitle");
        map.put("creationDate","tmsMaintenanceStateCreationDate");
        map.put("creationUser","tmsMaintenanceStateCreationUser");
        map.put("upDateDate","tmsMaintenanceStateUpDateDate");
        map.put("type","tmsMaintenanceStateType");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static MaintenanceState toDto(TmsMaintenanceState tmsState, boolean lazy) {
        if (null == tmsState) {
            return null;
        }
        MaintenanceState state = new MaintenanceState();
        state.setCode(tmsState.getTmsMaintenanceStateCode());
        state.setDate(tmsState.getTmsMaintenanceStateDate());
        state.setDescriptif(tmsState.getTmsMaintenanceStateDescriptif());
        state.setId(tmsState.getIdMaintenanceState());
        state.setTitle(tmsState.getTmsMaintenanceStateTitle());
        if(!lazy) {
            state.setCreationDate(tmsState.getTmsMaintenanceStateCreationDate());
            state.setCreationUser(UserMapper.toDto(tmsState.getTmsMaintenanceStateCreationUser(),true));
            state.setTypeMaintenance(TypeMaintenanceMapper.toDto(tmsState.getTmsMaintenanceStateType()));
            state.setUpDateDate(tmsState.getTmsMaintenanceStateUpDateDate());
        }
        return state;
    }

    public static TmsMaintenanceState toEntity(MaintenanceState state, boolean lazy) {
        if(null == state) {
            return null;
        }
        TmsMaintenanceState tmsState = new TmsMaintenanceState();
        tmsState.setTmsMaintenanceStateCode(state.getCode());
        tmsState.setTmsMaintenanceStateDate(state.getDate());
        tmsState.setTmsMaintenanceStateDescriptif(state.getDescriptif());
        tmsState.setIdMaintenanceState(state.getId());
        tmsState.setTmsMaintenanceStateTitle(state.getTitle());
        if(!lazy) {
            tmsState.setTmsMaintenanceStateCreationDate(state.getCreationDate());
            tmsState.setTmsMaintenanceStateCreationUser(UserMapper.toEntity(state.getCreationUser(),true));
            tmsState.setTmsMaintenanceStateType(TypeMaintenanceMapper.toEntity(state.getTypeMaintenance()));
            tmsState.setTmsMaintenanceStateUpDateDate(state.getUpDateDate());
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

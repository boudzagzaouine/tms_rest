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

    public static MaintenanceState toDto(TmsMaintenanceState tmsState) {
        if (null == tmsState) {
            return null;
        }
        MaintenanceState state = new MaintenanceState();
        state.setCode(tmsState.getTmsMaintenanceStateCode());
        state.setCreationDate(tmsState.getTmsMaintenanceStateCreationDate());
        state.setCreationUser(tmsState.getTmsMaintenanceStateCreationUser());
        state.setDate(tmsState.getTmsMaintenanceStateDate());
        state.setDescriptif(tmsState.getTmsMaintenanceStateDescriptif());
        state.setId(tmsState.getIdMaintenanceState());
        state.setTitle(tmsState.getTmsMaintenanceStateTitle());
        state.setTypeMaintenance(tmsState.getTmsMaintenanceStateType());
        state.setUpDateDate(tmsState.getTmsMaintenanceStateUpDateDate());
        state.setVehicle(tmsState.getTmsMaintenanceStateVehicle());
        return state;
    }

    public static TmsMaintenanceState toEntity(MaintenanceState state) {
        if(null == state) {
            return null;
        }
        TmsMaintenanceState tmsState = new TmsMaintenanceState();
        tmsState.setIdMaintenanceState(state.getId());
        tmsState.setTmsMaintenanceStateCode(state.getCode());
        tmsState.setTmsMaintenanceStateCreationDate(state.getCreationDate());
        tmsState.setTmsMaintenanceStateCreationUser(state.getCreationUser());
        tmsState.setTmsMaintenanceStateDate(state.getDate());
        tmsState.setTmsMaintenanceStateDescriptif(state.getDescriptif());
        tmsState.setTmsMaintenanceStateTitle(state.getTitle());
        tmsState.setTmsMaintenanceStateType(state.getTypeMaintenance());
        tmsState.setTmsMaintenanceStateUpDateDate(state.getUpDateDate());
        tmsState.setTmsMaintenanceStateVehicle(state.getVehicle());
        return tmsState;
    }

    public static Set<MaintenanceState> toDtos(Set<TmsMaintenanceState> tmsStates) {
        if(null == tmsStates) {
            return null;
        }
        Set<MaintenanceState> list = new HashSet<MaintenanceState>();
        for(TmsMaintenanceState tmsState: tmsStates) {
            list.add(toDto(tmsState));
        }
        return list;
    }

    public static List<MaintenanceState> toDtos(List<TmsMaintenanceState> tmsStates) {
        if(null == tmsStates) {
            return null;
        }
        List<MaintenanceState> list = new ArrayList<MaintenanceState>();
        for(TmsMaintenanceState tmsState: tmsStates) {
            list.add(toDto(tmsState));
        }
        return list;
    }

    public static List<MaintenanceState> toDtos(Iterable<TmsMaintenanceState> tmsStates) {
        if(null == tmsStates) {
            return null;
        }
        List<MaintenanceState> list = new ArrayList<MaintenanceState>();
        for(TmsMaintenanceState tmsState: tmsStates) {
            list.add(toDto(tmsState));
        }
        return list;
    }

    public static Set<TmsMaintenanceState> toEntities(Set<MaintenanceState> states) {
        if(null == states) {
            return null;
        }
        Set<TmsMaintenanceState> list = new HashSet<TmsMaintenanceState>();
        for(MaintenanceState state: states) {
            list.add(toEntity(state));
        }
        return list;
    }
}

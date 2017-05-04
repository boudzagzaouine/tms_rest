package com.sinno.ems.mapper;

import com.sinno.ems.dto.VehiculeStatus;
import com.sinno.ems.entities.TmsVehicleStatus;

import java.util.*;

/**
 * Created by bouzi on 3/23/2017.
 */


public class VehicleStatusMapper {
    public VehicleStatusMapper() {
    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsVehicleStatusId");
        map.put("codeStatusVehicule", "tmsVehiculeStatusCode");
        map.put("activity", "tmsVehiculeStatusActivity");
        map.put("descritpion", "tmsVehiculeStatusDescritpion");



    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static TmsVehicleStatus toEntity(VehiculeStatus vehiculeStatus , boolean lazy){
        if (null == vehiculeStatus) {
            return null;
        }
        TmsVehicleStatus tmsVehicleStatus = new TmsVehicleStatus();

        tmsVehicleStatus.setTmsVehiculeStatusId(vehiculeStatus.getId());
        tmsVehicleStatus.setTmsVehiculeStatusCode(vehiculeStatus.getCodeStatusVehicule()!=null ? vehiculeStatus.getCodeStatusVehicule().toUpperCase(): null);
        tmsVehicleStatus.setTmsVehiculeStatusDescritpion(vehiculeStatus.getDescription());
        tmsVehicleStatus.setTmsVehiculeStatusActivity(vehiculeStatus.getActivity());
        if (!lazy) {
            tmsVehicleStatus.setTmsVehiculeStatusVehicules(VehicleMapper.toEntities(vehiculeStatus.getVehicules(),true));
//
        }
        return tmsVehicleStatus;
    }

    public static VehiculeStatus toDto(TmsVehicleStatus tmsVehicleStatus, boolean lazy){
        if (null == tmsVehicleStatus) {
            return null;
        }
        VehiculeStatus vehiculeStatus = new VehiculeStatus();

        vehiculeStatus.setId(tmsVehicleStatus.getTmsVehiculeStatusId());
        vehiculeStatus.setCodeStatusVehicule(tmsVehicleStatus.getTmsVehiculeStatusCode());
        vehiculeStatus.setDescription(tmsVehicleStatus.getTmsVehiculeStatusDescritpion());
        vehiculeStatus.setActivity(tmsVehicleStatus.getTmsVehiculeStatusActivity());
        if (!lazy) {
            vehiculeStatus.setVehicules(VehicleMapper.toDtos(tmsVehicleStatus.getTmsVehiculeStatusVehicules(),true));
//
        }
        return vehiculeStatus;
    }

    public static List<VehiculeStatus>toDtos(List<TmsVehicleStatus> tmsVehicleStatuses, boolean lazy){
        if (null == tmsVehicleStatuses) {
            return null;
        }
        List<VehiculeStatus>vehiculeStatuses = new ArrayList<>();

        for ( TmsVehicleStatus tmsVehicleStatus : tmsVehicleStatuses) {
            vehiculeStatuses.add(toDto(tmsVehicleStatus,lazy));
        }
        return vehiculeStatuses;
    }


    public static List<VehiculeStatus>toDtos(Iterable<TmsVehicleStatus>tmsVehicleStatuses , boolean lazy){
        if (null == tmsVehicleStatuses) {
            return null;
        }
        List<VehiculeStatus>vehiculeStatuses = new ArrayList<>();

        for ( TmsVehicleStatus tmsVehicleStatus :tmsVehicleStatuses) {
            vehiculeStatuses.add(toDto(tmsVehicleStatus,lazy));
        }
        return vehiculeStatuses;
    }
    public static Set<TmsVehicleStatus>toEntities(Set<VehiculeStatus>vehiculeStatuses , boolean lazy){
        if (null == vehiculeStatuses) {
            return null;
        }
        Set<TmsVehicleStatus> tmsVehicleStatuses = new HashSet<>();
        for ( VehiculeStatus vehiculeStatus:vehiculeStatuses) {
            tmsVehicleStatuses.add(toEntity(vehiculeStatus,lazy));
        }
        return tmsVehicleStatuses;
    }

    public static Set<VehiculeStatus>toDtos(Set<TmsVehicleStatus> tmsVehicleStatuses, boolean lazy){
        if (null == tmsVehicleStatuses) {
            return null;
        }
        Set<VehiculeStatus>vehiculeStatuses = new HashSet<>();
        for (TmsVehicleStatus tmsVehicleStatus : tmsVehicleStatuses) {
            vehiculeStatuses.add(toDto(tmsVehicleStatus, lazy));
        }
        return  vehiculeStatuses;
}


}

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

        map.put("id", "prmVehicleStatusId");
        map.put("codeStatusVehicule", "prmVehicleStatusCodeStatusVehicule");
        map.put("descritpion", "prmVehicleStatusDescription");
        map.put("vehicule", "vehicules");


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

        tmsVehicleStatus.setPrmVehiculeStatusId(vehiculeStatus.getId());
        tmsVehicleStatus.setPrmVehiculeStatusCode(vehiculeStatus.getCodeStatusVehicule()!=null ? vehiculeStatus.getCodeStatusVehicule().toUpperCase(): null);
        tmsVehicleStatus.setPrmVehiculeStatusDescritpion(vehiculeStatus.getDescritpion());
        if (!lazy) {
            tmsVehicleStatus.setPrmVehiculeStatusVehicules(VehicleMapper.toEntities(vehiculeStatus.getVehicules(),true));
//
        }
        return tmsVehicleStatus;
    }

    public static VehiculeStatus toDto(TmsVehicleStatus tmsVehicleStatus, boolean lazy){
        if (null == tmsVehicleStatus) {
            return null;
        }
        VehiculeStatus vehiculeStatus = new VehiculeStatus();

        vehiculeStatus.setId(tmsVehicleStatus.getPrmVehiculeStatusId());
        vehiculeStatus.setCodeStatusVehicule(tmsVehicleStatus.getPrmVehiculeStatusCode());
        vehiculeStatus.setDescritpion(tmsVehicleStatus.getPrmVehiculeStatusDescritpion());
        if (!lazy) {
            vehiculeStatus.setVehicules(VehicleMapper.toDtos(tmsVehicleStatus.getPrmVehiculeStatusVehicules(),true));
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


    public static List<VehiculeStatus>toDtos(Iterable<TmsVehicleStatus>prmVehicleStatuses , boolean lazy){
        if (null == prmVehicleStatuses) {
            return null;
        }
        List<VehiculeStatus>vehiculeStatuses = new ArrayList<>();

        for ( TmsVehicleStatus tmsVehicleStatus :prmVehicleStatuses) {
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

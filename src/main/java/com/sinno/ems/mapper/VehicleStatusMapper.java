package com.sinno.ems.mapper;

import com.sinno.ems.dto.VehiculeStatus;
import com.sinno.ems.entities.PrmVehicleStatus;

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


    public static PrmVehicleStatus toEntity(VehiculeStatus vehiculeStatus , boolean lazy){
        if (null == vehiculeStatus) {
            return null;
        }
        PrmVehicleStatus prmVehicleStatus = new PrmVehicleStatus();

        prmVehicleStatus.setPrmVehiculeStatusId(vehiculeStatus.getId());
        prmVehicleStatus.setPrmVehiculeStatusCode(vehiculeStatus.getCodeStatusVehicule()!=null ? vehiculeStatus.getCodeStatusVehicule().toUpperCase(): null);
        prmVehicleStatus.setPrmVehiculeStatusDescritpion(vehiculeStatus.getDescritpion());
        if (!lazy) {
           //
//
        }
        return prmVehicleStatus;
    }

    public static VehiculeStatus toDto(PrmVehicleStatus prmVehicleStatus , boolean lazy){
        if (null == prmVehicleStatus) {
            return null;
        }
        VehiculeStatus vehiculeStatus = new VehiculeStatus();

        vehiculeStatus.setId(prmVehicleStatus.getPrmVehiculeStatusId());
        vehiculeStatus.setCodeStatusVehicule(prmVehicleStatus.getPrmVehiculeStatusCode());
        vehiculeStatus.setDescritpion(prmVehicleStatus.getPrmVehiculeStatusDescritpion());
        if (!lazy) {
            //
//
        }
        return vehiculeStatus;
    }

    public static List<VehiculeStatus>toDtos(List<PrmVehicleStatus>prmVehicleStatuses , boolean lazy){
        if (null == prmVehicleStatuses) {
            return null;
        }
        List<VehiculeStatus>vehiculeStatuses = new ArrayList<>();

        for ( PrmVehicleStatus prmVehicleStatus:prmVehicleStatuses) {
            vehiculeStatuses.add(toDto(prmVehicleStatus,lazy));
        }
        return vehiculeStatuses;
    }


    public static List<VehiculeStatus>toDtos(Iterable<PrmVehicleStatus>prmVehicleStatuses , boolean lazy){
        if (null == prmVehicleStatuses) {
            return null;
        }
        List<VehiculeStatus>vehiculeStatuses = new ArrayList<>();

        for ( PrmVehicleStatus prmVehicleStatus:prmVehicleStatuses) {
            vehiculeStatuses.add(toDto(prmVehicleStatus,lazy));
        }
        return vehiculeStatuses;
    }
    public static Set<PrmVehicleStatus>toEntities(Set<VehiculeStatus>vehiculeStatuses , boolean lazy){
        if (null == vehiculeStatuses) {
            return null;
        }
        Set<PrmVehicleStatus>prmVehicleStatuses = new HashSet<>();
        for ( VehiculeStatus vehiculeStatus:vehiculeStatuses) {
            prmVehicleStatuses.add(toEntity(vehiculeStatus,lazy));
        }
        return prmVehicleStatuses;
    }

    public static Set<VehiculeStatus>toDtos(Set<PrmVehicleStatus>prmVehicleStatuses , boolean lazy){
        if (null == prmVehicleStatuses) {
            return null;
        }
        Set<VehiculeStatus>vehiculeStatuses = new HashSet<>();
        for (PrmVehicleStatus prmVehicleStatus:prmVehicleStatuses) {
            vehiculeStatuses.add(toDto(prmVehicleStatus , lazy));
        }
        return  vehiculeStatuses;
}


}

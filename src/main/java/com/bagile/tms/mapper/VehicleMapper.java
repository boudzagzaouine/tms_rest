package com.bagile.tms.mapper;

import com.bagile.tms.dto.Vehicle;
import com.bagile.tms.entities.TmsVehicle;

import java.util.*;

public class VehicleMapper {
    public VehicleMapper() {
    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsVehicleId");
        map.put("code", "tmsVehicleCode");
        map.put("nbreEssieux", "tmsVehicleNbreEssieux");
        map.put("emptyWeight", "tmsVehicleEmptyWeight");
        map.put("dateOfRegistration", "tmsVehicleDateOfRegistration");
        map.put("brand", "tmsVehicleBrand");
        map.put("model", "tmsVehicleModel");
        map.put("status", "tmsVehicleStatus");
        map.put("type", "tmsVehicleType");
        map.put("policeAssurance", "tmsVehiclePoliceAssurance");
        map.put("maintenancePlan", "tmsVehicleMaintenancePlan");

        map.put("matricule", "tmsVehicleMatricule");
        map.put("dateCreation", "tmsVehicleDateCreation");
        map.put("dateUpDate", "tmsVehicleDateUpDate");
        map.put("creationUser", "tmsVehicleCreationUser");
        map.put("upDateUser", "tmsVehicleUpDateUser");
    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsVehicle toEntity(Vehicle vehicule , boolean lazy){
        if (null == vehicule) {
            return null;
        }
        TmsVehicle tmsVehicle = new TmsVehicle();
        tmsVehicle.setTmsVehicleId(vehicule.getId());
        tmsVehicle.setTmsVehicleCode(vehicule.getCode() != null ? vehicule.getCode().toUpperCase() : null);

        if (!lazy) {

        }
        return tmsVehicle;

    }

    public static Vehicle toDto(TmsVehicle tmsVehicle, boolean lazy){
        if (null == tmsVehicle) {
            return null;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId(tmsVehicle.getTmsVehicleId());
        vehicle.setCode(tmsVehicle.getTmsVehicleCode());

        if (!lazy) {

        }
        return  vehicle;

    }

    public static List<Vehicle>toDtos(List<TmsVehicle> tmsVehicles, boolean lazy){
        if (null == tmsVehicles) {
            return null;
        }
        List<Vehicle>vehicles = new ArrayList<Vehicle>();

        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicles.add(toDto(tmsVehicle,lazy));
        }
        return  vehicles;
    }
    public static List<Vehicle>toDtos(Iterable<TmsVehicle>tmsVehicles , boolean lazy){
        if (null == tmsVehicles) {
            return null;
        }
        List<Vehicle>vehicules = new ArrayList<>();

        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicules.add(toDto(tmsVehicle,lazy));
        }
        return  vehicules;
    }

    public static Set<TmsVehicle>toEntities(Set<TmsVehicle>vehicules , boolean lazy){
        if (null == vehicules) {
            return null;
        }
        Set<TmsVehicle> tmsVehicles = new HashSet<>();
        for (TmsVehicle vehicule:vehicules) {
            tmsVehicles.add(toEntity(vehicule,lazy));
        }
        return tmsVehicles;i
    }
    public static Set<TmsVehicle>toDtos(Set<TmsVehicle> tmsVehicles, boolean lazy){
        if (null == tmsVehicles) {
            return null;
        }
        Set<Vehicle>vehicules = new HashSet<>();
        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicules.add(toDto(tmsVehicle,lazy));
        }
        return vehicles;
    }
}

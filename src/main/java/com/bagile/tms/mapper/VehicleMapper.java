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

        map.put("id", "tmsVehicleid");
        map.put("registrationNumber", "registrationNumber");
        map.put("code", "tmsVehiclecode");
        map.put("technicalVisit", "tmsVehicletechnicalVisit");
        map.put("creationDate", "tmsVehiclecreationDate");
        map.put("vehiculeCategorie", "tmsVehicleCategory");
        map.put("badgeType", "tmsBadgeType");

    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsVehicle toEntity(Vehicle vehicle , boolean lazy){
        if (null == vehicle) {
            return null;
        }
        TmsVehicle tmsVehicle = new TmsVehicle();
        tmsVehicle.setTmsVehicleid(vehicle.getId());
        tmsVehicle.setRegistrationNumber(vehicle.getRegistrationNumber());
        tmsVehicle.setTmsVehiclecode(vehicle.getCode() != null ? vehicle.getCode().toUpperCase() : null);
        tmsVehicle.setTmsVehicletechnicalVisit(vehicle.getTechnicalVisit());
        tmsVehicle.setTmsVehiclecreationDate(vehicle.getCreationDate());


        if (!lazy) {
            tmsVehicle.setTmsVehicleCategory(VehicleCategoryMapper.toEntity(vehicle.getVehiculeCategorie(),true));
            tmsVehicle.setTmsBadgeType(BadgeTypeMapper.toEntity(vehicle.getBadgeType(),true));

        }
        return tmsVehicle;

    }

    public static Vehicle toDto(TmsVehicle tmsVehicle, boolean lazy){
        if (null == tmsVehicle) {
            return null;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId((int) tmsVehicle.getTmsVehicleid());
        vehicle.setRegistrationNumber(tmsVehicle.getRegistrationNumber());
        vehicle.setCode(tmsVehicle.getTmsVehiclecode() != null ? tmsVehicle.getTmsVehiclecode().toUpperCase() : null);
        vehicle.setTechnicalVisit(tmsVehicle.getTmsVehicletechnicalVisit());
        vehicle.setCreationDate(tmsVehicle.getTmsVehiclecreationDate());

        if (!lazy) {
            vehicle.setBadgeType(BadgeTypeMapper.toDto(tmsVehicle.getTmsBadgeType(),lazy));
            vehicle.setVehiculeCategorie(VehicleCategoryMapper.toDto(tmsVehicle.getTmsVehicleCategory(),lazy));

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

    public static Set<TmsVehicle>toEntities(Set<Vehicle>vehicles , boolean lazy){
        if (null == vehicles) {
            return null;
        }
        Set<TmsVehicle> tmsVehicles = new HashSet<>();
        for (Vehicle vehicle:vehicles) {
            tmsVehicles.add(toEntity(vehicle,lazy));
        }
        return tmsVehicles;
    }

    public static Set<Vehicle>toDtos(Set<TmsVehicle> tmsVehicles, boolean lazy){
        if (null == tmsVehicles) {
            return null;
        }
        Set<Vehicle>vehicles = new HashSet<>();
        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicles.add(toDto(tmsVehicle,lazy));
        }
        return vehicles;
    }
}

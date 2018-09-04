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
        map.put("registrationNumber", "tmsVehicleRegistrationNumber");
        map.put("badgeType", "tmsVehicleBadgeType");
        map.put("code", "tmsVehicleCode");
        map.put("technicalVisit", "tmsVehicleTechnicalVisit");
        map.put("category", "tmsVehicleCategory");
        map.put("drivingLicence", "tmsVehicleDrivingLicence");
        map.put("creationDate", "tmsVehicleCreationDate");
        map.put("creationUser", "tmsVehicleCreationUser");
        map.put("UpDateDate", "tmsVehicleUpDateDate");
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
        tmsVehicle.setTmsVehicleId(vehicle.getId());
        tmsVehicle.setTmsVehicleRegistrationNumber(vehicle.getRegistrationNumber());
        tmsVehicle.setTmsVehicleCode(vehicle.getCode() != null ? vehicle.getCode().toUpperCase() : null);
        tmsVehicle.setTmsVehicleTechnicalVisit(vehicle.getTechnicalVisit());

        if (!lazy) {
            tmsVehicle.setTmsVehicleBadgeType(BadgeTypeMapper.toEntity(vehicle.getBadgeType(),lazy));
            tmsVehicle.setTmsVehicleCategory(VehicleCategoryMapper.toEntity(vehicle.getVehicleCategory(),lazy));
            tmsVehicle.setTmsVehicleDrivingLicence(TrafficMapper.toEntity(vehicle.getDrivingLicence(),lazy));
            tmsVehicle.setTmsVehicleCreationDate(vehicle.getCreationDate());
            tmsVehicle.setTmsVehicleCreationUser(UserMapper.toEntity(vehicle.getCreationUser(),lazy));
            tmsVehicle.setTmsVehicleUpDateDate(vehicle.getUpDateDate());
        }
        return tmsVehicle;

    }

    public static Vehicle toDto(TmsVehicle tmsVehicle, boolean lazy){
        if (null == tmsVehicle) {
            return null;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId(tmsVehicle.getTmsVehicleId());
        vehicle.setRegistrationNumber(tmsVehicle.getTmsVehicleRegistrationNumber());
        vehicle.setCode(tmsVehicle.getTmsVehicleCode() != null ? tmsVehicle.getTmsVehicleCode().toUpperCase() : null);
        vehicle.setTechnicalVisit(tmsVehicle.getTmsVehicleTechnicalVisit());

        if (!lazy) {
            vehicle.setBadgeType(BadgeTypeMapper.toDto(tmsVehicle.getTmsVehicleBadgeType(),lazy));
            vehicle.setVehicleCategory(VehicleCategoryMapper.toDto(tmsVehicle.getTmsVehicleCategory(),lazy));
            vehicle.setDrivingLicence(TrafficMapper.toDto(tmsVehicle.getTmsVehicleDrivingLicence(),lazy));
            vehicle.setCreationDate(tmsVehicle.getTmsVehicleCreationDate());
            vehicle.setCreationUser(UserMapper.toDto(tmsVehicle.getTmsVehicleCreationUser(),lazy));
            vehicle.setUpDateDate(tmsVehicle.getTmsVehicleUpDateDate());
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

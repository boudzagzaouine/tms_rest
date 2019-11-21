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
        map.put("registrationNumber", "tmsRegistrationNumber");
        map.put("code", "tmsVehicleCode");
        map.put("technicalVisit", "tmsVehicleTechnicalVisit");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
        map.put("vehicleCategory", "tmsVehicleCategory");
        map.put("badgeType", "tmsBadgeType");
        map.put("insurance", "TmsInsurance");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsVehicle toEntity(Vehicle vehicle, boolean lazy) {
        if (null == vehicle) {
            return null;
        }
        TmsVehicle tmsVehicle = new TmsVehicle();
        tmsVehicle.setTmsVehicleId(vehicle.getId());
        tmsVehicle.setTmsRegistrationNumber(vehicle.getRegistrationNumber());
        tmsVehicle.setTmsVehicleCode(vehicle.getCode() != null ? vehicle.getCode().toUpperCase() : null);
        tmsVehicle.setTmsVehicleTechnicalVisit(vehicle.getTechnicalVisit());
        tmsVehicle.setCreatedBy(vehicle.getCreatedBy());
        tmsVehicle.setUpdatedBy(vehicle.getUpdatedBy());
        tmsVehicle.setCreationDate(vehicle.getCreationDate());
        tmsVehicle.setUpdateDate(vehicle.getUpdateDate());


        if (!lazy) {
            tmsVehicle.setTmsVehicleCategory(VehicleCategoryMapper.toEntity(vehicle.getVehicleCategory(), true));
            tmsVehicle.setTmsBadgeType(BadgeTypeMapper.toEntity(vehicle.getBadgeType(), true));
            tmsVehicle.setTmsInsurance(InsuranceMapper.toEntity(vehicle.getInsurance(), true));

        }
        return tmsVehicle;

    }

    public static Vehicle toDto(TmsVehicle tmsVehicle, boolean lazy) {
        if (null == tmsVehicle) {
            return null;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId((int) tmsVehicle.getTmsVehicleId());
        vehicle.setRegistrationNumber(tmsVehicle.getTmsRegistrationNumber());
        vehicle.setCode(tmsVehicle.getTmsVehicleCode());
        vehicle.setTechnicalVisit(tmsVehicle.getTmsVehicleTechnicalVisit());
        vehicle.setCreatedBy(tmsVehicle.getCreatedBy());
        vehicle.setUpdatedBy(tmsVehicle.getUpdatedBy());
        vehicle.setCreationDate(tmsVehicle.getCreationDate());
        vehicle.setUpdateDate(tmsVehicle.getUpdateDate());

        if (!lazy) {
            vehicle.setBadgeType(BadgeTypeMapper.toDto(tmsVehicle.getTmsBadgeType(), true));
            vehicle.setVehicleCategory(VehicleCategoryMapper.toDto(tmsVehicle.getTmsVehicleCategory(), true));
            vehicle.setInsurance(InsuranceMapper.toDto(tmsVehicle.getTmsInsurance(), true));

        }
        return vehicle;

    }


    public static List<Vehicle> toDtos(Iterable<? extends TmsVehicle> tmsVehicles, boolean lazy) {
        if (null == tmsVehicles) {
            return null;
        }
        List<Vehicle> vehicules = new ArrayList<>();

        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicules.add(toDto(tmsVehicle, lazy));
        }
        return vehicules;
    }

    public static Set<TmsVehicle> toEntities(Set<Vehicle> vehicles, boolean lazy) {
        if (null == vehicles) {
            return null;
        }
        Set<TmsVehicle> tmsVehicles = new HashSet<>();
        for (Vehicle vehicle : vehicles) {
            tmsVehicles.add(toEntity(vehicle, lazy));
        }
        return tmsVehicles;
    }

    public static Set<Vehicle> toDtos(Set<TmsVehicle> tmsVehicles, boolean lazy) {
        if (null == tmsVehicles) {
            return null;
        }
        Set<Vehicle> vehicles = new HashSet<>();
        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicles.add(toDto(tmsVehicle, lazy));
        }
        return vehicles;
    }
}

package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.VehicleCategory;
import com.bagile.gmo.entities.GmoVehicleCategory;

public class VehicleCategoryMapper {
    public VehicleCategoryMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsVehicleCategoryId");
        map.put("code", "tmsVehicleCategoryCode");
        map.put("consumption", "tmsVehicleCategoryConsumption");
        map.put("length", "tmsVehicleCategoryLength");
        map.put("width", "tmsVehicleCategoryWidth");
        map.put("height", "tmsVehicleCategoriyheight");
        map.put("depth", "tmsVehicleCategoryDepth");
        map.put("tonnage", "tmsVehicleCategoryTonnage");
        map.put("emptyWeight", "tmsVehicleCategoryEmptyWeight");
        map.put("totalWeight", "tmsVehicleCategoryTotalWeight");



        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoVehicleCategory toEntity(VehicleCategory vehicle, boolean lazy) {
        if (null == vehicle) {
            return null;
        }
        GmoVehicleCategory tmsVehicleCategory = new GmoVehicleCategory();
        tmsVehicleCategory.setTmsVehicleCategoryId(vehicle.getId());
        tmsVehicleCategory.setTmsVehicleCategoryCode(vehicle.getCode() != null ? vehicle.getCode().toUpperCase() : null);
        tmsVehicleCategory.setTmsVehicleCategoryConsumption (vehicle.getConsumption ());
        tmsVehicleCategory.setTmsVehicleCategoryWidth (vehicle.getWidth ());
        tmsVehicleCategory.setTmsVehicleCategoryDepth (vehicle.getDepth ());
        tmsVehicleCategory.setTmsVehicleCategoryTonnage (vehicle.getTonnage ());
        tmsVehicleCategory.setTmsVehicleCategoryEmptyWeight (vehicle.getEmptyWeight ());
        tmsVehicleCategory.setTmsVehicleCategoryTotalWeight (vehicle.getTotalWeight ());


        tmsVehicleCategory.setCreatedBy(vehicle.getCreatedBy());
        tmsVehicleCategory.setUpdatedBy(vehicle.getUpdatedBy());
        tmsVehicleCategory.setCreationDate(vehicle.getCreationDate());
        tmsVehicleCategory.setUpdateDate(vehicle.getUpdateDate());

            return tmsVehicleCategory;

    }

    public static VehicleCategory toDto(GmoVehicleCategory tmsVehicleCategory, boolean lazy) {
        if (null == tmsVehicleCategory) {
            return null;
        }
        VehicleCategory vehicle = new VehicleCategory();
        vehicle.setId((int) tmsVehicleCategory.getTmsVehicleCategoryId());
        vehicle.setCode(tmsVehicleCategory.getTmsVehicleCategoryCode());
        vehicle.setConsumption (tmsVehicleCategory.getTmsVehicleCategoryConsumption ());
        vehicle.setWidth (tmsVehicleCategory.getTmsVehicleCategoryWidth ());
        vehicle.setDepth (tmsVehicleCategory.getTmsVehicleCategoryDepth ());
        vehicle.setTonnage (tmsVehicleCategory.getTmsVehicleCategoryTonnage ());
        vehicle.setEmptyWeight (tmsVehicleCategory.getTmsVehicleCategoryEmptyWeight ());
        vehicle.setTotalWeight (tmsVehicleCategory.getTmsVehicleCategoryTotalWeight ());


        vehicle.setCreatedBy(tmsVehicleCategory.getCreatedBy());
        vehicle.setUpdatedBy(tmsVehicleCategory.getUpdatedBy());
        vehicle.setCreationDate(tmsVehicleCategory.getCreationDate());
        vehicle.setUpdateDate(tmsVehicleCategory.getUpdateDate());


            return vehicle;

    }


    public static List<VehicleCategory> toDtos(Iterable<? extends GmoVehicleCategory> tmsVehicleCategorys, boolean lazy) {
        if (null == tmsVehicleCategorys) {
            return null;
        }
        List<VehicleCategory> vehicules = new ArrayList<>();

        for (GmoVehicleCategory tmsVehicleCategory : tmsVehicleCategorys) {
            vehicules.add(toDto(tmsVehicleCategory, lazy));
        }
        return vehicules;
    }

    public static Set<GmoVehicleCategory> toEntities(Iterable<? extends VehicleCategory> vehicles, boolean lazy) {
        if (null == vehicles) {
            return null;
        }
        Set<GmoVehicleCategory> tmsVehicleCategorys = new HashSet<>();
        for (VehicleCategory vehicle : vehicles) {
            tmsVehicleCategorys.add(toEntity(vehicle, lazy));
        }
        return tmsVehicleCategorys;
    }

    public static Set<VehicleCategory> toDtos(Set<GmoVehicleCategory> tmsVehicleCategorys, boolean lazy) {
        if (null == tmsVehicleCategorys) {
            return null;
        }
        Set<VehicleCategory> vehicles = new HashSet<>();
        for (GmoVehicleCategory tmsVehicleCategory : tmsVehicleCategorys) {
            vehicles.add(toDto(tmsVehicleCategory, lazy));
        }
        return vehicles;
    }
}

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

        map.put("id", "gmoVehicleCategoryId");
        map.put("code", "gmoVehicleCategoryCode");
        map.put("consumption", "gmoVehicleCategoryConsumption");
        map.put("length", "gmoVehicleCategoryLength");
        map.put("width", "gmoVehicleCategoryWidth");
        map.put("height", "gmoVehicleCategoriyheight");
        map.put("depth", "gmoVehicleCategoryDepth");
        map.put("tonnage", "gmoVehicleCategoryTonnage");
        map.put("emptyWeight", "gmoVehicleCategoryEmptyWeight");
        map.put("totalWeight", "gmoVehicleCategoryTotalWeight");



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
        GmoVehicleCategory gmoVehicleCategory = new GmoVehicleCategory();
        gmoVehicleCategory.setGmoVehicleCategoryId(vehicle.getId());
        gmoVehicleCategory.setGmoVehicleCategoryCode(vehicle.getCode() != null ? vehicle.getCode().toUpperCase() : null);
        gmoVehicleCategory.setGmoVehicleCategoryConsumption (vehicle.getConsumption ());
        gmoVehicleCategory.setGmoVehicleCategoryWidth (vehicle.getWidth ());
        gmoVehicleCategory.setGmoVehicleCategoryDepth (vehicle.getDepth ());
        gmoVehicleCategory.setGmoVehicleCategoryTonnage (vehicle.getTonnage ());
        gmoVehicleCategory.setGmoVehicleCategoryEmptyWeight (vehicle.getEmptyWeight ());
        gmoVehicleCategory.setGmoVehicleCategoryTotalWeight (vehicle.getTotalWeight ());


        gmoVehicleCategory.setCreatedBy(vehicle.getCreatedBy());
        gmoVehicleCategory.setUpdatedBy(vehicle.getUpdatedBy());
        gmoVehicleCategory.setCreationDate(vehicle.getCreationDate());
        gmoVehicleCategory.setUpdateDate(vehicle.getUpdateDate());

            return gmoVehicleCategory;

    }

    public static VehicleCategory toDto(GmoVehicleCategory gmoVehicleCategory, boolean lazy) {
        if (null == gmoVehicleCategory) {
            return null;
        }
        VehicleCategory vehicle = new VehicleCategory();
        vehicle.setId((int) gmoVehicleCategory.getGmoVehicleCategoryId());
        vehicle.setCode(gmoVehicleCategory.getGmoVehicleCategoryCode());
        vehicle.setConsumption (gmoVehicleCategory.getGmoVehicleCategoryConsumption ());
        vehicle.setWidth (gmoVehicleCategory.getGmoVehicleCategoryWidth ());
        vehicle.setDepth (gmoVehicleCategory.getGmoVehicleCategoryDepth ());
        vehicle.setTonnage (gmoVehicleCategory.getGmoVehicleCategoryTonnage ());
        vehicle.setEmptyWeight (gmoVehicleCategory.getGmoVehicleCategoryEmptyWeight ());
        vehicle.setTotalWeight (gmoVehicleCategory.getGmoVehicleCategoryTotalWeight ());


        vehicle.setCreatedBy(gmoVehicleCategory.getCreatedBy());
        vehicle.setUpdatedBy(gmoVehicleCategory.getUpdatedBy());
        vehicle.setCreationDate(gmoVehicleCategory.getCreationDate());
        vehicle.setUpdateDate(gmoVehicleCategory.getUpdateDate());


            return vehicle;

    }


    public static List<VehicleCategory> toDtos(Iterable<? extends GmoVehicleCategory> gmoVehicleCategorys, boolean lazy) {
        if (null == gmoVehicleCategorys) {
            return null;
        }
        List<VehicleCategory> vehicules = new ArrayList<>();

        for (GmoVehicleCategory gmoVehicleCategory : gmoVehicleCategorys) {
            vehicules.add(toDto(gmoVehicleCategory, lazy));
        }
        return vehicules;
    }

    public static Set<GmoVehicleCategory> toEntities(Iterable<? extends VehicleCategory> vehicles, boolean lazy) {
        if (null == vehicles) {
            return null;
        }
        Set<GmoVehicleCategory> gmoVehicleCategorys = new HashSet<>();
        for (VehicleCategory vehicle : vehicles) {
            gmoVehicleCategorys.add(toEntity(vehicle, lazy));
        }
        return gmoVehicleCategorys;
    }

    public static Set<VehicleCategory> toDtos(Set<GmoVehicleCategory> gmoVehicleCategorys, boolean lazy) {
        if (null == gmoVehicleCategorys) {
            return null;
        }
        Set<VehicleCategory> vehicles = new HashSet<>();
        for (GmoVehicleCategory gmoVehicleCategory : gmoVehicleCategorys) {
            vehicles.add(toDto(gmoVehicleCategory, lazy));
        }
        return vehicles;
    }
}

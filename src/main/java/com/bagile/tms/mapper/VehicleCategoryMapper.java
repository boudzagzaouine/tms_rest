package com.bagile.tms.mapper;

import com.bagile.tms.dto.VehicleCategory;
import com.bagile.tms.entities.TmsVehicleCategory;

import java.util.*;


public class VehicleCategoryMapper {
    private VehicleCategoryMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsVehicleCategoryid");
        map.put("code", "tmsVehicleCategorycode");
        map.put("consumption", "tmsVehicleCategoryconsumption");
        map.put("weight", "tmsVehicleCategoryweight");
        map.put("width", "tmsVehicleCategorywidth");
        map.put("depth", "tmsVehicleCategorydepth");
        map.put("tonnage", "tmsVehicleCategorytonnage");
        map.put("emptyWeight", "tmsVehicleCategoryemptyWeight");
        map.put("totalWeight", "tmsVehicleCategorytotalWeight");
    }
    public static Map<String, String> getMap() {
        return map;
    }
    public String getField(String key) {
        return map.get(key);
    }
    public static TmsVehicleCategory toEntity(VehicleCategory VehicleCategory, boolean lazy) {
        if (null == VehicleCategory) {
            return null;
        }
        TmsVehicleCategory tmsVehicleCategory = new TmsVehicleCategory();
        tmsVehicleCategory.setTmsVehicleCategoryId(VehicleCategory.getId());
        tmsVehicleCategory.setTmsVehicleCategoryCode(VehicleCategory.getCode());
        tmsVehicleCategory.setTmsVehicleCategoryConsumption(VehicleCategory.getConsumption());
        tmsVehicleCategory.setTmsVehicleCategoryEmptyWeight(VehicleCategory.getWeight());
        tmsVehicleCategory.setTmsVehicleCategoryWidth(VehicleCategory.getWidth());
        tmsVehicleCategory.setTmsVehicleCategoryDepth(VehicleCategory.getDepth());
        tmsVehicleCategory.setTmsVehicleCategoryTonnage(VehicleCategory.getTonnage());
        tmsVehicleCategory.setTmsVehicleCategoryEmptyWeight(VehicleCategory.getEmptyWeight());
        tmsVehicleCategory.setTmsVehicleCategoryTotalWeight(VehicleCategory.getTotalWeight());

        if (!lazy) {
        }
        return tmsVehicleCategory;
    }

    public static VehicleCategory toDto(TmsVehicleCategory tmsVehicleCategory, boolean lazy) {
        if (null == tmsVehicleCategory) {
            return null;
        }
        VehicleCategory vehicleCategory = new VehicleCategory();
        vehicleCategory.setId(tmsVehicleCategory.getTmsVehicleCategoryId());
        vehicleCategory.setCode(tmsVehicleCategory.getTmsVehicleCategoryCode());
        vehicleCategory.setConsumption(tmsVehicleCategory.getTmsVehicleCategoryConsumption());
        vehicleCategory.setDepth(tmsVehicleCategory.getTmsVehicleCategoryDepth());
        vehicleCategory.setWeight(tmsVehicleCategory.getTmsVehicleCategoryEmptyWeight());
        vehicleCategory.setWidth(tmsVehicleCategory.getTmsVehicleCategoryWidth());
        vehicleCategory.setTonnage(tmsVehicleCategory.getTmsVehicleCategoryTonnage());
        vehicleCategory.setTotalWeight(tmsVehicleCategory.getTmsVehicleCategoryTotalWeight());
        vehicleCategory.setEmptyWeight(tmsVehicleCategory.getTmsVehicleCategoryTotalWeight());

        if (!lazy) {
        }
        return vehicleCategory;
    }
    public static List<VehicleCategory> toDtos(List<TmsVehicleCategory> tmsCategories, boolean lazy) {
        if (null == tmsCategories) {
            return null;
        }
        List<VehicleCategory> categories= new ArrayList<>();
        for (TmsVehicleCategory tmsVehicleCategory : tmsCategories) {
            categories.add(toDto(tmsVehicleCategory, lazy));
        }
        return categories;
    }

    public static List<VehicleCategory> toDtos(Iterable<TmsVehicleCategory> tmsCategories, boolean lazy) {
        if (null == tmsCategories) {
            return null;
        }
        List<VehicleCategory> categories = new ArrayList<>();
        for (TmsVehicleCategory tmsVehicleCategory : tmsCategories) {
            categories.add(toDto(tmsVehicleCategory, lazy));
        }
        return categories;
    }

    public static Set<TmsVehicleCategory> toEntities(Set<VehicleCategory> categories, boolean lazy) {
        if (null == categories) {
            return null;
        }
        Set<TmsVehicleCategory> TmsCategories = new HashSet<>();
        for (VehicleCategory vehicleCategory : categories) {
            TmsCategories.add(toEntity(vehicleCategory, lazy));
        }
        return TmsCategories;
    }

    public static Set<VehicleCategory> toDtos(Set<TmsVehicleCategory> TmsCategories, boolean lazy) {
        if (null == TmsCategories) {
            return null;
        }
        Set<VehicleCategory> categories = new HashSet<>();
        for (TmsVehicleCategory tmsVehicleCategory : TmsCategories) {
            categories.add(toDto(tmsVehicleCategory, lazy));
        }
        return categories;
    }
}


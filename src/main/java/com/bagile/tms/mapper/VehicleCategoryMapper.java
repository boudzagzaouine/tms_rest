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
        map.put("id", "tmsVehicleCategoryId");
        map.put("code", "tmsVehicleCategoryCode");
        map.put("consumption", "tmsVehicleCategoryConsumption");
        map.put("weight", "tmsVehicleCategoryWeight");
        map.put("width", "tmsVehicleCategoryWidth");
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

    public String getField(String key) {
        return map.get(key);
    }

    public static TmsVehicleCategory toEntity(VehicleCategory vehicleCategory, boolean lazy) {
        if (null == vehicleCategory) {
            return null;
        }
        TmsVehicleCategory tmsVehicleCategory = new TmsVehicleCategory();
        tmsVehicleCategory.setTmsVehicleCategoryId(vehicleCategory.getId());
        tmsVehicleCategory.setTmsVehicleCategoryCode(vehicleCategory.getCode());
        tmsVehicleCategory.setTmsVehicleCategoryConsumption(vehicleCategory.getConsumption());
        tmsVehicleCategory.setTmsVehicleCategoryEmptyWeight(vehicleCategory.getWeight());
        tmsVehicleCategory.setTmsVehicleCategoryWidth(vehicleCategory.getWidth());
        tmsVehicleCategory.setTmsVehicleCategoryDepth(vehicleCategory.getDepth());
        tmsVehicleCategory.setTmsVehicleCategoryTonnage(vehicleCategory.getTonnage());
        tmsVehicleCategory.setTmsVehicleCategoryEmptyWeight(vehicleCategory.getEmptyWeight());
        tmsVehicleCategory.setTmsVehicleCategoryTotalWeight(vehicleCategory.getTotalWeight());
        tmsVehicleCategory.setCreatedBy(vehicleCategory.getCreatedBy());
        tmsVehicleCategory.setUpdatedBy(vehicleCategory.getUpdatedBy());
        tmsVehicleCategory.setCreationDate(vehicleCategory.getCreationDate());
        tmsVehicleCategory.setUpdateDate(vehicleCategory.getUpdateDate());

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
        vehicleCategory.setCreatedBy(tmsVehicleCategory.getCreatedBy());
        vehicleCategory.setUpdatedBy(tmsVehicleCategory.getUpdatedBy());
        vehicleCategory.setCreationDate(tmsVehicleCategory.getCreationDate());
        vehicleCategory.setUpdateDate(tmsVehicleCategory.getUpdateDate());

        if (!lazy) {
        }
        return vehicleCategory;
    }

    public static List<VehicleCategory> toDtos(Iterable<? extends TmsVehicleCategory> tmsCategories, boolean lazy) {
        if (null == tmsCategories) {
            return null;
        }
        List<VehicleCategory> categories = new ArrayList<>();
        for (TmsVehicleCategory tmsVehicleCategory : tmsCategories) {
            categories.add(toDto(tmsVehicleCategory, lazy));
        }
        return categories;
    }

    public static Set<TmsVehicleCategory> toEntities(Set<? extends VehicleCategory> categories, boolean lazy) {
        if (null == categories) {
            return null;
        }
        Set<TmsVehicleCategory> TmsCategories = new HashSet<>();
        for (VehicleCategory vehicleCategory : categories) {
            TmsCategories.add(toEntity(vehicleCategory, lazy));
        }
        return TmsCategories;
    }

    public static Set<VehicleCategory> toDtos(Set<? extends TmsVehicleCategory> TmsCategories, boolean lazy) {
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


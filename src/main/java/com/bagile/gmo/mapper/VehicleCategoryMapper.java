package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportCategoryVehicle;
import com.bagile.gmo.dto.VehicleCategory;
import com.bagile.gmo.entities.GmoVehicleCategory;

import java.util.*;

public class VehicleCategoryMapper {
    public VehicleCategoryMapper() {
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

      //  map.put("insuranceType", "tmsInsuranceType");

        //map.put("vehicles", "tmsVehicles");

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
        tmsVehicleCategory.setTmsVehicleCategoryWeight (vehicle.getWeight ());
        tmsVehicleCategory.setTmsVehicleCategoryWidth (vehicle.getWidth ());
        tmsVehicleCategory.setTmsVehicleCategoryDepth (vehicle.getDepth ());
        tmsVehicleCategory.setTmsVehicleCategoryTonnage (vehicle.getTonnage ());
        tmsVehicleCategory.setTmsVehicleCategoryEmptyWeight (vehicle.getEmptyWeight ());
        tmsVehicleCategory.setTmsVehicleCategoryTotalWeight (vehicle.getTotalWeight ());


        tmsVehicleCategory.setCreatedBy(vehicle.getCreatedBy());
        tmsVehicleCategory.setUpdatedBy(vehicle.getUpdatedBy());
        tmsVehicleCategory.setCreationDate(vehicle.getCreationDate());
        tmsVehicleCategory.setUpdateDate(vehicle.getUpdateDate());

        if(!lazy) {
            //tmsVehicleCategory.setTmsInsuranceType (InsuranceTypeMapper.toEntity(vehicle.getInsuranceType(),false));
           // tmsVehicleCategory.setTmsTransportCategoryVehicles (TransportCategoryVehicleMapper.toEntities(vehicle.getTransportCategorieVehicules(),true));
            // tmsVehicleCategory.setTmsVehicles (VehicleMapper.toEntities(vehicle.getVehicles(),false));

        }
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
        vehicle.setWeight (tmsVehicleCategory.getTmsVehicleCategoryWeight ());
        vehicle.setWidth (tmsVehicleCategory.getTmsVehicleCategoryWidth ());
        vehicle.setDepth (tmsVehicleCategory.getTmsVehicleCategoryDepth ());
        vehicle.setTonnage (tmsVehicleCategory.getTmsVehicleCategoryTonnage ());
        vehicle.setEmptyWeight (tmsVehicleCategory.getTmsVehicleCategoryEmptyWeight ());
        vehicle.setTotalWeight (tmsVehicleCategory.getTmsVehicleCategoryTotalWeight ());


        vehicle.setCreatedBy(tmsVehicleCategory.getCreatedBy());
        vehicle.setUpdatedBy(tmsVehicleCategory.getUpdatedBy());
        vehicle.setCreationDate(tmsVehicleCategory.getCreationDate());
        vehicle.setUpdateDate(tmsVehicleCategory.getUpdateDate());

        if(!lazy) {

         //   vehicle.setInsuranceType (InsuranceTypeMapper.toDto(tmsVehicleCategory.getTmsInsuranceType (),false));
         //   vehicle.setTransportCategorieVehicules (TransportCategoryVehicleMapper.toDtos(tmsVehicleCategory.getTmsTransportCategoryVehicles (),true));

            // vehicle.setVehicles (VehicleMapper.toDtos(tmsVehicleCategory.get (),false));

        }
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

package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.VehicleTray;
import com.bagile.gmo.entities.TmsVehicleTray;

import java.util.*;

public class VehicleTrayMapper {
    public VehicleTrayMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsVehicleTrayId");
        map.put("code", "tmsVehicleTrayCode");
        map.put("description", "tmsVehicleTrayTypeDescription");

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

    public static TmsVehicleTray toEntity(VehicleTray vehicleTray, boolean lazy) {
        if (null == vehicleTray) {
            return null;
        }
        TmsVehicleTray tmsVehicleTrayType = new TmsVehicleTray();
        tmsVehicleTrayType.setTmsVehicleTrayId(vehicleTray.getId());
        tmsVehicleTrayType.setTmsVehicleTrayCode(vehicleTray.getCode() != null ? vehicleTray.getCode().toUpperCase() : null);
        tmsVehicleTrayType.setTmsVehicleTrayDescription (vehicleTray.getDescription ());

        tmsVehicleTrayType.setCreatedBy(vehicleTray.getCreatedBy());
        tmsVehicleTrayType.setUpdatedBy(vehicleTray.getUpdatedBy());
        tmsVehicleTrayType.setCreationDate(vehicleTray.getCreationDate());
        tmsVehicleTrayType.setUpdateDate(vehicleTray.getUpdateDate());

          if(!lazy){
              tmsVehicleTrayType.setOwnOwner(OwnerMapper.toEntity(vehicleTray.getOwner(),true));
          }

        return tmsVehicleTrayType;

    }

    public static VehicleTray toDto(TmsVehicleTray tmsVehicleTrayType, boolean lazy) {
        if (null == tmsVehicleTrayType) {
            return null;
        }
        VehicleTray vehicleTray = new VehicleTray();
        vehicleTray.setId(tmsVehicleTrayType.getTmsVehicleTrayId());
        vehicleTray.setCode(tmsVehicleTrayType.getTmsVehicleTrayCode());
        vehicleTray.setDescription (tmsVehicleTrayType.getTmsVehicleTrayDescription ());

 if(!lazy){
      vehicleTray.setOwner(OwnerMapper.toDto(tmsVehicleTrayType.getOwnOwner(),true));
 }
        return vehicleTray;

    }


    public static List<VehicleTray> toDtos(Iterable<? extends TmsVehicleTray> tmsVehicleTrayTypes, boolean lazy) {
        if (null == tmsVehicleTrayTypes) {
            return null;
        }
        List<VehicleTray> vehicules = new ArrayList<>();

        for (TmsVehicleTray tmsVehicleTrayType : tmsVehicleTrayTypes) {
            vehicules.add(toDto(tmsVehicleTrayType, lazy));
        }
        return vehicules;
    }

    public static Set<TmsVehicleTray> toEntities(Set<VehicleTray> vehicleTrays, boolean lazy) {
        if (null == vehicleTrays) {
            return null;
        }
        Set<TmsVehicleTray> tmsVehicleTrayTypes = new HashSet<>();
        for (VehicleTray vehicleTray : vehicleTrays) {
            tmsVehicleTrayTypes.add(toEntity(vehicleTray, lazy));
        }
        return tmsVehicleTrayTypes;
    }

    public static Set<VehicleTray> toDtos(Set<TmsVehicleTray> tmsVehicleTrayTypes, boolean lazy) {
        if (null == tmsVehicleTrayTypes) {
            return null;
        }
        Set<VehicleTray> vehicleTrays = new HashSet<>();
        for (TmsVehicleTray tmsVehicleTrayType : tmsVehicleTrayTypes) {
            vehicleTrays.add(toDto(tmsVehicleTrayType, lazy));
        }
        return vehicleTrays;
    }
}

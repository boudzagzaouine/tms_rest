package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.VehicleCategoryTray;
import com.bagile.gmo.entities.TmsVehicleCategoryTray;

import java.util.*;

public class VehicleCategoryTrayMapper {
    public VehicleCategoryTrayMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsVehicleCategoryTrayId");
        map.put("code", "tmsVehicleCategoryTrayCode");
        map.put("description", "tmsVehicleCategoryTrayDescription");

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

    public static TmsVehicleCategoryTray toEntity(VehicleCategoryTray vehicleCategoryTray, boolean lazy) {
        if (null == vehicleCategoryTray) {
            return null;
        }
        TmsVehicleCategoryTray tmsVehicleCategoryTray = new TmsVehicleCategoryTray();
        tmsVehicleCategoryTray.setTmsVehicleCategoryTrayId(vehicleCategoryTray.getId());

        tmsVehicleCategoryTray.setCreatedBy(vehicleCategoryTray.getCreatedBy());
        tmsVehicleCategoryTray.setUpdatedBy(vehicleCategoryTray.getUpdatedBy());
        tmsVehicleCategoryTray.setCreationDate(vehicleCategoryTray.getCreationDate());
        tmsVehicleCategoryTray.setUpdateDate(vehicleCategoryTray.getUpdateDate());

          if(!lazy){
              tmsVehicleCategoryTray.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(vehicleCategoryTray.getVehicleCategory(),true));
              tmsVehicleCategoryTray.setTmsVehicleTray(VehicleTrayMapper.toEntity(vehicleCategoryTray.getVehicleTray(),true));

              //tmsVehicleCategoryTray.setOwnOwner(OwnerMapper.toEntity(vehicleCategoryTray.getOwner(),true));
          }

        return tmsVehicleCategoryTray;

    }

    public static VehicleCategoryTray toDto(TmsVehicleCategoryTray tmsVehicleCategoryTray, boolean lazy) {
        if (null == tmsVehicleCategoryTray) {
            return null;
        }
        VehicleCategoryTray vehicleCategoryTray = new VehicleCategoryTray();
        vehicleCategoryTray.setId(tmsVehicleCategoryTray.getTmsVehicleCategoryTrayId());

 if(!lazy){
     vehicleCategoryTray.setVehicleCategory(VehicleCategoryMapper.toDto(tmsVehicleCategoryTray.getGmoVehicleCategory(),true));
     vehicleCategoryTray.setVehicleTray(VehicleTrayMapper.toDto(tmsVehicleCategoryTray.getTmsVehicleTray(),true));

     //vehicleCategoryTray.setOwner(OwnerMapper.toDto(tmsVehicleCategoryTray.getOwnOwner(),true));
 }
        return vehicleCategoryTray;

    }


    public static List<VehicleCategoryTray> toDtos(Iterable<? extends TmsVehicleCategoryTray> tmsVehicleCategoryTrays, boolean lazy) {
        if (null == tmsVehicleCategoryTrays) {
            return null;
        }
        List<VehicleCategoryTray> vehicules = new ArrayList<>();

        for (TmsVehicleCategoryTray tmsVehicleCategoryTray : tmsVehicleCategoryTrays) {
            vehicules.add(toDto(tmsVehicleCategoryTray, lazy));
        }
        return vehicules;
    }

    public static Set<TmsVehicleCategoryTray> toEntities(List<VehicleCategoryTray> vehicleCategoryTrays, boolean lazy) {
        if (null == vehicleCategoryTrays) {
            return null;
        }
        Set<TmsVehicleCategoryTray> tmsVehicleCategoryTrays = new HashSet<>();
        for (VehicleCategoryTray vehicleCategoryTray : vehicleCategoryTrays) {
            tmsVehicleCategoryTrays.add(toEntity(vehicleCategoryTray, lazy));
        }
        return tmsVehicleCategoryTrays;
    }

    public static List<VehicleCategoryTray> toDtos(Set<TmsVehicleCategoryTray> tmsVehicleCategoryTrays, boolean lazy) {
        if (null == tmsVehicleCategoryTrays) {
            return null;
        }
        List<VehicleCategoryTray> vehicleCategoryTrays = new ArrayList<>();
        for (TmsVehicleCategoryTray tmsVehicleCategoryTray : tmsVehicleCategoryTrays) {
            vehicleCategoryTrays.add(toDto(tmsVehicleCategoryTray, lazy));
        }
        return vehicleCategoryTrays;
    }
}

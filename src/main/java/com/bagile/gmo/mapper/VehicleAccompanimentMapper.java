package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.VehicleAccompaniment;
import com.bagile.gmo.entities.TmsVehicleAccompaniment;

import java.util.*;

public class VehicleAccompanimentMapper {
    public VehicleAccompanimentMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsVehicleAccompanimentId");
        map.put("code", "tmsVehicleAccompanimentCode");
        map.put("description", "tmsVehicleAccompanimentDescription");

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

    public static TmsVehicleAccompaniment toEntity(VehicleAccompaniment vehicleAccompaniment, boolean lazy) {
        if (null == vehicleAccompaniment) {
            return null;
        }
        TmsVehicleAccompaniment tmsVehicleAccompaniment = new TmsVehicleAccompaniment();
        tmsVehicleAccompaniment.setGmoVehicleAccompanimentId(vehicleAccompaniment.getId());
        tmsVehicleAccompaniment.setGmoVehicleAccompanimentCode(vehicleAccompaniment.getCode() != null ? vehicleAccompaniment.getCode().toUpperCase() : null);
        tmsVehicleAccompaniment.setGmoVehicleAccompanimentDescription (vehicleAccompaniment.getDescription ());

        tmsVehicleAccompaniment.setCreatedBy(vehicleAccompaniment.getCreatedBy());
        tmsVehicleAccompaniment.setUpdatedBy(vehicleAccompaniment.getUpdatedBy());
        tmsVehicleAccompaniment.setCreationDate(vehicleAccompaniment.getCreationDate());
        tmsVehicleAccompaniment.setUpdateDate(vehicleAccompaniment.getUpdateDate());

          if(!lazy){
              tmsVehicleAccompaniment.setOwnOwner(OwnerMapper.toEntity(vehicleAccompaniment.getOwner(),true));
          }

        return tmsVehicleAccompaniment;

    }

    public static VehicleAccompaniment toDto(TmsVehicleAccompaniment tmsVehicleAccompaniment, boolean lazy) {
        if (null == tmsVehicleAccompaniment) {
            return null;
        }
        VehicleAccompaniment vehicleAccompaniment = new VehicleAccompaniment();
        vehicleAccompaniment.setId(tmsVehicleAccompaniment.getGmoVehicleAccompanimentId());
        vehicleAccompaniment.setCode(tmsVehicleAccompaniment.getGmoVehicleAccompanimentCode());
        vehicleAccompaniment.setDescription (tmsVehicleAccompaniment.getGmoVehicleAccompanimentDescription ());

 if(!lazy){
      vehicleAccompaniment.setOwner(OwnerMapper.toDto(tmsVehicleAccompaniment.getOwnOwner(),true));
 }
        return vehicleAccompaniment;

    }


    public static List<VehicleAccompaniment> toDtos(Iterable<? extends TmsVehicleAccompaniment> tmsVehicleAccompaniments, boolean lazy) {
        if (null == tmsVehicleAccompaniments) {
            return null;
        }
        List<VehicleAccompaniment> vehicules = new ArrayList<>();

        for (TmsVehicleAccompaniment tmsVehicleAccompaniment : tmsVehicleAccompaniments) {
            vehicules.add(toDto(tmsVehicleAccompaniment, lazy));
        }
        return vehicules;
    }

    public static Set<TmsVehicleAccompaniment> toEntities(List<VehicleAccompaniment> vehicleAccompaniments, boolean lazy) {
        if (null == vehicleAccompaniments) {
            return null;
        }
        Set<TmsVehicleAccompaniment> tmsVehicleAccompaniments = new HashSet<>();
        for (VehicleAccompaniment vehicleAccompaniment : vehicleAccompaniments) {
            tmsVehicleAccompaniments.add(toEntity(vehicleAccompaniment, lazy));
        }
        return tmsVehicleAccompaniments;
    }

    public static List<VehicleAccompaniment> toDtos(Set<TmsVehicleAccompaniment> tmsVehicleAccompaniments, boolean lazy) {
        if (null == tmsVehicleAccompaniments) {
            return null;
        }
        List<VehicleAccompaniment> vehicleAccompaniments = new ArrayList<>();
        for (TmsVehicleAccompaniment tmsVehicleAccompaniment : tmsVehicleAccompaniments) {
            vehicleAccompaniments.add(toDto(tmsVehicleAccompaniment, lazy));
        }
        return vehicleAccompaniments;
    }
}

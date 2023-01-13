package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.BrandVehicleType;
import com.bagile.gmo.entities.GmoBrandVehicleType;

import java.util.*;

public class BrandVehicleTypeMapper {
    public BrandVehicleTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoBrandVehicleTypeId");
        map.put("code", "gmoBrandVehicleTypeCode");
        map.put("description", "gmoBrandVehicleTypeDescription");

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

    public static GmoBrandVehicleType toEntity(BrandVehicleType brandVehicleType, boolean lazy) {
        if (null == brandVehicleType) {
            return null;
        }
        GmoBrandVehicleType gmoBrandVehicleType = new GmoBrandVehicleType();
        gmoBrandVehicleType.setGmoBrandVehicleTypeId(brandVehicleType.getId());
        gmoBrandVehicleType.setGmoBrandVehicleTypeCode(brandVehicleType.getCode() != null ? brandVehicleType.getCode().toUpperCase() : null);
        gmoBrandVehicleType.setGmoBrandVehicleTypeDescription (brandVehicleType.getDescription ());



          if(!lazy){
              gmoBrandVehicleType.setOwnOwner(OwnerMapper.toEntity(brandVehicleType.getOwner(),true));
          }

        return gmoBrandVehicleType;

    }

    public static BrandVehicleType toDto(GmoBrandVehicleType gmoBrandVehicleType, boolean lazy) {
        if (null == gmoBrandVehicleType) {
            return null;
        }
        BrandVehicleType brandVehicleType = new BrandVehicleType();
        brandVehicleType.setId(gmoBrandVehicleType.getGmoBrandVehicleTypeId());
        brandVehicleType.setCode(gmoBrandVehicleType.getGmoBrandVehicleTypeCode());
        brandVehicleType.setDescription (gmoBrandVehicleType.getGmoBrandVehicleTypeDescription ());

 if(!lazy){
      brandVehicleType.setOwner(OwnerMapper.toDto(gmoBrandVehicleType.getOwnOwner(),true));
 }
        return brandVehicleType;

    }


    public static List<BrandVehicleType> toDtos(Iterable<? extends GmoBrandVehicleType> gmoBrandVehicleTypes, boolean lazy) {
        if (null == gmoBrandVehicleTypes) {
            return null;
        }
        List<BrandVehicleType> vehicules = new ArrayList<>();

        for (GmoBrandVehicleType gmoBrandVehicleType : gmoBrandVehicleTypes) {
            vehicules.add(toDto(gmoBrandVehicleType, lazy));
        }
        return vehicules;
    }

    public static Set<GmoBrandVehicleType> toEntities(Set<BrandVehicleType> brandVehicleTypes, boolean lazy) {
        if (null == brandVehicleTypes) {
            return null;
        }
        Set<GmoBrandVehicleType> gmoBrandVehicleTypes = new HashSet<>();
        for (BrandVehicleType brandVehicleType : brandVehicleTypes) {
            gmoBrandVehicleTypes.add(toEntity(brandVehicleType, lazy));
        }
        return gmoBrandVehicleTypes;
    }

    public static Set<BrandVehicleType> toDtos(Set<GmoBrandVehicleType> gmoBrandVehicleTypes, boolean lazy) {
        if (null == gmoBrandVehicleTypes) {
            return null;
        }
        Set<BrandVehicleType> brandVehicleTypes = new HashSet<>();
        for (GmoBrandVehicleType gmoBrandVehicleType : gmoBrandVehicleTypes) {
            brandVehicleTypes.add(toDto(gmoBrandVehicleType, lazy));
        }
        return brandVehicleTypes;
    }
}

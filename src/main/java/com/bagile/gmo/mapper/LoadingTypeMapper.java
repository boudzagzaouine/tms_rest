package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.LoadingType;
import com.bagile.gmo.entities.TmsLoadingType;

import java.util.*;

public class LoadingTypeMapper {
    public LoadingTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsLoadingTypeId");
        map.put("code", "tmsLoadingTypeCode");
        map.put("description", "tmsLoadingTypeTypeDescription");

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

    public static TmsLoadingType toEntity(LoadingType loadingType, boolean lazy) {
        if (null == loadingType) {
            return null;
        }
        TmsLoadingType tmsLoadingTypeType = new TmsLoadingType();
        tmsLoadingTypeType.setTmsLoadingTypeId(loadingType.getId());
        tmsLoadingTypeType.setTmsLoadingTypeCode(loadingType.getCode() != null ? loadingType.getCode().toUpperCase() : null);
        tmsLoadingTypeType.setTmsLoadingTypeDescription (loadingType.getDescription ());

        tmsLoadingTypeType.setCreatedBy(loadingType.getCreatedBy());
        tmsLoadingTypeType.setUpdatedBy(loadingType.getUpdatedBy());
        tmsLoadingTypeType.setCreationDate(loadingType.getCreationDate());
        tmsLoadingTypeType.setUpdateDate(loadingType.getUpdateDate());

          if(!lazy){
              tmsLoadingTypeType.setOwnOwner(OwnerMapper.toEntity(loadingType.getOwner(),true));
          }

        return tmsLoadingTypeType;

    }

    public static LoadingType toDto(TmsLoadingType tmsLoadingTypeType, boolean lazy) {
        if (null == tmsLoadingTypeType) {
            return null;
        }
        LoadingType loadingType = new LoadingType();
        loadingType.setId(tmsLoadingTypeType.getTmsLoadingTypeId());
        loadingType.setCode(tmsLoadingTypeType.getTmsLoadingTypeCode());
        loadingType.setDescription (tmsLoadingTypeType.getTmsLoadingTypeDescription ());

 if(!lazy){
      loadingType.setOwner(OwnerMapper.toDto(tmsLoadingTypeType.getOwnOwner(),true));
 }
        return loadingType;

    }


    public static List<LoadingType> toDtos(Iterable<? extends TmsLoadingType> tmsLoadingTypeTypes, boolean lazy) {
        if (null == tmsLoadingTypeTypes) {
            return null;
        }
        List<LoadingType> vehicules = new ArrayList<>();

        for (TmsLoadingType tmsLoadingTypeType : tmsLoadingTypeTypes) {
            vehicules.add(toDto(tmsLoadingTypeType, lazy));
        }
        return vehicules;
    }

    public static Set<TmsLoadingType> toEntities(Set<LoadingType> loadingTypes, boolean lazy) {
        if (null == loadingTypes) {
            return null;
        }
        Set<TmsLoadingType> tmsLoadingTypeTypes = new HashSet<>();
        for (LoadingType loadingType : loadingTypes) {
            tmsLoadingTypeTypes.add(toEntity(loadingType, lazy));
        }
        return tmsLoadingTypeTypes;
    }

    public static Set<LoadingType> toDtos(Set<TmsLoadingType> tmsLoadingTypeTypes, boolean lazy) {
        if (null == tmsLoadingTypeTypes) {
            return null;
        }
        Set<LoadingType> loadingTypes = new HashSet<>();
        for (TmsLoadingType tmsLoadingTypeType : tmsLoadingTypeTypes) {
            loadingTypes.add(toDto(tmsLoadingTypeType, lazy));
        }
        return loadingTypes;
    }
}

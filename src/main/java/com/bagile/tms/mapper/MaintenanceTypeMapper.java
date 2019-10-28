package com.bagile.tms.mapper;

import com.bagile.tms.dto.MaintenanceType;
import com.bagile.tms.entities.TmsMaintenanceType;

import java.util.*;

public class MaintenanceTypeMapper {

    private MaintenanceTypeMapper() {

    }
    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }
    static {
        map = new HashMap<>();
        map.put("id","tmsMaintenanceTypeId");
        map.put("code","tmsMaintenanceTypeCode");
        map.put("description","tmsMaintenanceTypeDescription");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static MaintenanceType toDto(TmsMaintenanceType tmsType,boolean lazy) {
        if (null == tmsType) {
            return null;
        }
        MaintenanceType type = new MaintenanceType();
        type.setId(tmsType.getTmsMaintenanceTypeId());
        type.setCode(tmsType.getTmsMaintenanceTypeCode());
        type.setDescription(tmsType.getTmsMaintenanceTypeDescription());

        type.setCreatedBy(tmsType.getCreatedBy());
        type.setUpdatedBy(tmsType.getUpdatedBy());
        type.setCreationDate(tmsType.getCreationDate());
        type.setUpdateDate(tmsType.getUpdateDate());

        return type;
    }

    public static TmsMaintenanceType toEntity(MaintenanceType type,boolean lazy) {
        if(null == type) {
            return null;
        }
        TmsMaintenanceType tmsType = new TmsMaintenanceType();
        tmsType.setTmsMaintenanceTypeId(type.getId());
        tmsType.setTmsMaintenanceTypeCode(type.getCode());
        tmsType.setTmsMaintenanceTypeDescription(type.getDescription());

        tmsType.setCreatedBy(type.getCreatedBy());
        tmsType.setUpdatedBy(type.getUpdatedBy());
        tmsType.setCreationDate(type.getCreationDate());
        tmsType.setUpdateDate(type.getUpdateDate());

        return tmsType;
    }

    public static Set<MaintenanceType> toDtos(Set<? extends TmsMaintenanceType> tmsTypes) {
        if(null == tmsTypes) {
            return null;
        }
        Set<MaintenanceType> list = new HashSet<MaintenanceType>();
        for(TmsMaintenanceType tmsType: tmsTypes) {
            list.add(toDto(tmsType,true));
        }
        return list;
    }


    public static List<MaintenanceType> toDtos(Iterable<? extends TmsMaintenanceType> tmsTypes) {
        if(null == tmsTypes) {
            return null;
        }
        List<MaintenanceType> list = new ArrayList<MaintenanceType>();
        for(TmsMaintenanceType tmsType: tmsTypes) {
            list.add(toDto(tmsType,true));
        }
        return list;
    }

    public static Set<TmsMaintenanceType> toEntities(Set<? extends MaintenanceType> types) {
        if(null == types) {
            return null;
        }
        Set<TmsMaintenanceType> list = new HashSet<TmsMaintenanceType>();
        for(MaintenanceType state: types) {
            list.add(toEntity(state,true));
        }
        return list;
    }
}

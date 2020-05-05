package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.MaintenanceType;
import com.bagile.gmo.entities.GmoMaintenanceType;

public class MaintenanceTypeMapper {

    private MaintenanceTypeMapper() {

    }
    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }
    static {
        map = new HashMap<>();
        map.put("id","gmoMaintenanceTypeId");
        map.put("code","gmoMaintenanceTypeCode");
        map.put("description","gmoMaintenanceTypeDescription");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static MaintenanceType toDto(GmoMaintenanceType gmoType,boolean lazy) {
        if (null == gmoType) {
            return null;
        }
        MaintenanceType type = new MaintenanceType();
        type.setId(gmoType.getGmoMaintenanceTypeId());
        type.setCode(gmoType.getGmoMaintenanceTypeCode());
        type.setDescription(gmoType.getGmoMaintenanceTypeDescription());

        type.setCreatedBy(gmoType.getCreatedBy());
        type.setUpdatedBy(gmoType.getUpdatedBy());
        type.setCreationDate(gmoType.getCreationDate());
        type.setUpdateDate(gmoType.getUpdateDate());

        return type;
    }

    public static GmoMaintenanceType toEntity(MaintenanceType type,boolean lazy) {
        if(null == type) {
            return null;
        }
        GmoMaintenanceType gmoType = new GmoMaintenanceType();
        gmoType.setGmoMaintenanceTypeId(type.getId());
        gmoType.setGmoMaintenanceTypeCode(type.getCode());
        gmoType.setGmoMaintenanceTypeDescription(type.getDescription());

        gmoType.setCreatedBy(type.getCreatedBy());
        gmoType.setUpdatedBy(type.getUpdatedBy());
        gmoType.setCreationDate(type.getCreationDate());
        gmoType.setUpdateDate(type.getUpdateDate());

        return gmoType;
    }

    public static Set<MaintenanceType> toDtos(Set<? extends GmoMaintenanceType> gmoTypes) {
        if(null == gmoTypes) {
            return null;
        }
        Set<MaintenanceType> list = new HashSet<MaintenanceType>();
        for(GmoMaintenanceType gmoType: gmoTypes) {
            list.add(toDto(gmoType,true));
        }
        return list;
    }


    public static List<MaintenanceType> toDtos(Iterable<? extends GmoMaintenanceType> gmoTypes) {
        if(null == gmoTypes) {
            return null;
        }
        List<MaintenanceType> list = new ArrayList<MaintenanceType>();
        for(GmoMaintenanceType gmoType: gmoTypes) {
            list.add(toDto(gmoType,true));
        }
        return list;
    }

    public static Set<GmoMaintenanceType> toEntities(Set<? extends MaintenanceType> types) {
        if(null == types) {
            return null;
        }
        Set<GmoMaintenanceType> list = new HashSet<GmoMaintenanceType>();
        for(MaintenanceType state: types) {
            list.add(toEntity(state,true));
        }
        return list;
    }
}

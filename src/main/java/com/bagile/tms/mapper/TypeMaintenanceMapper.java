package com.bagile.tms.mapper;

import com.bagile.tms.dto.TypeMaintenance;
import com.bagile.tms.entities.TmsTypeMaintenance;

import java.util.*;

public class TypeMaintenanceMapper {

    private TypeMaintenanceMapper() {

    }
    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }
    static {
        map = new HashMap<>();
        map.put("id","tmsTypeMaintenanceId");
        map.put("type","tmsTypeMaintenancetype");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TypeMaintenance toDto(TmsTypeMaintenance tmsType) {
        if (null == tmsType) {
            return null;
        }
        TypeMaintenance type = new TypeMaintenance();
        type.setId(tmsType.getTmsTypeMaintenanceId());
        type.setType(tmsType.getTmsTypeMaintenanceType());
        return type;
    }

    public static TmsTypeMaintenance toEntity(TypeMaintenance type) {
        if(null == type) {
            return null;
        }
        TmsTypeMaintenance tmsType = new TmsTypeMaintenance();
        tmsType.setTmsTypeMaintenanceId(type.getId());
        tmsType.setTmsTypeMaintenanceType(type.getType());
        return tmsType;
    }

    public static Set<TypeMaintenance> toDtos(Set<TmsTypeMaintenance> tmsTypes) {
        if(null == tmsTypes) {
            return null;
        }
        Set<TypeMaintenance> list = new HashSet<TypeMaintenance>();
        for(TmsTypeMaintenance tmsType: tmsTypes) {
            list.add(toDto(tmsType));
        }
        return list;
    }

    public static List<TypeMaintenance> toDtos(List<TmsTypeMaintenance> tmsTypes) {
        if(null == tmsTypes) {
            return null;
        }
        List<TypeMaintenance> list = new ArrayList<TypeMaintenance>();
        for(TmsTypeMaintenance tmsType: tmsTypes) {
            list.add(toDto(tmsType));
        }
        return list;
    }

    public static List<TypeMaintenance> toDtos(Iterable<TmsTypeMaintenance> tmsTypes) {
        if(null == tmsTypes) {
            return null;
        }
        List<TypeMaintenance> list = new ArrayList<TypeMaintenance>();
        for(TmsTypeMaintenance tmsType: tmsTypes) {
            list.add(toDto(tmsType));
        }
        return list;
    }

    public static Set<TmsTypeMaintenance> toEntities(Set<TypeMaintenance> types) {
        if(null == types) {
            return null;
        }
        Set<TmsTypeMaintenance> list = new HashSet<TmsTypeMaintenance>();
        for(TypeMaintenance state: types) {
            list.add(toEntity(state));
        }
        return list;
    }
}

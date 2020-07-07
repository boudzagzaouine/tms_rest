package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.MaintenanceLineRef;
import com.bagile.gmo.entities.GmoMaintenanceLineRef;

public class MaintenanceLineRefMapper {
    public MaintenanceLineRefMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoMaintenanceLineRefId");
        map.put("code", "gmoMaintenanceLineRefCode");
        map.put("description", "gmoMaintenanceLineRefDescription");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoMaintenanceLineRef toEntity(MaintenanceLineRef maintenanceLineRef, boolean lazy) {
        if (null == maintenanceLineRef) {
            return null;
        }
        GmoMaintenanceLineRef gmoMaintenanceLineRef = new GmoMaintenanceLineRef();
        gmoMaintenanceLineRef.setGmoMaintenanceLineRefId(maintenanceLineRef.getId());
        gmoMaintenanceLineRef.setGmoMaintenanceLineRefCode(maintenanceLineRef.getCode() != null ? maintenanceLineRef.getCode().toUpperCase() : null);
        gmoMaintenanceLineRef.setGmoMaintenanceLineRefDescription(maintenanceLineRef.getDescription());

        if (!lazy) {
           // gmoMaintenanceLineRef.setGmoMaintenanceLineRefActions(ActionTypeMapper.toEntities (maintenanceLineRef.getActions(), false));

        }
        return gmoMaintenanceLineRef;
    }

    public static MaintenanceLineRef toDto(GmoMaintenanceLineRef gmoMaintenanceLineRef, boolean lazy) {
        if (null == gmoMaintenanceLineRef) {
            return null;
        }
        MaintenanceLineRef maintenanceLineRef = new MaintenanceLineRef();
        maintenanceLineRef.setId(gmoMaintenanceLineRef.getGmoMaintenanceLineRefId());
        maintenanceLineRef.setCode(gmoMaintenanceLineRef.getGmoMaintenanceLineRefCode());
        maintenanceLineRef.setDescription(gmoMaintenanceLineRef.getGmoMaintenanceLineRefDescription());
        if (!lazy) {
          //  maintenanceLineRef.setActions(ActionTypeMapper.toDtos(gmoMaintenanceLineRef.getGmoMaintenanceLineRefActions(), true));
        }

        return maintenanceLineRef;
    }

    public static List<MaintenanceLineRef> toDtos(Iterable<? extends GmoMaintenanceLineRef> mntMaintenanceLineRefs, boolean lazy) {
        if (null == mntMaintenanceLineRefs) {
            return null;
        }
        List<MaintenanceLineRef> maintenanceLineRefs = new ArrayList<>();
        for (GmoMaintenanceLineRef gmoMaintenanceLineRef : mntMaintenanceLineRefs) {
            maintenanceLineRefs.add(toDto(gmoMaintenanceLineRef, lazy));
        }
        return maintenanceLineRefs;
    }

    public static Set<GmoMaintenanceLineRef> toEntities(Set<? extends MaintenanceLineRef> maintenanceLineRefs, boolean lazy) {
        if (null == maintenanceLineRefs) {
            return null;
        }
        Set<GmoMaintenanceLineRef> gmoMaintenanceLineRefs = new HashSet<>();

        for (MaintenanceLineRef maintenanceLineRef : maintenanceLineRefs) {
            gmoMaintenanceLineRefs.add(toEntity(maintenanceLineRef, lazy));
        }
        return gmoMaintenanceLineRefs;
    }

    public static Set<MaintenanceLineRef> toDtos(Set<? extends GmoMaintenanceLineRef> gmoMaintenanceLineRefs, boolean lazy) {
        if (null == gmoMaintenanceLineRefs) {
            return null;
        }
        Set<MaintenanceLineRef> maintenanceLineRefs = new HashSet<>();
        for (GmoMaintenanceLineRef gmoMaintenanceLineRef : gmoMaintenanceLineRefs) {
            maintenanceLineRefs.add(toDto(gmoMaintenanceLineRef, lazy));
        }
        return maintenanceLineRefs;
    }

}

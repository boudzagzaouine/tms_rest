/**
 *
 */
package com.sinno.ems.mapper;

import com.sinno.ems.dto.Aisle;
import com.sinno.ems.entities.LocAisle;

import java.util.*;

/**
 * @author aelguezzar
 */
public class AisleMapper {
    private AisleMapper() {
    }

    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }

    static {
        map = new HashMap<>();

        map.put("id", "locAisleId");
        map.put("zone", "locZone");
        map.put("warehouse", "wrhWarehouse");
        map.put("code", "locAisleCode");
        map.put("active", "locAisleIsActive");
        map.put("creationDate", "locAisleCreationDate");
        map.put("updateDate", "locAisleUpdateDate");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Aisle toDto(LocAisle locAisle, boolean lazy) {
        if (null == locAisle) {
            return null;
        }
        Aisle aisle = new Aisle();
        aisle.setCode(locAisle.getLocAisleCode());
        aisle.setCreationDate(locAisle.getLocAisleCreationDate());
        aisle.setId(locAisle.getLocAisleId());
        aisle.setActive(locAisle.isLocAisleIsActive());
        aisle.setUpdateDate(locAisle.getLocAisleUpdateDate());
        aisle.setOrder(locAisle.getLocAisleOrder());
        aisle.setPriority(locAisle.getLocAislePriority());
        aisle.setLength(locAisle.getLocAislelength());
        if (!lazy) {
            aisle.setWarehouse(WarehouseMapper.toDto(locAisle.getWrhWarehouse(), true));
            aisle.setZone(ZoneMapper.toDto(locAisle.getLocZone(), true));
        }
        return aisle;
    }

    public static LocAisle toEntity(Aisle aisle, boolean lazy) {
        if (null == aisle) {
            return null;
        }
        LocAisle locAisle = new LocAisle();
        locAisle.setLocAisleCode(aisle.getCode());
        locAisle.setLocAisleCreationDate(aisle.getCreationDate());
        locAisle.setLocAisleId(aisle.getId());
        locAisle.setLocAisleIsActive(aisle.getActive());
        locAisle.setLocAisleUpdateDate(aisle.getUpdateDate());
        locAisle.setLocAisleOrder(aisle.getOrder());
        locAisle.setLocAislePriority(aisle.getPriority());
        locAisle.setLocAislelength(aisle.getLength());
        if (!lazy) {
            locAisle.setLocZone(ZoneMapper.toEntity(aisle.getZone(), true));
            locAisle.setWrhWarehouse(WarehouseMapper.toEntity(aisle.getWarehouse(), true));
        }
        return locAisle;
    }

    public static List<Aisle> toDtos(List<LocAisle> locAisles, boolean lazy) {
        if (null == locAisles) {
            return null;
        }
        List<Aisle> aisles = new ArrayList<>();
        for (LocAisle locAisle : locAisles) {
            aisles.add(toDto(locAisle, lazy));
        }
        return aisles;
    }

    public static List<Aisle> toDtos(Iterable<LocAisle> locAisles, boolean lazy) {
        if (null == locAisles) {
            return null;
        }
        List<Aisle> aisles = new ArrayList<>();
        for (LocAisle locAisle : locAisles) {
            aisles.add(toDto(locAisle, lazy));
        }
        return aisles;
    }

    public static Set<LocAisle> toEntities(Set<Aisle> aisles, boolean lazy) {
        if (null == aisles) {
            return null;
        }
        Set<LocAisle> locAisles = new HashSet<>();
        for (Aisle aisle : aisles) {
            locAisles.add(toEntity(aisle, lazy));
        }
        return locAisles;
    }

    public static Set<Aisle> toDtos(Set<LocAisle> locAisles, boolean lazy) {
        if (null == locAisles) {
            return null;
        }
        Set<Aisle> aisles = new HashSet<>();
        for (LocAisle locAisle : locAisles) {
            aisles.add(toDto(locAisle, lazy));
        }
        return aisles;
    }

}

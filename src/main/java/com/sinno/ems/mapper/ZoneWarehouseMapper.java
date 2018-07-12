/**
 *
 */
package com.sinno.ems.mapper;

import java.util.*;

/**
 * @author aelguezzar
 */
public class ZoneWarehouseMapper {
    private ZoneWarehouseMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","");
        map.put("zone","locZone");
        map.put("warehouse","wrhWarehouse");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static ZoneWarehouse toDto(LocZoneWarehouse locZoneWarehouse, boolean lazy) {
        if (null == locZoneWarehouse) {
            return null;
        }
        ZoneWarehouse zoneWarehouse = new ZoneWarehouse();
        zoneWarehouse.setId(locZoneWarehouse.getLocZoneWarehouseId());
        if (!lazy) {
            zoneWarehouse.setZone(ZoneMapper.toDto(locZoneWarehouse.getLocZone(), true));
            zoneWarehouse.setWarehouse(WarehouseMapper.toDto(locZoneWarehouse.getWrhWarehouse(), true));
        }
        return zoneWarehouse;
    }

    public static LocZoneWarehouse toEntity(ZoneWarehouse zoneWarehouse, boolean lazy) {
        if (null == zoneWarehouse) {
            return null;
        }
        LocZoneWarehouse locZoneWarehouse = new LocZoneWarehouse();
        locZoneWarehouse.setLocZoneWarehouseId(zoneWarehouse.getId());
        if (!lazy) {
            locZoneWarehouse.setLocZone(ZoneMapper.toEntity(zoneWarehouse.getZone(), true));
            locZoneWarehouse.setWrhWarehouse(WarehouseMapper.toEntity(zoneWarehouse.getWarehouse(), true));
        }
        return locZoneWarehouse;
    }

    public static List<ZoneWarehouse> toDtos(List<LocZoneWarehouse> locZoneWarehouses, boolean lazy) {
        if (null == locZoneWarehouses) {
            return null;
        }
        List<ZoneWarehouse> zoneWarehouses = new ArrayList<>();
        for (LocZoneWarehouse locZoneWarehouse : locZoneWarehouses) {
            zoneWarehouses.add(toDto(locZoneWarehouse, lazy));
        }
        return zoneWarehouses;
    }

    public static List<ZoneWarehouse> toDtos(Iterable<LocZoneWarehouse> locZoneWarehouses, boolean lazy) {
        if (null == locZoneWarehouses) {
            return null;
        }
        List<ZoneWarehouse> zoneWarehouses = new ArrayList<>();
        for (LocZoneWarehouse locZoneWarehouse : locZoneWarehouses) {
            zoneWarehouses.add(toDto(locZoneWarehouse, lazy));
        }
        return zoneWarehouses;
    }

    public static Set<LocZoneWarehouse> toEntities(Set<ZoneWarehouse> zoneWarehouses, boolean lazy) {
        if (null == zoneWarehouses) {
            return null;
        }
        Set<LocZoneWarehouse> locZoneWarehouses = new HashSet<>();
        for (ZoneWarehouse zoneWarehouse : zoneWarehouses) {
            locZoneWarehouses.add(toEntity(zoneWarehouse, lazy));
        }
        return locZoneWarehouses;
    }

    public static Set<ZoneWarehouse> toDtos(Set<LocZoneWarehouse> locZoneWarehouses, boolean lazy) {
        if (null == locZoneWarehouses) {
            return null;
        }
        Set<ZoneWarehouse> zoneWarehouses = new HashSet<>();
        for (LocZoneWarehouse locZoneWarehouse : locZoneWarehouses) {
            zoneWarehouses.add(toDto(locZoneWarehouse, lazy));
        }
        return zoneWarehouses;
    }
}

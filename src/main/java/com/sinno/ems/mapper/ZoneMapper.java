/**
 *
 */
package com.sinno.ems.mapper;

import com.sinno.ems.dto.Zone;
import com.sinno.ems.entities.LocZone;

import java.util.*;

/**
 * @author aelguezzar
 */
public class ZoneMapper {
    private ZoneMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "locZoneId");
        map.put("warehouse", "wrhWarehouse");
        map.put("code", "locZoneCode");
        map.put("creationDate", "locZoneCreationDate");
        map.put("updateDate", "locZoneUpdateDate");
        map.put("description", "locZoneDescription");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static Zone toDto(LocZone locZone, boolean lazy) {
        if (null == locZone) {
            return null;
        }
        Zone zone = new Zone();
        zone.setCode(locZone.getLocZoneCode());
        zone.setCreationDate(locZone.getLocZoneCreationDate());
        zone.setId(locZone.getLocZoneId());
        zone.setUpdateDate(locZone.getLocZoneUpdateDate());
        zone.setDescription(locZone.getLocZoneDescription());
        if (!lazy) {
            //zone.setWarehouse(WarehouseMapper.toDto(locZone.getWrhWarehouse(), true));
            zone.setZoneWarehouses(ZoneWarehouseMapper.toDtos(locZone.getLocZoneWarehouses(), false));
// zone.setAisles(AisleMapper.toDtos(locZone.getLocAisles(), true));
//            zone.setLocations(LocationMapper.toDtos(locZone.getLocLocations(), true));
        }
        return zone;
    }

    public static LocZone toEntity(Zone zone, boolean lazy) {
        if (null == zone) {
            return null;
        }
        LocZone locZone = new LocZone();
        locZone.setLocZoneCode(zone.getCode() != null ? zone.getCode().toUpperCase() : null);
        locZone.setLocZoneCreationDate(zone.getCreationDate());
        locZone.setLocZoneId(zone.getId());
        locZone.setLocZoneUpdateDate(zone.getUpdateDate());
        locZone.setLocZoneDescription(zone.getDescription());
        if (!lazy) {
            locZone.setLocZoneWarehouses(ZoneWarehouseMapper.toEntities(zone.getZoneWarehouses(), false));
            //locZone.setWrhWarehouse(WarehouseMapper.toEntity(zone.getWarehouse(), true));
//            locZone.setLocAisles(AisleMapper.toEntities(zone.getAisles(), true));
//            locZone.setLocLocations(LocationMapper.toEntities(zone.getLocations(), true));
        }
        return locZone;
    }

    public static List<Zone> toDtos(List<LocZone> locZones, boolean lazy) {
        if (null == locZones) {
            return null;
        }
        List<Zone> zones = new ArrayList<>();
        for (LocZone locZone : locZones) {
            zones.add(toDto(locZone, lazy));
        }
        return zones;
    }

    public static List<Zone> toDtos(Iterable<LocZone> locZones, boolean lazy) {
        if (null == locZones) {
            return null;
        }
        List<Zone> zones = new ArrayList<>();
        for (LocZone locZone : locZones) {
            zones.add(toDto(locZone, lazy));
        }
        return zones;
    }

    public static Set<LocZone> toEntities(Set<Zone> zones, boolean lazy) {
        if (null == zones) {
            return null;
        }
        Set<LocZone> locZones = new HashSet<>();
        for (Zone zone : zones) {
            locZones.add(toEntity(zone, lazy));
        }
        return locZones;
    }

    public static Set<Zone> toDtos(Set<LocZone> locZones, boolean lazy) {
        if (null == locZones) {
            return null;
        }
        Set<Zone> zones = new HashSet<>();
        for (LocZone locZone : locZones) {
            zones.add(toDto(locZone, lazy));
        }
        return zones;
    }

}

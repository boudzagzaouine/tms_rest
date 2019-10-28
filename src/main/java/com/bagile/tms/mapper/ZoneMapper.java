package com.bagile.tms.mapper;

import com.bagile.tms.dto.Zone;
import com.bagile.tms.entities.TmsZone;

import java.util.*;

public class ZoneMapper {
    private ZoneMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsZoneId");
        map.put("name", "tmsZoneName");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static TmsZone toEntity(Zone zone, boolean lazy) {
        if (null == zone) {
            return null;
        }
        TmsZone tmsZone = new TmsZone();

        tmsZone.setTmsZoneId(zone.getId());
        tmsZone.setTmsZoneName(zone.getName());
        tmsZone.setCreatedBy(zone.getCreatedBy());
        tmsZone.setUpdatedBy(zone.getUpdatedBy());
        tmsZone.setCreationDate(zone.getCreationDate());
        tmsZone.setUpdateDate(zone.getUpdateDate());
        return tmsZone;
    }

    public static Zone toDto(TmsZone tmsZone, boolean lazy) {
        if (null == tmsZone) {
            return null;
        }
        Zone zone = new Zone();

        zone.setId(tmsZone.getTmsZoneId());
        zone.setName(tmsZone.getTmsZoneName());
        zone.setCreatedBy(tmsZone.getCreatedBy());
        zone.setUpdatedBy(tmsZone.getUpdatedBy());
        zone.setCreationDate(tmsZone.getCreationDate());
        zone.setUpdateDate(tmsZone.getUpdateDate());

        return zone;
    }

    public static List<Zone> toDtos(Iterable<? extends TmsZone> tmsZones, boolean lazy) {
        if (null == tmsZones) {
            return null;
        }
        List<Zone> zones = new ArrayList<>();
        for (TmsZone tmsZone : tmsZones) {
            zones.add(toDto(tmsZone, lazy));
        }
        return zones;
    }

    public static Set<TmsZone> toEntities(Set<Zone> zones, boolean lazy) {
        if (null == zones) {
            return null;
        }
        Set<TmsZone> tmsZones = new HashSet<>();
        for (Zone zone : zones) {
            tmsZones.add(toEntity(zone, lazy));
        }
        return tmsZones;
    }

    public static Set<Zone> toDtos(Set<TmsZone> tmsZones, boolean lazy) {
        if (null == tmsZones) {
            return null;
        }
        Set<Zone> zones = new HashSet<>();
        for (TmsZone tmsZone : tmsZones) {
            zones.add(toDto(tmsZone, lazy));
        }
        return zones;
    }

}

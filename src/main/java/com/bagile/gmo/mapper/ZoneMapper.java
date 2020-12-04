package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Zone;
import com.bagile.gmo.entities.GmoZone;

import java.util.*;

public class ZoneMapper {
    public ZoneMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoZoneId");
        map.put("code", "gmoZoneCode");
        map.put("description", "gmoZoneDescription");


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

    public static GmoZone toEntity(Zone zone, boolean lazy) {
        if (null == zone) {
            return null;
        }
        GmoZone gmoZone = new GmoZone();
        gmoZone.setGmoZoneId(zone.getId());
        gmoZone.setGmoZoneCode(zone.getCode() != null ? zone.getCode().toUpperCase() : null);
        gmoZone.setGmoZoneDescription(zone.getDescription() );


        gmoZone.setCreatedBy(zone.getCreatedBy());
        gmoZone.setUpdatedBy(zone.getUpdatedBy());
        gmoZone.setCreationDate(zone.getCreationDate());
        gmoZone.setUpdateDate(zone.getUpdateDate());

        if(!lazy) {

            gmoZone.setOwnOwner(OwnerMapper.toEntity(zone.getOwner(),true));

        }

        return gmoZone;

    }

    public static Zone toDto(GmoZone gmoZone, boolean lazy) {
        if (null == gmoZone) {
            return null;
        }
        Zone zone = new Zone();
        zone.setId( gmoZone.getGmoZoneId());
        zone.setCode(gmoZone.getGmoZoneCode());
        zone.setDescription(gmoZone.getGmoZoneDescription());


      if(!lazy){

          zone.setOwner(OwnerMapper.toDto(gmoZone.getOwnOwner(),true));

      }

        return zone;

    }


    public static List<Zone> toDtos(Iterable<? extends GmoZone> gmoZones, boolean lazy) {
        if (null == gmoZones) {
            return null;
        }
        List<Zone> vehicules = new ArrayList<>();

        for (GmoZone gmoZone : gmoZones) {
            vehicules.add(toDto(gmoZone, lazy));
        }
        return vehicules;
    }

    public static Set<GmoZone> toEntities(Set<Zone> zones, boolean lazy) {
        if (null == zones) {
            return null;
        }
        Set<GmoZone> gmoZones = new HashSet<>();
        for (Zone zone : zones) {
            gmoZones.add(toEntity(zone, lazy));
        }
        return gmoZones;
    }

    public static Set<Zone> toDtos(Set<GmoZone> gmoZones, boolean lazy) {
        if (null == gmoZones) {
            return null;
        }
        Set<Zone> zones = new HashSet<>();
        for (GmoZone gmoZone : gmoZones) {
            zones.add(toDto(gmoZone, lazy));
        }
        return zones;
    }
}

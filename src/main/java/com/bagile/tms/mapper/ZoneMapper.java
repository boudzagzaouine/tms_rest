package com.bagile.tms.mapper;

import com.bagile.tms.dto.Vacation;
import com.bagile.tms.dto.Zone;
import com.bagile.tms.entities.TmsVacation;
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
            tmsZone.setTmsZoneName(zone.getName());;

            return tmsZone;
        }

        public static Zone toDto(TmsZone tmsZone, boolean lazy) {
            if (null == tmsZone) {
                return null;
            }
            Zone zone = new Zone();

            zone.setId(tmsZone.getTmsZoneId());
            zone.setName(tmsZone.getTmsZoneName());

            return zone;
        }

        public static List<Zone> toDtos(List<TmsZone> tmsZones, boolean lazy) {
            if (null == tmsZones) {
                return null;
            }
            List<Zone> zones = new ArrayList<>();
            for (TmsZone tmsZone : tmsZones) {
                zones.add(toDto(tmsZone, lazy));

            }
            return zones;
        }
        public static List<Zone> toDtos(Iterable<TmsZone> tmsZones, boolean lazy) {
            if (null == tmsZones) {
                return null;
            }
            List<Zone> zones = new ArrayList<>();
            for (TmsZone tmsZone : tmsZones) {
                zones.add(toDto(tmsZone, lazy));
            }
            return zones;
        }
        public static Set<TmsZone> toEntities(Set<Zone>zones, boolean lazy){
            if (null == zones) {
                return null;
            }
            Set<TmsZone> tmsZones = new HashSet<>();
            for(Zone zone:zones){
                tmsZones.add(toEntity(zone,lazy));
            }
            return tmsZones;
        }
        public static Set<Zone> toDtos(Set<TmsZone> tmsZones, boolean lazy){
            if(null == tmsZones){
                return null;
            }
            Set<Zone> zones = new HashSet<>();
            for(TmsZone tmsZone : tmsZones){
                zones.add(toDto(tmsZone,lazy));
            }
            return zones;
        }

    }

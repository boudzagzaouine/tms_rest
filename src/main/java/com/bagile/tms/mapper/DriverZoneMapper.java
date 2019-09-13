package com.bagile.tms.mapper;

import com.bagile.tms.dto.Driver;
import com.bagile.tms.dto.DriverZone;
import com.bagile.tms.entities.TmsDriverZone;

import java.util.*;

public class DriverZoneMapper {

    public DriverZoneMapper() {
    }

    private static Map<String, String> map;


    static {
        map = new HashMap<>();
        map.put("id", "tmsDriverZoneid");
        map.put("driver", "tmsDriverZonedriver");
        map.put("zone", "tmsDriverZonezone");


    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }


    public static TmsDriverZone toEntity(DriverZone driverZone, boolean lazy) {
        if (null == driverZone) {
            return null;
        }
        TmsDriverZone tmsdriverzone = new TmsDriverZone();
        tmsdriverzone.setTmsDriverZoneid(driverZone.getId());

        if (!lazy) {
            tmsdriverzone.setTmsDriverZonedriver(DriverMapper.toEntity(driverZone.getDriver(), true));
            tmsdriverzone.setTmsDriverZonezone(ZoneMapper.toEntity(driverZone.getZone(), true));
        }
        return tmsdriverzone;
    }


    public static DriverZone toDto(TmsDriverZone tmsdriverZone, boolean lazy) {
        if (null == tmsdriverZone) {
            return null;
        }
        DriverZone driverzone = new DriverZone();
        driverzone.setId(tmsdriverZone.getTmsDriverZoneid());

        if (!lazy) {
            driverzone.setDriver(DriverMapper.toDto(tmsdriverZone.getTmsDriverZonedriver(), true));
            driverzone.setZone(ZoneMapper.toDto(tmsdriverZone.getTmsDriverZonezone(), true));

        }
        return driverzone;
    }

    public static List<DriverZone> toDtos(List<TmsDriverZone> tmsdriverzones, boolean lazy) {
        if (null == tmsdriverzones) {
            return null;
        }
        List<DriverZone> driverZones = new ArrayList<>();
        for (TmsDriverZone tmsdriverzone : tmsdriverzones) {
            driverZones.add(toDto(tmsdriverzone, lazy));

        }
        return driverZones;
    }

    public static List<DriverZone> toDtos(Iterable<TmsDriverZone> tmsdriverzones, boolean lazy) {
        if (null == tmsdriverzones) {
            return null;
        }
        List<DriverZone> driverZones = new ArrayList<>();
        for (TmsDriverZone tmsdriverzone : tmsdriverzones) {
            driverZones.add(toDto(tmsdriverzone, lazy));

        }
        return driverZones;
    }

    public static Set<TmsDriverZone> toEntities(Set<DriverZone> driverzones, boolean lazy) {
        if (null == driverzones) {
            return null;
        }
        Set<TmsDriverZone> tmsDriverszones = new HashSet<>();
        for (DriverZone driverzone : driverzones) {
            tmsDriverszones.add(toEntity(driverzone, lazy));
        }
        return tmsDriverszones;
    }


    public static Set<DriverZone> toDtos(Set<TmsDriverZone> tmsdriverszones, boolean lazy) {
        if (null == tmsdriverszones) {
            return null;
        }
        Set<DriverZone> driverszones = new HashSet<>();
        for (TmsDriverZone tmsdrivezone : tmsdriverszones) {
            driverszones.add(toDto(tmsdrivezone, lazy));
        }
        return driverszones;
    }

}

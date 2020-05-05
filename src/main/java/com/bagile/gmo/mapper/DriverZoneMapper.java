package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.DriverZone;
import com.bagile.gmo.entities.TmsDriverZone;

public class DriverZoneMapper {

    public DriverZoneMapper() {
    }

    private static Map<String, String> map;


    static {
        map = new HashMap<>();
        map.put("id", "tmsDriverZoneId");
        map.put("driver", "tmsDriverZoneDriver");
        map.put("zone", "tmsDriverZoneZone");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");

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
        tmsdriverzone.setTmsDriverZoneId(driverZone.getId());


        tmsdriverzone.setCreatedBy(driverZone.getCreatedBy());
        tmsdriverzone.setUpdatedBy(driverZone.getUpdatedBy());
        tmsdriverzone.setCreationDate(driverZone.getCreationDate());
        tmsdriverzone.setUpdateDate(driverZone.getUpdateDate());

        if (!lazy) {
            tmsdriverzone.setTmsDriverZoneDriver(DriverMapper.toEntity(driverZone.getDriver(), true));
            tmsdriverzone.setTmsDriverZoneZone(ZoneMapper.toEntity(driverZone.getZone(), true));
        }
        return tmsdriverzone;
    }


    public static DriverZone toDto(TmsDriverZone tmsdriverZone, boolean lazy) {
        if (null == tmsdriverZone) {
            return null;
        }
        DriverZone driverzone = new DriverZone();
        driverzone.setId(tmsdriverZone.getTmsDriverZoneId());

        if (!lazy) {
            driverzone.setDriver(DriverMapper.toDto(tmsdriverZone.getGmoDriverZoneDriver(), true));
            driverzone.setZone(ZoneMapper.toDto(tmsdriverZone.getTmsDriverZoneZone(), true));

        }
        return driverzone;
    }



    public static List<DriverZone> toDtos(Iterable<? extends  TmsDriverZone> tmsdriverzones, boolean lazy) {
        if (null == tmsdriverzones) {
            return null;
        }
        List<DriverZone> driverZones = new ArrayList<>();
        for (TmsDriverZone tmsdriverzone : tmsdriverzones) {
            driverZones.add(toDto(tmsdriverzone, lazy));

        }
        return driverZones;
    }

    public static Set<TmsDriverZone> toEntities(Set<? extends DriverZone> driverzones, boolean lazy) {
        if (null == driverzones) {
            return null;
        }
        Set<TmsDriverZone> tmsDriverszones = new HashSet<>();
        for (DriverZone driverzone : driverzones) {
            tmsDriverszones.add(toEntity(driverzone, lazy));
        }
        return tmsDriverszones;
    }


    public static Set<DriverZone> toDtos(Set<? extends TmsDriverZone> tmsdriverszones, boolean lazy) {
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

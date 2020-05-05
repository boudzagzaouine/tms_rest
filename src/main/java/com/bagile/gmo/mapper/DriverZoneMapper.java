package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.DriverZone;
import com.bagile.gmo.entities.GmoDriverZone;

public class DriverZoneMapper {

    public DriverZoneMapper() {
    }

    private static Map<String, String> map;


    static {
        map = new HashMap<>();
        map.put("id", "gmoDriverZoneId");
        map.put("driver", "gmoDriverZoneDriver");
        map.put("zone", "gmoDriverZoneZone");

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


    public static GmoDriverZone toEntity(DriverZone driverZone, boolean lazy) {
        if (null == driverZone) {
            return null;
        }
        GmoDriverZone gmodriverzone = new GmoDriverZone();
        gmodriverzone.setGmoDriverZoneId(driverZone.getId());


        gmodriverzone.setCreatedBy(driverZone.getCreatedBy());
        gmodriverzone.setUpdatedBy(driverZone.getUpdatedBy());
        gmodriverzone.setCreationDate(driverZone.getCreationDate());
        gmodriverzone.setUpdateDate(driverZone.getUpdateDate());

        if (!lazy) {
            gmodriverzone.setGmoDriverZoneDriver(DriverMapper.toEntity(driverZone.getDriver(), true));
            gmodriverzone.setGmoDriverZoneZone(ZoneMapper.toEntity(driverZone.getZone(), true));
        }
        return gmodriverzone;
    }


    public static DriverZone toDto(GmoDriverZone gmodriverZone, boolean lazy) {
        if (null == gmodriverZone) {
            return null;
        }
        DriverZone driverzone = new DriverZone();
        driverzone.setId(gmodriverZone.getGmoDriverZoneId());

        if (!lazy) {
            driverzone.setDriver(DriverMapper.toDto(gmodriverZone.getGmoDriverZoneDriver(), true));
            driverzone.setZone(ZoneMapper.toDto(gmodriverZone.getGmoDriverZoneZone(), true));

        }
        return driverzone;
    }



    public static List<DriverZone> toDtos(Iterable<? extends  GmoDriverZone> gmodriverzones, boolean lazy) {
        if (null == gmodriverzones) {
            return null;
        }
        List<DriverZone> driverZones = new ArrayList<>();
        for (GmoDriverZone gmodriverzone : gmodriverzones) {
            driverZones.add(toDto(gmodriverzone, lazy));

        }
        return driverZones;
    }

    public static Set<GmoDriverZone> toEntities(Set<? extends DriverZone> driverzones, boolean lazy) {
        if (null == driverzones) {
            return null;
        }
        Set<GmoDriverZone> gmoDriverszones = new HashSet<>();
        for (DriverZone driverzone : driverzones) {
            gmoDriverszones.add(toEntity(driverzone, lazy));
        }
        return gmoDriverszones;
    }


    public static Set<DriverZone> toDtos(Set<? extends GmoDriverZone> gmodriverszones, boolean lazy) {
        if (null == gmodriverszones) {
            return null;
        }
        Set<DriverZone> driverszones = new HashSet<>();
        for (GmoDriverZone gmodrivezone : gmodriverszones) {
            driverszones.add(toDto(gmodrivezone, lazy));
        }
        return driverszones;
    }

}

package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.BadgeTypeDriver;
import com.bagile.gmo.entities.GmoBadgeTypeDriver;

public class BadgeTypeDriverMapper {
    public BadgeTypeDriverMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoBadgeTypeDriverId");
        map.put("driver", "gmoDriver");
        map.put("badgeType", "gmoBadgeType");
        map.put("badgeNumber", "gmoBadgeNumber");
        map.put("deliveranceDate", "gmoDeliveranceDate");
        map.put("validityEndDate", "gmoValidityEndDate");

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

    public static GmoBadgeTypeDriver toEntity(BadgeTypeDriver badgeTypeDriver, boolean lazy) {
        if (null == badgeTypeDriver) {
            return null;
        }
        GmoBadgeTypeDriver gmoBadgeTypeDriver = new GmoBadgeTypeDriver();
        gmoBadgeTypeDriver.setGmoBadgeTypeDriverId(badgeTypeDriver.getId());
        gmoBadgeTypeDriver.setGmoBadgeNumber(badgeTypeDriver.getBadgeNumber());
        gmoBadgeTypeDriver.setGmoDeliveranceDate(badgeTypeDriver.getDeliveranceDate());
        gmoBadgeTypeDriver.setGmoValidityEndDate(badgeTypeDriver.getValidityEndDate());


        gmoBadgeTypeDriver.setCreatedBy(badgeTypeDriver.getCreatedBy());
        gmoBadgeTypeDriver.setUpdatedBy(badgeTypeDriver.getUpdatedBy());
        gmoBadgeTypeDriver.setCreationDate(badgeTypeDriver.getCreationDate());
        gmoBadgeTypeDriver.setUpdateDate(badgeTypeDriver.getUpdateDate());
        if (!lazy) {
            gmoBadgeTypeDriver.setGmoDriver(DriverMapper.toEntity(badgeTypeDriver.getDriver(), true));
            gmoBadgeTypeDriver.setGmoBadgeType(BadgeTypeMapper.toEntity(badgeTypeDriver.getBadgeType(),true));

        }
        return gmoBadgeTypeDriver;

    }

    public static BadgeTypeDriver toDto(GmoBadgeTypeDriver gmoBadgeTypeDriver, boolean lazy) {
        if (null == gmoBadgeTypeDriver) {
            return null;
        }
        BadgeTypeDriver badgeTypeDriver = new BadgeTypeDriver();
        badgeTypeDriver.setId((int) gmoBadgeTypeDriver.getGmoBadgeTypeDriverId());
        badgeTypeDriver.setBadgeNumber( gmoBadgeTypeDriver.getGmoBadgeNumber());
        badgeTypeDriver.setDeliveranceDate( gmoBadgeTypeDriver.getGmoDeliveranceDate());
        badgeTypeDriver.setValidityEndDate( gmoBadgeTypeDriver.getGmoValidityEndDate());


        if (!lazy) {
            badgeTypeDriver.setDriver(DriverMapper.toDto(gmoBadgeTypeDriver.getGmoDriver(), true));
            badgeTypeDriver.setBadgeType(BadgeTypeMapper.toDto(gmoBadgeTypeDriver.getGmoBadgeType(),true));
        }

        return badgeTypeDriver;

    }


    public static List<BadgeTypeDriver> toDtos(Iterable<? extends GmoBadgeTypeDriver> gmoBadgeTypeDrivers, boolean lazy) {
        if (null == gmoBadgeTypeDrivers) {
            return null;
        }
        List<BadgeTypeDriver> badgeTypeDrivers = new ArrayList<>();

        for (GmoBadgeTypeDriver gmoBadgeTypeDriver : gmoBadgeTypeDrivers) {
            badgeTypeDrivers.add(toDto(gmoBadgeTypeDriver, lazy));
        }
        return badgeTypeDrivers;
    }

    public static Set<GmoBadgeTypeDriver> toEntities(Iterable<? extends  BadgeTypeDriver> badgeTypeDriverType, boolean lazy) {
        if (null == badgeTypeDriverType) {
            return null;
        }
        Set<GmoBadgeTypeDriver> gmoBadgeTypeDrivers = new HashSet<>();
        for (BadgeTypeDriver badgeTypeDriver : badgeTypeDriverType) {
            gmoBadgeTypeDrivers.add(toEntity(badgeTypeDriver, lazy));
        }
        return gmoBadgeTypeDrivers;
    }

    /*public static Set<BadgeTypeDriver> toDtos(Set<GmoBadgeTypeDriver> gmoBadgeTypeDrivers, boolean lazy) {
        if (null == gmoBadgeTypeDrivers) {
            return null;
        }
        Set<BadgeTypeDriver> badgeTypeDriverType = new HashSet<>();
        for (GmoBadgeTypeDriver gmoBadgeTypeDriver : gmoBadgeTypeDrivers) {
            badgeTypeDriverType.add(toDto(gmoBadgeTypeDriver, lazy));
        }
        return badgeTypeDriverType;
    }*/
}

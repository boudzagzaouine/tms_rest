package com.bagile.tms.mapper;

import com.bagile.tms.dto.BadgeTypeDriver;
import com.bagile.tms.dto.BadgeTypeDriver;
import com.bagile.tms.entities.TmsBadgeTypeDriver;
import com.bagile.tms.entities.TmsBadgeTypeDriver;

import java.util.*;

public class BadgeTypeDriverMapper {
    public BadgeTypeDriverMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsBadgeTypeDriverId");
        map.put("driver", "tmsDriver");
        map.put("badgeType", "tmsBadgeType");
        map.put("badgeNumber", "tmsBadgeNumber");
        map.put("deliveranceDate", "tmsDeliveranceDate");
        map.put("validityEndDate", "tmsValidityEndDate");

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

    public static TmsBadgeTypeDriver toEntity(BadgeTypeDriver badgeTypeDriver, boolean lazy) {
        if (null == badgeTypeDriver) {
            return null;
        }
        TmsBadgeTypeDriver tmsBadgeTypeDriver = new TmsBadgeTypeDriver();
        tmsBadgeTypeDriver.setTmsBadgeTypeDriverId(badgeTypeDriver.getId());
        tmsBadgeTypeDriver.setTmsBadgeNumber(badgeTypeDriver.getBadgeNumber());
        tmsBadgeTypeDriver.setTmsDeliveranceDate(badgeTypeDriver.getDeliveranceDate());
        tmsBadgeTypeDriver.setTmsValidityEndDate(badgeTypeDriver.getValidityEndDate());


        tmsBadgeTypeDriver.setCreatedBy(badgeTypeDriver.getCreatedBy());
        tmsBadgeTypeDriver.setUpdatedBy(badgeTypeDriver.getUpdatedBy());
        tmsBadgeTypeDriver.setCreationDate(badgeTypeDriver.getCreationDate());
        tmsBadgeTypeDriver.setUpdateDate(badgeTypeDriver.getUpdateDate());
        if (!lazy) {
            tmsBadgeTypeDriver.setTmsDriver(DriverMapper.toEntity(badgeTypeDriver.getDriver(), true));
            tmsBadgeTypeDriver.setTmsBadgeType(BadgeTypeMapper.toEntity(badgeTypeDriver.getBadgeType(),true));

        }
        return tmsBadgeTypeDriver;

    }

    public static BadgeTypeDriver toDto(TmsBadgeTypeDriver tmsBadgeTypeDriver, boolean lazy) {
        if (null == tmsBadgeTypeDriver) {
            return null;
        }
        BadgeTypeDriver badgeTypeDriver = new BadgeTypeDriver();
        badgeTypeDriver.setId((int) tmsBadgeTypeDriver.getTmsBadgeTypeDriverId());
        badgeTypeDriver.setBadgeNumber( tmsBadgeTypeDriver.getTmsBadgeNumber());
        badgeTypeDriver.setDeliveranceDate( tmsBadgeTypeDriver.getTmsDeliveranceDate());
        badgeTypeDriver.setValidityEndDate( tmsBadgeTypeDriver.getTmsValidityEndDate());


        if (!lazy) {
            badgeTypeDriver.setDriver(DriverMapper.toDto(tmsBadgeTypeDriver.getTmsDriver(), true));
            badgeTypeDriver.setBadgeType(BadgeTypeMapper.toDto(tmsBadgeTypeDriver.getTmsBadgeType(),true));
        }

        return badgeTypeDriver;

    }


    public static List<BadgeTypeDriver> toDtos(Iterable<? extends TmsBadgeTypeDriver> tmsBadgeTypeDrivers, boolean lazy) {
        if (null == tmsBadgeTypeDrivers) {
            return null;
        }
        List<BadgeTypeDriver> badgeTypeDrivers = new ArrayList<>();

        for (TmsBadgeTypeDriver tmsBadgeTypeDriver : tmsBadgeTypeDrivers) {
            badgeTypeDrivers.add(toDto(tmsBadgeTypeDriver, lazy));
        }
        return badgeTypeDrivers;
    }

    public static Set<TmsBadgeTypeDriver> toEntities(Iterable<? extends  BadgeTypeDriver> badgeTypeDriverType, boolean lazy) {
        if (null == badgeTypeDriverType) {
            return null;
        }
        Set<TmsBadgeTypeDriver> tmsBadgeTypeDrivers = new HashSet<>();
        for (BadgeTypeDriver badgeTypeDriver : badgeTypeDriverType) {
            tmsBadgeTypeDrivers.add(toEntity(badgeTypeDriver, lazy));
        }
        return tmsBadgeTypeDrivers;
    }

    /*public static Set<BadgeTypeDriver> toDtos(Set<TmsBadgeTypeDriver> tmsBadgeTypeDrivers, boolean lazy) {
        if (null == tmsBadgeTypeDrivers) {
            return null;
        }
        Set<BadgeTypeDriver> badgeTypeDriverType = new HashSet<>();
        for (TmsBadgeTypeDriver tmsBadgeTypeDriver : tmsBadgeTypeDrivers) {
            badgeTypeDriverType.add(toDto(tmsBadgeTypeDriver, lazy));
        }
        return badgeTypeDriverType;
    }*/
}

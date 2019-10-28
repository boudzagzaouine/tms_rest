package com.bagile.tms.mapper;

import java.util.*;
import com.bagile.tms.dto.Badge;
import com.bagile.tms.entities.TmsBadge;
public class BadgeMapper {
    private BadgeMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsBadgeId");
        map.put("code", "tmsBadgeCode");
        map.put("badgetype", "tmsBadgeType");
        map.put("driver", "tmsDriver");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static TmsBadge toEntity(Badge badge, boolean lazy) {
        if (null == badge) {
            return null;
        }
        TmsBadge tmsBadge = new TmsBadge();
        tmsBadge.setTmsBadgeCode(badge.getCode());
        tmsBadge.setTmsBadgeId((int) badge.getId());
        if (!lazy) {
            tmsBadge.setTmsBadgeType(BadgeTypeMapper.toEntity(badge.getBadgeType(), true));
            tmsBadge.setTmsDriver(DriverMapper.toEntity(badge.getDriver(), true));
        }
        return tmsBadge;
    }

    public static Badge toDto(TmsBadge tmsBadge, boolean lazy) {
        if (null == tmsBadge) {
            return null;
        }
        Badge badge = new Badge();
        badge.setId((int) tmsBadge.getTmsBadgeId());
        badge.setCode(tmsBadge.getTmsBadgeCode());
        if (!lazy) {
            badge.setBadgeType(BadgeTypeMapper.toDto(tmsBadge.getTmsBadgeType(), true));
            badge.setDriver(DriverMapper.toDto(tmsBadge.getTmsDriver(), true));
        }
        return badge;
    }

    public static List<Badge> toDtos(List<TmsBadge> tmsBadges, boolean lazy) {
        if (null == tmsBadges) {
            return null;
        }
        List<Badge> badges = new ArrayList<>();
        for (TmsBadge tmsBadge : tmsBadges) {
            badges.add(toDto(tmsBadge, lazy));

        }
        return badges;
    }

    public static List<Badge> toDtos(Iterable<TmsBadge> tmsBadges, boolean lazy) {
        if (null == tmsBadges) {
            return null;
        }
        List<Badge> badges = new ArrayList<>();
        for (TmsBadge tmsBadge : tmsBadges) {
            badges.add(toDto(tmsBadge, lazy));
        }
        return badges;
    }

    public static Set<TmsBadge> toEntities(Set<Badge> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TmsBadge> tmsDrivers = new HashSet<>();
        for (Badge badge : badges) {
            tmsDrivers.add(toEntity(badge, lazy));
        }
        return tmsDrivers;
    }

    public static Set<Badge> toDtos(Set<TmsBadge> tmsBadges, boolean lazy) {
        if (null == tmsBadges) {
            return null;
        }
        Set<Badge> badges = new HashSet<>();
        for (TmsBadge tmsBadge : tmsBadges) {
            badges.add(toDto(tmsBadge, lazy));
        }
        return badges;
    }

}






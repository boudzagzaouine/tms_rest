package com.bagile.tms.mapper;

import com.bagile.tms.dto.BadgeType;
import com.bagile.tms.entities.TmsBadgeType;

import java.util.*;

public class BadgeTypeMapper {

    private BadgeTypeMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsBadgeTypeId");
        map.put("code", "tmsBadgeTypeCode");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static TmsBadgeType toEntity(BadgeType badgeType, boolean lazy) {
        if (null == badgeType) {
            return null;
        }
        TmsBadgeType tmsBadgeType = new TmsBadgeType();

        tmsBadgeType.setTmsBadgeTypeid(badgeType.getId());
        tmsBadgeType.setTmsBadgeTypecode(badgeType.getCode());

        return tmsBadgeType;
    }

    public static BadgeType toDto(TmsBadgeType tmsBadgeType, boolean lazy) {
        if (null == tmsBadgeType) {
            return null;
        }
        BadgeType badgeType = new BadgeType();

        badgeType.setId(tmsBadgeType.getTmsBadgeTypeid());
        badgeType.setCode(tmsBadgeType.getTmsBadgeTypecode());

        return badgeType;
    }

    public static List<BadgeType> toDtos(List<TmsBadgeType> tmsBadgeTypes, boolean lazy) {
        if (null == tmsBadgeTypes) {
            return null;
        }
        List<BadgeType> badgeTypes = new ArrayList<>();
        for (TmsBadgeType tmsBadgeType : tmsBadgeTypes) {
            badgeTypes.add(toDto(tmsBadgeType, lazy));
        }
        return badgeTypes;
    }

    public static List<BadgeType> toDtos(Iterable<TmsBadgeType> tmsBadgeTypes, boolean lazy) {
        if (null == tmsBadgeTypes) {
            return null;
        }
        List<BadgeType> badgeTypes = new ArrayList<>();
        for (TmsBadgeType tmsBadgeType : tmsBadgeTypes) {
            badgeTypes.add(toDto(tmsBadgeType, lazy));
        }
        return badgeTypes;
    }

    public static Set<TmsBadgeType> toEntities(Set<BadgeType> badgeTypes, boolean lazy) {
        if (null == badgeTypes) {
            return null;
        }
        Set<TmsBadgeType> tmsBadgeTypes = new HashSet<>();
        for (BadgeType badgeType : badgeTypes) {
            tmsBadgeTypes.add(toEntity(badgeType, lazy));
        }
        return tmsBadgeTypes;
    }

    public static Set<BadgeType> toDtos(Set<TmsBadgeType> tmsBadgeTypes, boolean lazy) {
        if (null == tmsBadgeTypes) {
            return null;
        }
        Set<BadgeType> badgeTypes = new HashSet<>();
        for (TmsBadgeType tmsBadgeType : tmsBadgeTypes) {
            badgeTypes.add(toDto(tmsBadgeType, lazy));
        }
        return badgeTypes;
    }

}

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

    public static TmsBadgeType toEntity(BadgeType badgeType, boolean lazy) {
        if (null == badgeType) {
            return null;
        }
        TmsBadgeType tmsBadgeType = new TmsBadgeType();

        tmsBadgeType.setTmsBadgeTypeId((int) badgeType.getId());
        tmsBadgeType.setTmsBadgeTypeCode(badgeType.getCode());

        tmsBadgeType.setCreatedBy(badgeType.getCreatedBy());
        tmsBadgeType.setUpdatedBy(badgeType.getUpdatedBy());
        tmsBadgeType.setCreationDate(badgeType.getCreationDate());
        tmsBadgeType.setUpdateDate(badgeType.getUpdateDate());

        return tmsBadgeType;
    }

    public static BadgeType toDto(TmsBadgeType tmsBadgeType, boolean lazy) {
        if (null == tmsBadgeType) {
            return null;
        }
        BadgeType badgeType = new BadgeType();

        badgeType.setId((int) tmsBadgeType.getTmsBadgeTypeId());
        badgeType.setCode(tmsBadgeType.getTmsBadgeTypeCode());

        badgeType.setCreatedBy(tmsBadgeType.getCreatedBy());
        badgeType.setUpdatedBy(tmsBadgeType.getUpdatedBy());
        badgeType.setCreationDate(tmsBadgeType.getCreationDate());
        badgeType.setUpdateDate(tmsBadgeType.getUpdateDate());

        return badgeType;
    }



    public static List<BadgeType> toDtos(Iterable<? extends TmsBadgeType> tmsBadgeTypes, boolean lazy) {
        if (null == tmsBadgeTypes) {
            return null;
        }
        List<BadgeType> badgeTypes = new ArrayList<>();
        for (TmsBadgeType tmsBadgeType : tmsBadgeTypes) {
            badgeTypes.add(toDto(tmsBadgeType, lazy));
        }
        return badgeTypes;
    }

    public static Set<TmsBadgeType> toEntities(Set<? extends BadgeType> badgeTypes, boolean lazy) {
        if (null == badgeTypes) {
            return null;
        }
        Set<TmsBadgeType> tmsBadgeTypes = new HashSet<>();
        for (BadgeType badgeType : badgeTypes) {
            tmsBadgeTypes.add(toEntity(badgeType, lazy));
        }
        return tmsBadgeTypes;
    }

    public static Set<BadgeType> toDtos(Set<? extends TmsBadgeType> tmsBadgeTypes, boolean lazy) {
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

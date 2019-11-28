package com.bagile.tms.mapper;

import com.bagile.tms.dto.BadgeType;
import com.bagile.tms.entities.TmsBadgeType;

import java.util.*;

public class BadgeTypeMapper {
    public BadgeTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsBadgeTypeId");
        map.put("code", "tmsBadgeTypeCode");
        map.put("description", "tmsBadgeTypeDescription");

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

    public static TmsBadgeType toEntity(BadgeType badgeType, boolean lazy) {
        if (null == badgeType) {
            return null;
        }
        TmsBadgeType tmsBadgeType = new TmsBadgeType();
        tmsBadgeType.setTmsBadgeTypeId(badgeType.getId());
        tmsBadgeType.setTmsBadgeTypeCode(badgeType.getCode() != null ? badgeType.getCode().toUpperCase() : null);
        tmsBadgeType.setTmsBadgeTypeDescription (badgeType.getDescription ());


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
        badgeType.setDescription (tmsBadgeType.getTmsBadgeTypeDescription ());


        return badgeType;

    }


    public static List<BadgeType> toDtos(Iterable<? extends TmsBadgeType> tmsBadgeTypes, boolean lazy) {
        if (null == tmsBadgeTypes) {
            return null;
        }
        List<BadgeType> vehicules = new ArrayList<>();

        for (TmsBadgeType tmsBadgeType : tmsBadgeTypes) {
            vehicules.add(toDto(tmsBadgeType, lazy));
        }
        return vehicules;
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

package com.bagile.tms.mapper;

import com.bagile.tms.dto.Badge;
import com.bagile.tms.entities.TmsBadge;

import java.util.*;

public class BadgeMapper {
    public BadgeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsBadgeId");
        map.put("code", "tmsBadgeCode");
        map.put("badgeType", "tmsBadgeType");
       
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

    public static TmsBadge toEntity(Badge badge, boolean lazy) {
        if (null == badge) {
            return null;
        }
        TmsBadge tmsBadge = new TmsBadge();
        tmsBadge.setTmsBadgeId(badge.getId());
        tmsBadge.setTmsBadgeCode(badge.getCode() != null ? badge.getCode().toUpperCase() : null);
      


        tmsBadge.setCreatedBy(badge.getCreatedBy());
        tmsBadge.setUpdatedBy(badge.getUpdatedBy());
        tmsBadge.setCreationDate(badge.getCreationDate());
        tmsBadge.setUpdateDate(badge.getUpdateDate());

        if(!lazy) {

             tmsBadge.setTmsBadgeType(BadgeTypeMapper.toEntity(badge.getBadgeType(),true));

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
     


        badge.setCreatedBy(tmsBadge.getCreatedBy());
        badge.setUpdatedBy(tmsBadge.getUpdatedBy());
        badge.setCreationDate(tmsBadge.getCreationDate());
        badge.setUpdateDate(tmsBadge.getUpdateDate());

        if(!lazy) {

             badge.setBadgeType(BadgeTypeMapper.toDto(tmsBadge.getTmsBadgeType(),true));

        }
        return badge;

    }


    public static List<Badge> toDtos(Iterable<? extends TmsBadge> tmsBadges, boolean lazy) {
        if (null == tmsBadges) {
            return null;
        }
        List<Badge> vehicules = new ArrayList<>();

        for (TmsBadge tmsBadge : tmsBadges) {
            vehicules.add(toDto(tmsBadge, lazy));
        }
        return vehicules;
    }

    public static Set<TmsBadge> toEntities(Set<Badge> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TmsBadge> tmsBadges = new HashSet<>();
        for (Badge badge : badges) {
            tmsBadges.add(toEntity(badge, lazy));
        }
        return tmsBadges;
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

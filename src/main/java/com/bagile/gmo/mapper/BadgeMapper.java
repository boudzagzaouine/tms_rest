package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Badge;
import com.bagile.gmo.entities.GmoBadge;

import java.util.*;

public class BadgeMapper {
    public BadgeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoBadgeId");
        map.put ("code", "gmoBadgeCode");
        map.put ("driver", "gmoBadgeCode");
        map.put ("badgeType", "gmoBadgeType");
        map.put ("description", "gmoBadgeDescription");
        map.put ("creationDate", "creationDate");
        map.put ("updateDate", "updateDate");
        map.put ("createdBy", "createdBy");
        map.put ("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get (key);
    }

    public static GmoBadge toEntity(Badge badge, boolean lazy) {
        if (null == badge) {
            return null;
        }

        GmoBadge gmoBadge = new GmoBadge ( );
        gmoBadge.setGmoBadgeId (badge.getId ( ));
        gmoBadge.setGmoBadgeCode (badge.getCode ( ) != null ? badge.getCode ( ).toUpperCase ( ) : null);
        gmoBadge.setGmoBadgeDescription (badge.getDescription ( ));
        gmoBadge.setCreatedBy (badge.getCreatedBy ( ));
        gmoBadge.setUpdatedBy (badge.getUpdatedBy ( ));

        if (!lazy) {
            gmoBadge.setGmoBadgeType (BadgeTypeMapper.toEntity (badge.getBadgeType ( ), true));
        }

        return gmoBadge;

    }

    public static Badge toDto(GmoBadge gmoBadge, boolean lazy) {
        if (null == gmoBadge) {
            return null;
        }
        Badge badge = new Badge ( );
        badge.setId (gmoBadge.getGmoBadgeId ());
        badge.setCode (gmoBadge.getGmoBadgeCode ());
        badge.setDescription (gmoBadge.getGmoBadgeDescription ());

        badge.setCreatedBy (gmoBadge.getCreatedBy ());
        badge.setUpdatedBy (gmoBadge.getUpdatedBy ());
        badge.setCreationDate (gmoBadge.getCreationDate ());
        badge.setUpdateDate (gmoBadge.getUpdateDate ());

        if (!lazy) {
            badge.setBadgeType (BadgeTypeMapper.toDto (gmoBadge.getGmoBadgeType(), true));
        }
        return badge;

    }


    public static List<Badge> toDtos(Iterable<? extends GmoBadge> gmoBadges, boolean lazy) {
        if (null == gmoBadges) {
            return null;
        }
        List<Badge> vehicules = new ArrayList<> ( );

        for (GmoBadge gmoBadge : gmoBadges) {
            vehicules.add (toDto (gmoBadge, lazy));
        }
        return vehicules;
    }

    public static Set<GmoBadge> toEntities(Set<Badge> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<GmoBadge> gmoBadges = new HashSet<> ( );
        for (Badge badge : badges) {
            gmoBadges.add (toEntity (badge, lazy));
        }
        return gmoBadges;
    }

    public static Set<Badge> toDtos(Set<GmoBadge> gmoBadges, boolean lazy) {
        if (null == gmoBadges) {
            return null;
        }
        Set<Badge> badges = new HashSet<> ( );
        for (GmoBadge gmoBadge : gmoBadges) {
            badges.add (toDto (gmoBadge, lazy));
        }
        return badges;
    }
}

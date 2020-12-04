package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.BadgeType;
import com.bagile.gmo.entities.GmoBadgeType;

import java.util.*;

public class BadgeTypeMapper {
    public BadgeTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoBadgeTypeId");
        map.put("code", "gmoBadgeTypeCode");
        map.put("description", "gmoBadgeTypeDescription");

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

    public static GmoBadgeType toEntity(BadgeType badgeType, boolean lazy) {
        if (null == badgeType) {
            return null;
        }
        GmoBadgeType gmoBadgeType = new GmoBadgeType();
        gmoBadgeType.setGmoBadgeTypeId(badgeType.getId());
        gmoBadgeType.setGmoBadgeTypeCode(badgeType.getCode() != null ? badgeType.getCode().toUpperCase() : null);
        gmoBadgeType.setGmoBadgeTypeDescription (badgeType.getDescription ());

        gmoBadgeType.setCreatedBy(badgeType.getCreatedBy());
        gmoBadgeType.setUpdatedBy(badgeType.getUpdatedBy());
        gmoBadgeType.setCreationDate(badgeType.getCreationDate());
        gmoBadgeType.setUpdateDate(badgeType.getUpdateDate());

          if(!lazy){
              gmoBadgeType.setOwnOwner(OwnerMapper.toEntity(badgeType.getOwner(),true));
          }

        return gmoBadgeType;

    }

    public static BadgeType toDto(GmoBadgeType gmoBadgeType, boolean lazy) {
        if (null == gmoBadgeType) {
            return null;
        }
        BadgeType badgeType = new BadgeType();
        badgeType.setId((int) gmoBadgeType.getGmoBadgeTypeId());
        badgeType.setCode(gmoBadgeType.getGmoBadgeTypeCode());
        badgeType.setDescription (gmoBadgeType.getGmoBadgeTypeDescription ());

 if(!lazy){
      badgeType.setOwner(OwnerMapper.toDto(gmoBadgeType.getOwnOwner(),true));
 }
        return badgeType;

    }


    public static List<BadgeType> toDtos(Iterable<? extends GmoBadgeType> gmoBadgeTypes, boolean lazy) {
        if (null == gmoBadgeTypes) {
            return null;
        }
        List<BadgeType> vehicules = new ArrayList<>();

        for (GmoBadgeType gmoBadgeType : gmoBadgeTypes) {
            vehicules.add(toDto(gmoBadgeType, lazy));
        }
        return vehicules;
    }

    public static Set<GmoBadgeType> toEntities(Set<BadgeType> badgeTypes, boolean lazy) {
        if (null == badgeTypes) {
            return null;
        }
        Set<GmoBadgeType> gmoBadgeTypes = new HashSet<>();
        for (BadgeType badgeType : badgeTypes) {
            gmoBadgeTypes.add(toEntity(badgeType, lazy));
        }
        return gmoBadgeTypes;
    }

    public static Set<BadgeType> toDtos(Set<GmoBadgeType> gmoBadgeTypes, boolean lazy) {
        if (null == gmoBadgeTypes) {
            return null;
        }
        Set<BadgeType> badgeTypes = new HashSet<>();
        for (GmoBadgeType gmoBadgeType : gmoBadgeTypes) {
            badgeTypes.add(toDto(gmoBadgeType, lazy));
        }
        return badgeTypes;
    }
}

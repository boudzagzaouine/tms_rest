package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.SubscriptionCardType;
import com.bagile.gmo.entities.GmoSubscriptionCardType;

import java.util.*;

public class SubscriptionCardTypeMapper {
    public SubscriptionCardTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoSubscriptionCardTypeId");
        map.put("code", "gmoSubscriptionCardTypeCode");
        map.put("description", "gmoSubscriptionCardTypeDescription");

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

    public static GmoSubscriptionCardType toEntity(SubscriptionCardType subscriptionCardType, boolean lazy) {
        if (null == subscriptionCardType) {
            return null;
        }
        GmoSubscriptionCardType gmoSubscriptionCardType = new GmoSubscriptionCardType();
        gmoSubscriptionCardType.setGmoSubscriptionCardTypeId(subscriptionCardType.getId());
        gmoSubscriptionCardType.setGmoSubscriptionCardTypeCode(subscriptionCardType.getCode() != null ? subscriptionCardType.getCode().toUpperCase() : null);
        gmoSubscriptionCardType.setGmoSubscriptionCardTypeDescription (subscriptionCardType.getDescription ());

        gmoSubscriptionCardType.setCreatedBy(subscriptionCardType.getCreatedBy());
        gmoSubscriptionCardType.setUpdatedBy(subscriptionCardType.getUpdatedBy());
        gmoSubscriptionCardType.setCreationDate(subscriptionCardType.getCreationDate());
        gmoSubscriptionCardType.setUpdateDate(subscriptionCardType.getUpdateDate());

          if(!lazy){
              gmoSubscriptionCardType.setOwnOwner(OwnerMapper.toEntity(subscriptionCardType.getOwner(),true));
          }

        return gmoSubscriptionCardType;

    }

    public static SubscriptionCardType toDto(GmoSubscriptionCardType gmoSubscriptionCardType, boolean lazy) {
        if (null == gmoSubscriptionCardType) {
            return null;
        }
        SubscriptionCardType subscriptionCardType = new SubscriptionCardType();
        subscriptionCardType.setId(gmoSubscriptionCardType.getGmoSubscriptionCardTypeId());
        subscriptionCardType.setCode(gmoSubscriptionCardType.getGmoSubscriptionCardTypeCode());
        subscriptionCardType.setDescription (gmoSubscriptionCardType.getGmoSubscriptionCardTypeDescription ());

 if(!lazy){
      subscriptionCardType.setOwner(OwnerMapper.toDto(gmoSubscriptionCardType.getOwnOwner(),true));
 }
        return subscriptionCardType;

    }


    public static List<SubscriptionCardType> toDtos(Iterable<? extends GmoSubscriptionCardType> gmoSubscriptionCardTypes, boolean lazy) {
        if (null == gmoSubscriptionCardTypes) {
            return null;
        }
        List<SubscriptionCardType> vehicules = new ArrayList<>();

        for (GmoSubscriptionCardType gmoSubscriptionCardType : gmoSubscriptionCardTypes) {
            vehicules.add(toDto(gmoSubscriptionCardType, lazy));
        }
        return vehicules;
    }

    public static Set<GmoSubscriptionCardType> toEntities(Set<SubscriptionCardType> subscriptionCardTypes, boolean lazy) {
        if (null == subscriptionCardTypes) {
            return null;
        }
        Set<GmoSubscriptionCardType> gmoSubscriptionCardTypes = new HashSet<>();
        for (SubscriptionCardType subscriptionCardType : subscriptionCardTypes) {
            gmoSubscriptionCardTypes.add(toEntity(subscriptionCardType, lazy));
        }
        return gmoSubscriptionCardTypes;
    }

    public static Set<SubscriptionCardType> toDtos(Set<GmoSubscriptionCardType> gmoSubscriptionCardTypes, boolean lazy) {
        if (null == gmoSubscriptionCardTypes) {
            return null;
        }
        Set<SubscriptionCardType> subscriptionCardTypes = new HashSet<>();
        for (GmoSubscriptionCardType gmoSubscriptionCardType : gmoSubscriptionCardTypes) {
            subscriptionCardTypes.add(toDto(gmoSubscriptionCardType, lazy));
        }
        return subscriptionCardTypes;
    }
}

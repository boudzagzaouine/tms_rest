package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.SubscriptionCard;
import com.bagile.gmo.entities.GmoSubscriptionCard;

import java.util.*;

public class SubscriptionCardMapper {
    public SubscriptionCardMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoSubscriptionCardId");
        map.put("code", "gmoSubscriptionCardCode");
        map.put("description", "gmoSubscriptionCardDescription");

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

    public static GmoSubscriptionCard toEntity(SubscriptionCard subscriptionCard, boolean lazy) {
        if (null == subscriptionCard) {
            return null;
        }
        GmoSubscriptionCard gmoSubscriptionCard = new GmoSubscriptionCard();
        gmoSubscriptionCard.setGmoSubscriptionCardId(subscriptionCard.getId());
        gmoSubscriptionCard.setGmoSubscriptionCardCode(subscriptionCard.getCode() != null ? subscriptionCard.getCode().toUpperCase() : null);
        gmoSubscriptionCard.setGmoSubscriptionCardDescription (subscriptionCard.getDescription ());

        gmoSubscriptionCard.setCreatedBy(subscriptionCard.getCreatedBy());
        gmoSubscriptionCard.setUpdatedBy(subscriptionCard.getUpdatedBy());
        gmoSubscriptionCard.setCreationDate(subscriptionCard.getCreationDate());
        gmoSubscriptionCard.setUpdateDate(subscriptionCard.getUpdateDate());

          if(!lazy){
              gmoSubscriptionCard.setOwnOwner(OwnerMapper.toEntity(subscriptionCard.getOwner(),true));
          }

        return gmoSubscriptionCard;

    }

    public static SubscriptionCard toDto(GmoSubscriptionCard gmoSubscriptionCard, boolean lazy) {
        if (null == gmoSubscriptionCard) {
            return null;
        }
        SubscriptionCard subscriptionCard = new SubscriptionCard();
        subscriptionCard.setId(gmoSubscriptionCard.getGmoSubscriptionCardId());
        subscriptionCard.setCode(gmoSubscriptionCard.getGmoSubscriptionCardCode());
        subscriptionCard.setDescription (gmoSubscriptionCard.getGmoSubscriptionCardDescription ());

 if(!lazy){
      subscriptionCard.setOwner(OwnerMapper.toDto(gmoSubscriptionCard.getOwnOwner(),true));
 }
        return subscriptionCard;

    }


    public static List<SubscriptionCard> toDtos(Iterable<? extends GmoSubscriptionCard> gmoSubscriptionCards, boolean lazy) {
        if (null == gmoSubscriptionCards) {
            return null;
        }
        List<SubscriptionCard> vehicules = new ArrayList<>();

        for (GmoSubscriptionCard gmoSubscriptionCard : gmoSubscriptionCards) {
            vehicules.add(toDto(gmoSubscriptionCard, lazy));
        }
        return vehicules;
    }

    public static Set<GmoSubscriptionCard> toEntities(Set<SubscriptionCard> subscriptionCards, boolean lazy) {
        if (null == subscriptionCards) {
            return null;
        }
        Set<GmoSubscriptionCard> gmoSubscriptionCards = new HashSet<>();
        for (SubscriptionCard subscriptionCard : subscriptionCards) {
            gmoSubscriptionCards.add(toEntity(subscriptionCard, lazy));
        }
        return gmoSubscriptionCards;
    }

    public static Set<SubscriptionCard> toDtos(Set<GmoSubscriptionCard> gmoSubscriptionCards, boolean lazy) {
        if (null == gmoSubscriptionCards) {
            return null;
        }
        Set<SubscriptionCard> subscriptionCards = new HashSet<>();
        for (GmoSubscriptionCard gmoSubscriptionCard : gmoSubscriptionCards) {
            subscriptionCards.add(toDto(gmoSubscriptionCard, lazy));
        }
        return subscriptionCards;
    }
}

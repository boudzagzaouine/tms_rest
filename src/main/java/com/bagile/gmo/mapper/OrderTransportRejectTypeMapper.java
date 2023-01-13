package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransportRejectType;
import com.bagile.gmo.entities.TmsOrderTransportRejectType;
import com.bagile.gmo.mapper.OwnerMapper;


import java.util.*;

public class OrderTransportRejectTypeMapper {
    public OrderTransportRejectTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderTransportRejectTypeId");
        map.put("code", "tmsOrderTransportRejectTypeCode");
        map.put("description", "tmsOrderTransportRejectTypeDescription");
        map.put("type", "tmsOrderTransportRejectTypeType");

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

    public static TmsOrderTransportRejectType toEntity(OrderTransportRejectType orderTransportRejectType, boolean lazy) {
        if (null == orderTransportRejectType) {
            return null;
        }
        TmsOrderTransportRejectType tmsOrderTransportRejectType = new TmsOrderTransportRejectType();
        tmsOrderTransportRejectType.setTmsOrderTransportRejectTypeId(orderTransportRejectType.getId());
        tmsOrderTransportRejectType.setTmsOrderTransportRejectTypeCode(orderTransportRejectType.getCode() != null ? orderTransportRejectType.getCode().toUpperCase() : null);
        tmsOrderTransportRejectType.setTmsOrderTransportRejectTypeDescription (orderTransportRejectType.getDescription ());
        tmsOrderTransportRejectType.setTmsOrderTransportRejectTypeType (orderTransportRejectType.getType ());



          if(!lazy){
              tmsOrderTransportRejectType.setOwnOwner(OwnerMapper.toEntity(orderTransportRejectType.getOwner(),true));
          }

        return tmsOrderTransportRejectType;

    }

    public static OrderTransportRejectType toDto(TmsOrderTransportRejectType tmsOrderTransportRejectType, boolean lazy) {
        if (null == tmsOrderTransportRejectType) {
            return null;
        }
        OrderTransportRejectType orderTransportRejectType = new OrderTransportRejectType();
        orderTransportRejectType.setId(tmsOrderTransportRejectType.getTmsOrderTransportRejectTypeId());
        orderTransportRejectType.setCode(tmsOrderTransportRejectType.getTmsOrderTransportRejectTypeCode());
        orderTransportRejectType.setDescription (tmsOrderTransportRejectType.getTmsOrderTransportRejectTypeDescription ());
        orderTransportRejectType.setType (tmsOrderTransportRejectType.getTmsOrderTransportRejectTypeType ());

 if(!lazy){
      orderTransportRejectType.setOwner(OwnerMapper.toDto(tmsOrderTransportRejectType.getOwnOwner(),true));
 }
        return orderTransportRejectType;

    }


    public static List<OrderTransportRejectType> toDtos(Iterable<? extends TmsOrderTransportRejectType> tmsOrderTransportRejectTypes, boolean lazy) {
        if (null == tmsOrderTransportRejectTypes) {
            return null;
        }
        List<OrderTransportRejectType> vehicules = new ArrayList<>();

        for (TmsOrderTransportRejectType tmsOrderTransportRejectType : tmsOrderTransportRejectTypes) {
            vehicules.add(toDto(tmsOrderTransportRejectType, lazy));
        }
        return vehicules;
    }

    public static Set<TmsOrderTransportRejectType> toEntities(Set<OrderTransportRejectType> orderTransportRejectTypes, boolean lazy) {
        if (null == orderTransportRejectTypes) {
            return null;
        }
        Set<TmsOrderTransportRejectType> tmsOrderTransportRejectTypes = new HashSet<>();
        for (OrderTransportRejectType orderTransportRejectType : orderTransportRejectTypes) {
            tmsOrderTransportRejectTypes.add(toEntity(orderTransportRejectType, lazy));
        }
        return tmsOrderTransportRejectTypes;
    }

    public static Set<OrderTransportRejectType> toDtos(Set<TmsOrderTransportRejectType> tmsOrderTransportRejectTypes, boolean lazy) {
        if (null == tmsOrderTransportRejectTypes) {
            return null;
        }
        Set<OrderTransportRejectType> orderTransportRejectTypes = new HashSet<>();
        for (TmsOrderTransportRejectType tmsOrderTransportRejectType : tmsOrderTransportRejectTypes) {
            orderTransportRejectTypes.add(toDto(tmsOrderTransportRejectType, lazy));
        }
        return orderTransportRejectTypes;
    }
}

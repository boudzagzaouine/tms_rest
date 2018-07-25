package com.bagile.tms.mapper;

import com.bagile.tms.dto.OrderType;
import com.bagile.tms.entities.PrmOrderType;

import java.util.*;

public class OrderTypeMapper {
    private OrderTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmOrderTypeId");
        map.put("code", "prmOrderTypeCode");
        map.put("description", "prmOrderTypeDescription");
        map.put("creationDate", "prmOrderTypeCreationDate");
        map.put("updateDate", "prmOrderTypeUpdateDate");
        map.put("flow", "prmOrderTypeFlow");
        map.put("active", "prmOrderTypeActive");
        map.put("organisation", "prmOrderTypeOrganisation");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmOrderType toEntity(OrderType orderType, boolean lazy) {
        if (null == orderType) {
            return null;
        }
        PrmOrderType prmOrderType = new PrmOrderType();
        prmOrderType.setPrmOrderTypeId(orderType.getId());
        prmOrderType.setPrmOrderTypeCode(orderType.getCode() != null ? orderType.getCode().toUpperCase() : null);
        prmOrderType.setPrmOrderTypeDescription(orderType.getDescription());
        prmOrderType.setPrmOrderTypeCreationDate(orderType.getCreationDate());
        prmOrderType.setPrmOrderTypeUpdateDate(orderType.getUpdateDate());
        prmOrderType.setPrmOrderTypeFlow(orderType.getFlow());
        prmOrderType.setPrmOrderTypeActive(orderType.getActive());
        if (!lazy) {
            prmOrderType.setOrgOrganisation(OrganisationMapper.toEntity(orderType.getOrganisation(), true));
        }
        return prmOrderType;
    }

    public static OrderType toDto(PrmOrderType prmOrderType, boolean lazy) {
        if (null == prmOrderType) {
            return null;
        }
        OrderType orderType = new OrderType();
        orderType.setId(prmOrderType.getPrmOrderTypeId());
        orderType.setCode(prmOrderType.getPrmOrderTypeCode());
        orderType.setDescription(prmOrderType.getPrmOrderTypeDescription());
        orderType.setCreationDate(prmOrderType.getPrmOrderTypeCreationDate());
        orderType.setUpdateDate(prmOrderType.getPrmOrderTypeUpdateDate());
        orderType.setFlow(prmOrderType.getPrmOrderTypeFlow());
        orderType.setActive(prmOrderType.getPrmOrderTypeActive());
        if (!lazy) {
            orderType.setOrganisation(OrganisationMapper.toDto(prmOrderType.getOrgOrganisation(), true));
        }
        return orderType;
    }

    public static List<OrderType> toDtos(List<PrmOrderType> prmOrderTypes, boolean lazy) {
        if (null == prmOrderTypes) {
            return null;
        }
        List<OrderType> orderTypes = new ArrayList<>();
        for (PrmOrderType prmOrderType : prmOrderTypes) {
            orderTypes.add(toDto(prmOrderType, lazy));
        }
        return orderTypes;
    }

    public static List<OrderType> toDtos(Iterable<PrmOrderType> prmOrderTypes, boolean lazy) {
        if (null == prmOrderTypes) {
            return null;
        }
        List<OrderType> orderTypes = new ArrayList<>();
        for (PrmOrderType prmOrderType : prmOrderTypes) {
            orderTypes.add(toDto(prmOrderType, lazy));
        }
        return orderTypes;
    }

    public static Set<PrmOrderType> toEntities(Set<OrderType> orderTypes, boolean lazy) {
        if (null == orderTypes) {
            return null;
        }
        Set<PrmOrderType> prmOrderTypes = new HashSet<>();
        for (OrderType orderType : orderTypes) {
            prmOrderTypes.add(toEntity(orderType, lazy));
        }
        return prmOrderTypes;
    }

    public static Set<OrderType> toDtos(Set<PrmOrderType> prmOrderTypes, boolean lazy) {
        if (null == prmOrderTypes) {
            return null;
        }
        Set<OrderType> orderTypes = new HashSet<>();
        for (PrmOrderType prmOrderType : prmOrderTypes) {
            orderTypes.add(toDto(prmOrderType, lazy));
        }
        return orderTypes;
    }
}

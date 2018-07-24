package com.bagile.tms.mapper;

import com.sinno.ems.dto.OrderStatus;
import com.sinno.ems.entities.PrmOrderStatus;

import java.util.*;

public class OrderStatusMapper {
    private OrderStatusMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","prmOrderStatusId");
        map.put("code","prmOrderStatusCode");
        map.put("description","prmOrderStatusDescription");
        map.put("orderType","prmOrderStatusOrderType");
        map.put("archivable","prmOrderStatusArchivable");
        map.put("organisation","prmOrderStatusOrganisation");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmOrderStatus toEntity(OrderStatus orderStatus, boolean lazy) {
        if (null == orderStatus) {
            return null;
        }
        PrmOrderStatus prmOrderStatus = new PrmOrderStatus();
        prmOrderStatus.setPrmOrderStatusId(orderStatus.getId());
        prmOrderStatus.setPrmOrderStatusCode(orderStatus.getCode()!=null?orderStatus.getCode().toUpperCase():null);
        prmOrderStatus.setPrmOrderStatusDescription(orderStatus.getDescription());
        prmOrderStatus.setPrmOrderStatusOrderType(orderStatus.isOrderType());
        prmOrderStatus.setPrmOrderStatusArchivable(orderStatus.getArchivable());
        if (!lazy) {
            prmOrderStatus.setOrgOrganisation(OrganisationMapper.toEntity(orderStatus.getOrganisation(), true));
        }
        return prmOrderStatus;
    }

    public static OrderStatus toDto(PrmOrderStatus prmOrderStatus, boolean lazy) {
        if (null == prmOrderStatus) {
            return null;
        }
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(prmOrderStatus.getPrmOrderStatusId());
        orderStatus.setCode(prmOrderStatus.getPrmOrderStatusCode());
        orderStatus.setDescription(prmOrderStatus.getPrmOrderStatusDescription());
        orderStatus.setOrderType(prmOrderStatus.isPrmOrderStatusOrderType());
        orderStatus.setArchivable(prmOrderStatus.getPrmOrderStatusArchivable());
        if (!lazy) {
            orderStatus.setOrganisation(OrganisationMapper.toDto(prmOrderStatus.getOrgOrganisation(), true));
        }
        return orderStatus;
    }

    public static List<OrderStatus> toDtos(List<PrmOrderStatus> prmOrderStatuss, boolean lazy) {
        if (null == prmOrderStatuss) {
            return null;
        }
        List<OrderStatus> orderStatuss = new ArrayList<>();
        for (PrmOrderStatus prmOrderStatus : prmOrderStatuss) {
            orderStatuss.add(toDto(prmOrderStatus, lazy));
        }
        return orderStatuss;
    }

    public static List<OrderStatus> toDtos(Iterable<PrmOrderStatus> prmOrderStatuss, boolean lazy) {
        if (null == prmOrderStatuss) {
            return null;
        }
        List<OrderStatus> orderStatuss = new ArrayList<>();
        for (PrmOrderStatus prmOrderStatus : prmOrderStatuss) {
            orderStatuss.add(toDto(prmOrderStatus, lazy));
        }
        return orderStatuss;
    }

    public static Set<PrmOrderStatus> toEntities(Set<OrderStatus> orderStatuss, boolean lazy) {
        if (null == orderStatuss) {
            return null;
        }
        Set<PrmOrderStatus> prmOrderStatuss = new HashSet<>();
        for (OrderStatus orderStatus : orderStatuss) {
            prmOrderStatuss.add(toEntity(orderStatus, lazy));
        }
        return prmOrderStatuss;
    }

    public static Set<OrderStatus> toDtos(Set<PrmOrderStatus> prmOrderStatuss, boolean lazy) {
        if (null == prmOrderStatuss) {
            return null;
        }
        Set<OrderStatus> orderStatuss = new HashSet<>();
        for (PrmOrderStatus prmOrderStatus : prmOrderStatuss) {
            orderStatuss.add(toDto(prmOrderStatus, lazy));
        }
        return orderStatuss;
    }
}

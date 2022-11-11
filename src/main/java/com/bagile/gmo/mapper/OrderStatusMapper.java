package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderStatus;
import com.bagile.gmo.entities.PrmOrderStatus;
import com.bagile.gmo.entities.TmsOrderTransport;
import com.bagile.gmo.entities.TmsOrderTransportInfo;
import com.bagile.gmo.util.EmsDate;

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
        map.put("devis","prmOrderStatusDevis");
        map.put("preparation","prmOrderStatusPreparation");
        map.put("purshaseOrder","prmOrderStatusPurshaseOrder");
        map.put("saleOrder","prmOrderStatusSaleOrder");
        map.put("delivery","prmOrderStatusDelivery");
        map.put("reception","prmOrderStatusReception");
        map.put("production","prmOrderStatusProduction");
        map.put("active","prmOrderStatusActive");

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
        prmOrderStatus.setPrmOrderStatusDelivery(orderStatus.getDelivery());
        prmOrderStatus.setPrmOrderStatusDevis(orderStatus.getDevis());
        prmOrderStatus.setPrmOrderStatusReception(orderStatus.getReception());
        prmOrderStatus.setPrmOrderStatusSaleOrder(orderStatus.getSaleOrder());
        prmOrderStatus.setPrmOrderStatusProduction(orderStatus.getProduction());
        prmOrderStatus.setPrmOrderStatusPreparation(orderStatus.getPreparation());
        prmOrderStatus.setPrmOrderStatusPurshaseOrder(orderStatus.getPurshaseOrder());
        prmOrderStatus.setUpdatedBy(orderStatus.getUpdatedBy());
        prmOrderStatus.setCreatedBy(prmOrderStatus.getCreatedBy());
        prmOrderStatus.setPrmOrderStatusActive(prmOrderStatus.getPrmOrderStatusActive());
        if (!lazy) {
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
        orderStatus.setDelivery(prmOrderStatus.getPrmOrderStatusDelivery());
        orderStatus.setDevis(prmOrderStatus.getPrmOrderStatusDevis());
        orderStatus.setReception(prmOrderStatus.getPrmOrderStatusReception());
        orderStatus.setSaleOrder(prmOrderStatus.getPrmOrderStatusSaleOrder());
        orderStatus.setProduction(prmOrderStatus.getPrmOrderStatusProduction());
        orderStatus.setPreparation(prmOrderStatus.getPrmOrderStatusPreparation());
        orderStatus.setPurshaseOrder(prmOrderStatus.getPrmOrderStatusPurshaseOrder());
        orderStatus.setUpdatedBy(prmOrderStatus.getUpdatedBy());
        orderStatus.setCreatedBy(prmOrderStatus.getCreatedBy());
        orderStatus.setActive(prmOrderStatus.getPrmOrderStatusActive());
        if (!lazy) {
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

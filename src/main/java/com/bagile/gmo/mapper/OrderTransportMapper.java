package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransport;
import com.bagile.gmo.entities.TmsOrderTransport;
import com.bagile.gmo.util.EmsDate;


import java.util.*;

public class  OrderTransportMapper {
    public OrderTransportMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderTransportId");
        map.put("vehicle", "tmsVehicle");
        map.put("account", "cmdAccount");

        map.put("transport", "trpTransport");
        map.put("turnType", "tmsOrderTransportType");
        map.put("turnStatus", "tmsTurnStatus");
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

    public static TmsOrderTransport toEntity(OrderTransport orderTransport, boolean lazy) {
        if (null == orderTransport) {
            return null;
        }
        TmsOrderTransport tmsOrderTransport = new TmsOrderTransport();
        tmsOrderTransport.setTmsOrderTransportId(orderTransport.getId());
        tmsOrderTransport.setTmsOrderTransportCode(orderTransport.getCode());
        tmsOrderTransport.setTmsOrderTransportDate(orderTransport.getDate());
        tmsOrderTransport.setTmsOrderTransportLoadingType(orderTransport.getLoadingType());
        tmsOrderTransport.setTmsOrderTransportPriceTTC(orderTransport.getPriceTTC());

        if (!lazy) {
            tmsOrderTransport.setCmdAccount(AccountMapper.toEntity(orderTransport.getAccount(), true));
            tmsOrderTransport.setTmsOrderTransportType(TurnTypeMapper.toEntity(orderTransport.getTurnType(), true));
            tmsOrderTransport.setTmsTurnStatus(TurnStatusMapper.toEntity(orderTransport.getTurnStatus(), true));
            tmsOrderTransport.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(orderTransport.getVehicleCategory(), true));

//           tmsOrderTransport.setTmsOrderTransportInfoAller(OrderTransportInfoMapper.toEntity(orderTransport.getOrderTransportInfoAller(), false));
         //  tmsOrderTransport.setTmsOrderTransportInfoRetour(OrderTransportInfoMapper.toEntity(orderTransport.getOrderTransportInfoRetour(), false));

        }
        return tmsOrderTransport;

    }




    public static OrderTransport toDto(TmsOrderTransport tmsOrderTransport, boolean lazy) {
        if (null == tmsOrderTransport) {
            return null;
        }
        OrderTransport orderTransport = new OrderTransport();
        orderTransport.setId( tmsOrderTransport.getTmsOrderTransportId());
        orderTransport.setDate(tmsOrderTransport.getTmsOrderTransportDate());
        orderTransport.setCode(tmsOrderTransport.getTmsOrderTransportCode());
        orderTransport.setLoadingType(tmsOrderTransport.getTmsOrderTransportLoadingType());
        orderTransport.setPriceTTC(tmsOrderTransport.getTmsOrderTransportPriceTTC());

        if (!lazy) {
            orderTransport.setTurnType(TurnTypeMapper.toDto(tmsOrderTransport.getTmsOrderTransportType(), true));
            orderTransport.setTurnStatus(TurnStatusMapper.toDto(tmsOrderTransport.getTmsTurnStatus(), true));
            orderTransport.setAccount(AccountMapper.toDto(tmsOrderTransport.getCmdAccount(), true));
            orderTransport.setVehicleCategory(VehicleCategoryMapper.toDto(tmsOrderTransport.getGmoVehicleCategory(), true));

          // orderTransport.setOrderTransportInfoAller(OrderTransportInfoMapper.toDto(tmsOrderTransport.getTmsOrderTransportInfoAller(), false));
           //orderTransport.setOrderTransportInfoRetour(OrderTransportInfoMapper.toDto(tmsOrderTransport.getTmsOrderTransportInfoRetour(), false));



        }
        return orderTransport;

    }



    public static List<OrderTransport> toDtos(Iterable<? extends TmsOrderTransport> tmsOrderTransports, boolean lazy) {
        if (null == tmsOrderTransports) {
            return null;
        }
        List<OrderTransport> turns = new ArrayList<>();
        for (TmsOrderTransport tmsOrderTransport : tmsOrderTransports) {
            turns.add(toDto(tmsOrderTransport, lazy));
        }
        return turns;
    }

    public static Set<TmsOrderTransport> toEntities(Set<? extends OrderTransport> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsOrderTransport> tmsOrderTransports = new HashSet<>();

        for (OrderTransport orderTransport : turns) {
            tmsOrderTransports.add(toEntity(orderTransport, lazy));
        }
        return tmsOrderTransports;
    }

    public static Set<OrderTransport> toDtos(Set<? extends TmsOrderTransport> tmsOrderTransports, boolean lazy) {
        if (null == tmsOrderTransports) {
            return null;
        }
        Set<OrderTransport> turns = new HashSet<>();
        for (TmsOrderTransport tmsOrderTransport : tmsOrderTransports) {
            turns.add(toDto(tmsOrderTransport, lazy));
        }
        return turns;
    }

}

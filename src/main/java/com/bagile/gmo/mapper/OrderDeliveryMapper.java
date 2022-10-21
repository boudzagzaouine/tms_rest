package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderDelivery;
import com.bagile.gmo.dto.OrderDeliveryTransport;
import com.bagile.gmo.entities.TmsDeliveryInfo;
import com.bagile.gmo.entities.TmsOrderDelivery;
import com.bagile.gmo.util.EmsDate;


import java.util.*;

public class OrderDeliveryMapper {
    public OrderDeliveryMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderDeliveryId");
        map.put("vehicle", "tmsVehicle");
        map.put("transport", "trpTransport");
        map.put("turnType", "tmsOrderDeliveryType");
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

    public static TmsOrderDelivery toEntity(OrderDelivery orderDelivery, boolean lazy) {
        if (null == orderDelivery) {
            return null;
        }
        TmsOrderDelivery tmsOrderDelivery = new TmsOrderDelivery();
        tmsOrderDelivery.setTmsOrderDeliveryId(orderDelivery.getId());
        tmsOrderDelivery.setTmsOrderDeliveryCode(orderDelivery.getCode());
        tmsOrderDelivery.setDateDelivery(orderDelivery.getDate());
        tmsOrderDelivery.setTmsOrderDeliveryLoadingType(orderDelivery.getLoadingType());

        if (!lazy) {
            tmsOrderDelivery.setCmdAccount(AccountMapper.toEntity(orderDelivery.getAccount(), false));
            tmsOrderDelivery.setTmsOrderDeliveryType(TurnTypeMapper.toEntity(orderDelivery.getTurnType(), false));
            tmsOrderDelivery.setTmsTurnStatus(TurnStatusMapper.toEntity(orderDelivery.getTurnStatus(), false));
            tmsOrderDelivery.setTmsDeliveryInfoAller(DeliveryInfoMapper.toEntity(orderDelivery.getDeliveryInfoAller(), false));
            tmsOrderDelivery.setTmsDeliveryInfoRetour(DeliveryInfoMapper.toEntity(orderDelivery.getDeliveryInfoRetour(), false));
            tmsOrderDelivery.setTmsOrderDeliveryTransports(OrderDeliveryTrasnportMapper.toEntities(orderDelivery.getOrderDeliveryTransport(), false));
   oneToMany(tmsOrderDelivery);
        }
        return tmsOrderDelivery;

    }
    private static void oneToMany(TmsOrderDelivery tmsOrderDelivery) {
        if(null !=tmsOrderDelivery.getTmsOrderDeliveryTransports()){
            tmsOrderDelivery.getTmsOrderDeliveryTransports().forEach(
                    tmsDelievrytransport -> {

                        if(0> tmsDelievrytransport.getTmsOrderDeliveryTransportId()){
                            tmsDelievrytransport.setCreationDate(EmsDate.getDateNow());
                            tmsDelievrytransport.setTmsOrderDeliveryTransportId(0L);
                        }

                        tmsDelievrytransport.setUpdateDate(EmsDate.getDateNow());
                        tmsDelievrytransport.setTmsOrderDelivery(tmsOrderDelivery);
                    }
            );
        }


    }

    public static OrderDelivery toDto(TmsOrderDelivery tmsOrderDelivery, boolean lazy) {
        if (null == tmsOrderDelivery) {
            return null;
        }
        OrderDelivery orderDelivery = new OrderDelivery();
        orderDelivery.setId( tmsOrderDelivery.getTmsOrderDeliveryId());
        orderDelivery.setDate(tmsOrderDelivery.getDateDelivery());
        orderDelivery.setCode(tmsOrderDelivery.getTmsOrderDeliveryCode());
        orderDelivery.setLoadingType(tmsOrderDelivery.getTmsOrderDeliveryLoadingType());

        if (!lazy) {
            orderDelivery.setTurnType(TurnTypeMapper.toDto(tmsOrderDelivery.getTmsOrderDeliveryType(), false));
            orderDelivery.setTurnStatus(TurnStatusMapper.toDto(tmsOrderDelivery.getTmsTurnStatus(), false));
            orderDelivery.setAccount(AccountMapper.toDto(tmsOrderDelivery.getCmdAccount(), false));

            orderDelivery.setDeliveryInfoAller(DeliveryInfoMapper.toDto(tmsOrderDelivery.getTmsDeliveryInfoAller(), false));
            orderDelivery.setDeliveryInfoRetour(DeliveryInfoMapper.toDto(tmsOrderDelivery.getTmsDeliveryInfoRetour(), false));

            orderDelivery.setOrderDeliveryTransport(OrderDeliveryTrasnportMapper.toDtos(tmsOrderDelivery.getTmsOrderDeliveryTransports(), false));


        }
        return orderDelivery;

    }



    public static List<OrderDelivery> toDtos(Iterable<? extends TmsOrderDelivery> tmsOrderDeliverys, boolean lazy) {
        if (null == tmsOrderDeliverys) {
            return null;
        }
        List<OrderDelivery> turns = new ArrayList<>();
        for (TmsOrderDelivery tmsOrderDelivery : tmsOrderDeliverys) {
            turns.add(toDto(tmsOrderDelivery, lazy));
        }
        return turns;
    }

    public static Set<TmsOrderDelivery> toEntities(Set<? extends OrderDelivery> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsOrderDelivery> tmsOrderDeliverys = new HashSet<>();

        for (OrderDelivery orderDelivery : turns) {
            tmsOrderDeliverys.add(toEntity(orderDelivery, lazy));
        }
        return tmsOrderDeliverys;
    }

    public static Set<OrderDelivery> toDtos(Set<? extends TmsOrderDelivery> tmsOrderDeliverys, boolean lazy) {
        if (null == tmsOrderDeliverys) {
            return null;
        }
        Set<OrderDelivery> turns = new HashSet<>();
        for (TmsOrderDelivery tmsOrderDelivery : tmsOrderDeliverys) {
            turns.add(toDto(tmsOrderDelivery, lazy));
        }
        return turns;
    }

}

package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransportAccompaniment;
import com.bagile.gmo.entities.TmsOrderTransportAccompaniment;

import java.util.*;

public class OrderTransportAccompanimentMapper {
    public OrderTransportAccompanimentMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoNotificationId");
        map.put ("code", "gmoNotificationCode");
        map.put ("email", "gmoNotificationEmail");

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

    public static TmsOrderTransportAccompaniment toEntity(OrderTransportAccompaniment orderTransportAccompaniment, boolean lazy) {
        if (null == orderTransportAccompaniment) {
            return null;
        }

        TmsOrderTransportAccompaniment tmsOrderTransportAccompaniment = new TmsOrderTransportAccompaniment ( );
        tmsOrderTransportAccompaniment.setTmsOrderTransportAccompanimentId (orderTransportAccompaniment.getId ( ));

        tmsOrderTransportAccompaniment.setCreatedBy (orderTransportAccompaniment.getCreatedBy ( ));
        tmsOrderTransportAccompaniment.setUpdatedBy (orderTransportAccompaniment.getUpdatedBy ( ));

        if (!lazy) {
            tmsOrderTransportAccompaniment.setOwnOwner(OwnerMapper.toEntity(orderTransportAccompaniment.getOwner(), true));
            tmsOrderTransportAccompaniment.setTmsVehicleAccompaniment(VehicleAccompanimentMapper.toEntity(orderTransportAccompaniment.getVehicleAccompaniment(), true));
            tmsOrderTransportAccompaniment.setTmsOrderTransport(OrderTransportMapper.toEntity(orderTransportAccompaniment.getOrderTransport(), true));

        }
       
            return tmsOrderTransportAccompaniment;

    }

    public static OrderTransportAccompaniment toDto(TmsOrderTransportAccompaniment tmsOrderTransportAccompaniment, boolean lazy) {
        if (null == tmsOrderTransportAccompaniment) {
            return null;
        }
        OrderTransportAccompaniment orderTransportAccompaniment = new OrderTransportAccompaniment ( );
        orderTransportAccompaniment.setId (tmsOrderTransportAccompaniment.getTmsOrderTransportAccompanimentId ());

        orderTransportAccompaniment.setCreatedBy (tmsOrderTransportAccompaniment.getCreatedBy ());
        orderTransportAccompaniment.setUpdatedBy (tmsOrderTransportAccompaniment.getUpdatedBy ());
        orderTransportAccompaniment.setCreationDate (tmsOrderTransportAccompaniment.getCreationDate ());
        orderTransportAccompaniment.setUpdateDate (tmsOrderTransportAccompaniment.getUpdateDate ());


        if (!lazy) {
            orderTransportAccompaniment.setOwner(OwnerMapper.toDto(tmsOrderTransportAccompaniment.getOwnOwner(), true));
            orderTransportAccompaniment.setOrderTransport(OrderTransportMapper.toDto(tmsOrderTransportAccompaniment.getTmsOrderTransport(), true));
            orderTransportAccompaniment.setVehicleAccompaniment(VehicleAccompanimentMapper.toDto(tmsOrderTransportAccompaniment.getTmsVehicleAccompaniment(), true));

        }
        return orderTransportAccompaniment;

    }


    public static List<OrderTransportAccompaniment> toDtos(Iterable<? extends TmsOrderTransportAccompaniment> tmsOrderTransportAccompaniments, boolean lazy) {
        if (null == tmsOrderTransportAccompaniments) {
            return null;
        }
        List<OrderTransportAccompaniment> orderTransportAccompaniments = new ArrayList<> ( );

        for (TmsOrderTransportAccompaniment tmsOrderTransportAccompaniment : tmsOrderTransportAccompaniments) {
            orderTransportAccompaniments.add (toDto (tmsOrderTransportAccompaniment, lazy));
        }
        return orderTransportAccompaniments;
    }

    public static Set<TmsOrderTransportAccompaniment> toEntities(List<OrderTransportAccompaniment> orderTransportAccompaniments, boolean lazy) {
        if (null == orderTransportAccompaniments) {
            return null;
        }
        Set<TmsOrderTransportAccompaniment> tmsOrderTransportAccompaniments = new HashSet<> ( );
        for (OrderTransportAccompaniment orderTransportAccompaniment : orderTransportAccompaniments) {
            tmsOrderTransportAccompaniments.add (toEntity (orderTransportAccompaniment, lazy));
        }
        return tmsOrderTransportAccompaniments;
    }

    public static List<OrderTransportAccompaniment> toDtos(Set<TmsOrderTransportAccompaniment> tmsOrderTransportAccompaniments, boolean lazy) {
        if (null == tmsOrderTransportAccompaniments) {
            return null;
        }
        List<OrderTransportAccompaniment> orderTransportAccompaniments = new ArrayList<> ( );
        for (TmsOrderTransportAccompaniment tmsOrderTransportAccompaniment : tmsOrderTransportAccompaniments) {
            orderTransportAccompaniments.add (toDto (tmsOrderTransportAccompaniment, lazy));
        }
        return orderTransportAccompaniments;
    }
}

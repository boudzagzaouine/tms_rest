/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderDelivery;
import com.bagile.gmo.dto.OrderDeliveryTransport;
import com.bagile.gmo.entities.TmsOrderDeliveryTransport;

import java.util.*;

public class OrderDeliveryTrasnportMapper {
    private OrderDeliveryTrasnportMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderDeliveryTransporteId");
       



    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static OrderDeliveryTransport toDto(TmsOrderDeliveryTransport tmsOrderDeliveryTransport, boolean lazy) {
        if (null == tmsOrderDeliveryTransport) {
            return null;
        }
        OrderDeliveryTransport orderDeliveryTransport = new OrderDeliveryTransport();
        orderDeliveryTransport.setId(tmsOrderDeliveryTransport.getTmsOrderDeliveryTransportId());
        orderDeliveryTransport.setNumberOfPalette(tmsOrderDeliveryTransport.getTmsOrderDeliveryTransportNumberOfPalette());



        orderDeliveryTransport.setUpdatedBy(tmsOrderDeliveryTransport.getUpdatedBy());
        orderDeliveryTransport.setCreatedBy(tmsOrderDeliveryTransport.getCreatedBy());
        if (!lazy) {

          //  orderDeliveryTransport.setOwner(OwnerMapper.toDto(tmsOrderDeliveryTransport.getOwnOwner(), true));
         orderDeliveryTransport.setVehicle(VehicleMapper.toDto(tmsOrderDeliveryTransport.getGmoVehicle(), false));
            orderDeliveryTransport.setVehicleCategory(VehicleCategoryMapper.toDto(tmsOrderDeliveryTransport.getGmoVehicleCategory(), true));

            orderDeliveryTransport.setTransport(TransportMapper.toDto(tmsOrderDeliveryTransport.getTrpTransport(), false));
            orderDeliveryTransport.setDrivers(DriverMapper.toDtos(tmsOrderDeliveryTransport.getGmoDrivers(), false));
            orderDeliveryTransport.setOrderDelivery(OrderDeliveryMapper.toDto(tmsOrderDeliveryTransport.getTmsOrderDelivery(), true));

        }
        return orderDeliveryTransport;
    }

    public static TmsOrderDeliveryTransport toEntity(OrderDeliveryTransport orderDeliveryTransport, boolean lazy) {
        if (null == orderDeliveryTransport) {
            return null;
        }
       TmsOrderDeliveryTransport tmsOrderDeliveryTransport = new TmsOrderDeliveryTransport();
        tmsOrderDeliveryTransport.setTmsOrderDeliveryTransportId(orderDeliveryTransport.getId());
        tmsOrderDeliveryTransport.setTmsOrderDeliveryTransportNumberOfPalette(orderDeliveryTransport.getNumberOfPalette());

        tmsOrderDeliveryTransport.setUpdatedBy(orderDeliveryTransport.getUpdatedBy());
        tmsOrderDeliveryTransport.setCreatedBy(orderDeliveryTransport.getCreatedBy());
        if (!lazy) {
             tmsOrderDeliveryTransport.setGmoVehicle(VehicleMapper.toEntity(orderDeliveryTransport.getVehicle(), true));
            tmsOrderDeliveryTransport.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(orderDeliveryTransport.getVehicleCategory(), false));
            tmsOrderDeliveryTransport.setTrpTransport(TransportMapper.toEntity(orderDeliveryTransport.getTransport(), true));
            tmsOrderDeliveryTransport.setGmoDrivers(DriverMapper.toEntities(orderDeliveryTransport.getDrivers(), true));
            tmsOrderDeliveryTransport.setTmsOrderDelivery(OrderDeliveryMapper.toEntity(orderDeliveryTransport.getOrderDelivery(), true));


        }
        return tmsOrderDeliveryTransport;
    }

    public static List<OrderDeliveryTransport> toDtos(List<TmsOrderDeliveryTransport> tmsOrderDeliveryTransports, boolean lazy) {
        if (null == tmsOrderDeliveryTransports) {
            return null;
        }
        List<OrderDeliveryTransport> orderDeliveryTransports = new ArrayList<>();
        for (TmsOrderDeliveryTransport tmsOrderDeliveryTransport : tmsOrderDeliveryTransports) {
            orderDeliveryTransports.add(toDto(tmsOrderDeliveryTransport, lazy));
        }
        return orderDeliveryTransports;
    }

    public static List<OrderDeliveryTransport> toDtos(Iterable< ? extends TmsOrderDeliveryTransport> tmsOrderDeliveryTransports, boolean lazy) {
        if (null == tmsOrderDeliveryTransports) {
            return null;
        }
        List<OrderDeliveryTransport> orderDeliveryTransports = new ArrayList<>();
        for (TmsOrderDeliveryTransport tmsOrderDeliveryTransport : tmsOrderDeliveryTransports) {
            orderDeliveryTransports.add(toDto(tmsOrderDeliveryTransport, lazy));
        }
        return orderDeliveryTransports;
    }


    public static Set<TmsOrderDeliveryTransport> toEntities(List<OrderDeliveryTransport> orderDeliveryTransports, boolean lazy) {
        if (null == orderDeliveryTransports) {
            return null;
        }
        Set<TmsOrderDeliveryTransport> tmsOrderDeliveryTransports = new HashSet<>();
        for (OrderDeliveryTransport orderDeliveryTransport : orderDeliveryTransports) {
            tmsOrderDeliveryTransports.add(toEntity(orderDeliveryTransport, lazy));
        }
        return tmsOrderDeliveryTransports;
    }

    /*public static Set<OrderDeliveryTransport> toDtos(Set<GmoOrderDeliveryTransport> tmsOrderDeliveryTransports, boolean lazy) {
        if (null == tmsOrderDeliveryTransports) {
            return null;
        }
        Set<OrderDeliveryTransport> orderDeliveryTransports = new HashSet<>();
        for (GmoOrderDeliveryTransport tmsOrderDeliveryTransport : tmsOrderDeliveryTransports) {
            orderDeliveryTransports.add(toDto(tmsOrderDeliveryTransport, lazy));
        }
        return orderDeliveryTransports;
    }*/



}

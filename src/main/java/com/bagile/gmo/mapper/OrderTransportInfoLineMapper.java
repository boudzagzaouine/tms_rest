package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransportInfoLine;
import com.bagile.gmo.entities.TmsOrderTransportInfoLine;

import java.util.*;

public class OrderTransportInfoLineMapper {
    public OrderTransportInfoLineMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderTransportInfoLineId");
        map.put("orderTransportInfo", "tmsOrderTransportInfo");

        map.put("vehicle", "tmsVehicle");
        map.put("transport", "trpTransport");
        map.put("dateDelivery", "dateDelivery");
        map.put("turnLines", "tmsOrderTransportInfoLineLines");

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

    public static TmsOrderTransportInfoLine toEntity(OrderTransportInfoLine orderTransportInfoLine, boolean lazy) {
        if (null == orderTransportInfoLine) {
            return null;
        }
        TmsOrderTransportInfoLine tmsOrderTransportInfoLine = new TmsOrderTransportInfoLine();
        tmsOrderTransportInfoLine.setTmsOrderTransportInfoLineId(orderTransportInfoLine.getId());

        tmsOrderTransportInfoLine.setTmsAddressContactDeliveryInfoNumberOfPalletEnlevement(orderTransportInfoLine.getNumberOfPalletEnlevement());
        tmsOrderTransportInfoLine.setTmsOrderTransportWeightEnlevement(orderTransportInfoLine.getWeightEnlevement());
        tmsOrderTransportInfoLine.setTmsOrderTransportCapacityEnlevement(orderTransportInfoLine.getCapacityEnlevement());
        tmsOrderTransportInfoLine.setTmsOrderTransportCommentEnlevement(orderTransportInfoLine.getCommentEnlevement());

        tmsOrderTransportInfoLine.setTmsAddressContactDeliveryInfoNumberOfPalletLivraison(orderTransportInfoLine.getNumberOfPalletLivraison());
        tmsOrderTransportInfoLine.setTmsOrderTransportWeightLivraison(orderTransportInfoLine.getWeightLivraison());
        tmsOrderTransportInfoLine.setTmsOrderTransportCapacityLivraison(orderTransportInfoLine.getCapacityLivraison());
        tmsOrderTransportInfoLine.setTmsOrderTransportCommentLivraison(orderTransportInfoLine.getCommentLivraison());

        tmsOrderTransportInfoLine.setTmsOrderTransportLineNumber(orderTransportInfoLine.getLineNumber());



        if (!lazy) {


            tmsOrderTransportInfoLine.setTmsAddressContactDeliveryInfo(AddressContactOrderTransportInfoMapper.toEntity(orderTransportInfoLine.getAddressContactDeliveryInfo(), true));
            tmsOrderTransportInfoLine.setTmsOrderTransportType(OrderTransportTypeMapper.toEntity(orderTransportInfoLine.getOrderTransportType(), true));
            tmsOrderTransportInfoLine.setTmsOrderTransportInfo(OrderTransportInfoMapper.toEntity(orderTransportInfoLine.getOrderTransportInfo(), true));




// oneToMany(tmsOrderTransportInfoLine);

        }
        return tmsOrderTransportInfoLine;

    }

    private static void oneToMany(TmsOrderTransportInfoLine tmsOrderTransportInfoLine) {
//        if(null !=tmsOrderTransportInfoLine.getTmsPackageDetails()){
//            tmsOrderTransportInfoLine.getTmsPackageDetails().forEach(
//                    tmsPackageDetail -> {
//
//                        if(0> tmsPackageDetail.getTmsPackageDetailId()){
//                            tmsPackageDetail.setCreationDate(EmsDate.getDateNow());
//                            tmsPackageDetail.setTmsPackageDetailId(0L);
//                        }
//
//                        tmsPackageDetail.setUpdateDate(EmsDate.getDateNow());
//                        tmsPackageDetail.setTmsOrderTransport(tmsOrderTransportInfoLine);
//                    }
//            );
//        }


    }

    public static OrderTransportInfoLine toDto(TmsOrderTransportInfoLine tmsOrderTransportInfoLine, boolean lazy) {
        if (null == tmsOrderTransportInfoLine) {
            return null;
        }
        OrderTransportInfoLine orderTransportInfoLine = new OrderTransportInfoLine();
        orderTransportInfoLine.setId( tmsOrderTransportInfoLine.getTmsOrderTransportInfoLineId());

        orderTransportInfoLine.setNumberOfPalletEnlevement(tmsOrderTransportInfoLine.getTmsAddressContactDeliveryInfoNumberOfPalletEnlevement());
        orderTransportInfoLine.setWeightEnlevement(tmsOrderTransportInfoLine.getTmsOrderTransportWeightEnlevement());
        orderTransportInfoLine.setCapacityEnlevement(tmsOrderTransportInfoLine.getTmsOrderTransportCapacityEnlevement());
       orderTransportInfoLine.setCommentEnlevement(tmsOrderTransportInfoLine.getTmsOrderTransportCommentEnlevement());

        orderTransportInfoLine.setNumberOfPalletLivraison(tmsOrderTransportInfoLine.getTmsAddressContactDeliveryInfoNumberOfPalletLivraison());
        orderTransportInfoLine.setWeightLivraison(tmsOrderTransportInfoLine.getTmsOrderTransportWeightLivraison());
        orderTransportInfoLine.setCapacityLivraison(tmsOrderTransportInfoLine.getTmsOrderTransportCapacityLivraison());
        orderTransportInfoLine.setCommentLivraison(tmsOrderTransportInfoLine.getTmsOrderTransportCommentLivraison());

        orderTransportInfoLine.setLineNumber(tmsOrderTransportInfoLine.getTmsOrderTransportLineNumber());


        if (!lazy) {

            orderTransportInfoLine.setAddressContactDeliveryInfo(AddressContactOrderTransportInfoMapper.toDto(tmsOrderTransportInfoLine.getTmsAddressContactDeliveryInfo(), true));

            orderTransportInfoLine.setOrderTransportType(OrderTransportTypeMapper.toDto(tmsOrderTransportInfoLine.getTmsOrderTransportType(), true));

            orderTransportInfoLine.setOrderTransportInfo(OrderTransportInfoMapper.toDto(tmsOrderTransportInfoLine.getTmsOrderTransportInfo(), true));

        }
        return orderTransportInfoLine;

    }


    public static List<OrderTransportInfoLine> toDtos(Iterable<? extends TmsOrderTransportInfoLine> tmsOrderTransportInfoLines, boolean lazy) {
        if (null == tmsOrderTransportInfoLines) {
            return null;
        }
        List<OrderTransportInfoLine> turns = new ArrayList<>();
        for (TmsOrderTransportInfoLine tmsOrderTransportInfoLine : tmsOrderTransportInfoLines) {
            turns.add(toDto(tmsOrderTransportInfoLine, lazy));
        }
        return turns;
    }

    public static Set<TmsOrderTransportInfoLine> toEntities(List< OrderTransportInfoLine> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsOrderTransportInfoLine> tmsOrderTransportInfoLines = new HashSet<>();

        for (OrderTransportInfoLine orderTransportInfoLine : turns) {
            tmsOrderTransportInfoLines.add(toEntity(orderTransportInfoLine, lazy));
        }
        return tmsOrderTransportInfoLines;
    }

    public static List<OrderTransportInfoLine> toDtos(List< TmsOrderTransportInfoLine> tmsOrderTransportInfoLines, boolean lazy) {
        if (null == tmsOrderTransportInfoLines) {
            return null;
        }
        List<OrderTransportInfoLine> turns = new ArrayList<>();
        for (TmsOrderTransportInfoLine tmsOrderTransportInfoLine : tmsOrderTransportInfoLines) {
            turns.add(toDto(tmsOrderTransportInfoLine, lazy));
        }
        return turns;
    }



}

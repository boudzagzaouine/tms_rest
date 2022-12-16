package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransportInfo;
import com.bagile.gmo.entities.TmsOrderTransportInfo;
import com.bagile.gmo.util.EmsDate;

import java.util.*;

public class OrderTransportInfoMapper {
    public OrderTransportInfoMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderTransportInfoId");
        map.put("type", "tmsOrderTransportInfoType");

        map.put("vehicle", "tmsVehicle");
        map.put("transport", "trpTransport");
        map.put("dateDelivery", "dateDelivery");
        map.put("orderTransport", "tmsOrderTransport");
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

    public static TmsOrderTransportInfo toEntity(OrderTransportInfo orderTransportInfo, boolean lazy) {
        if (null == orderTransportInfo) {
            return null;
        }
        TmsOrderTransportInfo tmsOrderTransportInfo = new TmsOrderTransportInfo();
        tmsOrderTransportInfo.setTmsOrderTransportInfoId(orderTransportInfo.getId());


        tmsOrderTransportInfo.setTmsOrderTransportInfoWeight(orderTransportInfo.getWeightTotal());
        tmsOrderTransportInfo.setTmsOrderTransportInfoCapacity(orderTransportInfo.getCapacityTotal());
        tmsOrderTransportInfo.setTmsOrderTransportInfoPriceTTC(orderTransportInfo.getPriceTTC());

        tmsOrderTransportInfo.setTmsOrderTransportInfoType(orderTransportInfo.getType());
        tmsOrderTransportInfo.setTmsOrderTransportInfoTrajetUnique(orderTransportInfo.getTrajetUnique());
        tmsOrderTransportInfo.setTmsOrderTransportInfoNumberOfPallet(orderTransportInfo.getNumberOfPallet());
        tmsOrderTransportInfo.setTmsOrderTransportInfoDate(orderTransportInfo.getDate());

        tmsOrderTransportInfo.setNumberKm(orderTransportInfo.getNumberKm());
        tmsOrderTransportInfo.setTime(orderTransportInfo.getTime());

        tmsOrderTransportInfo.setTmsOrderTransportNumberKmRetour(orderTransportInfo.getNumberKmRetour());
        tmsOrderTransportInfo.setTmsOrderTransportTimeRetour(orderTransportInfo.getTimeRetour());


        if (!lazy) {


            tmsOrderTransportInfo.setTmsPackageDetails(PackageDetailMapper.toEntities(orderTransportInfo.getPackageDetails(), false));
            tmsOrderTransportInfo.setTmsAddressContactOrderTransportInitial(AddressContactOrderTransportInfoMapper.toEntity(orderTransportInfo.getAddressContactInitial(), true));
            tmsOrderTransportInfo.setTmsAddressContactOrderTransportFinal(AddressContactOrderTransportInfoMapper.toEntity(orderTransportInfo.getAddressContactFinal(), true));
            tmsOrderTransportInfo.setTmsOrderTransportInfoPackagingType(PackagingTypeMapper.toEntity(orderTransportInfo.getPackagingType(), true));
            tmsOrderTransportInfo.setTmsOrderTransportInfoLines(OrderTransportInfoLineMapper.toEntities(orderTransportInfo.getOrderTransportInfoLines(), false));
            tmsOrderTransportInfo.setTmsOrderTransport(OrderTransportMapper.toEntity(orderTransportInfo.getOrderTransport(), true));
            tmsOrderTransportInfo.setTmsTurnStatus(TurnStatusMapper.toEntity(orderTransportInfo.getTurnStatus(), true));

            tmsOrderTransportInfo.setPrmVilleSource(VilleMapper.toEntity(orderTransportInfo.getVilleSource(), true));
            tmsOrderTransportInfo.setPrmVilleDistination(VilleMapper.toEntity(orderTransportInfo.getVilleDistination(), true));



            oneToMany(tmsOrderTransportInfo);

        }
        return tmsOrderTransportInfo;

    }

    private static void oneToMany(TmsOrderTransportInfo tmsOrderTransportInfo) {
        if(null !=tmsOrderTransportInfo.getTmsPackageDetails()){
            tmsOrderTransportInfo.getTmsPackageDetails().forEach(
                    tmsPackageDetail -> {

                        if(0> tmsPackageDetail.getTmsPackageDetailId()){
                            tmsPackageDetail.setCreationDate(EmsDate.getDateNow());
                            tmsPackageDetail.setTmsPackageDetailId(0L);
                        }

                        tmsPackageDetail.setUpdateDate(EmsDate.getDateNow());
                        tmsPackageDetail.setTmsOrderTransportInfo(tmsOrderTransportInfo);
                    }
            );
        }


        if(null !=tmsOrderTransportInfo.getTmsOrderTransportInfoLines()){
            tmsOrderTransportInfo.getTmsOrderTransportInfoLines().forEach(
                    tmsPackageLigne -> {

                        if(0> tmsPackageLigne.getTmsOrderTransportInfoLineId()){
                            tmsPackageLigne.setCreationDate(EmsDate.getDateNow());
                            tmsPackageLigne.setTmsOrderTransportInfoLineId(0L);
                        }

                        tmsPackageLigne.setUpdateDate(EmsDate.getDateNow());
                        tmsPackageLigne.setTmsOrderTransportInfo(tmsOrderTransportInfo);
                    }
            );
        }


    }

    public static OrderTransportInfo toDto(TmsOrderTransportInfo tmsOrderTransportInfo, boolean lazy) {
        if (null == tmsOrderTransportInfo) {
            return null;
        }
        OrderTransportInfo orderTransportInfo = new OrderTransportInfo();
        orderTransportInfo.setId( tmsOrderTransportInfo.getTmsOrderTransportInfoId());


        orderTransportInfo.setWeightTotal(tmsOrderTransportInfo.getTmsOrderTransportInfoWeight());
        orderTransportInfo.setCapacityTotal(tmsOrderTransportInfo.getTmsOrderTransportInfoCapacity());
       orderTransportInfo.setPriceTTC(tmsOrderTransportInfo.getTmsOrderTransportInfoPriceTTC());

        orderTransportInfo.setType(tmsOrderTransportInfo.getTmsOrderTransportInfoType());

        orderTransportInfo.setTrajetUnique(tmsOrderTransportInfo.getTmsOrderTransportInfoTrajetUnique());
        orderTransportInfo.setNumberOfPallet(tmsOrderTransportInfo.getTmsOrderTransportInfoNumberOfPallet());
        orderTransportInfo.setDate(tmsOrderTransportInfo.getTmsOrderTransportInfoDate());

        orderTransportInfo.setNumberKm(tmsOrderTransportInfo.getNumberKm());
        orderTransportInfo.setTime(tmsOrderTransportInfo.getTime());

        orderTransportInfo.setNumberKmRetour(tmsOrderTransportInfo.getTmsOrderTransportNumberKmRetour());
        orderTransportInfo.setTimeRetour(tmsOrderTransportInfo.getTmsOrderTransportTimeRetour());

        if (!lazy) {

            orderTransportInfo.setPackageDetails(PackageDetailMapper.toDtos(tmsOrderTransportInfo.getTmsPackageDetails(), false));
            orderTransportInfo.setAddressContactInitial(AddressContactOrderTransportInfoMapper.toDto(tmsOrderTransportInfo.getTmsAddressContactOrderTransportInitial(), true));
            orderTransportInfo.setAddressContactFinal(AddressContactOrderTransportInfoMapper.toDto(tmsOrderTransportInfo.getTmsAddressContactOrderTransportFinal(), true));

            orderTransportInfo.setPackagingType(PackagingTypeMapper.toDto(tmsOrderTransportInfo.getTmsOrderTransportInfoPackagingType(), true));
            orderTransportInfo.setOrderTransportInfoLines(OrderTransportInfoLineMapper.toDtos(tmsOrderTransportInfo.getTmsOrderTransportInfoLines(), false));
            orderTransportInfo.setTurnStatus(TurnStatusMapper.toDto(tmsOrderTransportInfo.getTmsTurnStatus(), true));

            orderTransportInfo.setOrderTransport(OrderTransportMapper.toDto(tmsOrderTransportInfo.getTmsOrderTransport(), true));
            orderTransportInfo.setVilleSource(VilleMapper.toDto(tmsOrderTransportInfo.getPrmVilleSource(), true));
            orderTransportInfo.setVilleDistination(VilleMapper.toDto(tmsOrderTransportInfo.getPrmVilleDistination(), true));


        }
        return orderTransportInfo;

    }


    public static List<OrderTransportInfo> toDtos(Iterable<? extends TmsOrderTransportInfo> tmsOrderTransportInfos, boolean lazy) {
        if (null == tmsOrderTransportInfos) {
            return null;
        }
        List<OrderTransportInfo> turns = new ArrayList<>();
        for (TmsOrderTransportInfo tmsOrderTransportInfo : tmsOrderTransportInfos) {
            turns.add(toDto(tmsOrderTransportInfo, lazy));
        }
        return turns;
    }

    public static Set<TmsOrderTransportInfo> toEntities(Set<? extends OrderTransportInfo> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsOrderTransportInfo> tmsOrderTransportInfos = new HashSet<>();

        for (OrderTransportInfo orderTransportInfo : turns) {
            tmsOrderTransportInfos.add(toEntity(orderTransportInfo, lazy));
        }
        return tmsOrderTransportInfos;
    }

    public static Set<OrderTransportInfo> toDtos(Set<? extends TmsOrderTransportInfo> tmsOrderTransportInfos, boolean lazy) {
        if (null == tmsOrderTransportInfos) {
            return null;
        }
        Set<OrderTransportInfo> turns = new HashSet<>();
        for (TmsOrderTransportInfo tmsOrderTransportInfo : tmsOrderTransportInfos) {
            turns.add(toDto(tmsOrderTransportInfo, lazy));
        }
        return turns;
    }

}

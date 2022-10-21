package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.DeliveryInfo;
import com.bagile.gmo.entities.TmsDeliveryInfo;
import com.bagile.gmo.util.EmsDate;

import java.util.*;

public class DeliveryInfoMapper {
    public DeliveryInfoMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsDeliveryInfoId");
        map.put("vehicle", "tmsVehicle");
        map.put("transport", "trpTransport");
        map.put("dateDelivery", "dateDelivery");
        map.put("turnLines", "tmsDeliveryInfoLines");

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

    public static TmsDeliveryInfo toEntity(DeliveryInfo deliveryInfo, boolean lazy) {
        if (null == deliveryInfo) {
            return null;
        }
        TmsDeliveryInfo tmsDeliveryInfo = new TmsDeliveryInfo();
        tmsDeliveryInfo.setTmsDeliveryInfoId(deliveryInfo.getId());


        tmsDeliveryInfo.setTmsDeliveryInfoWeightTotal(deliveryInfo.getWeightTotal());
        tmsDeliveryInfo.setTmsDeliveryInfoCapacityTotal(deliveryInfo.getCapacityTotal());
       tmsDeliveryInfo.setTmsDeliveryInfoPriceTTC(deliveryInfo.getPriceTTC());




        if (!lazy) {


            tmsDeliveryInfo.setTmsPackageDetails(PackageDetailMapper.toEntities(deliveryInfo.getPackageDetails(), false));
            tmsDeliveryInfo.setAddressContactDeliveryInfoSource(AddressContactDeliveryInfoMapper.toEntity(deliveryInfo.getContactDeliveryInfoSource(), false));
            tmsDeliveryInfo.setAddressContactDeliveryInfoDistination(AddressContactDeliveryInfoMapper.toEntity(deliveryInfo.getContactDeliveryInfoDistination(), false));
            tmsDeliveryInfo.setTmsDeliveryInfoPackagingType(PackagingTypeMapper.toEntity(deliveryInfo.getPackagingType(), false));




 oneToMany(tmsDeliveryInfo);

        }
        return tmsDeliveryInfo;

    }

    private static void oneToMany(TmsDeliveryInfo tmsDeliveryInfo) {
        if(null !=tmsDeliveryInfo.getTmsPackageDetails()){
            tmsDeliveryInfo.getTmsPackageDetails().forEach(
                    tmsPackageDetail -> {

                        if(0> tmsPackageDetail.getTmsPackageDetailId()){
                            tmsPackageDetail.setCreationDate(EmsDate.getDateNow());
                            tmsPackageDetail.setTmsPackageDetailId(0L);
                        }

                        tmsPackageDetail.setUpdateDate(EmsDate.getDateNow());
                        tmsPackageDetail.setTmsDeliveryInfo(tmsDeliveryInfo);
                    }
            );
        }


    }

    public static DeliveryInfo toDto(TmsDeliveryInfo tmsDeliveryInfo, boolean lazy) {
        if (null == tmsDeliveryInfo) {
            return null;
        }
        DeliveryInfo deliveryInfo = new DeliveryInfo();
        deliveryInfo.setId( tmsDeliveryInfo.getTmsDeliveryInfoId());


        deliveryInfo.setWeightTotal(tmsDeliveryInfo.getTmsDeliveryInfoWeightTotal());
        deliveryInfo.setCapacityTotal(tmsDeliveryInfo.getTmsDeliveryInfoCapacityTotal());
       deliveryInfo.setPriceTTC(tmsDeliveryInfo.getTmsDeliveryInfoPriceTTC());



        if (!lazy) {

            deliveryInfo.setPackageDetails(PackageDetailMapper.toDtos(tmsDeliveryInfo.getTmsPackageDetails(), false));
            deliveryInfo.setContactDeliveryInfoSource(AddressContactDeliveryInfoMapper.toDto(tmsDeliveryInfo.getAddressContactDeliveryInfoSource(), false));
            deliveryInfo.setContactDeliveryInfoDistination(AddressContactDeliveryInfoMapper.toDto(tmsDeliveryInfo.getAddressContactDeliveryInfoDistination(), false));

            deliveryInfo.setPackagingType(PackagingTypeMapper.toDto(tmsDeliveryInfo.getTmsDeliveryInfoPackagingType(), false));


        }
        return deliveryInfo;

    }


    public static List<DeliveryInfo> toDtos(Iterable<? extends TmsDeliveryInfo> tmsDeliveryInfos, boolean lazy) {
        if (null == tmsDeliveryInfos) {
            return null;
        }
        List<DeliveryInfo> turns = new ArrayList<>();
        for (TmsDeliveryInfo tmsDeliveryInfo : tmsDeliveryInfos) {
            turns.add(toDto(tmsDeliveryInfo, lazy));
        }
        return turns;
    }

    public static Set<TmsDeliveryInfo> toEntities(Set<? extends DeliveryInfo> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsDeliveryInfo> tmsDeliveryInfos = new HashSet<>();

        for (DeliveryInfo deliveryInfo : turns) {
            tmsDeliveryInfos.add(toEntity(deliveryInfo, lazy));
        }
        return tmsDeliveryInfos;
    }

    public static Set<DeliveryInfo> toDtos(Set<? extends TmsDeliveryInfo> tmsDeliveryInfos, boolean lazy) {
        if (null == tmsDeliveryInfos) {
            return null;
        }
        Set<DeliveryInfo> turns = new HashSet<>();
        for (TmsDeliveryInfo tmsDeliveryInfo : tmsDeliveryInfos) {
            turns.add(toDto(tmsDeliveryInfo, lazy));
        }
        return turns;
    }

}

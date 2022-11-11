package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.AddressContactOrderTransportInfo;
import com.bagile.gmo.entities.TmsAddressContactOrderTransportInfo;

import java.util.*;

public class AddressContactOrderTransportInfoMapper {
    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static AddressContactOrderTransportInfo toDto(TmsAddressContactOrderTransportInfo tmsAddress, boolean lazy) {
        if (null == tmsAddress) {
            return null;
        }
        AddressContactOrderTransportInfo addressContactDeliveryInfo = new AddressContactOrderTransportInfo();

        addressContactDeliveryInfo.setName(tmsAddress.getTmsAddressContactOrderTransportName());
        addressContactDeliveryInfo.setTel1(tmsAddress.getTmsAddressContactOrderTransportTel1());
        addressContactDeliveryInfo.setEmail(tmsAddress.getTmsAddressContactOrderTransportEmail());
        addressContactDeliveryInfo.setCompany(tmsAddress.getTmsAddressContactOrderTransportCompany());

        addressContactDeliveryInfo.setLine1(tmsAddress.getTmsAddressContactOrderTransportLine1());
        addressContactDeliveryInfo.setCity(tmsAddress.getTmsAddressContactOrderTransportCity());
        addressContactDeliveryInfo.setZip(tmsAddress.getTmsAddressContactOrderTransportZip());
        addressContactDeliveryInfo.setCountry(tmsAddress.getTmsAddressContactOrderTransportCountry());
        addressContactDeliveryInfo.setLatitude(tmsAddress.getTmsAddressContactOrderTransportLatitude());
        addressContactDeliveryInfo.setLongitude(tmsAddress.getTmsAddressContactOrderTransportLongitude());
        addressContactDeliveryInfo.setDate(tmsAddress.getTmsAddressContactOrderTransportDate());


        return addressContactDeliveryInfo;
    }


    public static TmsAddressContactOrderTransportInfo toEntity(AddressContactOrderTransportInfo addressContactDeliveryInfo, boolean lazy) {
        if (null == addressContactDeliveryInfo) {
            return null;
        }
        TmsAddressContactOrderTransportInfo tmsAddress = new TmsAddressContactOrderTransportInfo();


        tmsAddress.setTmsAddressContactOrderTransportName(addressContactDeliveryInfo.getName());
        tmsAddress.setTmsAddressContactOrderTransportTel1(addressContactDeliveryInfo.getTel1());
        tmsAddress.setTmsAddressContactOrderTransportEmail(addressContactDeliveryInfo.getEmail());
        tmsAddress.setTmsAddressContactOrderTransportCompany(addressContactDeliveryInfo.getCompany());

        tmsAddress.setTmsAddressContactOrderTransportLine1(addressContactDeliveryInfo.getLine1());
        tmsAddress.setTmsAddressContactOrderTransportCity(addressContactDeliveryInfo.getCity());
        tmsAddress.setTmsAddressContactOrderTransportZip(addressContactDeliveryInfo.getZip());
        tmsAddress.setTmsAddressContactOrderTransportCountry(addressContactDeliveryInfo.getCountry());
        tmsAddress.setTmsAddressContactOrderTransportLatitude(addressContactDeliveryInfo.getLatitude());
        tmsAddress.setTmsAddressContactOrderTransportLongitude(addressContactDeliveryInfo.getLongitude());
        tmsAddress.setTmsAddressContactOrderTransportDate(addressContactDeliveryInfo.getDate());


        return tmsAddress;
    }

    public static List<AddressContactOrderTransportInfo> toDtos(List<TmsAddressContactOrderTransportInfo> tmsAddresses, boolean lazy) {
        if (null == tmsAddresses) {
            return null;
        }
        List<AddressContactOrderTransportInfo> addresses = new ArrayList<>();
        for (TmsAddressContactOrderTransportInfo tmsAddress : tmsAddresses) {
            addresses.add(toDto(tmsAddress, lazy));
        }
        return addresses;
    }

    public static List<AddressContactOrderTransportInfo> toDtos(Iterable<TmsAddressContactOrderTransportInfo> tmsAddresses, boolean lazy) {
        if (null == tmsAddresses) {
            return null;
        }
        List<AddressContactOrderTransportInfo> addresses = new ArrayList<>();
        for (TmsAddressContactOrderTransportInfo tmsAddress : tmsAddresses) {
            addresses.add(toDto(tmsAddress, lazy));
        }
        return addresses;
    }

    public static Set<TmsAddressContactOrderTransportInfo> toEntities(Set<AddressContactOrderTransportInfo> addresses, boolean lazy) {
        if (null == addresses) {
            return null;
        }
        Set<TmsAddressContactOrderTransportInfo> tmsAddresses = new HashSet<>();
        for (AddressContactOrderTransportInfo addressContactDeliveryInfo : addresses) {
            tmsAddresses.add(toEntity(addressContactDeliveryInfo, lazy));
        }
        return tmsAddresses;
    }

    public static Set<AddressContactOrderTransportInfo> toDtos(Set<TmsAddressContactOrderTransportInfo> tmsAddresses, boolean lazy) {
        if (null == tmsAddresses) {
            return null;
        }
        Set<AddressContactOrderTransportInfo> addresses = new HashSet<>();
        for (TmsAddressContactOrderTransportInfo tmsAddress : tmsAddresses) {
            addresses.add(toDto(tmsAddress, lazy));
        }
        return addresses;
    }
}

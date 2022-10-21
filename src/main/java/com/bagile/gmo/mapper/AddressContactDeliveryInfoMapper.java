package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.dto.AddressContactDeliveryInfo;
import com.bagile.gmo.entities.TmsAddressContactDeliveryInfo;

import java.util.*;

public class AddressContactDeliveryInfoMapper {
    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static AddressContactDeliveryInfo toDto(TmsAddressContactDeliveryInfo tmsAddress, boolean lazy) {
        if (null == tmsAddress) {
            return null;
        }
        AddressContactDeliveryInfo addressContactDeliveryInfo = new AddressContactDeliveryInfo();

        addressContactDeliveryInfo.setName(tmsAddress.getTmsAddressContactDeliveryInfoName());
        addressContactDeliveryInfo.setTel1(tmsAddress.getTmsAddressContactDeliveryInfoTel1());
        addressContactDeliveryInfo.setEmail(tmsAddress.getTmsAddressContactDeliveryInfoEmail());
        addressContactDeliveryInfo.setCompany(tmsAddress.getTmsAddressContactDeliveryInfoCompany());

        addressContactDeliveryInfo.setLine1(tmsAddress.getTmsAddressContactDeliveryInfoLine1());
        addressContactDeliveryInfo.setCity(tmsAddress.getTmsAddressContactDeliveryInfoCity());
        addressContactDeliveryInfo.setZip(tmsAddress.getTmsAddressContactDeliveryInfoZip());
        addressContactDeliveryInfo.setCountry(tmsAddress.getTmsAddressContactDeliveryInfoCountry());
        addressContactDeliveryInfo.setLatitude(tmsAddress.getTmsAddressContactDeliveryInfoLatitude());
        addressContactDeliveryInfo.setLongitude(tmsAddress.getTmsAddressContactDeliveryInfoLongitude());
        addressContactDeliveryInfo.setDate(tmsAddress.getTmsAddressContactDeliveryInfoDate());


        return addressContactDeliveryInfo;
    }


    public static TmsAddressContactDeliveryInfo toEntity(AddressContactDeliveryInfo addressContactDeliveryInfo, boolean lazy) {
        if (null == addressContactDeliveryInfo) {
            return null;
        }
        TmsAddressContactDeliveryInfo tmsAddress = new TmsAddressContactDeliveryInfo();


        tmsAddress.setTmsAddressContactDeliveryInfoName(addressContactDeliveryInfo.getName());
        tmsAddress.setTmsAddressContactDeliveryInfoTel1(addressContactDeliveryInfo.getTel1());
        tmsAddress.setTmsAddressContactDeliveryInfoEmail(addressContactDeliveryInfo.getEmail());
        tmsAddress.setTmsAddressContactDeliveryInfoCompany(addressContactDeliveryInfo.getCompany());

        tmsAddress.setTmsAddressContactDeliveryInfoLine1(addressContactDeliveryInfo.getLine1());
        tmsAddress.setTmsAddressContactDeliveryInfoCity(addressContactDeliveryInfo.getCity());
        tmsAddress.setTmsAddressContactDeliveryInfoZip(addressContactDeliveryInfo.getZip());
        tmsAddress.setTmsAddressContactDeliveryInfoCountry(addressContactDeliveryInfo.getCountry());
        tmsAddress.setTmsAddressContactDeliveryInfoLatitude(addressContactDeliveryInfo.getLatitude());
        tmsAddress.setTmsAddressContactDeliveryInfoLongitude(addressContactDeliveryInfo.getLongitude());
        tmsAddress.setTmsAddressContactDeliveryInfoDate(addressContactDeliveryInfo.getDate());


        return tmsAddress;
    }

    public static List<AddressContactDeliveryInfo> toDtos(List<TmsAddressContactDeliveryInfo> tmsAddresses, boolean lazy) {
        if (null == tmsAddresses) {
            return null;
        }
        List<AddressContactDeliveryInfo> addresses = new ArrayList<>();
        for (TmsAddressContactDeliveryInfo tmsAddress : tmsAddresses) {
            addresses.add(toDto(tmsAddress, lazy));
        }
        return addresses;
    }

    public static List<AddressContactDeliveryInfo> toDtos(Iterable<TmsAddressContactDeliveryInfo> tmsAddresses, boolean lazy) {
        if (null == tmsAddresses) {
            return null;
        }
        List<AddressContactDeliveryInfo> addresses = new ArrayList<>();
        for (TmsAddressContactDeliveryInfo tmsAddress : tmsAddresses) {
            addresses.add(toDto(tmsAddress, lazy));
        }
        return addresses;
    }

    public static Set<TmsAddressContactDeliveryInfo> toEntities(Set<AddressContactDeliveryInfo> addresses, boolean lazy) {
        if (null == addresses) {
            return null;
        }
        Set<TmsAddressContactDeliveryInfo> tmsAddresses = new HashSet<>();
        for (AddressContactDeliveryInfo addressContactDeliveryInfo : addresses) {
            tmsAddresses.add(toEntity(addressContactDeliveryInfo, lazy));
        }
        return tmsAddresses;
    }

    public static Set<AddressContactDeliveryInfo> toDtos(Set<TmsAddressContactDeliveryInfo> tmsAddresses, boolean lazy) {
        if (null == tmsAddresses) {
            return null;
        }
        Set<AddressContactDeliveryInfo> addresses = new HashSet<>();
        for (TmsAddressContactDeliveryInfo tmsAddress : tmsAddresses) {
            addresses.add(toDto(tmsAddress, lazy));
        }
        return addresses;
    }
}

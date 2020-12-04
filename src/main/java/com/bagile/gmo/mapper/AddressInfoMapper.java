package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Address;
import com.bagile.gmo.dto.AddressInfo;
import com.bagile.gmo.entities.AdrAddressInfo;

import java.util.*;

public class AddressInfoMapper {
    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static AddressInfo toDto(AdrAddressInfo adrAddress, boolean lazy) {
        if (null == adrAddress) {
            return null;
        }
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setCity(adrAddress.getAdrAddressCity());
        addressInfo.setCountry(adrAddress.getAdrAddressCountry());
        addressInfo.setDigiCode(adrAddress.getAdrAddressDigiCode());
        addressInfo.setLine1(adrAddress.getAdrAddressLine1());
        addressInfo.setState(adrAddress.getAdrAddressState());
        addressInfo.setZip(adrAddress.getAdrAddressZip());
        addressInfo.setLine2(adrAddress.getAdrAddressLine2());



        return addressInfo;
    }
    public static AddressInfo toAddressInfoDto(Address address, boolean lazy) {
        if (null == address) {
            return null;
        }
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setCity(address.getCity());
        addressInfo.setCountry(address.getCountry());
        addressInfo.setDigiCode(address.getDigiCode());
        addressInfo.setLine1(address.getLine1());
        addressInfo.setState(address.getState());
        addressInfo.setZip(address.getZip());
        addressInfo.setLine2(address.getLine2());


        return addressInfo;
    }

    public static AdrAddressInfo toEntity(AddressInfo addressInfo, boolean lazy) {
        if (null == addressInfo) {
            return null;
        }
        AdrAddressInfo adrAddress = new AdrAddressInfo();
        adrAddress.setAdrAddressCity(addressInfo.getCity());
        adrAddress.setAdrAddressCountry(addressInfo.getCountry());
        adrAddress.setAdrAddressDigiCode(addressInfo.getDigiCode());
        adrAddress.setAdrAddressLine1(addressInfo.getLine1());
        adrAddress.setAdrAddressState(addressInfo.getState());
        adrAddress.setAdrAddressZip(addressInfo.getZip());
        adrAddress.setAdrAddressLine2(addressInfo.getLine2());
        return adrAddress;
    }

    public static List<AddressInfo> toDtos(List<AdrAddressInfo> adrAddresses, boolean lazy) {
        if (null == adrAddresses) {
            return null;
        }
        List<AddressInfo> addresses = new ArrayList<>();
        for (AdrAddressInfo adrAddress : adrAddresses) {
            addresses.add(toDto(adrAddress, lazy));
        }
        return addresses;
    }

    public static List<AddressInfo> toDtos(Iterable<AdrAddressInfo> adrAddresses, boolean lazy) {
        if (null == adrAddresses) {
            return null;
        }
        List<AddressInfo> addresses = new ArrayList<>();
        for (AdrAddressInfo adrAddress : adrAddresses) {
            addresses.add(toDto(adrAddress, lazy));
        }
        return addresses;
    }

    public static Set<AdrAddressInfo> toEntities(Set<AddressInfo> addresses, boolean lazy) {
        if (null == addresses) {
            return null;
        }
        Set<AdrAddressInfo> adrAddresses = new HashSet<>();
        for (AddressInfo addressInfo : addresses) {
            adrAddresses.add(toEntity(addressInfo, lazy));
        }
        return adrAddresses;
    }

    public static Set<AddressInfo> toDtos(Set<AdrAddressInfo> adrAddresses, boolean lazy) {
        if (null == adrAddresses) {
            return null;
        }
        Set<AddressInfo> addresses = new HashSet<>();
        for (AdrAddressInfo adrAddress : adrAddresses) {
            addresses.add(toDto(adrAddress, lazy));
        }
        return addresses;
    }
}

/**
 *
 */
package com.bagile.gmo.mapper;


import com.bagile.gmo.dto.Address;
import com.bagile.gmo.dto.Planning;
import com.bagile.gmo.entities.AdrAddress;
import com.bagile.gmo.entities.TmsPlanning;

import java.util.*;

/**
 * @author aelguezzar
 */
public class AddressMapper {
        public AddressMapper(){

        }
    private static Map<String, String> map;

    public static Map<String, String> getMap() {
        return map;
    }
    static {
        map = new HashMap<>();
        map.put("id","adrAddressId");
        map.put("owner","ownOwner");
        map.put("code","adrAddressCode");
        map.put("name","adrAddressName");

        map.put("contactTel","adrAddressContactTel");
        map.put("line1","adrAddressLine1");
        map.put("line2","adrAdressLine2");
        map.put("zip","adrAddressZip");
        map.put("city","adrAddressCity");
        map.put("state","adrAddressState");
        map.put("country","adrAddressCountry");
        map.put("digiCode","adrAddressDigiCode");
        map.put("creationDate","adrAddressCreationDate");
        map.put("updateDate","adrAddressUpdateDate");
        map.put("variable1","adrAddressVariable1");
        map.put("variable2","adrAddressVariable2");
        map.put("variable3","adrAddressVariable3");
        map.put("variable4","adrAddressVariable4");
        map.put("variable5","adrAddressVariable5");
        map.put("variable6","adrAddressVariable6");
        map.put("variable7","adrAddressVariable7");
        map.put("variable8","adrAddressVariable8");
        map.put("variable9","adrAddressVariable9");
        map.put("variable10","adrAddressVariable10");
        map.put("addressType","addAddressType");
        map.put("delivery","addAddressDelivery");

        map.put("account","cmdAccount");
        map.put("ville","prmVille");
        map.put("company","cmdCompany");

    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Address toDto(AdrAddress adrAddress, boolean lazy) {
        if (null == adrAddress) {
            return null;
        }
        Address address = new Address();
        address.setCity(adrAddress.getAdrAddressCity());
        address.setCode(adrAddress.getAdrAddressCode());
        address.setName(adrAddress.getAdrAddressName());

        address.setContactTel(adrAddress.getAdrAddressContactTel());
        address.setCountry(adrAddress.getAdrAddressCountry());
        address.setDigiCode(adrAddress.getAdrAddressDigiCode());
        address.setId(adrAddress.getAdrAddressId());
        address.setLine1(adrAddress.getAdrAddressLine1());
        address.setState(adrAddress.getAdrAddressState());
        address.setZip(adrAddress.getAdrAddressZip());
        address.setLine2(adrAddress.getAdrAdressLine2());
        address.setVariable1(adrAddress.getAdrAddressVariable1());
        address.setVariable2(adrAddress.getAdrAddressVariable2());
        address.setVariable3(adrAddress.getAdrAddressVariable3());
        address.setVariable4(adrAddress.getAdrAddressVariable4());
        address.setVariable5(adrAddress.getAdrAddressVariable5());
        address.setVariable6(adrAddress.getAdrAddressVariable6());
        address.setVariable7(adrAddress.getAdrAddressVariable7());
        address.setVariable8(adrAddress.getAdrAddressVariable8());
        address.setVariable9(adrAddress.getAdrAddressVariable9());
        address.setVariable10(adrAddress.getAdrAddressVariable10());
        address.setAddressType(adrAddress.getAddAddressType());
        address.setAddressTypeTms(adrAddress.getAdrAddressAddressTypeTms());
        address.setDelivery(adrAddress.getAddAddressDelivery());


        address.setLatitude(adrAddress.getAdrAddressLatitude());
        address.setLongitude(adrAddress.getAdrAddressLongitude());

        if (!lazy) {
            address.setOwner(OwnerMapper.toDto(adrAddress.getOwnOwner(), true));
            //address.setAccount(AccountMapper.toDto(adrAddress.getCmdAccount(), true));
          //  address.setCompany(CompanyMapper.toDto(adrAddress.getCmdCompany(), true));
            address.setTransport(TransportMapper.toDto(adrAddress.getTrpTransport(), true));

            address.setVille(VilleMapper.toDto(adrAddress.getPrmVille(), true));
            address.setPays(PaysMapper.toDto(adrAddress.getPrmPays(), true));

//            address.setWarehouses(WarehouseMapper.toDtos(adrAddress.getWrhWarehouses(), true));
//            address.setAccountsForAccountDeliveryAddress(
//                    AccountMapper.toDtos(adrAddress.getCmdAccountsForCmdAccountDeliveryAddressId(), true));
//            address.setAccountsForAccountInvoicesAddress(
//                    AccountMapper.toDtos(adrAddress.getCmdAccountsForCmdAccountInvoicesAddressId(), true));
//            address.setInvoiceArcs(InvoiceArcMapper.toDtos(adrAddress.getInvInvoiceArcs(), true));
//            address.setInvoices(InvoiceMapper.toDtos(adrAddress.getInvInvoices(), true));
//            address.setPurshaseOrderArcs(PurshaseOrderArcMapper.toDtos(adrAddress.getRcpPurshaseOrderArcs(), true));
//            address.setPurshaseOrders(PurshaseOrderMapper.toDtos(adrAddress.getRcpPurshaseOrders(), true));
//            address.setReceptionArcs(ReceptionArcMapper.toDtos(adrAddress.getRcpReceptionArcs(), true));
//            address.setReceptions(ReceptionMapper.toDtos(adrAddress.getRcpReceptions(), true));
//            address.setSaleOrderArcsForSaleOrderDeliveryAddress(
//                    SaleOrderArcMapper.toDtos(adrAddress.getCmdSaleOrderArcsForCmdSaleOrderDeliveryAddressId(), true));
//            address.setSaleOrderArcsForSaleOrderInvoiceAddress(
//                    SaleOrderArcMapper.toDtos(adrAddress.getCmdSaleOrderArcsForCmdSaleOrderInvoiceAddressId(), true));
//            address.setSaleOrdersForSaleOrderDeliveryAddress(
//                    SaleOrderMapper.toDtos(adrAddress.getCmdSaleOrdersForCmdSaleOrderDeliveryAddressId(), true));
//            address.setSaleOrdersForSaleOrderInvoiceAddress(
//                    SaleOrderMapper.toDtos(adrAddress.getCmdSaleOrdersForCmdSaleOrderInvoiceAddressId(), true));
        }
        return address;
    }

    public static AdrAddress toEntity(Address address, boolean lazy) {
        if (null == address) {
            return null;
        }
        AdrAddress adrAddress = new AdrAddress();
        adrAddress.setAdrAddressCity(address.getCity());
        adrAddress.setAdrAddressCode(address.getCode()!=null?address.getCode().toUpperCase():null);
        adrAddress.setAdrAddressName(address.getName());

        adrAddress.setAdrAddressContactTel(address.getContactTel());
        adrAddress.setAdrAddressCountry(address.getCountry());
        adrAddress.setAdrAddressCreationDate(address.getCreationDate());
        adrAddress.setAdrAddressDigiCode(address.getDigiCode());
        adrAddress.setAdrAddressId(address.getId());
        adrAddress.setAdrAddressLine1(address.getLine1());
        adrAddress.setAdrAddressState(address.getState());
        adrAddress.setAdrAddressUpdateDate(address.getUpdateDate());
        adrAddress.setAdrAddressZip(address.getZip());
        adrAddress.setAdrAdressLine2(address.getLine2());
        adrAddress.setAdrAddressVariable1(address.getVariable1());
        adrAddress.setAdrAddressVariable2(address.getVariable2());
        adrAddress.setAdrAddressVariable3(address.getVariable3());
        adrAddress.setAdrAddressVariable4(address.getVariable4());
        adrAddress.setAdrAddressVariable5(address.getVariable5());
        adrAddress.setAdrAddressVariable6(address.getVariable6());
        adrAddress.setAdrAddressVariable7(address.getVariable7());
        adrAddress.setAdrAddressVariable8(address.getVariable8());
        adrAddress.setAdrAddressVariable9(address.getVariable9());
        adrAddress.setAdrAddressVariable10(address.getVariable10());
        adrAddress.setAddAddressType(address.getAddressType());
        adrAddress.setAdrAddressAddressTypeTms(address.getAddressTypeTms());
        adrAddress.setAddAddressDelivery(address.getDelivery());

        adrAddress.setAdrAddressLatitude(address.getLatitude());
        adrAddress.setAdrAddressLongitude(address.getLongitude());

        if (!lazy) {
            adrAddress.setOwnOwner(OwnerMapper.toEntity(address.getOwner(), true));
           // adrAddress.setCmdAccount(AccountMapper.toEntity(address.getAccount(), true));
           // adrAddress.setCmdCompany(CompanyMapper.toEntity(address.getCompany(), true));
            adrAddress.setTrpTransport(TransportMapper.toEntity(address.getTransport(), true));

            adrAddress.setPrmPays(PaysMapper.toEntity(address.getPays(), true));
            adrAddress.setPrmVille(VilleMapper.toEntity(address.getVille(), true));

//            adrAddress.setCmdAccountsForCmdAccountDeliveryAddressId(
//                    AccountMapper.toEntities(address.getAccountsForAccountDeliveryAddress(), true));
//            adrAddress.setCmdAccountsForCmdAccountInvoicesAddressId(
//                    AccountMapper.toEntities(address.getAccountsForAccountInvoicesAddress(), true));
//            adrAddress.setCmdSaleOrderArcsForCmdSaleOrderDeliveryAddressId(
//                    SaleOrderArcMapper.toEntities(address.getSaleOrderArcsForSaleOrderDeliveryAddress(), true));
//            adrAddress.setCmdSaleOrderArcsForCmdSaleOrderInvoiceAddressId(
//                    SaleOrderArcMapper.toEntities(address.getSaleOrderArcsForSaleOrderInvoiceAddress(), true));
//            adrAddress.setCmdSaleOrdersForCmdSaleOrderDeliveryAddressId(
//                    SaleOrderMapper.toEntities(address.getSaleOrdersForSaleOrderDeliveryAddress(), true));
//            adrAddress.setCmdSaleOrdersForCmdSaleOrderInvoiceAddressId(
//                    SaleOrderMapper.toEntities(address.getSaleOrdersForSaleOrderInvoiceAddress(), true));
//            adrAddress.setInvInvoiceArcs(InvoiceArcMapper.toEntities(address.getInvoiceArcs(), true));
//            adrAddress.setInvInvoices(InvoiceMapper.toEntities(address.getInvoices(), true));
//            adrAddress.setRcpPurshaseOrderArcs(PurshaseOrderArcMapper.toEntities(address.getPurshaseOrderArcs(), true));
//            adrAddress.setRcpPurshaseOrders(PurshaseOrderMapper.toEntities(address.getPurshaseOrders(), true));
//            adrAddress.setRcpReceptionArcs(ReceptionArcMapper.toEntities(address.getReceptionArcs(), true));
//            adrAddress.setRcpReceptions(ReceptionMapper.toEntities(address.getReceptions(), true));
//            adrAddress.setWrhWarehouses(WarehouseMapper.toEntities(address.getWarehouses(), true));
        }
        return adrAddress;
    }

    public static List<Address> toDtos(List<AdrAddress> adrAddresses, boolean lazy) {
        if (null == adrAddresses) {
            return null;
        }
        List<Address> addresses = new ArrayList<>();
        for (AdrAddress adrAddress : adrAddresses) {
            addresses.add(toDto(adrAddress, lazy));
        }
        return addresses;
    }

    public static List<Address> toDtos(Iterable<AdrAddress> adrAddresses, boolean lazy) {
        if (null == adrAddresses) {
            return null;
        }
        List<Address> addresses = new ArrayList<>();
        for (AdrAddress adrAddress : adrAddresses) {
            addresses.add(toDto(adrAddress, lazy));
        }
        return addresses;
    }

    public static Set<AdrAddress> toEntities(Iterable<? extends Address> addresses, boolean lazy) {
        if (null == addresses) {
            return null;
        }
        Set<AdrAddress> adrAddresses = new HashSet<>();
        for (Address address : addresses) {
            adrAddresses.add(toEntity(address, lazy));
        }
        return adrAddresses;
    }



}

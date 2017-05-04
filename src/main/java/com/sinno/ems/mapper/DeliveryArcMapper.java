package com.sinno.ems.mapper;

import com.sinno.ems.dto.*;
import com.sinno.ems.dto.DeliveryArc;
import com.sinno.ems.entities.CmdDelivery;
import com.sinno.ems.entities.CmdDeliveryArc;
import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * Created by ALae on 21/04/2016.
 */
public class DeliveryArcMapper {
    private DeliveryArcMapper(){}
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdDeliveryId");
        map.put("code", "cmdDeliveryCode");
        map.put("description", "cmdDeliveryDescription");
        map.put("account", "cmdAccount");
        map.put("warehouse", "wrhWarehouse");
        map.put("transport", "trpTransport");
        map.put("deliveryAddress", "adrAddressByCmdSaleOrderDeliveryAddressId");
        map.put("invoiceAddress", "adrAddressByCmdSaleOrderInvoiceAddressId");
        map.put("owner", "ownOwner");
        map.put("orderStatus", "prmOrderStatus");
        map.put("saleOrder", "cmdSaleOrder");
        map.put("orderType", "prmOrderType");
        map.put("expectedDate", "cmdDeliveryExpectedDate");
        map.put("date", "cmdDeliveryDate");
        map.put("comment", "cmdDeliveryComment");
        map.put("containerCount", "cmdDeliveryContainerCount");
        map.put("lines", "cmdDeliveryLines");
        map.put("location", "locLocation");
        map.put("reception", "rcpReception");
        map.put("transportTel", "cmdDeliveryTransportTel");
        map.put("remarks", "cmddeliveryremarks");
        map.put("transportcontact", "cmdDeliveryTransportcontact");
        map.put("immatriculation", "cmdDeliveryimmatriculation");
        map.put("transfertCode", "cmdDeliveryTransfertCode");


    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static CmdDeliveryArc toEntity(DeliveryArc delivery, boolean lazy) {
        if (null == delivery) return null;
        CmdDeliveryArc cmdDelivery = new CmdDeliveryArc();
        cmdDelivery.setCmdDeliveryId(delivery.getId());
        cmdDelivery.setCmdDeliveryCode(delivery.getCode());
        cmdDelivery.setCmdDeliveryDescription(delivery.getDescription());
        cmdDelivery.setCmdDeliveryExpectedDate(delivery.getExpectedDate());
        cmdDelivery.setCmdDeliveryDate(delivery.getLoadDate());
        cmdDelivery.setCmdDeliveryContainerCount(delivery.getContainerCount());
        cmdDelivery.setCmdDeliveryTransportTel(delivery.getTransportTel());
        cmdDelivery.setCmdDeliveryTransportContact(delivery.getTransportContact());
        cmdDelivery.setCmdDeliveryRemarks(delivery.getRemarks());
        cmdDelivery.setCmdDeliveryImmatriculation(delivery.getImmatriculation());
        cmdDelivery.setCmdDeliveryUpdateDate(delivery.getUpdateDate());
        cmdDelivery.setCmdDeliveryCreationDate(delivery.getCreationDate());
        cmdDelivery.setCmdDeliveryTransfertCode(delivery.getTransfertCode());

        if (!lazy) {
            cmdDelivery.setLocLocation(LocationMapper.toEntity(delivery.getLocation(), true));
            cmdDelivery.setCmdAccount(AccountMapper.toEntity(delivery.getAccount(), true));
            cmdDelivery.setWrhWarehouse(WarehouseMapper.toEntity(delivery.getWarehouse(), true));
            cmdDelivery.setTrpTransport(TransportMapper.toEntity(delivery.getTransport(), true));
            cmdDelivery.setAdrAddressByCmdSaleOrderDeliveryAddressId(AddressMapper.toEntity(delivery.getDeliveryAddress(), true));
            cmdDelivery.setAdrAddressByCmdSaleOrderInvoiceAddressId(AddressMapper.toEntity(delivery.getInvoiceAddress(), true));
            cmdDelivery.setOwnOwner(OwnerMapper.toEntity(delivery.getOwner(), true));
            cmdDelivery.setCmdSaleOrder(SaleOrderArcMapper.toEntity(delivery.getSaleOrder(), true));
            cmdDelivery.setPrmOrderType(OrderTypeMapper.toEntity(delivery.getOrderType(), true));
            cmdDelivery.setPrmOrderStatus(OrderStatusMapper.toEntity(delivery.getOrderStatus(), true));
            cmdDelivery.setCmdDeliveryLines(DeliveryLineArcMapper.toEntities(delivery.getLines(), false));
            cmdDelivery.setRcpReception(ReceptionArcMapper.toEntity(delivery.getReception(), true));
            oneToMany(cmdDelivery);
        }
        return cmdDelivery;
    }

    public static void oneToMany(CmdDeliveryArc cmdDelivery) {
        if (null != cmdDelivery.getCmdDeliveryLines()) {
            cmdDelivery.getCmdDeliveryLines().stream().forEach(rl -> {
                rl.setCmdDelivery(cmdDelivery);
//                if (null != rl.getCmdDevisLine())
//                    rl.setCmdDeliveryLineOrderQuantity(rl.getCmdDevisLine().getCmdSaleOrderLineQuantity());
                rl.setCmdDeliveryLineUpdateDate(EmsDate.getDateNow());
                rl.setOwnOwner(cmdDelivery.getOwnOwner());
                rl.setWrhWarehouse(cmdDelivery.getWrhWarehouse());
                if (0 >= rl.getCmdDeliveryLineId()) {
                    rl.setCmdDeliveryLineCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static DeliveryArc toDto(CmdDeliveryArc cmdDelivery, boolean lazy) {
        if (null == cmdDelivery) return null;
        DeliveryArc delivery = new DeliveryArc();
        delivery.setId(cmdDelivery.getCmdDeliveryId());
        delivery.setCode(cmdDelivery.getCmdDeliveryCode());
        delivery.setDescription(cmdDelivery.getCmdDeliveryDescription());
        delivery.setExpectedDate(cmdDelivery.getCmdDeliveryExpectedDate());
        delivery.setLoadDate(cmdDelivery.getCmdDeliveryDate());
        delivery.setContainerCount(cmdDelivery.getCmdDeliveryContainerCount());
        delivery.setTransportTel(cmdDelivery.getCmdDeliveryTransportTel());
        delivery.setTransportContact(cmdDelivery.getCmdDeliveryTransportContact());
        delivery.setRemarks(cmdDelivery.getCmdDeliveryRemarks());
        delivery.setImmatriculation(cmdDelivery.getCmdDeliveryImmatriculation());
        delivery.setUpdateDate(cmdDelivery.getCmdDeliveryUpdateDate());
        delivery.setCreationDate(cmdDelivery.getCmdDeliveryCreationDate());
        delivery.setTransfertCode(cmdDelivery.getCmdDeliveryTransfertCode());

        if (!lazy) {
            delivery.setLocation(LocationMapper.toDto(cmdDelivery.getLocLocation(), true));
            delivery.setAccount(AccountMapper.toDto(cmdDelivery.getCmdAccount(), true));
            delivery.setWarehouse(WarehouseMapper.toDto(cmdDelivery.getWrhWarehouse(), true));
            delivery.setTransport(TransportMapper.toDto(cmdDelivery.getTrpTransport(), true));
            delivery.setDeliveryAddress(AddressMapper.toDto(cmdDelivery.getAdrAddressByCmdSaleOrderDeliveryAddressId(), true));
            delivery.setInvoiceAddress(AddressMapper.toDto(cmdDelivery.getAdrAddressByCmdSaleOrderInvoiceAddressId(), true));
            delivery.setOwner(OwnerMapper.toDto(cmdDelivery.getOwnOwner(), true));
            delivery.setSaleOrder(SaleOrderArcMapper.toDto(cmdDelivery.getCmdSaleOrder(), true));
            delivery.setOrderType(OrderTypeMapper.toDto(cmdDelivery.getPrmOrderType(), true));
            delivery.setOrderStatus(OrderStatusMapper.toDto(cmdDelivery.getPrmOrderStatus(), true));
            delivery.setLines(DeliveryLineArcMapper.toDtos(cmdDelivery.getCmdDeliveryLines(), false));
            delivery.setReception(ReceptionArcMapper.toDto(cmdDelivery.getRcpReception(), true));
        }
        return delivery;
    }


    public static List<DeliveryArc> toDtos(List<CmdDeliveryArc> cmdDeliveries, boolean lazy) {
        if (null == cmdDeliveries) {
            return null;
        }
        List<DeliveryArc> deliveries = new ArrayList<>();
        for (CmdDeliveryArc cmdDelivery : cmdDeliveries) {
            deliveries.add(toDto(cmdDelivery, lazy));
        }
        return deliveries;
    }

    public static List<DeliveryArc> toDtos(Iterable<CmdDeliveryArc> cmdDeliveries, boolean lazy) {
        if (null == cmdDeliveries) {
            return null;
        }
        List<DeliveryArc> deliveries = new ArrayList<>();
        for (CmdDeliveryArc cmdDelivery : cmdDeliveries) {
            deliveries.add(toDto(cmdDelivery, lazy));
        }
        return deliveries;
    }

    public static Set<CmdDeliveryArc> toEntities(Set<DeliveryArc> deliveries, boolean lazy) {
        if (null == deliveries) {
            return null;
        }
        Set<CmdDeliveryArc> cmdDeliveries = new HashSet<>();
        for (DeliveryArc delivery : deliveries) {
            cmdDeliveries.add(toEntity(delivery, lazy));
        }
        return cmdDeliveries;
    }

    public static Set<DeliveryArc> toDtos(Set<CmdDeliveryArc> cmdDeliveries, boolean lazy) {
        if (null == cmdDeliveries) {
            return null;
        }
        Set<DeliveryArc> deliveries = new HashSet<>();
        for (CmdDeliveryArc cmdDelivery : cmdDeliveries) {
            deliveries.add(toDto(cmdDelivery, lazy));
        }
        return deliveries;
    }
}

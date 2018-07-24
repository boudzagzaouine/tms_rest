package com.bagile.tms.mapper;

import com.sinno.ems.dto.Delivery;
import com.sinno.ems.entities.CmdDelivery;
import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * Created by ALae on 21/04/2016.
 */
public class DeliveryMapper {
    private DeliveryMapper() {
    }

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
        map.put("preparation", "cmdPreparation");
        map.put("road", "tmsRoad");


    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static CmdDelivery toEntity(Delivery delivery, boolean lazy) {
        if (null == delivery) return null;
        CmdDelivery cmdDelivery = new CmdDelivery();
        cmdDelivery.setCmdDeliveryId(delivery.getId());
        cmdDelivery.setCmdDeliveryCode(delivery.getCode() != null ? delivery.getCode().toUpperCase() : null);
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
        cmdDelivery.setCmdDeliveryComment(delivery.getComment());
        cmdDelivery.setCmdDeliverySendedToEms(delivery.getSendedToWms());
        cmdDelivery.setCmdDeliveryDiscount(delivery.getDiscount());
        cmdDelivery.setCmdDeliveryTotalPriceHT(delivery.getTotalPriceHT());
        cmdDelivery.setCmdDeliveryTotalPriceTTC(delivery.getTotalPriceTTC());
        cmdDelivery.setCmdDeliveryVat(delivery.getVat());
        if (!lazy) {
            cmdDelivery.setTmsRoad(RoadMapper.toEntity(delivery.getRoad(),true));
            cmdDelivery.setPrmCurrency(CurrencyMapper.toEntity(delivery.getCurrency(), true));
            cmdDelivery.setLocLocation(LocationMapper.toEntity(delivery.getLocation(), true));
            cmdDelivery.setCmdAccount(AccountMapper.toEntity(delivery.getAccount(), true));
            cmdDelivery.setWrhWarehouse(WarehouseMapper.toEntity(delivery.getWarehouse(), true));
            cmdDelivery.setTrpTransport(TransportMapper.toEntity(delivery.getTransport(), true));
            cmdDelivery.setAdrAddressByCmdSaleOrderDeliveryAddressId(AddressMapper.toEntity(delivery.getDeliveryAddress(), true));
            cmdDelivery.setAdrAddressByCmdSaleOrderInvoiceAddressId(AddressMapper.toEntity(delivery.getInvoiceAddress(), true));
            cmdDelivery.setOwnOwner(OwnerMapper.toEntity(delivery.getOwner(), true));
            cmdDelivery.setCmdSaleOrder(SaleOrderMapper.toEntity(delivery.getSaleOrder(), true));
            cmdDelivery.setPrmOrderType(OrderTypeMapper.toEntity(delivery.getOrderType(), true));
            cmdDelivery.setPrmOrderStatus(OrderStatusMapper.toEntity(delivery.getOrderStatus(), true));
            cmdDelivery.setCmdDeliveryLines(DeliveryLineMapper.toEntities(delivery.getLines(), false));
            cmdDelivery.setRcpReception(ReceptionMapper.toEntity(delivery.getReception(), true));
            cmdDelivery.setCmdPreparation(PreparationMapper.toEntity(delivery.getPreparation(), true));
            oneToMany(cmdDelivery);
        }
        return cmdDelivery;
    }

    public static void oneToMany(CmdDelivery cmdDelivery) {
        if (null != cmdDelivery.getCmdDeliveryLines()) {
            cmdDelivery.getCmdDeliveryLines().stream().forEach(rl -> {
                rl.setCmdDelivery(cmdDelivery);
//                if (null != rl.getCmdDevisLine())
//                    rl.setCmdDeliveryLineOrderQuantity(rl.getCmdDevisLine().getCmdSaleOrderLineQuantity());
                rl.setCmdDeliveryLineUpdateDate(EmsDate.getDateNow());
                rl.setOwnOwner(cmdDelivery.getOwnOwner());
                rl.setLocLocation(cmdDelivery.getLocLocation());
                rl.setWrhWarehouse(cmdDelivery.getWrhWarehouse());
                if (0 >= rl.getCmdDeliveryLineId()) {
                    rl.setCmdDeliveryLineCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static Delivery toDto(CmdDelivery cmdDelivery, boolean lazy) {
        if (null == cmdDelivery) return null;
        Delivery delivery = new Delivery();
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
        delivery.setComment(cmdDelivery.getCmdDeliveryComment());
        delivery.setSendedToWms(cmdDelivery.getCmdDeliverySendedToEms());
        delivery.setTotalPriceTTC(cmdDelivery.getCmdDeliveryTotalPriceTTC());
        delivery.setTotalPriceHT(cmdDelivery.getCmdDeliveryTotalPriceHT());
        delivery.setDiscount(cmdDelivery.getCmdDeliveryDiscount());
        delivery.setVat(cmdDelivery.getCmdDeliveryVat());
        if (!lazy) {
            delivery.setRoad(RoadMapper.toDto(cmdDelivery.getTmsRoad(),true));
            delivery.setCurrency(CurrencyMapper.toDto(cmdDelivery.getPrmCurrency(), true));
            delivery.setLocation(LocationMapper.toDto(cmdDelivery.getLocLocation(), true));
            delivery.setAccount(AccountMapper.toDto(cmdDelivery.getCmdAccount(), true));
            delivery.setWarehouse(WarehouseMapper.toDto(cmdDelivery.getWrhWarehouse(), true));
            delivery.setTransport(TransportMapper.toDto(cmdDelivery.getTrpTransport(), true));
            delivery.setDeliveryAddress(AddressMapper.toDto(cmdDelivery.getAdrAddressByCmdSaleOrderDeliveryAddressId(), true));
            delivery.setInvoiceAddress(AddressMapper.toDto(cmdDelivery.getAdrAddressByCmdSaleOrderInvoiceAddressId(), true));
            delivery.setOwner(OwnerMapper.toDto(cmdDelivery.getOwnOwner(), true));
            delivery.setSaleOrder(SaleOrderMapper.toDto(cmdDelivery.getCmdSaleOrder(), true));
            delivery.setOrderType(OrderTypeMapper.toDto(cmdDelivery.getPrmOrderType(), true));
            delivery.setOrderStatus(OrderStatusMapper.toDto(cmdDelivery.getPrmOrderStatus(), true));
            delivery.setLines(DeliveryLineMapper.toDtos(cmdDelivery.getCmdDeliveryLines(), false));
            delivery.setReception(ReceptionMapper.toDto(cmdDelivery.getRcpReception(), true));
            delivery.setPreparation(PreparationMapper.toDto(cmdDelivery.getCmdPreparation(), true));
        }
        return delivery;
    }


    public static List<Delivery> toDtos(List<CmdDelivery> cmdDeliveries, boolean lazy) {
        if (null == cmdDeliveries) {
            return null;
        }
        List<Delivery> deliveries = new ArrayList<>();
        for (CmdDelivery cmdDelivery : cmdDeliveries) {
            deliveries.add(toDto(cmdDelivery, lazy));
        }
        return deliveries;
    }

    public static List<Delivery> toDtos(Iterable<CmdDelivery> cmdDeliveries, boolean lazy) {
        if (null == cmdDeliveries) {
            return null;
        }
        List<Delivery> deliveries = new ArrayList<>();
        for (CmdDelivery cmdDelivery : cmdDeliveries) {
            deliveries.add(toDto(cmdDelivery, lazy));
        }
        return deliveries;
    }

    public static Set<CmdDelivery> toEntities(Set<Delivery> deliveries, boolean lazy) {
        if (null == deliveries) {
            return null;
        }
        Set<CmdDelivery> cmdDeliveries = new HashSet<>();
        for (Delivery delivery : deliveries) {
            cmdDeliveries.add(toEntity(delivery, lazy));
        }
        return cmdDeliveries;
    }

    public static Set<Delivery> toDtos(Set<CmdDelivery> cmdDeliveries, boolean lazy) {
        if (null == cmdDeliveries) {
            return null;
        }
        Set<Delivery> deliveries = new HashSet<>();
        for (CmdDelivery cmdDelivery : cmdDeliveries) {
            deliveries.add(toDto(cmdDelivery, lazy));
        }
        return deliveries;
    }
}

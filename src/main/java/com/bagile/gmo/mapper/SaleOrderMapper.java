/**
 *
 */
package com.bagile.gmo.mapper;


import com.bagile.gmo.dto.SaleOrder;
import com.bagile.gmo.entities.CmdSaleOrder;

import java.util.*;


public class SaleOrderMapper {
    private SaleOrderMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdSaleOrderId");
        map.put("account", "cmdAccount");
        map.put("owner", "ownOwner");
        map.put("deliveryAddress", "deliveryAddress");
        map.put("invoiceAddress", "invoiceAddress");
        map.put("orderStatus", "prmOrderStatus");
        map.put("orderType", "prmOrderType");
        map.put("supplier", "rcpSupplier");
        map.put("transport", "trpTransport");
        map.put("warehouse", "wrhWarehouseSource");
        map.put("warehouseDestination", "wrhWarehouseDestination");
        map.put("code", "cmdSaleOrderCode");
        map.put("remarks", "cmdSaleOrderRemarks");
        map.put("customerCode", "cmdSaleOrderCustomerCode");
        map.put("description", "cmdSaleOrderDescription");
        map.put("expectedDate", "cmdSaleOrderExpectedDate");
        map.put("loadDate", "cmdSaleOrderLoadDate");
        map.put("containers", "cmdSaleOrderContainers");
        map.put("transportContact", "cmdSaleOrderTransportContact");
        map.put("immatriculation", "cmdSaleOrderImmatriculation");
        map.put("creationDate", "cmdSaleOrderCreationDate");
        map.put("updateDate", "cmdSaleOrderUpdateDate");
        map.put("variable1", "cmdSaleOrderVariable1");
        map.put("variable2", "cmdSaleOrderVariable2");
        map.put("variable3", "cmdSaleOrderVariable3");
        map.put("variable4", "cmdSaleOrderVariable4");
        map.put("variable5", "cmdSaleOrderVariable5");
        map.put("variable6", "cmdSaleOrderVariable6");
        map.put("variable7", "cmdSaleOrderVariable7");
        map.put("variable8", "cmdSaleOrderVariable8");
        map.put("variable9", "cmdSaleOrderVariable9");
        map.put("variable10", "cmdSaleOrderVariable10");
        map.put("transportTel", "cmdSaleOrderTransportTel");
        map.put("transfertCode", "cmdSaleOrderTransferCode");
        map.put("accounted", "cmdSaleOrderAccounted");
        map.put("active", "cmdSaleOrderActive");
        map.put("devis", "cmdDevis");
        map.put("currency", "prmCurrency");
        map.put("commercial", "cmdCommercial");
        map.put("parentService", "parentService");
        map.put("payedAmount", "cmdSaleOrderPayedAmount");
        map.put("promotion", "pmtPromotion");
        map.put("cashRegister", "cmdSaleOrderCashRegister");
        map.put("paymentStatus", "prmPaymentStatus");
        map.put("deal", "cmdDeal");
        map.put("dealCode", "cmdSaleOrderDealCode");
        map.put("confirmed", "cmdSaleOrderConfirmed");
        map.put("dealResponsible", "cmdDealResponsible");
        map.put("lines","cmdSaleOrderLines");
        map.put("gmao","cmdSaleOrderGmao");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static SaleOrder toDto(CmdSaleOrder cmdSaleOrder, boolean lazy) {
        if (null == cmdSaleOrder) {
            return null;
        }
        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setId(cmdSaleOrder.getCmdSaleOrderId());

        saleOrder.setCode(cmdSaleOrder.getCmdSaleOrderCode());
        saleOrder.setContainers(cmdSaleOrder.getCmdSaleOrderContainers());
        saleOrder.setCreationDate(cmdSaleOrder.getCmdSaleOrderCreationDate());
        saleOrder.setCustomerCode(cmdSaleOrder.getCmdSaleOrderCustomerCode());
        saleOrder.setDescription(cmdSaleOrder.getCmdSaleOrderDescription());
        saleOrder.setExpectedDate(cmdSaleOrder.getCmdSaleOrderExpectedDate());
        saleOrder.setId(cmdSaleOrder.getCmdSaleOrderId());
        saleOrder.setImmatriculation(cmdSaleOrder.getCmdSaleOrderImmatriculation());
        saleOrder.setLoadDate(cmdSaleOrder.getCmdSaleOrderLoadDate());
        saleOrder.setRemarks(cmdSaleOrder.getCmdSaleOrderRemarks());
        saleOrder.setTransportContact(cmdSaleOrder.getCmdSaleOrderTransportContact());
        saleOrder.setUpdateDate(cmdSaleOrder.getUpdateDate());
        saleOrder.setVariable1(cmdSaleOrder.getCmdSaleOrderVariable1());
        saleOrder.setVariable2(cmdSaleOrder.getCmdSaleOrderVariable2());
        saleOrder.setVariable3(cmdSaleOrder.getCmdSaleOrderVariable3());
        saleOrder.setVariable4(cmdSaleOrder.getCmdSaleOrderVariable4());
        saleOrder.setVariable5(cmdSaleOrder.getCmdSaleOrderVariable5());
        saleOrder.setVariable6(cmdSaleOrder.getCmdSaleOrderVariable6());
        saleOrder.setVariable7(cmdSaleOrder.getCmdSaleOrderVariable7());
        saleOrder.setVariable8(cmdSaleOrder.getCmdSaleOrderVariable8());
        saleOrder.setVariable9(cmdSaleOrder.getCmdSaleOrderVariable9());
        saleOrder.setVariable10(cmdSaleOrder.getCmdSaleOrderVariable10());
        saleOrder.setTransportTel(cmdSaleOrder.getCmdSaleOrderTransportTel());
        saleOrder.setTransfertCode(cmdSaleOrder.getCmdSaleOrderTransfertCode());
        saleOrder.setSendedToWms(cmdSaleOrder.getCmdSaleOrderSendedToWms());
        saleOrder.setDiscount(cmdSaleOrder.getCmdSaleOrderDiscount());
        saleOrder.setTotalPriceTTC(cmdSaleOrder.getCmdSaleOrderTotalPriceTTC());
        saleOrder.setTotalPriceHT(cmdSaleOrder.getCmdSaleOrderTotalPriceHT());
        saleOrder.setVat(cmdSaleOrder.getCmdSaleOrderVat());
        saleOrder.setActive(cmdSaleOrder.getCmdSaleOrderActive());
        saleOrder.setAccounted(cmdSaleOrder.getCmdSaleOrderAccounted());
        saleOrder.setPayedAmount(cmdSaleOrder.getCmdSaleOrderPayedAmount());
        saleOrder.setUpdatedBy(cmdSaleOrder.getUpdatedBy());
        saleOrder.setCreatedBy(cmdSaleOrder.getCreatedBy());
        saleOrder.setTotalPriceHTDefaultCurrency(cmdSaleOrder.getCmdSaleOrderTotalPriceHTDefaultCurrency());
        saleOrder.setTotalPriceTTCDefaultCurrency(cmdSaleOrder.getCmdSaleOrderTotalPriceTTCDefaultCurrency());
        saleOrder.setVatDefaultCurrency(cmdSaleOrder.getCmdSaleOrderVatDefaultCurrency());
        saleOrder.setExchangeRate(cmdSaleOrder.getCmdSaleOrderExchangeRate());
        saleOrder.setGmao(cmdSaleOrder.getCmdSaleOrderGmao());


        if (!lazy) {

            saleOrder.setAccount(AccountMapper.toDto(cmdSaleOrder.getCmdAccount(), false));
            saleOrder.setOrderStatus(OrderStatusMapper.toDto(cmdSaleOrder.getPrmOrderStatus(), true));
            saleOrder.setOrderType(OrderTypeMapper.toDto(cmdSaleOrder.getPrmOrderType(), true));
            saleOrder.setOwner(OwnerMapper.toDto(cmdSaleOrder.getOwnOwner(), true));
            saleOrder.setDeliveryAddress(AddressInfoMapper.toDto(cmdSaleOrder.getDeliveryAddress(), true));
            saleOrder.setInvoiceAddress(AddressInfoMapper.toDto(cmdSaleOrder.getInvoiceAddress(), true));
            saleOrder.setSupplier(SupplierMapper.toDto(cmdSaleOrder.getRcpSupplier(), true));
            saleOrder.setTransport(TransportMapper.toDto(cmdSaleOrder.getTrpTransport(), true));
            saleOrder.setWarehouse(WarehouseMapper.toDto(cmdSaleOrder.getWrhWarehouseSource(), true));
            saleOrder.setWarehouseDestination(WarehouseMapper.toDto(cmdSaleOrder.getWrhWarehouseDestination(), true));
            //saleOrder.setLines(SaleOrderLineMapper.toDtos(cmdSaleOrder.getCmdSaleOrderLines(), true));

        }
        return saleOrder;
    }

    public static CmdSaleOrder toEntity(SaleOrder saleOrder, boolean lazy) {
        if (null == saleOrder) {
            return null;
        }
        CmdSaleOrder cmdSaleOrder = new CmdSaleOrder();
        cmdSaleOrder.setCmdSaleOrderId(saleOrder.getId());

        cmdSaleOrder.setCmdSaleOrderCode(saleOrder.getCode() != null ? saleOrder.getCode().toUpperCase() : null);
        cmdSaleOrder.setCmdSaleOrderContainers(saleOrder.getContainers());
        cmdSaleOrder.setCmdSaleOrderCreationDate(saleOrder.getCreationDate());
        cmdSaleOrder.setCmdSaleOrderCustomerCode(saleOrder.getCustomerCode());
        cmdSaleOrder.setCmdSaleOrderDescription(saleOrder.getDescription());
        cmdSaleOrder.setCmdSaleOrderExpectedDate(saleOrder.getExpectedDate());
        cmdSaleOrder.setCmdSaleOrderId(saleOrder.getId());
        cmdSaleOrder.setCmdSaleOrderImmatriculation(saleOrder.getImmatriculation());
        cmdSaleOrder.setCmdSaleOrderLoadDate(saleOrder.getLoadDate());
        cmdSaleOrder.setCmdSaleOrderRemarks(saleOrder.getRemarks());
        cmdSaleOrder.setCmdSaleOrderTransportContact(saleOrder.getTransportContact());
        cmdSaleOrder.setUpdateDate(saleOrder.getUpdateDate());
        cmdSaleOrder.setCmdSaleOrderVariable1(saleOrder.getVariable1());
        cmdSaleOrder.setCmdSaleOrderVariable2(saleOrder.getVariable2());
        cmdSaleOrder.setCmdSaleOrderVariable3(saleOrder.getVariable3());
        cmdSaleOrder.setCmdSaleOrderVariable4(saleOrder.getVariable4());
        cmdSaleOrder.setCmdSaleOrderVariable5(saleOrder.getVariable5());
        cmdSaleOrder.setCmdSaleOrderVariable6(saleOrder.getVariable6());
        cmdSaleOrder.setCmdSaleOrderVariable7(saleOrder.getVariable7());
        cmdSaleOrder.setCmdSaleOrderVariable8(saleOrder.getVariable8());
        cmdSaleOrder.setCmdSaleOrderVariable9(saleOrder.getVariable9());
        cmdSaleOrder.setCmdSaleOrderVariable10(saleOrder.getVariable10());
        cmdSaleOrder.setCmdSaleOrderTransportTel(saleOrder.getTransportTel());
        cmdSaleOrder.setCmdSaleOrderTransfertCode(saleOrder.getTransfertCode());
        cmdSaleOrder.setCmdSaleOrderSendedToWms(saleOrder.getSendedToWms());
        cmdSaleOrder.setCmdSaleOrderTotalPriceHT(saleOrder.getTotalPriceHT());
        cmdSaleOrder.setCmdSaleOrderTotalPriceTTC(saleOrder.getTotalPriceTTC());
        cmdSaleOrder.setCmdSaleOrderDiscount(saleOrder.getDiscount());
        cmdSaleOrder.setCmdSaleOrderVat(saleOrder.getVat());
        cmdSaleOrder.setCmdSaleOrderActive(saleOrder.getActive());
        cmdSaleOrder.setCmdSaleOrderAccounted(saleOrder.getAccounted());
        cmdSaleOrder.setCmdSaleOrderPayedAmount(saleOrder.getPayedAmount());
        cmdSaleOrder.setUpdatedBy(saleOrder.getUpdatedBy());
        cmdSaleOrder.setCreatedBy(saleOrder.getCreatedBy());
        cmdSaleOrder.setCmdSaleOrderTotalPriceHTDefaultCurrency(saleOrder.getTotalPriceHTDefaultCurrency());
        cmdSaleOrder.setCmdSaleOrderTotalPriceTTCDefaultCurrency(saleOrder.getTotalPriceTTCDefaultCurrency());
        cmdSaleOrder.setCmdSaleOrderVatDefaultCurrency(saleOrder.getVatDefaultCurrency());
        cmdSaleOrder.setCmdSaleOrderExchangeRate(saleOrder.getExchangeRate());
        cmdSaleOrder.setCmdSaleOrderGmao(saleOrder.getGmao());


        if (!lazy) {

            cmdSaleOrder.setCmdAccount(AccountMapper.toEntity(saleOrder.getAccount(), true));
            cmdSaleOrder.setCmdSaleOrderLines(SaleOrderLineMapper.toEntities(saleOrder.getLines(), false));
            cmdSaleOrder.setDeliveryAddress(AddressInfoMapper.toEntity(saleOrder.getDeliveryAddress(), false));
            cmdSaleOrder.setInvoiceAddress(AddressInfoMapper.toEntity(saleOrder.getInvoiceAddress(), true));
            cmdSaleOrder.setOwnOwner(OwnerMapper.toEntity(saleOrder.getOwner(), true));
            cmdSaleOrder.setPrmOrderStatus(OrderStatusMapper.toEntity(saleOrder.getOrderStatus(), true));
            cmdSaleOrder.setPrmOrderType(OrderTypeMapper.toEntity(saleOrder.getOrderType(), true));
            cmdSaleOrder.setRcpSupplier(SupplierMapper.toEntity(saleOrder.getSupplier(), true));
            cmdSaleOrder.setTrpTransport(TransportMapper.toEntity(saleOrder.getTransport(), true));
            cmdSaleOrder.setWrhWarehouseSource(WarehouseMapper.toEntity(saleOrder.getWarehouse(), true));
            cmdSaleOrder.setWrhWarehouseDestination(WarehouseMapper.toEntity(saleOrder.getWarehouseDestination(), true));
            cmdSaleOrder.setCmdSaleOrderLines(SaleOrderLineMapper.toEntities(saleOrder.getLines(), true));

        }
        return cmdSaleOrder;
    }



    public static List<SaleOrder> toDtos(List<CmdSaleOrder> cmdSaleOrders, boolean lazy) {
        if (null == cmdSaleOrders) {
            return null;
        }
        List<SaleOrder> saleOrders = new ArrayList<>();
        for (CmdSaleOrder cmdsaleOrder : cmdSaleOrders) {
            saleOrders.add(toDto(cmdsaleOrder, lazy));
        }
        return saleOrders;
    }

    public static List<SaleOrder> toDtos(Iterable< ? extends CmdSaleOrder> cmdSaleOrders, boolean lazy) {
        if (null == cmdSaleOrders) {
            return null;
        }
        List<SaleOrder> saleOrders = new ArrayList<>();
        for (CmdSaleOrder cmdsaleOrder : cmdSaleOrders) {
            saleOrders.add(toDto(cmdsaleOrder, lazy));
        }
        return saleOrders;
    }


    public static Set<CmdSaleOrder> toEntities(List<SaleOrder> saleOrders, boolean lazy) {
        if (null == saleOrders) {
            return null;
        }
        Set<CmdSaleOrder> cmdSaleOrders = new HashSet<>();
        for (SaleOrder SaleOrder : saleOrders) {
            cmdSaleOrders.add(toEntity(SaleOrder, lazy));
        }
        return cmdSaleOrders;
    }

   


}

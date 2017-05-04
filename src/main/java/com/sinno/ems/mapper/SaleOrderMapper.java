/**
 *
 */
package com.sinno.ems.mapper;

import com.sinno.ems.dto.SaleOrder;
import com.sinno.ems.entities.CmdSaleOrder;
import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * @author aelguezzar
 */
public class SaleOrderMapper {
    private SaleOrderMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdSaleOrderId");
        map.put("account", "cmdAccount");
        map.put("owner", "ownOwner");
        map.put("addressBySaleOrderDeliveryAddress", "adrAddressByCmdSaleOrderDeliveryAddressId");
        map.put("addressBySaleOrderInvoiceAddress", "adrAddressByCmdSaleOrderInvoiceAddressId");
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
        map.put("numberLine", "cmdSaleOrderNumberLine");
        map.put("numberLineCmd", "cmdSaleOrderNumberLineCmd");
        map.put("transportTel", "cmdSaleOrderTransportTel");
        map.put("transfertCode", "cmdSaleOrderTransferCode");
        map.put("devis", "cmdDevis");
        map.put("currency", "prmCurrency");
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
        saleOrder.setUpdateDate(cmdSaleOrder.getCmdSaleOrderUpdateDate());
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
        saleOrder.setCmdSaleOrderNumberLine(cmdSaleOrder.getCmdSaleOrderNumberLine());
        saleOrder.setCmdSaleOrderNumberLineCmd(cmdSaleOrder.getCmdSaleOrderNumberLineCmd());
        saleOrder.setTransportTel(cmdSaleOrder.getCmdSaleOrderTransportTel());
        saleOrder.setTransfertCode(cmdSaleOrder.getCmdSaleOrderTransfertCode());
        saleOrder.setSendedToWms(cmdSaleOrder.getCmdSaleOrderSendedToWms());
        saleOrder.setDiscount(cmdSaleOrder.getCmdSaleOrderDiscount());
        saleOrder.setTotalPriceTTC(cmdSaleOrder.getCmdSaleOrderTotalPriceTTC());
        saleOrder.setTotalPriceHT(cmdSaleOrder.getCmdSaleOrderTotalPriceHT());
        saleOrder.setVat(cmdSaleOrder.getCmdSaleOrderVat());
        if (!lazy) {
            saleOrder.setCurrency(CurrencyMapper.toDto(cmdSaleOrder.getPrmCurrency(), true));
            saleOrder.setLines(SaleOrderLineMapper.toDtos(cmdSaleOrder.getCmdSaleOrderLines(), false));
            saleOrder.setAccount(AccountMapper.toDto(cmdSaleOrder.getCmdAccount(), true));
            saleOrder.setOrderStatus(OrderStatusMapper.toDto(cmdSaleOrder.getPrmOrderStatus(), true));
            saleOrder.setOrderType(OrderTypeMapper.toDto(cmdSaleOrder.getPrmOrderType(), true));
            saleOrder.setOwner(OwnerMapper.toDto(cmdSaleOrder.getOwnOwner(), true));
//            saleOrder.setStockArcs(SaleOrderStockArcMapper.toDtos(cmdSaleOrder.getCmdSaleOrderStockArcs(), true));
//            saleOrder.setStockReserveds(StockReservedMapper.toDtos(cmdSaleOrder.getStkStockReserveds(), true));
//            saleOrder.setStocks(SaleOrderStockMapper.toDtos(cmdSaleOrder.getCmdSaleOrderStocks(), true));
            saleOrder.setAddressBySaleOrderDeliveryAddress(AddressMapper.toDto(cmdSaleOrder.getAdrAddressByCmdSaleOrderDeliveryAddressId(), true));
            saleOrder.setAddressBySaleOrderInvoiceAddress(AddressMapper.toDto(cmdSaleOrder.getAdrAddressByCmdSaleOrderInvoiceAddressId(), true));
            saleOrder.setSupplier(SupplierMapper.toDto(cmdSaleOrder.getRcpSupplier(), true));
            saleOrder.setTransport(TransportMapper.toDto(cmdSaleOrder.getTrpTransport(), true));
            saleOrder.setWarehouse(WarehouseMapper.toDto(cmdSaleOrder.getWrhWarehouseSource(), true));
            saleOrder.setWarehouseDestination(WarehouseMapper.toDto(cmdSaleOrder.getWrhWarehouseDestination(), true));
            saleOrder.setDevis(DevisMapper.toDto(cmdSaleOrder.getCmdDevis(), true));
            saleOrder.setUser(UserMapper.toDto(cmdSaleOrder.getUsrUser(), true));
        }
        return saleOrder;
    }

    public static CmdSaleOrder toEntity(SaleOrder saleOrder, boolean lazy) {
        if (null == saleOrder) {
            return null;
        }
        CmdSaleOrder cmdSaleOrder = new CmdSaleOrder();
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
        cmdSaleOrder.setCmdSaleOrderUpdateDate(saleOrder.getUpdateDate());
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
        cmdSaleOrder.setCmdSaleOrderNumberLineCmd(saleOrder.getCmdSaleOrderNumberLineCmd());
        cmdSaleOrder.setCmdSaleOrderNumberLine(saleOrder.getCmdSaleOrderNumberLine());
        cmdSaleOrder.setCmdSaleOrderTransportTel(saleOrder.getTransportTel());
        cmdSaleOrder.setCmdSaleOrderTransfertCode(saleOrder.getTransfertCode());
        cmdSaleOrder.setCmdSaleOrderSendedToWms(saleOrder.getSendedToWms());
        cmdSaleOrder.setCmdSaleOrderTotalPriceHT(saleOrder.getTotalPriceHT());
        cmdSaleOrder.setCmdSaleOrderTotalPriceTTC(saleOrder.getTotalPriceTTC());
        cmdSaleOrder.setCmdSaleOrderDiscount(saleOrder.getDiscount());
        cmdSaleOrder.setCmdSaleOrderVat(saleOrder.getVat());
        if (!lazy) {
            cmdSaleOrder.setPrmCurrency(CurrencyMapper.toEntity(saleOrder.getCurrency(), true));
            cmdSaleOrder.setUsrUser(UserMapper.toEntity(saleOrder.getUser(), true));
            cmdSaleOrder.setCmdAccount(AccountMapper.toEntity(saleOrder.getAccount(), true));
            cmdSaleOrder.setCmdSaleOrderLines(SaleOrderLineMapper.toEntities(saleOrder.getLines(), false));
//            cmdSaleOrder.setCmdSaleOrderStockArcs(SaleOrderStockArcMapper.toEntities(saleOrder.getStockArcs(), true));
//            cmdSaleOrder.setCmdSaleOrderStocks(SaleOrderStockMapper.toEntities(saleOrder.getStocks(), true));
            cmdSaleOrder.setAdrAddressByCmdSaleOrderDeliveryAddressId(AddressMapper.toEntity(saleOrder.getAddressBySaleOrderDeliveryAddress(), true));
            cmdSaleOrder.setAdrAddressByCmdSaleOrderInvoiceAddressId(AddressMapper.toEntity(saleOrder.getAddressBySaleOrderInvoiceAddress(), true));
            cmdSaleOrder.setOwnOwner(OwnerMapper.toEntity(saleOrder.getOwner(), true));
            cmdSaleOrder.setPrmOrderStatus(OrderStatusMapper.toEntity(saleOrder.getOrderStatus(), true));
            cmdSaleOrder.setPrmOrderType(OrderTypeMapper.toEntity(saleOrder.getOrderType(), true));
            cmdSaleOrder.setRcpSupplier(SupplierMapper.toEntity(saleOrder.getSupplier(), true));
            //cmdSaleOrder.setStkStockReserveds(StockReservedMapper.toEntities(saleOrder.getStockReserveds(), true));
            cmdSaleOrder.setTrpTransport(TransportMapper.toEntity(saleOrder.getTransport(), true));
            cmdSaleOrder.setWrhWarehouseSource(WarehouseMapper.toEntity(saleOrder.getWarehouse(), true));
            cmdSaleOrder.setWrhWarehouseDestination(WarehouseMapper.toEntity(saleOrder.getWarehouseDestination(), true));
            cmdSaleOrder.setCmdDevis(DevisMapper.toEntity(saleOrder.getDevis(), true));
            oneToMany(cmdSaleOrder);
        }
        return cmdSaleOrder;
    }

    public static void oneToMany(CmdSaleOrder saleOrder) {
        if (null != saleOrder.getCmdSaleOrderLines()) {
            saleOrder.getCmdSaleOrderLines().stream().forEach(sl -> {
                sl.setCmdSaleOrder(saleOrder);
                sl.setOwnOwner(saleOrder.getOwnOwner());
                sl.setCmdSaleOrderLineUpdateDate(EmsDate.getDateNow());
                if (0 >= sl.getCmdSaleOrderLineId()) {
                    sl.setCmdSaleOrderLineCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static List<SaleOrder> toDtos(List<CmdSaleOrder> cmdSaleOrders, boolean lazy) {
        if (null == cmdSaleOrders) {
            return null;
        }
        List<SaleOrder> saleOrders = new ArrayList<>();
        for (CmdSaleOrder cmdSaleOrder : cmdSaleOrders) {
            saleOrders.add(toDto(cmdSaleOrder, lazy));
        }
        return saleOrders;
    }

    public static List<SaleOrder> toDtos(Iterable<CmdSaleOrder> cmdSaleOrders, boolean lazy) {
        if (null == cmdSaleOrders) {
            return null;
        }
        List<SaleOrder> saleOrders = new ArrayList<>();
        for (CmdSaleOrder cmdSaleOrder : cmdSaleOrders) {
            saleOrders.add(toDto(cmdSaleOrder, lazy));
        }
        return saleOrders;
    }

    public static Set<CmdSaleOrder> toEntities(Set<SaleOrder> saleOrders, boolean lazy) {
        if (null == saleOrders) {
            return null;
        }
        Set<CmdSaleOrder> cmdSaleOrders = new HashSet<>();
        for (SaleOrder saleOrder : saleOrders) {
            cmdSaleOrders.add(toEntity(saleOrder, lazy));
        }
        return cmdSaleOrders;
    }

    public static Set<SaleOrder> toDtos(Set<CmdSaleOrder> cmdSaleOrders, boolean lazy) {
        if (null == cmdSaleOrders) {
            return null;
        }
        Set<SaleOrder> saleOrders = new HashSet<>();
        for (CmdSaleOrder cmdSaleOrder : cmdSaleOrders) {
            saleOrders.add(toDto(cmdSaleOrder, lazy));
        }
        return saleOrders;
    }

}

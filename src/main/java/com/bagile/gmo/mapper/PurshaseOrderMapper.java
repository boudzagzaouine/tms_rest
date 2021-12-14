package com.bagile.gmo.mapper;


import com.bagile.gmo.dto.PurshaseOrder;
import com.bagile.gmo.entities.RcpPurshaseOrder;
import com.bagile.gmo.util.EmsDate;

import java.util.*;

public class PurshaseOrderMapper {
    public PurshaseOrderMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "rcpPurshaseOrderId");
        map.put("owner", "ownOwner");
        map.put("address", "adrAddress");
        map.put("orderStatus", "prmOrderStatus");
        map.put("orderType", "prmOrderType");
        map.put("transport", "trpTransport");
        map.put("code", "rcpPurshaseOrderCode");
        map.put("remarks", "rcpPurshaseOrderRemarks");
        map.put("supplierOrderCode", "rcpPurshaseOrderSupplierOrderCode");
        map.put("description", "rcpPurshaseOrderDescription");
        map.put("expectedDate", "rcpPurshaseOrderExpectedDate");
        map.put("receptionDate", "rcpPurshaseOrderReceptionDate");
        map.put("containers", "rcpPurshaseOrderContainers");
        map.put("warehouseSource", "wrhWarehouseSource");
        map.put("warehouse", "wrhWarehouseDestination");
        map.put("transportContact", "rcpPurshaseOrderTransportContact");
        map.put("immatriculation", "rcpPurshaseOrderImmatriculation");
        map.put("telContact", "rcpPurshaseOrderTelContact");
        map.put("creationDate", "rcpPurshaseOrderCreationDate");
        map.put("updateDate", "rcpPurshaseOrderUpdateDate");
        map.put("variable1", "rcpPurshaseOrderVariable1");
        map.put("variable2", "rcpPurshaseOrderVariable2");
        map.put("variable3", "rcpPurshaseOrderVariable3");
        map.put("variable4", "rcpPurshaseOrderVariable4");
        map.put("variable5", "rcpPurshaseOrderVariable5");
        map.put("variable6", "rcpPurshaseOrderVariable6");
        map.put("variable7", "rcpPurshaseOrderVariable7");
        map.put("variable8", "rcpPurshaseOrderVariable8");
        map.put("variable9", "rcpPurshaseOrderVariable9");
        map.put("variable10", "rcpPurshaseOrderVariable10");
        map.put("supplier", "rcpSupplier");
        map.put("cmdType", "rcpPurshaseOrderCmdType");
        map.put("accountOrderCode", "rcpPurshaseOrderAccountOrderCode");
        map.put("transfertCode", "rcpPurshaseOrderTransfertCode");
        map.put("totalPriceHT", "rcpPurshaseOrderTotalPriceHt");
        map.put("totalPriceTTC", "rcpPurshaseOrderTotalPriceTTC");
        map.put("accounted", "rcpPurshaseOrderAccounted");
        map.put("active", "rcpPurshaseOrderActive");
        map.put("discount", "rcpPurshaseOrderDiscount");
        map.put("vat","rcpPurshaseOrderVat");
        map.put("currency", "prmCurrency");
        map.put("saleOrder", "cmdSaleOrder");
        map.put("paymentStatus", "prmPaymentStatus");
        map.put("box", "usrBox");
        map.put("deal", "cmdDeal");
        map.put("account", "cmdAccount");
        map.put("notes", "rcpPurshaseOrdernotes");
        map.put("gmao", "rcpPurshaseOrderGmao");


    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static RcpPurshaseOrder toEntity(PurshaseOrder purshaseOrder, boolean lazy) {
        if (null == purshaseOrder) {
            return null;
        }
        RcpPurshaseOrder rcpPurshaseOrder = new RcpPurshaseOrder();
        rcpPurshaseOrder.setRcpPurshaseOrderId(purshaseOrder.getId());
        rcpPurshaseOrder.setRcpPurshaseOrderCode(purshaseOrder.getCode() != null ? purshaseOrder.getCode().toUpperCase() : null);
        rcpPurshaseOrder.setRcpPurshaseOrderRemarks(purshaseOrder.getRemarks());
        rcpPurshaseOrder.setRcpPurshaseOrderSupplierOrderCode(purshaseOrder.getSupplierOrderCode());
        rcpPurshaseOrder.setRcpPurshaseOrderTransportContact(purshaseOrder.getTransportContact());
        rcpPurshaseOrder.setRcpPurshaseOrderDescription(purshaseOrder.getDescription());
        rcpPurshaseOrder.setRcpPurshaseOrderExpectedDate(purshaseOrder.getExpectedDate());
        rcpPurshaseOrder.setRcpPurshaseOrderReceptionDate(purshaseOrder.getReceptionDate());
        rcpPurshaseOrder.setRcpPurshaseOrderContainers(purshaseOrder.getContainers());
        rcpPurshaseOrder.setRcpPurshaseOrderImmatriculation(purshaseOrder.getImmatriculation());
        rcpPurshaseOrder.setRcpPurshaseOrderTelContact(purshaseOrder.getTelContact());
        rcpPurshaseOrder.setRcpPurshaseOrderCreationDate(purshaseOrder.getCreationDate());
        rcpPurshaseOrder.setRcpPurshaseOrderUpdateDate(purshaseOrder.getUpdateDate());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable1(purshaseOrder.getVariable1());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable2(purshaseOrder.getVariable2());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable3(purshaseOrder.getVariable3());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable4(purshaseOrder.getVariable4());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable5(purshaseOrder.getVariable5());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable6(purshaseOrder.getVariable6());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable7(purshaseOrder.getVariable7());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable8(purshaseOrder.getVariable8());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable9(purshaseOrder.getVariable9());
        rcpPurshaseOrder.setRcpPurshaseOrderVariable10(purshaseOrder.getVariable10());
        rcpPurshaseOrder.setRcpPurshaseOrderCmdType(purshaseOrder.getCmdType());
        rcpPurshaseOrder.setRcpPurshaseOrderAccountOrderCode(purshaseOrder.getAccountOrderCode());
        rcpPurshaseOrder.setRcpPurshaseOrderTransfertCode(purshaseOrder.getTransfertCode());
        rcpPurshaseOrder.setRcpPurshaseOrderTotalPriceTTC(purshaseOrder.getTotalPriceTTC());
        rcpPurshaseOrder.setRcpPurshaseOrderTotalPriceHT(purshaseOrder.getTotalPriceHT());
        rcpPurshaseOrder.setRcpPurshaseOrderVat(purshaseOrder.getVat());
        rcpPurshaseOrder.setRcpPurshaseOrderDiscount(purshaseOrder.getDiscount());
        rcpPurshaseOrder.setRcpPurshaseOrderActive(purshaseOrder.getActive());
        rcpPurshaseOrder.setRcpPurshaseOrderAccounted(purshaseOrder.getAccounted());
        rcpPurshaseOrder.setRcpPurshaseOrderPayedAmount(purshaseOrder.getPayedAmount());
        rcpPurshaseOrder.setUpdatedBy(purshaseOrder.getUpdatedBy());
        rcpPurshaseOrder.setCreatedBy(purshaseOrder.getCreatedBy());
        rcpPurshaseOrder.setRcpPurshaseTotalPriceHTDefaultCurrency(purshaseOrder.getTotalPriceHTDefaultCurrency());
        rcpPurshaseOrder.setRcpPurshaseTotalPriceTTCDefaultCurrency(purshaseOrder.getTotalPriceTTCDefaultCurrency());
        rcpPurshaseOrder.setRcpPurshaseVatDefaultCurrency(purshaseOrder.getVatDefaultCurrency());
        rcpPurshaseOrder.setRcpPurshaseExchangeRate(purshaseOrder.getExchangeRate());
        rcpPurshaseOrder.setRcpPurshaseOrderProvisionalCost(purshaseOrder.getProvisionalCost());
        rcpPurshaseOrder.setRcpPurshaseOrderExtraCost(purshaseOrder.getExtraCost());
        rcpPurshaseOrder.setRcpPurshaseOrdernotes(purshaseOrder.getNotes());
        rcpPurshaseOrder.setRcpPurshaseOrderGmao(purshaseOrder.getGmao());

        if (!lazy) {
          //  rcpPurshaseOrder.setPrmPaymentStatus(PaymentStatusMapper.toEntity(purshaseOrder.getPaymentStatus(),true));
            rcpPurshaseOrder.setRcpSupplier(SupplierMapper.toEntity(purshaseOrder.getSupplier(), false));
         //   rcpPurshaseOrder.setRcpExtraCosts(ExtraCostMapper.toEntities(purshaseOrder.getExtraCosts(), true));
            rcpPurshaseOrder.setWrhWarehouseSource(WarehouseMapper.toEntity(purshaseOrder.getWarehouseSource(), true));
            rcpPurshaseOrder.setWrhWarehouseDestination(WarehouseMapper.toEntity(purshaseOrder.getWarehouse(), true));
           // rcpPurshaseOrder.setPrmCurrency(CurrencyMapper.toEntity(purshaseOrder.getCurrency(), true));
            rcpPurshaseOrder.setOwnOwner(OwnerMapper.toEntity(purshaseOrder.getOwner(), true));
            rcpPurshaseOrder.setTrpTransport(TransportMapper.toEntity(purshaseOrder.getTransport(), true));
            rcpPurshaseOrder.setAdrAddress(AddressInfoMapper.toEntity(purshaseOrder.getAddress(), true));
            rcpPurshaseOrder.setTrpTransport(TransportMapper.toEntity(purshaseOrder.getTransport(), true));
            rcpPurshaseOrder.setPrmOrderStatus(OrderStatusMapper.toEntity(purshaseOrder.getOrderStatus(), true));
            rcpPurshaseOrder.setPrmOrderType(OrderTypeMapper.toEntity(purshaseOrder.getOrderType(), true));
            rcpPurshaseOrder.setRcpPurshaseOrderLines(PurshaseOrderLineMapper.toEntities(purshaseOrder.getPurshaseOrderLines(), false));
            rcpPurshaseOrder.setCmdSaleOrder(SaleOrderMapper.toEntity(purshaseOrder.getSaleOrder(), false));
           // rcpPurshaseOrder.setRcpBillingTerms(BillingTermPurshaseMapper.toEntities(purshaseOrder.getBillingTermPurshases(), false));
          //  rcpPurshaseOrder.setUsrBox(BoxMapper.toEntity(purshaseOrder.getBox(), true));
          //  rcpPurshaseOrder.setCmdDeal(DealMapper.toEntity(purshaseOrder.getDeal(), true));
            rcpPurshaseOrder.setCmdAccount(AccountMapper.toEntity(purshaseOrder.getAccount(), true));
            oneToMany(rcpPurshaseOrder);
        }
        return rcpPurshaseOrder;
    }

    public static void oneToMany(RcpPurshaseOrder purshaseOrder) {
       if (null != purshaseOrder.getRcpPurshaseOrderLines()) {
            purshaseOrder.getRcpPurshaseOrderLines().forEach(pl -> {
                pl.setRcpPurshaseOrder(purshaseOrder);
                pl.setRcpPurshaseOrderLineUpdateDate(EmsDate.getDateNow());
              /*  if (0 >= pl.getRcpPurshaseOrderLineId()) {
                    pl.setRcpPurshaseOrderLineId(0);
                    pl.setRcpPurshaseOrderLineCreationDate(EmsDate.getDateNow());
                    pl.setOwnOwner(purshaseOrder.getOwnOwner());
                }*/
            });
          /*  if (purshaseOrder.getRcpBillingTerms() !=  null) {
            purshaseOrder.getRcpBillingTerms().forEach(pl -> {
                pl.setRcpPurshaseOrder(purshaseOrder);
                pl.setRcpBillingTermUpdateDate(EmsDate.getDateNow());
                if (0 >= pl.getRcpBillingTermId()) {
                    pl.setRcpBillingTermId(0);
                    pl.setRcpBillingTermCreationDate(EmsDate.getDateNow());
                }
            });
            }*/
        }
    }

    public static PurshaseOrder toDto(RcpPurshaseOrder rcpPurshaseOrder, boolean lazy) {
        if (null == rcpPurshaseOrder) {
            return null;
        }
        PurshaseOrder purshaseOrder = new PurshaseOrder();
        purshaseOrder.setId(rcpPurshaseOrder.getRcpPurshaseOrderId());
        purshaseOrder.setCode(rcpPurshaseOrder.getRcpPurshaseOrderCode());
        purshaseOrder.setRemarks(rcpPurshaseOrder.getRcpPurshaseOrderRemarks());
        purshaseOrder.setSupplierOrderCode(rcpPurshaseOrder.getRcpPurshaseOrderSupplierOrderCode());
        purshaseOrder.setTransportContact(rcpPurshaseOrder.getRcpPurshaseOrderTransportContact());
        purshaseOrder.setDescription(rcpPurshaseOrder.getRcpPurshaseOrderDescription());//
        purshaseOrder.setExpectedDate(rcpPurshaseOrder.getRcpPurshaseOrderExpectedDate());
        purshaseOrder.setReceptionDate(rcpPurshaseOrder.getRcpPurshaseOrderReceptionDate());
        purshaseOrder.setContainers(rcpPurshaseOrder.getRcpPurshaseOrderContainers());
        purshaseOrder.setImmatriculation(rcpPurshaseOrder.getRcpPurshaseOrderImmatriculation());
        purshaseOrder.setTelContact(rcpPurshaseOrder.getRcpPurshaseOrderTelContact());
        purshaseOrder.setCreationDate(rcpPurshaseOrder.getRcpPurshaseOrderCreationDate());
        purshaseOrder.setUpdateDate(rcpPurshaseOrder.getRcpPurshaseOrderUpdateDate());
        purshaseOrder.setVariable1(rcpPurshaseOrder.getRcpPurshaseOrderVariable1());
        purshaseOrder.setVariable2(rcpPurshaseOrder.getRcpPurshaseOrderVariable2());
        purshaseOrder.setVariable3(rcpPurshaseOrder.getRcpPurshaseOrderVariable3());
        purshaseOrder.setVariable4(rcpPurshaseOrder.getRcpPurshaseOrderVariable4());
        purshaseOrder.setVariable5(rcpPurshaseOrder.getRcpPurshaseOrderVariable5());
        purshaseOrder.setVariable6(rcpPurshaseOrder.getRcpPurshaseOrderVariable6());
        purshaseOrder.setVariable7(rcpPurshaseOrder.getRcpPurshaseOrderVariable7());
        purshaseOrder.setVariable8(rcpPurshaseOrder.getRcpPurshaseOrderVariable8());
        purshaseOrder.setVariable9(rcpPurshaseOrder.getRcpPurshaseOrderVariable9());
        purshaseOrder.setVariable10(rcpPurshaseOrder.getRcpPurshaseOrderVariable10());
        purshaseOrder.setCmdType(rcpPurshaseOrder.getRcpPurshaseOrderCmdType());
        purshaseOrder.setAccountOrderCode(rcpPurshaseOrder.getRcpPurshaseOrderAccountOrderCode());
        purshaseOrder.setTransfertCode(rcpPurshaseOrder.getRcpPurshaseOrderTransfertCode());
        purshaseOrder.setTotalPriceHT(rcpPurshaseOrder.getRcpPurshaseOrderTotalPriceHT());
        purshaseOrder.setTotalPriceTTC(rcpPurshaseOrder.getRcpPurshaseOrderTotalPriceTTC());
        purshaseOrder.setDiscount(rcpPurshaseOrder.getRcpPurshaseOrderDiscount());
        purshaseOrder.setVat(rcpPurshaseOrder.getRcpPurshaseOrderVat());
        purshaseOrder.setActive(rcpPurshaseOrder.getRcpPurshaseOrderActive());
        purshaseOrder.setAccounted(rcpPurshaseOrder.getRcpPurshaseOrderAccounted());
        purshaseOrder.setPayedAmount(rcpPurshaseOrder.getRcpPurshaseOrderPayedAmount());
        purshaseOrder.setUpdatedBy(rcpPurshaseOrder.getUpdatedBy());
        purshaseOrder.setCreatedBy(rcpPurshaseOrder.getCreatedBy());
        purshaseOrder.setTotalPriceHTDefaultCurrency(rcpPurshaseOrder.getRcpPurshaseTotalPriceHTDefaultCurrency());
        purshaseOrder.setTotalPriceTTCDefaultCurrency(rcpPurshaseOrder.getRcpPurshaseTotalPriceTTCDefaultCurrency());
        purshaseOrder.setVatDefaultCurrency(rcpPurshaseOrder.getRcpPurshaseVatDefaultCurrency());
        purshaseOrder.setExchangeRate(rcpPurshaseOrder.getRcpPurshaseExchangeRate());
        purshaseOrder.setProvisionalCost(rcpPurshaseOrder.getRcpPurshaseOrderProvisionalCost());
        purshaseOrder.setExtraCost(rcpPurshaseOrder.getRcpPurshaseOrderExtraCost());
        purshaseOrder.setNotes(rcpPurshaseOrder.getRcpPurshaseOrdernotes());
        purshaseOrder.setGmao(rcpPurshaseOrder.getRcpPurshaseOrderGmao());

        if (!lazy) {
           // purshaseOrder.setPaymentStatus(PaymentStatusMapper.toDto(rcpPurshaseOrder.getPrmPaymentStatus(),true));
            purshaseOrder.setSupplier(SupplierMapper.toDto(rcpPurshaseOrder.getRcpSupplier(), false));
         //   purshaseOrder.setExtraCosts(ExtraCostMapper.toDtos(rcpPurshaseOrder.getRcpExtraCosts(), true));
            purshaseOrder.setWarehouseSource(WarehouseMapper.toDto(rcpPurshaseOrder.getWrhWarehouseSource(), true));
            purshaseOrder.setWarehouse(WarehouseMapper.toDto(rcpPurshaseOrder.getWrhWarehouseDestination(), true));
            purshaseOrder.setOwner(OwnerMapper.toDto(rcpPurshaseOrder.getOwnOwner(), true));
            purshaseOrder.setTransport(TransportMapper.toDto(rcpPurshaseOrder.getTrpTransport(), true));
            purshaseOrder.setAddress(AddressInfoMapper.toDto(rcpPurshaseOrder.getAdrAddress(), true));
            purshaseOrder.setTransport(TransportMapper.toDto(rcpPurshaseOrder.getTrpTransport(), true));
            purshaseOrder.setOrderStatus(OrderStatusMapper.toDto(rcpPurshaseOrder.getPrmOrderStatus(), true));
            purshaseOrder.setOrderType(OrderTypeMapper.toDto(rcpPurshaseOrder.getPrmOrderType(), true));
           // purshaseOrder.setCurrency(CurrencyMapper.toDto(rcpPurshaseOrder.getPrmCurrency(), true));
            purshaseOrder.setPurshaseOrderLines(PurshaseOrderLineMapper.toDtos(rcpPurshaseOrder.getRcpPurshaseOrderLines(), false));
         //   purshaseOrder.setBillingTermPurshases(BillingTermPurshaseMapper.toDtos(rcpPurshaseOrder.getRcpBillingTerms(), false));
            purshaseOrder.setSaleOrder(SaleOrderMapper.toDto(rcpPurshaseOrder.getCmdSaleOrder(), false));
         //   purshaseOrder.setBox(BoxMapper.toDto(rcpPurshaseOrder.getUsrBox(), true));
         //   purshaseOrder.setDeal(DealMapper.toDto(rcpPurshaseOrder.getCmdDeal(), true));
            purshaseOrder.setAccount(AccountMapper.toDto(rcpPurshaseOrder.getCmdAccount(), true));
        }
        return purshaseOrder;
    }


    public static List<PurshaseOrder> toDtos(List<RcpPurshaseOrder> rcpPurshaseOrders, boolean lazy) {
        if (null == rcpPurshaseOrders) {
            return Collections.emptyList();
        }
        List<PurshaseOrder> purshaseOrders = new ArrayList<>();
        for (RcpPurshaseOrder rcpPurshaseOrder : rcpPurshaseOrders) {
            purshaseOrders.add(toDto(rcpPurshaseOrder, lazy));
        }
        return purshaseOrders;
    }



    public static Set<RcpPurshaseOrder> toEntities(List<PurshaseOrder> purshaseOrders, boolean lazy) {
        if (null == purshaseOrders) {
            return null;
        }
        Set<RcpPurshaseOrder> rcpPurshaseOrders = new HashSet<>();
        for (PurshaseOrder purshaseOrder : purshaseOrders) {
            rcpPurshaseOrders.add(toEntity(purshaseOrder, lazy));
        }
        return rcpPurshaseOrders;
    }

    public static List<PurshaseOrder> toDtos(Iterable< ? extends RcpPurshaseOrder> rcpPurshaseOrders, boolean lazy) {
        if (null == rcpPurshaseOrders) {
            return null;
        }
        List<PurshaseOrder> purshaseOrders = new ArrayList<>();
        for (RcpPurshaseOrder rcpPurshaseOrder : rcpPurshaseOrders) {
            purshaseOrders.add(toDto(rcpPurshaseOrder, lazy));
        }
        return purshaseOrders;
    }
}

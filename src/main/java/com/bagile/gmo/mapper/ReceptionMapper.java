package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Reception;
import com.bagile.gmo.entities.RcpReception;
import com.bagile.gmo.util.EmsDate;


import java.util.*;

public class ReceptionMapper {
    private ReceptionMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "rcpReceptionId");
        map.put("owner", "ownOwner");
        map.put("address", "adrAddress");
        map.put("orderType", "prmOrderType");
        map.put("purshaseOrder", "rcpPurshaseOrder");
        map.put("supplier", "rcpSupplier");
        map.put("transport", "trpTransport");
        map.put("code", "rcpReceptionCode");
        map.put("remarks", "rcpReceptionRemarks");
        map.put("orderCode", "rcpReceptionOrderCode");
        map.put("description", "rcpReceptionDescription");
        map.put("expectedDate", "rcpReceptionExpectedDate");
        map.put("receptionDate", "rcpReceptionReceptionDate");
        map.put("creationDate", "rcpReceptionCreationDate");
        map.put("updateDate", "rcpReceptionUpdateDate");
        map.put("variable1", "rcpReceptionVariable1");
        map.put("variable2", "rcpReceptionVariable2");
        map.put("variable3", "rcpReceptionVariable3");
        map.put("variable4", "rcpReceptionVariable4");
        map.put("variable5", "rcpReceptionVariable5");
        map.put("variable6", "rcpReceptionVariable6");
        map.put("variable7", "rcpReceptionVariable7");
        map.put("variable8", "rcpReceptionVariable8");
        map.put("variable9", "rcpReceptionVariable9");
        map.put("variable10", "rcpReceptionVariable10");
        map.put("status", "rcpReceptionStatus");
        map.put("warehouse", "wrhWarehouse");
        map.put("delivery", "cmdDelivery");
        map.put("location", "locLocation");
        map.put("transportTel", "rcpReceptionTransportTel");
        map.put("orderStatus", "prmOrderStatus");
        map.put("receptionLines", "rcpReceptionLines");
        map.put("immatriculation", "rcpPurshaseOrderImmatriculation");
        map.put("account", "cmdAccount");
        map.put("transportContact", "rcpReceptionTransportContact");
        map.put("transfertCode", "rcpReceptionTransfertCode");
        map.put("totalPriceHT", "rcpReceptionTotalPriceHT");
        map.put("totalPriceTTC", "rcpReceptionTotalPriceTTC");
        map.put("vat", "rcpReceptionVat");
        map.put("discount", "rcpReceptionDiscount");
        map.put("active", "rcpReceptionActive");
        map.put("currency", "prmCurrency");
        map.put("accounted", "rcpReceptionAccounted");
        map.put("box", "usrBox");
        map.put("supplierDeliveryDate", "rcpReceptionSupplierDeliveryDate");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static RcpReception toEntity(Reception reception, boolean lazy) {
        if (null == reception) {
            return null;
        }
        RcpReception rcpReception = new RcpReception();
        rcpReception.setRcpReceptionId(reception.getId());
        rcpReception.setRcpReceptionCode(reception.getCode() != null ? reception.getCode().toUpperCase() : null);
        rcpReception.setRcpReceptionRemarks(reception.getRemarks());
        rcpReception.setRcpReceptionOrderCode(reception.getOrderCode());
        rcpReception.setRcpReceptionDescription(reception.getDescription());
        rcpReception.setRcpReceptionExpectedDate(reception.getExpectedDate());
        rcpReception.setRcpReceptionReceptionDate(reception.getReceptionDate());
        rcpReception.setRcpReceptionCreationDate(reception.getCreationDate());
        rcpReception.setRcpReceptionUpdateDate(reception.getUpdateDate());
        rcpReception.setRcpReceptionVariable1(reception.getVariable1());
        rcpReception.setRcpReceptionVariable2(reception.getVariable2());
        rcpReception.setRcpReceptionVariable3(reception.getVariable3());
        rcpReception.setRcpReceptionVariable4(reception.getVariable4());
        rcpReception.setRcpReceptionVariable5(reception.getVariable5());
        rcpReception.setRcpReceptionVariable6(reception.getVariable6());
        rcpReception.setRcpReceptionVariable7(reception.getVariable7());
        rcpReception.setRcpReceptionVariable8(reception.getVariable8());
        rcpReception.setRcpReceptionVariable9(reception.getVariable9());
        rcpReception.setRcpReceptionVariable10(reception.getVariable10());
        rcpReception.setRcpReceptionNumberOfContainers(reception.getNumberOfContainers());
        rcpReception.setRcpReceptionTransportTel(reception.getTransportTel());
        rcpReception.setRcpReceptionImmatriculation(reception.getImmatriculation());
        rcpReception.setRcpReceptionTransportContact(reception.getTransportContact());
        rcpReception.setRcpReceptionTransfertCode(reception.getTransfertCode());
        rcpReception.setRcpReceptionSendedToWms(reception.getSendedToWms());
        rcpReception.setRcpReceptionTotalPriceHT(reception.getTotalPriceHT());
        rcpReception.setRcpReceptionTotalPriceTTC(reception.getTotalPriceTTC());
        rcpReception.setRcpReceptionDiscount(reception.getDiscount());
        rcpReception.setRcpReceptionVat(reception.getVat());
        rcpReception.setRcpReceptionActive(reception.getActive());
        rcpReception.setRcpReceptionAccounted(reception.getAccounted());
        rcpReception.setUpdatedBy(reception.getUpdatedBy());
        rcpReception.setCreatedBy(reception.getCreatedBy());
        rcpReception.setRcpPurshaseTotalPriceHTDefaultCurrency(reception.getTotalPriceHTDefaultCurrency());
        rcpReception.setRcpPurshaseTotalPriceTTCDefaultCurrency(reception.getTotalPriceTTCDefaultCurrency());
        rcpReception.setRcpPurshaseVatDefaultCurrency(reception.getVatDefaultCurrency());
        rcpReception.setRcpPurshaseExchangeRate(reception.getExchangeRate());
        rcpReception.setRcpReceptionProvisionalCost(reception.getProvisionalCost());
        rcpReception.setRcpReceptionSupplierDeliveryDate(reception.getSupplierDeliveryDate());
        if (!lazy) {
            rcpReception.setCmdAccount(AccountMapper.toEntity(reception.getAccount(), true));
           // rcpReception.setLocLocation(LocationMapper.toEntity(reception.getLocation(), true));
            rcpReception.setPrmOrderStatus(OrderStatusMapper.toEntity(reception.getOrderStatus(), true));
            rcpReception.setWrhWarehouse(WarehouseMapper.toEntity(reception.getWarehouse(), true));
            rcpReception.setRcpPurshaseOrder(PurshaseOrderMapper.toEntity(reception.getPurshaseOrder(), true));
            rcpReception.setPrmOrderType(OrderTypeMapper.toEntity(reception.getOrderType(), true));
            rcpReception.setOwnOwner(OwnerMapper.toEntity(reception.getOwner(), true));
            rcpReception.setRcpSupplier(SupplierMapper.toEntity(reception.getSupplier(), true));
            rcpReception.setTrpTransport(TransportMapper.toEntity(reception.getTransport(), true));
            rcpReception.setAdrAddress(AddressInfoMapper.toEntity(reception.getAddress(), true));
            rcpReception.setRcpReceptionLines(ReceptionLineMapper.toEntities(reception.getReceptionLines(), false));
            rcpReception.setCmdDelivery(DeliveryMapper.toEntity(reception.getDelivery(), true));
          //  rcpReception.setPrmCurrency(CurrencyMapper.toEntity(reception.getCurrency(), true));
         //   rcpReception.setUsrBox(BoxMapper.toEntity(reception.getBox(), true));
//            rcpReception.setRcpReceptionStocks(ReceptionStockMapper.toEntities(reception.getReceptionStocks(), true));
//            rcpReception.setRcpReceptionStockArcs(ReceptionStockArcMapper.toEntities(reception.getReceptionStockArcs(), true));
            oneToMany(rcpReception);
        }
        return rcpReception;
    }

    public static void oneToMany(RcpReception reception) {
      //  if (null != reception.getRcpReceptionLines()) {
            reception.getRcpReceptionLines().forEach(rl -> {
                rl.setRcpReception(reception);
                rl.setRcpReceptionLineUpdateDate(EmsDate.getDateNow());
              if (0 >= rl.getRcpReceptionLineId()) {
                    rl.setRcpReceptionLineId(0L);
                    rl.setRcpReceptionLineCreationDate(EmsDate.getDateNow());
                    rl.setPrmOrderStatus(reception.getPrmOrderStatus());
                }
            });
       // }
    }

    public static Reception toDto(RcpReception rcpReception, boolean lazy) {
        if (null == rcpReception) {
            return null;
        }
        Reception reception = new Reception();
        reception.setId(rcpReception.getRcpReceptionId());
        reception.setCode(rcpReception.getRcpReceptionCode());
        reception.setOrderCode(rcpReception.getRcpReceptionOrderCode());
        reception.setRemarks(rcpReception.getRcpReceptionRemarks());
        reception.setDescription(rcpReception.getRcpReceptionDescription());//
        reception.setExpectedDate(rcpReception.getRcpReceptionExpectedDate());
        reception.setReceptionDate(rcpReception.getRcpReceptionReceptionDate());
        reception.setCreationDate(rcpReception.getRcpReceptionCreationDate());
        reception.setUpdateDate(rcpReception.getRcpReceptionUpdateDate());
        reception.setVariable1(rcpReception.getRcpReceptionVariable1());
        reception.setVariable2(rcpReception.getRcpReceptionVariable2());
        reception.setVariable3(rcpReception.getRcpReceptionVariable3());
        reception.setVariable4(rcpReception.getRcpReceptionVariable4());
        reception.setVariable5(rcpReception.getRcpReceptionVariable5());
        reception.setVariable6(rcpReception.getRcpReceptionVariable6());
        reception.setVariable7(rcpReception.getRcpReceptionVariable7());
        reception.setVariable8(rcpReception.getRcpReceptionVariable8());
        reception.setVariable9(rcpReception.getRcpReceptionVariable9());
        reception.setVariable10(rcpReception.getRcpReceptionVariable10());
        reception.setNumberOfContainers(rcpReception.getRcpReceptionNumberOfContainers());
        reception.setTransportTel(rcpReception.getRcpReceptionTransportTel());
        reception.setImmatriculation(rcpReception.getRcpReceptionImmatriculation());
        reception.setTransportContact(rcpReception.getRcpReceptionTransportContact());
        reception.setTransfertCode(rcpReception.getRcpReceptionTransfertCode());
        reception.setSendedToWms(rcpReception.getRcpReceptionSendedToWms());
        reception.setTotalPriceHT(rcpReception.getRcpReceptionTotalPriceHT());
        reception.setTotalPriceTTC(rcpReception.getRcpReceptionTotalPriceTTC());
        reception.setDiscount(rcpReception.getRcpReceptionDiscount());
        reception.setVat(rcpReception.getRcpReceptionVat());
        reception.setActive(rcpReception.getRcpReceptionActive());
        reception.setAccounted(rcpReception.getRcpReceptionAccounted());
        reception.setTotalPriceHTDefaultCurrency(rcpReception.getRcpPurshaseTotalPriceHTDefaultCurrency());
        reception.setTotalPriceTTCDefaultCurrency(rcpReception.getRcpPurshaseTotalPriceTTCDefaultCurrency());
        reception.setVatDefaultCurrency(rcpReception.getRcpPurshaseVatDefaultCurrency());
        reception.setExchangeRate(rcpReception.getRcpPurshaseExchangeRate());
        reception.setUpdatedBy(rcpReception.getUpdatedBy());
        reception.setCreatedBy(rcpReception.getCreatedBy());
        reception.setProvisionalCost(rcpReception.getRcpReceptionProvisionalCost());
        reception.setSupplierDeliveryDate(rcpReception.getRcpReceptionSupplierDeliveryDate());
        if (!lazy) {
            reception.setAccount(AccountMapper.toDto(rcpReception.getCmdAccount(), true));
           // reception.setLocation(LocationMapper.toDto(rcpReception.getLocLocation(), true));
            reception.setOrderStatus(OrderStatusMapper.toDto(rcpReception.getPrmOrderStatus(), true));
            reception.setWarehouse(WarehouseMapper.toDto(rcpReception.getWrhWarehouse(), true));
            reception.setOwner(OwnerMapper.toDto(rcpReception.getOwnOwner(), true));
            reception.setSupplier(SupplierMapper.toDto(rcpReception.getRcpSupplier(), true));
            reception.setAddress(AddressInfoMapper.toDto(rcpReception.getAdrAddress(), true));
            reception.setOrderType(OrderTypeMapper.toDto(rcpReception.getPrmOrderType(), true));
            reception.setPurshaseOrder(PurshaseOrderMapper.toDto(rcpReception.getRcpPurshaseOrder(), true));
            reception.setDelivery(DeliveryMapper.toDto(rcpReception.getCmdDelivery(), true));
            reception.setTransport(TransportMapper.toDto(rcpReception.getTrpTransport(), true));
            reception.setReceptionLines(ReceptionLineMapper.toDtos(rcpReception.getRcpReceptionLines(), false));

            //   reception.setCurrency(CurrencyMapper.toDto(rcpReception.getPrmCurrency(), true));
          //  reception.setBox(BoxMapper.toDto(rcpReception.getUsrBox(), true));
        }
        return reception;
    }

    public static List<Reception> toDtos(List<RcpReception> rcpReceptions, boolean lazy) {
        if (null == rcpReceptions) {
            return null;
        }
        List<Reception> receptions = new ArrayList<>();
        for (RcpReception rcpReception : rcpReceptions) {
            receptions.add(toDto(rcpReception, lazy));
        }
        return receptions;
    }

    public static List<Reception> toDtos(Iterable<RcpReception> rcpReceptions, boolean lazy) {
        if (null == rcpReceptions) {
            return null;
        }
        List<Reception> receptions = new ArrayList<>();
        for (RcpReception rcpReception : rcpReceptions) {
            receptions.add(toDto(rcpReception, lazy));
        }
        return receptions;
    }

    public static Set<RcpReception> toEntities(Set<Reception> receptions, boolean lazy) {
        if (null == receptions) {
            return null;
        }
        Set<RcpReception> rcpReceptions = new HashSet<>();
        for (Reception rurshaseOrder : receptions) {
            rcpReceptions.add(toEntity(rurshaseOrder, lazy));
        }
        return rcpReceptions;
    }

    public static Set<Reception> toDtos(Set<RcpReception> rcpReceptions, boolean lazy) {
        if (null == rcpReceptions) {
            return null;
        }
        Set<Reception> receptions = new HashSet<>();
        for (RcpReception rcpReception : rcpReceptions) {
            receptions.add(toDto(rcpReception, lazy));
        }
        return receptions;
    }
}

package com.bagile.tms.mapper;

import com.sinno.ems.util.EmsDate;

import java.util.*;

public class ReceptionArcMapper {
    private ReceptionArcMapper() {
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
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static RcpReceptionArc toEntity(ReceptionArc reception, boolean lazy) {
        if (null == reception) {
            return null;
        }
        RcpReceptionArc rcpReception = new RcpReceptionArc();
        rcpReception.setRcpReceptionId(reception.getId());
        rcpReception.setRcpReceptionCode(reception.getCode());
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
        if (!lazy) {
            rcpReception.setCmdAccount(AccountMapper.toEntity(reception.getAccount(), true));
            rcpReception.setLocLocation(LocationMapper.toEntity(reception.getLocation(), true));
            rcpReception.setPrmOrderStatus(OrderStatusMapper.toEntity(reception.getOrderStatus(), true));
            rcpReception.setWrhWarehouse(WarehouseMapper.toEntity(reception.getWarehouse(), true));
            rcpReception.setRcpPurshaseOrder(PurshaseOrderArcMapper.toEntity(reception.getPurshaseOrder(), true));
            rcpReception.setPrmOrderType(OrderTypeMapper.toEntity(reception.getOrderType(), true));
            rcpReception.setOwnOwner(OwnerMapper.toEntity(reception.getOwner(), true));
            rcpReception.setRcpSupplier(SupplierMapper.toEntity(reception.getSupplier(), true));
            rcpReception.setTrpTransport(TransportMapper.toEntity(reception.getTransport(), true));
            rcpReception.setAdrAddress(AddressMapper.toEntity(reception.getAddress(), true));
            rcpReception.setRcpReceptionLines(ReceptionLineArcMapper.toEntities(reception.getReceptionLines(), false));
            rcpReception.setCmdDelivery(DeliveryArcMapper.toEntity(reception.getDelivery(), true));
//            rcpReception.setRcpReceptionStocks(ReceptionStockMapper.toEntities(reception.getReceptionStocks(), true));
//            rcpReception.setRcpReceptionStockArcs(ReceptionStockArcMapper.toEntities(reception.getReceptionStockArcs(), true));
            oneToMany(rcpReception);
        }
        return rcpReception;
    }

    public static void oneToMany(RcpReceptionArc reception) {
        if (null != reception.getRcpReceptionLines()) {
            reception.getRcpReceptionLines().stream().forEach(rl -> {
                rl.setRcpReception(reception);
                if (null != rl.getRcpPurshaseOrderLine())
                    rl.setRcpReceptionLineQuantity(rl.getRcpPurshaseOrderLine().getRcpPurshaseOrderLineQuantity());
                rl.setRcpReceptionLineUpdateDate(EmsDate.getDateNow());
                if (0 >= rl.getRcpReceptionLineId()) {
                    rl.setRcpReceptionLineCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static ReceptionArc toDto(RcpReceptionArc rcpReception, boolean lazy) {
        if (null == rcpReception) {
            return null;
        }
        ReceptionArc reception = new ReceptionArc();
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
        if (!lazy) {
            reception.setAccount(AccountMapper.toDto(rcpReception.getCmdAccount(), true));
            reception.setLocation(LocationMapper.toDto(rcpReception.getLocLocation(), true));
            reception.setOrderStatus(OrderStatusMapper.toDto(rcpReception.getPrmOrderStatus(), true));
            reception.setWarehouse(WarehouseMapper.toDto(rcpReception.getWrhWarehouse(), true));
            reception.setOwner(OwnerMapper.toDto(rcpReception.getOwnOwner(), true));
            reception.setSupplier(SupplierMapper.toDto(rcpReception.getRcpSupplier(), true));
            reception.setAddress(AddressMapper.toDto(rcpReception.getAdrAddress(), true));
            reception.setOrderType(OrderTypeMapper.toDto(rcpReception.getPrmOrderType(), true));
            reception.setPurshaseOrder(PurshaseOrderArcMapper.toDto(rcpReception.getRcpPurshaseOrder(), true));
            reception.setTransport(TransportMapper.toDto(rcpReception.getTrpTransport(), true));
            //reception.setTransport(TransportMapper.toDto(rcpReception.getTrpTransport(), true));
            reception.setReceptionLines(ReceptionLineArcMapper.toDtos(rcpReception.getRcpReceptionLines(), false));
//          reception.setReceptionStocks(ReceptionStockMapper.toDtos(rcpReception.getRcpReceptionStocks(), true));
//          reception.setReceptionStockArcs(ReceptionStockArcMapper.toDtos(rcpReception.getRcpReceptionStockArcs(), true));
        }
        return reception;
    }

    public static List<ReceptionArc> toDtos(List<RcpReceptionArc> rcpReceptions, boolean lazy) {
        if (null == rcpReceptions) {
            return null;
        }
        List<ReceptionArc> receptions = new ArrayList<>();
        for (RcpReceptionArc rcpReception : rcpReceptions) {
            receptions.add(toDto(rcpReception, lazy));
        }
        return receptions;
    }

    public static List<ReceptionArc> toDtos(Iterable<RcpReceptionArc> rcpReceptions, boolean lazy) {
        if (null == rcpReceptions) {
            return null;
        }
        List<ReceptionArc> receptions = new ArrayList<>();
        for (RcpReceptionArc rcpReception : rcpReceptions) {
            receptions.add(toDto(rcpReception, lazy));
        }
        return receptions;
    }

    public static Set<RcpReceptionArc> toEntities(Set<ReceptionArc> receptions, boolean lazy) {
        if (null == receptions) {
            return null;
        }
        Set<RcpReceptionArc> rcpReceptions = new HashSet<>();
        for (ReceptionArc rurshaseOrder : receptions) {
            rcpReceptions.add(toEntity(rurshaseOrder, lazy));
        }
        return rcpReceptions;
    }

    public static Set<ReceptionArc> toDtos(Set<RcpReceptionArc> rcpReceptions, boolean lazy) {
        if (null == rcpReceptions) {
            return null;
        }
        Set<ReceptionArc> receptions = new HashSet<>();
        for (RcpReceptionArc rcpReception : rcpReceptions) {
            receptions.add(toDto(rcpReception, lazy));
        }
        return receptions;
    }
}

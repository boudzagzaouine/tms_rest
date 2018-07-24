package com.bagile.tms.mapper;

import java.util.*;


public class ReceptionStockArcMapper {
    private ReceptionStockArcMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "rcpReceptionStockId");
        map.put("owner", "ownOwner");
        map.put("product", "pdtProduct");
        map.put("blockType", "prmBlockType");
        map.put("color", "prmColor");
        map.put("reception", "rcpReception");
        map.put("receptionLine", "rcpReceptionLine");
        map.put("supplier", "rcpSupplier");
        map.put("warehouse", "wrhWarehouse");
        map.put("quantityReceived", "rcpReceptionStockQuantityReceived");
        map.put("dlc", "rcpReceptionStockDlc");
        map.put("dluo", "rcpReceptionStockDluo");
        map.put("serialNo", "rcpReceptionStockSerialNo");
        map.put("lot", "rcpReceptionStockLot");
        map.put("receptionDate", "rcpReceptionStockReceptionDate");
        map.put("creationDate", "rcpReceptionStockCreationDate");
        map.put("updateDate", "rcpReceptionStockUpdateDate");
        map.put("container","stkContainer");
        map.put("uom","pdtUom");
        map.put("location","locLocation");
        map.put("weight","rcpReceptionStockWeight");
        map.put("quality","rcpReceptionStockQuality");
        map.put("orderStatus","prmOrderStatus");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }


    public static RcpReceptionStockArc toEntity(ReceptionStockArc receptionStock, boolean lazy) {
        if (null == receptionStock) {
            return null;
        }
        RcpReceptionStockArc rcpReceptionStock = new RcpReceptionStockArc();
        rcpReceptionStock.setRcpReceptionStockId(receptionStock.getId());
        rcpReceptionStock.setRcpReceptionStockQuantityReceived(receptionStock.getQuantityReceived());
        rcpReceptionStock.setRcpReceptionStockDlc(receptionStock.getDlc());
        rcpReceptionStock.setRcpReceptionStockDluo(receptionStock.getDluo());
        rcpReceptionStock.setRcpReceptionStockSerialNo(receptionStock.getSerialNo());
        rcpReceptionStock.setRcpReceptionStockLot(receptionStock.getLot());
        rcpReceptionStock.setRcpReceptionStockReceptionDate(receptionStock.getReceptionDate());
        rcpReceptionStock.setRcpReceptionStockCreationDate(receptionStock.getCreationDate());
        rcpReceptionStock.setRcpReceptionStockUpdateDate(receptionStock.getUpdateDate());
        rcpReceptionStock.setRcpReceptionStockQuality(receptionStock.getQuality());
        rcpReceptionStock.setRcpReceptionStockWeight(receptionStock.getWeight());
        if (!lazy) {
            rcpReceptionStock.setStkContainer(ContainerMapper.toEntity(receptionStock.getContainer(), true));
            rcpReceptionStock.setPdtProduct(ProductMapper.toEntity(receptionStock.getProduct(), true));
            rcpReceptionStock.setRcpReceptionLine(ReceptionLineArcMapper.toEntity(receptionStock.getReceptionLine(), true));
            rcpReceptionStock.setRcpReception(ReceptionArcMapper.toEntity(receptionStock.getReception(), true));
            rcpReceptionStock.setOwnOwner(OwnerMapper.toEntity(receptionStock.getOwner(), true));
            rcpReceptionStock.setRcpSupplier(SupplierMapper.toEntity(receptionStock.getSupplier(), true));
            rcpReceptionStock.setPrmBlockType(BlockTypeMapper.toEntity(receptionStock.getBlockType(), true));
            rcpReceptionStock.setPrmColor(ColorMapper.toEntity(receptionStock.getColor(), true));
            rcpReceptionStock.setWrhWarehouse(WarehouseMapper.toEntity(receptionStock.getWarehouse(), true));
            rcpReceptionStock.setLocLocation(LocationMapper.toEntity(receptionStock.getLocation(),true));
            rcpReceptionStock.setPdtUom(UomMapper.toEntity(receptionStock.getUom(),true));
            rcpReceptionStock.setPdtUomRecieved(UomMapper.toEntity(receptionStock.getUomReceived(),true));
            rcpReceptionStock.setPrmOrderStatus(OrderStatusMapper.toEntity(receptionStock.getOrderStatus(),true));




        }
        return rcpReceptionStock;
    }

    public static ReceptionStockArc toDto(RcpReceptionStockArc rcpReceptionStock, boolean lazy) {
        if (null == rcpReceptionStock) {
            return null;
        }
        ReceptionStockArc receptionStock = new ReceptionStockArc();
        receptionStock.setId(rcpReceptionStock.getRcpReceptionStockId());
        receptionStock.setQuantityReceived(rcpReceptionStock.getRcpReceptionStockQuantityReceived());
        receptionStock.setDlc(rcpReceptionStock.getRcpReceptionStockDlc());
        receptionStock.setDluo(rcpReceptionStock.getRcpReceptionStockDluo());
        receptionStock.setSerialNo(rcpReceptionStock.getRcpReceptionStockSerialNo());
        receptionStock.setLot(rcpReceptionStock.getRcpReceptionStockLot());
        receptionStock.setReceptionDate(rcpReceptionStock.getRcpReceptionStockReceptionDate());
        receptionStock.setCreationDate(rcpReceptionStock.getRcpReceptionStockCreationDate());
        receptionStock.setUpdateDate(rcpReceptionStock.getRcpReceptionStockUpdateDate());
        receptionStock.setQuality(rcpReceptionStock.getRcpReceptionStockQuality());
        receptionStock.setWeight(rcpReceptionStock.getRcpReceptionStockWeight());
        if (!lazy) {
            receptionStock.setContainer(ContainerMapper.toDto(rcpReceptionStock.getStkContainer(), true));
            receptionStock.setProduct(ProductMapper.toDto(rcpReceptionStock.getPdtProduct(), true));
            receptionStock.setReceptionLine(ReceptionLineArcMapper.toDto(rcpReceptionStock.getRcpReceptionLine(), true));
            receptionStock.setReception(ReceptionArcMapper.toDto(rcpReceptionStock.getRcpReception(), true));
            receptionStock.setOwner(OwnerMapper.toDto(rcpReceptionStock.getOwnOwner(), true));
            receptionStock.setSupplier(SupplierMapper.toDto(rcpReceptionStock.getRcpSupplier(), true));
            receptionStock.setBlockType(BlockTypeMapper.toDto(rcpReceptionStock.getPrmBlockType(), true));
            receptionStock.setColor(ColorMapper.toDto(rcpReceptionStock.getPrmColor(), true));
            receptionStock.setWarehouse(WarehouseMapper.toDto(rcpReceptionStock.getWrhWarehouse(), true));
            receptionStock.setUom(UomMapper.toDto(rcpReceptionStock.getPdtUom(), true));
            receptionStock.setUomReceived(UomMapper.toDto(rcpReceptionStock.getPdtUomRecieved(), true));
            receptionStock.setOrderStatus(OrderStatusMapper.toDto(rcpReceptionStock.getPrmOrderStatus(),true));
            receptionStock.setLocation(LocationMapper.toDto(rcpReceptionStock.getLocLocation(),true));
        }
        return receptionStock;
    }

    public static List<ReceptionStockArc> toDtos(List<RcpReceptionStockArc> rcpReceptionStocks, boolean lazy) {
        if (null == rcpReceptionStocks) {
            return null;
        }
        List<ReceptionStockArc> receptionStocks = new ArrayList<>();
        for (RcpReceptionStockArc rcpReceptionStock : rcpReceptionStocks) {
            receptionStocks.add(toDto(rcpReceptionStock, lazy));
        }
        return receptionStocks;
    }

    public static List<ReceptionStockArc> toDtos(Iterable<RcpReceptionStockArc> rcpReceptionStocks, boolean lazy) {
        if (null == rcpReceptionStocks) {
            return null;
        }
        List<ReceptionStockArc> receptionStocks = new ArrayList<>();
        for (RcpReceptionStockArc rcpReceptionStock : rcpReceptionStocks) {
            receptionStocks.add(toDto(rcpReceptionStock, lazy));
        }
        return receptionStocks;
    }

    public static Set<RcpReceptionStockArc> toEntities(Set<ReceptionStockArc> receptionStocks, boolean lazy) {
        if (null == receptionStocks) {
            return null;
        }
        Set<RcpReceptionStockArc> rcpReceptionStocks = new HashSet<>();
        for (ReceptionStockArc rurshaseOrder : receptionStocks) {
            rcpReceptionStocks.add(toEntity(rurshaseOrder, lazy));
        }
        return rcpReceptionStocks;
    }

    public static Set<ReceptionStockArc> toDtos(Set<RcpReceptionStockArc> rcpReceptionStocks, boolean lazy) {
        if (null == rcpReceptionStocks) {
            return null;
        }
        Set<ReceptionStockArc> receptionStocks = new HashSet<>();
        for (RcpReceptionStockArc rcpReceptionStock : rcpReceptionStocks) {
            receptionStocks.add(toDto(rcpReceptionStock, lazy));
        }
        return receptionStocks;
    }

}

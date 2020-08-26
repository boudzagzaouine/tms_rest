package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ReceptionStock;
import com.bagile.gmo.entities.RcpReceptionStock;


import java.util.*;

public class ReceptionStockMapper {
    private ReceptionStockMapper() {
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
        map.put("productDimension", "pdtProductDimension");
        map.put("productPack", "pdtProductPack");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }


    public static RcpReceptionStock toEntity(ReceptionStock receptionStock, boolean lazy) {
        if (null == receptionStock) {
            return null;
        }
        RcpReceptionStock rcpReceptionStock = new RcpReceptionStock();
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
        rcpReceptionStock.setUpdatedBy(receptionStock.getUpdatedBy());
        rcpReceptionStock.setCreatedBy(receptionStock.getCreatedBy());
        if (!lazy) {
          //  rcpReceptionStock.setPdtProductDimension(ProductDimensionMapper.toEntity(receptionStock.getProductDimension(),true));
           // rcpReceptionStock.setStkContainer(ContainerMapper.toEntity(receptionStock.getContainer(), true));
            rcpReceptionStock.setPdtProduct(ProductMapper.toEntity(receptionStock.getProduct(), true));
            rcpReceptionStock.setRcpReceptionLine(ReceptionLineMapper.toEntity(receptionStock.getReceptionLine(), true));
            rcpReceptionStock.setRcpReception(ReceptionMapper.toEntity(receptionStock.getReception(), true));
            rcpReceptionStock.setOwnOwner(OwnerMapper.toEntity(receptionStock.getOwner(), true));
            rcpReceptionStock.setRcpSupplier(SupplierMapper.toEntity(receptionStock.getSupplier(), true));
         //   rcpReceptionStock.setPrmBlockType(BlockTypeMapper.toEntity(receptionStock.getBlockType(), true));
          //  rcpReceptionStock.setPrmColor(ColorMapper.toEntity(receptionStock.getColor(), true));
            rcpReceptionStock.setWrhWarehouse(WarehouseMapper.toEntity(receptionStock.getWarehouse(), true));
          //  rcpReceptionStock.setLocLocation(LocationMapper.toEntity(receptionStock.getLocation(),true));
            rcpReceptionStock.setPdtUom(UomMapper.toEntity(receptionStock.getUom(),true));
            rcpReceptionStock.setPdtUomRecieved(UomMapper.toEntity(receptionStock.getUomReceived(),true));
            rcpReceptionStock.setPdtProductPack(ProductPackMapper.toEntity(receptionStock.getProductPack(), true));
        }
        return rcpReceptionStock;
    }

    public static ReceptionStock toDto(RcpReceptionStock rcpReceptionStock, boolean lazy) {
        if (null == rcpReceptionStock) {
            return null;
        }
        ReceptionStock receptionStock = new ReceptionStock();
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
            receptionStock.setProductPack(ProductPackMapper.toDto(rcpReceptionStock.getPdtProductPack(), false));
          //  receptionStock.setProductDimension(ProductDimensionMapper.toDto(rcpReceptionStock.getPdtProductDimension(),true));
          //  receptionStock.setContainer(ContainerMapper.toDto(rcpReceptionStock.getStkContainer(), true));
            receptionStock.setProduct(ProductMapper.toDto(rcpReceptionStock.getPdtProduct(), false));
            receptionStock.setReceptionLine(ReceptionLineMapper.toDto(rcpReceptionStock.getRcpReceptionLine(), true));
            receptionStock.setReception(ReceptionMapper.toDto(rcpReceptionStock.getRcpReception(), true));
            receptionStock.setOwner(OwnerMapper.toDto(rcpReceptionStock.getOwnOwner(), true));
            receptionStock.setSupplier(SupplierMapper.toDto(rcpReceptionStock.getRcpSupplier(), true));
          //  receptionStock.setBlockType(BlockTypeMapper.toDto(rcpReceptionStock.getPrmBlockType(), true));
          //  receptionStock.setColor(ColorMapper.toDto(rcpReceptionStock.getPrmColor(), true));
            receptionStock.setWarehouse(WarehouseMapper.toDto(rcpReceptionStock.getWrhWarehouse(), true));
            receptionStock.setUom(UomMapper.toDto(rcpReceptionStock.getPdtUom(), true));
            receptionStock.setUomReceived(UomMapper.toDto(rcpReceptionStock.getPdtUomRecieved(), true));
          //  receptionStock.setLocation(LocationMapper.toDto(rcpReceptionStock.getLocLocation(),true));
            receptionStock.setProductPack(ProductPackMapper.toDto(rcpReceptionStock.getPdtProductPack(),true));
        }
        return receptionStock;
    }

    public static List<ReceptionStock> toDtos(List<RcpReceptionStock> rcpReceptionStocks, boolean lazy) {
        if (null == rcpReceptionStocks) {
            return null;
        }
        List<ReceptionStock> receptionStocks = new ArrayList<>();
        for (RcpReceptionStock rcpReceptionStock : rcpReceptionStocks) {
            receptionStocks.add(toDto(rcpReceptionStock, lazy));
        }
        return receptionStocks;
    }

    public static List<ReceptionStock> toDtos(Iterable<RcpReceptionStock> rcpReceptionStocks, boolean lazy) {
        if (null == rcpReceptionStocks) {
            return null;
        }
        List<ReceptionStock> receptionStocks = new ArrayList<>();
        for (RcpReceptionStock rcpReceptionStock : rcpReceptionStocks) {
            receptionStocks.add(toDto(rcpReceptionStock, lazy));
        }
        return receptionStocks;
    }

    public static Set<RcpReceptionStock> toEntities(Set<ReceptionStock> receptionStocks, boolean lazy) {
        if (null == receptionStocks) {
            return null;
        }
        Set<RcpReceptionStock> rcpReceptionStocks = new HashSet<>();
        for (ReceptionStock rurshaseOrder : receptionStocks) {
            rcpReceptionStocks.add(toEntity(rurshaseOrder, lazy));
        }
        return rcpReceptionStocks;
    }

    public static Set<ReceptionStock> toDtos(Set<RcpReceptionStock> rcpReceptionStocks, boolean lazy) {
        if (null == rcpReceptionStocks) {
            return null;
        }
        Set<ReceptionStock> receptionStocks = new HashSet<>();
        for (RcpReceptionStock rcpReceptionStock : rcpReceptionStocks) {
            receptionStocks.add(toDto(rcpReceptionStock, lazy));
        }
        return receptionStocks;
    }
}

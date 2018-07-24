/**
 *
 */
package com.bagile.tms.mapper;

import java.util.*;

/**
 * @author aelguezzar
 */
public class SaleOrderStockArcMapper {
    private SaleOrderStockArcMapper() {
    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdSaleOrderStockId");
        map.put("saleOrder", "cmdSaleOrder");
        map.put("saleOrderLine", "cmdSaleOrderLine");
        map.put("location", "locLocation");
        map.put("owner", "ownOwner");
        map.put("product", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("blockType", "prmBlockType");
        map.put("container", "stkContainer");
        map.put("warehouse", "wrhWarehouse");
        map.put("color", "prmColor");
        map.put("cineNumber", "cmdSaleOrderStockLineNumber");
        map.put("quantityserved", "cmdSaleOrderStockQuantityserved");
        map.put("transportContainerNo", "cmdSaleOrderStockTransportContainerNo");
        map.put("dlc", "cmdSaleOrderStockDlc");
        map.put("dluo", "cmdSaleOrderStockDluo");
        map.put("serialNo", "cmdSaleOrderStockSerialNo");
        map.put("lot", "cmdSaleOrderStockLot");
        map.put("orderDate", "cmdSaleOrderStockOrderDate");
        map.put("creationDate", "cmdSaleOrderStockCreationDate");
        map.put("updateDate", "cmdSaleOrderStockUpdateDate");
        map.put("delivery", "cmdDelivery");
        map.put("deliveryLine", "cmdDeliveryLine");
        map.put("weight","cmdSaleOrderStockWeight");
        map.put("quality","cmdSaleOrderStockQuality");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static SaleOrderStockArc toDto(CmdSaleOrderStockArc cmdOrderStock, boolean lazy) {
        if (null == cmdOrderStock) {
            return null;
        }
        SaleOrderStockArc saleOrderStock = new SaleOrderStockArc();
        saleOrderStock.setCreationDate(cmdOrderStock.getCmdSaleOrderStockCreationDate());
        saleOrderStock.setDlc(cmdOrderStock.getCmdSaleOrderStockDlc());
        saleOrderStock.setDluo(cmdOrderStock.getCmdSaleOrderStockDluo());
        saleOrderStock.setId(cmdOrderStock.getCmdSaleOrderStockId());
        saleOrderStock.setLineNumber(cmdOrderStock.getCmdSaleOrderStockLineNumber());
        saleOrderStock.setLot(cmdOrderStock.getCmdSaleOrderStockLot());
        saleOrderStock.setOrderDate(cmdOrderStock.getCmdSaleOrderStockOrderDate());
        saleOrderStock.setQuantityServed(cmdOrderStock.getCmdSaleOrderStockQuantityServed());
        saleOrderStock.setSerialNo(cmdOrderStock.getCmdSaleOrderStockSerialNo());
        saleOrderStock.setTransportContainerNo(cmdOrderStock.getCmdSaleOrderStockTransportContainerNo());
        saleOrderStock.setUpdateDate(cmdOrderStock.getCmdSaleOrderStockUpdateDate());
        saleOrderStock.setQuality(cmdOrderStock.getCmdSaleOrderStockQuality());
        saleOrderStock.setWeight(cmdOrderStock.getCmdSaleOrderStockWeight());
        if (!lazy) {
            saleOrderStock.setBlockType(BlockTypeMapper.toDto(cmdOrderStock.getPrmBlockType(), true));
            saleOrderStock.setContainer(ContainerMapper.toDto(cmdOrderStock.getStkContainer(), true));
            saleOrderStock.setLocation(LocationMapper.toDto(cmdOrderStock.getLocLocation(), true));
            saleOrderStock.setColor(ColorMapper.toDto(cmdOrderStock.getPrmColor(), true));
            saleOrderStock.setOwner(OwnerMapper.toDto(cmdOrderStock.getOwnOwner(), true));
            saleOrderStock.setProduct(ProductMapper.toDto(cmdOrderStock.getPdtProduct(), true));
            saleOrderStock.setDelivery(DeliveryArcMapper.toDto(cmdOrderStock.getCmdDelivery(), true));
            saleOrderStock.setDeliveryLine(DeliveryLineArcMapper.toDto(cmdOrderStock.getCmdDeliveryLine(), true));
            saleOrderStock.setUom(UomMapper.toDto(cmdOrderStock.getPdtUom(), true));
            saleOrderStock.setWarehouse(WarehouseMapper.toDto(cmdOrderStock.getWrhWarehouse(), true));
        }
        return saleOrderStock;
    }

    public static CmdSaleOrderStockArc toEntity(SaleOrderStockArc saleOrderStock, boolean lazy) {
        if (null == saleOrderStock) {
            return null;
        }
        CmdSaleOrderStockArc cmdSaleOrderStock = new CmdSaleOrderStockArc();
        cmdSaleOrderStock.setCmdSaleOrderStockCreationDate(saleOrderStock.getCreationDate());
        cmdSaleOrderStock.setCmdSaleOrderStockDlc(saleOrderStock.getDlc());
        cmdSaleOrderStock.setCmdSaleOrderStockDluo(saleOrderStock.getDluo());
        cmdSaleOrderStock.setCmdSaleOrderStockId(saleOrderStock.getId());
        cmdSaleOrderStock.setCmdSaleOrderStockLineNumber(saleOrderStock.getLineNumber());
        cmdSaleOrderStock.setCmdSaleOrderStockLot(saleOrderStock.getLot());
        cmdSaleOrderStock.setCmdSaleOrderStockOrderDate(saleOrderStock.getOrderDate());
        cmdSaleOrderStock.setCmdSaleOrderStockQuantityServed(saleOrderStock.getQuantityServed());
        cmdSaleOrderStock.setCmdSaleOrderStockSerialNo(saleOrderStock.getSerialNo());
        cmdSaleOrderStock.setCmdSaleOrderStockTransportContainerNo(saleOrderStock.getTransportContainerNo());
        cmdSaleOrderStock.setCmdSaleOrderStockUpdateDate(saleOrderStock.getUpdateDate());
        cmdSaleOrderStock.setCmdSaleOrderStockQuality(saleOrderStock.getQuality());
        cmdSaleOrderStock.setCmdSaleOrderStockWeight(saleOrderStock.getWeight());
        if (!lazy) {
            cmdSaleOrderStock.setCmdDelivery(DeliveryArcMapper.toEntity(saleOrderStock.getDelivery(), true));
            cmdSaleOrderStock.setCmdDeliveryLine(DeliveryLineArcMapper.toEntity(saleOrderStock.getDeliveryLine(), true));
            cmdSaleOrderStock.setLocLocation(LocationMapper.toEntity(saleOrderStock.getLocation(), true));
            cmdSaleOrderStock.setOwnOwner(OwnerMapper.toEntity(saleOrderStock.getOwner(), true));
            cmdSaleOrderStock.setPrmColor(ColorMapper.toEntity(saleOrderStock.getColor(), true));
            cmdSaleOrderStock.setPdtProduct(ProductMapper.toEntity(saleOrderStock.getProduct(), true));
            cmdSaleOrderStock.setPdtUom(UomMapper.toEntity(saleOrderStock.getUom(), true));
            cmdSaleOrderStock.setPrmBlockType(BlockTypeMapper.toEntity(saleOrderStock.getBlockType(), true));
            cmdSaleOrderStock.setStkContainer(ContainerMapper.toEntity(saleOrderStock.getContainer(), true));
            cmdSaleOrderStock.setWrhWarehouse(WarehouseMapper.toEntity(saleOrderStock.getWarehouse(), true));
        }
        return cmdSaleOrderStock;
    }

    public static List<SaleOrderStockArc> toDtos(List<CmdSaleOrderStockArc> cmdSaleOrderStocks, boolean lazy) {
        if (null == cmdSaleOrderStocks) {
            return null;
        }
        List<SaleOrderStockArc> saleOrderStocks = new ArrayList<>();
        for (CmdSaleOrderStockArc cmdSaleOrderStock : cmdSaleOrderStocks) {
            saleOrderStocks.add(toDto(cmdSaleOrderStock, lazy));
        }
        return saleOrderStocks;
    }

    public static List<SaleOrderStockArc> toDtos(Iterable<CmdSaleOrderStockArc> cmdSaleOrderStocks, boolean lazy) {
        if (null == cmdSaleOrderStocks) {
            return null;
        }
        List<SaleOrderStockArc> saleOrderStocks = new ArrayList<>();
        for (CmdSaleOrderStockArc cmdSaleOrderStock : cmdSaleOrderStocks) {
            saleOrderStocks.add(toDto(cmdSaleOrderStock, lazy));
        }
        return saleOrderStocks;
    }

    public static Set<CmdSaleOrderStockArc> toEntities(Set<SaleOrderStockArc> saleOrderStocks, boolean lazy) {
        if (null == saleOrderStocks) {
            return null;
        }
        Set<CmdSaleOrderStockArc> cmdSaleOrderStocks = new HashSet<>();
        for (SaleOrderStockArc saleOrderStock : saleOrderStocks) {
            cmdSaleOrderStocks.add(toEntity(saleOrderStock, lazy));
        }
        return cmdSaleOrderStocks;
    }

    public static Set<SaleOrderStockArc> toDtos(Set<CmdSaleOrderStockArc> cmdSaleOrderStocks, boolean lazy) {
        if (null == cmdSaleOrderStocks) {
            return null;
        }
        Set<SaleOrderStockArc> saleOrderStocks = new HashSet<>();
        for (CmdSaleOrderStockArc cmdSaleOrderStock : cmdSaleOrderStocks) {
            saleOrderStocks.add(toDto(cmdSaleOrderStock, lazy));
        }
        return saleOrderStocks;
    }

}

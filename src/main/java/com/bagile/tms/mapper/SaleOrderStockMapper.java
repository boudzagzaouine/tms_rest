/**
 *
 */
package com.bagile.tms.mapper;

import com.sinno.ems.dto.SaleOrderStock;
import com.sinno.ems.entities.CmdSaleOrderStock;

import java.util.*;

/**
 * @author aelguezzar
 */
public class SaleOrderStockMapper {
    private SaleOrderStockMapper() {
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
        map.put("weight", "cmdSaleOrderStockWeight");
        map.put("quality", "cmdSaleOrderStockQuality");
        map.put("productDimension", "pdtProductDimension");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static SaleOrderStock toDto(CmdSaleOrderStock cmdOrderStock, boolean lazy) {
        if (null == cmdOrderStock) {
            return null;
        }
        SaleOrderStock saleOrderStock = new SaleOrderStock();
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
            saleOrderStock.setProductDimension(ProductDimensionMapper.toDto(cmdOrderStock.getPdtProductDimension(),true));

            saleOrderStock.setBlockType(BlockTypeMapper.toDto(cmdOrderStock.getPrmBlockType(), true));
            saleOrderStock.setContainer(ContainerMapper.toDto(cmdOrderStock.getStkContainer(), true));
            saleOrderStock.setLocation(LocationMapper.toDto(cmdOrderStock.getLocLocation(), true));
            saleOrderStock.setColor(ColorMapper.toDto(cmdOrderStock.getPrmColor(), true));
            saleOrderStock.setOwner(OwnerMapper.toDto(cmdOrderStock.getOwnOwner(), true));
            saleOrderStock.setProduct(ProductMapper.toDto(cmdOrderStock.getPdtProduct(), true));
            saleOrderStock.setDelivery(DeliveryMapper.toDto(cmdOrderStock.getCmdDelivery(), true));
            saleOrderStock.setDeliveryLine(DeliveryLineMapper.toDto(cmdOrderStock.getCmdDeliveryLine(), true));
            saleOrderStock.setUom(UomMapper.toDto(cmdOrderStock.getPdtUom(), true));
            saleOrderStock.setWarehouse(WarehouseMapper.toDto(cmdOrderStock.getWrhWarehouse(), true));
            saleOrderStock.setStock(StockMapper.toDto(cmdOrderStock.getStkStock(), false));
        }
        return saleOrderStock;
    }

    public static CmdSaleOrderStock toEntity(SaleOrderStock saleOrderStock, boolean lazy) {
        if (null == saleOrderStock) {
            return null;
        }
        CmdSaleOrderStock cmdSaleOrderStock = new CmdSaleOrderStock();
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
            cmdSaleOrderStock.setPdtProductDimension(ProductDimensionMapper.toEntity(saleOrderStock.getProductDimension(),true));
            cmdSaleOrderStock.setCmdDelivery(DeliveryMapper.toEntity(saleOrderStock.getDelivery(), true));
            cmdSaleOrderStock.setCmdDeliveryLine(DeliveryLineMapper.toEntity(saleOrderStock.getDeliveryLine(), true));
            cmdSaleOrderStock.setLocLocation(LocationMapper.toEntity(saleOrderStock.getLocation(), true));
            cmdSaleOrderStock.setOwnOwner(OwnerMapper.toEntity(saleOrderStock.getOwner(), true));
            cmdSaleOrderStock.setPrmColor(ColorMapper.toEntity(saleOrderStock.getColor(), true));
            cmdSaleOrderStock.setPdtProduct(ProductMapper.toEntity(saleOrderStock.getProduct(), true));
            cmdSaleOrderStock.setPdtUom(UomMapper.toEntity(saleOrderStock.getUom(), true));
            cmdSaleOrderStock.setPrmBlockType(BlockTypeMapper.toEntity(saleOrderStock.getBlockType(), true));
            cmdSaleOrderStock.setStkContainer(ContainerMapper.toEntity(saleOrderStock.getContainer(), true));
            cmdSaleOrderStock.setWrhWarehouse(WarehouseMapper.toEntity(saleOrderStock.getWarehouse(), true));
            cmdSaleOrderStock.setStkStock(StockMapper.toEntity(saleOrderStock.getStock(), true));
        }
        return cmdSaleOrderStock;
    }

    public static List<SaleOrderStock> toDtos(List<CmdSaleOrderStock> cmdSaleOrderStocks, boolean lazy) {
        if (null == cmdSaleOrderStocks) {
            return null;
        }
        List<SaleOrderStock> saleOrderStocks = new ArrayList<>();
        for (CmdSaleOrderStock cmdSaleOrderStock : cmdSaleOrderStocks) {
            saleOrderStocks.add(toDto(cmdSaleOrderStock, lazy));
        }
        return saleOrderStocks;
    }

    public static List<SaleOrderStock> toDtos(Iterable<CmdSaleOrderStock> cmdSaleOrderStocks, boolean lazy) {
        if (null == cmdSaleOrderStocks) {
            return null;
        }
        List<SaleOrderStock> saleOrderStocks = new ArrayList<>();
        for (CmdSaleOrderStock cmdSaleOrderStock : cmdSaleOrderStocks) {
            saleOrderStocks.add(toDto(cmdSaleOrderStock, lazy));
        }
        return saleOrderStocks;
    }

    public static Set<CmdSaleOrderStock> toEntities(Set<SaleOrderStock> saleOrderStocks, boolean lazy) {
        if (null == saleOrderStocks) {
            return null;
        }
        Set<CmdSaleOrderStock> cmdSaleOrderStocks = new HashSet<>();
        for (SaleOrderStock saleOrderStock : saleOrderStocks) {
            cmdSaleOrderStocks.add(toEntity(saleOrderStock, lazy));
        }
        return cmdSaleOrderStocks;
    }

    public static Set<SaleOrderStock> toDtos(Set<CmdSaleOrderStock> cmdSaleOrderStocks, boolean lazy) {
        if (null == cmdSaleOrderStocks) {
            return null;
        }
        Set<SaleOrderStock> saleOrderStocks = new HashSet<>();
        for (CmdSaleOrderStock cmdSaleOrderStock : cmdSaleOrderStocks) {
            saleOrderStocks.add(toDto(cmdSaleOrderStock, lazy));
        }
        return saleOrderStocks;
    }

}

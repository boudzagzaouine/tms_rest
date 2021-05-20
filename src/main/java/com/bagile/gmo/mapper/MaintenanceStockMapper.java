/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.MaintenanceStock;
import com.bagile.gmo.entities.GmoMaintenanceStock;


import java.util.*;

/**
 * @author aelguezzar
 */
public class MaintenanceStockMapper {
    private MaintenanceStockMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "GmoMaintenanceStockId");
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
        map.put("cineNumber", "GmoMaintenanceStockLineNumber");
        map.put("quantityserved", "GmoMaintenanceStockQuantityserved");
        map.put("transportContainerNo", "GmoMaintenanceStockTransportContainerNo");
        map.put("dlc", "GmoMaintenanceStockDlc");
        map.put("dluo", "GmoMaintenanceStockDluo");
        map.put("serialNo", "GmoMaintenanceStockSerialNo");
        map.put("lot", "GmoMaintenanceStockLot");
        map.put("orderDate", "GmoMaintenanceStockOrderDate");
        map.put("creationDate", "GmoMaintenanceStockCreationDate");
        map.put("updateDate", "GmoMaintenanceStockUpdateDate");
        map.put("maintenance", "gmoMaintenance");
        map.put("actionLineMaintenance", "gmoActionLineMaintenance");
        map.put("weight", "GmoMaintenanceStockWeight");
        map.put("quality", "GmoMaintenanceStockQuality");
        map.put("productDimension", "pdtProductDimension");
        map.put("productPack", "pdtProductPack");
        map.put("stock", "stkStock");


    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static MaintenanceStock toDto(GmoMaintenanceStock gmoMaintenanceStock, boolean lazy) {
        if (null == gmoMaintenanceStock) {
            return null;
        }
        MaintenanceStock maintenanceStock = new MaintenanceStock();
        //MaintenanceStock.setCreationDate(gmoMaintenanceStock.getGmoMaintenanceStockCreationDate());
        maintenanceStock.setDlc(gmoMaintenanceStock.getgmoSaleOrderStockDlc());
        maintenanceStock.setDluo(gmoMaintenanceStock.getgmoSaleOrderStockDluo());
        maintenanceStock.setId(gmoMaintenanceStock.getgmoSaleOrderStockId());
        maintenanceStock.setLineNumber(gmoMaintenanceStock.getgmoSaleOrderStockLineNumber());
        maintenanceStock.setLot(gmoMaintenanceStock.getgmoSaleOrderStockLot());
        maintenanceStock.setOrderDate(gmoMaintenanceStock.getgmoSaleOrderStockOrderDate());
        maintenanceStock.setQuantityServed(gmoMaintenanceStock.getgmoSaleOrderStockQuantityServed());
        maintenanceStock.setSerialNo(gmoMaintenanceStock.getgmoSaleOrderStockSerialNo());
        maintenanceStock.setUpdateDate(gmoMaintenanceStock.getUpdateDate());
        maintenanceStock.setQuality(gmoMaintenanceStock.getgmoSaleOrderStockQuality());
        maintenanceStock.setWeight(gmoMaintenanceStock.getgmoSaleOrderStockWeight());
        maintenanceStock.setUpdatedBy(gmoMaintenanceStock.getUpdatedBy());
        maintenanceStock.setCreatedBy(gmoMaintenanceStock.getCreatedBy());
        if (!lazy) {
          //  MaintenanceStock.setProductDimension(ProductDimensionMapper.toDto(gmoMaintenanceStock.getPdtProductDimension(),true));
            maintenanceStock.setProductPack(ProductPackMapper.toDto(gmoMaintenanceStock.getPdtProductPack(), false));
            maintenanceStock.setBlockType(BlockTypeMapper.toDto(gmoMaintenanceStock.getPrmBlockType(), true));
            maintenanceStock.setContainer(ContainerMapper.toDto(gmoMaintenanceStock.getStkContainer(), true));
            maintenanceStock.setLocation(LocationMapper.toDto(gmoMaintenanceStock.getLocLocation(), true));
           // MaintenanceStock.setColor(ColorMapper.toDto(gmoMaintenanceStock.getPrmColor(), true));
            maintenanceStock.setOwner(OwnerMapper.toDto(gmoMaintenanceStock.getOwnOwner(), true));
            maintenanceStock.setProduct(ProductMapper.toDto(gmoMaintenanceStock.getPdtProduct(), false));
            maintenanceStock.setMaintenance(MaintenanceMapper.toDto(gmoMaintenanceStock.getGmoMaintenance(), true));
            maintenanceStock.setActionLineMaintenance(ActionLineMaintenanceMapper.toDto(gmoMaintenanceStock.getGmoActionLineMaintenance(), false));
            maintenanceStock.setUom(UomMapper.toDto(gmoMaintenanceStock.getPdtUom(), true));
            maintenanceStock.setWarehouse(WarehouseMapper.toDto(gmoMaintenanceStock.getWrhWarehouse(), true));
            maintenanceStock.setStock(StockMapper.toDto(gmoMaintenanceStock.getStkStock(), false));

            maintenanceStock.setDieselDeclaration(DieselDeclarationMapper.toDto(gmoMaintenanceStock.getGmoDieselDeclaration(), false));
        }
        return maintenanceStock;
    }

    public static GmoMaintenanceStock toEntity(MaintenanceStock maintenanceStock, boolean lazy) {
        if (null == maintenanceStock) {
            return null;
        }
        GmoMaintenanceStock gmoMaintenanceStock = new GmoMaintenanceStock();
       // gmoMaintenanceStock.set(maintenanceStock.getCreationDate());
        gmoMaintenanceStock.setgmoSaleOrderStockDlc(maintenanceStock.getDlc());
        gmoMaintenanceStock.setgmoSaleOrderStockDluo(maintenanceStock.getDluo());
        gmoMaintenanceStock.setgmoSaleOrderStockId(maintenanceStock.getId());
        gmoMaintenanceStock.setgmoSaleOrderStockLineNumber(maintenanceStock.getLineNumber());
        gmoMaintenanceStock.setgmoSaleOrderStockLot(maintenanceStock.getLot());
        gmoMaintenanceStock.setgmoSaleOrderStockOrderDate(maintenanceStock.getOrderDate());
        gmoMaintenanceStock.setgmoSaleOrderStockQuantityServed(maintenanceStock.getQuantityServed());
        gmoMaintenanceStock.setgmoSaleOrderStockSerialNo(maintenanceStock.getSerialNo());
        //gmoMaintenanceStock.set(maintenanceStock.getUpdateDate());
        gmoMaintenanceStock.setgmoSaleOrderStockQuality(maintenanceStock.getQuality());
        gmoMaintenanceStock.setgmoSaleOrderStockWeight(maintenanceStock.getWeight());
        gmoMaintenanceStock.setUpdatedBy(maintenanceStock.getUpdatedBy());
        gmoMaintenanceStock.setCreatedBy(maintenanceStock.getCreatedBy());
        if (!lazy) {
            gmoMaintenanceStock.setPdtProductPack(ProductPackMapper.toEntity(maintenanceStock.getProductPack(), true));
          //  gmoMaintenanceStock.setPdtProductDimension(ProductDimensionMapper.toEntity(MaintenanceStock.getProductDimension(),true));
            gmoMaintenanceStock.setGmoMaintenance(MaintenanceMapper.toEntity(maintenanceStock.getMaintenance(), true));
            gmoMaintenanceStock.setGmoActionLineMaintenance(ActionLineMaintenanceMapper.toEntity(maintenanceStock.getActionLineMaintenance(), true));
            gmoMaintenanceStock.setLocLocation(LocationMapper.toEntity(maintenanceStock.getLocation(), true));
            gmoMaintenanceStock.setOwnOwner(OwnerMapper.toEntity(maintenanceStock.getOwner(), true));
            //gmoMaintenanceStock.setPrmColor(ColorMapper.toEntity(maintenanceStock.getColor(), true));
            gmoMaintenanceStock.setPdtProduct(ProductMapper.toEntity(maintenanceStock.getProduct(), true));
            gmoMaintenanceStock.setPdtUom(UomMapper.toEntity(maintenanceStock.getUom(), true));
            gmoMaintenanceStock.setPrmBlockType(BlockTypeMapper.toEntity(maintenanceStock.getBlockType(), true));
            gmoMaintenanceStock.setStkContainer(ContainerMapper.toEntity(maintenanceStock.getContainer(), true));
            gmoMaintenanceStock.setWrhWarehouse(WarehouseMapper.toEntity(maintenanceStock.getWarehouse(), true));
            gmoMaintenanceStock.setStkStock(StockMapper.toEntity(maintenanceStock.getStock(), true));
            gmoMaintenanceStock.setGmoDieselDeclaration(DieselDeclarationMapper.toEntity(maintenanceStock.getDieselDeclaration(), false));

        }
        return gmoMaintenanceStock;
    }

    public static List<MaintenanceStock> toDtos(List<GmoMaintenanceStock> GmoMaintenanceStocks, boolean lazy) {
        if (null == GmoMaintenanceStocks) {
            return null;
        }
        List<MaintenanceStock> MaintenanceStocks = new ArrayList<>();
        for (GmoMaintenanceStock GmoMaintenanceStock : GmoMaintenanceStocks) {
            MaintenanceStocks.add(toDto(GmoMaintenanceStock, lazy));
        }
        return MaintenanceStocks;
    }

    public static List<MaintenanceStock> toDtos(Iterable<GmoMaintenanceStock> GmoMaintenanceStocks, boolean lazy) {
        if (null == GmoMaintenanceStocks) {
            return null;
        }
        List<MaintenanceStock> MaintenanceStocks = new ArrayList<>();
        for (GmoMaintenanceStock GmoMaintenanceStock : GmoMaintenanceStocks) {
            MaintenanceStocks.add(toDto(GmoMaintenanceStock, lazy));
        }
        return MaintenanceStocks;
    }

    public static Set<GmoMaintenanceStock> toEntities(Set<MaintenanceStock> MaintenanceStocks, boolean lazy) {
        if (null == MaintenanceStocks) {
            return null;
        }
        Set<GmoMaintenanceStock> GmoMaintenanceStocks = new HashSet<>();
        for (MaintenanceStock MaintenanceStock : MaintenanceStocks) {
            GmoMaintenanceStocks.add(toEntity(MaintenanceStock, lazy));
        }
        return GmoMaintenanceStocks;
    }

    public static Set<MaintenanceStock> toDtos(Set<GmoMaintenanceStock> GmoMaintenanceStocks, boolean lazy) {
        if (null == GmoMaintenanceStocks) {
            return null;
        }
        Set<MaintenanceStock> MaintenanceStocks = new HashSet<>();
        for (GmoMaintenanceStock GmoMaintenanceStock : GmoMaintenanceStocks) {
            MaintenanceStocks.add(toDto(GmoMaintenanceStock, lazy));
        }
        return MaintenanceStocks;
    }

}

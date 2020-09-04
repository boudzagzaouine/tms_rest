package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Stock;
import com.bagile.gmo.entities.StkStock;


import java.util.*;

public class StockMapper {
    private StockMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "stkStockId");
        map.put("location", "locLocation");
        map.put("owner", "ownOwner");
        map.put("product", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("blockType", "prmBlockType");
        map.put("color", "prmColor");
        map.put("supplier", "rcpSupplier");
        map.put("container", "stkContainer");
        // map.put("warehouse", "wrhWarehouse");
        map.put("quantity", "stkStockQuantity");
        map.put("dlc", "stkStockDlc");
        map.put("dluo", "stkStockDluo");
        map.put("serialNo", "stkStockSerialNo");
        map.put("lot", "stkStockLot");
        map.put("receptionDate", "stkStockReceptionDate");
        map.put("creationDate", "stkStockCreationDate");
        map.put("updateDate", "stkStockUpdateDate");
        map.put("variable1", "stkStockVariable1");
        map.put("variable2", "stkStockVariable2");
        map.put("variable3", "stkStockVariable3");
        map.put("variable4", "stkStockVariable4");
        map.put("variable5", "stkStockVariable5");
        map.put("variable6", "stkStockVariable6");
        map.put("variable7", "stkStockVariable7");
        map.put("variable8", "stkStockVariable8");
        map.put("variable9", "stkStockVariable9");
        map.put("variable10", "stkStockVariable10");
        map.put("kit", "stkStockKit");
        map.put("receptionStock", "rcpReceptionStock");
        map.put("receptionLine", "rcpReceptionLine");
        map.put("weight", "stkStockWeight");
        map.put("quality", "stkStockQuality");
        map.put("comment", "stkStockComment");
        map.put("productDimension", "pdtProductDimension");
        map.put("warehouse", "wrhWarehouse");
        map.put("productPack", "pdtProductPack");
        map.put("accountedSale", "stkStockAccountedSale");
        map.put("accountedPurchase", "stkStockAccountedPurchase");
        map.put("active", "stkStockActive");
        map.put("appliedBruteToNet", "stkStockAppliedBruteToNet");
        map.put("productionLine", "prcProductionLine");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static StkStock toEntity(Stock stock, boolean lazy) {
        if (null == stock) {
            return null;
        }
        StkStock stkStock = new StkStock();
        stkStock.setStkStockId(stock.getId());
        stkStock.setStkStockQuantity(stock.getQuantity());
        stkStock.setStkStockQuantityBaseUom(stock.getQuantityUomBase());
        stkStock.setStkStockDlc(stock.getDlc());
        stkStock.setStkStockDluo(stock.getDluo());
        stkStock.setStkStockSerialNo(stock.getSerialNo());
        stkStock.setStkStockLot(stock.getLot());
        stkStock.setStkStockReceptionDate(stock.getReceptionDate());
        stkStock.setStkStockCreationDate(stock.getCreationDate());
        stkStock.setStkStockUpdateDate(stock.getUpdateDate());
        stkStock.setStkStockVariable1(stock.getVariable1());
        stkStock.setStkStockVariable2(stock.getVariable2());
        stkStock.setStkStockVariable3(stock.getVariable3());
        stkStock.setStkStockVariable4(stock.getVariable4());
        stkStock.setStkStockVariable5(stock.getVariable5());
        stkStock.setStkStockVariable6(stock.getVariable6());
        stkStock.setStkStockVariable7(stock.getVariable7());
        stkStock.setStkStockVariable8(stock.getVariable8());
        stkStock.setStkStockVariable9(stock.getVariable9());
        stkStock.setStkStockVariable10(stock.getVariable10());
        stkStock.setStkStockKit(stock.getKit());
        stkStock.setStkStockQuality(stock.getQuality());
        stkStock.setStkStockWeight(stock.getWeight());
        stkStock.setStkStockComment(stock.getComment());
        stkStock.setStkStockAccountedSale(stock.getAccountedSale());
        stkStock.setStkStockAccountedPurchase(stock.getAccountedPurchase());
        stkStock.setStkStockActive(stock.getActive());
        stkStock.setUpdatedBy(stock.getUpdatedBy());
        stkStock.setCreatedBy(stock.getCreatedBy());
        stkStock.setStkStockPurchasePrice(stock.getPurchasePrice());
        stkStock.setStkStockSalePrice(stock.getSalePrice());
        stkStock.setStkStockAppliedBruteToNet(stock.getAppliedBruteToNet());
        if (!lazy) {
            //stkStock.setPdtProductDimension(ProductDimensionMapper.toEntity(stock.getProductDimension(), true));
           // stkStock.setWrhWarehouse(WarehouseMapper.toEntity(stock.getWarehouse(), true));
            stkStock.setPdtProduct(ProductMapper.toEntity(stock.getProduct(), true));
            stkStock.setOwnOwner(OwnerMapper.toEntity(stock.getOwner(), true));
            stkStock.setRcpSupplier(SupplierMapper.toEntity(stock.getSupplier(), true));
           // stkStock.setPrmBlockType(BlockTypeMapper.toEntity(stock.getBlockType(), true));
           // stkStock.setPrmColor(ColorMapper.toEntity(stock.getColor(), true));
            stkStock.setPdtUom(UomMapper.toEntity(stock.getUom(), true));
            stkStock.setLocLocation(LocationMapper.toEntity(stock.getLocation(), true));
            stkStock.setStkContainer(ContainerMapper.toEntity(stock.getContainer(), true));
            stkStock.setRcpReceptionLine(ReceptionLineMapper.toEntity(stock.getReceptionLine(), true));
            stkStock.setRcpReceptionStock(ReceptionStockMapper.toEntity(stock.getReceptionStock(), true));
            stkStock.setPdtProductPack(ProductPackMapper.toEntity(stock.getProductPack(), true));
         // stkStock.setPrcProductionLine(ProductionLineMapper.toEntity(stock.getProductionLine(), true));
            //stkStock.setWrhWarehouse(WarehouseMapper.toEntity(stock.getWarehouse(), true));
        }
        return stkStock;
    }

    public static Stock toDto(StkStock stkStock, boolean lazy) {
        if (null == stkStock) {
            return null;
        }
        Stock stock = new Stock();
        stock.setId(stkStock.getStkStockId());
        stock.setQuantity(stkStock.getStkStockQuantity());
        stock.setQuantityUomBase(stkStock.getStkStockQuantityBaseUom());
        stock.setDlc(stkStock.getStkStockDlc());
        stock.setDluo(stkStock.getStkStockDluo());
        stock.setSerialNo(stkStock.getStkStockSerialNo());
        stock.setLot(stkStock.getStkStockLot());
        stock.setReceptionDate(stkStock.getStkStockReceptionDate());
        stock.setCreationDate(stkStock.getStkStockCreationDate());
        stock.setUpdateDate(stkStock.getStkStockUpdateDate());
        stock.setVariable1(stkStock.getStkStockVariable1());
        stock.setVariable2(stkStock.getStkStockVariable2());
        stock.setVariable3(stkStock.getStkStockVariable3());
        stock.setVariable4(stkStock.getStkStockVariable4());
        stock.setVariable5(stkStock.getStkStockVariable5());
        stock.setVariable6(stkStock.getStkStockVariable6());
        stock.setVariable7(stkStock.getStkStockVariable7());
        stock.setVariable8(stkStock.getStkStockVariable8());
        stock.setVariable9(stkStock.getStkStockVariable9());
        stock.setVariable10(stkStock.getStkStockVariable10());
        stock.setKit(stkStock.getStkStockKit());
        stock.setQuality(stkStock.getStkStockQuality());
        stock.setWeight(stkStock.getStkStockWeight());
        stock.setComment(stkStock.getStkStockComment());
        stock.setAccountedSale(stkStock.getStkStockAccountedSale());
        stock.setAccountedPurchase(stkStock.getStkStockAccountedPurchase());
        stock.setActive(stkStock.getStkStockActive());
        stock.setPurchasePrice(stkStock.getStkStockPurchasePrice());
        stock.setSalePrice(stkStock.getStkStockSalePrice());
        stock.setAppliedBruteToNet(stkStock.getStkStockAppliedBruteToNet());
        if (!lazy) {
            stock.setProductPack(ProductPackMapper.toDto(stkStock.getPdtProductPack(), false));
          //  stock.setProductDimension(ProductDimensionMapper.toDto(stkStock.getPdtProductDimension(), true));
            stock.setProduct(ProductMapper.toDto(stkStock.getPdtProduct(), false));
          //  stock.setWarehouse(WarehouseMapper.toDto(stkStock.getWrhWarehouse(), true));
            stock.setOwner(OwnerMapper.toDto(stkStock.getOwnOwner(), true));
            stock.setSupplier(SupplierMapper.toDto(stkStock.getRcpSupplier(), true));
         //   stock.setBlockType(BlockTypeMapper.toDto(stkStock.getPrmBlockType(), true));
          //  stock.setColor(ColorMapper.toDto(stkStock.getPrmColor(), true));
            stock.setUom(UomMapper.toDto(stkStock.getPdtUom(), true));
            stock.setLocation(LocationMapper.toDto(stkStock.getLocLocation(), true));
           stock.setContainer(ContainerMapper.toDto(stkStock.getStkContainer(), true));
           stock.setReceptionLine(ReceptionLineMapper.toDto(stkStock.getRcpReceptionLine(), true));
           stock.setReceptionStock(ReceptionStockMapper.toDto(stkStock.getRcpReceptionStock(), true));
        //  stock.setProductionLine(ProductionLineMapper.toDto(stkStock.getPrcProductionLine(), true));
            // stock.setWarehouse(WarehouseMapper.toDto(stkStock.getWrhWarehouse(), true));
        }
        return stock;
    }

   /* public static Stock toViewDto(StkStockView stkStock, boolean lazy) {
        if (null == stkStock) {
            return null;
        }
        Stock stock = new Stock();
        stock.setId(stkStock.getStkStockId());
        stock.setQuantity(stkStock.getStkStockQuantity());
        stock.setDlc(stkStock.getStkStockDlc());
        stock.setDluo(stkStock.getStkStockDluo());
        stock.setSerialNo(stkStock.getStkStockSerialNo());
        stock.setLot(stkStock.getStkStockLot());
        stock.setReceptionDate(stkStock.getStkStockReceptionDate());
        stock.setCreationDate(stkStock.getStkStockCreationDate());
        stock.setUpdateDate(stkStock.getStkStockUpdateDate());
        stock.setVariable1(stkStock.getStkStockVariable1());
        stock.setVariable2(stkStock.getStkStockVariable2());
        stock.setVariable3(stkStock.getStkStockVariable3());
        stock.setVariable4(stkStock.getStkStockVariable4());
        stock.setVariable5(stkStock.getStkStockVariable5());
        stock.setVariable6(stkStock.getStkStockVariable6());
        stock.setVariable7(stkStock.getStkStockVariable7());
        stock.setVariable8(stkStock.getStkStockVariable8());
        stock.setVariable9(stkStock.getStkStockVariable9());
        stock.setVariable10(stkStock.getStkStockVariable10());
        stock.setKit(stkStock.getStkStockKit());
        stock.setQuality(stkStock.getStkStockQuality());
        stock.setWeight(stkStock.getStkStockWeight());
        stock.setComment(stkStock.getStkStockComment());
        stock.setAccountedSale(stkStock.getStkStockAccountedSale());
        stock.setAccountedPurchase(stkStock.getStkStockAccountedPurchase());
        if (!lazy) {
            stock.setProductDimension(ProductDimensionMapper.toDto(stkStock.getPdtProductDimension(), true));
            stock.setProductPack(ProductPackMapper.toDto(stkStock.getPdtProductPack(), false));
            stock.setProduct(ProductMapper.toDto(stkStock.getPdtProduct(), false));
            stock.setWarehouse(WarehouseMapper.toDto(stkStock.getWrhWarehouse(), true));
            stock.setOwner(OwnerMapper.toDto(stkStock.getOwnOwner(), true));
            stock.setSupplier(SupplierMapper.toDto(stkStock.getRcpSupplier(), true));
            stock.setBlockType(BlockTypeMapper.toDto(stkStock.getPrmBlockType(), true));
            stock.setColor(ColorMapper.toDto(stkStock.getPrmColor(), true));
            stock.setUom(UomMapper.toDto(stkStock.getPdtUom(), true));
            stock.setLocation(LocationMapper.toDto(stkStock.getLocLocation(), true));
            stock.setContainer(ContainerMapper.toDto(stkStock.getStkContainer(), true));
            stock.setReceptionLine(ReceptionLineMapper.toDto(stkStock.getRcpReceptionLine(), true));
            stock.setReceptionStock(ReceptionStockMapper.toDto(stkStock.getRcpReceptionStock(), true));

            // stock.setWarehouse(WarehouseMapper.toDto(stkStock.getWrhWarehouse(), true));
        }
        return stock;
    }*/

    public static List<Stock> toDtos(List<StkStock> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<Stock> stocks = new ArrayList<>();
        for (StkStock stkStock : stkStocks) {
            stocks.add(toDto(stkStock, lazy));
        }
        return stocks;
    }

  /* public static List<Stock> toViewDtos(List<StkStockView> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<Stock> stocks = new ArrayList<>();
        for (StkStockView stkStock : stkStocks) {
            stocks.add(toViewDto(stkStock, lazy));
        }
        return stocks;
    }*/

    public static List<Stock> toDtos(Iterable<StkStock> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<Stock> stocks = new ArrayList<>();
        for (StkStock stkStock : stkStocks) {
            stocks.add(toDto(stkStock, lazy));
        }
        return stocks;
    }

    /*public static List<Stock> toViewDtos(Iterable<StkStockView> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<Stock> stocks = new ArrayList<>();
        for (StkStockView stkStock : stkStocks) {
            stocks.add(toViewDto(stkStock, lazy));
        }
        return stocks;
    }*/

    public static Set<StkStock> toEntities(Set<Stock> stocks, boolean lazy) {
        if (null == stocks) {
            return null;
        }
        Set<StkStock> stkStocks = new HashSet<>();
        for (Stock stock : stocks) {
            stkStocks.add(toEntity(stock, lazy));
        }
        return stkStocks;
    }

    public static Set<Stock> toDtos(Set<StkStock> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        Set<Stock> stocks = new HashSet<>();
        for (StkStock stkStock : stkStocks) {
            stocks.add(toDto(stkStock, lazy));
        }
        return stocks;
    }
}

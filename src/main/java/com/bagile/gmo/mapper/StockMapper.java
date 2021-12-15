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
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
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
        map.put("gmao", "stkStockGmao");
        map.put("saleOrderLine", "cmdSaleOrderLine");

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
        StkStock stkStocks = new StkStock();
        stkStocks.setStkStockId(stock.getId());
        stkStocks.setStkStockQuantity(stock.getQuantity());
        stkStocks.setStkStockQuantityBaseUom(stock.getQuantityUomBase());
        stkStocks.setStkStockDlc(stock.getDlc());
        stkStocks.setStkStockDluo(stock.getDluo());
        stkStocks.setStkStockSerialNo(stock.getSerialNo());
        stkStocks.setStkStockLot(stock.getLot());
        stkStocks.setStkStockReceptionDate(stock.getReceptionDate());
        stkStocks.setCreationDate(stock.getCreationDate());
        stkStocks.setUpdateDate(stock.getUpdateDate());
        stkStocks.setStkStockVariable1(stock.getVariable1());
        stkStocks.setStkStockVariable2(stock.getVariable2());
        stkStocks.setStkStockVariable3(stock.getVariable3());
        stkStocks.setStkStockVariable4(stock.getVariable4());
        stkStocks.setStkStockVariable5(stock.getVariable5());
        stkStocks.setStkStockVariable6(stock.getVariable6());
        stkStocks.setStkStockVariable7(stock.getVariable7());
        stkStocks.setStkStockVariable8(stock.getVariable8());
        stkStocks.setStkStockVariable9(stock.getVariable9());
        stkStocks.setStkStockVariable10(stock.getVariable10());
        stkStocks.setStkStockKit(stock.getKit());
        stkStocks.setStkStockQuality(stock.getQuality());
        stkStocks.setStkStockWeight(stock.getWeight());
        stkStocks.setStkStockComment(stock.getComment());
        stkStocks.setStkStockAccountedSale(stock.getAccountedSale());
        stkStocks.setStkStockAccountedPurchase(stock.getAccountedPurchase());
        stkStocks.setStkStockActive(stock.getActive());
        stkStocks.setUpdatedBy(stock.getUpdatedBy());
        stkStocks.setCreatedBy(stock.getCreatedBy());
        stkStocks.setStkStockPurchasePrice(stock.getPurchasePrice());
        stkStocks.setStkStockSalePrice(stock.getSalePrice());
        stkStocks.setStkStockAppliedBruteToNet(stock.getAppliedBruteToNet());
        stkStocks.setStkStockGmao(stock.getGmao());

        if (!lazy) {
            //stkStocks.setPdtProductDimension(ProductDimensionMapper.toEntity(stock.getProductDimension(), true));
           // stkStocks.setWrhWarehouse(WarehouseMapper.toEntity(stock.getWarehouse(), true));
            stkStocks.setPdtProduct(ProductMapper.toEntity(stock.getProduct(), true));
            stkStocks.setOwnOwner(OwnerMapper.toEntity(stock.getOwner(), true));
            stkStocks.setRcpSupplier(SupplierMapper.toEntity(stock.getSupplier(), false));
           // stkStocks.setPrmBlockType(BlockTypeMapper.toEntity(stock.getBlockType(), true));
           // stkStocks.setPrmColor(ColorMapper.toEntity(stock.getColor(), true));
            stkStocks.setPdtUom(UomMapper.toEntity(stock.getUom(), true));
            stkStocks.setLocLocation(LocationMapper.toEntity(stock.getLocation(), true));
            stkStocks.setStkContainer(ContainerMapper.toEntity(stock.getContainer(), false));
            stkStocks.setRcpReceptionLine(ReceptionLineMapper.toEntity(stock.getReceptionLine(), true));
            stkStocks.setRcpReceptionStock(ReceptionStockMapper.toEntity(stock.getReceptionStock(), true));
            stkStocks.setPdtProductPack(ProductPackMapper.toEntity(stock.getProductPack(), true));
            stkStocks.setCmdSaleOrderLine(SaleOrderLineMapper.toEntity(stock.getSaleOrderLine(), true));

            // stkStocks.setPrcProductionLine(ProductionLineMapper.toEntity(stock.getProductionLine(), true));
            //stkStocks.setWrhWarehouse(WarehouseMapper.toEntity(stock.getWarehouse(), true));
        }
        return stkStocks;
    }

    public static Stock toDto(StkStock stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        Stock stock = new Stock();
        stock.setId(stkStocks.getStkStockId());
        stock.setQuantity(stkStocks.getStkStockQuantity());
        stock.setQuantityUomBase(stkStocks.getStkStockQuantityBaseUom());
        stock.setDlc(stkStocks.getStkStockDlc());
        stock.setDluo(stkStocks.getStkStockDluo());
        stock.setSerialNo(stkStocks.getStkStockSerialNo());
        stock.setLot(stkStocks.getStkStockLot());
        stock.setReceptionDate(stkStocks.getStkStockReceptionDate());
        stock.setCreationDate(stkStocks.getCreationDate());
        stock.setUpdateDate(stkStocks.getUpdateDate());
        stock.setVariable1(stkStocks.getStkStockVariable1());
        stock.setVariable2(stkStocks.getStkStockVariable2());
        stock.setVariable3(stkStocks.getStkStockVariable3());
        stock.setVariable4(stkStocks.getStkStockVariable4());
        stock.setVariable5(stkStocks.getStkStockVariable5());
        stock.setVariable6(stkStocks.getStkStockVariable6());
        stock.setVariable7(stkStocks.getStkStockVariable7());
        stock.setVariable8(stkStocks.getStkStockVariable8());
        stock.setVariable9(stkStocks.getStkStockVariable9());
        stock.setVariable10(stkStocks.getStkStockVariable10());
        stock.setKit(stkStocks.getStkStockKit());
        stock.setQuality(stkStocks.getStkStockQuality());
        stock.setWeight(stkStocks.getStkStockWeight());
        stock.setComment(stkStocks.getStkStockComment());
        stock.setAccountedSale(stkStocks.getStkStockAccountedSale());
        stock.setAccountedPurchase(stkStocks.getStkStockAccountedPurchase());
        stock.setActive(stkStocks.getStkStockActive());
        stock.setPurchasePrice(stkStocks.getStkStockPurchasePrice());
        stock.setSalePrice(stkStocks.getStkStockSalePrice());
        stock.setAppliedBruteToNet(stkStocks.getStkStockAppliedBruteToNet());
        stock.setGmao(stkStocks.getStkStockGmao());

        if (!lazy) {
            stock.setProductPack(ProductPackMapper.toDto(stkStocks.getPdtProductPack(), false));
          //  stock.setProductDimension(ProductDimensionMapper.toDto(stkStocks.getPdtProductDimension(), true));
            stock.setProduct(ProductMapper.toDto(stkStocks.getPdtProduct(), false));
          //  stock.setWarehouse(WarehouseMapper.toDto(stkStocks.getWrhWarehouse(), true));
            stock.setOwner(OwnerMapper.toDto(stkStocks.getOwnOwner(), true));
            stock.setSupplier(SupplierMapper.toDto(stkStocks.getRcpSupplier(), false));
         //   stock.setBlockType(BlockTypeMapper.toDto(stkStocks.getPrmBlockType(), true));
          //  stock.setColor(ColorMapper.toDto(stkStocks.getPrmColor(), true));
            stock.setUom(UomMapper.toDto(stkStocks.getPdtUom(), true));
            stock.setLocation(LocationMapper.toDto(stkStocks.getLocLocation(), true));
           stock.setContainer(ContainerMapper.toDto(stkStocks.getStkContainer(), false));
           stock.setReceptionLine(ReceptionLineMapper.toDto(stkStocks.getRcpReceptionLine(), true));
           stock.setReceptionStock(ReceptionStockMapper.toDto(stkStocks.getRcpReceptionStock(), true));
            stock.setSaleOrderLine(SaleOrderLineMapper.toDto(stkStocks.getCmdSaleOrderLine(), true));


            //  stock.setProductionLine(ProductionLineMapper.toDto(stkStocks.getPrcProductionLine(), true));
            // stock.setWarehouse(WarehouseMapper.toDto(stkStocks.getWrhWarehouse(), true));
        }
        return stock;
    }

   /* public static Stock toViewDto(StkStockView stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        Stock stock = new Stock();
        stock.setId(stkStocks.getStkStockId());
        stock.setQuantity(stkStocks.getStkStockQuantity());
        stock.setDlc(stkStocks.getStkStockDlc());
        stock.setDluo(stkStocks.getStkStockDluo());
        stock.setSerialNo(stkStocks.getStkStockSerialNo());
        stock.setLot(stkStocks.getStkStockLot());
        stock.setReceptionDate(stkStocks.getStkStockReceptionDate());
        stock.setCreationDate(stkStocks.getStkStockCreationDate());
        stock.setUpdateDate(stkStocks.getStkStockUpdateDate());
        stock.setVariable1(stkStocks.getStkStockVariable1());
        stock.setVariable2(stkStocks.getStkStockVariable2());
        stock.setVariable3(stkStocks.getStkStockVariable3());
        stock.setVariable4(stkStocks.getStkStockVariable4());
        stock.setVariable5(stkStocks.getStkStockVariable5());
        stock.setVariable6(stkStocks.getStkStockVariable6());
        stock.setVariable7(stkStocks.getStkStockVariable7());
        stock.setVariable8(stkStocks.getStkStockVariable8());
        stock.setVariable9(stkStocks.getStkStockVariable9());
        stock.setVariable10(stkStocks.getStkStockVariable10());
        stock.setKit(stkStocks.getStkStockKit());
        stock.setQuality(stkStocks.getStkStockQuality());
        stock.setWeight(stkStocks.getStkStockWeight());
        stock.setComment(stkStocks.getStkStockComment());
        stock.setAccountedSale(stkStocks.getStkStockAccountedSale());
        stock.setAccountedPurchase(stkStocks.getStkStockAccountedPurchase());
        if (!lazy) {
            stock.setProductDimension(ProductDimensionMapper.toDto(stkStocks.getPdtProductDimension(), true));
            stock.setProductPack(ProductPackMapper.toDto(stkStocks.getPdtProductPack(), false));
            stock.setProduct(ProductMapper.toDto(stkStocks.getPdtProduct(), false));
            stock.setWarehouse(WarehouseMapper.toDto(stkStocks.getWrhWarehouse(), true));
            stock.setOwner(OwnerMapper.toDto(stkStocks.getOwnOwner(), true));
            stock.setSupplier(SupplierMapper.toDto(stkStocks.getRcpSupplier(), true));
            stock.setBlockType(BlockTypeMapper.toDto(stkStocks.getPrmBlockType(), true));
            stock.setColor(ColorMapper.toDto(stkStocks.getPrmColor(), true));
            stock.setUom(UomMapper.toDto(stkStocks.getPdtUom(), true));
            stock.setLocation(LocationMapper.toDto(stkStocks.getLocLocation(), true));
            stock.setContainer(ContainerMapper.toDto(stkStocks.getStkContainer(), true));
            stock.setReceptionLine(ReceptionLineMapper.toDto(stkStocks.getRcpReceptionLine(), true));
            stock.setReceptionStock(ReceptionStockMapper.toDto(stkStocks.getRcpReceptionStock(), true));

            // stock.setWarehouse(WarehouseMapper.toDto(stkStocks.getWrhWarehouse(), true));
        }
        return stock;
    }*/

    

  /* public static List<Stock> toViewDtos(List<StkStockView> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<Stock> stocks = new ArrayList<>();
        for (StkStockView stkStocks : stkStocks) {
            stocks.add(toViewDto(stkStocks, lazy));
        }
        return stocks;
    }*/
  
    /*public static List<Stock> toDtos(Iterable< ? extends StkStock> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<Stock> stocks = new ArrayList<>();
        for (StkStock stkStocks : stkStocks) {
            stocks.add(toDto(stkStocks, lazy));
        }
        return stocks;
    }*/

    /*public static List<Stock> toViewDtos(Iterable<StkStockView> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<Stock> stocks = new ArrayList<>();
        for (StkStockView stkStocks : stkStocks) {
            stocks.add(toViewDto(stkStocks, lazy));
        }
        return stocks;
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

    public static List<Stock> toDtos(Iterable< ? extends StkStock> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<Stock> stocks = new ArrayList<>();
        for (StkStock stkStock : stkStocks) {
            stocks.add(toDto(stkStock, lazy));
        }
        return stocks;
    }


    public static Set<StkStock> toEntities(List<Stock> stocks, boolean lazy) {
        if (null == stocks) {
            return null;
        }
        Set<StkStock> stkStocks = new HashSet<>();
        for (Stock stock : stocks) {
            stkStocks.add(toEntity(stock, lazy));
        }
        return stkStocks;
    }


}

package com.bagile.tms.mapper;

import com.bagile.tms.dto.Stock;
import com.bagile.tms.entities.StkStock;

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
        map.put("receptionLine", "rcpReceptionLine");
        map.put("weight", "stkStockWeight");
        map.put("quality", "stkStockQuality");
        map.put("comment", "stkStockComment");
        map.put("receptionStock", "rcpReceptionStock");
        map.put("productDimension", "pdtProductDimension");


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

        stkStock.setStkStockComment(stock.getComment());
        stkStock.setStkStockActive(stock.getActive());
        if (!lazy) {
            stkStock.setPdtProduct(ProductMapper.toEntity(stock.getProduct(), true));
            stkStock.setOwnOwner(OwnerMapper.toEntity(stock.getOwner(), true));
            stkStock.setPdtUom(UomMapper.toEntity(stock.getUom(), true));
            stkStock.setStkContainer(ContainerMapper.toEntity(stock.getContainer(), true));


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
        stock.setComment(stkStock.getStkStockComment());
        stock.setActive(stkStock.getStkStockActive());
        if (!lazy) {
            stock.setProduct(ProductMapper.toDto(stkStock.getPdtProduct(), true));
            stock.setOwner(OwnerMapper.toDto(stkStock.getOwnOwner(), true));
            stock.setUom(UomMapper.toDto(stkStock.getPdtUom(), true));
            stock.setContainer(ContainerMapper.toDto(stkStock.getStkContainer(), true));

            // stock.setWarehouse(WarehouseMapper.toDto(stkStock.getWrhWarehouse(), true));
        }
        return stock;
    }


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

package com.sinno.ems.mapper;

import java.util.*;

public class StockArcMapper {
    private StockArcMapper() {
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
        map.put("receptionStock","rcpReceptionStock");
        map.put("receptionLine","rcpReceptionLine");
        map.put("weight","stkStockWeight");
        map.put("quality","stkStockQuality");
        map.put("comment","stkStockComment");




    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static StkStockArc toEntity(StockArc stock, boolean lazy) {
        if (null == stock) {
            return null;
        }
        StkStockArc stkStock = new StkStockArc();
        stkStock.setStkStockId(stock.getId());
        stkStock.setStkStockQuantity(stock.getQuantity());
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
        if (!lazy) {
            stkStock.setPdtProduct(ProductMapper.toEntity(stock.getProduct(), true));
            stkStock.setOwnOwner(OwnerMapper.toEntity(stock.getOwner(), true));
            stkStock.setRcpSupplier(SupplierMapper.toEntity(stock.getSupplier(), true));
            stkStock.setPrmBlockType(BlockTypeMapper.toEntity(stock.getBlockType(), true));
            stkStock.setPrmColor(ColorMapper.toEntity(stock.getColor(), true));
            stkStock.setPdtUom(UomMapper.toEntity(stock.getUom(), true));
            stkStock.setLocLocation(LocationMapper.toEntity(stock.getLocation(), true));
            stkStock.setStkContainer(ContainerArcMapper.toEntity(stock.getContainer(), true));
            stkStock.setRcpReceptionLine(ReceptionLineMapper.toEntity(stock.getReceptionLine(),true));


            //stkStock.setWrhWarehouse(WarehouseMapper.toEntity(stock.getWarehouse(), true));
        }
        return stkStock;
    }

    public static StockArc toDto(StkStockArc stkStock, boolean lazy) {
        if (null == stkStock) {
            return null;
        }
        StockArc stock = new StockArc();
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
        if (!lazy) {
            stock.setProduct(ProductMapper.toDto(stkStock.getPdtProduct(), true));
            stock.setOwner(OwnerMapper.toDto(stkStock.getOwnOwner(), true));
            stock.setSupplier(SupplierMapper.toDto(stkStock.getRcpSupplier(), true));
            stock.setBlockType(BlockTypeMapper.toDto(stkStock.getPrmBlockType(), true));
            stock.setColor(ColorMapper.toDto(stkStock.getPrmColor(), true));
            stock.setUom(UomMapper.toDto(stkStock.getPdtUom(), true));
            stock.setLocation(LocationMapper.toDto(stkStock.getLocLocation(), true));
            stock.setContainer(ContainerArcMapper.toDto(stkStock.getStkContainer(), true));
            stock.setReceptionLine(ReceptionLineMapper.toDto(stkStock.getRcpReceptionLine(),true));

            // stock.setWarehouse(WarehouseMapper.toDto(stkStock.getWrhWarehouse(), true));
        }
        return stock;
    }

    public static List<StockArc> toDtos(List<StkStockArc> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<StockArc> stocks = new ArrayList<>();
        for (StkStockArc stkStock : stkStocks) {
            stocks.add(toDto(stkStock, lazy));
        }
        return stocks;
    }

    public static List<StockArc> toDtos(Iterable<StkStockArc> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        List<StockArc> stocks = new ArrayList<>();
        for (StkStockArc stkStock : stkStocks) {
            stocks.add(toDto(stkStock, lazy));
        }
        return stocks;
    }

    public static Set<StkStockArc> toEntities(Set<StockArc> stocks, boolean lazy) {
        if (null == stocks) {
            return null;
        }
        Set<StkStockArc> stkStocks = new HashSet<>();
        for (StockArc stock : stocks) {
            stkStocks.add(toEntity(stock, lazy));
        }
        return stkStocks;
    }

    public static Set<StockArc> toDtos(Set<StkStockArc> stkStocks, boolean lazy) {
        if (null == stkStocks) {
            return null;
        }
        Set<StockArc> stocks = new HashSet<>();
        for (StkStockArc stkStock : stkStocks) {
            stocks.add(toDto(stkStock, lazy));
        }
        return stocks;
    }
}

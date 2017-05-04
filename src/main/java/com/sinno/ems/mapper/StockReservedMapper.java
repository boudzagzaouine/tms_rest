package com.sinno.ems.mapper;

import com.sinno.ems.dto.StockReserved;
import com.sinno.ems.entities.StkStockReserved;

import java.util.*;

public class StockReservedMapper {
    private StockReservedMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","stkStockReservedId");
        map.put("account","cmdAccount");
        map.put("saleOrder","cmdSaleOrder");
        map.put("saleOrderLine","cmdSaleOrderLine");
        map.put("owner","ownOwner");
        map.put("product","pdtProduct");
        map.put("uom","pdtUom");
        map.put("blockType","prmBlockType");
        map.put("color","prmColor");
        map.put("supplier","rcpSupplier");
        map.put("warehouse","wrhWarehouse");
        map.put("quantity","stkStockReservedQuantity");
        map.put("dlc","stkStockReservedDlc");
        map.put("dluo","stkStockReservedDluo");
        map.put("serialNo","stkStockReservedSerialNo");
        map.put("lot","stkStockReservedLot");
        map.put("receptionDate","stkStockReservedReceptionDate");
        map.put("creationDate","stkStockReservedCreationDate");
        map.put("updateDate","stkStockReservedUpdateDate");
        map.put("weight","stkStockReservedWeight");
        map.put("quality","stkStockReservedQuality");
        map.put("productDimensionOld", "pdtProductDimensionOld");
        map.put("productDimensionNew", "pdtProductDimensionNew");

    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static StkStockReserved toEntity(StockReserved stockReserved, boolean lazy) {
        if (null == stockReserved) {
            return null;
        }
        StkStockReserved stkStockReserved = new StkStockReserved();
        stkStockReserved.setStkStockReservedId(stockReserved.getId());
        stkStockReserved.setStkStockReservedQuantity(stockReserved.getQuantity());
        stkStockReserved.setStkStockReservedDlc(stockReserved.getDlc());
        stkStockReserved.setStkStockReservedDluo(stockReserved.getDluo());
        stkStockReserved.setStkStockReservedSerialNo(stockReserved.getSerialNo());
        stkStockReserved.setStkStockReservedLot(stockReserved.getLot());
        stkStockReserved.setStkStockReservedReceptionDate(stockReserved.getReceptionDate());
        stkStockReserved.setStkStockReservedCreationDate(stockReserved.getCreationDate());
        stkStockReserved.setStkStockReservedUpdateDate(stockReserved.getUpdateDate());
        stkStockReserved.setStkStockReservedQuality(stockReserved.getQuality());
        if (!lazy) {
            stkStockReserved.setPdtProductDimensionNew(ProductDimensionMapper.toEntity(stockReserved.getProductDimensionNew(),true));
            stkStockReserved.setPdtProductDimensionOld(ProductDimensionMapper.toEntity(stockReserved.getProductDimensionOld(),true));
            stkStockReserved.setCmdSaleOrderLine(SaleOrderLineMapper.toEntity(stockReserved.getSaleOrderLine(), true));
            stkStockReserved.setPdtProduct(ProductMapper.toEntity(stockReserved.getProduct(), true));
            stkStockReserved.setOwnOwner(OwnerMapper.toEntity(stockReserved.getOwner(), true));
            stkStockReserved.setRcpSupplier(SupplierMapper.toEntity(stockReserved.getSupplier(), true));
            stkStockReserved.setPrmBlockType(BlockTypeMapper.toEntity(stockReserved.getBlockType(), true));
            stkStockReserved.setPrmColor(ColorMapper.toEntity(stockReserved.getColor(), true));
            stkStockReserved.setPdtUom(UomMapper.toEntity(stockReserved.getUom(), true));
            stkStockReserved.setWrhWarehouse(WarehouseMapper.toEntity(stockReserved.getWarehouse(), true));
            stkStockReserved.setCmdAccount(AccountMapper.toEntity(stockReserved.getAccount(), true));
            stkStockReserved.setCmdSaleOrder(SaleOrderMapper.toEntity(stockReserved.getSaleOrder(), true));
        }
        return stkStockReserved;
    }

    public static StockReserved toDto(StkStockReserved stkStockReserved, boolean lazy) {
        if (null == stkStockReserved) {
            return null;
        }
        StockReserved stockReserved = new StockReserved();
        stockReserved.setId(stkStockReserved.getStkStockReservedId());
        stockReserved.setQuantity(stkStockReserved.getStkStockReservedQuantity());
        stockReserved.setDlc(stkStockReserved.getStkStockReservedDlc());
        stockReserved.setDluo(stkStockReserved.getStkStockReservedDluo());
        stockReserved.setSerialNo(stkStockReserved.getStkStockReservedSerialNo());
        stockReserved.setLot(stkStockReserved.getStkStockReservedLot());
        stockReserved.setReceptionDate(stkStockReserved.getStkStockReservedReceptionDate());
        stockReserved.setCreationDate(stkStockReserved.getStkStockReservedCreationDate());
        stockReserved.setUpdateDate(stkStockReserved.getStkStockReservedUpdateDate());
        stockReserved.setWeight(stkStockReserved.getStkStockReservedWeight());
        if (!lazy) {
            stockReserved.setSaleOrderLine(SaleOrderLineMapper.toDto(stkStockReserved.getCmdSaleOrderLine(), true));
            stockReserved.setProduct(ProductMapper.toDto(stkStockReserved.getPdtProduct(), true));
            stockReserved.setOwner(OwnerMapper.toDto(stkStockReserved.getOwnOwner(), true));
            stockReserved.setSupplier(SupplierMapper.toDto(stkStockReserved.getRcpSupplier(), true));
            stockReserved.setBlockType(BlockTypeMapper.toDto(stkStockReserved.getPrmBlockType(), true));
            stockReserved.setColor(ColorMapper.toDto(stkStockReserved.getPrmColor(), true));
            stockReserved.setUom(UomMapper.toDto(stkStockReserved.getPdtUom(), true));
            stockReserved.setWarehouse(WarehouseMapper.toDto(stkStockReserved.getWrhWarehouse(), true));
            stockReserved.setAccount(AccountMapper.toDto(stkStockReserved.getCmdAccount(), true));
            stockReserved.setSaleOrder(SaleOrderMapper.toDto(stkStockReserved.getCmdSaleOrder(), true));
        }
        return stockReserved;
    }

    public static List<StockReserved> toDtos(List<StkStockReserved> stkStockReserveds, boolean lazy) {
        if (null == stkStockReserveds) {
            return null;
        }
        List<StockReserved> stockReserveds = new ArrayList<>();
        for (StkStockReserved stkStockReserved : stkStockReserveds) {
            stockReserveds.add(toDto(stkStockReserved, lazy));
        }
        return stockReserveds;
    }

    public static List<StockReserved> toDtos(Iterable<StkStockReserved> stkStockReserveds, boolean lazy) {
        if (null == stkStockReserveds) {
            return null;
        }
        List<StockReserved> stockReserveds = new ArrayList<>();
        for (StkStockReserved stkStockReserved : stkStockReserveds) {
            stockReserveds.add(toDto(stkStockReserved, lazy));
        }
        return stockReserveds;
    }

    public static Set<StkStockReserved> toEntities(Set<StockReserved> stockReserveds, boolean lazy) {
        if (null == stockReserveds) {
            return null;
        }
        Set<StkStockReserved> stkStockReserveds = new HashSet<>();
        for (StockReserved stockReserved : stockReserveds) {
            stkStockReserveds.add(toEntity(stockReserved, lazy));
        }
        return stkStockReserveds;
    }

    public static Set<StockReserved> toDtos(Set<StkStockReserved> stkStockReserveds, boolean lazy) {
        if (null == stkStockReserveds) {
            return null;
        }
        Set<StockReserved> stockReserveds = new HashSet<>();
        for (StkStockReserved stkStockReserved : stkStockReserveds) {
            stockReserveds.add(toDto(stkStockReserved, lazy));
        }
        return stockReserveds;
    }
}

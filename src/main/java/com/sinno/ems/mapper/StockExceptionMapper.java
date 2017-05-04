package com.sinno.ems.mapper;

import com.sinno.ems.dto.StockException;
import com.sinno.ems.entities.StkStockException;

import java.util.*;

/**
 * Created by ASMAE on 27/04/2016.
 */
public class StockExceptionMapper {
    private StockExceptionMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "stkStockExceptionId");
        map.put("reason", "stkStockExceptionReason");
        map.put("locationOld", "locLocationOld");
        map.put("owner", "ownOwnerOld");
        map.put("productOld", "pdtProductOld");
        map.put("uomOld", "pdtUomOld");
        map.put("uomNew", "pdtUomNew");
        map.put("blockTypeOld", "prmBlockTypeOld");
        map.put("colorOld", "prmColorOld");
        map.put("supplierOld", "rcpSupplierOld");
        map.put("containerOld", "stkContainerOld");
        // map.put("warehouse", "wrhWarehouse");
        map.put("quantityOld", "stkStockExceptionQuantityOld");
        map.put("quantityNew", "stkStockExceptionQuantityNew");
        map.put("dlcOld", "stkStockExceptionDlcOld");
        map.put("dluoOld", "stkStockExceptionDluoOld");
        map.put("serialNoOld", "stkStockExceptionSerialNooldOld");
        map.put("lotOld", "stkStockExceptionLotOld");
        map.put("receptionDateOld", "stkStockExceptionReceptionDateOld");
        map.put("creationDateOld", "stkStockExceptionCreationDateOld");
        map.put("creationDateNew", "stkStockExceptionCreationDateNew");
        map.put("updateDateOld", "stkStockExceptionUpdateDateOld");
        map.put("variable1Old", "stkStockExceptionVariable1Old");
        map.put("variable2Old", "stkStockExceptionVariable2Old");
        map.put("variable3Old", "stkStockExceptionVariable3Old");
        map.put("variable4Old", "stkStockExceptionVariable4Old");
        map.put("variable5Old", "stkStockExceptionVariable5Old");
        map.put("variable6Old", "stkStockExceptionVariable6Old");
        map.put("variable7Old", "stkStockExceptionVariable7Old");
        map.put("variable8Old", "stkStockExceptionVariable8Old");
        map.put("variable9Old", "stkStockExceptionVariable9Old");
        map.put("variable10Old", "stkStockExceptionVariable10Old");
        map.put("kitOld", "stkStockExceptionKitOld");
        map.put("receptionLineOld", "rcpReceptionLineOld");
        map.put("weightOld", "stkStockExceptionWeightOld");
        map.put("qualityOld", "stkStockExceptionQualityOld");
        map.put("weightNew", "stkStockExceptionWeightNew");
        map.put("qualityNew", "stkStockExceptionQualityNew");
        map.put("exception", "stkException");
        map.put("action", "stkStockExceptionAction");
        map.put("user", "usrUser");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static StkStockException toEntity(StockException stockException, boolean lazy) {
        if (null == stockException) {
            return null;
        }
        StkStockException stkStockException = new StkStockException();
        stkStockException.setStkStockExceptionId(stockException.getId());
        stkStockException.setStkStockExceptionReason(stockException.getReason());
        stkStockException.setStkStockExceptionQuantityOld(stockException.getQuantityOld());
        stkStockException.setStkStockExceptionQuantityNew(stockException.getQuantityNew());
        stkStockException.setStkStockExceptionDlcOld(stockException.getDlcOld());
        stkStockException.setStkStockExceptionDluoOld(stockException.getDluoOld());
        stkStockException.setStkStockExceptionSerialNoOld(stockException.getSerialNoOld());
        stkStockException.setStkStockExceptionLotOld(stockException.getLotOld());
        stkStockException.setStkStockExceptionReceptionDateOld(stockException.getReceptionDateOld());
        stkStockException.setStkStockExceptionCreationDateOld(stockException.getCreationDateOld());
        stkStockException.setStkStockExceptionCreationDateNew(stockException.getCreationDateNew());
        stkStockException.setStkStockExceptionUpdateDateOld(stockException.getUpdateDateOld());
        stkStockException.setStkStockExceptionVariable1Old(stockException.getVariable1Old());
        stkStockException.setStkStockExceptionVariable2Old(stockException.getVariable2Old());
        stkStockException.setStkStockExceptionVariable3Old(stockException.getVariable3Old());
        stkStockException.setStkStockExceptionVariable4Old(stockException.getVariable4Old());
        stkStockException.setStkStockExceptionVariable5Old(stockException.getVariable5Old());
        stkStockException.setStkStockExceptionVariable6Old(stockException.getVariable6Old());
        stkStockException.setStkStockExceptionVariable7Old(stockException.getVariable7Old());
        stkStockException.setStkStockExceptionVariable8Old(stockException.getVariable8Old());
        stkStockException.setStkStockExceptionVariable9Old(stockException.getVariable9Old());
        stkStockException.setStkStockExceptionVariable10Old(stockException.getVariable10Old());
        stkStockException.setStkStockExceptioKitOld(stockException.getKitOld());
        stkStockException.setStkStockExceptionQualityNew(stockException.getQualityNew());
        stkStockException.setStkStockExceptionQuantityOld(stockException.getQuantityOld());
        stkStockException.setStkStockExceptionWeightNew(stockException.getWeightNew());
        stkStockException.setStkStockExceptionWeightOld(stockException.getWeightOld());
        stkStockException.setStkStockExceptionAction(stockException.getAction());
        if (!lazy) {
            stkStockException.setStkException(ExceptionMapper.toEntity(stockException.getException(), true));
            stkStockException.setUsrUser(UserMapper.toEntity(stockException.getUser(), true));
            stkStockException.setPdtProductOld(ProductMapper.toEntity(stockException.getProductOld(), true));
            stkStockException.setOwnOwnerOld(OwnerMapper.toEntity(stockException.getOwner(), true));
            stkStockException.setRcpSupplierOld(SupplierMapper.toEntity(stockException.getSupplierOld(), true));
            stkStockException.setPrmBlockTypeOld(BlockTypeMapper.toEntity(stockException.getBlockTypeOld(), true));
            stkStockException.setPrmColorOld(ColorMapper.toEntity(stockException.getColorOld(), true));
            stkStockException.setPdtUomOld(UomMapper.toEntity(stockException.getUomOld(), true));
            stkStockException.setPdtUomNew(UomMapper.toEntity(stockException.getUomNew(), true));
            stkStockException.setLocLocationOld(LocationMapper.toEntity(stockException.getLocationOld(), true));
            stkStockException.setStkContainerOld(ContainerMapper.toEntity(stockException.getContainerOld(), true));
            //stkStock.setWrhWarehouse(WarehouseMapper.toEntity(stock.getWarehouse(), true));
            stkStockException.setRcpReceptionLineOld(ReceptionLineMapper.toEntity(stockException.getReceptionLineOld(), true));
            stkStockException.setStkException(ExceptionMapper.toEntity(stockException.getException(), true));
        }
        return stkStockException;
    }

    public static StockException toDto(StkStockException stkStockException, boolean lazy) {
        if (null == stkStockException) {
            return null;
        }
        StockException stockException = new StockException();
        stockException.setId(stkStockException.getStkStockExceptionId());
        stockException.setReason(stkStockException.getStkStockExceptionReason());
        stockException.setQuantityOld(stkStockException.getStkStockExceptionQuantityOld());
        stockException.setDlcOld(stkStockException.getStkStockExceptionDlcOld());
        stockException.setDluoOld(stkStockException.getStkStockExceptionDluoOld());
        stockException.setSerialNoOld(stkStockException.getStkStockExceptionSerialNoOld());
        stockException.setLotOld(stkStockException.getStkStockExceptionLotOld());
        stockException.setReceptionDateOld(stkStockException.getStkStockExceptionReceptionDateOld());
        stockException.setCreationDateOld(stkStockException.getStkStockExceptionCreationDateOld());
        stockException.setCreationDateNew(stkStockException.getStkStockExceptionCreationDateNew());
        stockException.setUpdateDateOld(stkStockException.getStkStockExceptionUpdateDateOld());
        stockException.setVariable1Old(stkStockException.getStkStockExceptionVariable1Old());
        stockException.setVariable2Old(stkStockException.getStkStockExceptionVariable2Old());
        stockException.setVariable3Old(stkStockException.getStkStockExceptionVariable3Old());
        stockException.setVariable4Old(stkStockException.getStkStockExceptionVariable4Old());
        stockException.setVariable5Old(stkStockException.getStkStockExceptionVariable5Old());
        stockException.setVariable6Old(stkStockException.getStkStockExceptionVariable6Old());
        stockException.setVariable7Old(stkStockException.getStkStockExceptionVariable7Old());
        stockException.setVariable8Old(stkStockException.getStkStockExceptionVariable8Old());
        stockException.setVariable9Old(stkStockException.getStkStockExceptionVariable9Old());
        stockException.setVariable10Old(stkStockException.getStkStockExceptionVariable10Old());
        stockException.setKitOld(stkStockException.getStkStockExceptioKitOld());
        stockException.setQuantityNew(stkStockException.getStkStockExceptionQuantityNew());
        stockException.setQuantityOld(stkStockException.getStkStockExceptionQuantityOld());
        stockException.setQualityOld(stkStockException.getStkStockExceptionQualityOld());
        stockException.setQualityNew(stkStockException.getStkStockExceptionQualityNew());
        stockException.setWeightNew(stkStockException.getStkStockExceptionWeightNew());
        stockException.setWeightOld(stkStockException.getStkStockExceptionWeightOld());
        stockException.setAction(stkStockException.getStkStockExceptionAction());
        if (!lazy) {
            stockException.setProductOld(ProductMapper.toDto(stkStockException.getPdtProductOld(), true));
            stockException.setException(ExceptionMapper.toDto(stkStockException.getStkException(), true));
            stockException.setUser(UserMapper.toDto(stkStockException.getUsrUser(), true));
            stockException.setOwner(OwnerMapper.toDto(stkStockException.getOwnOwnerOld(), true));
            stockException.setSupplierOld(SupplierMapper.toDto(stkStockException.getRcpSupplierOld(), true));
            stockException.setBlockTypeOld(BlockTypeMapper.toDto(stkStockException.getPrmBlockTypeOld(), true));
            stockException.setColorOld(ColorMapper.toDto(stkStockException.getPrmColorOld(), true));
            stockException.setUomOld(UomMapper.toDto(stkStockException.getPdtUomOld(), true));
            stockException.setUomNew(UomMapper.toDto(stkStockException.getPdtUomNew(), true));
            stockException.setLocationOld(LocationMapper.toDto(stkStockException.getLocLocationOld(), true));
            stockException.setContainerOld(ContainerMapper.toDto(stkStockException.getStkContainerOld(), true));
            // stock.setWarehouse(WarehouseMapper.toDto(stkStock.getWrhWarehouse(), true));
            stockException.setReceptionLineOld(ReceptionLineMapper.toDto(stkStockException.getRcpReceptionLineOld(), true));
            stockException.setException(ExceptionMapper.toDto(stkStockException.getStkException(), true));
        }
        return stockException;
    }

    public static List<StockException> toDtos(List<StkStockException> stkStocksExceptions, boolean lazy) {
        if (null == stkStocksExceptions) {
            return null;
        }
        List<StockException> stocksExceptions = new ArrayList<>();
        for (StkStockException stkStockException : stkStocksExceptions) {
            stocksExceptions.add(toDto(stkStockException, lazy));
        }
        return stocksExceptions;
    }

    public static List<StockException> toDtos(Iterable<StkStockException> stkStocksExceptions, boolean lazy) {
        if (null == stkStocksExceptions) {
            return null;
        }
        List<StockException> stocksExceptions = new ArrayList<>();
        for (StkStockException stkStockException : stkStocksExceptions) {
            stocksExceptions.add(toDto(stkStockException, lazy));
        }
        return stocksExceptions;
    }

    public static Set<StkStockException> toEntities(Set<StockException> stocksExceptions, boolean lazy) {
        if (null == stocksExceptions) {
            return null;
        }
        Set<StkStockException> stkStocksExceptions = new HashSet<>();
        for (StockException stockException : stocksExceptions) {
            stkStocksExceptions.add(toEntity(stockException, lazy));
        }
        return stkStocksExceptions;
    }

    public static Set<StockException> toDtos(Set<StkStockException> stkStocksExceptions, boolean lazy) {
        if (null == stkStocksExceptions) {
            return null;
        }
        Set<StockException> stocksExceptions = new HashSet<>();
        for (StkStockException stkStockException : stkStocksExceptions) {
            stocksExceptions.add(toDto(stkStockException, lazy));
        }
        return stocksExceptions;
    }
}

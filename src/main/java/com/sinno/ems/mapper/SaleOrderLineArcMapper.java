/**
 *
 */
package com.sinno.ems.mapper;

import java.util.*;

/**
 * @author aelguezzar
 */
public class SaleOrderLineArcMapper {
    private SaleOrderLineArcMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","cmdSaleOrderLineId");
        map.put("saleOrder","cmdSaleOrder");
        map.put("location","locLocation");
        map.put("owner","ownOwner");
        map.put("product","pdtProduct");
        map.put("uom","pdtUom");
        map.put("blockType","prmBlockType");
        map.put("color","prmColor");
        map.put("orderStatus","prmOrderStatus");
        map.put("transport","trpTransport");
        map.put("warehouse","wrhWarehouse");
        map.put("lineNumber","cmdSaleOrderLineLineNumber");
        map.put("quantity","cmdSaleOrderLineQuantity");
        map.put("quantityServed","cmdSaleOrderLineQuantityServed");
        map.put("description","cmdSaleOrderLineDescription");
        map.put("container","stkContainer");
        map.put("dlc","cmdSaleOrderLineDlc");
        map.put("dluo","cmdSaleOrderLineDluo");
        map.put("serialNo","cmdSaleOrderLineSerialNo");
        map.put("lot","cmdSaleOrderLineLot");
        map.put("date","cmdSaleOrderLineDate");
        map.put("creationDate","cmdSaleOrderLineCreationDate");
        map.put("updateDate","cmdSaleOrderLineUpdateDate");
        map.put("variable1","cmdSaleOrderLineVariable1");
        map.put("variable2","cmdSaleOrderLineVariable2");
        map.put("variable3","cmdSaleOrderLineVariable3");
        map.put("variable4","cmdSaleOrderLineVariable4");
        map.put("variable5","cmdSaleOrderLineVariable5");
        map.put("variable6","cmdSaleOrderLineVariable6");
        map.put("variable7","cmdSaleOrderLineVariable7");
        map.put("variable8","cmdSaleOrderLineVariable8");
        map.put("variable9","cmdSaleOrderLineVariable9");
        map.put("variable10","cmdSaleOrderLineVariable10");
        map.put("comment","cmdSaleOrderLineComment");
        map.put("weight","cmdSaleOrderLineWeight");
        map.put("quality","cmdSaleOrderLineQuality");
    }

    public static String getField(String key) {
        return map.get(key);
    }



    public static Map<String, String> getMap() {
        return map;
    }

    public static SaleOrderLineArc toDto(CmdSaleOrderLineArc cmdSaleOrderLine, boolean lazy) {
        if (null == cmdSaleOrderLine) {
            return null;
        }
        SaleOrderLineArc saleOrderLine = new SaleOrderLineArc();
        saleOrderLine.setCreationDate(cmdSaleOrderLine.getCmdSaleOrderLineCreationDate());
        saleOrderLine.setDate(cmdSaleOrderLine.getCmdSaleOrderLineDate());
        saleOrderLine.setDescription(cmdSaleOrderLine.getCmdSaleOrderLineDescription());
        saleOrderLine.setDlc(cmdSaleOrderLine.getCmdSaleOrderLineDlc());
        saleOrderLine.setDluo(cmdSaleOrderLine.getCmdSaleOrderLineDluo());
        saleOrderLine.setId(cmdSaleOrderLine.getCmdSaleOrderLineId());
        saleOrderLine.setLineNumber(cmdSaleOrderLine.getCmdSaleOrderLineLineNumber());
        saleOrderLine.setLot(cmdSaleOrderLine.getCmdSaleOrderLineLot());
        saleOrderLine.setQuantity(cmdSaleOrderLine.getCmdSaleOrderLineQuantity());
        saleOrderLine.setQuantityServed(cmdSaleOrderLine.getCmdSaleOrderLineQuantityServed());
        saleOrderLine.setSerialNo(cmdSaleOrderLine.getCmdSaleOrderLineSerialNo());
        saleOrderLine.setUpdateDate(cmdSaleOrderLine.getCmdSaleOrderLineUpdateDate());
        saleOrderLine.setVariable1(cmdSaleOrderLine.getCmdSaleOrderLineVariable1());
        saleOrderLine.setVariable2(cmdSaleOrderLine.getCmdSaleOrderLineVariable2());
        saleOrderLine.setVariable3(cmdSaleOrderLine.getCmdSaleOrderLineVariable3());
        saleOrderLine.setVariable4(cmdSaleOrderLine.getCmdSaleOrderLineVariable4());
        saleOrderLine.setVariable5(cmdSaleOrderLine.getCmdSaleOrderLineVariable5());
        saleOrderLine.setVariable6(cmdSaleOrderLine.getCmdSaleOrderLineVariable6());
        saleOrderLine.setVariable7(cmdSaleOrderLine.getCmdSaleOrderLineVariable7());
        saleOrderLine.setVariable8(cmdSaleOrderLine.getCmdSaleOrderLineVariable8());
        saleOrderLine.setVariable9(cmdSaleOrderLine.getCmdSaleOrderLineVariable9());
        saleOrderLine.setVariable10(cmdSaleOrderLine.getCmdSaleOrderLineVariable10());
        saleOrderLine.setComment(cmdSaleOrderLine.getCmdSaleOrderLineComment());
        saleOrderLine.setQuality(cmdSaleOrderLine.getCmdSaleOrderLineQuality());
        saleOrderLine.setWeight(cmdSaleOrderLine.getCmdSaleOrderLineWeight());
        if (!lazy) {
            saleOrderLine.setContainer(ContainerArcMapper.toDto(cmdSaleOrderLine.getStkContainer(),true));
            saleOrderLine.setBlockType(BlockTypeMapper.toDto(cmdSaleOrderLine.getPrmBlockType(), true));
            saleOrderLine.setColor(ColorMapper.toDto(cmdSaleOrderLine.getPrmColor(), true));
            saleOrderLine.setLocation(LocationMapper.toDto(cmdSaleOrderLine.getLocLocation(), true));
            saleOrderLine.setOrderStatus(OrderStatusMapper.toDto(cmdSaleOrderLine.getPrmOrderStatus(), true));
            saleOrderLine.setOwner(OwnerMapper.toDto(cmdSaleOrderLine.getOwnOwner(), true));
            saleOrderLine.setProduct(ProductMapper.toDto(cmdSaleOrderLine.getPdtProduct(), true));
            saleOrderLine.setSaleOrder(SaleOrderArcMapper.toDto(cmdSaleOrderLine.getCmdSaleOrder(), true));
//            saleOrderLine.setSaleOrderStockArcs(SaleOrderStockArcMapper.toDtos(cmdSaleOrderLine.getCmdSaleOrderStockArcs(), true));
//            saleOrderLine.setSaleOrderStocks(SaleOrderStockMapper.toDtos(cmdSaleOrderLine.getCmdSaleOrderStocks(), true));
//            saleOrderLine.setStockReserveds(StockReservedMapper.toDtos(cmdSaleOrderLine.getStkStockReserveds(), true));
            saleOrderLine.setTransport(TransportMapper.toDto(cmdSaleOrderLine.getTrpTransport(), true));
            saleOrderLine.setUom(UomMapper.toDto(cmdSaleOrderLine.getPdtUom(), true));
            saleOrderLine.setWarehouse(WarehouseMapper.toDto(cmdSaleOrderLine.getWrhWarehouse(), true));
        }
        return saleOrderLine;
    }

    public static CmdSaleOrderLineArc toEntity(SaleOrderLineArc saleOrderLine, boolean lazy) {
        if (null == saleOrderLine) {
            return null;
        }
        CmdSaleOrderLineArc cmdSaleOrderLine = new CmdSaleOrderLineArc();
        cmdSaleOrderLine.setCmdSaleOrderLineCreationDate(saleOrderLine.getCreationDate());
        cmdSaleOrderLine.setCmdSaleOrderLineDate(saleOrderLine.getDate());
        cmdSaleOrderLine.setCmdSaleOrderLineDescription(saleOrderLine.getDescription());
        cmdSaleOrderLine.setCmdSaleOrderLineDlc(saleOrderLine.getDlc());
        cmdSaleOrderLine.setCmdSaleOrderLineDluo(saleOrderLine.getDluo());
        cmdSaleOrderLine.setCmdSaleOrderLineId(saleOrderLine.getId());
        cmdSaleOrderLine.setCmdSaleOrderLineLineNumber(saleOrderLine.getLineNumber());
        cmdSaleOrderLine.setCmdSaleOrderLineLot(saleOrderLine.getLot());
        cmdSaleOrderLine.setCmdSaleOrderLineQuantity(saleOrderLine.getQuantity());
        cmdSaleOrderLine.setCmdSaleOrderLineQuantityServed(saleOrderLine.getQuantityServed());
        cmdSaleOrderLine.setCmdSaleOrderLineSerialNo(saleOrderLine.getSerialNo());
        cmdSaleOrderLine.setCmdSaleOrderLineUpdateDate(saleOrderLine.getUpdateDate());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable1(saleOrderLine.getVariable1());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable2(saleOrderLine.getVariable2());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable3(saleOrderLine.getVariable3());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable4(saleOrderLine.getVariable4());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable5(saleOrderLine.getVariable5());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable6(saleOrderLine.getVariable6());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable7(saleOrderLine.getVariable7());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable8(saleOrderLine.getVariable8());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable9(saleOrderLine.getVariable9());
        cmdSaleOrderLine.setCmdSaleOrderLineVariable10(saleOrderLine.getVariable10());
        cmdSaleOrderLine.setCmdSaleOrderLineComment(saleOrderLine.getComment());
        cmdSaleOrderLine.setCmdSaleOrderLineQuality(saleOrderLine.getQuality());
        cmdSaleOrderLine.setCmdSaleOrderLineWeight(saleOrderLine.getWeight());
        if (!lazy) {
            cmdSaleOrderLine.setStkContainer(ContainerArcMapper.toEntity(saleOrderLine.getContainer(),true));
            cmdSaleOrderLine.setCmdSaleOrder(SaleOrderArcMapper.toEntity(saleOrderLine.getSaleOrder(), true));
//            cmdSaleOrderLine.setCmdSaleOrderStockArcs(SaleOrderStockArcMapper.toEntities(saleOrderLine.getSaleOrderStockArcs(), true));
//            cmdSaleOrderLine.setCmdSaleOrderStocks(SaleOrderStockMapper.toEntities(saleOrderLine.getSaleOrderStocks(), true));
            cmdSaleOrderLine.setLocLocation(LocationMapper.toEntity(saleOrderLine.getLocation(), true));
            cmdSaleOrderLine.setOwnOwner(OwnerMapper.toEntity(saleOrderLine.getOwner(), true));
            cmdSaleOrderLine.setPdtProduct(ProductMapper.toEntity(saleOrderLine.getProduct(), true));
            cmdSaleOrderLine.setPdtUom(UomMapper.toEntity(saleOrderLine.getUom(), true));
            cmdSaleOrderLine.setPrmBlockType(BlockTypeMapper.toEntity(saleOrderLine.getBlockType(), true));
            cmdSaleOrderLine.setPrmColor(ColorMapper.toEntity(saleOrderLine.getColor(), true));
            cmdSaleOrderLine.setPrmOrderStatus(OrderStatusMapper.toEntity(saleOrderLine.getOrderStatus(), true));
//            cmdSaleOrderLine.setStkStockReserveds(StockReservedMapper.toEntities(saleOrderLine.getStockReserveds(), true));
            cmdSaleOrderLine.setTrpTransport(TransportMapper.toEntity(saleOrderLine.getTransport(), true));
            cmdSaleOrderLine.setWrhWarehouse(WarehouseMapper.toEntity(saleOrderLine.getWarehouse(), true));
        }
        return cmdSaleOrderLine;
    }

    public static List<SaleOrderLineArc> toDtos(List<CmdSaleOrderLineArc> cmdOrderLines, boolean lazy) {
        if (null == cmdOrderLines) {
            return null;
        }
        List<SaleOrderLineArc> saleOrderLines = new ArrayList<>();
        for (CmdSaleOrderLineArc cmdSaleOrderLine : cmdOrderLines) {
            saleOrderLines.add(toDto(cmdSaleOrderLine, lazy));
        }
        return saleOrderLines;
    }

    public static List<SaleOrderLineArc> toDtos(Iterable<CmdSaleOrderLineArc> cmdOrderLines, boolean lazy) {
        if (null == cmdOrderLines) {
            return null;
        }
        List<SaleOrderLineArc> saleOrderLines = new ArrayList<>();
        for (CmdSaleOrderLineArc cmdSaleOrderLine : cmdOrderLines) {
            saleOrderLines.add(toDto(cmdSaleOrderLine, lazy));
        }
        return saleOrderLines;
    }

    public static Set<CmdSaleOrderLineArc> toEntities(Set<SaleOrderLineArc> saleOrderLines, boolean lazy) {
        if (null == saleOrderLines) {
            return null;
        }
        Set<CmdSaleOrderLineArc> cmdSaleOrderLines = new HashSet<>();
        for (SaleOrderLineArc saleOrderLine : saleOrderLines) {
            cmdSaleOrderLines.add(toEntity(saleOrderLine, lazy));
        }
        return cmdSaleOrderLines;
    }

    public static Set<SaleOrderLineArc> toDtos(Set<CmdSaleOrderLineArc> cmdOrderLines, boolean lazy) {
        if (null == cmdOrderLines) {
            return null;
        }
        Set<SaleOrderLineArc> saleOrderLines = new HashSet<>();
        for (CmdSaleOrderLineArc cmdSaleOrderLine : cmdOrderLines) {
            saleOrderLines.add(toDto(cmdSaleOrderLine, lazy));
        }
        return saleOrderLines;
    }


}

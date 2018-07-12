package com.sinno.ems.mapper;

import java.util.*;

public class ReceptionLineArcMapper {
    private ReceptionLineArcMapper(){}

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id","rcpReceptionLineId");
        map.put("location","locLocation");
        map.put("owner","ownOwner");
        map.put("product","pdtProduct");
        map.put("uom","pdtUom");
        map.put("uomReceived","pdtUomReceived");
        map.put("blockType","prmBlockType");
        map.put("color","prmColor");
        map.put("orderStatus","prmOrderStatus");
        map.put("purshaseOrderLine","rcpPurshaseOrderLine");
        map.put("reception","rcpReception");
        map.put("warehouse","wrhWarehouse");
        map.put("lineNumber","rcpReceptionLineLineNumber");
        map.put("quantity","rcpReceptionLineQuantity");
        map.put("quantityReceived","rcpReceptionLineQuantityReceived");
        map.put("description","rcpReceptionLineDescription");
        map.put("containerCode","rcpReceptionLineContainerCode");
        map.put("dlc","rcpReceptionLineDlc");
        map.put("dluo","rcpReceptionLineDluo");
        map.put("serialNo","rcpReceptionLineSerialNo");
        map.put("lot","rcpReceptionLineLot");
        map.put("receptionDate","rcpReceptionLineReceptionDate");
        map.put("creationDate","rcpReceptionLineCreationDate");
        map.put("updateDate","rcpReceptionLineUpdateDate");
        map.put("variable1","rcpReceptionLineVariable1");
        map.put("variable2","rcpReceptionLineVariable2");
        map.put("variable3","rcpReceptionLineVariable3");
        map.put("variable4","rcpReceptionLineVariable4");
        map.put("variable5","rcpReceptionLineVariable5");
        map.put("variable6","rcpReceptionLineVariable6");
        map.put("variable7","rcpReceptionLineVariable7");
        map.put("variable8","rcpReceptionLineVariable8");
        map.put("variable9","rcpReceptionLineVariable9");
        map.put("variable10","rcpReceptionLineVariable10");
        map.put("quantityClosed","rcpReceptionLineQuantityClosed");
        map.put("suppOfLife","rcpReceptionLineSuppOfLife");
        map.put("weight","rcpReceptionLineWeight");
        map.put("quality","rcpReceptionLineQuality");
        map.put("comment","rcpReceptionLineComment");
        map.put("blockedQuantity","rcpReceptionLineBlockedQuantity");


    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static RcpReceptionLineArc toEntity(ReceptionLineArc receptionLine, boolean lazy) {
        if (null == receptionLine) {
            return null;
        }
        RcpReceptionLineArc rcpReceptionLine = new RcpReceptionLineArc();
        rcpReceptionLine.setRcpReceptionLineId(receptionLine.getId());
        rcpReceptionLine.setRcpReceptionLineLineNumber(receptionLine.getLineNumber());
        rcpReceptionLine.setRcpReceptionLineQuantity(receptionLine.getQuantity());
        rcpReceptionLine.setRcpReceptionLineQuantityReceived(receptionLine.getQuantityReceived());
        rcpReceptionLine.setRcpReceptionLineDescription(receptionLine.getDescription());
        rcpReceptionLine.setRcpReceptionLineContainerCode(receptionLine.getContainerCode());
        rcpReceptionLine.setRcpReceptionLineDlc(receptionLine.getDlc());
        rcpReceptionLine.setRcpReceptionLineDluo(receptionLine.getDluo());
        rcpReceptionLine.setRcpReceptionLineSerialNo(receptionLine.getSerialNo());
        rcpReceptionLine.setRcpReceptionLineLot(receptionLine.getLot());
        rcpReceptionLine.setRcpReceptionLineReceptionDate(receptionLine.getReceptionDate());
        rcpReceptionLine.setRcpReceptionLineCreationDate(receptionLine.getCreationDate());
        rcpReceptionLine.setRcpReceptionLineUpdateDate(receptionLine.getUpdateDate());
        rcpReceptionLine.setRcpReceptionLineVariable1(receptionLine.getVariable1());
        rcpReceptionLine.setRcpReceptionLineVariable2(receptionLine.getVariable2());
        rcpReceptionLine.setRcpReceptionLineVariable3(receptionLine.getVariable3());
        rcpReceptionLine.setRcpReceptionLineVariable4(receptionLine.getVariable4());
        rcpReceptionLine.setRcpReceptionLineVariable5(receptionLine.getVariable5());
        rcpReceptionLine.setRcpReceptionLineVariable6(receptionLine.getVariable6());
        rcpReceptionLine.setRcpReceptionLineVariable7(receptionLine.getVariable7());
        rcpReceptionLine.setRcpReceptionLineVariable8(receptionLine.getVariable8());
        rcpReceptionLine.setRcpReceptionLineVariable9(receptionLine.getVariable9());
        rcpReceptionLine.setRcpReceptionLineVariable10(receptionLine.getVariable10());
        rcpReceptionLine.setRcpReceptionQuantityClosed(receptionLine.getQuantityClosed());
        rcpReceptionLine.setRcpReceptionSuppOfLife(receptionLine.getSuppOfLife());
        rcpReceptionLine.setRcpReceptionLineWeight(receptionLine.getWeight());
        rcpReceptionLine.setRcpReceptionLineQuality(receptionLine.getQuality());
        rcpReceptionLine.setRcpReceptionLineComment(receptionLine.getComment());
        rcpReceptionLine.setRcpReceptionLineBlockedQuantity(receptionLine.getBlockedQuantity());
        if (!lazy) {
            rcpReceptionLine.setRcpPurshaseOrderLine(PurshaseOrderLineArcMapper.toEntity(receptionLine.getPurshaseOrderLine(), true));// TODO
            rcpReceptionLine.setRcpReception(ReceptionArcMapper.toEntity(receptionLine.getReception(), true));
            rcpReceptionLine.setOwnOwner(OwnerMapper.toEntity(receptionLine.getOwner(), true));
            rcpReceptionLine.setPdtProduct(ProductMapper.toEntity(receptionLine.getProduct(), true));
            rcpReceptionLine.setPrmBlockType(BlockTypeMapper.toEntity(receptionLine.getBlockType(), true));
            rcpReceptionLine.setPrmColor(ColorMapper.toEntity(receptionLine.getColor(), true));
            rcpReceptionLine.setPdtUom(UomMapper.toEntity(receptionLine.getUom(), true));
            rcpReceptionLine.setPdtUomReceived(UomMapper.toEntity(receptionLine.getUomReceived(),true));
            rcpReceptionLine.setLocLocation(LocationMapper.toEntity(receptionLine.getLocation(), true));
            rcpReceptionLine.setWrhWarehouse(WarehouseMapper.toEntity(receptionLine.getWarehouse(), true));
            rcpReceptionLine.setPrmOrderStatus(OrderStatusMapper.toEntity(receptionLine.getOrderStatus(), true));
//            rcpReceptionLine.setRcpReceptionStockArcs(ReceptionStockArcMapper.toEntities(receptionLine.getReceptionStockArcs(), true));
//            rcpReceptionLine.setRcpReceptionStocks(ReceptionStockMapper.toEntities(receptionLine.getReceptionStocks(), true));
//            rcpReceptionLine.setRcpReceptionLineArcs(ReceptionLineArcMapper.toEntities(receptionLine.getReceptionLineArcs(), true));

        }
        return rcpReceptionLine;
    }

    public static ReceptionLineArc toDto(RcpReceptionLineArc rcpReceptionLine, boolean lazy) {
        if (null == rcpReceptionLine) {
            return null;
        }
        ReceptionLineArc receptionLine = new ReceptionLineArc();
        receptionLine.setId(rcpReceptionLine.getRcpReceptionLineId());
        receptionLine.setLineNumber(rcpReceptionLine.getRcpReceptionLineLineNumber());
        receptionLine.setQuantity(rcpReceptionLine.getRcpReceptionLineQuantity());
        receptionLine.setQuantityReceived(rcpReceptionLine.getRcpReceptionLineQuantityReceived());
        receptionLine.setDescription(rcpReceptionLine.getRcpReceptionLineDescription());//
        receptionLine.setContainerCode(rcpReceptionLine.getRcpReceptionLineContainerCode());
        receptionLine.setDlc(rcpReceptionLine.getRcpReceptionLineDlc());
        receptionLine.setDluo(rcpReceptionLine.getRcpReceptionLineDluo());
        receptionLine.setSerialNo(rcpReceptionLine.getRcpReceptionLineSerialNo());
        receptionLine.setLot(rcpReceptionLine.getRcpReceptionLineLot());
        receptionLine.setReceptionDate(rcpReceptionLine.getRcpReceptionLineReceptionDate());
        receptionLine.setCreationDate(rcpReceptionLine.getRcpReceptionLineCreationDate());
        receptionLine.setUpdateDate(rcpReceptionLine.getRcpReceptionLineUpdateDate());
        receptionLine.setVariable1(rcpReceptionLine.getRcpReceptionLineVariable1());
        receptionLine.setVariable2(rcpReceptionLine.getRcpReceptionLineVariable2());
        receptionLine.setVariable3(rcpReceptionLine.getRcpReceptionLineVariable3());
        receptionLine.setVariable4(rcpReceptionLine.getRcpReceptionLineVariable4());
        receptionLine.setVariable5(rcpReceptionLine.getRcpReceptionLineVariable5());
        receptionLine.setVariable6(rcpReceptionLine.getRcpReceptionLineVariable6());
        receptionLine.setVariable7(rcpReceptionLine.getRcpReceptionLineVariable7());
        receptionLine.setVariable8(rcpReceptionLine.getRcpReceptionLineVariable8());
        receptionLine.setVariable9(rcpReceptionLine.getRcpReceptionLineVariable9());
        receptionLine.setVariable10(rcpReceptionLine.getRcpReceptionLineVariable10());
        receptionLine.setQuantityClosed(rcpReceptionLine.getRcpReceptionQuantityClosed());
        receptionLine.setSuppOfLife(rcpReceptionLine.getRcpReceptionSuppOfLife());
        receptionLine.setWeight(rcpReceptionLine.getRcpReceptionLineWeight());
        receptionLine.setQuality(rcpReceptionLine.getRcpReceptionLineQuality());
        receptionLine.setComment(rcpReceptionLine.getRcpReceptionLineComment());
        receptionLine.setBlockedQuantity(rcpReceptionLine.getRcpReceptionLineBlockedQuantity());
        if (!lazy) {
            receptionLine.setPurshaseOrderLine(PurshaseOrderLineArcMapper.toDto(rcpReceptionLine.getRcpPurshaseOrderLine(), true));
            receptionLine.setReception(ReceptionArcMapper.toDto(rcpReceptionLine.getRcpReception(), true));
            receptionLine.setOwner(OwnerMapper.toDto(rcpReceptionLine.getOwnOwner(), true));
            receptionLine.setProduct(ProductMapper.toDto(rcpReceptionLine.getPdtProduct(), true));
            receptionLine.setBlockType(BlockTypeMapper.toDto(rcpReceptionLine.getPrmBlockType(), true));
            receptionLine.setColor(ColorMapper.toDto(rcpReceptionLine.getPrmColor(), true));
            receptionLine.setUom(UomMapper.toDto(rcpReceptionLine.getPdtUom(), true));
            receptionLine.setUomReceived(UomMapper.toDto(rcpReceptionLine.getPdtUomReceived(),true));
            receptionLine.setLocation(LocationMapper.toDto(rcpReceptionLine.getLocLocation(), true));
            receptionLine.setWarehouse(WarehouseMapper.toDto(rcpReceptionLine.getWrhWarehouse(), true));
            receptionLine.setOrderStatus(OrderStatusMapper.toDto(rcpReceptionLine.getPrmOrderStatus(), true));

//            receptionLine.setReceptionStockArcs(ReceptionStockArcMapper.toDtos(rcpReceptionLine.getRcpReceptionStockArcs(), true));
//            receptionLine.setReceptionStocks(ReceptionStockMapper.toDtos(rcpReceptionLine.getRcpReceptionStocks(), true));
//            receptionLine.setReceptionLineArcs(ReceptionLineArcMapper.toDtos(rcpReceptionLine.getRcpReceptionLineArcs(), true));
        }
        return receptionLine;
    }

    public static List<ReceptionLineArc> toDtos(List<RcpReceptionLineArc> rcpReceptionLines, boolean lazy) {
        if (null == rcpReceptionLines) {
            return null;
        }
        List<ReceptionLineArc> receptionLines = new ArrayList<>();
        for (RcpReceptionLineArc rcpReceptionLine : rcpReceptionLines) {
            receptionLines.add(toDto(rcpReceptionLine, lazy));
        }
        return receptionLines;
    }

    public static List<ReceptionLineArc> toDtos(Iterable<RcpReceptionLineArc> rcpReceptionLines, boolean lazy) {
        if (null == rcpReceptionLines) {
            return null;
        }
        List<ReceptionLineArc> receptionLines = new ArrayList<>();
        for (RcpReceptionLineArc rcpReceptionLine : rcpReceptionLines) {
            receptionLines.add(toDto(rcpReceptionLine, lazy));
        }
        return receptionLines;
    }

    public static Set<RcpReceptionLineArc> toEntities(Set<ReceptionLineArc> receptionLines, boolean lazy) {
        if (null == receptionLines) {
            return null;
        }
        Set<RcpReceptionLineArc> rcpReceptionLines = new HashSet<>();
        for (ReceptionLineArc rurshaseOrder : receptionLines) {
            rcpReceptionLines.add(toEntity(rurshaseOrder, lazy));
        }
        return rcpReceptionLines;
    }

    public static Set<ReceptionLineArc> toDtos(Set<RcpReceptionLineArc> rcpReceptionLines, boolean lazy) {
        if (null == rcpReceptionLines) {
            return null;
        }
        Set<ReceptionLineArc> receptionLines = new HashSet<>();
        for (RcpReceptionLineArc rcpReceptionLine : rcpReceptionLines) {
            receptionLines.add(toDto(rcpReceptionLine, lazy));
        }
        return receptionLines;
    }
}

package com.sinno.ems.mapper;

import java.util.*;

public class PurshaseOrderLineArcMapper {
    private PurshaseOrderLineArcMapper() {
    }
    
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","rcpPurshaseOrderLineId");
        map.put("location","locLocation");
        map.put("owner","ownOwner");
        map.put("product","pdtProduct");
        map.put("uom","pdtUom");
        map.put("uomReceived","pdtUomReceived");
        map.put("blockType","prmBlockType");
        map.put("color","prmColor");
        map.put("orderStatus","prmOrderStatus");
        map.put("purshaseOrder","rcpPurshaseOrder");
        map.put("warehouse","wrhWarehouse");
        map.put("number","rcpPurshaseOrderLineNumber");
        map.put("quantity","rcpPurshaseOrderLineQuantity");
        map.put("quantityReceived","rcpPurshaseOrderLineQuantityReceived");
        map.put("description","rcpPurshaseOrderLineDescription");
        map.put("containerCode","rcpPurshaseOrderLineContainerCode");
        map.put("dlc","rcpPurshaseOrderLineDlc");
        map.put("dluo","rcpPurshaseOrderLineDluo");
        map.put("serialNo","rcpPurshaseOrderLineSerialNo");
        map.put("lot","rcpPurshaseOrderLineLot");
        map.put("receptionDate","rcpPurshaseOrderLineReceptionDate");
        map.put("creationDate","rcpPurshaseOrderLineCreationDate");
        map.put("updateDate","rcpPurshaseOrderLineUpdateDate");
        map.put("variable1","rcpPurshaseOrderLineVariable1");
        map.put("variable2","rcpPurshaseOrderLineVariable2");
        map.put("variable3","rcpPurshaseOrderLineVariable3");
        map.put("variable4","rcpPurshaseOrderLineVariable4");
        map.put("variable5","rcpPurshaseOrderLineVariable5");
        map.put("variable6","rcpPurshaseOrderLineVariable6");
        map.put("variable7","rcpPurshaseOrderLineVariable7");
        map.put("variable8","rcpPurshaseOrderLineVariable8");
        map.put("variable9","rcpPurshaseOrderLineVariable9");
        map.put("variable10","rcpPurshaseOrderLineVariable10");
        map.put("quantityClosed","rcpPurshaseOrderLineQuantityClosed");
        map.put("comment","rcpPurshaseOrderLineComment");
        map.put("suppOfLife","rcpPurshaseOrderLineSuppOfLife");
        map.put("weight","rcpPurshaseOrderLineWeight");
        map.put("quality","rcpPurshaseOrderLineQuality");
        map.put("blockedQuantity","rcpPurshaseOrderLineBlockedQuantity");


    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static RcpPurshaseOrderLineArc toEntity(PurshaseOrderLineArc purshaseOrderLine, boolean lazy) {
        if (null == purshaseOrderLine) {
            return null;
        }
        RcpPurshaseOrderLineArc rcpPurshaseOrderLine = new RcpPurshaseOrderLineArc();
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineId(purshaseOrderLine.getId());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineNumber(purshaseOrderLine.getNumber());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineQuantity(purshaseOrderLine.getQuantity());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineQuantityReceived(purshaseOrderLine.getQuantityReceived());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineDescription(purshaseOrderLine.getDescription());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineContainerCode(purshaseOrderLine.getContainerCode());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineDlc(purshaseOrderLine.getDlc());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineDluo(purshaseOrderLine.getDluo());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineSerialNo(purshaseOrderLine.getSerialNo());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineLot(purshaseOrderLine.getLot());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineReceptionDate(purshaseOrderLine.getReceptionDate());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineCreationDate(purshaseOrderLine.getCreationDate());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineUpdateDate(purshaseOrderLine.getUpdateDate());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable1(purshaseOrderLine.getVariable1());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable2(purshaseOrderLine.getVariable2());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable3(purshaseOrderLine.getVariable3());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable4(purshaseOrderLine.getVariable4());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable5(purshaseOrderLine.getVariable5());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable6(purshaseOrderLine.getVariable6());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable7(purshaseOrderLine.getVariable7());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable8(purshaseOrderLine.getVariable8());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable9(purshaseOrderLine.getVariable9());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineVariable10(purshaseOrderLine.getVariable10());
        rcpPurshaseOrderLine.setRcpPurshaseOrderSuppOfLife(purshaseOrderLine.getSuppOfLife());
        rcpPurshaseOrderLine.setRcpPurshaseOrderComment(purshaseOrderLine.getComment());
        rcpPurshaseOrderLine.setRcpPurshaseOrderQuantityClosed(purshaseOrderLine.getQuantityClosed());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineWeight(purshaseOrderLine.getWeight());
        rcpPurshaseOrderLine.setRcpPurshaseOrderLineQuality(purshaseOrderLine.getQuality());
        rcpPurshaseOrderLine.setRcpReceptionLineBlockedQuantity(purshaseOrderLine.getBlockedQuantity());
        if (!lazy) {
            rcpPurshaseOrderLine.setRcpPurshaseOrder(PurshaseOrderArcMapper.toEntity(purshaseOrderLine.getPurshaseOrder(), true));
            rcpPurshaseOrderLine.setOwnOwner(OwnerMapper.toEntity(purshaseOrderLine.getOwner(), true));
            rcpPurshaseOrderLine.setPdtProduct(ProductMapper.toEntity(purshaseOrderLine.getProduct(), true));
            rcpPurshaseOrderLine.setPrmBlockType(BlockTypeMapper.toEntity(purshaseOrderLine.getBlockType(), true));
            rcpPurshaseOrderLine.setPrmColor(ColorMapper.toEntity(purshaseOrderLine.getColor(), true));
            rcpPurshaseOrderLine.setPdtUom(UomMapper.toEntity(purshaseOrderLine.getUom(), true));
            rcpPurshaseOrderLine.setPdtUomReceived(UomMapper.toEntity(purshaseOrderLine.getUomReceived(), true));
            rcpPurshaseOrderLine.setLocLocation(LocationMapper.toEntity(purshaseOrderLine.getLocation(), true));
            rcpPurshaseOrderLine.setWrhWarehouse(WarehouseMapper.toEntity(purshaseOrderLine.getWarehouse(), true));
            rcpPurshaseOrderLine.setPrmOrderStatus(OrderStatusMapper.toEntity(purshaseOrderLine.getOrderStatus(), true));
//            rcpPurshaseOrderLine.setRcpReceptionLines(ReceptionLineMapper.toEntities(purshaseOrderLine.getReceptionLines(), true));
//            rcpPurshaseOrderLine.setRcpReceptionLineArcs(ReceptionLineArcMapper.toEntities(purshaseOrderLine.getReceptionLineArcs(), true));
        }
        return rcpPurshaseOrderLine;
    }

    public static PurshaseOrderLineArc toDto(RcpPurshaseOrderLineArc rcpPurshaseOrderLine, boolean lazy) {
        if (null == rcpPurshaseOrderLine) {
            return null;
        }
        PurshaseOrderLineArc purshaseOrderLine = new PurshaseOrderLineArc();
        purshaseOrderLine.setId(rcpPurshaseOrderLine.getRcpPurshaseOrderLineId());
        purshaseOrderLine.setNumber(rcpPurshaseOrderLine.getRcpPurshaseOrderLineNumber());
        purshaseOrderLine.setQuantity(rcpPurshaseOrderLine.getRcpPurshaseOrderLineQuantity());
        purshaseOrderLine.setQuantityReceived(rcpPurshaseOrderLine.getRcpPurshaseOrderLineQuantityReceived());
        purshaseOrderLine.setDescription(rcpPurshaseOrderLine.getRcpPurshaseOrderLineDescription());//
        purshaseOrderLine.setContainerCode(rcpPurshaseOrderLine.getRcpPurshaseOrderLineContainerCode());
        purshaseOrderLine.setDlc(rcpPurshaseOrderLine.getRcpPurshaseOrderLineDlc());
        purshaseOrderLine.setDluo(rcpPurshaseOrderLine.getRcpPurshaseOrderLineDluo());
        purshaseOrderLine.setSerialNo(rcpPurshaseOrderLine.getRcpPurshaseOrderLineSerialNo());
        purshaseOrderLine.setLot(rcpPurshaseOrderLine.getRcpPurshaseOrderLineLot());
        purshaseOrderLine.setCreationDate(rcpPurshaseOrderLine.getRcpPurshaseOrderLineCreationDate());
        purshaseOrderLine.setUpdateDate(rcpPurshaseOrderLine.getRcpPurshaseOrderLineUpdateDate());
        purshaseOrderLine.setVariable1(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable1());
        purshaseOrderLine.setVariable2(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable2());
        purshaseOrderLine.setVariable3(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable3());
        purshaseOrderLine.setVariable4(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable4());
        purshaseOrderLine.setVariable5(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable5());
        purshaseOrderLine.setVariable6(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable6());
        purshaseOrderLine.setVariable7(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable7());
        purshaseOrderLine.setVariable8(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable8());
        purshaseOrderLine.setVariable9(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable9());
        purshaseOrderLine.setVariable10(rcpPurshaseOrderLine.getRcpPurshaseOrderLineVariable10());
        purshaseOrderLine.setSuppOfLife(rcpPurshaseOrderLine.getRcpPurshaseOrderSuppOfLife());
        purshaseOrderLine.setQuantityClosed(rcpPurshaseOrderLine.getRcpPurshaseOrderQuantityClosed());
        purshaseOrderLine.setComment(rcpPurshaseOrderLine.getRcpPurshaseOrderComment());
        purshaseOrderLine.setQuality(rcpPurshaseOrderLine.getRcpPurshaseOrderLineQuality());
        purshaseOrderLine.setWeight(rcpPurshaseOrderLine.getRcpPurshaseOrderLineWeight());
        purshaseOrderLine.setBlockedQuantity(rcpPurshaseOrderLine.getRcpReceptionLineBlockedQuantity());
        if (!lazy) {
            purshaseOrderLine.setPurshaseOrder(PurshaseOrderArcMapper.toDto(rcpPurshaseOrderLine.getRcpPurshaseOrder(), true));
            purshaseOrderLine.setOwner(OwnerMapper.toDto(rcpPurshaseOrderLine.getOwnOwner(), true));
            purshaseOrderLine.setProduct(ProductMapper.toDto(rcpPurshaseOrderLine.getPdtProduct(), true));
            purshaseOrderLine.setBlockType(BlockTypeMapper.toDto(rcpPurshaseOrderLine.getPrmBlockType(), true));
            purshaseOrderLine.setColor(ColorMapper.toDto(rcpPurshaseOrderLine.getPrmColor(), true));
            purshaseOrderLine.setUom(UomMapper.toDto(rcpPurshaseOrderLine.getPdtUom(), true));
            purshaseOrderLine.setUomReceived(UomMapper.toDto(rcpPurshaseOrderLine.getPdtUomReceived(), true));
            purshaseOrderLine.setLocation(LocationMapper.toDto(rcpPurshaseOrderLine.getLocLocation(), true));
            purshaseOrderLine.setWarehouse(WarehouseMapper.toDto(rcpPurshaseOrderLine.getWrhWarehouse(), true));
            purshaseOrderLine.setReceptionDate(rcpPurshaseOrderLine.getRcpPurshaseOrderLineReceptionDate());
            purshaseOrderLine.setOrderStatus(OrderStatusMapper.toDto(rcpPurshaseOrderLine.getPrmOrderStatus(), true));
//            purshaseOrderLine.setReceptionLines(ReceptionLineMapper.toDtos(rcpPurshaseOrderLine.getRcpReceptionLines(), true));
//            purshaseOrderLine.setReceptionLineArcs(ReceptionLineArcMapper.toDtos(rcpPurshaseOrderLine.getRcpReceptionLineArcs(), true));
        }
        return purshaseOrderLine;
    }

    public static List<PurshaseOrderLineArc> toDtos(List<RcpPurshaseOrderLineArc> rcpPurshaseOrderLines, boolean lazy) {
        if (null == rcpPurshaseOrderLines) {
            return null;
        }
        List<PurshaseOrderLineArc> purshaseOrderLines = new ArrayList<>();
        for (RcpPurshaseOrderLineArc rcpPurshaseOrderLine : rcpPurshaseOrderLines) {
            purshaseOrderLines.add(toDto(rcpPurshaseOrderLine, lazy));
        }
        return purshaseOrderLines;
    }

    public static List<PurshaseOrderLineArc> toDtos(Iterable<RcpPurshaseOrderLineArc> rcpPurshaseOrderLines, boolean lazy) {
        if (null == rcpPurshaseOrderLines) {
            return null;
        }
        List<PurshaseOrderLineArc> purshaseOrderLines = new ArrayList<>();
        for (RcpPurshaseOrderLineArc rcpPurshaseOrderLine : rcpPurshaseOrderLines) {
            purshaseOrderLines.add(toDto(rcpPurshaseOrderLine, lazy));
        }
        return purshaseOrderLines;
    }

    public static Set<RcpPurshaseOrderLineArc> toEntities(Set<PurshaseOrderLineArc> purshaseOrderLines, boolean lazy) {
        if (null == purshaseOrderLines) {
            return null;
        }
        Set<RcpPurshaseOrderLineArc> rcpPurshaseOrderLines = new HashSet<>();
        for (PurshaseOrderLineArc rurshaseOrder : purshaseOrderLines) {
            rcpPurshaseOrderLines.add(toEntity(rurshaseOrder, lazy));
        }
        return rcpPurshaseOrderLines;
    }

    public static Set<PurshaseOrderLineArc> toDtos(Set<RcpPurshaseOrderLineArc> rcpPurshaseOrderLines, boolean lazy) {
        if (null == rcpPurshaseOrderLines) {
            return null;
        }
        Set<PurshaseOrderLineArc> purshaseOrderLines = new HashSet<>();
        for (RcpPurshaseOrderLineArc rcpPurshaseOrderLine : rcpPurshaseOrderLines) {
            purshaseOrderLines.add(toDto(rcpPurshaseOrderLine, lazy));
        }
        return purshaseOrderLines;
    }
}

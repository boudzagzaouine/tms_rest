package com.sinno.ems.mapper;

import com.sinno.ems.dto.*;
import com.sinno.ems.entities.CmdDeliveryLine;
import com.sinno.ems.entities.CmdDeliveryLineArc;

import java.util.*;

/**
 * Created by ALae on 21/04/2016.
 */
public class DeliveryLineArcMapper {
    private DeliveryLineArcMapper(){}
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdDeliveryLineId");
        map.put("lineNumber", "cmdDeliveryLinelineNumber");
        map.put("saleOrderLine", "cmdSaleOrderLine");
        map.put("product", "pdtProduct");
        map.put("productDescription", "cmdDeliveryLineProductDescription");
        map.put("orderedQuantity", "cmdDeliveryLineOrderedQuantity");
        map.put("uom", "prmUom");
        map.put("quantityServed", "cmdDeliveryLineQuantityServed");
        map.put("blockType", "prmBlockType");
        map.put("warehouse", "whrWarehouse");
        map.put("container", "cmdDeliveryLineContainer");
        map.put("orderStatus", "prmOrderStatus");
        map.put("serialNo", "cmdDeliveryLineSerialNo");
        map.put("lot", "cmdDeliveryLineLot");
        map.put("color", "prmColor");
        map.put("dlc", "cmdDeliveryLineDlc");
        map.put("dluo", "cmdDeliveryLineDluo");
        map.put("comment", "cmdDeliveryLineComment");
        map.put("owner", "ownOwner");
        map.put("creationDate", "cmdDeliveryLineCreationDate");
        map.put("updateDate", "cmdDeliveryLineUpdateDate");
        map.put("delivery", "cmdDelivery");
        map.put("weight", "cmdDeliveryLineWeight");
        map.put("quality", "cmdDeliveryLineQuality");
        map.put("location", "locLocation");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static CmdDeliveryLineArc toEntity(DeliveryLineArc deliveryLine, boolean lazy) {
        if (null == deliveryLine) {
            return null;
        }
        CmdDeliveryLineArc cdl = new CmdDeliveryLineArc();

        cdl.setCmdDeliveryLineId(deliveryLine.getId());
        cdl.setCmdDeliveryLinelineNumber(deliveryLine.getLineNumber());
        cdl.setCmdDeliveryLineProductDescription(deliveryLine.getProductDescription());
        cdl.setCmdDeliveryLineOrderQuantity(deliveryLine.getOrderedQuantity());
        cdl.setCmdDeliveryLineQuantityServed(deliveryLine.getQuantityServed());
        cdl.setCmdDeliveryLineSerialNo(deliveryLine.getSerialNo());
        cdl.setCmdDeliveryLineLot(deliveryLine.getLot());
        cdl.setCmdDeliveryLineDlc(deliveryLine.getDlc());
        cdl.setCmdDeliveryLineDluo(deliveryLine.getDluo());
        cdl.setCmdDeliveryLineComment(deliveryLine.getComment());
        cdl.setCmdDeliveryLineCreationDate(deliveryLine.getCreationDate());
        cdl.setCmdDeliveryLineUpdateDate(deliveryLine.getUpdateDate());
        cdl.setCmdDeliveryLineWeight(deliveryLine.getWeight());
        cdl.setCmdDeliveryLineQuality(deliveryLine.getQuality());

        if (!lazy) {
            cdl.setLocLocation(LocationMapper.toEntity(deliveryLine.getLocation(), true));
            cdl.setCmdDelivery(DeliveryArcMapper.toEntity(deliveryLine.getDelivery(), true));
            cdl.setCmdSaleOrderLine(SaleOrderLineArcMapper.toEntity(deliveryLine.getSaleOrderLine(), true));
            cdl.setPdtProduct(ProductMapper.toEntity(deliveryLine.getProduct(), true));
            cdl.setPdtUom(UomMapper.toEntity(deliveryLine.getUom(), true));
            cdl.setPrmBlockType(BlockTypeMapper.toEntity(deliveryLine.getBlockType(), true));
            cdl.setWrhWarehouse(WarehouseMapper.toEntity(deliveryLine.getWarehouse(), true));
            cdl.setPrmOrderStatus(OrderStatusMapper.toEntity(deliveryLine.getOrderStatus(), true));
            cdl.setCmdDeliveryLineColor(ColorMapper.toEntity(deliveryLine.getColor(), true));
            cdl.setOwnOwner(OwnerMapper.toEntity(deliveryLine.getOwner(), true));
            cdl.setCmdDeliveryLineContainer(ContainerArcMapper.toEntity(deliveryLine.getContainer(), true));

        }
        return cdl;
    }

    public static DeliveryLineArc toDto(CmdDeliveryLineArc cmdDeliveryLine, boolean lazy) {
        if (null == cmdDeliveryLine) {
            return null;
        }
        DeliveryLineArc dl = new DeliveryLineArc();
        dl.setId(cmdDeliveryLine.getCmdDeliveryLineId());
        dl.setLineNumber(cmdDeliveryLine.getCmdDeliveryLinelineNumber());
        dl.setProductDescription(cmdDeliveryLine.getCmdDeliveryLineProductDescription());
        dl.setOrderedQuantity(cmdDeliveryLine.getCmdDeliveryLineOrderQuantity());
        dl.setQuantityServed(cmdDeliveryLine.getCmdDeliveryLineQuantityServed());
        dl.setSerialNo(cmdDeliveryLine.getCmdDeliveryLineSerialNo());
        dl.setLot(cmdDeliveryLine.getCmdDeliveryLineLot());
        dl.setDlc(cmdDeliveryLine.getCmdDeliveryLineDlc());
        dl.setDluo(cmdDeliveryLine.getCmdDeliveryLineDluo());
        dl.setComment(cmdDeliveryLine.getCmdDeliveryLineComment());
        dl.setCreationDate(cmdDeliveryLine.getCmdDeliveryLineCreationDate());
        dl.setUpdateDate(cmdDeliveryLine.getCmdDeliveryLineUpdateDate());
        dl.setWeight(cmdDeliveryLine.getCmdDeliveryLineWeight());
        dl.setQuality(cmdDeliveryLine.getCmdDeliveryLineQuality());

        if (!lazy) {
            dl.setLocation(LocationMapper.toDto(cmdDeliveryLine.getLocLocation(), true));
            dl.setDelivery(DeliveryArcMapper.toDto(cmdDeliveryLine.getCmdDelivery(), true));
            dl.setSaleOrderLine(SaleOrderLineArcMapper.toDto(cmdDeliveryLine.getCmdSaleOrderLine(), true));
            dl.setProduct(ProductMapper.toDto(cmdDeliveryLine.getPdtProduct(), true));
            dl.setUom(UomMapper.toDto(cmdDeliveryLine.getPdtUom(), true));
            dl.setBlockType(BlockTypeMapper.toDto(cmdDeliveryLine.getPrmBlockType(), true));
            dl.setWarehouse(WarehouseMapper.toDto(cmdDeliveryLine.getWrhWarehouse(), true));
            dl.setOrderStatus(OrderStatusMapper.toDto(cmdDeliveryLine.getPrmOrderStatus(), true));
            dl.setColor(ColorMapper.toDto(cmdDeliveryLine.getCmdDeliveryLineColor(), true));
            dl.setOwner(OwnerMapper.toDto(cmdDeliveryLine.getOwnOwner(), true));
            dl.setContainer(ContainerArcMapper.toDto(cmdDeliveryLine.getCmdDeliveryLineContainer(), true));
        }
        return dl;
    }

    public static List<DeliveryLineArc> toDtos(List<CmdDeliveryLineArc> cmdDeliveryLines, boolean lazy) {
        if (null == cmdDeliveryLines) {
            return null;
        }
        List<DeliveryLineArc> deliveryLines = new ArrayList<>();
        for (CmdDeliveryLineArc cmdDeliveryLine : cmdDeliveryLines) {
            deliveryLines.add(toDto(cmdDeliveryLine, lazy));
        }
        return deliveryLines;
    }

    public static List<DeliveryLineArc> toDtos(Iterable<CmdDeliveryLineArc> cmdDeliveryLines, boolean lazy) {
        if (null == cmdDeliveryLines) {
            return null;
        }
        List<DeliveryLineArc> deliveryLines = new ArrayList<>();
        for (CmdDeliveryLineArc cmdDeliveryLine : cmdDeliveryLines) {
            deliveryLines.add(toDto(cmdDeliveryLine, lazy));
        }
        return deliveryLines;
    }

    public static Set<CmdDeliveryLineArc> toEntities(Set<DeliveryLineArc> deliveryLines, boolean lazy) {
        if (null == deliveryLines) {
            return null;
        }
        Set<CmdDeliveryLineArc> cmdDeliveryLines = new HashSet<>();
        for (DeliveryLineArc deliveryLine : deliveryLines) {
            cmdDeliveryLines.add(toEntity(deliveryLine, lazy));
        }
        return cmdDeliveryLines;
    }

    public static Set<DeliveryLineArc> toDtos(Set<CmdDeliveryLineArc> cmdDeliveryLines, boolean lazy) {
        if (null == cmdDeliveryLines) {
            return null;
        }
        Set<DeliveryLineArc> deliveryLines = new HashSet<>();
        for (CmdDeliveryLineArc cmdDeliveryLine : cmdDeliveryLines) {
            deliveryLines.add(toDto(cmdDeliveryLine, lazy));
        }
        return deliveryLines;
    }
}

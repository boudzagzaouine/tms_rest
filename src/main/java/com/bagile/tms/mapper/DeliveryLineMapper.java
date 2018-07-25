package com.bagile.tms.mapper;

import com.bagile.tms.dto.DeliveryLine;
import com.bagile.tms.entities.CmdDeliveryLine;

import java.util.*;

/**
 * Created by ALae on 21/04/2016.
 */
public class DeliveryLineMapper {
    private DeliveryLineMapper() {
    }

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
        map.put("containerCode", "cmdDeliveryLineContainerCode");
        map.put("preparationLine", "cmdPreparationLine");
        map.put("productDimension", "pdtProductDimension");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static CmdDeliveryLine toEntity(DeliveryLine deliveryLine, boolean lazy) {
        if (null == deliveryLine) {
            return null;
        }
        CmdDeliveryLine cdl = new CmdDeliveryLine();

        cdl.setCmdDeliveryLineId(deliveryLine.getId());
        cdl.setCmdDeliveryLinelineNumber(deliveryLine.getLineNumber());
        cdl.setCmdDeliveryLineProductDescription(deliveryLine.getProductDescription());
        cdl.setCmdDeliveryLineOrderQuantity(deliveryLine.getOrderedQuantity());
        cdl.setCmdDeliveryLineQuantityServed(deliveryLine.getQuantityServed());

        cdl.setCmdDeliveryLineComment(deliveryLine.getComment());
        cdl.setCmdDeliveryLineCreationDate(deliveryLine.getCreationDate());
        cdl.setCmdDeliveryLineUpdateDate(deliveryLine.getUpdateDate());
        cdl.setCmdDeliveryLineContainerCode(deliveryLine.getContainerCode());

        if (!lazy) {

            cdl.setCmdDelivery(DeliveryMapper.toEntity(deliveryLine.getDelivery(), true));
            cdl.setCmdSaleOrderLine(SaleOrderLineMapper.toEntity(deliveryLine.getSaleOrderLine(), true));
            cdl.setPdtProduct(ProductMapper.toEntity(deliveryLine.getProduct(), true));
            cdl.setPdtUom(UomMapper.toEntity(deliveryLine.getUom(), true));
            cdl.setWrhWarehouse(WarehouseMapper.toEntity(deliveryLine.getWarehouse(), true));
            cdl.setPrmOrderStatus(OrderStatusMapper.toEntity(deliveryLine.getOrderStatus(), true));
            cdl.setOwnOwner(OwnerMapper.toEntity(deliveryLine.getOwner(), true));
            cdl.setCmdDeliveryLineContainer(ContainerMapper.toEntity(deliveryLine.getContainer(), true));
        }
        return cdl;
    }

    public static DeliveryLine toDto(CmdDeliveryLine cmdDeliveryLine, boolean lazy) {
        if (null == cmdDeliveryLine) {
            return null;
        }
        DeliveryLine dl = new DeliveryLine();
        dl.setId(cmdDeliveryLine.getCmdDeliveryLineId());
        dl.setLineNumber(cmdDeliveryLine.getCmdDeliveryLinelineNumber());
        dl.setProductDescription(cmdDeliveryLine.getCmdDeliveryLineProductDescription());
        dl.setOrderedQuantity(cmdDeliveryLine.getCmdDeliveryLineOrderQuantity());
        dl.setQuantityServed(cmdDeliveryLine.getCmdDeliveryLineQuantityServed());
        dl.setComment(cmdDeliveryLine.getCmdDeliveryLineComment());
        dl.setCreationDate(cmdDeliveryLine.getCmdDeliveryLineCreationDate());
        dl.setUpdateDate(cmdDeliveryLine.getCmdDeliveryLineUpdateDate());
        dl.setContainerCode(cmdDeliveryLine.getCmdDeliveryLineContainerCode());

        if (!lazy) {

            dl.setDelivery(DeliveryMapper.toDto(cmdDeliveryLine.getCmdDelivery(), true));
            dl.setSaleOrderLine(SaleOrderLineMapper.toDto(cmdDeliveryLine.getCmdSaleOrderLine(), true));
            dl.setProduct(ProductMapper.toDto(cmdDeliveryLine.getPdtProduct(), true));
            dl.setUom(UomMapper.toDto(cmdDeliveryLine.getPdtUom(), true));
            dl.setWarehouse(WarehouseMapper.toDto(cmdDeliveryLine.getWrhWarehouse(), true));
            dl.setOrderStatus(OrderStatusMapper.toDto(cmdDeliveryLine.getPrmOrderStatus(), true));
            dl.setOwner(OwnerMapper.toDto(cmdDeliveryLine.getOwnOwner(), true));
            dl.setContainer(ContainerMapper.toDto(cmdDeliveryLine.getCmdDeliveryLineContainer(), true));
        }
        return dl;
    }

    public static List<DeliveryLine> toDtos(List<CmdDeliveryLine> cmdDeliveryLines, boolean lazy) {
        if (null == cmdDeliveryLines) {
            return null;
        }
        List<DeliveryLine> deliveryLines = new ArrayList<>();
        for (CmdDeliveryLine cmdDeliveryLine : cmdDeliveryLines) {
            deliveryLines.add(toDto(cmdDeliveryLine, lazy));
        }
        return deliveryLines;
    }

    public static List<DeliveryLine> toDtos(Iterable<CmdDeliveryLine> cmdDeliveryLines, boolean lazy) {
        if (null == cmdDeliveryLines) {
            return null;
        }
        List<DeliveryLine> deliveryLines = new ArrayList<>();
        for (CmdDeliveryLine cmdDeliveryLine : cmdDeliveryLines) {
            deliveryLines.add(toDto(cmdDeliveryLine, lazy));
        }
        return deliveryLines;
    }

    public static Set<CmdDeliveryLine> toEntities(Set<DeliveryLine> deliveryLines, boolean lazy) {
        if (null == deliveryLines) {
            return null;
        }
        Set<CmdDeliveryLine> cmdDeliveryLines = new HashSet<>();
        for (DeliveryLine deliveryLine : deliveryLines) {
            cmdDeliveryLines.add(toEntity(deliveryLine, lazy));
        }
        return cmdDeliveryLines;
    }

    public static Set<DeliveryLine> toDtos(Set<CmdDeliveryLine> cmdDeliveryLines, boolean lazy) {
        if (null == cmdDeliveryLines) {
            return null;
        }
        Set<DeliveryLine> deliveryLines = new HashSet<>();
        for (CmdDeliveryLine cmdDeliveryLine : cmdDeliveryLines) {
            deliveryLines.add(toDto(cmdDeliveryLine, lazy));
        }
        return deliveryLines;
    }
}

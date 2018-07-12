package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class PreparationLineMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","cmdPreparationLineId");
        map.put("number","cmdPreparationLineNumber");
        map.put("creationDate","cmdPreparationLineCreationDate");
        map.put("updateDate","cmdPreparationLineUpdateDate");
        map.put("quantity","cmdPreparationLineQuantity");
        map.put("quantityFound","CmdPreparationLineQuantityFound");
        map.put("owner","ownOwner");
        map.put("warehouse","wrhWarehouse");
        map.put("saleOrderLine","cmdSaleOrderLine");
        map.put("product","pdtProduct");
        map.put("preparation","cmdPreparation");
        map.put("uom","pdtUom");
        map.put("color","prmColor");
        map.put("weight","cmdPreparationLineWeight");
        map.put("quality","cmdPreparationLineQuality");
        map.put("dlc","cmdPreparationLineDlc");
        map.put("dluo","cmdPreparationLineDluo");
        map.put("serialNo","cmdPreparationLineSerialNo");
        map.put("lot","cmdPreparationLineLot");
        map.put("productDimension", "pdtProductDimension");


    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }
    public static CmdPreparationLine toEntity(PreparationLine preparationLine, boolean lazy) {
        if (null == preparationLine) {
            return null;
        }
        CmdPreparationLine cmdPreparationLine=new CmdPreparationLine();
        cmdPreparationLine.setCmdPreparationLineId(preparationLine.getId());
        cmdPreparationLine.setCmdPreparationLineNumber(preparationLine.getNumber());
        cmdPreparationLine.setCmdPreparationLineCreationDate(preparationLine.getCreationDate());
        cmdPreparationLine.setCmdPreparationLineUpdateDate(preparationLine.getUpdateDate());
        cmdPreparationLine.setCmdPreparationLineQuantity(preparationLine.getQuantity());
        cmdPreparationLine.setCmdPreparationLineQuantityFound(preparationLine.getQuantityFound());
        cmdPreparationLine.setCmdPreparationLineDlc(preparationLine.getDlc());
        cmdPreparationLine.setCmdPreparationLineDluo(preparationLine.getDluo());
        cmdPreparationLine.setCmdPreparationLineSerialNo(preparationLine.getSerialNo());
        cmdPreparationLine.setCmdPreparationLineLot(preparationLine.getLot());
        cmdPreparationLine.setCmdPreparationLineQuality(preparationLine.getQuality());
        cmdPreparationLine.setCmdPreparationLineWeight(preparationLine.getWeight());
      
        if (!lazy) {
            cmdPreparationLine.setPdtProductDimension(ProductDimensionMapper.toEntity(preparationLine.getProductDimension(),true));

            cmdPreparationLine.setPrmColor(ColorMapper.toEntity(preparationLine.getColor(),true));
            cmdPreparationLine.setPdtUom(UomMapper.toEntity(preparationLine.getUom(),true));
            cmdPreparationLine.setOwnOwner(OwnerMapper.toEntity(preparationLine.getOwner(),true));
            cmdPreparationLine.setWrhWarehouse(WarehouseMapper.toEntity(preparationLine.getWarehouse(),true));
            cmdPreparationLine.setCmdSaleOrderLine(SaleOrderLineMapper.toEntity(preparationLine.getSaleOrderLine(),true));
            cmdPreparationLine.setPdtProduct(ProductMapper.toEntity(preparationLine.getProduct(),true));
            cmdPreparationLine.setCmdPreparation(PreparationMapper.toEntity(preparationLine.getPreparation(),true));

        }

        return cmdPreparationLine;
    }
    public static PreparationLine toDto(CmdPreparationLine cmdPreparationLine, boolean lazy) {
        if (null == cmdPreparationLine) {
            return null;
        }

        PreparationLine preparationLine=new PreparationLine();
        preparationLine.setId(cmdPreparationLine.getCmdPreparationLineId());
        preparationLine.setNumber(cmdPreparationLine.getCmdPreparationLineNumber());
        preparationLine.setCreationDate(cmdPreparationLine.getCmdPreparationLineCreationDate());
        preparationLine.setUpdateDate(cmdPreparationLine.getCmdPreparationLineUpdateDate());
        preparationLine.setQuantity(cmdPreparationLine.getCmdPreparationLineQuantity());
        preparationLine.setQuantityFound(cmdPreparationLine.getCmdPreparationLineQuantityFound());
        preparationLine.setDlc(cmdPreparationLine.getCmdPreparationLineDlc());
        preparationLine.setDluo(cmdPreparationLine.getCmdPreparationLineDluo());
        preparationLine.setSerialNo(cmdPreparationLine.getCmdPreparationLineSerialNo());
        preparationLine.setLot(cmdPreparationLine.getCmdPreparationLineLot());
        preparationLine.setQuality(cmdPreparationLine.getCmdPreparationLineQuality());
        preparationLine.setWeight(cmdPreparationLine.getCmdPreparationLineWeight());

        if (!lazy) {
            preparationLine.setProductDimension(ProductDimensionMapper.toDto(cmdPreparationLine.getPdtProductDimension(),true));
            preparationLine.setColor(ColorMapper.toDto(cmdPreparationLine.getPrmColor(),true));
            preparationLine.setUom(UomMapper.toDto(cmdPreparationLine.getPdtUom(),true));
            preparationLine.setOwner(OwnerMapper.toDto(cmdPreparationLine.getOwnOwner(),true));
            preparationLine.setWarehouse(WarehouseMapper.toDto(cmdPreparationLine.getWrhWarehouse(),true));
            preparationLine.setSaleOrderLine(SaleOrderLineMapper.toDto(cmdPreparationLine.getCmdSaleOrderLine(),true));
            preparationLine.setProduct(ProductMapper.toDto(cmdPreparationLine.getPdtProduct(),true));
            preparationLine.setPreparation(PreparationMapper.toDto(cmdPreparationLine.getCmdPreparation(),true));

        }

        return preparationLine;
    }
    public static List<PreparationLine> toDtos(List<CmdPreparationLine> cmdPreparationLines, boolean lazy) {
        if (null == cmdPreparationLines) {
            return null;
        }
        List<PreparationLine> preparationLines = new ArrayList<>();
        for (CmdPreparationLine ownOwner : cmdPreparationLines) {
            preparationLines.add(toDto(ownOwner, lazy));
        }
        return preparationLines;
    }

    public static List<PreparationLine> toDtos(Iterable<CmdPreparationLine> cmdPreparationLines, boolean lazy) {
        if (null == cmdPreparationLines) {
            return null;
        }
        List<PreparationLine> preparationLines = new ArrayList<>();
        for (CmdPreparationLine cmdPreparationLine : cmdPreparationLines) {
            preparationLines.add(toDto(cmdPreparationLine, lazy));
        }
        return preparationLines;
    }

    public static Set<CmdPreparationLine> toEntities(Set<PreparationLine> preparationLines, boolean lazy) {
        if (null == preparationLines) {
            return null;
        }
        Set<CmdPreparationLine> cmdPreparationLines = new HashSet<>();
        for (PreparationLine preparationLine : preparationLines) {
            cmdPreparationLines.add(toEntity(preparationLine, lazy));
        }
        return cmdPreparationLines;
    }

    public static Set<PreparationLine> toDtos(Set<CmdPreparationLine> cmdPreparationLines, boolean lazy) {
        if (null == cmdPreparationLines) {
            return null;
        }
        Set<PreparationLine> preparationLines = new HashSet<>();
        for (CmdPreparationLine cmdPreparationLine : cmdPreparationLines) {
            preparationLines.add(toDto(cmdPreparationLine, lazy));
        }
        return preparationLines;
    }

}

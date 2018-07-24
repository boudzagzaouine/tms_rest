package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Enissay on 06/12/2016.
 */
public class DevisLineMapper {
    private DevisLineMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdDevisLineId");
        map.put("devis", "cmdDevis");
        map.put("owner", "ownOwner");
        map.put("product", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("blockType", "prmBlockType");
        map.put("orderStatus", "prmOrderStatus");
        map.put("lineNumber", "cmdDevisLineLineNumber");
        map.put("quantity", "cmdDevisLineQuantity");
        map.put("description", "cmdDevisLineDescription");
        map.put("creationDate", "cmdDevisLineCreationDate");
        map.put("updateDate", "cmdDevisLineUpdateDate");
        map.put("variable1", "cmdDevisLineVariable1");
        map.put("variable2", "cmdDevisLineVariable2");
        map.put("variable3", "cmdDevisLineVariable3");
        map.put("variable4", "cmdDevisLineVariable4");
        map.put("variable5", "cmdDevisLineVariable5");
        map.put("variable6", "cmdDevisLineVariable6");
        map.put("variable7", "cmdDevisLineVariable7");
        map.put("variable8", "cmdDevisLineVariable8");
        map.put("variable9", "cmdDevisLineVariable9");
        map.put("variable10", "cmdDevisLineVariable10");
        map.put("comment", "cmdDevisLineComment");
        map.put("totalPriceHT", "cmdDevisLineTotalPriceHT");
        map.put("totalPriceHT", "cmdDevisLineTotalPriceTTC");
        map.put("vat", "prmVat");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static DevisLine toDto(CmdDevisLine cmdDevisLine, boolean lazy) {
        if (null == cmdDevisLine) {
            return null;
        }
        DevisLine devisLine = new DevisLine();
        devisLine.setCreationDate(cmdDevisLine.getCmdDevisLineCreationDate());
        devisLine.setId(cmdDevisLine.getCmdDevisLineId());
        devisLine.setLineNumber(cmdDevisLine.getCmdDevisLineLineNumber());
        devisLine.setUpdateDate(cmdDevisLine.getCmdDevisLineUpdateDate());
        devisLine.setComment(cmdDevisLine.getCmdDevisLineComment());
        devisLine.setQuantity(cmdDevisLine.getCmdDevisLineQuantity());
        devisLine.setDiscount(cmdDevisLine.getCmdDevisLineDiscount());
        devisLine.setSalePrice(cmdDevisLine.getCmdDevisLineSalePrice());
        devisLine.setTotalPriceTTC(cmdDevisLine.getCmdDevisLineTotalPriceTTC());
        devisLine.setTotalPriceHT(cmdDevisLine.getCmdDevisLineTotalPriceHT());
        if (!lazy) {
            devisLine.setVat(VatMapper.toDto(cmdDevisLine.getPrmVat(), true));
            devisLine.setBlockType(BlockTypeMapper.toDto(cmdDevisLine.getPrmBlockType(), true));
            devisLine.setOrderStatus(OrderStatusMapper.toDto(cmdDevisLine.getPrmOrderStatus(), true));
            devisLine.setOwner(OwnerMapper.toDto(cmdDevisLine.getOwnOwner(), true));
            devisLine.setProduct(ProductMapper.toDto(cmdDevisLine.getPdtProduct(), true));
            devisLine.setDevis(DevisMapper.toDto(cmdDevisLine.getCmdDevis(), true));
            devisLine.setUom(UomMapper.toDto(cmdDevisLine.getPdtUom(), true));
        }
        return devisLine;
    }

    public static CmdDevisLine toEntity(DevisLine devisLine, boolean lazy) {
        if (null == devisLine) {
            return null;
        }
        CmdDevisLine cmdDevisLine = new CmdDevisLine();
        cmdDevisLine.setCmdDevisLineCreationDate(devisLine.getCreationDate());
        cmdDevisLine.setCmdDevisLineDescription(devisLine.getProductDescription());
        cmdDevisLine.setCmdDevisLineId(devisLine.getId());
        cmdDevisLine.setCmdDevisLineLineNumber(devisLine.getLineNumber());
        cmdDevisLine.setCmdDevisLineQuantity(devisLine.getQuantity());
        cmdDevisLine.setCmdDevisLineUpdateDate(devisLine.getUpdateDate());
        cmdDevisLine.setCmdDevisLineComment(devisLine.getComment());
        cmdDevisLine.setCmdDevisLineSalePrice(devisLine.getSalePrice());
        cmdDevisLine.setCmdDevisLineDiscount(devisLine.getDiscount());
        cmdDevisLine.setCmdDevisLineTotalPriceTTC(devisLine.getTotalPriceTTC());
        cmdDevisLine.setCmdDevisLineTotalPriceHT(devisLine.getTotalPriceHT());
        if (!lazy) {
            cmdDevisLine.setPrmVat(VatMapper.toEntity(devisLine.getVat(), true));
            cmdDevisLine.setOwnOwner(OwnerMapper.toEntity(devisLine.getOwner(), true));
            cmdDevisLine.setPdtProduct(ProductMapper.toEntity(devisLine.getProduct(), true));
            cmdDevisLine.setPdtUom(UomMapper.toEntity(devisLine.getUom(), true));
            cmdDevisLine.setPrmBlockType(BlockTypeMapper.toEntity(devisLine.getBlockType(), true));
            cmdDevisLine.setPrmOrderStatus(OrderStatusMapper.toEntity(devisLine.getOrderStatus(), true));
        }
        return cmdDevisLine;
    }

    public static List<DevisLine> toDtos(List<CmdDevisLine> cmdOrderLines, boolean lazy) {
        if (null == cmdOrderLines) {
            return null;
        }
        List<DevisLine> devisLines = new ArrayList<>();
        for (CmdDevisLine cmdDevisLine : cmdOrderLines) {
            devisLines.add(toDto(cmdDevisLine, lazy));
        }
        return devisLines;
    }

    public static List<DevisLine> toDtos(Iterable<CmdDevisLine> cmdOrderLines, boolean lazy) {
        if (null == cmdOrderLines) {
            return null;
        }
        List<DevisLine> devisLines = new ArrayList<>();
        for (CmdDevisLine cmdDevisLine : cmdOrderLines) {
            devisLines.add(toDto(cmdDevisLine, lazy));
        }
        return devisLines;
    }

    public static Set<CmdDevisLine> toEntities(Set<DevisLine> devisLines, boolean lazy) {
        if (null == devisLines) {
            return null;
        }
        Set<CmdDevisLine> cmdDevisLines = new HashSet<>();
        for (DevisLine devisLine : devisLines) {
            cmdDevisLines.add(toEntity(devisLine, lazy));
        }
        return cmdDevisLines;
    }

    public static Set<DevisLine> toDtos(Set<CmdDevisLine> cmdOrderLines, boolean lazy) {
        if (null == cmdOrderLines) {
            return null;
        }
        Set<DevisLine> devisLines = new HashSet<>();
        for (CmdDevisLine cmdDevisLine : cmdOrderLines) {
            devisLines.add(toDto(cmdDevisLine, lazy));
        }
        return devisLines;
    }
}

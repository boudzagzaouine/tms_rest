/**
 *
 */
package com.bagile.tms.mapper;

import com.bagile.tms.dto.TurnLine;
import com.bagile.tms.entities.TmsTurnLine;
import com.bagile.tms.util.EmsDate;


import java.util.*;

/**
 * @author aelguezzar
 */
public class TurnLineMapper {
    private TurnLineMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTurnLineeId");
        map.put("owner", "ownOwner");
        map.put("product", "pdtProduct");
        map.put("description", "tmsTurnLineDescription");
        map.put("blockType", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("quantityServed", "tmsTurnLineQuantityServed");
        map.put("salePrice", "tmsTurnLineSalePrice");
        map.put("vat", "prmVat");
        map.put("totalPriceHT", "tmsTurnLineTotalPriceHT");
        map.put("totalPriceTTC", "tmsTurnLineTotalPriceTTC");
        map.put("productPack", "pdtProductPack");
        map.put("turnLine", "tmsTurnLine");
        map.put("turn", "tmsTurn");



    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static TurnLine toDto(TmsTurnLine tmsTurnLine, boolean lazy) {
        if (null == tmsTurnLine) {
            return null;
        }
        TurnLine turnLine = new TurnLine();
        turnLine.setId(tmsTurnLine.getTmsTurnLineeId());
        turnLine.setDescription(tmsTurnLine.getTmsTurnLineDescription());
        turnLine.setQuantityServed(tmsTurnLine.getTmsTurnLineQuantityServed());
        turnLine.setSalePrice(tmsTurnLine.getTmsTurnLineSalePrice());
        turnLine.setTotalPriceHT(tmsTurnLine.getTmsTurnLineTotalPriceHT());
        turnLine.setTotalPriceTTC(tmsTurnLine.getTmsTurnLineTotalPriceTTC());

        
        turnLine.setUpdatedBy(tmsTurnLine.getUpdatedBy());
        turnLine.setCreatedBy(tmsTurnLine.getCreatedBy());
        if (!lazy) {

            turnLine.setVat(VatMapper.toDto(tmsTurnLine.getPrmVat(), true));
            turnLine.setOwner(OwnerMapper.toDto(tmsTurnLine.getOwnOwner(), true));
            turnLine.setProduct(ProductMapper.toDto(tmsTurnLine.getPdtProduct(), true));
            turnLine.setUom(UomMapper.toDto(tmsTurnLine.getPdtUom(), true));
            turnLine.setProductPack(ProductPackMapper.toDto(tmsTurnLine.getPdtProductPack(), false));
            turnLine.setSaleOrderLine(SaleOrderLineMapper.toDto(tmsTurnLine.getCmdSaleOrderLine(), false));
            turnLine.setSaleOrderLine(SaleOrderLineMapper.toDto(tmsTurnLine.getCmdSaleOrderLine(), false));

        }
        return turnLine;
    }

    public static TmsTurnLine toEntity(TurnLine turnLine, boolean lazy) {
        if (null == turnLine) {
            return null;
        }
        TmsTurnLine tmsTurnLine = new TmsTurnLine();
        tmsTurnLine.setTmsTurnLineeId(turnLine.getId());
        tmsTurnLine.setTmsTurnLineDescription(turnLine.getDescription());
        tmsTurnLine.setTmsTurnLineQuantityServed(turnLine.getQuantityServed());
        tmsTurnLine.setTmsTurnLineSalePrice(turnLine.getSalePrice());
        tmsTurnLine.setTmsTurnLineTotalPriceHT(turnLine.getTotalPriceHT());
        tmsTurnLine.setTmsTurnLineTotalPriceTTC(turnLine.getTotalPriceTTC());

        tmsTurnLine.setUpdatedBy(turnLine.getUpdatedBy());
        tmsTurnLine.setCreatedBy(turnLine.getCreatedBy());
        if (!lazy) {
            tmsTurnLine.setPrmVat(VatMapper.toEntity(turnLine.getVat(), true));
            tmsTurnLine.setOwnOwner(OwnerMapper.toEntity(turnLine.getOwner(), true));
            tmsTurnLine.setPdtProduct(ProductMapper.toEntity(turnLine.getProduct(), true));
            tmsTurnLine.setPdtUom(UomMapper.toEntity(turnLine.getUom(), true));
            tmsTurnLine.setPdtProductPack(ProductPackMapper.toEntity(turnLine.getProductPack(), true));
            tmsTurnLine.setCmdSaleOrderLine(SaleOrderLineMapper.toEntity(turnLine.getSaleOrderLine(), true));
            tmsTurnLine.setTmsTurn(TurnMapper.toEntity(turnLine.getTurn(), true));

        }
        return tmsTurnLine;
    }

    public static List<TurnLine> toDtos(List<TmsTurnLine> tmsTurnLines, boolean lazy) {
        if (null == tmsTurnLines) {
            return null;
        }
        List<TurnLine> turnLines = new ArrayList<>();
        for (TmsTurnLine tmsTurnLine : tmsTurnLines) {
            turnLines.add(toDto(tmsTurnLine, lazy));
        }
        return turnLines;
    }

    public static List<TurnLine> toDtos(Iterable<TmsTurnLine> tmsTurnLines, boolean lazy) {
        if (null == tmsTurnLines) {
            return null;
        }
        List<TurnLine> turnLines = new ArrayList<>();
        for (TmsTurnLine tmsTurnLine : tmsTurnLines) {
            turnLines.add(toDto(tmsTurnLine, lazy));
        }
        return turnLines;
    }


    public static Set<TmsTurnLine> toEntities(Set<TurnLine> turnLines, boolean lazy) {
        if (null == turnLines) {
            return null;
        }
        Set<TmsTurnLine> tmsTurnLines = new HashSet<>();
        for (TurnLine turnLine : turnLines) {
            tmsTurnLines.add(toEntity(turnLine, lazy));
        }
        return tmsTurnLines;
    }

    public static Set<TurnLine> toDtos(Set<TmsTurnLine> tmsTurnLines, boolean lazy) {
        if (null == tmsTurnLines) {
            return null;
        }
        Set<TurnLine> turnLines = new HashSet<>();
        for (TmsTurnLine tmsTurnLine : tmsTurnLines) {
            turnLines.add(toDto(tmsTurnLine, lazy));
        }
        return turnLines;
    }



}

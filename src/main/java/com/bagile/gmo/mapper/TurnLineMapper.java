/**
 *
 */
package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.TurnLine;
import com.bagile.gmo.entities.GmoTurnLine;

/**
 * @author aelguezzar
 */
public class TurnLineMapper {
    private TurnLineMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoTurnLineeId");
       // map.put("owner", "ownOwner");
        map.put("product", "pdtProduct");
        map.put("description", "gmoTurnLineDescription");
        map.put("blockType", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("quantityServed", "gmoTurnLineQuantityServed");
        map.put("salePrice", "gmoTurnLineSalePrice");
        map.put("vat", "prmVat");
        map.put("totalPriceHT", "gmoTurnLineTotalPriceHT");
        map.put("totalPriceTTC", "gmoTurnLineTotalPriceTTC");
        map.put("productPack", "pdtProductPack");
        map.put("turnLine", "gmoTurnLine");
        map.put("turn", "gmoTurn");
        map.put("saleOrder", "cmdSaleOrder");



    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static TurnLine toDto(GmoTurnLine gmoTurnLine, boolean lazy) {
        if (null == gmoTurnLine) {
            return null;
        }
        TurnLine turnLine = new TurnLine();
        turnLine.setId(gmoTurnLine.getGmoTurnLineeId());
        turnLine.setDescription(gmoTurnLine.getGmoTurnLineDescription());
        turnLine.setQuantityServed(gmoTurnLine.getGmoTurnLineQuantityServed());
        turnLine.setSalePrice(gmoTurnLine.getGmoTurnLineSalePrice());
        turnLine.setTotalPriceHT(gmoTurnLine.getGmoTurnLineTotalPriceHT());
        turnLine.setTotalPriceTTC(gmoTurnLine.getGmoTurnLineTotalPriceTTC());

        
        turnLine.setUpdatedBy(gmoTurnLine.getUpdatedBy());
        turnLine.setCreatedBy(gmoTurnLine.getCreatedBy());
        if (!lazy) {

            turnLine.setVat(VatMapper.toDto(gmoTurnLine.getPrmVat(), true));
          //  turnLine.setOwner(OwnerMapper.toDto(gmoTurnLine.getOwnOwner(), true));
            turnLine.setProduct(ProductMapper.toDto(gmoTurnLine.getPdtProduct(), true));
            turnLine.setUom(UomMapper.toDto(gmoTurnLine.getPdtUom(), true));
            turnLine.setProductPack(ProductPackMapper.toDto(gmoTurnLine.getPdtProductPack(), false));
            turnLine.setSaleOrderLine(SaleOrderLineMapper.toDto(gmoTurnLine.getCmdSaleOrderLine(), false));
            turnLine.setSaleOrderLine(SaleOrderLineMapper.toDto(gmoTurnLine.getCmdSaleOrderLine(), false));
            turnLine.setSaleOrder(SaleOrderMapper.toDto(gmoTurnLine.getCmdSaleOrder(), false));
            turnLine.setTurn(TurnMapper.toDto(gmoTurnLine.getGmoTurn(), false));


        }
        return turnLine;
    }

    public static GmoTurnLine toEntity(TurnLine turnLine, boolean lazy) {
        if (null == turnLine) {
            return null;
        }
        GmoTurnLine gmoTurnLine = new GmoTurnLine();
        gmoTurnLine.setGmoTurnLineeId(turnLine.getId());
        gmoTurnLine.setGmoTurnLineDescription(turnLine.getDescription());
        gmoTurnLine.setGmoTurnLineQuantityServed(turnLine.getQuantityServed());
        gmoTurnLine.setGmoTurnLineSalePrice(turnLine.getSalePrice());
        gmoTurnLine.setGmoTurnLineTotalPriceHT(turnLine.getTotalPriceHT());
        gmoTurnLine.setGmoTurnLineTotalPriceTTC(turnLine.getTotalPriceTTC());

        gmoTurnLine.setUpdatedBy(turnLine.getUpdatedBy());
        gmoTurnLine.setCreatedBy(turnLine.getCreatedBy());
        if (!lazy) {
            gmoTurnLine.setPrmVat(VatMapper.toEntity(turnLine.getVat(), true));
            //gmoTurnLine.setOwnOwner(OwnerMapper.toEntity(turnLine.getOwner(), true));
            gmoTurnLine.setPdtProduct(ProductMapper.toEntity(turnLine.getProduct(), true));
            gmoTurnLine.setPdtUom(UomMapper.toEntity(turnLine.getUom(), true));
            gmoTurnLine.setPdtProductPack(ProductPackMapper.toEntity(turnLine.getProductPack(), true));
            gmoTurnLine.setCmdSaleOrderLine(SaleOrderLineMapper.toEntity(turnLine.getSaleOrderLine(), true));
            gmoTurnLine.setGmoTurn(TurnMapper.toEntity(turnLine.getTurn(), true));
            gmoTurnLine.setCmdSaleOrder(SaleOrderMapper.toEntity(turnLine.getSaleOrder(), true));
            gmoTurnLine.setGmoTurn(TurnMapper.toEntity(turnLine.getTurn(), true));

        }
        return gmoTurnLine;
    }

    public static List<TurnLine> toDtos(List<GmoTurnLine> gmoTurnLines, boolean lazy) {
        if (null == gmoTurnLines) {
            return null;
        }
        List<TurnLine> turnLines = new ArrayList<>();
        for (GmoTurnLine gmoTurnLine : gmoTurnLines) {
            turnLines.add(toDto(gmoTurnLine, lazy));
        }
        return turnLines;
    }

    public static List<TurnLine> toDtos(Iterable< ? extends GmoTurnLine> gmoTurnLines, boolean lazy) {
        if (null == gmoTurnLines) {
            return null;
        }
        List<TurnLine> turnLines = new ArrayList<>();
        for (GmoTurnLine gmoTurnLine : gmoTurnLines) {
            turnLines.add(toDto(gmoTurnLine, lazy));
        }
        return turnLines;
    }


    public static Set<GmoTurnLine> toEntities(List<TurnLine> turnLines, boolean lazy) {
        if (null == turnLines) {
            return null;
        }
        Set<GmoTurnLine> gmoTurnLines = new HashSet<>();
        for (TurnLine turnLine : turnLines) {
            gmoTurnLines.add(toEntity(turnLine, lazy));
        }
        return gmoTurnLines;
    }

    /*public static Set<TurnLine> toDtos(Set<GmoTurnLine> gmoTurnLines, boolean lazy) {
        if (null == gmoTurnLines) {
            return null;
        }
        Set<TurnLine> turnLines = new HashSet<>();
        for (GmoTurnLine gmoTurnLine : gmoTurnLines) {
            turnLines.add(toDto(gmoTurnLine, lazy));
        }
        return turnLines;
    }*/



}

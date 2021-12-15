/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TurnLine;
import com.bagile.gmo.entities.TmsTurnLine;

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
        map.put("turn", "tmsTurn");
        map.put("saleOrder", "cmdSaleOrder");



    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static TurnLine toDto(TmsTurnLine gmoTurnLine, boolean lazy) {
        if (null == gmoTurnLine) {
            return null;
        }
        TurnLine turnLine = new TurnLine();
        turnLine.setId(gmoTurnLine.getTmsTurnLineeId());
        turnLine.setDescription(gmoTurnLine.getTmsTurnLineDescription());
        turnLine.setQuantityServed(gmoTurnLine.getTmsTurnLineQuantityServed());
        turnLine.setSalePrice(gmoTurnLine.getTmsTurnLineSalePrice());
        turnLine.setTotalPriceHT(gmoTurnLine.getTmsTurnLineTotalPriceHT());
        turnLine.setTotalPriceTTC(gmoTurnLine.getTmsTurnLineTotalPriceTTC());

        
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
            turnLine.setTurnSoPo(TurnSoPoMapper.toDto(gmoTurnLine.getTmsTurnSoPo(), true));

            turnLine.setPurshaseOrderLine(PurshaseOrderLineMapper.toDto(gmoTurnLine.getRcpPurshaseOrderLine(), false));
            turnLine.setStocks(StockMapper.toDtos(gmoTurnLine.getStkStocks(), false));

        }
        return turnLine;
    }

    public static TmsTurnLine toEntity(TurnLine turnLine, boolean lazy) {
        if (null == turnLine) {
            return null;
        }
       TmsTurnLine gmoTurnLine = new TmsTurnLine();
        gmoTurnLine.setTmsTurnLineeId(turnLine.getId());
        gmoTurnLine.setTmsTurnLineDescription(turnLine.getDescription());
        gmoTurnLine.setTmsTurnLineQuantityServed(turnLine.getQuantityServed());
        gmoTurnLine.setTmsTurnLineSalePrice(turnLine.getSalePrice());
        gmoTurnLine.setTmsTurnLineTotalPriceHT(turnLine.getTotalPriceHT());
        gmoTurnLine.setTmsTurnLineTotalPriceTTC(turnLine.getTotalPriceTTC());

        gmoTurnLine.setUpdatedBy(turnLine.getUpdatedBy());
        gmoTurnLine.setCreatedBy(turnLine.getCreatedBy());
        if (!lazy) {
            gmoTurnLine.setPrmVat(VatMapper.toEntity(turnLine.getVat(), true));
            //gmoTurnLine.setOwnOwner(OwnerMapper.toEntity(turnLine.getOwner(), true));
            gmoTurnLine.setPdtProduct(ProductMapper.toEntity(turnLine.getProduct(), true));
            gmoTurnLine.setPdtUom(UomMapper.toEntity(turnLine.getUom(), true));
            gmoTurnLine.setPdtProductPack(ProductPackMapper.toEntity(turnLine.getProductPack(), true));
            gmoTurnLine.setCmdSaleOrderLine(SaleOrderLineMapper.toEntity(turnLine.getSaleOrderLine(), true));
            gmoTurnLine.setTmsTurnSoPo(TurnSoPoMapper.toEntity(turnLine.getTurnSoPo(), true));

            gmoTurnLine.setRcpPurshaseOrderLine(PurshaseOrderLineMapper.toEntity(turnLine.getPurshaseOrderLine(), true));
            gmoTurnLine.setStkStocks(StockMapper.toEntities(turnLine.getStocks(), true));

        }
        return gmoTurnLine;
    }

    public static List<TurnLine> toDtos(List<TmsTurnLine> gmoTurnLines, boolean lazy) {
        if (null == gmoTurnLines) {
            return null;
        }
        List<TurnLine> turnLines = new ArrayList<>();
        for (TmsTurnLine gmoTurnLine : gmoTurnLines) {
            turnLines.add(toDto(gmoTurnLine, lazy));
        }
        return turnLines;
    }

    public static List<TurnLine> toDtos(Iterable< ? extends TmsTurnLine> gmoTurnLines, boolean lazy) {
        if (null == gmoTurnLines) {
            return null;
        }
        List<TurnLine> turnLines = new ArrayList<>();
        for (TmsTurnLine gmoTurnLine : gmoTurnLines) {
            turnLines.add(toDto(gmoTurnLine, lazy));
        }
        return turnLines;
    }


    public static Set<TmsTurnLine> toEntities(List<TurnLine> turnLines, boolean lazy) {
        if (null == turnLines) {
            return null;
        }
        Set<TmsTurnLine> gmoTurnLines = new HashSet<>();
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

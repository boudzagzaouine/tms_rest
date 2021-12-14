/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TurnSoPo;
import com.bagile.gmo.entities.TmsTurnSoPo;
import com.bagile.gmo.util.EmsDate;

import java.util.*;

public class TurnSoPoMapper {
    private TurnSoPoMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTurnSoPoeId");
       // map.put("owner", "ownOwner");
        map.put("product", "pdtProduct");
        map.put("description", "tmsTurnSoPoDescription");
        map.put("blockType", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("quantityServed", "tmsTurnSoPoQuantityServed");
        map.put("salePrice", "tmsTurnSoPoSalePrice");
        map.put("vat", "prmVat");
        map.put("totalPriceHT", "tmsTurnSoPoTotalPriceHT");
        map.put("totalPriceTTC", "tmsTurnSoPoTotalPriceTTC");
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

    public static TurnSoPo toDto(TmsTurnSoPo tmsTurnSoPo, boolean lazy) {
        if (null == tmsTurnSoPo) {
            return null;
        }
        TurnSoPo turnSoPo = new TurnSoPo();
        turnSoPo.setId(tmsTurnSoPo.getTmsTurnSoPoeId());
        turnSoPo.setCode(tmsTurnSoPo.getTmsTurnSoPoCode());

        turnSoPo.setTotalPriceHT(tmsTurnSoPo.getTmsTurnSoPoTotalPriceHT());
        turnSoPo.setTotalPriceTTC(tmsTurnSoPo.getTmsTurnSoPoTotalPriceTTC());

        turnSoPo.setTotalPriceTurn(tmsTurnSoPo.getTmsTurnSoPoTotalPriceTurn());
        turnSoPo.setTotalQuantity(tmsTurnSoPo.getTmsTurnSoPoTotalQuantity());

        
        turnSoPo.setUpdatedBy(tmsTurnSoPo.getUpdatedBy());
        turnSoPo.setCreatedBy(tmsTurnSoPo.getCreatedBy());
        if (!lazy) {

          //  turnSoPo.setOwner(OwnerMapper.toDto(tmsTurnSoPo.getOwnOwner(), true));
         turnSoPo.setSaleOrder(SaleOrderMapper.toDto(tmsTurnSoPo.getCmdSaleOrder(), false));
            turnSoPo.setTurn(TurnMapper.toDto(tmsTurnSoPo.getTmsTurn(), true));

            turnSoPo.setPurshaseOrder(PurshaseOrderMapper.toDto(tmsTurnSoPo.getRcpPurshaseOrder(), false));
            turnSoPo.setTurnLines(TurnLineMapper.toDtos(tmsTurnSoPo.getTmsTurnLines(), false));

        }
        return turnSoPo;
    }

    public static TmsTurnSoPo toEntity(TurnSoPo turnSoPo, boolean lazy) {
        if (null == turnSoPo) {
            return null;
        }
       TmsTurnSoPo tmsTurnSoPo = new TmsTurnSoPo();
        tmsTurnSoPo.setTmsTurnSoPoeId(turnSoPo.getId());
        tmsTurnSoPo.setTmsTurnSoPoCode(turnSoPo.getCode());

        tmsTurnSoPo.setTmsTurnSoPoTotalPriceHT(turnSoPo.getTotalPriceHT());
        tmsTurnSoPo.setTmsTurnSoPoTotalPriceTTC(turnSoPo.getTotalPriceTTC());

        tmsTurnSoPo.setTmsTurnSoPoTotalPriceTurn(turnSoPo.getTotalPriceTurn());
        tmsTurnSoPo.setTmsTurnSoPoTotalQuantity(turnSoPo.getTotalQuantity());

        tmsTurnSoPo.setUpdatedBy(turnSoPo.getUpdatedBy());
        tmsTurnSoPo.setCreatedBy(turnSoPo.getCreatedBy());
        if (!lazy) {
             tmsTurnSoPo.setTmsTurn(TurnMapper.toEntity(turnSoPo.getTurn(), true));
            tmsTurnSoPo.setCmdSaleOrder(SaleOrderMapper.toEntity(turnSoPo.getSaleOrder(), false));
            tmsTurnSoPo.setTmsTurn(TurnMapper.toEntity(turnSoPo.getTurn(), true));

            tmsTurnSoPo.setRcpPurshaseOrder(PurshaseOrderMapper.toEntity(turnSoPo.getPurshaseOrder(), true));
            tmsTurnSoPo.setTmsTurnLines(TurnLineMapper.toEntities(turnSoPo.getTurnLines(), false));
            oneToMany(tmsTurnSoPo);

        }
        return tmsTurnSoPo;
    }
    private static void oneToMany(TmsTurnSoPo tmsTurnSoPo) {
        if(null !=tmsTurnSoPo.getTmsTurnLines()){
            tmsTurnSoPo.getTmsTurnLines().forEach(
                    tmsTurnLine -> {

                        if(0>=tmsTurnLine.getTmsTurnLineeId()){
                            tmsTurnLine.setCreationDate(EmsDate.getDateNow());
                            tmsTurnLine.setTmsTurnLineeId(0L);
                        }

                        tmsTurnLine.setUpdateDate(EmsDate.getDateNow());
                        tmsTurnLine.setTmsTurnSoPo(tmsTurnSoPo);
                    }
            );}
    }
    public static List<TurnSoPo> toDtos(List<TmsTurnSoPo> tmsTurnSoPos, boolean lazy) {
        if (null == tmsTurnSoPos) {
            return null;
        }
        List<TurnSoPo> turnSoPos = new ArrayList<>();
        for (TmsTurnSoPo tmsTurnSoPo : tmsTurnSoPos) {
            turnSoPos.add(toDto(tmsTurnSoPo, lazy));
        }
        return turnSoPos;
    }

    public static List<TurnSoPo> toDtos(Iterable< ? extends TmsTurnSoPo> tmsTurnSoPos, boolean lazy) {
        if (null == tmsTurnSoPos) {
            return null;
        }
        List<TurnSoPo> turnSoPos = new ArrayList<>();
        for (TmsTurnSoPo tmsTurnSoPo : tmsTurnSoPos) {
            turnSoPos.add(toDto(tmsTurnSoPo, lazy));
        }
        return turnSoPos;
    }


    public static Set<TmsTurnSoPo> toEntities(List<TurnSoPo> turnSoPos, boolean lazy) {
        if (null == turnSoPos) {
            return null;
        }
        Set<TmsTurnSoPo> tmsTurnSoPos = new HashSet<>();
        for (TurnSoPo turnSoPo : turnSoPos) {
            tmsTurnSoPos.add(toEntity(turnSoPo, lazy));
        }
        return tmsTurnSoPos;
    }

    /*public static Set<TurnSoPo> toDtos(Set<GmoTurnSoPo> tmsTurnSoPos, boolean lazy) {
        if (null == tmsTurnSoPos) {
            return null;
        }
        Set<TurnSoPo> turnSoPos = new HashSet<>();
        for (GmoTurnSoPo tmsTurnSoPo : tmsTurnSoPos) {
            turnSoPos.add(toDto(tmsTurnSoPo, lazy));
        }
        return turnSoPos;
    }*/



}

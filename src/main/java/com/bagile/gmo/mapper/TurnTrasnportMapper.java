/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TurnTransport;
import com.bagile.gmo.entities.TmsTurnTransport;

import java.util.*;

public class TurnTrasnportMapper {
    private TurnTrasnportMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTurnTransporteId");
       // map.put("owner", "ownOwner");
        map.put("product", "pdtProduct");
        map.put("description", "tmsTurnTransportDescription");
        map.put("blockType", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("quantityServed", "tmsTurnTransportQuantityServed");
        map.put("salePrice", "tmsTurnTransportSalePrice");
        map.put("vat", "prmVat");
        map.put("totalPriceHT", "tmsTurnTransportTotalPriceHT");
        map.put("totalPriceTTC", "tmsTurnTransportTotalPriceTTC");
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

    public static TurnTransport toDto(TmsTurnTransport tmsTurnTransport, boolean lazy) {
        if (null == tmsTurnTransport) {
            return null;
        }
        TurnTransport turnTransport = new TurnTransport();
        turnTransport.setId(tmsTurnTransport.getTmsTurnTransportId());
        turnTransport.setNumberOfPalette(tmsTurnTransport.getTmsTurnTransportNumberOfPalette());



        turnTransport.setUpdatedBy(tmsTurnTransport.getUpdatedBy());
        turnTransport.setCreatedBy(tmsTurnTransport.getCreatedBy());
        if (!lazy) {

          //  turnTransport.setOwner(OwnerMapper.toDto(tmsTurnTransport.getOwnOwner(), true));
         turnTransport.setVehicle(VehicleMapper.toDto(tmsTurnTransport.getGmoVehicle(), false));
            turnTransport.setVehicleCategory(VehicleCategoryMapper.toDto(tmsTurnTransport.getGmoVehicleCategory(), true));

            turnTransport.setTransport(TransportMapper.toDto(tmsTurnTransport.getTrpTransport(), false));
            turnTransport.setDrivers(DriverMapper.toDtos(tmsTurnTransport.getGmoDrivers(), false));
            turnTransport.setTurn(TurnMapper.toDto(tmsTurnTransport.getTmsTurnn(), true));

        }
        return turnTransport;
    }

    public static TmsTurnTransport toEntity(TurnTransport turnTransport, boolean lazy) {
        if (null == turnTransport) {
            return null;
        }
       TmsTurnTransport tmsTurnTransport = new TmsTurnTransport();
        tmsTurnTransport.setTmsTurnTransportId(turnTransport.getId());
        tmsTurnTransport.setTmsTurnTransportNumberOfPalette(turnTransport.getNumberOfPalette());

        tmsTurnTransport.setUpdatedBy(turnTransport.getUpdatedBy());
        tmsTurnTransport.setCreatedBy(turnTransport.getCreatedBy());
        if (!lazy) {
             tmsTurnTransport.setGmoVehicle(VehicleMapper.toEntity(turnTransport.getVehicle(), true));
            tmsTurnTransport.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(turnTransport.getVehicleCategory(), false));
            tmsTurnTransport.setTrpTransport(TransportMapper.toEntity(turnTransport.getTransport(), true));
            tmsTurnTransport.setGmoDrivers(DriverMapper.toEntities(turnTransport.getDrivers(), true));
            tmsTurnTransport.setTmsTurnn(TurnMapper.toEntity(turnTransport.getTurn(), true));


        }
        return tmsTurnTransport;
    }

    public static List<TurnTransport> toDtos(List<TmsTurnTransport> tmsTurnTransports, boolean lazy) {
        if (null == tmsTurnTransports) {
            return null;
        }
        List<TurnTransport> turnTransports = new ArrayList<>();
        for (TmsTurnTransport tmsTurnTransport : tmsTurnTransports) {
            turnTransports.add(toDto(tmsTurnTransport, lazy));
        }
        return turnTransports;
    }

    public static List<TurnTransport> toDtos(Iterable< ? extends TmsTurnTransport> tmsTurnTransports, boolean lazy) {
        if (null == tmsTurnTransports) {
            return null;
        }
        List<TurnTransport> turnTransports = new ArrayList<>();
        for (TmsTurnTransport tmsTurnTransport : tmsTurnTransports) {
            turnTransports.add(toDto(tmsTurnTransport, lazy));
        }
        return turnTransports;
    }


    public static Set<TmsTurnTransport> toEntities(List<TurnTransport> turnTransports, boolean lazy) {
        if (null == turnTransports) {
            return null;
        }
        Set<TmsTurnTransport> tmsTurnTransports = new HashSet<>();
        for (TurnTransport turnTransport : turnTransports) {
            tmsTurnTransports.add(toEntity(turnTransport, lazy));
        }
        return tmsTurnTransports;
    }

    /*public static Set<TurnTransport> toDtos(Set<GmoTurnTransport> tmsTurnTransports, boolean lazy) {
        if (null == tmsTurnTransports) {
            return null;
        }
        Set<TurnTransport> turnTransports = new HashSet<>();
        for (GmoTurnTransport tmsTurnTransport : tmsTurnTransports) {
            turnTransports.add(toDto(tmsTurnTransport, lazy));
        }
        return turnTransports;
    }*/



}

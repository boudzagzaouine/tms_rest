package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Turn;
import com.bagile.gmo.entities.TmsTurn;
import com.bagile.gmo.util.EmsDate;

import java.util.*;

public class TurnMapper {
    public TurnMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTurnId");
        map.put("vehicle", "gmoVehicle");
        map.put("transport", "trpTransport");
        map.put("dateDelivery", "dateDelivery");
        map.put("turnLines", "gmoTurnLines");
   
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsTurn toEntity(Turn turn, boolean lazy) {
        if (null == turn) {
            return null;
        }
        TmsTurn gmoTurn = new TmsTurn();
        gmoTurn.setTmsTurnId(turn.getId());
        gmoTurn.setDateDelivery(turn.getDateDelivery());

        gmoTurn.setTmsTurnTotalSoTTC(turn.getTotalSoTTC());
        gmoTurn.setTmsTurnTotalPoTTC(turn.getTotalPoTTC());
        gmoTurn.setTmsTurnTotalSoQnt(turn.getTotalSoQnt());
        gmoTurn.setTmsTurnTotalPoQnt(turn.getTotalPoQnt());
        gmoTurn.setTmsTurnTotalSoPriceTurn(turn.getTotalSoPriceTurn());
        gmoTurn.setTmsTurnTotalPoPriceTurn(turn.getTotalPoPriceTurn());
        gmoTurn.setTmsTurnPackagingType(turn.getPackagingType());
        gmoTurn.setTmsTurnCode(turn.getCode());


        if (!lazy) {
            //gmoTurn.setGmoCommissions(CommissionTurnMapper.toEntities(turn.getCommissions(), false));
            //gmoTurn.setGmoDrivers(DriverMapper.toEntities(turn.getDrivers(), false));
           // gmoTurn.setTrpTransport(TransportMapper.toEntity(turn.getTransport(), false));
           // gmoTurn.setGmoVehicle(VehicleMapper.toEntity(turn.getVehicle(), false));
            gmoTurn.setTmsTurnType(TurnTypeMapper.toEntity(turn.getTurnType(), false));
            gmoTurn.setTmsTurnSoPos(TurnSoPoMapper.toEntities(turn.getTurnSoPos(), false));
            gmoTurn.setTmsTurnTransports(TurnTrasnportMapper.toEntities(turn.getTurnTransports(), false));

            oneToMany(gmoTurn);
            oneToManyTransport(gmoTurn);

        }
        return gmoTurn;

    }
    private static void oneToMany(TmsTurn tmsTurn) {
        if(null !=tmsTurn.getTmsTurnSoPos()){
            tmsTurn.getTmsTurnSoPos().forEach(
                    tmsTurnSoPos -> {

                        if(0> tmsTurnSoPos.getTmsTurnSoPoeId()){
                            tmsTurnSoPos.setCreationDate(EmsDate.getDateNow());
                            tmsTurnSoPos.setTmsTurnSoPoeId(0L);
                        }

                        tmsTurnSoPos.setUpdateDate(EmsDate.getDateNow());
                        tmsTurnSoPos.setTmsTurn(tmsTurn);
                    }
            );
        }

        if(null !=tmsTurn.getTmsTurnTransports()){
            tmsTurn.getTmsTurnTransports().forEach(
                    tmsTurnTransport -> {

                        if(0> tmsTurnTransport.getTmsTurnTransportId()){
                            tmsTurnTransport.setCreationDate(EmsDate.getDateNow());
                            tmsTurnTransport.setTmsTurnTransportId(0L);
                        }

                        tmsTurnTransport.setUpdateDate(EmsDate.getDateNow());
                        tmsTurnTransport.setTmsTurnn(tmsTurn);
                    }
            );
        }
    }
    private static void oneToManyTransport(TmsTurn tmsTurn) {

        if(null !=tmsTurn.getTmsTurnTransports()){
            tmsTurn.getTmsTurnTransports().forEach(
                    tmsTurnTransport -> {

                        if(0> tmsTurnTransport.getTmsTurnTransportId()){
                            tmsTurnTransport.setCreationDate(EmsDate.getDateNow());
                            tmsTurnTransport.setTmsTurnTransportId(0L);
                        }

                        tmsTurnTransport.setUpdateDate(EmsDate.getDateNow());
                        tmsTurnTransport.setTmsTurnn(tmsTurn);
                    }
            );
        }
    }


    public static Turn toDto(TmsTurn gmoTurn, boolean lazy) {
        if (null == gmoTurn) {
            return null;
        }
        Turn turn = new Turn();
        turn.setId( gmoTurn.getTmsTurnId());
        turn.setDateDelivery(gmoTurn.getDateDelivery());

        turn.setTotalSoTTC(gmoTurn.getTmsTurnTotalSoTTC());
        turn.setTotalPoTTC(gmoTurn.getTmsTurnTotalPoTTC());
        turn.setTotalSoQnt(gmoTurn.getTmsTurnTotalSoQnt());
        turn.setTotalPoQnt(gmoTurn.getTmsTurnTotalPoQnt());
        turn.setTotalSoPriceTurn(gmoTurn.getTmsTurnTotalSoPriceTurn());
        turn.setTotalPoPriceTurn(gmoTurn.getTmsTurnTotalPoPriceTurn());
        turn.setPackagingType(gmoTurn.getTmsTurnPackagingType());

        turn.setCode(gmoTurn.getTmsTurnCode());

        turn.setCreatedBy(gmoTurn.getCreatedBy());
        turn.setUpdatedBy(gmoTurn.getUpdatedBy());
        turn.setCreationDate(gmoTurn.getCreationDate());
        turn.setUpdateDate(gmoTurn.getUpdateDate());

        if (!lazy) {
         //   turn.setCommissions(CommissionTurnMapper.toDtos(gmoTurn.getGmoCommissions (), false));
           // turn.setDrivers(DriverMapper.toDtos(gmoTurn.getGmoDrivers(), false));
            //turn.setTransport(TransportMapper.toDto(gmoTurn.getTrpTransport(), false));
           // turn.setVehicle(VehicleMapper.toDto(gmoTurn.getGmoVehicle(), false));
            turn.setTurnType(TurnTypeMapper.toDto(gmoTurn.getTmsTurnType(), false));
            turn.setTurnSoPos(TurnSoPoMapper.toDtos(gmoTurn.getTmsTurnSoPos(), false));
            turn.setTurnTransports(TurnTrasnportMapper.toDtos(gmoTurn.getTmsTurnTransports(), false));

        }
        return turn;

    }


    public static List<Turn> toDtos(Iterable<? extends TmsTurn> tmsTurns, boolean lazy) {
        if (null == tmsTurns) {
            return null;
        }
        List<Turn> turns = new ArrayList<>();
        for (TmsTurn tmsTurn : tmsTurns) {
            turns.add(toDto(tmsTurn, lazy));
        }
        return turns;
    }

    public static Set<TmsTurn> toEntities(Set<? extends Turn> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsTurn> tmsTurns = new HashSet<>();

        for (Turn turn : turns) {
            tmsTurns.add(toEntity(turn, lazy));
        }
        return tmsTurns;
    }

    public static Set<Turn> toDtos(Set<? extends TmsTurn> tmsTurns, boolean lazy) {
        if (null == tmsTurns) {
            return null;
        }
        Set<Turn> turns = new HashSet<>();
        for (TmsTurn tmsTurn : tmsTurns) {
            turns.add(toDto(tmsTurn, lazy));
        }
        return turns;
    }

}

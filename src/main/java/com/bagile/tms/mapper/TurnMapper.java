package com.bagile.tms.mapper;

import com.bagile.tms.dto.Turn;
import com.bagile.tms.entities.TmsTurn;

import java.util.*;

public class TurnMapper {
    public TurnMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTurnId");
        map.put("turns", "tmsTurns");
        map.put("vehicle", "tmsVehicle");
        map.put("transport", "trpTransport");
        map.put("dateDelivery", "dateDelivery");
        map.put("turnLines", "tmsTurnLines");
   
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
        TmsTurn tmsTurn = new TmsTurn();
        tmsTurn.setTmsTurnId(turn.getId());
        tmsTurn.setDateDelivery(turn.getDateDelivery());
   
        
        if (!lazy) {
            //tmsTurn.setTmsCommissions(CommissionTurnMapper.toEntities(turn.getCommissions(), false));
            tmsTurn.setTmsTurnLines(TurnLineMapper.toEntities(turn.getTurnLines(), false));
            tmsTurn.setTmsDrivers(DriverMapper.toEntities(turn.getDrivers(), false));
            tmsTurn.setTrpTransport(TransportMapper.toEntity(turn.getTransport(), false));
            tmsTurn.setTmsVehicle(VehicleMapper.toEntity(turn.getVehicle(), false));



        }
        return tmsTurn;

    }



    public static Turn toDto(TmsTurn tmsTurn, boolean lazy) {
        if (null == tmsTurn) {
            return null;
        }
        Turn turn = new Turn();
        turn.setId( tmsTurn.getTmsTurnId());
        turn.setDateDelivery(tmsTurn.getDateDelivery());


        turn.setCreatedBy(tmsTurn.getCreatedBy());
        turn.setUpdatedBy(tmsTurn.getUpdatedBy());
        turn.setCreationDate(tmsTurn.getCreationDate());
        turn.setUpdateDate(tmsTurn.getUpdateDate());

        if (!lazy) {
         //   turn.setCommissions(CommissionTurnMapper.toDtos(tmsTurn.getTmsCommissions (), false));
            turn.setDrivers(DriverMapper.toDtos(tmsTurn.getTmsDrivers(), false));
            turn.setTurnLines(TurnLineMapper.toDtos(tmsTurn.getTmsTurnLines(), false));
            turn.setTransport(TransportMapper.toDto(tmsTurn.getTrpTransport(), false));
            turn.setVehicle(VehicleMapper.toDto(tmsTurn.getTmsVehicle(), false));

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

    public static Set<TmsTurn> toEntities(Set<Turn> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsTurn> tmsTurns = new HashSet<>();
        for (Turn turn : turns) {
            tmsTurns.add(toEntity(turn, lazy));
        }
        return tmsTurns;
    }

    public static Set<Turn> toDtos(Set<TmsTurn> tmsTurns, boolean lazy) {
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

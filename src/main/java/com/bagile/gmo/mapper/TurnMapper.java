package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.Turn;
import com.bagile.gmo.entities.GmoTurn;

public class TurnMapper {
    public TurnMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoTurnId");
        map.put("turns", "gmoTurns");
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

    public static GmoTurn toEntity(Turn turn, boolean lazy) {
        if (null == turn) {
            return null;
        }
        GmoTurn gmoTurn = new GmoTurn();
        gmoTurn.setGmoTurnId(turn.getId());
        gmoTurn.setDateDelivery(turn.getDateDelivery());
   
        
        if (!lazy) {
            //gmoTurn.setGmoCommissions(CommissionTurnMapper.toEntities(turn.getCommissions(), false));
            gmoTurn.setGmoTurnLines(TurnLineMapper.toEntities(turn.getTurnLines(), false));
            gmoTurn.setGmoDrivers(DriverMapper.toEntities(turn.getDrivers(), false));
            gmoTurn.setTrpTransport(TransportMapper.toEntity(turn.getTransport(), false));
            gmoTurn.setGmoVehicle(VehicleMapper.toEntity(turn.getVehicle(), false));



        }
        return gmoTurn;

    }



    public static Turn toDto(GmoTurn gmoTurn, boolean lazy) {
        if (null == gmoTurn) {
            return null;
        }
        Turn turn = new Turn();
        turn.setId( gmoTurn.getGmoTurnId());
        turn.setDateDelivery(gmoTurn.getDateDelivery());


        turn.setCreatedBy(gmoTurn.getCreatedBy());
        turn.setUpdatedBy(gmoTurn.getUpdatedBy());
        turn.setCreationDate(gmoTurn.getCreationDate());
        turn.setUpdateDate(gmoTurn.getUpdateDate());

        if (!lazy) {
         //   turn.setCommissions(CommissionTurnMapper.toDtos(gmoTurn.getGmoCommissions (), false));
            turn.setDrivers(DriverMapper.toDtos(gmoTurn.getGmoDrivers(), false));
            turn.setTurnLines(TurnLineMapper.toDtos(gmoTurn.getGmoTurnLines(), false));
            turn.setTransport(TransportMapper.toDto(gmoTurn.getTrpTransport(), false));
            turn.setVehicle(VehicleMapper.toDto(gmoTurn.getGmoVehicle(), false));

        }
        return turn;

    }


    public static List<Turn> toDtos(Iterable<? extends GmoTurn> gmoTurns, boolean lazy) {
        if (null == gmoTurns) {
            return null;
        }
        List<Turn> turns = new ArrayList<>();

        for (GmoTurn gmoTurn : gmoTurns) {
            turns.add(toDto(gmoTurn, lazy));
        }
        return turns;
    }

    public static Set<GmoTurn> toEntities(Set<Turn> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<GmoTurn> gmoTurns = new HashSet<>();
        for (Turn turn : turns) {
            gmoTurns.add(toEntity(turn, lazy));
        }
        return gmoTurns;
    }

    public static Set<Turn> toDtos(Set<GmoTurn> gmoTurns, boolean lazy) {
        if (null == gmoTurns) {
            return null;
        }
        Set<Turn> turns = new HashSet<>();
        for (GmoTurn gmoTurn : gmoTurns) {
            turns.add(toDto(gmoTurn, lazy));
        }
        return turns;
    }
}

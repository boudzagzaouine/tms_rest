package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransport;
import com.bagile.gmo.dto.TransportPlanHistory;
import com.bagile.gmo.entities.TmsTransportPlanHistory;

import java.util.*;

public class TransportPlanHistoryMapper {
    public TransportPlanHistoryMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTransportPlanHistoryId");
        map.put("vehicle", "gmoVehicle");
        map.put("vehicleCategory", "gmoVehicleCategory");
        map.put("orderTransport", "tmsOrderTransport");
        map.put("villeSource", "prmVilleSource");
        map.put("villeDistination", "prmVilleDistination");
        map.put("transport", "trpTransport");
        map.put("turnType", "tmsTransportPlanHistoryType");
        map.put("turnStatus", "tmsTurnStatus");
        map.put("type", "tmsTransportPlanHistoryType");
        map.put("orderTransportRejectType", "tmsOrderTransportRejectType");
        map.put("trajet", "tmsTrajet");

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

    public static TmsTransportPlanHistory toEntity(TransportPlanHistory transportPlanHistory, boolean lazy) {
        if (null == transportPlanHistory) {
            return null;
        }
        TmsTransportPlanHistory tmsTransportPlanHistory = new TmsTransportPlanHistory();
        tmsTransportPlanHistory.setTmsTransportPlanHistoryId(transportPlanHistory.getId());
        tmsTransportPlanHistory.setTmsTransportPlanHistoryPurchasePrice(transportPlanHistory.getPurchasePrice());
        tmsTransportPlanHistory.setTmsTransportPlanHistoryDate(transportPlanHistory.getDate());
        tmsTransportPlanHistory.setTmsTransportPlanHistorySalePrice(transportPlanHistory.getSalePrice());
        tmsTransportPlanHistory.setTmsTransportPlanHistoryType(transportPlanHistory.getType());
        tmsTransportPlanHistory.setTmsTransportPlanHistoryRemark(transportPlanHistory.getRemark());
        tmsTransportPlanHistory.setTmsTransportPlanHistoryMarginRate(transportPlanHistory.getMarginRate());
        tmsTransportPlanHistory.setTmsTransportPlanHistorymargineService(transportPlanHistory.getMargineService());


        if (!lazy) {
            tmsTransportPlanHistory.setTmsOrderTransport(OrderTransportMapper.toEntity(transportPlanHistory.getOrderTransport(), false));
            tmsTransportPlanHistory.setGmoVehicle(VehicleMapper.toEntity(transportPlanHistory.getVehicle(), true));
            tmsTransportPlanHistory.setGmoDriver(DriverMapper.toEntity(transportPlanHistory.getDriver(), true));
            tmsTransportPlanHistory.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(transportPlanHistory.getVehicleCategory(), true));
            tmsTransportPlanHistory.setTrpTransport(TransportMapper.toEntity(transportPlanHistory.getTransport(), true));
            tmsTransportPlanHistory.setTmsTurnStatus(TurnStatusMapper.toEntity(transportPlanHistory.getTurnStatus(), true));
//        tmsTransportPlanHistory.setPrmVilleSource(VilleMapper.toEntity(transportPlanHistory.getVilleSource(), true));
//           tmsTransportPlanHistory.setPrmVilleDistination(VilleMapper.toEntity(transportPlanHistory.getVilleDistination(), true));
            tmsTransportPlanHistory.setTmsOrderTransportRejectType(OrderTransportRejectTypeMapper.toEntity(transportPlanHistory.getOrderTransportRejectType(), true));
            tmsTransportPlanHistory.setTmsTrajet(TrajetMapper.toEntity(transportPlanHistory.getTrajet(), true));

        }
        return tmsTransportPlanHistory;

    }


 

    public static TransportPlanHistory toDto(TmsTransportPlanHistory tmsTransportPlanHistory, boolean lazy) {
        if (null == tmsTransportPlanHistory) {
            return null;
        }
        TransportPlanHistory transportPlanHistory = new TransportPlanHistory();
        transportPlanHistory.setId( tmsTransportPlanHistory.getTmsTransportPlanHistoryId());
        transportPlanHistory.setPurchasePrice(tmsTransportPlanHistory.getTmsTransportPlanHistoryPurchasePrice());
        transportPlanHistory.setDate(tmsTransportPlanHistory.getTmsTransportPlanHistoryDate());


        transportPlanHistory.setSalePrice(tmsTransportPlanHistory.getTmsTransportPlanHistorySalePrice());
        transportPlanHistory.setType(tmsTransportPlanHistory.getTmsTransportPlanHistoryType());
        transportPlanHistory.setRemark(tmsTransportPlanHistory.getTmsTransportPlanHistoryRemark());
        transportPlanHistory.setMargineService(tmsTransportPlanHistory.getTmsTransportPlanHistorymargineService());
        transportPlanHistory.setMarginRate(tmsTransportPlanHistory.getTmsTransportPlanHistoryMarginRate());

        if (!lazy) {
            transportPlanHistory.setOrderTransport(OrderTransportMapper.toDto(tmsTransportPlanHistory.getTmsOrderTransport(), false));
            transportPlanHistory.setVehicle(VehicleMapper.toDto(tmsTransportPlanHistory.getGmoVehicle(), true));
            transportPlanHistory.setDriver(DriverMapper.toDto(tmsTransportPlanHistory.getGmoDriver(), true));
            transportPlanHistory.setVehicleCategory(VehicleCategoryMapper.toDto(tmsTransportPlanHistory.getGmoVehicleCategory(), true));
            transportPlanHistory.setTransport(TransportMapper.toDto(tmsTransportPlanHistory.getTrpTransport(), true));
            transportPlanHistory.setTurnStatus(TurnStatusMapper.toDto(tmsTransportPlanHistory.getTmsTurnStatus(), true));
//          transportPlanHistory.setVilleSource(VilleMapper.toDto(tmsTransportPlanHistory.getPrmVilleSource(), true));
//           transportPlanHistory.setVilleDistination(VilleMapper.toDto(tmsTransportPlanHistory.getPrmVilleDistination(), true));
            transportPlanHistory.setOrderTransportRejectType(OrderTransportRejectTypeMapper.toDto(tmsTransportPlanHistory.getTmsOrderTransportRejectType(), true));
            transportPlanHistory.setTrajet(TrajetMapper.toDto(tmsTransportPlanHistory.getTmsTrajet(), true));



        }
        return transportPlanHistory;

    }



    public static List<TransportPlanHistory> toDtos(Iterable<? extends TmsTransportPlanHistory> tmsTransportPlanHistorys, boolean lazy) {
        if (null == tmsTransportPlanHistorys) {
            return null;
        }
        List<TransportPlanHistory> turns = new ArrayList<>();
        for (TmsTransportPlanHistory tmsTransportPlanHistory : tmsTransportPlanHistorys) {
            turns.add(toDto(tmsTransportPlanHistory, lazy));
        }
        return turns;
    }

    public static Set<TmsTransportPlanHistory> toEntities(Set<? extends TransportPlanHistory> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsTransportPlanHistory> tmsTransportPlanHistorys = new HashSet<>();

        for (TransportPlanHistory transportPlanHistory : turns) {
            tmsTransportPlanHistorys.add(toEntity(transportPlanHistory, lazy));
        }
        return tmsTransportPlanHistorys;
    }

    public static Set<TransportPlanHistory> toDtos(Set<? extends TmsTransportPlanHistory> tmsTransportPlanHistorys, boolean lazy) {
        if (null == tmsTransportPlanHistorys) {
            return null;
        }
        Set<TransportPlanHistory> turns = new HashSet<>();
        for (TmsTransportPlanHistory tmsTransportPlanHistory : tmsTransportPlanHistorys) {
            turns.add(toDto(tmsTransportPlanHistory, lazy));
        }
        return turns;
    }

}

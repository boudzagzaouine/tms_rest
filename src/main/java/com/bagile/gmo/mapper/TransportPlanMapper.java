package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportPlan;
import com.bagile.gmo.entities.TmsTransportPlan;

import java.util.*;

public class TransportPlanMapper {
    public TransportPlanMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTransportPlanId");

        map.put("vehicle", "tmsVehicle");
        map.put("vehicleCategory", "gmoVehicleCategory");
        map.put("orderTransport", "tmsOrderTransport");
        map.put("villeSource", "prmVilleSource");
        map.put("villeDistination", "prmVilleDistination");
        map.put("transport", "trpTransport");
        map.put("turnType", "tmsTransportPlanType");
        map.put("turnStatus", "tmsTurnStatus");
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

    public static TmsTransportPlan toEntity(TransportPlan transportPlan, boolean lazy) {
        if (null == transportPlan) {
            return null;
        }
        TmsTransportPlan tmsTransportPlan = new TmsTransportPlan();
        tmsTransportPlan.setTmsTransportPlanId(transportPlan.getId());
        tmsTransportPlan.setTmsTransportPlanPurchasePrice(transportPlan.getPurchasePrice());
        tmsTransportPlan.setTmsTransportPlanDate(transportPlan.getDate());
        tmsTransportPlan.setPrmVilleSource(transportPlan.getVilleSource());
        tmsTransportPlan.setPrmVilleDistination(transportPlan.getVilleDistination());
        tmsTransportPlan.setTmsTransportPlanSalePrice(transportPlan.getSalePrice());


        if (!lazy) {
            tmsTransportPlan.setTmsOrderTransport(OrderTransportMapper.toEntity(transportPlan.getOrderTransport(), false));
            tmsTransportPlan.setGmoVehicle(VehicleMapper.toEntity(transportPlan.getVehicle(), true));
            tmsTransportPlan.setGmoDriver(DriverMapper.toEntity(transportPlan.getDriver(), true));
            tmsTransportPlan.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(transportPlan.getVehicleCategory(), true));
            tmsTransportPlan.setTrpTransport(TransportMapper.toEntity(transportPlan.getTransport(), true));
            tmsTransportPlan.setTmsTurnStatus(TurnStatusMapper.toEntity(transportPlan.getTurnStatus(), true));
//            tmsTransportPlan.setPrmVilleSource(VilleMapper.toEntity(transportPlan.getVilleSource(), true));
//            tmsTransportPlan.setPrmVilleDistination(VilleMapper.toEntity(transportPlan.getVilleDistination(), true));

        }
        return tmsTransportPlan;

    }




    public static TransportPlan toDto(TmsTransportPlan tmsTransportPlan, boolean lazy) {
        if (null == tmsTransportPlan) {
            return null;
        }
        TransportPlan transportPlan = new TransportPlan();
        transportPlan.setId( tmsTransportPlan.getTmsTransportPlanId());
        transportPlan.setPurchasePrice(tmsTransportPlan.getTmsTransportPlanPurchasePrice());
        transportPlan.setDate(tmsTransportPlan.getTmsTransportPlanDate());

        transportPlan.setVilleSource(tmsTransportPlan.getPrmVilleSource());
        transportPlan.setVilleDistination(tmsTransportPlan.getPrmVilleDistination());

        transportPlan.setSalePrice(tmsTransportPlan.getTmsTransportPlanSalePrice());

        if (!lazy) {
            transportPlan.setOrderTransport(OrderTransportMapper.toDto(tmsTransportPlan.getTmsOrderTransport(), false));
            transportPlan.setVehicle(VehicleMapper.toDto(tmsTransportPlan.getGmoVehicle(), true));
            transportPlan.setDriver(DriverMapper.toDto(tmsTransportPlan.getGmoDriver(), true));
            transportPlan.setVehicleCategory(VehicleCategoryMapper.toDto(tmsTransportPlan.getGmoVehicleCategory(), true));
            transportPlan.setTransport(TransportMapper.toDto(tmsTransportPlan.getTrpTransport(), true));
            transportPlan.setTurnStatus(TurnStatusMapper.toDto(tmsTransportPlan.getTmsTurnStatus(), true));
//            transportPlan.setVilleSource(VilleMapper.toDto(tmsTransportPlan.getPrmVilleSource(), true));
//            transportPlan.setVilleDistination(VilleMapper.toDto(tmsTransportPlan.getPrmVilleDistination(), true));



        }
        return transportPlan;

    }



    public static List<TransportPlan> toDtos(Iterable<? extends TmsTransportPlan> tmsTransportPlans, boolean lazy) {
        if (null == tmsTransportPlans) {
            return null;
        }
        List<TransportPlan> turns = new ArrayList<>();
        for (TmsTransportPlan tmsTransportPlan : tmsTransportPlans) {
            turns.add(toDto(tmsTransportPlan, lazy));
        }
        return turns;
    }

    public static Set<TmsTransportPlan> toEntities(Set<? extends TransportPlan> turns, boolean lazy) {
        if (null == turns) {
            return null;
        }
        Set<TmsTransportPlan> tmsTransportPlans = new HashSet<>();

        for (TransportPlan transportPlan : turns) {
            tmsTransportPlans.add(toEntity(transportPlan, lazy));
        }
        return tmsTransportPlans;
    }

    public static Set<TransportPlan> toDtos(Set<? extends TmsTransportPlan> tmsTransportPlans, boolean lazy) {
        if (null == tmsTransportPlans) {
            return null;
        }
        Set<TransportPlan> turns = new HashSet<>();
        for (TmsTransportPlan tmsTransportPlan : tmsTransportPlans) {
            turns.add(toDto(tmsTransportPlan, lazy));
        }
        return turns;
    }

}

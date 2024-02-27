package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.TransportPlanLocation;
import com.bagile.gmo.entities.TmsTransportPlanLocation;

import java.util.*;

public class TransportPlanLocationMapper {
    public TransportPlanLocationMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsTransportPlanLocationId");
        map.put("vehicle", "tmsTransportPlanLocationvehicle");
        map.put("driver", "tmsTransportPlanLocationdriver");
        map.put("date", "tmsTransportPlanLocationdate");
        map.put("orderTransport", "tmsTransportPlanLocationOrderTransport");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsTransportPlanLocation toEntity(TransportPlanLocation transportPlanLocation, boolean lazy) {
        if (null == transportPlanLocation) {
            return null;
        }
        TmsTransportPlanLocation tmsTransportPlanLocation = new TmsTransportPlanLocation();
        tmsTransportPlanLocation.setTmsTransportPlanLocationId(transportPlanLocation.getId());
        tmsTransportPlanLocation.setTmsTransportPlanLocationtransportPlanId(transportPlanLocation.getTransportPlanId());
        tmsTransportPlanLocation.setTmsTransportPlanLocationOrderTransportId(transportPlanLocation.getOrderTransportId());
        tmsTransportPlanLocation.setTmsTransportPlanLocationOrderTransportInfoId(transportPlanLocation.getOrderTransportInfoId());
        tmsTransportPlanLocation.setTmsTransportPlanLocationOrderTransportInfoLineID(transportPlanLocation.getOrderTransportInfoLineId());
        tmsTransportPlanLocation.setTmsTransportPlanLocationvehicleId(transportPlanLocation.getVehicleId());
        tmsTransportPlanLocation.setTmsTransportPlanLocationdriverId(transportPlanLocation.getDriverId());
        tmsTransportPlanLocation.setTmsTransportPlanLocationlatitude(transportPlanLocation.getLatitude());
        tmsTransportPlanLocation.setTmsTransportPlanLocationlongitude(transportPlanLocation.getLongitude());
        tmsTransportPlanLocation.setTmsTransportPlanLocationdate(transportPlanLocation.getDate());
        tmsTransportPlanLocation.setTmsTransportPlanLocationType(transportPlanLocation.getType());
        tmsTransportPlanLocation.setAccountId(transportPlanLocation.getAccountId());
        tmsTransportPlanLocation.setAccountName(transportPlanLocation.getAccountName());

        if (!lazy) {
            tmsTransportPlanLocation.setTmsTransportPlanLocationtransportPlan(TransportPlanMapper.toEntity(transportPlanLocation.getTransportPlan(),true));
            tmsTransportPlanLocation.setTmsTransportPlanLocationOrderTransport(OrderTransportMapper.toEntity(transportPlanLocation.getOrderTransport(),true));
            tmsTransportPlanLocation.setTmsTransportPlanLocationOrderTransportInfo(OrderTransportInfoMapper.toEntity(transportPlanLocation.getOrderTransportInfo(),true));
            tmsTransportPlanLocation.setTmsTransportPlanLocationOrderTransportInfoLine(OrderTransportInfoLineMapper.toEntity(transportPlanLocation.getOrderTransportInfoLine(),true));
            tmsTransportPlanLocation.setTmsTransportPlanLocationDriver(DriverMapper.toEntity(transportPlanLocation.getDriver(),true));
            tmsTransportPlanLocation.setTmsTransportPlanLocationVehicle(VehicleMapper.toEntity(transportPlanLocation.getVehicle(),true));


        }
        return tmsTransportPlanLocation;
    }

    public static TransportPlanLocation toDto(TmsTransportPlanLocation tmsTransportPlanLocation, boolean lazy) {
        if (null == tmsTransportPlanLocation) {
            return null;
        }
        TransportPlanLocation transportPlanLocation = new TransportPlanLocation();
        transportPlanLocation.setId(tmsTransportPlanLocation.getTmsTransportPlanLocationId());
        transportPlanLocation.setTransportPlanId(tmsTransportPlanLocation.getTmsTransportPlanLocationtransportPlanId());
        transportPlanLocation.setOrderTransportId(tmsTransportPlanLocation.getTmsTransportPlanLocationOrderTransportId());
        transportPlanLocation.setOrderTransportInfoId(tmsTransportPlanLocation.getTmsTransportPlanLocationOrderTransportInfoId());
        transportPlanLocation.setOrderTransportInfoLineId(tmsTransportPlanLocation.getTmsTransportPlanLocationOrderTransportInfoLineID());
        transportPlanLocation.setVehicleId(tmsTransportPlanLocation.getTmsTransportPlanLocationvehicleId());
        transportPlanLocation.setDriverId(tmsTransportPlanLocation.getTmsTransportPlanLocationdriverId());

        transportPlanLocation.setLatitude(tmsTransportPlanLocation.getTmsTransportPlanLocationlatitude());
        transportPlanLocation.setLongitude(tmsTransportPlanLocation.getTmsTransportPlanLocationlongitude());
        transportPlanLocation.setDate(tmsTransportPlanLocation.getTmsTransportPlanLocationdate());
        transportPlanLocation.setType(tmsTransportPlanLocation.getTmsTransportPlanLocationType());
        transportPlanLocation.setAccountId(tmsTransportPlanLocation.getAccountId());
        transportPlanLocation.setAccountName(tmsTransportPlanLocation.getAccountName());

        if (!lazy) {

            transportPlanLocation.setTransportPlan(TransportPlanMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationtransportPlan(), false));
            transportPlanLocation.setOrderTransport(OrderTransportMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationOrderTransport(), false));
            transportPlanLocation.setOrderTransportInfo(OrderTransportInfoMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationOrderTransportInfo(), false));
            transportPlanLocation.setOrderTransportInfoLine(OrderTransportInfoLineMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationOrderTransportInfoLine(), false));
            transportPlanLocation.setDriver(DriverMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationDriver(), false));
            transportPlanLocation.setVehicle(VehicleMapper.toDto(tmsTransportPlanLocation.getTmsTransportPlanLocationVehicle(), false));

        }
        return transportPlanLocation;

    }


    public static List<TransportPlanLocation> toDtos(Iterable<? extends TmsTransportPlanLocation> tmsTransportPlanLocations, boolean lazy) {
        if (null == tmsTransportPlanLocations) {
            return null;
        }
        List<TransportPlanLocation> transportPlanLocations = new ArrayList<>();

        for (TmsTransportPlanLocation tmsTransportPlanLocation : tmsTransportPlanLocations) {
            transportPlanLocations.add(toDto(tmsTransportPlanLocation, lazy));
        }
        return transportPlanLocations;
    }

    public static Set<TmsTransportPlanLocation> toEntities(List<TransportPlanLocation> list, boolean lazy) {
        if (null == list) {
            return null;
        }
        Set<TmsTransportPlanLocation> tmsTransportPlanLocations = new HashSet<>();
        for (TransportPlanLocation transportPlanLocation : list) {
            tmsTransportPlanLocations.add(toEntity(transportPlanLocation, lazy));
        }
        return tmsTransportPlanLocations;
    }

    public static List<TransportPlanLocation> toDtos(List<TmsTransportPlanLocation> tmsTransportPlanLocations, boolean lazy) {
        if (null == tmsTransportPlanLocations) {
            return null;
        }
        List<TransportPlanLocation> transportPlanLocations = new ArrayList<>();
        for (TmsTransportPlanLocation tmsTransportPlanLocation : tmsTransportPlanLocations) {
            transportPlanLocations.add(toDto(tmsTransportPlanLocation, lazy));
        }
        return transportPlanLocations;
    }
}

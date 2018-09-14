package com.bagile.tms.mapper;

import com.bagile.tms.dto.Road;
import com.bagile.tms.entities.TmsRoad;

import java.util.*;

public class RoadMapper {
    public RoadMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsRoadId");
        map.put("code", "tmsRoadCode");
        map.put("duration", "tmsRoadDuration");
        map.put("cost", "tmsRoadCost");
        map.put("distance", "tmsRoadDistance");
        map.put("driver", "tmsRoadDriver");
        map.put("adjunct", "tmsRoadAdjunct");
        map.put("date", "tmsRoadDate");
        map.put("state", "tmsRoadState");
        map.put("saleOrders", "tmsRoadSaleOrders");
        map.put("stockAddress", "tmsRoadStockAddress");
        map.put("creationDate", "tmsRoadCreationDate");
        map.put("creationUser", "tmsRoadCreationUser");
        map.put("upDateUser", "tmsRoadUpDateUser");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsRoad toEntity(Road road, boolean lazy){
        if (null == road) {
            return null;
        }
        TmsRoad tmsRoad = new TmsRoad();
        tmsRoad.setTmsRoadId(road.getId());
        tmsRoad.setTmsRoadCode(road.getCode() != null ? road.getCode().toUpperCase() : null );
        tmsRoad.setTmsRoadDuration(road.getDuration());
        tmsRoad.setTmsRoadCost(road.getCost());
        tmsRoad.setTmsRoadDistance(road.getDistance());
        tmsRoad.setTmsRoadUpDateDate(road.getUpDateDate());
        tmsRoad.setTmsRoadCreationDate(road.getCreationDate());
        if (!lazy) {
            tmsRoad.setTmsRoadDate(road.getDate());
            tmsRoad.setTmsRoadRoadState(RoadStateMapper.toEntity(road.getState(),true));
            tmsRoad.setTmsRoadSaleOrders(SaleOrderMapper.toEntities(road.getSaleOrders(),true));
            tmsRoad.setTmsRoadStockAddresses(AddressMapper.toEntities(road.getStockAddresses(),true));
            tmsRoad.setTmsRoadVehicle(VehicleMapper.toEntity(road.getVehicle(),true));
            tmsRoad.setTmsRoadCreationUser(UserMapper.toEntity(road.getCreationUser(),true));
            tmsRoad.setTmsRoadDriver(DriverMapper.toEntity(road.getDriver(),true));
            tmsRoad.setTmsRoadAdjunct(DriverMapper.toEntity(road.getAdjunct(),true));

        }
        return tmsRoad;
    }
    public static Road toDto(TmsRoad tmsRoad, boolean lazy){
        if (null == tmsRoad) {
            return null;
        }
        Road road = new Road();
        road.setId(tmsRoad.getTmsRoadId());
        road.setCode(tmsRoad.getTmsRoadCode() != null ? tmsRoad.getTmsRoadCode().toUpperCase() : null );
        road.setDuration(tmsRoad.getTmsRoadDuration());
        road.setCost(tmsRoad.getTmsRoadCost());
        road.setDistance(tmsRoad.getTmsRoadDistance());
        road.setUpDateDate(tmsRoad.getTmsRoadUpDateDate());
        if (!lazy) {
            road.setDate(tmsRoad.getTmsRoadDate());
            road.setState(RoadStateMapper.toDto(tmsRoad.getTmsRoadRoadState(),true));
            road.setSaleOrders(SaleOrderMapper.toDtos(tmsRoad.getTmsRoadSaleOrders(),true));
            road.setStockAddresses(AddressMapper.toDtos(tmsRoad.getTmsRoadStockAddresses(),true));
            road.setVehicle(VehicleMapper.toDto(tmsRoad.getTmsRoadVehicle(),true));
            road.setCreationDate(tmsRoad.getTmsRoadCreationDate());
            road.setCreationUser(UserMapper.toDto(tmsRoad.getTmsRoadCreationUser(),true));
            road.setDriver(DriverMapper.toDto(tmsRoad.getTmsRoadDriver(),true));
            road.setAdjunct(DriverMapper.toDto(tmsRoad.getTmsRoadAdjunct(),true));
        }
        return road;
    }

    public static List<Road>toDtos(List<TmsRoad> tmsRoads, boolean lazy){
        if (null == tmsRoads) {
            return null;
        }
        List<Road>roads = new ArrayList<>();
        for (TmsRoad tmsRoad : tmsRoads) {
            roads.add(toDto(tmsRoad, lazy));
        }
        return roads;
    }

    public static List<Road> toDtos(Iterable<TmsRoad>tmsRoads , boolean lazy){
        if (null == tmsRoads) {
            return null;
        }
        List<Road>roads = new ArrayList<>();
        for (TmsRoad tmsRoad : tmsRoads) {
            roads.add(toDto(tmsRoad, lazy));
        }
        return roads;
    }

    public static Set<TmsRoad> toEntities(Set<Road>roads , boolean lazy){
        if (null == roads) {
            return null;
        }
        Set<TmsRoad> tmsRoads = new HashSet<>();
        for ( Road road:roads) {
            tmsRoads.add(toEntity(road , lazy));
        }
        return tmsRoads;
    }
    public static Set<Road> toDtos(Set<TmsRoad> tmsRoads, boolean lazy){
        if (null == tmsRoads) {
            return null;
        }
        Set<Road>roads = new HashSet<>();
        for ( TmsRoad tmsRoad : tmsRoads) {
            roads.add(toDto(tmsRoad, lazy));
        }
        return roads;
    }

}

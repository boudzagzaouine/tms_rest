package com.sinno.ems.mapper;

import com.sinno.ems.dto.Road;
import com.sinno.ems.entities.TmsRoad;

import java.util.*;

/**
 * Created by bouzi on 3/22/2017.
 */
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
        map.put("incidents", "tmsRoadIncidents");
        map.put("principalDriver", "tmsRoadPrincipalDriver");
        map.put("suppleantDriver", "tmsRoadSuppleantDriver");
        map.put("deliveries", "tmsRoadDeliveries");
        map.put("vehicule", "tmsRoadVehicule");


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

        if (!lazy) {
          tmsRoad.setTmsRoadIncident(IncidentMapper.toEntities(road.getIncidents(),true));
          tmsRoad.setTmsRoadPrincialDriver(DriverMapper.toEntity(road.getPrincipalDriver(),true));
          tmsRoad.setTmsRoadSuppleantDriver(DriverMapper.toEntity(road.getPrincipalDriver(),true));
          //
          tmsRoad.setTmsRoadVehicle(VehicleMapper.toEntity(road.getVehicule(),true));
        }
        return tmsRoad;
    }
    public static Road toDto(TmsRoad tmsRoad, boolean lazy){
        if (null == tmsRoad) {
            return null;
        }
        Road road = new Road();
        road.setId(tmsRoad.getTmsRoadId());
        road.setCode(tmsRoad.getTmsRoadCode());
        road.setDuration(tmsRoad.getTmsRoadDuration());
        road.setCost(tmsRoad.getTmsRoadCost());
        road.setDistance(tmsRoad.getTmsRoadDistance());

        if (!lazy) {
            road.setIncidents(IncidentMapper.toDtos(tmsRoad.getTmsRoadIncident(),true));
            road.setPrincipalDriver(DriverMapper.toDto(tmsRoad.getTmsRoadPrincialDriver(),true));
            road.setSuppleantDriver(DriverMapper.toDto(tmsRoad.getTmsRoadPrincialDriver(),true));
            //
            road.setVehicule(VehicleMapper.toDto(tmsRoad.getTmsRoadVehicle(),true));
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

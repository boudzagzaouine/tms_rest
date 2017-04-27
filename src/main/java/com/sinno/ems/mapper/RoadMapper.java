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

        map.put("id", "prmRoadId");
        map.put("code", "prmRoadCode");
        map.put("duration", "prmRoadDuration");
        map.put("cost", "prmRoadCost");
        map.put("distance", "prmRoadDistance");
        map.put("incidents", "prmRoadIncidents");
        map.put("principalDriver", "prmRoadPrincipalDriver");
        map.put("suppleantDriver", "prmRoadSuppleantDriver");
        map.put("deliveries", "prmRoadDeliveries");
        map.put("vehicule", "prmRoadVehicule");


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
        tmsRoad.setPrmRoadId(road.getId());
        tmsRoad.setPrmRoadCode(road.getCode() != null ? road.getCode().toUpperCase() : null );
        tmsRoad.setPrmRoadDuration(road.getDuration());
        tmsRoad.setPrmRoadCost(road.getCost());
        tmsRoad.setPrmRoadDistance(road.getDistance());

        if (!lazy) {
          tmsRoad.setPrmRoadIncident(IncidentMapper.toEntities(road.getIncidents(),true));
          tmsRoad.setPrmRoadPrincialDriver(DriverMapper.toEntity(road.getPrincipalDriver(),true));
          tmsRoad.setPrmRoadSuppleantDriver(DriverMapper.toEntity(road.getPrincipalDriver(),true));
          //
          tmsRoad.setPrmRoadVehicle(VehicleMapper.toEntity(road.getVehicule(),true));
        }
        return tmsRoad;
    }
    public static Road toDto(TmsRoad tmsRoad, boolean lazy){
        if (null == tmsRoad) {
            return null;
        }
        Road road = new Road();
        road.setId(tmsRoad.getPrmRoadId());
        road.setCode(tmsRoad.getPrmRoadCode());
        road.setDuration(tmsRoad.getPrmRoadDuration());
        road.setCost(tmsRoad.getPrmRoadCost());
        road.setDistance(tmsRoad.getPrmRoadDistance());

        if (!lazy) {
            road.setIncidents(IncidentMapper.toDtos(tmsRoad.getPrmRoadIncident(),true));
            road.setPrincipalDriver(DriverMapper.toDto(tmsRoad.getPrmRoadPrincialDriver(),true));
            road.setSuppleantDriver(DriverMapper.toDto(tmsRoad.getPrmRoadPrincialDriver(),true));
            //
            road.setVehicule(VehicleMapper.toDto(tmsRoad.getPrmRoadVehicle(),true));
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

    public static List<Road> toDtos(Iterable<TmsRoad>prmRoads , boolean lazy){
        if (null == prmRoads) {
            return null;
        }
        List<Road>roads = new ArrayList<>();
        for (TmsRoad tmsRoad : prmRoads) {
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

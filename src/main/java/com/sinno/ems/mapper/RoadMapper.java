package com.sinno.ems.mapper;

import com.sinno.ems.dto.Road;
import com.sinno.ems.entities.PrmRoad;
import org.springframework.security.access.method.P;

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

    public static PrmRoad toEntity(Road road, boolean lazy){
        if (null == road) {
            return null;
        }
        PrmRoad prmRoad = new PrmRoad();
        prmRoad.setPrmRoadId(road.getId());
        prmRoad.setPrmRoadCode(road.getCode() != null ? road.getCode().toUpperCase() : null );
        prmRoad.setPrmRoadDuration(road.getDuration());
        prmRoad.setPrmRoadCost(road.getCost());
        prmRoad.setPrmRoadDistance(road.getDistance());
        prmRoad.setPrmRoadIncident(road.getIncidents());
        prmRoad.setPrmRoadPrincialDriver(road.getPrincipalDriver());
        prmRoad.setPrmRoadSuppleantDriver(road.getSuppleantDriver());
        if (!lazy) {
          //
            //
        }
        return prmRoad;
    }
    public static Road toDto(PrmRoad prmRoad , boolean lazy){
        if (null == prmRoad) {
            return null;
        }
        Road road = new Road();
        road.setId(prmRoad.getPrmRoadId());
        road.setCode(prmRoad.getPrmRoadCode());
        road.setDuration(prmRoad.getPrmRoadDuration());
        road.setCost(prmRoad.getPrmRoadCost());
        road.setDistance(prmRoad.getPrmRoadDistance());
        road.setIncidents(prmRoad.getPrmRoadIncident());
        road.setPrincipalDriver(prmRoad.getPrmRoadPrincialDriver());
        road.setSuppleantDriver(prmRoad.getPrmRoadSuppleantDriver());
        if (!lazy) {
            //
            //
        }
        return road;
    }

    public static List<Road>toDtos(List<PrmRoad> prmRoads , boolean lazy){
        if (null == prmRoads) {
            return null;
        }
        List<Road>roads = new ArrayList<>();
        for (PrmRoad prmRoad : prmRoads) {
            roads.add(toDto(prmRoad , lazy));
        }
        return roads;
    }

    public static List<Road> toDtos(Iterable<PrmRoad>prmRoads , boolean lazy){
        if (null == prmRoads) {
            return null;
        }
        List<Road>roads = new ArrayList<>();
        for (PrmRoad prmRoad : prmRoads) {
            roads.add(toDto(prmRoad , lazy));
        }
        return roads;
    }

    public static Set<PrmRoad> toEntities(Set<Road>roads , boolean lazy){
        if (null == roads) {
            return null;
        }
        Set<PrmRoad>prmRoads = new HashSet<>();
        for ( Road road:roads) {
            prmRoads.add(toEntity(road , lazy));
        }
        return prmRoads;
    }
    public static Set<Road> toDtos(Set<PrmRoad>prmRoads , boolean lazy){
        if (null == prmRoads) {
            return null;
        }
        Set<Road>roads = new HashSet<>();
        for ( PrmRoad prmRoad : prmRoads) {
            roads.add(toDto(prmRoad , lazy));
        }
        return roads;
    }

}

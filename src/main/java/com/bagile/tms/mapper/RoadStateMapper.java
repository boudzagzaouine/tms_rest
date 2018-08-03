package com.bagile.tms.mapper;

import com.bagile.tms.dto.Category;
import com.bagile.tms.dto.Road;
import com.bagile.tms.dto.RoadState;
import com.bagile.tms.dto.Traffic;
import com.bagile.tms.entities.TmsCategory;
import com.bagile.tms.entities.TmsRoad;
import com.bagile.tms.entities.TmsRoadState;
import com.bagile.tms.entities.TmsTraffic;

import java.util.*;

public class RoadStateMapper {
    private RoadStateMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsRoadStateId");
        map.put("state", "tmsRoadState");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static TmsRoadState toEntity(RoadState roadState, boolean lazy) {
        if (null == roadState) {
            return null;
        }
        TmsRoadState tmsRoadState = new TmsRoadState();

        tmsRoadState.setTmsRoadStateId(roadState.getId());
        tmsRoadState.setTmsRoadStateState(roadState.getState());

        return tmsRoadState;
    }

    public static RoadState toDto(TmsRoadState tmsRoadState, boolean lazy) {
        if (null == tmsRoadState) {
            return null;
        }
        RoadState roadState = new RoadState();

        roadState.setId(tmsRoadState.getTmsRoadStateId());
        roadState.setState(tmsRoadState.getTmsRoadStateState());

        return roadState;
    }

    public static List<RoadState> toDtos(List<TmsRoadState> tmsRoadStates, boolean lazy) {
        if (null == tmsRoadStates) {
            return null;
        }
        List<RoadState> roadStates = new ArrayList<>();
        for (TmsRoadState tmsRoadState : tmsRoadStates) {
            roadStates.add(toDto(tmsRoadState, lazy));
        }
        return roadStates;
    }

    public static List<RoadState> toDtos(Iterable<TmsRoadState> tmsRoadStates, boolean lazy) {
        if (null == tmsRoadStates) {
            return null;
        }
        List<RoadState> roadStates = new ArrayList<>();
        for (TmsRoadState tmsRoadState : tmsRoadStates) {
            roadStates.add(toDto(tmsRoadState, lazy));
        }
        return roadStates;
    }

    public static Set<TmsRoadState> toEntities(Set<RoadState> roadStates, boolean lazy) {
        if (null == roadStates) {
            return null;
        }
        Set<TmsRoadState> TmsRoadStates = new HashSet<>();
        for (RoadState roadState : roadStates) {
            TmsRoadStates.add(toEntity(roadState, lazy));
        }
        return TmsRoadStates;
    }

    public static Set<RoadState> toDtos(Set<TmsRoadState> TmsRoadStates, boolean lazy) {
        if (null == TmsRoadStates) {
            return null;
        }
        Set<RoadState> roadStates = new HashSet<>();
        for (TmsRoadState tmsRoadState : TmsRoadStates) {
            roadStates.add(toDto(tmsRoadState, lazy));
        }
        return roadStates;
    }
}
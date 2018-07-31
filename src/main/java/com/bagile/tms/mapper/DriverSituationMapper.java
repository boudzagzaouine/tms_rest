package com.bagile.tms.mapper;

import com.bagile.tms.dto.DriverSituation;

import java.util.*;

/**
 * Created by khalil on 23/03/2017.
 */
public class DriverSituationMapper {
    private DriverSituationMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsDriverId");
        map.put("code", "tmsDriverSituationCode");
        map.put("description", "tmsDriverSituationDescription");
    }

    public static Map<String, String> getMap() {
        return map;
    }


    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsDriverSituation toEntity(DriverSituation driversituation, boolean lazy) {
        if (null == driversituation) {
            return null;
        }
        TmsDriverSituation tmsDriverSituation = new TmsDriverSituation();
        tmsDriverSituation.setTmsDriverId(driversituation.getId());
        tmsDriverSituation.setTmsDriverSituationDescription(driversituation.getDescription());
        tmsDriverSituation.setTmsDriverSituationCode(driversituation.getCode());
        if (!lazy) {
        tmsDriverSituation.setTmsDrivers(DriverMapper.toEntities(driversituation.getDrivers(),true));
        }
        return tmsDriverSituation;
    }

    public static DriverSituation toDto(TmsDriverSituation tmsDriverSituation, boolean lazy) {
        if (null == tmsDriverSituation) {
            return null;
        }
        DriverSituation driverSituation = new DriverSituation();
        driverSituation.setId(tmsDriverSituation.getTmsDriverId());
        driverSituation.setCode(tmsDriverSituation.getTmsDriverSituationCode());
        driverSituation.setDescription(tmsDriverSituation.getTmsDriverSituationDescription());
        if(!lazy){
        driverSituation.setDrivers(DriverMapper.toDtos(tmsDriverSituation.getTmsDrivers(),true));
        }
        return driverSituation;
    }
    public static List<DriverSituation> toDtos(List<TmsDriverSituation> tmsDriverSituations, boolean lazy) {
        if (null == tmsDriverSituations) {
            return null;
        }
        List<DriverSituation> driverSituations = new ArrayList<>();
        for (TmsDriverSituation tmsColor : tmsDriverSituations) {
            driverSituations.add(toDto(tmsColor, lazy));
        }
        return driverSituations;
    }

    public static List<DriverSituation> toDtos(Iterable<TmsDriverSituation> tmsDriverSituations, boolean lazy) {
        if (null == tmsDriverSituations) {
            return null;
        }
        List<DriverSituation> colors = new ArrayList<>();
        for (TmsDriverSituation tmsDriverSituation : tmsDriverSituations) {
            colors.add(toDto(tmsDriverSituation, lazy));
        }
        return colors;
    }
    public static Set<TmsDriverSituation> toEntities(Set<DriverSituation> driverSituations, boolean lazy) {
        if (null == driverSituations) {
            return null;
        }
        Set<TmsDriverSituation> tmsDriverSituations = new HashSet<>();
        for (DriverSituation driverSituation : driverSituations) {
            tmsDriverSituations.add(toEntity(driverSituation, lazy));
        }
        return tmsDriverSituations;
    }
    public static Set<DriverSituation> toDtos(Set<TmsDriverSituation> tmsDriverSituations, boolean lazy) {
        if (null == tmsDriverSituations) {
            return null;
        }
        Set<DriverSituation> driverSituations = new HashSet<>();
        for (TmsDriverSituation tmsColor : tmsDriverSituations) {
            driverSituations.add(toDto(tmsColor, lazy));
        }
        return driverSituations;
    }
}

package com.sinno.ems.mapper;

import com.sinno.ems.dto.DriverSituation;
import com.sinno.ems.entities.TmsDriverSituation;

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
        map.put("id", "prmDriverId");
        map.put("code", "prmDriverSituationCode");
        map.put("description", "prmDriverSituationDescription");
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
        tmsDriverSituation.setPrmDriverId(driversituation.getId());
        tmsDriverSituation.setPrmDriverSituationDescription(driversituation.getDescription());
        tmsDriverSituation.setPrmDriverSituationCode(driversituation.getCode());
        if (!lazy) {

        }
        return tmsDriverSituation;
    }

    public static DriverSituation toDto(TmsDriverSituation tmsDriverSituation, boolean lazy) {
        if (null == tmsDriverSituation) {
            return null;
        }
        DriverSituation driverSituation = new DriverSituation();
        driverSituation.setId(tmsDriverSituation.getPrmDriverId());
        driverSituation.setCode(tmsDriverSituation.getPrmDriverSituationCode());
        driverSituation.setDescription(tmsDriverSituation.getPrmDriverSituationDescription());
        if(!lazy){

        }
        return driverSituation;
    }
    public static List<DriverSituation> toDtos(List<TmsDriverSituation> tmsDriverSituations, boolean lazy) {
        if (null == tmsDriverSituations) {
            return null;
        }
        List<DriverSituation> driverSituations = new ArrayList<>();
        for (TmsDriverSituation prmColor : tmsDriverSituations) {
            driverSituations.add(toDto(prmColor, lazy));
        }
        return driverSituations;
    }

    public static List<DriverSituation> toDtos(Iterable<TmsDriverSituation> prmDriverSituations, boolean lazy) {
        if (null == prmDriverSituations) {
            return null;
        }
        List<DriverSituation> colors = new ArrayList<>();
        for (TmsDriverSituation tmsDriverSituation : prmDriverSituations) {
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
        for (TmsDriverSituation prmColor : tmsDriverSituations) {
            driverSituations.add(toDto(prmColor, lazy));
        }
        return driverSituations;
    }
}

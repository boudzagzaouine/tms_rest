package com.sinno.ems.mapper;

import com.sinno.ems.dto.DriverSituation;
import com.sinno.ems.entities.PrmDriverSituation;

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

    public static PrmDriverSituation toEntity(DriverSituation driversituation, boolean lazy) {
        if (null == driversituation) {
            return null;
        }
        PrmDriverSituation prmDriverSituation = new PrmDriverSituation();
        prmDriverSituation.setPrmDriverId(driversituation.getId());
        prmDriverSituation.setPrmDriverSituationDescription(driversituation.getDescription());
        prmDriverSituation.setPrmDriverSituationCode(driversituation.getCode());
        if (!lazy) {

        }
        return prmDriverSituation;
    }

    public static DriverSituation toDto(PrmDriverSituation prmDriverSituation, boolean lazy) {
        if (null == prmDriverSituation) {
            return null;
        }
        DriverSituation driverSituation = new DriverSituation();
        driverSituation.setId(prmDriverSituation.getPrmDriverId());
        driverSituation.setCode(prmDriverSituation.getPrmDriverSituationCode());
        driverSituation.setDescription(prmDriverSituation.getPrmDriverSituationDescription());
        if(!lazy){

        }
        return driverSituation;
    }
    public static List<DriverSituation> toDtos(List<PrmDriverSituation> prmDriverSituations, boolean lazy) {
        if (null == prmDriverSituations) {
            return null;
        }
        List<DriverSituation> driverSituations = new ArrayList<>();
        for (PrmDriverSituation prmColor : prmDriverSituations) {
            driverSituations.add(toDto(prmColor, lazy));
        }
        return driverSituations;
    }

    public static List<DriverSituation> toDtos(Iterable<PrmDriverSituation> prmDriverSituations, boolean lazy) {
        if (null == prmDriverSituations) {
            return null;
        }
        List<DriverSituation> colors = new ArrayList<>();
        for (PrmDriverSituation prmDriverSituation : prmDriverSituations) {
            colors.add(toDto(prmDriverSituation, lazy));
        }
        return colors;
    }
    public static Set<PrmDriverSituation> toEntities(Set<DriverSituation> driverSituations, boolean lazy) {
        if (null == driverSituations) {
            return null;
        }
        Set<PrmDriverSituation>  prmDriverSituations= new HashSet<>();
        for (DriverSituation driverSituation : driverSituations) {
            prmDriverSituations.add(toEntity(driverSituation, lazy));
        }
        return prmDriverSituations;
    }
    public static Set<DriverSituation> toDtos(Set<PrmDriverSituation> prmDriverSituations, boolean lazy) {
        if (null == prmDriverSituations) {
            return null;
        }
        Set<DriverSituation> driverSituations = new HashSet<>();
        for (PrmDriverSituation prmColor : prmDriverSituations) {
            driverSituations.add(toDto(prmColor, lazy));
        }
        return driverSituations;
    }
}

package com.sinno.ems.mapper;

import com.sinno.ems.dto.Incident;
import com.sinno.ems.entities.TmsIncident;

import java.util.*;

/**
 * Created by khalil on 22/03/2017.
 */
public class IncidentMapper {
    private IncidentMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmIncidentId");
        map.put("code", "prmIncidentCode");
        map.put("time", "prmIncidentTime");
        map.put("description", "prmIncidentDescription");
        map.put("nature", "prmIncidentNature");
        map.put("road", "prmRoad");
        map.put("driver", "prmDriver");
    }

    public static Map<String, String> getMap() {
        return map;
    }


    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsIncident toEntity(Incident incident, boolean lazy) {
        if (null == incident) {
            return null;
        }
        TmsIncident tmsIncident = new TmsIncident();
        tmsIncident.setPrmIncidentId(incident.getId());
        tmsIncident.setPrmIncidentCode(incident.getCode());
        tmsIncident.setPrmIncidentTime(incident.getDateTime());
        tmsIncident.setPrmIncidentDescription(incident.getDescription());
        if (!lazy) {
            tmsIncident.setPrmIncidentNature(NatureIncidentMapper.toEntity(incident.getNatureIncident(),true));
            tmsIncident.setPrmIncidentRoad(RoadMapper.toEntity(incident.getRoad() , true));
            tmsIncident.setPrmIncidentDriver(DriverMapper.toEntity(incident.getDriver() , true));
        }
        return tmsIncident;
    }

    public static Incident toDto(TmsIncident tmsIncident, boolean lazy) {
        if (null == tmsIncident) {
            return null;
        }
        Incident incident = new Incident();
        incident.setId(tmsIncident.getPrmIncidentId());
        incident.setCode(tmsIncident.getPrmIncidentCode());
        incident.setDateTime(tmsIncident.getPrmIncidentTime());
        incident.setDescription(tmsIncident.getPrmIncidentDescription());
        if (!lazy) {
            incident.setNatureIncident(NatureIncidentMapper.toDto(tmsIncident.getPrmIncidentNature(),true));
            incident.setRoad(RoadMapper.toDto( tmsIncident.getPrmIncidentRoad(), true));
            incident.setDriver(DriverMapper.toDto(tmsIncident.getPrmIncidentDriver() , true));
        }
        return incident;
    }
    public static List<Incident> toDtos(List<TmsIncident> tmsIncidents, boolean lazy) {
        if (null == tmsIncidents) {
            return null;
        }
        List<Incident> incidents = new ArrayList<>();
        for (TmsIncident tmsIncident : tmsIncidents) {
            incidents.add(toDto(tmsIncident, lazy));
        }
        return incidents;
    }
    public static List<Incident> toDtos(Iterable<TmsIncident> prmIncidents, boolean lazy) {
        if (null == prmIncidents) {
            return null;
        }
        List<Incident> incidents = new ArrayList<>();
        for (TmsIncident tmsIncident : prmIncidents) {
           incidents.add(toDto(tmsIncident, lazy));
        }
        return incidents;
    }
    public static Set<TmsIncident> toEntities(Set<Incident> incidents, boolean lazy) {
        if (null == incidents) {
            return null;
        }
        Set<TmsIncident> tmsIncidents = new HashSet<>();
        for (Incident incident : incidents) {
            tmsIncidents.add(toEntity(incident, lazy));
        }
        return tmsIncidents;
    }
    public static Set<Incident> toDtos(Set<TmsIncident> tmsIncidents, boolean lazy) {
        if (null == tmsIncidents) {
            return null;
        }
        Set<Incident> incidents = new HashSet<>();
        for (TmsIncident prmColor : tmsIncidents) {
            incidents.add(toDto(prmColor, lazy));
        }
        return incidents;
    }
}

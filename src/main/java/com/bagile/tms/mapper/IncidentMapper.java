package com.bagile.tms.mapper;

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
        map.put("id", "tmsIncidentId");
        map.put("code", "tmsIncidentCode");
        map.put("time", "tmsIncidentTime");
        map.put("description", "tmsIncidentDescription");
        map.put("nature", "tmsIncidentNature");
        map.put("road", "tmsIncidentRoad");
        map.put("driver", "tmsIncidentDriver");
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
        tmsIncident.setTmsIncidentId(incident.getId());
        tmsIncident.setTmsIncidentCode(incident.getCode());
        tmsIncident.setTmsIncidentTime(incident.getDateTime());
        tmsIncident.setTmsIncidentDescription(incident.getDescription());
        if (!lazy) {
            tmsIncident.setTmsIncidentNature(NatureIncidentMapper.toEntity(incident.getNatureIncident(),true));
            tmsIncident.setTmsIncidentRoad(RoadMapper.toEntity(incident.getRoad() , true));
            tmsIncident.setTmsIncidentDriver(DriverMapper.toEntity(incident.getDriver() , true));
        }
        return tmsIncident;
    }

    public static Incident toDto(TmsIncident tmsIncident, boolean lazy) {
        if (null == tmsIncident) {
            return null;
        }
        Incident incident = new Incident();
        incident.setId(tmsIncident.getTmsIncidentId());
        incident.setCode(tmsIncident.getTmsIncidentCode());
        incident.setDateTime(tmsIncident.getTmsIncidentTime());
        incident.setDescription(tmsIncident.getTmsIncidentDescription());
        if (!lazy) {
            incident.setNatureIncident(NatureIncidentMapper.toDto(tmsIncident.getTmsIncidentNature(),true));
            incident.setRoad(RoadMapper.toDto( tmsIncident.getTmsIncidentRoad(), true));
            incident.setDriver(DriverMapper.toDto(tmsIncident.getTmsIncidentDriver() , true));
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
    public static List<Incident> toDtos(Iterable<TmsIncident> tmsIncidents, boolean lazy) {
        if (null == tmsIncidents) {
            return null;
        }
        List<Incident> incidents = new ArrayList<>();
        for (TmsIncident tmsIncident : tmsIncidents) {
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
        for (TmsIncident tmsColor : tmsIncidents) {
            incidents.add(toDto(tmsColor, lazy));
        }
        return incidents;
    }
}

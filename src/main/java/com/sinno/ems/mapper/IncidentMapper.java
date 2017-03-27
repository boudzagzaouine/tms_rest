package com.sinno.ems.mapper;

import com.sinno.ems.dto.Incident;
import com.sinno.ems.entities.PrmIncident;
import com.sinno.ems.entities.PrmRoad;

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

    public static PrmIncident toEntity(Incident incident, boolean lazy) {
        if (null == incident) {
            return null;
        }
        PrmIncident prmIncident = new PrmIncident();
        prmIncident.setPrmIncidentId(incident.getId());
        prmIncident.setPrmIncidentCode(incident.getCode());
        prmIncident.setPrmIncidentTime(incident.getDateTime());
        prmIncident.setPrmIncidentDescription(incident.getDescription());
        if (!lazy) {
            prmIncident.setPrmIncidentNature(NatureIncidentMapper.toEntity(incident.getNatureIncident(),true));
            prmIncident.setPrmRoad(RoadMapper.toEntity(incident.getRoad() , true));
            prmIncident.setPrmDriver(DriverMapper.toEntity(incident.getDriver() , true));
        }
        return prmIncident;
    }

    public static Incident toDto(PrmIncident prmIncident, boolean lazy) {
        if (null == prmIncident) {
            return null;
        }
        Incident incident = new Incident();
        incident.setId(prmIncident.getPrmIncidentId());
        incident.setCode(prmIncident.getPrmIncidentCode());
        incident.setDateTime(prmIncident.getPrmIncidentTime());
        incident.setDescription(prmIncident.getPrmIncidentDescription());
        if (!lazy) {
            incident.setNatureIncident(NatureIncidentMapper.toDto(prmIncident.getPrmIncidentNature(),true));
            incident.setRoad(RoadMapper.toDto( prmIncident.getPrmRoad(), true));
            incident.setDriver(DriverMapper.toDto(prmIncident.getPrmDriver() , true));
        }
        return incident;
    }
    public static List<Incident> toDtos(List<PrmIncident> prmIncidents, boolean lazy) {
        if (null == prmIncidents) {
            return null;
        }
        List<Incident> incidents = new ArrayList<>();
        for (PrmIncident prmIncident : prmIncidents) {
            incidents.add(toDto(prmIncident, lazy));
        }
        return incidents;
    }
    public static List<Incident> toDtos(Iterable<PrmIncident> prmIncidents, boolean lazy) {
        if (null == prmIncidents) {
            return null;
        }
        List<Incident> incidents = new ArrayList<>();
        for (PrmIncident prmIncident : prmIncidents) {
           incidents.add(toDto(prmIncident, lazy));
        }
        return incidents;
    }
    public static Set<PrmIncident> toEntities(Set<Incident> incidents, boolean lazy) {
        if (null == incidents) {
            return null;
        }
        Set<PrmIncident> prmIncidents = new HashSet<>();
        for (Incident incident : incidents) {
            prmIncidents.add(toEntity(incident, lazy));
        }
        return prmIncidents;
    }
    public static Set<Incident> toDtos(Set<PrmIncident> prmIncidents, boolean lazy) {
        if (null == prmIncidents) {
            return null;
        }
        Set<Incident> incidents = new HashSet<>();
        for (PrmIncident prmColor : prmIncidents) {
            incidents.add(toDto(prmColor, lazy));
        }
        return incidents;
    }
}

package com.sinno.ems.mapper;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sinno.ems.dto.NatureIncident;
import com.sinno.ems.entities.AsrPoliceInsurance;
import com.sinno.ems.entities.IncNatureIncident;

import java.util.*;

/**
 * Created by bouzi on 3/22/2017.
 */
public class NatureIncidentMapper {

    public NatureIncidentMapper() {
    }
    private static Map<String,String> map;
    static {
        map = new HashMap<>();

        map.put("id", "incNatureIncientId");
        map.put("code", "incNatureIncientCode");
        map.put("description", "incNatureIncientDescription");
        map.put("incident", "incidents");
    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }
    public static IncNatureIncident toEntity(NatureIncident natureIncident , boolean lazy){
        if (null == natureIncident) {
            return null;
        }
        IncNatureIncident incNatureIncident = new IncNatureIncident();
        incNatureIncident.setIncNatureIncidentId(natureIncident.getId());
        incNatureIncident.setIncNatureIncidentCode(natureIncident.getCode() !=null ? natureIncident.getCode().toUpperCase(): null);
        incNatureIncident.setIncNatureIncidentDescription(natureIncident.getDescription());
        if (!lazy) {
           incNatureIncident.setIncidents(IncidentMapper.toEntities(natureIncident.getIncidents(),true));
//
        }
        return incNatureIncident;
    }
    public static NatureIncident toDto(IncNatureIncident incNatureIncident , boolean lazy){
        if (null == incNatureIncident) {
            return null;
        }
        NatureIncident natureIncident = new NatureIncident();
        natureIncident.setId(incNatureIncident.getIncNatureIncidentId());
        natureIncident.setCode(incNatureIncident.getIncNatureIncidentCode());
        natureIncident.setDescription(incNatureIncident.getIncNatureIncidentDescription());
        if (!lazy) {
            natureIncident.setIncidents(IncidentMapper.toDtos(incNatureIncident.getIncidents(),true));
//
        }
        return natureIncident;
    }
    public static List<NatureIncident>toDtos(List<IncNatureIncident>incNatureIncidents,boolean lazy){
        if (null == incNatureIncidents) {
            return null;
        }
        List<NatureIncident>natureIncidents = new ArrayList<>();
        for (IncNatureIncident incNatureIncident : incNatureIncidents) {
            natureIncidents.add(toDto(incNatureIncident , lazy));
        }
        return natureIncidents;
    }

    public static List<NatureIncident> toDtos(Iterable<IncNatureIncident>incNatureIncidents , boolean lazy){
        if (null == incNatureIncidents) {
            return null;
        }
        List<NatureIncident> natureIncidents= new ArrayList<>();
        for (IncNatureIncident incNatureIncident : incNatureIncidents) {
            natureIncidents.add(toDto(incNatureIncident,lazy));
        }
        return natureIncidents;
    }
    public static Set<IncNatureIncident>toEntities(Set<NatureIncident>natureIncidents, boolean lazy){
        if (null == natureIncidents) {
            return null;
        }
        Set<IncNatureIncident> incNatureIncidents = new HashSet<>();
        for ( NatureIncident natureIncident : natureIncidents) {
            incNatureIncidents.add(toEntity(natureIncident,lazy));
        }
        return incNatureIncidents;
    }
    public static Set<NatureIncident>toDtos(Set<IncNatureIncident>incNatureIncidents , boolean lazy){
        if (null == incNatureIncidents) {
            return null;
        }
        Set<NatureIncident>natureIncidents = new HashSet<>();

        for (IncNatureIncident incNatureIncident: incNatureIncidents) {
            natureIncidents.add(toDto(incNatureIncident , lazy));
        }
        return natureIncidents;
    }
}

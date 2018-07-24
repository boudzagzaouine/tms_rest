package com.bagile.tms.mapper;

import com.sinno.ems.dto.NatureIncident;
import com.sinno.ems.entities.TmsNatureIncident;

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

        map.put("id", "tmsNatureIncidentId");
        map.put("code", "tmsNatureIncidentCode");
        map.put("description", "tmsNatureIncidentDescription");
    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }
    public static TmsNatureIncident toEntity(NatureIncident natureIncident , boolean lazy){
        if (null == natureIncident) {
            return null;
        }
        TmsNatureIncident tmsNatureIncident = new TmsNatureIncident();
        tmsNatureIncident.setIncNatureIncidentId(natureIncident.getId());
        tmsNatureIncident.setIncNatureIncidentCode(natureIncident.getCode() !=null ? natureIncident.getCode().toUpperCase(): null);
        tmsNatureIncident.setIncNatureIncidentDescription(natureIncident.getDescription());
        if (!lazy) {
           tmsNatureIncident.setIncidents(IncidentMapper.toEntities(natureIncident.getIncidents(),true));
//
        }
        return tmsNatureIncident;
    }
    public static NatureIncident toDto(TmsNatureIncident tmsNatureIncident, boolean lazy){
        if (null == tmsNatureIncident) {
            return null;
        }
        NatureIncident natureIncident = new NatureIncident();
        natureIncident.setId(tmsNatureIncident.getIncNatureIncidentId());
        natureIncident.setCode(tmsNatureIncident.getIncNatureIncidentCode());
        natureIncident.setDescription(tmsNatureIncident.getIncNatureIncidentDescription());
        if (!lazy) {
            natureIncident.setIncidents(IncidentMapper.toDtos(tmsNatureIncident.getIncidents(),true));
//
        }
        return natureIncident;
    }
    public static List<NatureIncident>toDtos(List<TmsNatureIncident> tmsNatureIncidents, boolean lazy){
        if (null == tmsNatureIncidents) {
            return null;
        }
        List<NatureIncident>natureIncidents = new ArrayList<>();
        for (TmsNatureIncident tmsNatureIncident : tmsNatureIncidents) {
            natureIncidents.add(toDto(tmsNatureIncident, lazy));
        }
        return natureIncidents;
    }

    public static List<NatureIncident> toDtos(Iterable<TmsNatureIncident>tmsNatureIncidents , boolean lazy){
        if (null == tmsNatureIncidents) {
            return null;
        }
        List<NatureIncident> natureIncidents= new ArrayList<>();
        for (TmsNatureIncident tmsNatureIncident : tmsNatureIncidents) {
            natureIncidents.add(toDto(tmsNatureIncident,lazy));
        }
        return natureIncidents;
    }
    public static Set<TmsNatureIncident>toEntities(Set<NatureIncident>natureIncidents, boolean lazy){
        if (null == natureIncidents) {
            return null;
        }
        Set<TmsNatureIncident> tmsNatureIncidents = new HashSet<>();
        for ( NatureIncident natureIncident : natureIncidents) {
            tmsNatureIncidents.add(toEntity(natureIncident,lazy));
        }
        return tmsNatureIncidents;
    }
    public static Set<NatureIncident>toDtos(Set<TmsNatureIncident> tmsNatureIncidents, boolean lazy){
        if (null == tmsNatureIncidents) {
            return null;
        }
        Set<NatureIncident>natureIncidents = new HashSet<>();

        for (TmsNatureIncident tmsNatureIncident : tmsNatureIncidents) {
            natureIncidents.add(toDto(tmsNatureIncident, lazy));
        }
        return natureIncidents;
    }
}

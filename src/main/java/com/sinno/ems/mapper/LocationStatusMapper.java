package com.sinno.ems.mapper;

import com.sinno.ems.dto.LocationStatus;
import com.sinno.ems.entities.PrmLocationStatus;

import java.util.*;

/**
 * Created by Enissay on 03/05/2016.
 */
public class LocationStatusMapper {
    private LocationStatusMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmLocationStatusId");
        map.put("code", "prmLocationStatusCode");
        map.put("description", "prmLocationStatusDescription");
        map.put("organisation", "orgOrganisation");
    }


    public static Map<String, String> getMap() {
        return map;
    }


    public static String getField(String key) {
        return map.get(key);
    }

    public static LocationStatus toDto(PrmLocationStatus prmLocationStatus, boolean lazy) {
        if (null == prmLocationStatus) {
            return null;
        }
        LocationStatus locationStatus = new LocationStatus();
        locationStatus.setId(prmLocationStatus.getPrmLocationStatusId());
        locationStatus.setCode(prmLocationStatus.getPrmLocationStatusCode());
        locationStatus.setDescription(prmLocationStatus.getPrmLocationStatusDescription());
        if (!lazy) {
            locationStatus.setOrganisation(OrganisationMapper.toDto(prmLocationStatus.getOrgOrganisation(), true));
        }
        return locationStatus;

    }

    public static PrmLocationStatus toEntity(LocationStatus locationStatus, boolean lazy) {
        if (null == locationStatus) {
            return null;
        }
        PrmLocationStatus prmLocationStatus = new PrmLocationStatus();
        prmLocationStatus.setPrmLocationStatusId(locationStatus.getId());
        prmLocationStatus.setPrmLocationStatusCode(locationStatus.getCode() != null ? locationStatus.getCode().toUpperCase() : null);
        prmLocationStatus.setPrmLocationStatusDescription(locationStatus.getDescription());
        if (!lazy) {
            prmLocationStatus.setOrgOrganisation(OrganisationMapper.toEntity(locationStatus.getOrganisation(), true));
        }
        return prmLocationStatus;

    }

    public static List<LocationStatus> toDtos(List<PrmLocationStatus> prmLocationStatuses, boolean lazy) {
        if (null == prmLocationStatuses) {
            return null;
        }
        List<LocationStatus> locationStatuses = new ArrayList<>();
        for (PrmLocationStatus prmLocationStatus : prmLocationStatuses) {
            locationStatuses.add(toDto(prmLocationStatus, lazy));
        }
        return locationStatuses;
    }

    public static List<LocationStatus> toDtos(Iterable<PrmLocationStatus> prmLocationStatuts, boolean lazy) {
        if (null == prmLocationStatuts) {
            return null;
        }
        List<LocationStatus> locationStatuses = new ArrayList<>();
        for (PrmLocationStatus prmLocationStatus : prmLocationStatuts) {
            locationStatuses.add(toDto(prmLocationStatus, lazy));
        }
        return locationStatuses;
    }

    public static Set<PrmLocationStatus> toEntities(Set<LocationStatus> locationStatuses, boolean lazy) {
        if (null == locationStatuses) {
            return null;
        }
        Set<PrmLocationStatus> locLocations = new HashSet<>();
        for (LocationStatus locationStatus : locationStatuses) {
            locLocations.add(toEntity(locationStatus, lazy));
        }
        return locLocations;
    }

    public static Set<LocationStatus> toDtos(Set<PrmLocationStatus> prmLocationStatuses, boolean lazy) {
        if (null == prmLocationStatuses) {
            return null;
        }
        Set<LocationStatus> locationStatuses = new HashSet<>();
        for (PrmLocationStatus prmLocationStatus : prmLocationStatuses) {
            locationStatuses.add(toDto(prmLocationStatus, lazy));
        }
        return locationStatuses;
    }
}


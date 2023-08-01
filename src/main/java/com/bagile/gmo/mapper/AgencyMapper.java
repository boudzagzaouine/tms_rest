package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Agency;
import com.bagile.gmo.entities.UsrAgency;

import java.util.*;

public class AgencyMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "usrAgencyId");
        map.put("code", "usrAgencyCode");
        map.put("description", "usrAgencyDescription");
        map.put("zone", "usrAgencyZone");
        map.put("responsable", "usrAgencyResponsable");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public AgencyMapper() {
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static UsrAgency toEntity(Agency agency, boolean lazy) {
        if (null == agency) {
            return null;
        }
        UsrAgency usrAgency = new UsrAgency();
        usrAgency.setUsrAgencyId(agency.getId());
        usrAgency.setUsrAgencyCode(agency.getCode() != null ? agency.getCode().toUpperCase() : null);
        usrAgency.setUsrAgencyDescription(agency.getDescription());
        usrAgency.setCreatedBy(agency.getCreatedBy());
        usrAgency.setUpdatedBy(agency.getUpdatedBy());
        usrAgency.setCreationDate(agency.getCreationDate());
        usrAgency.setUpdateDate(agency.getUpdateDate());

        if (!lazy) {
            usrAgency.setAdrAddress(AddressMapper.toEntity(agency.getAddress(), true));
            usrAgency.setUsrAgencyZone(ZoneMapper.toEntity(agency.getZone(), true));
            usrAgency.setUsrAgencyResponsable(UserMapper.toEntity(agency.getResponsable(), true));
        }

        return usrAgency;

    }

    public static Agency toDto(UsrAgency usrAgency, boolean lazy) {
        if (null == usrAgency) {
            return null;
        }
        Agency agency = new Agency();
        agency.setId(usrAgency.getUsrAgencyId());
        agency.setCode(usrAgency.getUsrAgencyCode());
        agency.setDescription(usrAgency.getUsrAgencyDescription());

        if (!lazy) {
            agency.setAddress(AddressMapper.toDto(usrAgency.getAdrAddress(), true));
            agency.setZone(ZoneMapper.toDto(usrAgency.getUsrAgencyZone(), true));
            agency.setResponsable(UserMapper.toDto(usrAgency.getUsrAgencyResponsable(), true));
        }
        return agency;

    }


    public static List<Agency> toDtos(Iterable<? extends UsrAgency> usrAgencys, boolean lazy) {
        if (null == usrAgencys) {
            return null;
        }
        List<Agency> vehicules = new ArrayList<>();

        for (UsrAgency usrAgency : usrAgencys) {
            vehicules.add(toDto(usrAgency, lazy));
        }
        return vehicules;
    }

    public static Set<UsrAgency> toEntities(Set<Agency> agencys, boolean lazy) {
        if (null == agencys) {
            return null;
        }
        Set<UsrAgency> usrAgencys = new HashSet<>();
        for (Agency agency : agencys) {
            usrAgencys.add(toEntity(agency, lazy));
        }
        return usrAgencys;
    }

    public static Set<Agency> toDtos(Set<UsrAgency> usrAgencys, boolean lazy) {
        if (null == usrAgencys) {
            return null;
        }
        Set<Agency> agencys = new HashSet<>();
        for (UsrAgency usrAgency : usrAgencys) {
            agencys.add(toDto(usrAgency, lazy));
        }
        return agencys;
    }
}

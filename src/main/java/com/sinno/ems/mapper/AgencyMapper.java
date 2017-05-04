package com.sinno.ems.mapper;

import com.sinno.ems.dto.Agency;
import com.sinno.ems.entities.UsrAgency;

import java.util.*;

/**
 * Created by Enissay on 02/01/2017.
 */
public class AgencyMapper {
    private AgencyMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","usrAgencyId");
        map.put("code","usrAgencyCode");
        map.put("description","usrAgencyDescription");
        map.put("creationDate","usrAgencyCreationDate");
        map.put("updateDate","usrAgencyUpdateDate");
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Agency toDto(UsrAgency usrAgency, boolean lazy) {
        if (null == usrAgency) {
            return null;
        }
        Agency agency = new Agency();
        agency.setId(usrAgency.getUsrAgencyId());
        agency.setCode(usrAgency.getUsrAgencyCode());
        agency.setDescription(usrAgency.getUsrAgencyDescription());
        agency.setCreationDate(usrAgency.getUsrAgencyCreationDate());
        agency.setUpdateDate(usrAgency.getUsrAgencyUpdateDate());
        if (!lazy) {
        }
        return agency;
    }





    public static UsrAgency toEntity(Agency agency, boolean lazy) {
        if (null == agency) {
            return null;
        }
        UsrAgency usrAgency = new UsrAgency();
        usrAgency.setUsrAgencyId(agency.getId());
        usrAgency.setUsrAgencyCode(agency.getCode()!=null?agency.getCode().toUpperCase():null);
        usrAgency.setUsrAgencyDescription(agency.getDescription());
        usrAgency.setUsrAgencyCreationDate(agency.getCreationDate());
        usrAgency.setUsrAgencyUpdateDate(agency.getUpdateDate());

        return usrAgency;
    }

    public static List<Agency> toDtos(List<UsrAgency> usrAgencies, boolean lazy) {
        if (null == usrAgencies) {
            return null;
        }
        List<Agency> agencys = new ArrayList<>();
        for (UsrAgency usrAgency : usrAgencies) {
            agencys.add(toDto(usrAgency, lazy));
        }
        return agencys;
    }

    public static List<Agency> toDtos(Iterable<UsrAgency> usrAgencies, boolean lazy) {
        if (null == usrAgencies) {
            return null;
        }
        List<Agency> agencys = new ArrayList<>();
        for (UsrAgency usrAgency : usrAgencies) {
            agencys.add(toDto(usrAgency, lazy));
        }
        return agencys;
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

    public static Set<UsrAgency> toEntities(Set<Agency> agencies, boolean lazy) {
        if (null == agencies) {
            return null;
        }
        Set<UsrAgency> usrAgencys = new HashSet<>();
        for (Agency agency : agencies) {
            usrAgencys.add(toEntity(agency, lazy));
        }
        return usrAgencys;
    }
}

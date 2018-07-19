package com.bagile.tms.mapper;


import com.bagile.tms.dto.Agency;
import com.bagile.tms.entities.UsrAgency;

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
        Agency uom = new Agency();
        uom.setId(usrAgency.getUsrAgencyId());
        uom.setCode(usrAgency.getUsrAgencyCode());
        uom.setDescription(usrAgency.getUsrAgencyDescription());
        uom.setCreationDate(usrAgency.getUsrAgencyCreationDate());
        uom.setUpdateDate(usrAgency.getUsrAgencyUpdateDate());
        if (!lazy) {
        }
        return uom;
    }





    public static UsrAgency toEntity(Agency uom, boolean lazy) {
        if (null == uom) {
            return null;
        }
        UsrAgency usrAgency = new UsrAgency();
        usrAgency.setUsrAgencyId(uom.getId());
        usrAgency.setUsrAgencyCode(uom.getCode()!=null?uom.getCode().toUpperCase():null);
        usrAgency.setUsrAgencyDescription(uom.getDescription());
        usrAgency.setUsrAgencyCreationDate(uom.getCreationDate());
        usrAgency.setUsrAgencyUpdateDate(uom.getUpdateDate());
        if (!lazy) {
        }
        return usrAgency;
    }

    public static List<Agency> toDtos(List<UsrAgency> usrAgencies, boolean lazy) {
        if (null == usrAgencies) {
            return null;
        }
        List<Agency> uoms = new ArrayList<>();
        for (UsrAgency usrAgency : usrAgencies) {
            uoms.add(toDto(usrAgency, lazy));
        }
        return uoms;
    }

    public static List<Agency> toDtos(Iterable<UsrAgency> usrAgencies, boolean lazy) {
        if (null == usrAgencies) {
            return null;
        }
        List<Agency> uoms = new ArrayList<>();
        for (UsrAgency usrAgency : usrAgencies) {
            uoms.add(toDto(usrAgency, lazy));
        }
        return uoms;
    }

    public static Set<Agency> toDtos(Set<UsrAgency> usrAgencys, boolean lazy) {
        if (null == usrAgencys) {
            return null;
        }
        Set<Agency> uoms = new HashSet<>();
        for (UsrAgency usrAgency : usrAgencys) {
            uoms.add(toDto(usrAgency, lazy));
        }
        return uoms;
    }

    public static Set<UsrAgency> toEntities(Set<Agency> agencies, boolean lazy) {
        if (null == agencies) {
            return null;
        }
        Set<UsrAgency> usrAgencys = new HashSet<>();
        for (Agency uom : agencies) {
            usrAgencys.add(toEntity(uom, lazy));
        }
        return usrAgencys;
    }
}

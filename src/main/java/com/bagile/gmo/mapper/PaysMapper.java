/**
 *
 */
package com.bagile.gmo.mapper;


import com.bagile.gmo.dto.Pays;
import com.bagile.gmo.entities.PrmPays;

import java.util.*;


public class PaysMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmPaysId");
        map.put("code", "prmPaysCode");
        map.put("description", "prmPaysDescription");
        map.put("creationDate", "prmPaysCreationDate");
        map.put("updateDate","prmPaysUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Pays toDto(PrmPays prmPays, boolean lazy) {
        if (null == prmPays) {
            return null;
        }
        Pays pays = new Pays();
        pays.setId(prmPays.getPrmPaysId());
        pays.setCode(prmPays.getPrmPaysCode() !=null ? prmPays.getPrmPaysCode().toUpperCase():null);
        pays.setDescription(prmPays.getPrmPaysDescription());
        pays.setCreationDate(prmPays.getPrmPaysCreationDate());
        pays.setUpdateDate(prmPays.getPrmPaysUpdateDate());
        pays.setUpdatedBy(prmPays.getUpdatedBy());
        pays.setCreatedBy(prmPays.getCreatedBy());
        return pays;
    }

    public static PrmPays toEntity(Pays pays, boolean lazy) {
        if (null == pays) {
            return null;
        }
        PrmPays prmPays = new PrmPays();
        prmPays.setPrmPaysId(pays.getId());
        prmPays.setPrmPaysCode(pays.getCode());
        prmPays.setPrmPaysDescription(pays.getDescription());
        prmPays.setPrmPaysCreationDate(pays.getCreationDate());
        prmPays.setPrmPaysUpdateDate(pays.getUpdateDate());
        prmPays.setUpdatedBy(pays.getUpdatedBy());
        prmPays.setCreatedBy(pays.getCreatedBy());
        return prmPays;
    }

    public static List<Pays> toDtos(List<PrmPays> prmPayss, boolean lazy) {
        if (null == prmPayss) {
            return null;
        }
        List<Pays> payses = new ArrayList<>();
        for (PrmPays prmPays : prmPayss) {
            payses.add(toDto(prmPays, lazy));
        }
        return payses;
    }

    public static List<Pays> toDtos(Iterable<PrmPays> prmPayss, boolean lazy) {
        if (null == prmPayss) {
            return null;
        }
        List<Pays> payses = new ArrayList<>();
        for (PrmPays prmPays : prmPayss) {
            payses.add(toDto(prmPays, lazy));
        }
        return payses;
    }

    public static Set<PrmPays> toEntities(Set<Pays> payses, boolean lazy) {
        if (null == payses) {
            return null;
        }
        Set<PrmPays> prmPayss = new HashSet<>();
        for (Pays pays : payses) {
            prmPayss.add(toEntity(pays, lazy));
        }
        return prmPayss;
    }

    public static Set<Pays> toDtos(Set<PrmPays> prmPayss, boolean lazy) {
        if (null == prmPayss) {
            return null;
        }
        Set<Pays> payses = new HashSet<>();
        for (PrmPays prmPays : prmPayss) {
            payses.add(toDto(prmPays, lazy));
        }
        return payses;
    }
}

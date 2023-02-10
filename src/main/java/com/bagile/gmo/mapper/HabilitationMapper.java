package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Habilitation;
import com.bagile.gmo.entities.UsrHabilitation;

import java.util.*;

public class HabilitationMapper {
    private HabilitationMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "usrHabilitationId");
        map.put("code", "usrHabilitationCode");
        map.put("description", "usrHabilitationDescription");
        map.put("habilitation", "usrHabilitationParent");
        map.put("active", "usrHabilitationActive");
        map.put("labelFR", "usrHabilitationLabelFR");
        map.put("labelEN", "usrHabilitationLabelEN");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static UsrHabilitation toEntity(Habilitation habilitation, boolean lazy) {
        if (null == habilitation) {
            return null;
        }
        UsrHabilitation usrHabilitation = new UsrHabilitation();
        usrHabilitation.setUsrHabilitationId(habilitation.getId());
        usrHabilitation.setUsrHabilitationCode(habilitation.getCode() != null ? habilitation.getCode().toUpperCase() : null);
        usrHabilitation.setUsrHabilitationDescription(habilitation.getDescription());

       // usrHabilitation.setAuthority(habilitation.getAuthority());
        usrHabilitation.setUsrHabilitationActive(habilitation.getActive());
        usrHabilitation.setUsrHabilitationLabelFR(habilitation.getLabelFR());
        usrHabilitation.setUsrHabilitationLabelEN(habilitation.getLabelEN());



        usrHabilitation.setCreatedBy(habilitation.getCreatedBy());
        usrHabilitation.setUpdatedBy(habilitation.getUpdatedBy());
        usrHabilitation.setCreationDate(habilitation.getCreationDate());
        usrHabilitation.setUpdateDate(habilitation.getUpdateDate());

        if (!lazy) {
            usrHabilitation.setUsrHabilitationParent(toEntity(habilitation.getHabilitation(), true));
            usrHabilitation.setUsrHabilitations(toEntities(habilitation.getHabilitations(), true));
        }
        return usrHabilitation;
    }

    public static Habilitation toDto(UsrHabilitation usrHabilitation, boolean lazy) {
        if (null == usrHabilitation) {
            return null;
        }
        Habilitation habilitation = new Habilitation();
        habilitation.setId(usrHabilitation.getUsrHabilitationId());
        habilitation.setCode(usrHabilitation.getUsrHabilitationCode());
        habilitation.setDescription(usrHabilitation.getUsrHabilitationDescription());
       // habilitation.setAuthority(usrHabilitation.getAuthority());
        habilitation.setActive(usrHabilitation.getUsrHabilitationActive());
        habilitation.setLabelEN(usrHabilitation.getUsrHabilitationLabelEN());
        habilitation.setLabelFR(usrHabilitation.getUsrHabilitationLabelFR());

        habilitation.setCreatedBy(usrHabilitation.getCreatedBy());
        habilitation.setUpdatedBy(usrHabilitation.getUpdatedBy());
        habilitation.setCreationDate(usrHabilitation.getCreationDate());
        habilitation.setUpdateDate(usrHabilitation.getUpdateDate());
        if (!lazy) {
            habilitation.setHabilitation(toDto(usrHabilitation.getUsrHabilitationParent(), true));
            habilitation.setHabilitations(toDtos(usrHabilitation.getUsrHabilitations(), true));
        }
        return habilitation;
    }


    public static List<Habilitation> toDtos(Iterable<? extends UsrHabilitation> usrHabilitations, boolean lazy) {
        if (null == usrHabilitations) {
            return null;
        }
        List<Habilitation> habilitations = new ArrayList<>();
        for (UsrHabilitation usrHabilitation : usrHabilitations) {
            habilitations.add(toDto(usrHabilitation, lazy));
        }
        return habilitations;
    }

    public static Set<UsrHabilitation> toEntities(Set<? extends Habilitation> habilitations, boolean lazy) {
        if (null == habilitations) {
            return null;
        }
        Set<UsrHabilitation> usrHabilitations = new HashSet<>();
        for (Habilitation habilitation : habilitations) {
            usrHabilitations.add(toEntity(habilitation, lazy));
        }
        return usrHabilitations;
    }

    public static Set<Habilitation> toDtos(Set<? extends UsrHabilitation> usrHabilitations, boolean lazy) {
        if (null == usrHabilitations) {
            return null;
        }
        Set<Habilitation> habilitations = new HashSet<>();
        for (UsrHabilitation usrHabilitation : usrHabilitations) {
            habilitations.add(toDto(usrHabilitation, lazy));
        }
        return habilitations;
    }
}

/**
 *
 */
package com.bagile.gmo.mapper;


import com.bagile.gmo.dto.Ville;
import com.bagile.gmo.entities.PrmVille;

import java.util.*;


public class VilleMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmVilleId");
        map.put("code", "prmVilleCode");
        map.put("description", "prmVilleDescription");
        map.put("creationDate", "prmVilleCreationDate");
        map.put("updateDate","prmVilleUpdateDate");
        map.put("pays","prmPays");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Ville toDto(PrmVille prmVille, boolean lazy) {
        if (null == prmVille) {
            return null;
        }
        Ville ville = new Ville();
        ville.setId(prmVille.getPrmVilleId());
        ville.setCode(prmVille.getPrmVilleCode() !=null ? prmVille.getPrmVilleCode().toUpperCase():null);
        ville.setDescription(prmVille.getPrmVilleDescription());
        ville.setCreationDate(prmVille.getPrmVilleCreationDate());
        ville.setUpdateDate(prmVille.getPrmVilleUpdateDate());
        ville.setUpdatedBy(prmVille.getUpdatedBy());
        ville.setCreatedBy(prmVille.getCreatedBy());
        if(!lazy){
            ville.setPays(PaysMapper.toDto(prmVille.getPrmPays(),true));
        }
        return ville;
    }

    public static PrmVille toEntity(Ville ville, boolean lazy) {
        if (null == ville) {
            return null;
        }
        PrmVille prmVille = new PrmVille();
        prmVille.setPrmVilleId(ville.getId());
        prmVille.setPrmVilleCode(ville.getCode());
        prmVille.setPrmVilleDescription(ville.getDescription());
        prmVille.setPrmVilleCreationDate(ville.getCreationDate());
        prmVille.setPrmVilleUpdateDate(ville.getUpdateDate());
        prmVille.setUpdatedBy(ville.getUpdatedBy());
        prmVille.setCreatedBy(ville.getCreatedBy());
        if(!lazy)
        {
            prmVille.setPrmPays(PaysMapper.toEntity(ville.getPays(),true));
        }
        return prmVille;
    }

    public static List<Ville> toDtos(List<PrmVille> prmVilles, boolean lazy) {
        if (null == prmVilles) {
            return null;
        }
        List<Ville> villes = new ArrayList<>();
        for (PrmVille prmVille : prmVilles) {
            villes.add(toDto(prmVille, lazy));
        }
        return villes;
    }

    public static List<Ville> toDtos(Iterable<PrmVille> prmVilles, boolean lazy) {
        if (null == prmVilles) {
            return null;
        }
        List<Ville> villes = new ArrayList<>();
        for (PrmVille prmVille : prmVilles) {
            villes.add(toDto(prmVille, lazy));
        }
        return villes;
    }

    public static Set<PrmVille> toEntities(Set<Ville> villes, boolean lazy) {
        if (null == villes) {
            return null;
        }
        Set<PrmVille> prmVilles = new HashSet<>();
        for (Ville ville : villes) {
            prmVilles.add(toEntity(ville, lazy));
        }
        return prmVilles;
    }

    public static Set<Ville> toDtos(Set<PrmVille> prmVilles, boolean lazy) {
        if (null == prmVilles) {
            return null;
        }
        Set<Ville> villes = new HashSet<>();
        for (PrmVille prmVille : prmVilles) {
            villes.add(toDto(prmVille, lazy));
        }
        return villes;
    }
}

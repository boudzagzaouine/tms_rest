package com.sinno.ems.mapper;

import com.sinno.ems.dto.Edi;
import com.sinno.ems.entities.PrmEdi;

import java.util.*;

public class EdiMapper {
    private EdiMapper(){}

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","prmEdiId");
        map.put("code","prmEdiCode");
        map.put("description","prmEdiDescription");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmEdi toEntity(Edi edi, boolean lazy) {
        if (null == edi) {
            return null;
        }
        PrmEdi prmEdi = new PrmEdi();
        prmEdi.setPrmEdiId(edi.getId());
        prmEdi.setPrmEdiCode(edi.getCode());
        prmEdi.setPrmEdiDescription(edi.getDescription());
        return prmEdi;
    }

    public static Edi toDto(PrmEdi prmEdi, boolean lazy) {
        if (null == prmEdi) {
            return null;
        }
        Edi edi = new Edi();
        edi.setId(prmEdi.getPrmEdiId());
        edi.setCode(prmEdi.getPrmEdiCode());
        edi.setDescription(prmEdi.getPrmEdiDescription());
        return edi;
    }

    public static List<Edi> toDtos(List<PrmEdi> prmEdis, boolean lazy) {
        if (null == prmEdis) {
            return null;
        }
        List<Edi> edis = new ArrayList<>();
        for (PrmEdi prmEdi : prmEdis) {
            edis.add(toDto(prmEdi, lazy));
        }
        return edis;
    }

    public static List<Edi> toDtos(Iterable<PrmEdi> prmEdis, boolean lazy) {
        if (null == prmEdis) {
            return null;
        }
        List<Edi> edis = new ArrayList<>();
        for (PrmEdi prmEdi : prmEdis) {
            edis.add(toDto(prmEdi, lazy));
        }
        return edis;
    }

    public static Set<PrmEdi> toEntities(Set<Edi> edis, boolean lazy) {
        if (null == edis) {
            return null;
        }
        Set<PrmEdi> prmEdis = new HashSet<>();
        for (Edi edi : edis) {
            prmEdis.add(toEntity(edi, lazy));
        }
        return prmEdis;
    }

    public static Set<Edi> toDtos(Set<PrmEdi> prmEdis, boolean lazy) {
        if (null == prmEdis) {
            return null;
        }
        Set<Edi> edis = new HashSet<>();
        for (PrmEdi prmEdi : prmEdis) {
            edis.add(toDto(prmEdi, lazy));
        }
        return edis;
    }
}

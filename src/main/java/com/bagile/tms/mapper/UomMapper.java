package com.bagile.tms.mapper;

import com.bagile.tms.dto.Uom;
import com.bagile.tms.entities.PdtUom;

import java.util.*;

public class UomMapper {
    private UomMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","pdtUomId");
        map.put("owner","ownOwner");
        map.put("code","pdtUomCode");
        map.put("description","pdtUomDescription");
        map.put("creationDate","pdtUomCreationDate");
        map.put("updateDate","pdtUomUpdateDate");
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Uom toDto(PdtUom pdtUom, boolean lazy) {
        if (null == pdtUom) {
            return null;
        }
        Uom uom = new Uom();
        uom.setId(pdtUom.getPdtUomId());
        uom.setCode(pdtUom.getPdtUomCode());
        uom.setDescription(pdtUom.getPdtUomDescription());
        uom.setCreationDate(pdtUom.getPdtUomCreationDate());
        uom.setUpdateDate(pdtUom.getPdtUomUpdateDate());
        if (!lazy) {
            uom.setOwner(OwnerMapper.toDto(pdtUom.getOwnOwner(), true));
        }
        return uom;
    }

    public static void replace(Uom uom,Uom uom2) {
        uom.setId(uom2.getId());
        uom.setCode(uom2.getCode());
        uom.setDescription(uom2.getDescription());
        uom.setOwner(uom2.getOwner());
        uom.setCreationDate(uom2.getCreationDate());
        uom.setUpdateDate(uom2.getUpdateDate());

    }



    public static PdtUom toEntity(Uom uom, boolean lazy) {
        if (null == uom) {
            return null;
        }
        PdtUom pdtUom = new PdtUom();
        pdtUom.setPdtUomId(uom.getId());
        pdtUom.setPdtUomCode(uom.getCode()!=null?uom.getCode().toUpperCase():null);
        pdtUom.setPdtUomDescription(uom.getDescription());
        pdtUom.setPdtUomCreationDate(uom.getCreationDate());
        pdtUom.setPdtUomUpdateDate(uom.getUpdateDate());
        if (!lazy) {
            pdtUom.setOwnOwner(OwnerMapper.toEntity(uom.getOwner(), true));
        }
        return pdtUom;
    }

    public static List<Uom> toDtos(List<PdtUom> pdtUoms, boolean lazy) {
        if (null == pdtUoms) {
            return null;
        }
        List<Uom> uoms = new ArrayList<>();
        for (PdtUom pdtUom : pdtUoms) {
            uoms.add(toDto(pdtUom, lazy));
        }
        return uoms;
    }

    public static List<Uom> toDtos(Iterable<PdtUom> pdtUoms, boolean lazy) {
        if (null == pdtUoms) {
            return null;
        }
        List<Uom> uoms = new ArrayList<>();
        for (PdtUom pdtUom : pdtUoms) {
            uoms.add(toDto(pdtUom, lazy));
        }
        return uoms;
    }

    public static Set<Uom> toDtos(Set<PdtUom> pdtUoms, boolean lazy) {
        if (null == pdtUoms) {
            return null;
        }
        Set<Uom> uoms = new HashSet<>();
        for (PdtUom pdtUom : pdtUoms) {
            uoms.add(toDto(pdtUom, lazy));
        }
        return uoms;
    }

    public static Set<PdtUom> toEntities(Set<Uom> uoms, boolean lazy) {
        if (null == uoms) {
            return null;
        }
        Set<PdtUom> pdtUoms = new HashSet<>();
        for (Uom uom : uoms) {
            pdtUoms.add(toEntity(uom, lazy));
        }
        return pdtUoms;
    }
}

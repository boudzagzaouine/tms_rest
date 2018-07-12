package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by ASMAE on 28/04/2016.
 */
public class BarCodeMapper {
    private BarCodeMapper(){

    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "prmBarCodeId");
        map.put("name", "prmBarCodeName");
        map.put("suffixe", "prmBarCodeSuffixe");
        map.put("creationDate", "prmBarCodeCreationDate");
        map.put("updateDate", "prmBarCodeUpdateDate");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmBarCode toEntity(BarCode barCode, boolean lazy) {
        if (null == barCode) {
            return null;
        }
        PrmBarCode prmBarCode = new PrmBarCode();
        prmBarCode.setPrmBarCodeId(barCode.getId());
        prmBarCode.setPrmBarCodeName(barCode.getName());
        prmBarCode.setPrmBarCodeSuffixe(barCode.getSuffixe());
        prmBarCode.setPrmBarCodeCreationDate(barCode.getCreationDate());
        prmBarCode.setPrmBarCodeUpdateDate(barCode.getUpdateDate());
        return prmBarCode;
    }

    public static BarCode toDto(PrmBarCode prmBarCode, boolean lazy) {
        if (null == prmBarCode) {
            return null;
        }
        BarCode barCode = new BarCode();
        barCode.setId(prmBarCode.getPrmBarCodeId());
        barCode.setName(prmBarCode.getPrmBarCodeName());
        barCode.setSuffixe(prmBarCode.getPrmBarCodeSuffixe());
        barCode.setCreationDate(prmBarCode.getPrmBarCodeCreationDate());
        barCode.setUpdateDate(prmBarCode.getPrmBarCodeUpdateDate());
        return barCode;
    }

    public static List<BarCode> toDtos(List<PrmBarCode> prmBarCodes, boolean lazy) {
        if (null == prmBarCodes) {
            return null;
        }
        List<BarCode> barCodes = new ArrayList<>();
        for (PrmBarCode prmBarCode : prmBarCodes) {
            barCodes.add(toDto(prmBarCode, lazy));
        }
        return barCodes;
    }

    public static List<BarCode> toDtos(Iterable<PrmBarCode> prmBarCodes, boolean lazy) {
        if (null == prmBarCodes) {
            return null;
        }
        List<BarCode> barCodes = new ArrayList<>();
        for (PrmBarCode prmBarCode : prmBarCodes) {
            barCodes.add(toDto(prmBarCode, lazy));
        }
        return barCodes;
    }

    public static Set<PrmBarCode> toEntities(Set<BarCode> barCodes, boolean lazy) {
        if (null == barCodes) {
            return null;
        }
        Set<PrmBarCode> prmBarCodes = new HashSet<>();
        for (BarCode barCode : barCodes) {
            prmBarCodes.add(toEntity(barCode, lazy));
        }
        return prmBarCodes;
    }

    public static Set<BarCode> toDtos(Set<PrmBarCode> prmBarCodes, boolean lazy) {
        if (null == prmBarCodes) {
            return null;
        }
        Set<BarCode> barCodes = new HashSet<>();
        for (PrmBarCode prmBarCode : prmBarCodes) {
            barCodes.add(toDto(prmBarCode, lazy));
        }
        return barCodes;
    }
}

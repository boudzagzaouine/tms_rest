package com.sinno.ems.mapper;

import com.sinno.ems.dto.Vat;
import com.sinno.ems.dto.Vat;
import com.sinno.ems.entities.PrmVat;
import com.sinno.ems.entities.PrmVat;

import java.util.*;

/**
 * Created by Enissay on 22/12/2016.
 */
public class VatMapper {
    private VatMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmVatId");
        map.put("value", "prmVatValue");
        map.put("creationDate", "prmVatCreationDate");
        map.put("updateDate", "prmVatUpdateDate");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmVat toEntity(Vat vat, boolean lazy) {
        if (null == vat) {
            return null;
        }
        PrmVat prmVat = new PrmVat();
        prmVat.setPrmVatId(vat.getId());
        prmVat.setPrmVatValue(vat.getValue());
        prmVat.setPrmVatCreationDate(vat.getCreationDate());
        prmVat.setPrmVatUpdateDate(vat.getUpdateDate());
        return prmVat;
    }
    public static Vat toDto(PrmVat prmVat, boolean lazy) {
        if (null == prmVat) {
            return null;
        }
        Vat vat=new Vat();
        vat.setId(prmVat.getPrmVatId());
        vat.setValue(prmVat.getPrmVatValue());
        vat.setCreationDate(prmVat.getPrmVatCreationDate());
        vat.setUpdateDate(prmVat.getPrmVatUpdateDate());
        return vat;
    }
    public static List<Vat> toDtos(List<PrmVat> usrVats, boolean lazy) {
        if (null == usrVats) {
            return null;
        }
        List<Vat> vats = new ArrayList<>();
        for (PrmVat usrVat : usrVats) {
            vats.add(toDto(usrVat, lazy));
        }
        return vats;
    }

    public static List<Vat> toDtos(Iterable<PrmVat> usrVats, boolean lazy) {
        if (null == usrVats) {
            return null;
        }
        List<Vat> vats = new ArrayList<>();
        for (PrmVat usrVat : usrVats) {
            vats.add(toDto(usrVat, lazy));
        }
        return vats;
    }

    public static Set<PrmVat> toEntities(Set<Vat> vats, boolean lazy) {
        if (null == vats) {
            return null;
        }
        Set<PrmVat> usrVats = new HashSet<>();
        for (Vat vat : vats) {
            usrVats.add(toEntity(vat, lazy));
        }
        return usrVats;
    }

    public static Set<Vat> toDtos(Set<PrmVat> usrVats, boolean lazy) {
        if (null == usrVats) {
            return null;
        }
        Set<Vat> vats = new HashSet<>();
        for (PrmVat usrVat : usrVats) {
            vats.add(toDto(usrVat, lazy));
        }
        return vats;
    }
}
    

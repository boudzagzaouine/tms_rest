package com.bagile.tms.mapper;

import com.bagile.tms.dto.Vat;
import com.bagile.tms.entities.PrmVat;

import java.util.*;

public class VatMapper {
    public VatMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "prmId");
        map.put ("value", "prmValue");
       
        
        map.put ("creationDate", "creationDate");
        map.put ("updateDate", "updateDate");
        map.put ("createdBy", "createdBy");
        map.put ("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get (key);
    }

    public static PrmVat toEntity(Vat vat, boolean lazy) {
        if (null == vat) {
            return null;
        }

        PrmVat prmVat = new PrmVat ( );
        prmVat.setPrmVatId (vat.getId ( ));
        prmVat.setPrmVatValue (vat.getValue ( ));
        prmVat.setCreatedBy (vat.getCreatedBy ( ));
        prmVat.setUpdatedBy (vat.getUpdatedBy ( ));

        if (!lazy) {
            //prmVat.setTmsBadgeType (BadgeTypeMapper.toEntity (vat.getBadgeType ( ), true));
        }

        return prmVat;

    }

    public static Vat toDto(PrmVat prmVat, boolean lazy) {
        if (null == prmVat) {
            return null;
        }
        Vat vat = new Vat ( );
        vat.setId ((int) prmVat.getPrmVatId ());
        vat.setValue (prmVat.getPrmVatValue ());

        vat.setCreatedBy (prmVat.getCreatedBy ());
        vat.setUpdatedBy (prmVat.getUpdatedBy ());
        vat.setCreationDate (prmVat.getCreationDate ());
        vat.setUpdateDate (prmVat.getUpdateDate ());

        if (!lazy) {
            //vat.setBadgeType (BadgeTypeMapper.toDto (prmVat.getTmsBadgeType(), true));
        }
        return vat;

    }


    public static List<Vat> toDtos(Iterable<? extends PrmVat> prmVats, boolean lazy) {
        if (null == prmVats) {
            return null;
        }
        List<Vat> vehicules = new ArrayList<> ( );

        for (PrmVat prmVat : prmVats) {
            vehicules.add (toDto (prmVat, lazy));
        }
        return vehicules;
    }

    public static Set<PrmVat> toEntities(Set<Vat> vats, boolean lazy) {
        if (null == vats) {
            return null;
        }
        Set<PrmVat> prmVats = new HashSet<> ( );
        for (Vat vat : vats) {
            prmVats.add (toEntity (vat, lazy));
        }
        return prmVats;
    }

    public static Set<Vat> toDtos(Set<PrmVat> prmVats, boolean lazy) {
        if (null == prmVats) {
            return null;
        }
        Set<Vat> vats = new HashSet<> ( );
        for (PrmVat prmVat : prmVats) {
            vats.add (toDto (prmVat, lazy));
        }
        return vats;
    }
}

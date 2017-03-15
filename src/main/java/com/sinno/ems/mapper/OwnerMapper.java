package com.sinno.ems.mapper;

import com.sinno.ems.dto.Owner;
import com.sinno.ems.entities.OwnOwner;

import java.util.*;

public class OwnerMapper {
    private OwnerMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "ownOwnerId");
        map.put("code", "ownOwnerCode");
        map.put("description", "ownOwnerDescription");
        map.put("siret", "ownOwnerSiret");
        map.put("comment", "ownOwnerComment");
        map.put("active", "ownOwnerIsActive");
        map.put("creationDate", "ownOwnerCreationDate");
        map.put("updateDate", "ownOwnerUpdateDate");
        map.put("variable1", "ownOwnerVariable1");
        map.put("variable2", "ownOwnerVariable2");
        map.put("variable3", "ownOwnerVariable3");
        map.put("variable4", "ownOwnerVariable4");
        map.put("variable5", "ownOwnerVariable5");
        map.put("variable6", "ownOwnerVariable6");
        map.put("variable7", "ownOwnerVariable7");
        map.put("variable8", "ownOwnerVariable8");
        map.put("variable9", "ownOwnerVariable9");
        map.put("variable10", "ownOwnerVariable10");
        map.put("invoiceType", "ownOwnerTypeInvoice");
        map.put("invoiceTerm", "ownOwnerInvoiceTerm");
        map.put("relevantVat", "ownOwnerRelevantVat");
        map.put("vat", "ownOwnerVat");
        map.put("currency", "ownOwnerCurrency");
        map.put("organisation", "orgOrganisation");
        map.put("address", "adrAddress");
        map.put("contact", "prmContact");
        map.put("name", "ownOwnerName");
        map.put("surname", "ownOwnerSurname");
        map.put("firstInvoiceDate", "ownOwnerFirstInvoiceDate");
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static OwnOwner toEntity(Owner owner, boolean lazy) {
        if (null == owner) {
            return null;
        }
        OwnOwner ownOwner = new OwnOwner();


        if (!lazy) {
        }

        return ownOwner;
    }

    public static Owner toDto(OwnOwner ownOwner, boolean lazy) {
        if (null == ownOwner) {
            return null;
        }
        Owner owner = new Owner();


        if (!lazy) {

        }

        return owner;
    }

    public static List<Owner> toDtos(List<OwnOwner> ownOwners, boolean lazy) {
        if (null == ownOwners) {
            return null;
        }
        List<Owner> owners = new ArrayList<>();
        for (OwnOwner ownOwner : ownOwners) {
            owners.add(toDto(ownOwner, lazy));
        }
        return owners;
    }

    public static List<Owner> toDtos(Iterable<OwnOwner> ownOwners, boolean lazy) {
        if (null == ownOwners) {
            return null;
        }
        List<Owner> owners = new ArrayList<>();
        for (OwnOwner ownOwner : ownOwners) {
            owners.add(toDto(ownOwner, lazy));
        }
        return owners;
    }

    public static Set<OwnOwner> toEntities(Set<Owner> owners, boolean lazy) {
        if (null == owners) {
            return null;
        }
        Set<OwnOwner> ownOwners = new HashSet<>();
        for (Owner owner : owners) {
            ownOwners.add(toEntity(owner, lazy));
        }
        return ownOwners;
    }

    public static Set<Owner> toDtos(Set<OwnOwner> ownOwners, boolean lazy) {
        if (null == ownOwners) {
            return null;
        }
        Set<Owner> owners = new HashSet<>();
        for (OwnOwner ownOwner : ownOwners) {
            owners.add(toDto(ownOwner, lazy));
        }
        return owners;
    }
}

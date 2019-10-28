package com.bagile.tms.mapper;

import com.bagile.tms.dto.Owner;
import com.bagile.tms.entities.OwnOwner;

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
       // map.put("organisation", "orgOrganisation");
     //   map.put("address", "adrAddress");
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

        ownOwner.setOwnOwnerId(owner.getId());
        ownOwner.setOwnOwnerCode(owner.getCode() != null ? owner.getCode().toUpperCase() : null);
        ownOwner.setOwnOwnerName(owner.getName());
        ownOwner.setOwnOwnerSurname(owner.getSurname());
        ownOwner.setOwnOwnerEmail(owner.getEmail());
        ownOwner.setOwnOwnerPrimaryTel(owner.getPrimaryTel());
        ownOwner.setOwnOwnerSecondaryTel(owner.getSecondaryTel());
        ownOwner.setOwnOwnerDescription(owner.getDescription());
        ownOwner.setOwnOwnerSiret(owner.getSiret());
        ownOwner.setOwnOwnerComment(owner.getComment());
        ownOwner.setOwnOwnerIsActive(owner.getActive());
        ownOwner.setOwnOwnerCreationDate(owner.getCreationDate());
        ownOwner.setOwnOwnerUpdateDate(owner.getUpdateDate());
        ownOwner.setOwnOwnerVariable1(owner.getVariable1());
        ownOwner.setOwnOwnerVariable2(owner.getVariable2());
        ownOwner.setOwnOwnerVariable3(owner.getVariable3());
        ownOwner.setOwnOwnerVariable4(owner.getVariable4());
        ownOwner.setOwnOwnerVariable5(owner.getVariable5());
        ownOwner.setOwnOwnerVariable6(owner.getVariable6());
        ownOwner.setOwnOwnerVariable7(owner.getVariable7());
        ownOwner.setOwnOwnerVariable8(owner.getVariable8());
        ownOwner.setOwnOwnerVariable9(owner.getVariable9());
        ownOwner.setOwnOwnerVariable10(owner.getVariable10());

        ownOwner.setOwnOwnerImage(owner.getImage());

        if (!lazy) {
          //  ownOwner.setOrgOrganisation(OrganisationMapper.toEntity(owner.getOrganisation(), true));
          //  ownOwner.setAdrAddress(AddressMapper.toEntity(owner.getAddress(), true));
        }

        return ownOwner;
    }

    public static Owner toDto(OwnOwner ownOwner, boolean lazy) {
        if (null == ownOwner) {
            return null;
        }
        Owner owner = new Owner();

        owner.setId(ownOwner.getOwnOwnerId());
        owner.setCode(ownOwner.getOwnOwnerCode());
        owner.setName(ownOwner.getOwnOwnerName());
        owner.setSurname(ownOwner.getOwnOwnerSurname());
        owner.setEmail(ownOwner.getOwnOwnerEmail());
        owner.setPrimaryTel(ownOwner.getOwnOwnerPrimaryTel());
        owner.setSecondaryTel(ownOwner.getOwnOwnerSecondaryTel());
        owner.setDescription(ownOwner.getOwnOwnerDescription());
        owner.setSiret(ownOwner.getOwnOwnerSiret());
        owner.setComment(ownOwner.getOwnOwnerComment());
        owner.setActive(ownOwner.getOwnOwnerIsActive());
        owner.setCreationDate(ownOwner.getOwnOwnerCreationDate());
        owner.setUpdateDate(ownOwner.getOwnOwnerUpdateDate());
        owner.setVariable1(ownOwner.getOwnOwnerVariable1());
        owner.setVariable2(ownOwner.getOwnOwnerVariable2());
        owner.setVariable3(ownOwner.getOwnOwnerVariable3());
        owner.setVariable4(ownOwner.getOwnOwnerVariable4());
        owner.setVariable5(ownOwner.getOwnOwnerVariable5());
        owner.setVariable6(ownOwner.getOwnOwnerVariable6());
        owner.setVariable7(ownOwner.getOwnOwnerVariable7());
        owner.setVariable8(ownOwner.getOwnOwnerVariable8());
        owner.setVariable9(ownOwner.getOwnOwnerVariable9());
        owner.setVariable10(ownOwner.getOwnOwnerVariable10());
        owner.setImage(ownOwner.getOwnOwnerImage());


        if (!lazy) {
          //  owner.setAddress(AddressMapper.toDto(ownOwner.getAdrAddress(), true));
           // owner.setOrganisation(OrganisationMapper.toDto(ownOwner.getOrgOrganisation(), true));

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

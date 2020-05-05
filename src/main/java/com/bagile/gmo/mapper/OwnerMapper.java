package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Owner;
import com.bagile.gmo.entities.OwnOwner;

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



        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");

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
        ownOwner.setCreationDate(owner.getCreationDate());
        ownOwner.setUpdateDate(owner.getUpdateDate());
        ownOwner.setOwnOwnerImage(owner.getImage());
        ownOwner.setCreatedBy(owner.getCreatedBy());
        ownOwner.setUpdatedBy(owner.getUpdatedBy());
        ownOwner.setCreationDate(owner.getCreationDate());
        ownOwner.setUpdateDate(owner.getUpdateDate());

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
        owner.setCreationDate(ownOwner.getCreationDate());
        owner.setUpdateDate(ownOwner.getUpdateDate());
        owner.setImage(ownOwner.getOwnOwnerImage());
        owner.setCreatedBy(ownOwner.getCreatedBy());
        owner.setUpdatedBy(ownOwner.getUpdatedBy());
        owner.setCreationDate(ownOwner.getCreationDate());
        owner.setUpdateDate(ownOwner.getUpdateDate());

        if (!lazy) {
          //  owner.setAddress(AddressMapper.toDto(ownOwner.getAdrAddress(), true));
           // owner.setOrganisation(OrganisationMapper.toDto(ownOwner.getOrgOrganisation(), true));

        }

        return owner;
    }


    public static List<Owner> toDtos(Iterable<? extends OwnOwner> ownOwners, boolean lazy) {
        if (null == ownOwners) {
            return null;
        }
        List<Owner> owners = new ArrayList<>();
        for (OwnOwner ownOwner : ownOwners) {
            owners.add(toDto(ownOwner, lazy));
        }
        return owners;
    }

    public static Set<OwnOwner> toEntities(Set<? extends Owner> owners, boolean lazy) {
        if (null == owners) {
            return null;
        }
        Set<OwnOwner> ownOwners = new HashSet<>();
        for (Owner owner : owners) {
            ownOwners.add(toEntity(owner, lazy));
        }
        return ownOwners;
    }

    public static Set<Owner> toDtos(Set<? extends OwnOwner> ownOwners, boolean lazy) {
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

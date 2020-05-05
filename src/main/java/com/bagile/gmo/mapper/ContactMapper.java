package com.bagile.gmo.mapper;


import com.bagile.gmo.dto.Contact;
import com.bagile.gmo.entities.PrmContact;

import java.util.*;

public class ContactMapper {
    private ContactMapper(){

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","prmContactId");
        map.put("name","prmContactName");
        map.put("surname","prmContactSurname");
        map.put("tel1","prmContactTel1");
        map.put("tel2","prmContactTel2");
        map.put("fax","prmContactFax");
        map.put("contactType", "prmContactType");
        map.put("email", "prmContactEmail");
        map.put("comment", "prmContactComment");
        map.put("active","prmContactActive");

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

    public static PrmContact toEntity(Contact contact, boolean lazy) {
        if (null == contact) {
            return null;
        }
        PrmContact tmsContact = new PrmContact();
        tmsContact.setPrmContactId(contact.getId());
        tmsContact.setPrmContactName(contact.getName());
        tmsContact.setPrmContactType(contact.getContactType());
        tmsContact.setPrmContactSurname(contact.getSurname());
        tmsContact.setPrmContactTel1 (contact.getTel1 ());
        tmsContact.setPrmContactTel2 (contact.getTel2 ());
        tmsContact.setPrmContactFax(contact.getFax());
        tmsContact.setPrmContactEmail(contact.getEmail());
         tmsContact.setPrmContactComment(contact.getComment());
        tmsContact.setPrmContactActive(contact.getActive());


        tmsContact.setCreatedBy(contact.getCreatedBy());
        tmsContact.setUpdatedBy(contact.getUpdatedBy());
        tmsContact.setCreationDate(contact.getCreationDate());
        tmsContact.setUpdateDate(contact.getUpdateDate());
        /*if (!lazy) {
            tmsContact.setOwnOwner(OwnerMapper.toEntity(contact.getOwner(), true));
//            prmContact.setInvInvoices(InvoiceMapper.toEntities(contact.getInvoices(), true));
//            prmContact.setInvInvoiceArcs(InvoiceArcMapper.toEntities(contact.getInvoiceArcs(), true));
//            prmContact.setRcpSuppliers(SupplierMapper.toEntities(contact.getSuppliers(), true));
//            prmContact.setTrpTransports(TransportMapper.toEntities(contact.getTransports(), true));
        }*/
        return tmsContact;
    }

    public static Contact toDto(PrmContact tmsContact, boolean lazy) {
        if (null == tmsContact) {
            return null;
        }
        Contact contact = new Contact();
        contact.setId(tmsContact.getPrmContactId());
        contact.setName(tmsContact.getPrmContactName());
        contact.setSurname(tmsContact.getPrmContactSurname());
        contact.setTel1 (tmsContact.getPrmContactTel1 ());
        contact.setTel2 (tmsContact.getPrmContactTel2 ());
        contact.setFax(tmsContact.getPrmContactFax());
        contact.setContactType(tmsContact.getPrmContactType());
        contact.setEmail(tmsContact.getPrmContactEmail());
        contact.setComment(tmsContact.getPrmContactComment());
        contact.setActive(tmsContact.isPrmContactActive());

        contact.setCreatedBy(tmsContact.getCreatedBy());
        contact.setUpdatedBy(tmsContact.getUpdatedBy());
        contact.setCreationDate(tmsContact.getCreationDate());
        contact.setUpdateDate(tmsContact.getUpdateDate());
        /*if (!lazy) {
            contact.setOwner(OwnerMapper.toDto(prmContact.getOwnOwner(), true));
//            contact.setInvoices(InvoiceMapper.toDtos(prmContact.getInvInvoices(), true));
//            contact.setInvoiceArcs(InvoiceArcMapper.toDtos(prmContact.getInvInvoiceArcs(), true));
//            contact.setSuppliers(SupplierMapper.toDtos(prmContact.getRcpSuppliers(), true));
//            contact.setTransports(TransportMapper.toDtos(prmContact.getTrpTransports(), true));
        }*/
        return contact;
    }



    public static List<Contact> toDtos(Iterable<? extends PrmContact> tmsContacts, boolean lazy) {
        if (null == tmsContacts) {
            return null;
        }
        List<Contact> contacts = new ArrayList<>();
        for (PrmContact trmContact : tmsContacts) {
            contacts.add(toDto(trmContact, lazy));
        }
        return contacts;
    }

    public static Set<PrmContact> toEntities(Set<Contact> contacts, boolean lazy) {
        if (null == contacts) {
            return null;
        }
        Set<PrmContact> prmContacts = new HashSet<>();
        for (Contact contact : contacts) {
            prmContacts.add(toEntity(contact, lazy));
        }
        return prmContacts;
    }

    public static Set<Contact> toDtos(Set<PrmContact> tmsContacts, boolean lazy) {
        if (null == tmsContacts) {
            return null;
        }
        Set<Contact> contacts = new HashSet<>();
        for (PrmContact tmsContact : tmsContacts) {
            contacts.add(toDto(tmsContact, lazy));
        }
        return contacts;
    }
}

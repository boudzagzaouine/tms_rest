package com.bagile.tms.mapper;


import com.bagile.tms.dto.Contact;
import com.bagile.tms.entities.PrmContact;

import java.util.*;

public class ContactMapper {
    private ContactMapper(){

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","prmContactid");
        map.put("name","prmContactname");
        map.put("creationDate","prmContactcreationDate");
        map.put("surname","prmContactsurname");
        map.put("tel1","prmContactTel1");
        map.put("fax","prmContactfax");
        map.put("contactType", "prmContactType");
        map.put("email", "prmContactemail");
        map.put("comment", "prmContactcomment");
        map.put("active","prmContactactive");
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
        tmsContact.setPrmContactTele1(contact.getTele1());
        tmsContact.setPrmContactFax(contact.getFax());
        tmsContact.setPrmContactEmail(contact.getEmail());
         tmsContact.setPrmContactComment(contact.getComment());
        tmsContact.setPrmContactActive(contact.getActive());
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
        contact.setCreationDate(tmsContact.getPrmContactCreationDate());
        contact.setSurname(tmsContact.getPrmContactSurname());
        contact.setTele1(tmsContact.getPrmContactTele1());
        contact.setFax(tmsContact.getPrmContactFax());
        contact.setContactType(tmsContact.getPrmContactType());
        contact.setEmail(tmsContact.getPrmContactEmail());
        contact.setComment(tmsContact.getPrmContactComment());
        contact.setActive(tmsContact.isPrmContactActive());
        /*if (!lazy) {
            contact.setOwner(OwnerMapper.toDto(prmContact.getOwnOwner(), true));
//            contact.setInvoices(InvoiceMapper.toDtos(prmContact.getInvInvoices(), true));
//            contact.setInvoiceArcs(InvoiceArcMapper.toDtos(prmContact.getInvInvoiceArcs(), true));
//            contact.setSuppliers(SupplierMapper.toDtos(prmContact.getRcpSuppliers(), true));
//            contact.setTransports(TransportMapper.toDtos(prmContact.getTrpTransports(), true));
        }*/
        return contact;
    }

    public static List<Contact> toDtos(List<PrmContact> tmsContacts, boolean lazy) {
        if (null == tmsContacts) {
            return null;
        }
        List<Contact> contacts = new ArrayList<>();
        for (PrmContact trmContact : tmsContacts) {
            contacts.add(toDto(trmContact, lazy));
        }
        return contacts;
    }

    public static List<Contact> toDtos(Iterable<PrmContact> tmsContacts, boolean lazy) {
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

package com.bagile.tms.mapper;


import com.bagile.tms.dto.Contact;
import com.bagile.tms.entities.TmsContact;

import java.util.*;

public class ContactMapper {
    private ContactMapper(){

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","tmsContactid");
        map.put("name","tmsContactname");
        map.put("creationDate","tmsContactcreationDate");
        map.put("surname","tmsContactsurname");
        map.put("tel1","prmContactTel1");
        map.put("fax","tmsContactfax");
        map.put("contactType", "tmsContactType");
        map.put("email", "tmsContactemail");
        map.put("comment", "tmsContactcomment");
        map.put("active","tmsContactactive");
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsContact toEntity(Contact contact, boolean lazy) {
        if (null == contact) {
            return null;
        }
        TmsContact tmsContact = new TmsContact();
        tmsContact.setTmsContactid(contact.getId());
        tmsContact.setTmsContactname(contact.getName());
        tmsContact.setTmsContactcontactType(contact.getContactType());
        tmsContact.setTmsContactsurname(contact.getSurname());
        tmsContact.setTmsContacttele1(contact.getTele1());
        tmsContact.setTmsContactfax(contact.getFax());
        tmsContact.setTmsContactcontactType(contact.getContactType());
        tmsContact.setTmsContactemail(contact.getEmail());
         tmsContact.setTmsContactcomment(contact.getComment());
        tmsContact.setTmsContactactive(contact.getActive());
        /*if (!lazy) {
            tmsContact.setOwnOwner(OwnerMapper.toEntity(contact.getOwner(), true));
//            prmContact.setInvInvoices(InvoiceMapper.toEntities(contact.getInvoices(), true));
//            prmContact.setInvInvoiceArcs(InvoiceArcMapper.toEntities(contact.getInvoiceArcs(), true));
//            prmContact.setRcpSuppliers(SupplierMapper.toEntities(contact.getSuppliers(), true));
//            prmContact.setTrpTransports(TransportMapper.toEntities(contact.getTransports(), true));
        }*/
        return tmsContact;
    }

    public static Contact toDto(TmsContact tmsContact, boolean lazy) {
        if (null == tmsContact) {
            return null;
        }
        Contact contact = new Contact();
        contact.setId(tmsContact.getTmsContactid());
        contact.setName(tmsContact.getTmsContactname());
        contact.setCreationDate(tmsContact.getTmsContactcreationDate());
        contact.setSurname(tmsContact.getTmsContactsurname());
        contact.setTele1(tmsContact.getTmsContacttele1());
        contact.setFax(tmsContact.getTmsContactfax());
        contact.setContactType(tmsContact.getTmsContactcontactType());
        contact.setEmail(tmsContact.getTmsContactemail());
        contact.setComment(tmsContact.getTmsContactcomment());
        contact.setActive(tmsContact.getTmsContactactive());
        /*if (!lazy) {
            contact.setOwner(OwnerMapper.toDto(prmContact.getOwnOwner(), true));
//            contact.setInvoices(InvoiceMapper.toDtos(prmContact.getInvInvoices(), true));
//            contact.setInvoiceArcs(InvoiceArcMapper.toDtos(prmContact.getInvInvoiceArcs(), true));
//            contact.setSuppliers(SupplierMapper.toDtos(prmContact.getRcpSuppliers(), true));
//            contact.setTransports(TransportMapper.toDtos(prmContact.getTrpTransports(), true));
        }*/
        return contact;
    }

    public static List<Contact> toDtos(List<TmsContact> tmsContacts, boolean lazy) {
        if (null == tmsContacts) {
            return null;
        }
        List<Contact> contacts = new ArrayList<>();
        for (TmsContact trmContact : tmsContacts) {
            contacts.add(toDto(trmContact, lazy));
        }
        return contacts;
    }

    public static List<Contact> toDtos(Iterable<TmsContact> tmsContacts, boolean lazy) {
        if (null == tmsContacts) {
            return null;
        }
        List<Contact> contacts = new ArrayList<>();
        for (TmsContact trmContact : tmsContacts) {
            contacts.add(toDto(trmContact, lazy));
        }
        return contacts;
    }

    public static Set<TmsContact> toEntities(Set<Contact> contacts, boolean lazy) {
        if (null == contacts) {
            return null;
        }
        Set<TmsContact> prmContacts = new HashSet<>();
        for (Contact contact : contacts) {
            prmContacts.add(toEntity(contact, lazy));
        }
        return prmContacts;
    }

    public static Set<Contact> toDtos(Set<TmsContact> tmsContacts, boolean lazy) {
        if (null == tmsContacts) {
            return null;
        }
        Set<Contact> contacts = new HashSet<>();
        for (TmsContact tmsContact : tmsContacts) {
            contacts.add(toDto(tmsContact, lazy));
        }
        return contacts;
    }
}

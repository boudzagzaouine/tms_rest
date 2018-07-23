package com.sinno.ems.mapper;

import com.sinno.ems.dto.Contact;
import com.sinno.ems.entities.PrmContact;

import java.util.*;

public class ContactMapper {
    private ContactMapper(){

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","prmContactId");
        map.put("owner","ownOwner");
        map.put("name","prmContactName");
        map.put("surName","prmContactSurName");
        map.put("tel1","prmContactTel1");
        map.put("tel2","prmContactTel2");
        map.put("fax","prmContactFax");
        map.put("creationDate","prmContactCreationDate");
        map.put("updateDate","prmContactUpdateDate");
        map.put("variable1","prmContactVariable1");
        map.put("variable2","prmContactVariable2");
        map.put("variable3","prmContactVariable3");
        map.put("variable4","prmContactVariable4");
        map.put("variable5","prmContactVariable5");
        map.put("variable6","prmContactVariable6");
        map.put("variable7","prmContactVariable7");
        map.put("variable8","prmContactVariable8");
        map.put("variable9","prmContactVariable9");
        map.put("variable10","prmContactVariable10");
        map.put("contactType", "prmContactType");
        map.put("email", "prmContactEmail");
        map.put("comment", "prmContactComment");
        map.put("active","prmContactActive");
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
        PrmContact prmContact = new PrmContact();
        prmContact.setPrmContactId(contact.getId());
        prmContact.setPrmContactName(contact.getName());
        prmContact.setPrmContactSurName(contact.getSurName());
        prmContact.setPrmContactTel1(contact.getTel1());
        prmContact.setPrmContactTel2(contact.getTel2());
        prmContact.setPrmContactFax(contact.getFax());
        prmContact.setPrmContactCreationDate(contact.getCreationDate());
        prmContact.setPrmContactUpdateDate(contact.getUpdateDate());
        prmContact.setPrmContactVariable1(contact.getVariable1());
        prmContact.setPrmContactVariable2(contact.getVariable2());
        prmContact.setPrmContactVariable3(contact.getVariable3());
        prmContact.setPrmContactVariable4(contact.getVariable4());
        prmContact.setPrmContactVariable5(contact.getVariable5());
        prmContact.setPrmContactVariable6(contact.getVariable6());
        prmContact.setPrmContactVariable7(contact.getVariable7());
        prmContact.setPrmContactVariable8(contact.getVariable8());
        prmContact.setPrmContactVariable9(contact.getVariable9());
        prmContact.setPrmContactVariable10(contact.getVariable10());
        prmContact.setPrmContactType(contact.getContactType());
        prmContact.setPrmContactEmail(contact.getEmail());
        prmContact.setPrmContactActive(contact.getActive());
        prmContact.setPrmContactComment(contact.getComment());
        if (!lazy) {
              prmContact.setOwnOwner(OwnerMapper.toEntity(contact.getOwner(), true));
//            prmContact.setInvInvoices(InvoiceMapper.toEntities(contact.getInvoices(), true));
//            prmContact.setInvInvoiceArcs(InvoiceArcMapper.toEntities(contact.getInvoiceArcs(), true));
//            prmContact.setRcpSuppliers(SupplierMapper.toEntities(contact.getSuppliers(), true));
//            prmContact.setTrpTransports(TransportMapper.toEntities(contact.getTransports(), true));
        }
        return prmContact;
    }

    public static Contact toDto(PrmContact prmContact, boolean lazy) {
        if (null == prmContact) {
            return null;
        }
        Contact contact = new Contact();
        contact.setId(prmContact.getPrmContactId());
        contact.setName(prmContact.getPrmContactName());
        contact.setSurName(prmContact.getPrmContactSurName());
        contact.setTel1(prmContact.getPrmContactTel1());
        contact.setTel2(prmContact.getPrmContactTel2());
        contact.setFax(prmContact.getPrmContactFax());
        contact.setCreationDate(prmContact.getPrmContactCreationDate());
        contact.setUpdateDate(prmContact.getPrmContactUpdateDate());
        contact.setVariable1(prmContact.getPrmContactVariable1());
        contact.setVariable2(prmContact.getPrmContactVariable2());
        contact.setVariable3(prmContact.getPrmContactVariable3());
        contact.setVariable4(prmContact.getPrmContactVariable4());
        contact.setVariable5(prmContact.getPrmContactVariable5());
        contact.setVariable6(prmContact.getPrmContactVariable6());
        contact.setVariable7(prmContact.getPrmContactVariable7());
        contact.setVariable8(prmContact.getPrmContactVariable8());
        contact.setVariable9(prmContact.getPrmContactVariable9());
        contact.setVariable10(prmContact.getPrmContactVariable10());
        contact.setContactType(prmContact.getPrmContactType());
        contact.setEmail(prmContact.getPrmContactEmail());
        contact.setComment(prmContact.getPrmContactComment());
        contact.setActive(prmContact.getPrmContactActive());
        if (!lazy) {
            contact.setOwner(OwnerMapper.toDto(prmContact.getOwnOwner(), true));
//            contact.setInvoices(InvoiceMapper.toDtos(prmContact.getInvInvoices(), true));
//            contact.setInvoiceArcs(InvoiceArcMapper.toDtos(prmContact.getInvInvoiceArcs(), true));
//            contact.setSuppliers(SupplierMapper.toDtos(prmContact.getRcpSuppliers(), true));
//            contact.setTransports(TransportMapper.toDtos(prmContact.getTrpTransports(), true));
        }
        return contact;
    }

    public static List<Contact> toDtos(List<PrmContact> prmContacts, boolean lazy) {
        if (null == prmContacts) {
            return null;
        }
        List<Contact> contacts = new ArrayList<>();
        for (PrmContact prmContact : prmContacts) {
            contacts.add(toDto(prmContact, lazy));
        }
        return contacts;
    }

    public static List<Contact> toDtos(Iterable<PrmContact> prmContacts, boolean lazy) {
        if (null == prmContacts) {
            return null;
        }
        List<Contact> contacts = new ArrayList<>();
        for (PrmContact prmContact : prmContacts) {
            contacts.add(toDto(prmContact, lazy));
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

    public static Set<Contact> toDtos(Set<PrmContact> prmContacts, boolean lazy) {
        if (null == prmContacts) {
            return null;
        }
        Set<Contact> contacts = new HashSet<>();
        for (PrmContact prmContact : prmContacts) {
            contacts.add(toDto(prmContact, lazy));
        }
        return contacts;
    }
}

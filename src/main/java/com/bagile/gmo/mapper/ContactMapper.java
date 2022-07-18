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
        PrmContact gmoContact = new PrmContact();
        gmoContact.setPrmContactId(contact.getId());
        gmoContact.setPrmContactName(contact.getName());
      //  gmoContact.setPrmContactType(contact.getContactType());
        gmoContact.setPrmContactSurname(contact.getSurname());
        gmoContact.setPrmContactTel1 (contact.getTel1 ());
        gmoContact.setPrmContactTel2 (contact.getTel2 ());
        gmoContact.setPrmContactFax(contact.getFax());
        gmoContact.setPrmContactEmail(contact.getEmail());
         gmoContact.setPrmContactComment(contact.getComment());
        gmoContact.setPrmContactActive(contact.getActive());


        gmoContact.setCreatedBy(contact.getCreatedBy());
        gmoContact.setUpdatedBy(contact.getUpdatedBy());
        gmoContact.setCreationDate(contact.getCreationDate());
        gmoContact.setUpdateDate(contact.getUpdateDate());
        if (!lazy) {
            gmoContact.setOwnOwner(OwnerMapper.toEntity(contact.getOwner(), true));
            gmoContact.setCmdAccount(AccountMapper.toEntity(contact.getAccount(), true));

//            prmContact.setInvInvoices(InvoiceMapper.toEntities(contact.getInvoices(), true));
//            prmContact.setInvInvoiceArcs(InvoiceArcMapper.toEntities(contact.getInvoiceArcs(), true));
//            prmContact.setRcpSuppliers(SupplierMapper.toEntities(contact.getSuppliers(), true));
//            prmContact.setTrpTransports(TransportMapper.toEntities(contact.getTransports(), true));
        }
        return gmoContact;
    }

    public static Contact toDto(PrmContact gmoContact, boolean lazy) {
        if (null == gmoContact) {
            return null;
        }
        Contact contact = new Contact();
        contact.setId(gmoContact.getPrmContactId());
        contact.setName(gmoContact.getPrmContactName());
        contact.setSurname(gmoContact.getPrmContactSurname());
        contact.setTel1 (gmoContact.getPrmContactTel1 ());
        contact.setTel2 (gmoContact.getPrmContactTel2 ());
        contact.setFax(gmoContact.getPrmContactFax());
      //  contact.setContactType(gmoContact.getPrmContactType());
        contact.setEmail(gmoContact.getPrmContactEmail());
        contact.setComment(gmoContact.getPrmContactComment());
        contact.setActive(gmoContact.isPrmContactActive());

        contact.setCreatedBy(gmoContact.getCreatedBy());
        contact.setUpdatedBy(gmoContact.getUpdatedBy());
        contact.setCreationDate(gmoContact.getCreationDate());
        contact.setUpdateDate(gmoContact.getUpdateDate());
        if (!lazy) {

            contact.setOwner(OwnerMapper.toDto(gmoContact.getOwnOwner(), true));
            contact.setAccount(AccountMapper.toDto(gmoContact.getCmdAccount(), true));

//            contact.setInvoices(InvoiceMapper.toDtos(prmContact.getInvInvoices(), true));
//            contact.setInvoiceArcs(InvoiceArcMapper.toDtos(prmContact.getInvInvoiceArcs(), true));
//            contact.setSuppliers(SupplierMapper.toDtos(prmContact.getRcpSuppliers(), true));
//            contact.setTransports(TransportMapper.toDtos(prmContact.getTrpTransports(), true));
        }
        return contact;
    }



    public static List<Contact> toDtos(Iterable<? extends PrmContact> gmoContacts, boolean lazy) {
        if (null == gmoContacts) {
            return null;
        }
        List<Contact> contacts = new ArrayList<>();
        for (PrmContact trmContact : gmoContacts) {
            contacts.add(toDto(trmContact, lazy));
        }
        return contacts;
    }

    public static Set<PrmContact> toEntities(Iterable<? extends Contact> contacts, boolean lazy) {
        if (null == contacts) {
            return null;
        }
        Set<PrmContact> prmContacts = new HashSet<>();
        for (Contact contact : contacts) {
            prmContacts.add(toEntity(contact, lazy));
        }
        return prmContacts;
    }


}

package com.sinno.ems.mapperWms;

import com.sinno.ems.dto.Account;
import com.sinno.ems.dto.Address;
import com.sinno.ems.dto.Owner;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperOwner {


    public static com.sinno.wms.crud.modelbasic.owners.Owner convertToWmsDto(Owner o) {

        com.sinno.wms.crud.modelbasic.owners.Owner own = new com.sinno.wms.crud.modelbasic.owners.Owner();

        if (null != o.getDescription())
            own.setDescription(o.getDescription());
        if (null != o.getPrimaryTel())
            own.setTelephone(o.getPrimaryTel());
        if (null != o.getAddress() && null != o.getAddress().getLine1() && null != o.getAddress().getLine2())
            own.setAddress_name(o.getAddress().getLine1() + " " + o.getAddress().getLine2());
        if (null != o.getAddress() && null != o.getAddress().getCity())
            own.setCity(o.getAddress().getCity());
        if (null != o.getAddress() && null != o.getAddress().getCountry())
            own.setCountry(o.getAddress().getCountry());
        if (null != o.getCode())
            own.setOwner_code(o.getCode());
        if (null != o.getAddress() && null != o.getAddress().getState())
            own.setState(o.getAddress().getState());
        if (null != o.getName())
            own.setContact_name(o.getName());
        if (null != o.getAddress() && null != o.getAddress().getZip())
            own.setPostal_code(o.getAddress().getZip());
        if (null != o.getSiret())
            own.setCif(o.getSiret());
        if (null != o.getCurrency())
            own.setCurrency(o.getCurrency());
        if (null != o.getInvoiceTerm())
            own.setInvoice_term(o.getInvoiceTerm());
        if (null != o.getRelevantVat())
            own.setRelevant_vat(o.getRelevantVat());
        if (null != o.getInvoiceType()) {
            if (1 == o.getInvoiceType()) {
                own.setInvoice_type("Hebdomadaire");
            }
            if (2 == o.getInvoiceType()) {
                own.setInvoice_type("Bimensuelle");
            }
            if (3 == o.getInvoiceType()) {
                own.setInvoice_type("Mensuelle");
            }
            if (4 == o.getInvoiceType()) {
                own.setInvoice_type("Trimestrielle");
            }
        }
        if (null != o.getSurname()) {
            own.setContact_surname(o.getSurname());
        }

        // own.setFax();
        // own.setExtension();

        return own;

    }

    public static Owner convertToEmsDto(Owner owner, com.sinno.wms.crud.modelbasic.owners.Owner o) {

        Account account = new Account();


        if (null != o.getOwner_code())
            owner.setCode(o.getOwner_code());
        if (null != o.getContact_name())
            owner.setName(o.getContact_name());
        if (null != o.getDescription())
            owner.setDescription(o.getDescription());
        if (null != o.getTelephone())
            owner.setPrimaryTel(o.getTelephone());
        if (null != o.getCif())
            owner.setSiret(o.getCif());

        if (null != o.getCurrency())
            owner.setCurrency(o.getCurrency());

        if (null != o.getInvoice_term())
            owner.setInvoiceTerm(o.getInvoice_term());

        if (null != o.getInvoice_type()) {
            if ("Hebdomadaire".equals(o.getInvoice_type().trim()))
                owner.setInvoiceType(1L);
            else if ("Bimensuelle".equals(o.getInvoice_type().trim()))
                owner.setInvoiceType(2L);
            else if ("Mensuelle".equals(o.getInvoice_type().trim()))
                owner.setInvoiceType(3L);
            else if ("Trimestrielle".equals(o.getInvoice_type().trim()))
                owner.setInvoiceType(4L);
        }

        if (null != o.getRelevant_vat())
            owner.setRelevantVat(o.getRelevant_vat());

        if (null != o.getContact_surname()) {
            owner.setSurname(o.getContact_surname());
        }
        if (null != o.getContact_email())
            owner.setEmail(o.getContact_email());
        if (null != o.getVat())
            owner.setVat(o.getVat());
        if (null != o.getActive())
            owner.setActive(o.getActive());




     /*   owner.setEmail();
        owner.setSurname();
        owner.setVat();
        owner.setAddress();
        owner.setCurrency();
        owner.setComment();
        owner.setUserBoxCreationDate();
        owner.setActive();            */

        return owner;

    }
}

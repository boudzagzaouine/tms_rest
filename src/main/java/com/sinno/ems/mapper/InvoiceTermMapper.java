package com.sinno.ems.mapper;

import com.sinno.ems.dto.InvoiceTerm;
import com.sinno.ems.entities.InvInvoiceTerm;

import java.util.*;

/**
 * Created by Enissay on 03/12/2016.
 */
public class InvoiceTermMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invInvoiceTermId");
        map.put("code", "invInvoiceTermCode");
        map.put("description", "invInvoiceTermDescription");
        map.put("creationDate", "invInvoiceTermCreationDate");
        map.put("updateDate", "invInvoiceTermUpdateDate");
        //map.put("organisation", "invInvoiceTermOrganisation");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvInvoiceTerm toEntity(InvoiceTerm invoiceTerm, boolean lazy) {
        if (null == invoiceTerm) {
            return null;
        }
        InvInvoiceTerm invInvoiceTerm = new InvInvoiceTerm();
        invInvoiceTerm.setInvInvoiceTermId(invoiceTerm.getId());
        invInvoiceTerm.setInvInvoiceTermCode(invoiceTerm.getCode() != null ? invoiceTerm.getCode().toUpperCase() : null);
        invInvoiceTerm.setInvInvoiceTermDescription(invoiceTerm.getDescription());
        invInvoiceTerm.setInvInvoiceTermCreationDate(invoiceTerm.getCreationDate());
        invInvoiceTerm.setInvInvoiceTermUpdateDate(invoiceTerm.getUpdateDate());
       
        if (!lazy) {
           // invInvoiceTerm.setOrgOrganisation(OrganisationMapper.toEntity(invoiceTerm.getOrganisation(), true));
        }
        return invInvoiceTerm;
    }

    public static InvoiceTerm toDto(InvInvoiceTerm invInvoiceTerm, boolean lazy) {
        if (null == invInvoiceTerm) {
            return null;
        }
        InvoiceTerm invoiceTerm = new InvoiceTerm();
        invoiceTerm.setId(invInvoiceTerm.getInvInvoiceTermId());
        invoiceTerm.setCode(invInvoiceTerm.getInvInvoiceTermCode());
        invoiceTerm.setDescription(invInvoiceTerm.getInvInvoiceTermDescription());
        invoiceTerm.setCreationDate(invInvoiceTerm.getInvInvoiceTermCreationDate());
        invoiceTerm.setUpdateDate(invInvoiceTerm.getInvInvoiceTermUpdateDate());
       
        if (!lazy) {
           // invoiceTerm.setOrganisation(OrganisationMapper.toDto(invInvoiceTerm.getOrgOrganisation(), true));
        }
        return invoiceTerm;
    }

    public static List<InvoiceTerm> toDtos(List<InvInvoiceTerm> invInvoiceTerms, boolean lazy) {
        if (null == invInvoiceTerms) {
            return null;
        }
        List<InvoiceTerm> invoiceTerms = new ArrayList<>();
        for (InvInvoiceTerm invInvoiceTerm : invInvoiceTerms) {
            invoiceTerms.add(toDto(invInvoiceTerm, lazy));
        }
        return invoiceTerms;
    }

    public static List<InvoiceTerm> toDtos(Iterable<InvInvoiceTerm> invInvoiceTerms, boolean lazy) {
        if (null == invInvoiceTerms) {
            return null;
        }
        List<InvoiceTerm> invoiceTerms = new ArrayList<>();
        for (InvInvoiceTerm invInvoiceTerm : invInvoiceTerms) {
            invoiceTerms.add(toDto(invInvoiceTerm, lazy));
        }
        return invoiceTerms;
    }

    public static Set<InvInvoiceTerm> toEntities(Set<InvoiceTerm> invoiceTerms, boolean lazy) {
        if (null == invoiceTerms) {
            return null;
        }
        Set<InvInvoiceTerm> invInvoiceTerms = new HashSet<>();
        for (InvoiceTerm invoiceTerm : invoiceTerms) {
            invInvoiceTerms.add(toEntity(invoiceTerm, lazy));
        }
        return invInvoiceTerms;
    }

    public static Set<InvoiceTerm> toDtos(Set<InvInvoiceTerm> invInvoiceTerms, boolean lazy) {
        if (null == invInvoiceTerms) {
            return null;
        }
        Set<InvoiceTerm> invoiceTerms = new HashSet<>();
        for (InvInvoiceTerm invInvoiceTerm : invInvoiceTerms) {
            invoiceTerms.add(toDto(invInvoiceTerm, lazy));
        }
        return invoiceTerms;
    }
}

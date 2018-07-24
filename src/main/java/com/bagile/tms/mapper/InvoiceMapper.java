/**
 *
 */
package com.bagile.tms.mapper;

import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * @author aelguezzar
 */
public class InvoiceMapper {
    private InvoiceMapper() {
    }

    private static Map<String, String> map;


    public static Map<String, String> getMap() {
        return map;
    }

    static {
        map = new HashMap<>();
        map.put("id", "invInvoiceId");
        map.put("owner", "ownOwner");
        map.put("address", "adrAddress");
        map.put("code", "invInvoiceCode");
        map.put("creationDate", "invInvoiceCreationDate");
        map.put("updateDate", "invInvoiceUpdateDate");
        map.put("state", "invInvoiceState");
        map.put("vat", "invInvoicevat");
        map.put("invoiceDate", "invInvoiceDate");
        map.put("comment", "invInvoiceComment");
        map.put("name", "invInvoiceName");
        map.put("surname", "invInvoiceSurname");
        map.put("primaryTel", "invInvoicePrimaryTel");
        map.put("secondaryTel", "invInvoiceSecondaryTel");
        map.put("email", "invInvoiceEmail");
        map.put("fax", "invInvoiceFax");
        map.put("endDate","invInvoiceEndDate");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Invoice toDto(InvInvoice invInvoice, boolean lazy) {
        if (null == invInvoice) {
            return null;
        }
        Invoice invoice = new Invoice();
        invoice.setCode(invInvoice.getInvInvoiceCode());
        invoice.setCreationDate(invInvoice.getInvInvoiceCreationDate());
        invoice.setId(invInvoice.getInvInvoiceId());
        invoice.setUpdateDate(invInvoice.getInvInvoiceUpdateDate());
        invoice.setInvoiceDate(invInvoice.getInvInvoiceDate());
        invoice.setState(invInvoice.getInvInvoiceState());
        invoice.setVat(invInvoice.getInvInvoiceVat());
        invoice.setComment(invInvoice.getInvInvoiceComment());
        invoice.setName(invInvoice.getInvInvoiceName());
        invoice.setSurname(invInvoice.getInvInvoiceSurname());
        invoice.setSecondaryTel(invInvoice.getInvInvoiceSecondaryTel());
        invoice.setPrimaryTel(invInvoice.getInvInvoicePrimaryTel());
        invoice.setEmail(invInvoice.getInvInvoiceEmail());
        invoice.setFax(invInvoice.getInvInvoiceFax());
        invoice.setStartDate(invInvoice.getInvInvoicStartDate());
        if (!lazy) {
            invoice.setLines(InvoiceLineMapper.toDtos(invInvoice.getInvInvoiceLines(), false));
            invoice.setOwner(OwnerMapper.toDto(invInvoice.getOwnOwner(), true));
            invoice.setAddress(AddressMapper.toDto(invInvoice.getAdrAddress(), true));
        }
        return invoice;
    }

    public static InvInvoice toEntity(Invoice invoice, boolean lazy) {
        if (null == invoice) {
            return null;
        }
        InvInvoice invInvoice = new InvInvoice();
        invInvoice.setInvInvoiceCode(invoice.getCode() != null ? invoice.getCode().toUpperCase() : null);
        invInvoice.setInvInvoiceCreationDate(invoice.getCreationDate());
        invInvoice.setInvInvoiceId(invoice.getId());
        invInvoice.setInvInvoiceUpdateDate(invoice.getUpdateDate());
        invInvoice.setInvInvoiceState(invoice.getState());
        invInvoice.setInvInvoiceVat(invoice.getVat());
        invInvoice.setInvInvoiceDate(invoice.getInvoiceDate());
        invInvoice.setInvInvoiceComment(invoice.getComment());
        invInvoice.setInvInvoiceName(invoice.getName());
        invInvoice.setInvInvoiceSurname(invoice.getSurname());
        invInvoice.setInvInvoicePrimaryTel(invoice.getPrimaryTel());
        invInvoice.setInvInvoiceSecondaryTel(invoice.getSecondaryTel());
        invInvoice.setInvInvoiceEmail(invoice.getEmail());
        invInvoice.setInvInvoiceFax(invoice.getFax());
        invInvoice.setInvInvoiceDate(invoice.getInvoiceDate());
        invInvoice.setInvInvoicStartDate(invoice.getStartDate());
        if (!lazy) {
            invInvoice.setAdrAddress(AddressMapper.toEntity(invoice.getAddress(), true));
            invInvoice.setInvInvoiceLines(InvoiceLineMapper.toEntities(invoice.getLines(), false));
            invInvoice.setOwnOwner(OwnerMapper.toEntity(invoice.getOwner(), true));
            oneToMany(invInvoice);
        }
        return invInvoice;
    }

    public static void oneToMany(InvInvoice invoice) {
        if (null != invoice.getInvInvoiceLines()) {
            invoice.getInvInvoiceLines().stream().forEach(il -> {
                il.setInvInvoice(invoice);
                il.setInvInvoiceLinesUpdateDate(EmsDate.getDateNow());
                if (0 >= il.getInvInvoiceLinesId()) {
                    il.setInvInvoiceLinesCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static List<Invoice> toDtos(List<InvInvoice> invInvoices, boolean lazy) {
        if (null == invInvoices) {
            return null;
        }
        List<Invoice> invoices = new ArrayList<>();
        for (InvInvoice invInvoice : invInvoices) {
            invoices.add(toDto(invInvoice, lazy));
        }
        return invoices;
    }

    public static List<Invoice> toDtos(Iterable<InvInvoice> invInvoices, boolean lazy) {
        if (null == invInvoices) {
            return null;
        }
        List<Invoice> invoices = new ArrayList<>();
        for (InvInvoice invInvoice : invInvoices) {
            invoices.add(toDto(invInvoice, lazy));
        }
        return invoices;
    }

    public static Set<InvInvoice> toEntities(Set<Invoice> invoices, boolean lazy) {
        if (null == invoices) {
            return null;
        }
        Set<InvInvoice> invInvoices = new HashSet<>();
        for (Invoice invoice : invoices) {
            invInvoices.add(toEntity(invoice, lazy));
        }
        return invInvoices;
    }

    public static Set<Invoice> toDtos(Set<InvInvoice> invInvoices, boolean lazy) {
        if (null == invInvoices) {
            return null;
        }
        Set<Invoice> invoices = new HashSet<>();
        for (InvInvoice invInvoice : invInvoices) {
            invoices.add(toDto(invInvoice, lazy));
        }
        return invoices;
    }

}

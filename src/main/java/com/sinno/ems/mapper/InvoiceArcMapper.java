/**
 *
 */
package com.sinno.ems.mapper;

import com.sinno.ems.dto.InvoiceArc;
import com.sinno.ems.dto.InvoiceLineArc;
import com.sinno.ems.entities.InvInvoiceArc;
import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * @author aelguezzar
 */
public class InvoiceArcMapper {
    private InvoiceArcMapper() {
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
        map.put("contact", "prmContact");
        map.put("code", "invInvoiceCode");
        map.put("creationDate", "invInvoiceCreationDate");
        map.put("updateDate", "invInvoiceUpdateDate");
        map.put("state","invInvoiceState");
        map.put("vat","invInvoicevat");
        map.put("invoiceDate","invInvoiceDate");
        map.put("comment","invInvoiceComment");


    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static InvoiceArc toDto(InvInvoiceArc invInvoiceArc, boolean lazy) {
        if (null == invInvoiceArc) {
            return null;
        }
        InvoiceArc invoiceArc = new InvoiceArc();
        invoiceArc.setCode(invInvoiceArc.getInvInvoiceCode());
        invoiceArc.setCreationDate(invInvoiceArc.getInvInvoiceCreationDate());
        invoiceArc.setId(invInvoiceArc.getInvInvoiceId());
        invoiceArc.setUpdateDate(invInvoiceArc.getInvInvoiceUpdateDate());
        invoiceArc.setState(invInvoiceArc.getInvInvoiceState());
        invoiceArc.setVat(invInvoiceArc.getInvInvoiceVat());
        invoiceArc.setComment(invInvoiceArc.getInvInvoiceComment());
        if (!lazy) {
            invoiceArc.setContact(ContactMapper.toDto(invInvoiceArc.getPrmContact(), true));
            invoiceArc.setLines(InvoiceLineArcMapper.toDtos(invInvoiceArc.getInvInvoiceLines(), false));
            invoiceArc.setOwner(OwnerMapper.toDto(invInvoiceArc.getOwnOwner(), true));
            invoiceArc.setAddress(AddressMapper.toDto(invInvoiceArc.getAdrAddress(), true));
        }
        return invoiceArc;
    }

    public static InvInvoiceArc toEntity(InvoiceArc invoice, boolean lazy) {
        if (null == invoice) {
            return null;
        }
        InvInvoiceArc invInvoiceArc = new InvInvoiceArc();
        invInvoiceArc.setInvInvoiceCode(invoice.getCode());
        invInvoiceArc.setInvInvoiceCreationDate(invoice.getCreationDate());
        invInvoiceArc.setInvInvoiceId(invoice.getId());
        invInvoiceArc.setInvInvoiceUpdateDate(invoice.getUpdateDate());
        invInvoiceArc.setInvInvoiceState(invoice.getState());
        invInvoiceArc.setInvInvoiceVat(invoice.getVat());
        invInvoiceArc.setInvInvoiceDate(invoice.getInvoiceDate());
        invInvoiceArc.setInvInvoiceComment(invoice.getComment());
        if (!lazy) {
            invInvoiceArc.setAdrAddress(AddressMapper.toEntity(invoice.getAddress(), true));
            invInvoiceArc.setInvInvoiceLines(InvoiceLineArcMapper.toEntities(invoice.getLines(), false));
            invInvoiceArc.setOwnOwner(OwnerMapper.toEntity(invoice.getOwner(), true));
            invInvoiceArc.setPrmContact(ContactMapper.toEntity(invoice.getContact(), true));
            oneToMany(invInvoiceArc);
        }
        return invInvoiceArc;
    }

    public static void oneToMany(InvInvoiceArc invoiceArc) {
        if (null != invoiceArc.getInvInvoiceLines()) {
            invoiceArc.getInvInvoiceLines().stream().forEach(il -> {
                il.setInvInvoice(invoiceArc);
                il.setInvInvoiceLinesUpdateDate(EmsDate.getDateNow());
                if (0 >= il.getInvInvoiceLinesId()) {
                    il.setInvInvoiceLinesCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static List<InvoiceArc> toDtos(List<InvInvoiceArc> invInvoices, boolean lazy) {
        if (null == invInvoices) {
            return null;
        }
        List<InvoiceArc> invoices = new ArrayList<>();
        for (InvInvoiceArc invInvoice : invInvoices) {
            invoices.add(toDto(invInvoice, lazy));
        }
        return invoices;
    }

    public static List<InvoiceArc> toDtos(Iterable<InvInvoiceArc> invInvoices, boolean lazy) {
        if (null == invInvoices) {
            return null;
        }
        List<InvoiceArc> invoices = new ArrayList<>();
        for (InvInvoiceArc invInvoice : invInvoices) {
            invoices.add(toDto(invInvoice, lazy));
        }
        return invoices;
    }

    public static Set<InvInvoiceArc> toEntities(Set<InvoiceArc> invoices, boolean lazy) {
        if (null == invoices) {
            return null;
        }
        Set<InvInvoiceArc> invInvoices = new HashSet<>();
        for (InvoiceArc invoice : invoices) {
            invInvoices.add(toEntity(invoice, lazy));
        }
        return invInvoices;
    }

    public static Set<InvoiceArc> toDtos(Set<InvInvoiceArc> invInvoices, boolean lazy) {
        if (null == invInvoices) {
            return null;
        }
        Set<InvoiceArc> invoices = new HashSet<>();
        for (InvInvoiceArc invInvoice : invInvoices) {
            invoices.add(toDto(invInvoice, lazy));
        }
        return invoices;
    }

}

/**
 *
 */
package com.sinno.ems.mapper;

import java.util.*;


/**
 * @author aelguezzar
 */
public class InvoiceLineMapper {
    private InvoiceLineMapper() {
    }

    private static Map<String, String> map;


    public static Map<String, String> getMap() {
        return map;
    }

    static {
        map = new HashMap<>();
        map.put("id","invInvoiceLinesId");
        map.put("invoice","invInvoice");
        map.put("movementType","invMovementType");
        map.put("owner","ownOwner");
        map.put("lineNumber","invInvoiceLinesLineNumber");
        map.put("tarifPrice","invInvoiceLinesTarifPrice");
        map.put("discount","invInvoiceLinesDiscount");
        map.put("quantity","invInvoiceLinesQuantity");
        map.put("totalPriceHT","invInvoiceLinesTotalPriceHT");
        map.put("totalPriceTTC","invInvoiceLinesTotalPriceTTC");
        map.put("creationDate","invInvoiceLinesCreationDate");
        map.put("updateDate","invInvoiceLinesUpdateDate");
        map.put("variable1","invInvoiceLinesVariable1");
        map.put("variable2","invInvoiceLinesVariable2");
        map.put("variable3","invInvoiceLinesVariable3");
        map.put("variable4","invInvoiceLinesVariable4");
        map.put("variable5","invInvoiceLinesVariable5");
        map.put("variable6","invInvoiceLinesVariable6");
        map.put("variable7","invInvoiceLinesVariable7");
        map.put("variable8","invInvoiceLinesVariable8");
        map.put("variable9","invInvoiceLinesVariable9");
        map.put("variable10","invInvoiceLinesVariable10");
        map.put("comment","invInvoiceLinesComment");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static InvoiceLine toDto(InvInvoiceLine invInvoiceLine, boolean lazy) {
        if (null == invInvoiceLine) {
            return null;
        }
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setCreationDate(invInvoiceLine.getInvInvoiceLinesCreationDate());
        invoiceLine.setDiscount(invInvoiceLine.getInvInvoiceLinesDiscount());
        invoiceLine.setId(invInvoiceLine.getInvInvoiceLinesId());
        invoiceLine.setLineNumber(invInvoiceLine.getInvInvoiceLinesLineNumber());
        invoiceLine.setQuantity(invInvoiceLine.getInvInvoiceLinesQuantity());
        invoiceLine.setTarifPrice(invInvoiceLine.getInvInvoiceLinesTarifPrice());
        invoiceLine.setTotalPriceHT(invInvoiceLine.getInvInvoiceLinesTotalPriceHT());
        invoiceLine.setTotalPriceTTC(invInvoiceLine.getInvInvoiceLinesTotalPriceTTC());
        invoiceLine.setUpdateDate(invInvoiceLine.getInvInvoiceLinesUpdateDate());
        invoiceLine.setVariable1(invInvoiceLine.getInvInvoiceLinesVariable1());
        invoiceLine.setVariable2(invInvoiceLine.getInvInvoiceLinesVariable2());
        invoiceLine.setVariable3(invInvoiceLine.getInvInvoiceLinesVariable3());
        invoiceLine.setVariable4(invInvoiceLine.getInvInvoiceLinesVariable4());
        invoiceLine.setVariable5(invInvoiceLine.getInvInvoiceLinesVariable5());
        invoiceLine.setVariable6(invInvoiceLine.getInvInvoiceLinesVariable6());
        invoiceLine.setVariable7(invInvoiceLine.getInvInvoiceLinesVariable7());
        invoiceLine.setVariable8(invInvoiceLine.getInvInvoiceLinesVariable8());
        invoiceLine.setVariable9(invInvoiceLine.getInvInvoiceLinesVariable9());
        invoiceLine.setVariable10(invInvoiceLine.getInvInvoiceLinesVariable10());
        invoiceLine.setComment(invInvoiceLine.getInvInvoiceLinesComment());
        if (!lazy) {
            invoiceLine.setInvoice(InvoiceMapper.toDto(invInvoiceLine.getInvInvoice(), true));
            invoiceLine.setMovementType(MovementTypeMapper.toDto(invInvoiceLine.getInvMovementType(), true));
            invoiceLine.setOwner(OwnerMapper.toDto(invInvoiceLine.getOwnOwner(), true));
        }
        return invoiceLine;
    }

    public static InvInvoiceLine toEntity(InvoiceLine invoiceLine, boolean lazy) {
        if (null == invoiceLine) {
            return null;
        }
        InvInvoiceLine invInvoiceLine = new InvInvoiceLine();
        invInvoiceLine.setInvInvoice(InvoiceMapper.toEntity(invoiceLine.getInvoice(), true));
        invInvoiceLine.setInvInvoiceLinesCreationDate(invoiceLine.getCreationDate());
        invInvoiceLine.setInvInvoiceLinesDiscount(invoiceLine.getDiscount());
        invInvoiceLine.setInvInvoiceLinesId(invoiceLine.getId());
        invInvoiceLine.setInvInvoiceLinesLineNumber(invoiceLine.getLineNumber());
        invInvoiceLine.setInvInvoiceLinesQuantity(invoiceLine.getQuantity());
        invInvoiceLine.setInvInvoiceLinesTarifPrice(invoiceLine.getTarifPrice());
        invInvoiceLine.setInvInvoiceLinesTotalPriceHT(invoiceLine.getTotalPriceHT());
        invInvoiceLine.setInvInvoiceLinesTotalPriceTTC(invoiceLine.getTotalPriceTTC());
        invInvoiceLine.setInvInvoiceLinesUpdateDate(invoiceLine.getUpdateDate());
        invInvoiceLine.setInvMovementType(MovementTypeMapper.toEntity(invoiceLine.getMovementType(), true));
        invInvoiceLine.setOwnOwner(OwnerMapper.toEntity(invoiceLine.getOwner(), true));
        invInvoiceLine.setInvInvoiceLinesVariable1(invoiceLine.getVariable1());
        invInvoiceLine.setInvInvoiceLinesVariable2(invoiceLine.getVariable2());
        invInvoiceLine.setInvInvoiceLinesVariable3(invoiceLine.getVariable3());
        invInvoiceLine.setInvInvoiceLinesVariable4(invoiceLine.getVariable4());
        invInvoiceLine.setInvInvoiceLinesVariable5(invoiceLine.getVariable5());
        invInvoiceLine.setInvInvoiceLinesVariable6(invoiceLine.getVariable6());
        invInvoiceLine.setInvInvoiceLinesVariable7(invoiceLine.getVariable7());
        invInvoiceLine.setInvInvoiceLinesVariable8(invoiceLine.getVariable8());
        invInvoiceLine.setInvInvoiceLinesVariable9(invoiceLine.getVariable9());
        invInvoiceLine.setInvInvoiceLinesVariable10(invoiceLine.getVariable10());
        invInvoiceLine.setInvInvoiceLinesComment(invoiceLine.getComment());

        return invInvoiceLine;
    }

    public static List<InvoiceLine> toDtos(List<InvInvoiceLine> invInvoiceLines, boolean lazy) {
        if (null == invInvoiceLines) {
            return null;
        }
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        for (InvInvoiceLine invInvoiceLine : invInvoiceLines) {
            invoiceLines.add(toDto(invInvoiceLine, lazy));
        }
        return invoiceLines;
    }

    public static List<InvoiceLine> toDtos(Iterable<InvInvoiceLine> invInvoiceLines, boolean lazy) {
        if (null == invInvoiceLines) {
            return null;
        }
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        for (InvInvoiceLine invInvoiceLine : invInvoiceLines) {
            invoiceLines.add(toDto(invInvoiceLine, lazy));
        }
        return invoiceLines;
    }

    public static Set<InvInvoiceLine> toEntities(Set<InvoiceLine> invoiceLines, boolean lazy) {
        if (null == invoiceLines) {
            return null;
        }
        Set<InvInvoiceLine> invInvoiceLines = new HashSet<>();
        for (InvoiceLine invoiceLine : invoiceLines) {
            invInvoiceLines.add(toEntity(invoiceLine, lazy));
        }
        return invInvoiceLines;
    }

    public static Set<InvoiceLine> toDtos(Set<InvInvoiceLine> invInvoiceLines, boolean lazy) {
        if (null == invInvoiceLines) {
            return null;
        }
        Set<InvoiceLine> invoiceLines = new HashSet<>();
        for (InvInvoiceLine invInvoiceLine : invInvoiceLines) {
            invoiceLines.add(toDto(invInvoiceLine, lazy));
        }
        return invoiceLines;
    }

}

package com.bagile.tms.mapper;

import com.sinno.ems.util.EmsDate;

import java.util.*;

/**
 * Created by Enissay on 05/12/2016.
 */
public class SupplierInvoiceLineMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "invSupplierInvoiceId");
        map.put("number", "invSupplierInvoiceLineNumber");
        map.put("creationDate", "invSupplierInvoiceLineCreationDate");
        map.put("updateDate", "invSupplierInvoiceLineUpdateDate");
        map.put("priceHt", "invSupplierInvoiceLinePriceHt");
        map.put("priceTTC", "invSupplierInvoiceLinePriceTTC");
        map.put("discount", "invSupplierInvoiceLineDiscount");
        map.put("quantity", "invSupplierInvoiceState");
        map.put("invoiceSupplier", "invSupplierInvoiceState");
        map.put("product", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("tarifPrice", "invSupplierInvoiceTarifPrice");
        map.put("vat", "invSupplierInvoiceVat");

    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static InvSupplierInvoiceLine toEntity(SupplierInvoiceLine supplierInvoiceLine, boolean lazy) {
        if (null == supplierInvoiceLine) {
            return null;
        }
        InvSupplierInvoiceLine invSupplierInvoiceLine = new InvSupplierInvoiceLine();
        invSupplierInvoiceLine.setInvSupplierInvoiceLineId(supplierInvoiceLine.getId());
        invSupplierInvoiceLine.setInvSupplierInvoiceLineNumber(supplierInvoiceLine.getNumber());
        invSupplierInvoiceLine.setInvSupplierInvoiceLineCreationDate(supplierInvoiceLine.getCreationDate());
        invSupplierInvoiceLine.setInvSupplierInvoiceLineUpdateDate(supplierInvoiceLine.getUpdateDate());
        invSupplierInvoiceLine.setInvSupplierInvoiceLinePriceHt(supplierInvoiceLine.getTotalPriceHT());
        invSupplierInvoiceLine.setInvSupplierInvoiceLinePriceTTC(supplierInvoiceLine.getTotalPriceTTC());
        invSupplierInvoiceLine.setInvSupplierInvoiceLineDiscount(supplierInvoiceLine.getDiscount());
        invSupplierInvoiceLine.setInvSupplierInvoiceLineTarifPrice(supplierInvoiceLine.getTarifPrice());
        invSupplierInvoiceLine.setInvSupplierInvoiceLineQuantity(supplierInvoiceLine.getQuantity());

        if (!lazy) {
            invSupplierInvoiceLine.setPrmVat(VatMapper.toEntity(supplierInvoiceLine.getVat(), true));
            invSupplierInvoiceLine.setPdtProduct(ProductMapper.toEntity(supplierInvoiceLine.getProduct(), true));
            invSupplierInvoiceLine.setPdtUom(UomMapper.toEntity(supplierInvoiceLine.getUom(), true));
            invSupplierInvoiceLine.setInvSupplierInvoice(SupplierInvoiceMapper.toEntity(supplierInvoiceLine.getSupplierInvoice(), true));
        }
        return invSupplierInvoiceLine;
    }

    public static SupplierInvoiceLine toDto(InvSupplierInvoiceLine invSupplierInvoiceLine, boolean lazy) {
        if (null == invSupplierInvoiceLine) {
            return null;
        }
        SupplierInvoiceLine supplierInvoiceLine = new SupplierInvoiceLine();
        supplierInvoiceLine.setId(invSupplierInvoiceLine.getInvSupplierInvoiceLineId());
        supplierInvoiceLine.setNumber(invSupplierInvoiceLine.getInvSupplierInvoiceLineNumber());
        supplierInvoiceLine.setCreationDate(invSupplierInvoiceLine.getInvSupplierInvoiceLineCreationDate());
        supplierInvoiceLine.setUpdateDate(invSupplierInvoiceLine.getInvSupplierInvoiceLineUpdateDate());
        supplierInvoiceLine.setTotalPriceHT(invSupplierInvoiceLine.getInvSupplierInvoiceLinePriceHt());
        supplierInvoiceLine.setTotalPriceTTC(invSupplierInvoiceLine.getInvSupplierInvoiceLinePriceTTC());
        supplierInvoiceLine.setDiscount(invSupplierInvoiceLine.getInvSupplierInvoiceLineDiscount());
        supplierInvoiceLine.setTarifPrice(invSupplierInvoiceLine.getInvSupplierInvoiceLineTarifPrice());
        supplierInvoiceLine.setQuantity(invSupplierInvoiceLine.getInvSupplierInvoiceLineQuantity());

        if (!lazy) {
            supplierInvoiceLine.setVat(VatMapper.toDto(invSupplierInvoiceLine.getPrmVat(), true));
            supplierInvoiceLine.setProduct(ProductMapper.toDto(invSupplierInvoiceLine.getPdtProduct(), true));
            supplierInvoiceLine.setUom(UomMapper.toDto(invSupplierInvoiceLine.getPdtUom(), true));
            supplierInvoiceLine.setSupplierInvoice(SupplierInvoiceMapper.toDto(invSupplierInvoiceLine.getInvSupplierInvoice(), true));

        }
        return supplierInvoiceLine;
    }

    public static void oneToMany(InvSupplierInvoice invSupplierInvoice) {
        if (null != invSupplierInvoice.getInvSupplierInvoiceLines()) {
            invSupplierInvoice.getInvSupplierInvoiceLines().stream().forEach(sl -> {
                sl.setInvSupplierInvoice(invSupplierInvoice);
                sl.setInvSupplierInvoiceLineUpdateDate(EmsDate.getDateNow());
                if (0 >= sl.getInvSupplierInvoiceLineId()) {
                    sl.setInvSupplierInvoiceLineCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static List<SupplierInvoiceLine> toDtos(List<InvSupplierInvoiceLine> invSupplierInvoiceLines, boolean lazy) {
        if (null == invSupplierInvoiceLines) {
            return null;
        }
        List<SupplierInvoiceLine> supplierInvoiceLines = new ArrayList<>();
        for (InvSupplierInvoiceLine invSupplierInvoiceLine : invSupplierInvoiceLines) {
            supplierInvoiceLines.add(toDto(invSupplierInvoiceLine, lazy));
        }
        return supplierInvoiceLines;
    }

    public static List<SupplierInvoiceLine> toDtos(Iterable<InvSupplierInvoiceLine> invSupplierInvoices, boolean lazy) {
        if (null == invSupplierInvoices) {
            return null;
        }
        List<SupplierInvoiceLine> supplierInvoices = new ArrayList<>();
        for (InvSupplierInvoiceLine invSupplierInvoiceLine : invSupplierInvoices) {
            supplierInvoices.add(toDto(invSupplierInvoiceLine, lazy));
        }
        return supplierInvoices;
    }

    public static Set<InvSupplierInvoiceLine> toEntities(Set<SupplierInvoiceLine> supplierInvoiceLines, boolean lazy) {
        if (null == supplierInvoiceLines) {
            return null;
        }
        Set<InvSupplierInvoiceLine> invSupplierInvoices = new HashSet<>();
        for (SupplierInvoiceLine supplierInvoice : supplierInvoiceLines) {
            invSupplierInvoices.add(toEntity(supplierInvoice, lazy));
        }
        return invSupplierInvoices;
    }

    public static Set<SupplierInvoiceLine> toDtos(Set<InvSupplierInvoiceLine> invSupplierInvoiceLines, boolean lazy) {
        if (null == invSupplierInvoiceLines) {
            return null;
        }
        Set<SupplierInvoiceLine> supplierInvoices = new HashSet<>();
        for (InvSupplierInvoiceLine invSupplierInvoiceLine : invSupplierInvoiceLines) {
            supplierInvoices.add(toDto(invSupplierInvoiceLine, lazy));
        }
        return supplierInvoices;
    }


}

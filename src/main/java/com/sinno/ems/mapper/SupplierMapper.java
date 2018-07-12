package com.sinno.ems.mapper;

import java.util.*;

public class SupplierMapper {
    private SupplierMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "rcpSupplierId");
        map.put("owner", "ownOwner");
        map.put("contact", "prmContact");
        map.put("transport", "trpTransport");
        map.put("code", "rcpSupplierCode");
        map.put("description", "rcpSupplierDescription");
        map.put("comment", "rcpSupplierComment");
        map.put("terms", "rcpSupplierTerms");
        map.put("creationDate", "rcpSupplierCreationDate");
        map.put("updateDate", "rcpSupplierUpdateDate");
        map.put("variable1", "rcpSupplierVariable1");
        map.put("variable2", "rcpSupplierVariable2");
        map.put("variable3", "rcpSupplierVariable3");
        map.put("variable4", "rcpSupplierVariable4");
        map.put("variable5", "rcpSupplierVariable5");
        map.put("variable6", "rcpSupplierVariable6");
        map.put("variable7", "rcpSupplierVariable7");
        map.put("variable8", "rcpSupplierVariable8");
        map.put("variable9", "rcpSupplierVariable9");
        map.put("variable10", "rcpSupplierVariable10");
        map.put("address", "adrAddress");
        map.put("active", "rcpSupplierIsActive");
        map.put("invoiceTerm", "invInvoiceTerm");


    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static RcpSupplier toEntity(Supplier supplier, boolean lazy) {
        if (null == supplier) {
            return null;
        }
        RcpSupplier rcpSupplier = new RcpSupplier();
        rcpSupplier.setRcpSupplierId(supplier.getId());
        rcpSupplier.setRcpSupplierCode(supplier.getCode() != null ? supplier.getCode().toUpperCase() : null);
        rcpSupplier.setRcpSupplierDescription(supplier.getDescription());
        rcpSupplier.setRcpSupplierComment(supplier.getComment());
        rcpSupplier.setRcpSupplierTerms(supplier.getTerms());
        rcpSupplier.setRcpSupplierCreationDate(supplier.getCreationDate());
        rcpSupplier.setRcpSupplierUpdateDate(supplier.getUpdateDate());
        rcpSupplier.setRcpSupplierVariable1(supplier.getVariable1());
        rcpSupplier.setRcpSupplierVariable2(supplier.getVariable2());
        rcpSupplier.setRcpSupplierVariable3(supplier.getVariable3());
        rcpSupplier.setRcpSupplierVariable4(supplier.getVariable4());
        rcpSupplier.setRcpSupplierVariable5(supplier.getVariable5());
        rcpSupplier.setRcpSupplierVariable6(supplier.getVariable6());
        rcpSupplier.setRcpSupplierVariable7(supplier.getVariable7());
        rcpSupplier.setRcpSupplierVariable8(supplier.getVariable8());
        rcpSupplier.setRcpSupplierVariable9(supplier.getVariable9());
        rcpSupplier.setRcpSupplierVariable10(supplier.getVariable10());
        rcpSupplier.setRcpSupplierIsActive(supplier.getActive());
        if (!lazy) {
            rcpSupplier.setOwnOwner(OwnerMapper.toEntity(supplier.getOwner(), true));
            rcpSupplier.setPrmContact(ContactMapper.toEntity(supplier.getContact(), true));
            rcpSupplier.setTrpTransport(TransportMapper.toEntity(supplier.getTransport(), true));
            rcpSupplier.setAdrAddress(AddressMapper.toEntity(supplier.getAddress(), true));
            rcpSupplier.setInvInvoiceTerm(InvoiceTermMapper.toEntity(supplier.getInvoiceTerm(), true));
//            rcpSupplier.setRcpReceptionStockArcs(ReceptionStockArcMapper.toEntities(supplier.getReceptionStockArcs(), true));
//            rcpSupplier.setRcpReceptionStocks(ReceptionStockMapper.toEntities(supplier.getReceptionStocks(), true));
//            rcpSupplier.setRcpReceptionArcs(ReceptionArcMapper.toEntities(supplier.getReceptionArcs(), true));
//            rcpSupplier.setCmdSaleOrderArcs(SaleOrderArcMapper.toEntities(supplier.getSaleOrderArcs(), true));
//            rcpSupplier.setStkStockReserveds(StockReservedMapper.toEntities(supplier.getStockReserveds(), true));
//            rcpSupplier.setPdtProducts(ProductMapper.toEntities(supplier.getProducts(), true));
//            rcpSupplier.setRcpReceptions(ReceptionMapper.toEntities(supplier.getReceptions(), true));
//            rcpSupplier.setCmdSaleOrders(SaleOrderMapper.toEntities(supplier.getSaleOrders(), true));
//            rcpSupplier.setStkStockArcs(StockArcMapper.toEntities(supplier.getStockArcs(), true));
        }
        return rcpSupplier;
    }

    public static Supplier toDto(RcpSupplier rcpSupplier, boolean lazy) {
        if (null == rcpSupplier) {
            return null;
        }
        Supplier supplier = new Supplier();
        supplier.setId(rcpSupplier.getRcpSupplierId());
        supplier.setCode(rcpSupplier.getRcpSupplierCode());
        supplier.setDescription(rcpSupplier.getRcpSupplierDescription());//
        supplier.setComment(rcpSupplier.getRcpSupplierComment());
        supplier.setTerms(rcpSupplier.getRcpSupplierTerms());
        supplier.setCreationDate(rcpSupplier.getRcpSupplierCreationDate());
        supplier.setUpdateDate(rcpSupplier.getRcpSupplierUpdateDate());
        supplier.setVariable1(rcpSupplier.getRcpSupplierVariable1());
        supplier.setVariable2(rcpSupplier.getRcpSupplierVariable2());
        supplier.setVariable3(rcpSupplier.getRcpSupplierVariable3());
        supplier.setVariable4(rcpSupplier.getRcpSupplierVariable4());
        supplier.setVariable5(rcpSupplier.getRcpSupplierVariable5());
        supplier.setVariable6(rcpSupplier.getRcpSupplierVariable6());
        supplier.setVariable7(rcpSupplier.getRcpSupplierVariable7());
        supplier.setVariable8(rcpSupplier.getRcpSupplierVariable8());
        supplier.setVariable9(rcpSupplier.getRcpSupplierVariable9());
        supplier.setVariable10(rcpSupplier.getRcpSupplierVariable10());
        supplier.setActive(rcpSupplier.getRcpSupplierIsActive());
        if (!lazy) {
            supplier.setOwner(OwnerMapper.toDto(rcpSupplier.getOwnOwner(), true));
            supplier.setContact(ContactMapper.toDto(rcpSupplier.getPrmContact(), true));
            supplier.setTransport(TransportMapper.toDto(rcpSupplier.getTrpTransport(), true));
            supplier.setReceptionStockArcs(ReceptionStockArcMapper.toDtos(rcpSupplier.getRcpReceptionStockArcs(), true));
            supplier.setReceptionStocks(ReceptionStockMapper.toDtos(rcpSupplier.getRcpReceptionStocks(), true));
            supplier.setReceptionArcs(ReceptionArcMapper.toDtos(rcpSupplier.getRcpReceptionArcs(), true));
            supplier.setSaleOrderArcs(SaleOrderArcMapper.toDtos(rcpSupplier.getCmdSaleOrderArcs(), true));
            supplier.setStockReserveds(StockReservedMapper.toDtos(rcpSupplier.getStkStockReserveds(), true));
            supplier.setProducts(ProductMapper.toDtos(rcpSupplier.getPdtProducts(), true));
            supplier.setReceptions(ReceptionMapper.toDtos(rcpSupplier.getRcpReceptions(), true));
            supplier.setSaleOrders(SaleOrderMapper.toDtos(rcpSupplier.getCmdSaleOrders(), true));
            supplier.setStockArcs(StockArcMapper.toDtos(rcpSupplier.getStkStockArcs(), true));
            supplier.setAddress(AddressMapper.toDto(rcpSupplier.getAdrAddress(), true));
            supplier.setInvoiceTerm(InvoiceTermMapper.toDto(rcpSupplier.getInvInvoiceTerm(), true));
        }
        return supplier;
    }

    public static List<Supplier> toDtos(List<RcpSupplier> rcpSuppliers, boolean lazy) {
        if (null == rcpSuppliers) {
            return null;
        }
        List<Supplier> suppliers = new ArrayList<>();
        for (RcpSupplier rcpSupplier : rcpSuppliers) {
            suppliers.add(toDto(rcpSupplier, lazy));
        }
        return suppliers;
    }

    public static List<Supplier> toDtos(Iterable<RcpSupplier> rcpSuppliers, boolean lazy) {
        if (null == rcpSuppliers) {
            return null;
        }
        List<Supplier> suppliers = new ArrayList<>();
        for (RcpSupplier rcpSupplier : rcpSuppliers) {
            suppliers.add(toDto(rcpSupplier, lazy));
        }
        return suppliers;
    }

    public static Set<RcpSupplier> toEntities(Set<Supplier> suppliers, boolean lazy) {
        if (null == suppliers) {
            return null;
        }
        Set<RcpSupplier> rcpSuppliers = new HashSet<>();
        for (Supplier supplier : suppliers) {
            rcpSuppliers.add(toEntity(supplier, lazy));
        }
        return rcpSuppliers;
    }

    public static Set<Supplier> toDtos(Set<RcpSupplier> rcpSuppliers, boolean lazy) {
        if (null == rcpSuppliers) {
            return null;
        }
        Set<Supplier> suppliers = new HashSet<>();
        for (RcpSupplier rcpSupplier : rcpSuppliers) {
            suppliers.add(toDto(rcpSupplier, lazy));
        }
        return suppliers;
    }
}

package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Adil on 1/24/2017.
 */
public class SupplierWarrantyMapper {
    private SupplierWarrantyMapper(){}

    private static Map<String, String> map;
    static {
        map = new HashMap<>();
        map.put("id","pdtSupplierWarrantyId");
        map.put("code","pdtSupplierWarrantyCode");
        map.put("product","pdtSupplierWarrantyProduct");
        map.put("serialNumber","pdtSupplierWarrantySerialNumber");
        map.put("beginDate","pdtSupplierWarrantyBeginDate");
        map.put("endDate","pdtSupplierWarrantyEndDate");
        map.put("creationDate","pdtSupplierWarrantyCreation");
        map.put("updateDate","pdtSupplierWarrantyUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static SupplierWarranty toDto(PdtSupplierWarranty pdtSupplierWarranty, boolean lazy){

        if (null == pdtSupplierWarranty) return null;

        SupplierWarranty supplierWarranty = new SupplierWarranty();
        supplierWarranty.setCode(pdtSupplierWarranty.getPdtSupplierWarrantyCode());
        supplierWarranty.setSerialNumber(pdtSupplierWarranty.getPdtSupplierWarrantyProductSerialNumber());
        supplierWarranty.setBeginDate(pdtSupplierWarranty.getPdtSupplierWarrantyBeginDate());
        supplierWarranty.setEndDate(pdtSupplierWarranty.getPdtSupplierWarrantyEndDate());
        supplierWarranty.setCreationDate(pdtSupplierWarranty.getPdtSupplierCreationDate());
        supplierWarranty.setUpdateDate(pdtSupplierWarranty.getPdtSupplierUpdateDate());

        if(!lazy){
            supplierWarranty.setProduct(ProductMapper.toDto(pdtSupplierWarranty.getPdtSupplierWarrantyProduct(), true));
        }

        return supplierWarranty;

    }

    public static PdtSupplierWarranty toEntity(SupplierWarranty supplierWarranty, boolean lazy){

        PdtSupplierWarranty pdtSupplierWarranty = new PdtSupplierWarranty();

        pdtSupplierWarranty.setPdtSupplierWarrantyCode(supplierWarranty.getCode());
        pdtSupplierWarranty.setPdtSupplierWarrantyProductSerialNumber(supplierWarranty.getSerialNumber());
        pdtSupplierWarranty.setPdtSupplierWarrantyBeginDate(supplierWarranty.getBeginDate());
        pdtSupplierWarranty.setPdtSupplierWarrantyEndDate(supplierWarranty.getEndDate());
        pdtSupplierWarranty.setPdtSupplierCreationDate(supplierWarranty.getCreationDate());
        pdtSupplierWarranty.setPdtSupplierUpdateDate(supplierWarranty.getUpdateDate());

        if (!lazy) {
            pdtSupplierWarranty.setPdtSupplierWarrantyProduct(ProductMapper.toEntity(supplierWarranty.getProduct(), true));
        }

        return pdtSupplierWarranty;
    }
    
    
    public static List<SupplierWarranty> toDtos(List<PdtSupplierWarranty> pdtSupplierWarrantys, boolean lazy) {
        if (null == pdtSupplierWarrantys) {
            return null;
        }
        List<SupplierWarranty> suppliers = new ArrayList<>();
        for (PdtSupplierWarranty pdtSupplierWarranty : pdtSupplierWarrantys) {
            suppliers.add(toDto(pdtSupplierWarranty, lazy));
        }
        return suppliers;
    }

    public static List<SupplierWarranty> toDtos(Iterable<PdtSupplierWarranty> pdtSupplierWarrantys, boolean lazy) {
        if (null == pdtSupplierWarrantys) {
            return null;
        }
        List<SupplierWarranty> suppliers = new ArrayList<>();
        for (PdtSupplierWarranty pdtSupplierWarranty : pdtSupplierWarrantys) {
            suppliers.add(toDto(pdtSupplierWarranty, lazy));
        }
        return suppliers;
    }

    public static Set<PdtSupplierWarranty> toEntities(Set<SupplierWarranty> suppliers, boolean lazy) {
        if (null == suppliers) {
            return null;
        }
        Set<PdtSupplierWarranty> pdtSupplierWarrantys = new HashSet<>();
        for (SupplierWarranty supplier : suppliers) {
            pdtSupplierWarrantys.add(toEntity(supplier, lazy));
        }
        return pdtSupplierWarrantys;
    }

    public static Set<SupplierWarranty> toDtos(Set<PdtSupplierWarranty> pdtSupplierWarrantys, boolean lazy) {
        if (null == pdtSupplierWarrantys) {
            return null;
        }
        Set<SupplierWarranty> suppliers = new HashSet<>();
        for (PdtSupplierWarranty pdtSupplierWarranty : pdtSupplierWarrantys) {
            suppliers.add(toDto(pdtSupplierWarranty, lazy));
        }
        return suppliers;
    }
}

package com.sinno.ems.mapper;

import com.sinno.ems.dto.ProductSupplier;

import java.util.*;

/**
 * Created by Enissay on 24/01/2017.
 */
public class ProductSupplierMapper {
    private ProductSupplierMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "pdtProductSupplierId");
        map.put("price", "pdtProductSupplierPrice");
        map.put("product", "pdtProduct");
        map.put("supplier", "rcpSupplier");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static ProductSupplier toDto(PdtProductSupplier pdtProductSupplier, boolean lazy) {
        if (null == pdtProductSupplier) {
            return null;
        }
        ProductSupplier productSupplier = new ProductSupplier();
        productSupplier.setId(pdtProductSupplier.getPdtProductSupplierId());
        productSupplier.setPrice(pdtProductSupplier.getPdtProductSupplierPrice());
        if (!lazy) {
            productSupplier.setSupplier(SupplierMapper.toDto(pdtProductSupplier.getRcpSupplier(), true));
            productSupplier.setProduct(ProductMapper.toDto(pdtProductSupplier.getPdtProduct(), true));
        }
        return productSupplier;
    }

    public static PdtProductSupplier toEntity(ProductSupplier productSupplier, boolean lazy) {
        if (null == productSupplier) {
            return null;
        }
        PdtProductSupplier pdtProductSupplier = new PdtProductSupplier();
        pdtProductSupplier.setPdtProductSupplierId(productSupplier.getId());
        pdtProductSupplier.setPdtProductSupplierPrice(productSupplier.getPrice());
        if (!lazy) {
            pdtProductSupplier.setPdtProduct(ProductMapper.toEntity(productSupplier.getProduct(), true));
            pdtProductSupplier.setRcpSupplier(SupplierMapper.toEntity(productSupplier.getSupplier(), true));
        }
        return pdtProductSupplier;
    }

    public static List<ProductSupplier> toDtos(List<PdtProductSupplier> pdtProductSuppliers, boolean lazy) {
        if (null == pdtProductSuppliers) {
            return null;
        }
        List<ProductSupplier> productSuppliers = new ArrayList<>();
        for (PdtProductSupplier pdtProductSupplier : pdtProductSuppliers) {
            productSuppliers.add(toDto(pdtProductSupplier, lazy));
        }
        return productSuppliers;
    }

    public static List<ProductSupplier> toDtos(Iterable<PdtProductSupplier> pdtProductSuppliers, boolean lazy) {
        if (null == pdtProductSuppliers) {
            return null;
        }
        List<ProductSupplier> productSuppliers = new ArrayList<>();
        for (PdtProductSupplier pdtProductSupplier : pdtProductSuppliers) {
            productSuppliers.add(toDto(pdtProductSupplier, lazy));
        }
        return productSuppliers;
    }

    public static Set<PdtProductSupplier> toEntities(Set<ProductSupplier> productSuppliers, boolean lazy) {
        if (null == productSuppliers) {
            return null;
        }
        Set<PdtProductSupplier> pdtProductSuppliers = new HashSet<>();
        for (ProductSupplier productSupplier : productSuppliers) {
            pdtProductSuppliers.add(toEntity(productSupplier, lazy));
        }
        return pdtProductSuppliers;
    }

    public static Set<ProductSupplier> toDtos(Set<PdtProductSupplier> pdtProductSuppliers, boolean lazy) {
        if (null == pdtProductSuppliers) {
            return null;
        }
        Set<ProductSupplier> productSuppliers = new HashSet<>();
        for (PdtProductSupplier pdtProductSupplier : pdtProductSuppliers) {
            productSuppliers.add(toDto(pdtProductSupplier, lazy));
        }
        return productSuppliers;
    }

}

package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.ProductType;
import com.bagile.gmo.entities.PdtProductType;

import java.util.*;

public class ProductTypeMapper {
    private ProductTypeMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "pdtProductTypeId");
        map.put("owner", "ownOwner");
        map.put("productType", "pdtProductTypeParent");
        map.put("code", "pdtProductTypeCode");
        map.put("description", "pdtProductTypeDescription");
        map.put("creationDate", "pdtProductTypeCreationDate");
        map.put("updateDate", "pdtProductTypeUpdateDate");
        map.put("gmao", "pdtProductTypeGmao");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PdtProductType toEntity(ProductType productType, boolean lazy) {
        if (null == productType) {
            return null;
        }
        PdtProductType pdtProductType = new PdtProductType();
        pdtProductType.setPdtProductTypeId(productType.getId());
        pdtProductType.setPdtProductTypeCode(productType.getCode() != null ? productType.getCode().toUpperCase() : null);
        pdtProductType.setPdtProductTypeDescription(productType.getDescription());
        pdtProductType.setPdtProductTypeCreationDate(productType.getCreationDate());
        pdtProductType.setPdtProductTypeUpdateDate(productType.getUpdateDate());
        pdtProductType.setPdtProductTypeGmao(productType.getGmao());

        if (!lazy) {
            pdtProductType.setPdtProductTypeParent(toEntity(productType.getProductType(), true));
            pdtProductType.setOwnOwner(OwnerMapper.toEntity(productType.getOwner(), true));
//            pdtProductType.setPdtProductTypes(toEntities(productType.getProductTypes(), true));
//            pdtProductType
//                    .setPdtProductsForPdtProductTypeId(ProductMapper.toEntities(productType.getProductsForProductType(), true));
//            pdtProductType.setPdtProductsForPdtProductSubTypeId(
//                    ProductMapper.toEntities(productType.getProductsForProductSubType(), true));
        }
        return pdtProductType;
    }

    public static ProductType toDto(PdtProductType pdtProductType, boolean lazy) {
        if (null == pdtProductType) {
            return null;
        }
        ProductType productType = new ProductType();
        productType.setId(pdtProductType.getPdtProductTypeId());
        productType.setCode(pdtProductType.getPdtProductTypeCode());
        productType.setDescription(pdtProductType.getPdtProductTypeDescription());
        productType.setCreationDate(pdtProductType.getPdtProductTypeCreationDate());
        productType.setUpdateDate(pdtProductType.getPdtProductTypeUpdateDate());
        productType.setGmao(pdtProductType.getPdtProductTypeGmao());

        if (!lazy) {
            productType.setProductType(toDto(pdtProductType.getPdtProductTypeParent(), true));
            productType.setOwner(OwnerMapper.toDto(pdtProductType.getOwnOwner(), true));
//            productType.setProductTypes(toDtos(pdtProductType.getPdtProductTypes(), true));
//            productType.setProductsForProductType(ProductMapper.toDtos(pdtProductType.getPdtProductsForPdtProductTypeId(), true));
//            productType.setProductsForProductSubType(
//                    ProductMapper.toDtos(pdtProductType.getPdtProductsForPdtProductSubTypeId(), true));
        }
        return productType;
    }


    public static List<ProductType> toDtos(Iterable<? extends PdtProductType> pdtProductTypes, boolean lazy) {
        if (null == pdtProductTypes) {
            return null;
        }
        List<ProductType> productTypes = new ArrayList<>();
        for (PdtProductType pdtProductType : pdtProductTypes) {
            productTypes.add(toDto(pdtProductType, lazy));
        }
        return productTypes;
    }

    public static Set<PdtProductType> toEntities(Set<ProductType> productTypes, boolean lazy) {
        if (null == productTypes) {
            return null;
        }
        Set<PdtProductType> pdtProductTypes = new HashSet<>();
        for (ProductType productType : productTypes) {
            pdtProductTypes.add(toEntity(productType, lazy));
        }
        return pdtProductTypes;
    }

    public static Set<ProductType> toDtos(Set<PdtProductType> pdtProductTypes, boolean lazy) {
        if (null == pdtProductTypes) {
            return null;
        }
        Set<ProductType> productTypes = new HashSet<>();
        for (PdtProductType pdtProductType : pdtProductTypes) {
            productTypes.add(toDto(pdtProductType, lazy));
        }
        return productTypes;
    }
}

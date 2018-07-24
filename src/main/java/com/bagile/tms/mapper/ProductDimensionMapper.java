package com.bagile.tms.mapper;

import com.sinno.ems.dto.ProductDimension;
import com.sinno.ems.entities.PdtProductDimension;

import java.util.*;

/**
 * Created by Enissay on 15/03/2017.
 */
public class ProductDimensionMapper {

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "pdtProductDimensionId");
        map.put("product", "pdtProduct");
        map.put("width", "pdtProductDimensionWidth");
        map.put("height", "pdtProductDimensionHeight");
        map.put("depth", "pdtProductDimensionDepth");
        map.put("price", "pdtProductDimensionPrice");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static ProductDimension toDto(PdtProductDimension pdtProductDimension, boolean lazy) {
        if (null == pdtProductDimension) {
            return null;
        }
        ProductDimension productDimension = new ProductDimension();
        productDimension.setId(pdtProductDimension.getPdtProductDimensionId());
        productDimension.setCreationDate(pdtProductDimension.getPdtProductDimensionCreationDate());
        productDimension.setUpdateDate(pdtProductDimension.getPdtProductDimensionUpdateDate());
        productDimension.setDepth(pdtProductDimension.getPdtProductDimensionDepth());
        productDimension.setHeight(pdtProductDimension.getPdtProductDimensionHeight());
        productDimension.setWidth(pdtProductDimension.getPdtProductDimensionWidth());
        productDimension.setPrice(pdtProductDimension.getPdtProductDimensionPrice());
        if(!lazy){
            productDimension.setProduct(ProductMapper.toDto(pdtProductDimension.getPdtProduct(),true));
        }
        return productDimension;
    }

    public static PdtProductDimension toEntity(ProductDimension productDimension, boolean lazy) {
        if (null == productDimension) {
            return null;
        }
        PdtProductDimension pdtProductDimension = new PdtProductDimension();
        pdtProductDimension.setPdtProductDimensionId(productDimension.getId());
        pdtProductDimension.setPdtProductDimensionCreationDate(productDimension.getCreationDate());
        pdtProductDimension.setPdtProductDimensionUpdateDate(productDimension.getUpdateDate());
        pdtProductDimension.setPdtProductDimensionDepth(productDimension.getDepth());
        pdtProductDimension.setPdtProductDimensionHeight(productDimension.getHeight());
        pdtProductDimension.setPdtProductDimensionWidth(productDimension.getWidth());
        pdtProductDimension.setPdtProductDimensionPrice(productDimension.getPrice());

        if (!lazy) {
            pdtProductDimension.setPdtProduct(ProductMapper.toEntity(productDimension.getProduct(), true));
        }
        return pdtProductDimension;
    }

    public static List<ProductDimension> toDtos(List<PdtProductDimension> pdtProductDimensions, boolean lazy) {
        if (null == pdtProductDimensions) {
            return null;
        }
        List<ProductDimension> productDimensions = new ArrayList<>();
        for (PdtProductDimension pdtProductDimension : pdtProductDimensions) {
            productDimensions.add(toDto(pdtProductDimension, lazy));
        }
        return productDimensions;
    }

    public static List<ProductDimension> toDtos(Iterable<PdtProductDimension> pdtProductDimensions, boolean lazy) {
        if (null == pdtProductDimensions) {
            return null;
        }
        List<ProductDimension> productDimensions = new ArrayList<>();
        for (PdtProductDimension pdtProductDimension : pdtProductDimensions) {
            productDimensions.add(toDto(pdtProductDimension, lazy));
        }
        return productDimensions;
    }

    public static Set<PdtProductDimension> toEntities(Set<ProductDimension> productDimensions, boolean lazy) {
        if (null == productDimensions) {
            return null;
        }
        Set<PdtProductDimension> pdtProductDimensions = new HashSet<>();
        for (ProductDimension productDimension : productDimensions) {
            pdtProductDimensions.add(toEntity(productDimension, lazy));
        }
        return pdtProductDimensions;
    }

    public static Set<ProductDimension> toDtos(Set<PdtProductDimension> pdtProductDimensions, boolean lazy) {
        if (null == pdtProductDimensions) {
            return null;
        }
        Set<ProductDimension> productDimensions = new HashSet<>();
        for (PdtProductDimension pdtProductDimension : pdtProductDimensions) {
            productDimensions.add(toDto(pdtProductDimension, lazy));
        }
        return productDimensions;
    }
}

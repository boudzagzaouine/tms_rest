package com.bagile.tms.mapper;

import com.bagile.tms.dto.ProductPack;
import com.bagile.tms.entities.PdtProductPack;

import java.util.*;

public class ProductPackMapper {
    private ProductPackMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "pdtProductPackId");
        map.put("packId", "pdtProductPackId");
        map.put("owner", "ownOwner");
        map.put("alias", "pdtAlias");
        map.put("product", "pdtProduct");
        map.put("uom", "pdtUom");
        map.put("weight", "pdtProductPackWeight");
        map.put("size", "pdtProductPackSize");
        map.put("height", "pdtProductPackHeight");
        map.put("lenght", "pdtProductPackLenght");
        map.put("depth", "pdtProductPackDepth");
        map.put("creationDate", "pdtProductPackCreationDate");
        map.put("updateDate", "pdtProductPackUpdateDate");
        map.put("salePrice", "pdtProductPackSalePrice");
        map.put("purshasePrice", "pdtProductPackPurshasePrice");
        map.put("quantity", "pdtProductPackQuantity");
        map.put("typePck", "pdtProductPackTypePck");
        map.put("width", "pdtProductPackWdith");
        map.put("weightControl", "pdtProductPackWeightControl");
        map.put("currency", "prmCurrency");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PdtProductPack toEntity(ProductPack productPack, boolean lazy) {
        if (null == productPack) {
            return null;
        }
        PdtProductPack pdtProductPack = new PdtProductPack();
        pdtProductPack.setPdtProductPackId(productPack.getId());
        pdtProductPack.setPdtProductPackWeight(productPack.getWeight());
        pdtProductPack.setPdtProductPackSize(productPack.getSize());
        pdtProductPack.setPdtProductPackLenght(productPack.getLenght());
        pdtProductPack.setPdtProductPackHeight(productPack.getHeight());
        pdtProductPack.setPdtProductPackDepth(productPack.getDepth());
        pdtProductPack.setPdtProductPackCreationDate(productPack.getCreationDate());
        pdtProductPack.setPdtProductPackUpdateDate(productPack.getUpdateDate());
        pdtProductPack.setPdtProductQuantity(productPack.getQuantity());
        pdtProductPack.setPdtProductSalePrice(productPack.getSalePrice());
        pdtProductPack.setPdtProductPurshasePrice(productPack.getPurshasePrice());
        pdtProductPack.setPdtProductPackTypePck(productPack.getTypePck());
        pdtProductPack.setPdtProductPackWidth(productPack.getWidth());
        pdtProductPack.setPdtProductPackWeightControl(productPack.getWeightControl());
        if (!lazy) {
            pdtProductPack.setPdtProduct(ProductMapper.toEntity(productPack.getProduct(), true));
            pdtProductPack.setPdtAlias(AliasMapper.toEntity(productPack.getAlias(), true));
            pdtProductPack.setOwnOwner(OwnerMapper.toEntity(productPack.getOwner(), true));
            pdtProductPack.setPdtUom(UomMapper.toEntity(productPack.getUom(), true));
        }
        return pdtProductPack;
    }

    public static ProductPack toDto(PdtProductPack pdtProductPack, boolean lazy) {
        if (null == pdtProductPack) {
            return null;
        }
        ProductPack productPack = new ProductPack();
        productPack.setId(pdtProductPack.getPdtProductPackId());
        productPack.setWeight(pdtProductPack.getPdtProductPackWeight());
        productPack.setSize(pdtProductPack.getPdtProductPackSize());
        productPack.setHeight(pdtProductPack.getPdtProductPackHeight());
        productPack.setLenght(pdtProductPack.getPdtProductPackLenght());
        productPack.setDepth(pdtProductPack.getPdtProductPackDepth());
        productPack.setCreationDate(pdtProductPack.getPdtProductPackCreationDate());
        productPack.setUpdateDate(pdtProductPack.getPdtProductPackUpdateDate());
        productPack.setTypePck(pdtProductPack.getPdtProductPackTypePck());
        productPack.setSalePrice(pdtProductPack.getPdtProductSalePrice());
        productPack.setQuantity(pdtProductPack.getPdtProductQuantity());
        productPack.setWidth(pdtProductPack.getPdtProductPackWidth());
        productPack.setWeightControl(pdtProductPack.getPdtProductPackWeightControl());
        productPack.setPurshasePrice(pdtProductPack.getPdtProductPurshasePrice());
        if (!lazy) {
            productPack.setProduct(ProductMapper.toDto(pdtProductPack.getPdtProduct(), true));
            productPack.setAlias(AliasMapper.toDto(pdtProductPack.getPdtAlias(), true));
            productPack.setOwner(OwnerMapper.toDto(pdtProductPack.getOwnOwner(), true));
            productPack.setUom(UomMapper.toDto(pdtProductPack.getPdtUom(), true));
        }
        return productPack;
    }

    public static List<ProductPack> toDtos(List<PdtProductPack> pdtProductPacks, boolean lazy) {
        if (null == pdtProductPacks) {
            return null;
        }
        List<ProductPack> productPacks = new ArrayList<>();
        for (PdtProductPack pdtProductPack : pdtProductPacks) {
            productPacks.add(toDto(pdtProductPack, lazy));
        }
        return productPacks;
    }

    public static List<ProductPack> toDtos(Iterable<PdtProductPack> pdtProductPacks, boolean lazy) {
        if (null == pdtProductPacks) {
            return null;
        }
        List<ProductPack> productPacks = new ArrayList<>();
        for (PdtProductPack pdtProductPack : pdtProductPacks) {
            productPacks.add(toDto(pdtProductPack, lazy));
        }
        return productPacks;
    }

    public static Set<PdtProductPack> toEntities(Set<ProductPack> productPacks, boolean lazy) {
        if (null == productPacks) {
            return null;
        }
        Set<PdtProductPack> pdtProductPacks = new HashSet<>();
        for (ProductPack productPack : productPacks) {
            pdtProductPacks.add(toEntity(productPack, lazy));
        }
        return pdtProductPacks;
    }

    public static Set<ProductPack> toDtos(Set<PdtProductPack> pdtProductPacks, boolean lazy) {
        if (null == pdtProductPacks) {
            return null;
        }
        Set<ProductPack> productPacks = new HashSet<>();
        for (PdtProductPack pdtProductPack : pdtProductPacks) {
            productPacks.add(toDto(pdtProductPack, lazy));
        }
        return productPacks;
    }
}

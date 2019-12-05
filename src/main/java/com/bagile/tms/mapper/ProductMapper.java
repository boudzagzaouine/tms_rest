package com.bagile.tms.mapper;


import com.bagile.tms.dto.Product;
import com.bagile.tms.entities.PdtProduct;
import com.bagile.tms.util.EmsDate;

import java.util.*;

public class ProductMapper {
    private ProductMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "pdtProductId");
        map.put("location", "locLocation");
        map.put("owner", "ownOwner");
        map.put("productType", "pdtProductTypeByPdtProductTypeId");
        map.put("productSubType", "pdtProductTypeByPdtProductSubTypeId");
        map.put("uomByProductUomSale", "pdtUomByPdtProductUomSaleId");
        map.put("uomByProductUomBase", "pdtUomByPdtProductUomBaseId");
        map.put("uomByProductUomPurshase", "pdtUomByPdtProductUomPurshaseId");
        map.put("blockType", "prmBlockType");
        map.put("images", "prmImages");
        map.put("supplier", "rcpSupplier");
        map.put("warehouse", "wrhWarehouse");
        map.put("code", "pdtProductCode");
        map.put("alias", "pdtAlias");
        map.put("priceUB", "pdtPriceUB");
        map.put("suppOfLife", "pdtSuppOfLife");
        map.put("raisonToOut", "pdtRaisonToOut");
        map.put("productRotation", "pdtProductRotation");
        map.put("dlcControl", "pdtProductDlcControl");
        map.put("dluoControl", "pdtProductDluoControl");
        map.put("serialNoControl", "pdtProductSerialNoControl");
        map.put("lotControl", "pdtProductLotControl");
        map.put("colorControl", "pdtProductColorControl");
        map.put("desc", "pdtProductDesc");
        map.put("descSecondLanguage", "pdtProductDescSecondLanguage");
        map.put("shortDesc", "pdtProductShortDesc");
        map.put("daysOfLife", "pdtProductDaysOfLife");
        map.put("containerStack", "pdtProductContainerStack");
        map.put("pickMessage", "pdtProductPickMessage");
        map.put("manipulationDesc", "pdtProductManipulationDesc");
        map.put("minTemp", "pdtProductMinTemp");
        map.put("maxTemp", "pdtProductMaxTemp");
        map.put("maxStock", "pdtProductMaxStock");
        map.put("minStock", "pdtProductMinStock");
        map.put("manipulationPrice", "pdtProductManipulationPrice");
        map.put("pickingPrice", "pdtProductPickingPrice");
        map.put("expeditionPrice", "pdtProductExpeditionPrice");
        map.put("conditionningPrice", "pdtProductConditionningPrice");
        map.put("paletConditionning", "pdtProductPaletConditionning");
        map.put("active", "pdtProductIsActive");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("updatedBy", "updatedBy");
        map.put("createdBy", "createdBy");
        map.put("variable1", "pdtProductVariable1");
        map.put("variable2", "pdtProductVariable2");
        map.put("variable3", "pdtProductVariable3");
        map.put("variable4", "pdtProductVariable4");
        map.put("variable5", "pdtProductVariable5");
        map.put("variable6", "pdtProductVariable6");
        map.put("variable7", "pdtProductVariable7");
        map.put("variable8", "pdtProductVariable8");
        map.put("variable9", "pdtProductVariable9");
        map.put("variable10", "pdtProductVariable10");
        map.put("kit", "pdtProductIsKit");
        map.put("qualityOfControl", "pdtProductQualityOfControl");
        map.put("samplingPercentage", "pdtProductSamplingPercentage");
        map.put("productpack", "pdtProductPack");
        map.put("pickingLocation", "pickingLocLocation");
        map.put("pickingUom", "pickingPdtUom");
        map.put("minimalThreshold", "pdtMinimalThreshold");
        map.put("capacity", "pdtCapacity");
        map.put("controlWeight", "pdtProductControlWeight");
        map.put("aliases", "pdtAliases");
        map.put("kitProductPack", "pdtKitProductPack");
        map.put("alternativeProducts","pdtAlternativeProducts");
        map.put("productPreparationLogic","productPreparationLogic");

    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PdtProduct toEntity(Product product, boolean lazy) {
        if (null == product) {
            return null;
        }
        PdtProduct pdtProduct = new PdtProduct();
        pdtProduct.setPdtProductId(product.getId());
        pdtProduct.setPdtProductCode(product.getCode());
        pdtProduct.setPdtProductDlcControl(product.getDlcControl());
        pdtProduct.setPdtProductDluoControl(product.getDluoControl());
        pdtProduct.setPdtProductSerialNoControl(product.getSerialNoControl());
        pdtProduct.setPdtProductLotControl(product.getLotControl());
        pdtProduct.setPdtProductColorControl(product.getColorControl());
        pdtProduct.setPdtProductDesc(product.getDesc());
        pdtProduct.setPdtProductShortDesc(product.getShortDesc());
        pdtProduct.setPdtProductDaysOfLife(product.getDaysOfLife());
        pdtProduct.setPdtProductContainerStack(product.getContainerStack());
        pdtProduct.setPdtProductPickMessage(product.getPickMessage());
        pdtProduct.setPdtProductManipulationDesc(product.getManipulationDesc());
        pdtProduct.setPdtProductMinTemp(product.getMinTemp());
        pdtProduct.setPdtProductMaxTemp(product.getMaxTemp());
        pdtProduct.setPdtProductMaxStock(product.getMaxStock());
        pdtProduct.setPdtProductMinStock(product.getMinStock());
        pdtProduct.setPdtProductManipulationPrice(product.getManipulationPrice());
        pdtProduct.setPdtProductPickingPrice(product.getPickingPrice());
        pdtProduct.setPdtProductExpeditionPrice(product.getExpeditionPrice());
        pdtProduct.setPdtProductConditionningPrice(product.getConditionningPrice());
        pdtProduct.setPdtProductPaletConditionning(product.getPaletConditionning());
        pdtProduct.setPdtProductIsActive(product.getActive());
        pdtProduct.setPdtProductCreationDate(product.getCreationDate());
        pdtProduct.setPdtProductUpdateDate(product.getUpdateDate());
        pdtProduct.setPdtProductVariable1(product.getVariable1());
        pdtProduct.setPdtProductVariable2(product.getVariable2());
        pdtProduct.setPdtProductVariable3(product.getVariable3());
        pdtProduct.setPdtProductVariable4(product.getVariable4());
        pdtProduct.setPdtProductVariable5(product.getVariable5());
        pdtProduct.setPdtProductVariable6(product.getVariable6());
        pdtProduct.setPdtProductVariable7(product.getVariable7());
        pdtProduct.setPdtProductVariable8(product.getVariable8());
        pdtProduct.setPdtProductVariable9(product.getVariable9());
        pdtProduct.setPdtProductVariable10(product.getVariable10());
        pdtProduct.setPdtProductIsKit(product.getKit());
        pdtProduct.setPdtProductRaisonToOut(product.getRaisonToOut());
        pdtProduct.setPdtProductSuppOfLife(product.getSuppOfLife());
        pdtProduct.setPdtProductPriceUB(product.getPriceUB());
        pdtProduct.setPdtProductQualityOfControl(product.getQualityOfControl());
        pdtProduct.setPdtCapacity(product.getCapacity());
        pdtProduct.setPdtMinimalThreshold(product.getMinimalThreshold());
        pdtProduct.setPdtIsReception(product.getReception());
        pdtProduct.setPdtProductReqExp(product.getReqExp());
        pdtProduct.setPdtProductReqRec(product.getReqRec());
        pdtProduct.setPdtProductControlWeight(product.getWeightControl());
        pdtProduct.setUpdateDate (product.getUpdateDate ());
        pdtProduct.setCreationDate (product.getCreationDate ());
        pdtProduct.setUpdatedBy (product.getUpdatedBy ());
        pdtProduct.setCreatedBy (product.getCreatedBy ());

        if (!lazy) {
            pdtProduct.setPdtProductPack(ProductPackMapper.toEntity(product.getProductPack(), true));
            pdtProduct.setPickingPdtUom(UomMapper.toEntity(product.getPickingUom(), true));
            pdtProduct.setOwnOwner(OwnerMapper.toEntity(product.getOwner(), true));
            pdtProduct.setPdtProductTypeByPdtProductTypeId(ProductTypeMapper.toEntity(product.getProductType(), true));
            pdtProduct.setPdtProductTypeByPdtProductSubTypeId(ProductTypeMapper.toEntity(product.getProductSubType(), true));
            pdtProduct.setRcpSupplier(SupplierMapper.toEntity(product.getSupplier(), true));
            pdtProduct.setPdtUomByPdtProductUomBaseId(UomMapper.toEntity(product.getUomByProductUomBase(), true));
            pdtProduct.setPdtUomByPdtProductUomPurshaseId(UomMapper.toEntity(product.getUomByProductUomPurshase(), true));
            pdtProduct.setPdtUomByPdtProductUomSaleId(UomMapper.toEntity(product.getUomByProductUomSale(), true));
            pdtProduct.setWrhWarehouse(WarehouseMapper.toEntity(product.getWarehouse(), true));
            pdtProduct.setPdtProductPacks(ProductPackMapper.toEntities(product.getProductPacks(), false));
            pdtProduct.setPdtKitProductPack(ProductPackMapper.toEntity(product.getKitProductPack(), false));
            oneToMany(pdtProduct);
        }
        return pdtProduct;
    }

    public static void oneToMany(PdtProduct pdtProduct) {
        if (null != pdtProduct.getPdtProductPacks()) {
            pdtProduct.getPdtProductPacks().forEach(il -> {
                il.setPdtProduct(pdtProduct);
                il.setOwnOwner(pdtProduct.getOwnOwner());
                if (0 >= il.getPdtProductPackId()) {
                    il.setPdtProductPackCreationDate(EmsDate.getDateNow());
                }
            });
        }
    }

    public static Product toDto(PdtProduct pdtProduct, boolean lazy) {
        if (null == pdtProduct) {
            return null;
        }
        Product product = new Product();
        product.setId(pdtProduct.getPdtProductId());
        product.setCode(pdtProduct.getPdtProductCode());
        product.setSupplier(SupplierMapper.toDto(pdtProduct.getRcpSupplier(), true));
        product.setDlcControl(pdtProduct.getPdtProductDlcControl());
        product.setDluoControl(pdtProduct.getPdtProductDluoControl());
        product.setSerialNoControl(pdtProduct.getPdtProductSerialNoControl());
        product.setLotControl(pdtProduct.getPdtProductLotControl());
        product.setColorControl(pdtProduct.getPdtProductColorControl());
        product.setDesc(pdtProduct.getPdtProductDesc());
        product.setShortDesc(pdtProduct.getPdtProductShortDesc());
        product.setDaysOfLife(pdtProduct.getPdtProductDaysOfLife());
        product.setContainerStack(pdtProduct.getPdtProductContainerStack());
        product.setManipulationDesc(pdtProduct.getPdtProductManipulationDesc());
        product.setMinTemp(pdtProduct.getPdtProductMinTemp());
        product.setMaxTemp(pdtProduct.getPdtProductMaxTemp());
        product.setPickMessage(pdtProduct.getPdtProductPickMessage());
        product.setMaxStock(pdtProduct.getPdtProductMaxStock());
        product.setMinStock(pdtProduct.getPdtProductMinStock());
        product.setPaletConditionning(pdtProduct.getPdtProductPaletConditionning());
        product.setManipulationPrice(pdtProduct.getPdtProductManipulationPrice());
        product.setPickingPrice(pdtProduct.getPdtProductPickingPrice());
        product.setExpeditionPrice(pdtProduct.getPdtProductExpeditionPrice());
        product.setConditionningPrice(pdtProduct.getPdtProductConditionningPrice());
        product.setActive(pdtProduct.getPdtProductIsActive());
        product.setCreationDate(pdtProduct.getPdtProductCreationDate());
        product.setUpdateDate(pdtProduct.getPdtProductUpdateDate());
        product.setVariable1(pdtProduct.getPdtProductVariable1());
        product.setVariable2(pdtProduct.getPdtProductVariable2());
        product.setVariable3(pdtProduct.getPdtProductVariable3());
        product.setVariable4(pdtProduct.getPdtProductVariable4());
        product.setVariable5(pdtProduct.getPdtProductVariable5());
        product.setVariable6(pdtProduct.getPdtProductVariable6());
        product.setVariable7(pdtProduct.getPdtProductVariable7());
        product.setVariable8(pdtProduct.getPdtProductVariable8());
        product.setVariable9(pdtProduct.getPdtProductVariable9());
        product.setVariable10(pdtProduct.getPdtProductVariable10());
        product.setKit(pdtProduct.getPdtProductIsKit());
        product.setPriceUB(pdtProduct.getPdtProductPriceUB());
        product.setRaisonToOut(pdtProduct.getPdtProductRaisonToOut());
        product.setSuppOfLife(pdtProduct.getPdtProductSuppOfLife());
        product.setQualityOfControl(pdtProduct.getPdtProductQualityOfControl());
        product.setSamplingPercentage(pdtProduct.getPdtProductSamplingPercentage());
        product.setCapacity(pdtProduct.getPdtCapacity());
        product.setReception(pdtProduct.getPdtIsReception());
        product.setMinimalThreshold(pdtProduct.getPdtMinimalThreshold());
        product.setReqExp(pdtProduct.getPdtProductReqExp());
        product.setReqRec(pdtProduct.getPdtProductReqRec());
        product.setWeightControl(pdtProduct.getPdtProductControlWeight());
        product.setUpdateDate (pdtProduct.getUpdateDate ());
        product.setCreationDate (pdtProduct.getCreationDate ());
        product.setUpdatedBy (pdtProduct.getUpdatedBy ());
        product.setCreatedBy (pdtProduct.getCreatedBy ());
        if (!lazy) {
            product.setProductPack(ProductPackMapper.toDto(pdtProduct.getPdtProductPack(), true));
            product.setKitProductPack(ProductPackMapper.toDto(pdtProduct.getPdtKitProductPack(), true));
            product.setPickingUom(UomMapper.toDto(pdtProduct.getPickingPdtUom(), true));
            product.setOwner(OwnerMapper.toDto(pdtProduct.getOwnOwner(), true));
            product.setProductType(ProductTypeMapper.toDto(pdtProduct.getPdtProductTypeByPdtProductTypeId(), true));
            product.setProductSubType(ProductTypeMapper.toDto(pdtProduct.getPdtProductTypeByPdtProductSubTypeId(), true));
            product.setUomByProductUomBase(UomMapper.toDto(pdtProduct.getPdtUomByPdtProductUomBaseId(), true));
            product.setUomByProductUomPurshase(UomMapper.toDto(pdtProduct.getPdtUomByPdtProductUomPurshaseId(), true));
            product.setUomByProductUomSale(UomMapper.toDto(pdtProduct.getPdtUomByPdtProductUomSaleId(), true));
            product.setWarehouse(WarehouseMapper.toDto(pdtProduct.getWrhWarehouse(), true));
            product.setProductPacks(ProductPackMapper.toDtos(pdtProduct.getPdtProductPacks(), false));
        }
        return product;
    }

    public static List<Product> toDtos(List<PdtProduct> pdtProducts, boolean lazy) {
        if (null == pdtProducts) {
            return null;
        }
        List<Product> products = new ArrayList<>();
        for (PdtProduct pdtProduct : pdtProducts) {
            products.add(toDto(pdtProduct, lazy));
        }
        return products;
    }

    public static List<Product> toDtos(Iterable<PdtProduct> pdtProducts, boolean lazy) {
        if (null == pdtProducts) {
            return null;
        }
        List<Product> products = new ArrayList<>();
        for (PdtProduct pdtProduct : pdtProducts) {
            products.add(toDto(pdtProduct, lazy));
        }
        return products;
    }

    public static Set<PdtProduct> toEntities(Set<Product> products, boolean lazy) {
        if (null == products) {
            return null;
        }
        Set<PdtProduct> pdtProducts = new HashSet<>();
        for (Product product : products) {
            pdtProducts.add(toEntity(product, lazy));
        }
        return pdtProducts;
    }

    public static Set<Product> toDtos(Set<PdtProduct> pdtProducts, boolean lazy) {
        if (null == pdtProducts) {
            return null;
        }
        Set<Product> products = new HashSet<>();
        for (PdtProduct pdtProduct : pdtProducts) {
            products.add(toDto(pdtProduct, lazy));
        }
        return products;
    }
}

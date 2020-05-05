package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Product;
import com.bagile.gmo.entities.PdtProduct;

import java.util.*;

public class ProductMapper {
    private ProductMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ();
        map.put("id", "pdtProductId");
        map.put("location", "locLocation");
        map.put("owner", "ownOwner");
        map.put("product", "pdtProductParent");
        map.put("productType", "pdtProductTypeByPdtProductTypeId");
        map.put("productSubType", "pdtProductTypeByPdtProductSubTypeId");
        map.put("uomByProductUomSale", "pdtUomByPdtProductUomSaleId");
        map.put("uomByProductUomBase", "pdtUomByPdtProductUomBaseId");
        map.put("uomByProductUomPurshase", "pdtUomByPdtProductUomPurshaseId");
        map.put("blockType", "prmBlockType");
        map.put("image", "prmImage");
        map.put("supplier", "rcpSupplier");
        map.put("warehouse", "wrhWarehouse");
        map.put("code", "pdtProductCode");
        map.put("alias", "pdtAlias");
        map.put("productCategory", "pdtProductCategory");
        map.put("salePriceUB", "pdtProductSalePriceUB");
        map.put("salePriceTTCUB", "pdtProductTTCSalePriceUB");
        map.put("purhsasePriceUB", "pdtProductPurshasePriceUB");
        map.put("purhsasePriceTTCUB", "pdtProductTTCPurshasePriceUB");
        map.put("suppOfLife", "pdtSuppOfLife");
        map.put("raisonToOut", "pdtRaisonToOut");
        map.put("materialABCCode", "pdtProductMaterialABCCode");
        map.put("dlcControl", "pdtProductDlcControl");
        map.put("dluoControl", "pdtProductDluoControl");
        map.put("serialNoControl", "pdtProductSerialNoControl");
        map.put("lotControl", "pdtProductLotControl");
        map.put("colorControl", "pdtProductColorControl");
        map.put("desc", "pdtProductDesc");
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
        map.put("creationDate", "pdtProductCreationDate");
        map.put("updateDate", "pdtProductUpdateDate");
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
        map.put("warrantyManagement", "pdtProductWarrantyManagement");
        map.put("discount", "pdtProductDiscount");
        map.put("warrantyPeriod", "prmWarrantyPeriod");
        map.put("currency", "prmCurrencySale");
        map.put("currencyPurshase", "prmCurrencyPurshase");
        map.put("productForm", "pdtProductForm");
        map.put("dimension", "pdtProductDimension");
        map.put("coefficient", "pdtProductCoefficient");
        map.put("productionCost", "pdtProductProductionCost");
        map.put("process", "pdtProcess");
        map.put("vat", "prmVat");
        map.put("menu", "pdtProductMenu");
        map.put("stocked", "pdtProductStocked");
        map.put("forBuying", "pdtProductForBuying");
        map.put("stockManaged", "pdtProductStockManaged");
        map.put("charge", "pdtProductCharge");
        map.put("packaging", "pdtProductPackaging");
        map.put("lastInventoryDate", "pdtProductLastInventoryDate");
        map.put("variableWeight", "pdtProductVariableWeight");
        map.put("customsPercentage", "pdtProductCustomsPercentage");
        map.put("purchaseVat", "prmVatPurchase");

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
        pdtProduct.setPdtProductMaterialABCCode(product.getMaterialABCCode());
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
        pdtProduct.setPdtProductSalePriceUB(product.getSalePriceUB());
        pdtProduct.setPdtProductPurshasePriceUB(product.getPurshasePriceUB());
        pdtProduct.setPdtProductQualityOfControl(product.getQualityOfControl());
        pdtProduct.setPdtCapacity(product.getCapacity());
        pdtProduct.setPdtMinimalThreshold(product.getMinimalThreshold());
        pdtProduct.setPdtIsReception(product.getReception());
        pdtProduct.setPdtProductControlWeight(product.getWeightControl());
        pdtProduct.setPdtProductWarrantyManagement(product.getWarrantyManagement());
        pdtProduct.setPdtProductDiscount(product.getDiscount());
        pdtProduct.setPdtProductDimension(product.getDimension());
        pdtProduct.setPdtProductVersion(product.getVersion());
        pdtProduct.setPdtProductStocked(product.getStocked());
        pdtProduct.setPdtProductForBuying(product.getForBuying());
        pdtProduct.setPdtProductStockManaged(product.getStockManaged());
        pdtProduct.setPdtProductOutOfStock(product.getOutOfStock());
        pdtProduct.setPdtProductMarginOfCostsOfReturn(product.getMarginOfCostsOfReturn());
        pdtProduct.setPdtProductMarginOfPurchase(product.getMarginOfPurchase());
        pdtProduct.setPdtProductCoefficient(product.getCoefficient());
        pdtProduct.setPdtProductProductionCost(product.getProductionCost());
        pdtProduct.setPdtProductCostsOfReturn(product.getCostsOfReturn());
        pdtProduct.setPdtProductTechnicalSheet(product.getTechnicalSheet());
        pdtProduct.setPdtProductCharge(product.getCharge());
        pdtProduct.setPdtProductPackaging(product.getPackaging());
        pdtProduct.setPdtProductLastInventoryDate(product.getLastInventoryDate());
        pdtProduct.setPdtProductSupplierDelay(product.getSupplierDelay());
        pdtProduct.setUpdatedBy(product.getUpdatedBy());
        pdtProduct.setCreatedBy(product.getCreatedBy());
        pdtProduct.setPdtProductProfessionalSalePrice(product.getProfessionalSalePrice());
        pdtProduct.setPdtProductVariableWeight(product.getVariableWeight());
        pdtProduct.setPdtProductCustomsPercentage(product.getCustomsPercentage());
        pdtProduct.setPdtProductTTCSalePriceUB(product.getSalePriceTTCUB());
        pdtProduct.setPdtProductTTCPurshasePriceUB(product.getPurshasePriceTTCUB());
        pdtProduct.setPdtProductProfessionalTTCSalePrice(product.getProfessionalTTCSalePrice());


        if (!lazy) {

            pdtProduct.setPdtProductPack(ProductPackMapper.toEntity(product.getProductPack(), false));
            pdtProduct.setPickingPdtUom(UomMapper.toEntity(product.getPickingUom(), true));
            pdtProduct.setOwnOwner(OwnerMapper.toEntity(product.getOwner(), true));
            pdtProduct.setPdtProductTypeByPdtProductTypeId(ProductTypeMapper.toEntity(product.getProductType(), true));
            pdtProduct.setPdtProductTypeByPdtProductSubTypeId(ProductTypeMapper.toEntity(product.getProductSubType(), true));
            pdtProduct.setRcpSupplier(SupplierMapper.toEntity(product.getSupplier(), true));
            pdtProduct.setPdtUomByPdtProductUomBaseId(UomMapper.toEntity(product.getUomByProductUomBase(), true));
            pdtProduct.setPdtUomByPdtProductUomPurshaseId(UomMapper.toEntity(product.getUomByProductUomPurshase(), true));
            pdtProduct.setPdtUomByPdtProductUomSaleId(UomMapper.toEntity(product.getUomByProductUomSale(), true));
            pdtProduct.setPdtProductParent(toEntity(product.getProduct(), true));
            pdtProduct.setWrhWarehouse(WarehouseMapper.toEntity(product.getWarehouse(), true));
            pdtProduct.setPdtProductPacks(ProductPackMapper.toEntities(product.getProductPacks(), false));

            pdtProduct.setPrmVat(VatMapper.toEntity(product.getVat(), true));

        }
        return pdtProduct;
    }


    public static Product toDto(PdtProduct pdtProduct, boolean lazy) {
        if (null == pdtProduct) {
            return null;
        }
        Product product = new Product();
        product.setId(pdtProduct.getPdtProductId());
        product.setCode(pdtProduct.getPdtProductCode());
        product.setMaterialABCCode(pdtProduct.getPdtProductMaterialABCCode());
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
        product.setSalePriceUB(pdtProduct.getPdtProductSalePriceUB());
        product.setPurshasePriceUB(pdtProduct.getPdtProductPurshasePriceUB());
        product.setRaisonToOut(pdtProduct.getPdtProductRaisonToOut());
        product.setQualityOfControl(pdtProduct.getPdtProductQualityOfControl());
        product.setCapacity(pdtProduct.getPdtCapacity());
        product.setReception(pdtProduct.getPdtIsReception());
        product.setMinimalThreshold(pdtProduct.getPdtMinimalThreshold());
        product.setWeightControl(pdtProduct.getPdtProductControlWeight());
        product.setWarrantyManagement(pdtProduct.getPdtProductWarrantyManagement());
        product.setDiscount(pdtProduct.getPdtProductDiscount());
        product.setDimension(pdtProduct.getPdtProductDimension());
        product.setVersion(pdtProduct.getPdtProductVersion());
        product.setStocked(pdtProduct.getPdtProductStocked());
        product.setForBuying(pdtProduct.getPdtProductForBuying());
        product.setStockManaged(pdtProduct.getPdtProductStockManaged());
        product.setOutOfStock(pdtProduct.getPdtProductOutOfStock());
        product.setMarginOfCostsOfReturn(pdtProduct.getPdtProductMarginOfCostsOfReturn());
        product.setMarginOfPurchase(pdtProduct.getPdtProductMarginOfPurchase());
        product.setCoefficient(pdtProduct.getPdtProductCoefficient());
        product.setProductionCost(pdtProduct.getPdtProductProductionCost());
        product.setCostsOfReturn(pdtProduct.getPdtProductCostsOfReturn());
        product.setTechnicalSheet(pdtProduct.getPdtProductTechnicalSheet());
        product.setLastInventoryDate(pdtProduct.getPdtProductLastInventoryDate());
        product.setSupplierDelay(pdtProduct.getPdtProductSupplierDelay());
        product.setUpdatedBy(pdtProduct.getUpdatedBy());
        product.setCreatedBy(pdtProduct.getCreatedBy());
        product.setProfessionalSalePrice(pdtProduct.getPdtProductProfessionalSalePrice());
        product.setVariableWeight(pdtProduct.getPdtProductVariableWeight());
        product.setCustomsPercentage(pdtProduct.getPdtProductCustomsPercentage());
        product.setSalePriceTTCUB(pdtProduct.getPdtProductTTCSalePriceUB());
        product.setPurshasePriceTTCUB(pdtProduct.getPdtProductTTCPurshasePriceUB());
        product.setProfessionalTTCSalePrice(pdtProduct.getPdtProductProfessionalTTCSalePrice());

        if (!lazy) {
            product.setProductPack(ProductPackMapper.toDto(pdtProduct.getPdtProductPack(), true));
            product.setPickingUom(UomMapper.toDto(pdtProduct.getPickingPdtUom(), true));
            product.setOwner(OwnerMapper.toDto(pdtProduct.getOwnOwner(), true));
            product.setProductType(ProductTypeMapper.toDto(pdtProduct.getPdtProductTypeByPdtProductTypeId(), true));
           product.setProductSubType(ProductTypeMapper.toDto(pdtProduct.getPdtProductTypeByPdtProductSubTypeId(), true));
            product.setUomByProductUomBase(UomMapper.toDto(pdtProduct.getPdtUomByPdtProductUomBaseId(), true));
            product.setUomByProductUomPurshase(UomMapper.toDto(pdtProduct.getPdtUomByPdtProductUomPurshaseId(), true));
            product.setUomByProductUomSale(UomMapper.toDto(pdtProduct.getPdtUomByPdtProductUomSaleId(), true));
            product.setWarehouse(WarehouseMapper.toDto(pdtProduct.getWrhWarehouse(), true));
            product.setProductPacks(ProductPackMapper.toDtos(pdtProduct.getPdtProductPacks(), false));
          //  product.setProductDimensions(ProductDimensionMapper.toDtos(pdtProduct.getPdtProductDimensions(), false));

            product.setVat(VatMapper.toDto(pdtProduct.getPrmVat(), false));

        }
        return product;
    }

    public static List<Product> toDtos(Iterable<? extends PdtProduct> pdtProducts, boolean lazy) {
        if (null == pdtProducts) {
            return null;
        }
        List<Product> products = new ArrayList<> ();
        for (PdtProduct pdtProduct : pdtProducts) {
            products.add(toDto(pdtProduct, lazy));
        }
        return products;
    }

    public static Set<PdtProduct> toEntities(Set<? extends Product> products, boolean lazy) {
        if (null == products) {
            return null;
        }
        Set<PdtProduct> pdtProducts = new HashSet<> ();
        for (Product product : products) {
            pdtProducts.add(toEntity(product, lazy));
        }
        return pdtProducts;
    }

    public static Set<Product> toDtos(Set<? extends PdtProduct> pdtProducts, boolean lazy) {
        if (null == pdtProducts) {
            return null;
        }
        Set<Product> products = new HashSet<> ();
        for (PdtProduct pdtProduct : pdtProducts) {
            products.add(toDto(pdtProduct, lazy));
        }
        return products;
    }
}

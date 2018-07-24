package com.bagile.tms.mapper;

import com.sinno.ems.dto.Product;
import com.sinno.ems.entities.PdtProduct;
import com.sinno.ems.util.EmsDate;

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
        map.put("product", "pdtProductParent");
        map.put("productType", "pdtProductTypeByPdtProductTypeId");
        map.put("productSubType", "pdtProductTypeByPdtProductSubTypeId");
        map.put("uomByProductUomSale", "pdtUomByPdtProductUomSaleId");
        map.put("uomByProductUomBase", "pdtUomByPdtProductUomBaseId");
        map.put("uomByProductUomBase", "pdtUomByPdtProductUomBaseId");
        map.put("uomByProductUomPurshase", "pdtUomByPdtProductUomPurshaseId");
        map.put("blockType", "prmBlockType");
        map.put("image", "prmImage");
        map.put("supplier", "rcpSupplier");
        map.put("warehouse", "wrhWarehouse");
        map.put("code", "pdtProductCode");
        map.put("alias", "pdtAlias");
        map.put("salePriceUB", "pdtSalePriceUB");
        map.put("purhsasePriceUB", "pdtPurshasePriceUB");
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
        map.put("process","pdtProcess");

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
        pdtProduct.setPdtProductSuppOfLife(product.getSuppOfLife());
        pdtProduct.setPdtProductSalePriceUB(product.getSalePriceUB());
        pdtProduct.setPdtProductPurshasePriceUB(product.getPurshasePriceUB());
        pdtProduct.setPdtProductQualityOfControl(product.getQualityOfControl());
        pdtProduct.setPdtCapacity(product.getCapacity());
        pdtProduct.setPdtMinimalThreshold(product.getMinimalThreshold());
        pdtProduct.setPdtIsReception(product.getReception());
        pdtProduct.setPdtProductReqExp(product.getReqExp());
        pdtProduct.setPdtProductReqRec(product.getReqRec());
        pdtProduct.setPdtProductControlWeight(product.getWeightControl());
        pdtProduct.setPdtProductWarrantyManagement(product.getWarrantyManagement());
        pdtProduct.setPdtProductDiscount(product.getDiscount());
        pdtProduct.setPdtProductDimension(product.getDimension());
            pdtProduct.setPdtProductVersion(product.getVersion());
        if (!lazy) {
            pdtProduct.setPdtProcess(ProcessMapper.toEntity(product.getProcess(),false));
            pdtProduct.setPrmCurrencyPurshase(CurrencyMapper.toEntity(product.getCurrencyPurshase(), false));
            pdtProduct.setPrmCurrencySale(CurrencyMapper.toEntity(product.getCurrency(), true));
            pdtProduct.setPrmWarrantyPeriod(WarrantyPeriodMapper.toEntity(product.getWarrantyPeriod(), true));
            pdtProduct.setPdtProductPack(ProductPackMapper.toEntity(product.getProductPack(), true));
            pdtProduct.setPickingPdtUom(UomMapper.toEntity(product.getPickingUom(), true));
            pdtProduct.setPickingLocLocation(LocationMapper.toEntity(product.getPickingLocation(), true));
            pdtProduct.setPdtAlias(AliasMapper.toEntity(product.getAlias(), true));
            pdtProduct.setOwnOwner(OwnerMapper.toEntity(product.getOwner(), true));
            pdtProduct.setPdtProductTypeByPdtProductTypeId(ProductTypeMapper.toEntity(product.getProductType(), true));
            pdtProduct.setPdtProductTypeByPdtProductSubTypeId(ProductTypeMapper.toEntity(product.getProductSubType(), true));
            pdtProduct.setRcpSupplier(SupplierMapper.toEntity(product.getSupplier(), true));
            pdtProduct.setPrmBlockType(BlockTypeMapper.toEntity(product.getBlockType(), true));
            pdtProduct.setPdtUomByPdtProductUomBaseId(UomMapper.toEntity(product.getUomByProductUomBase(), true));
            pdtProduct.setPdtUomByPdtProductUomPurshaseId(UomMapper.toEntity(product.getUomByProductUomPurshase(), true));
            pdtProduct.setPdtUomByPdtProductUomSaleId(UomMapper.toEntity(product.getUomByProductUomSale(), true));
            pdtProduct.setPdtProductParent(toEntity(product.getProduct(), true));
            pdtProduct.setLocLocation(LocationMapper.toEntity(product.getLocation(), true));
            pdtProduct.setWrhWarehouse(WarehouseMapper.toEntity(product.getWarehouse(), true));
            pdtProduct.setPrmImages(ImageMapper.toEntities(product.getImages(), false));
            pdtProduct.setPdtProductDimensions(ProductDimensionMapper.toEntities(product.getProductDimensions(),false));
            pdtProduct.setPdtProductPacks(ProductPackMapper.toEntities(product.getProductPacks(), false));
            pdtProduct.setPdtProductForm(ProductFormMapper.toEntity(product.getProductForm(), false));
//            pdtProduct.setCmdSaleOrderLineArcs(SaleOrderLineArcMapper.toEntities(product.getSaleOrderLineArcs(), true));
//            pdtProduct.setCmdSaleOrderStocks(SaleOrderStockMapper.toEntities(product.getSaleOrderStocks(), true));
//            pdtProduct.setRcpReceptionStocks(ReceptionStockMapper.toEntities(product.getReceptionStocks(), true));
//            pdtProduct.setCmdSaleOrderStockArcs(SaleOrderStockArcMapper.toEntities(product.getSaleOrderStockArcs(), true));
//            pdtProduct.setPdtProducts(toEntities(product.getProducts(), true));
//            pdtProduct.setRcpReceptionLines(ReceptionLineMapper.toEntities(product.getReceptionLines(), true));
//            pdtProduct.setPdtProducts_1(toEntities(product.getProducts_1(), true));
//            pdtProduct.setStkStockArcs(StockArcMapper.toEntities(product.getStockArcs(), true));
//            pdtProduct.setCmdSaleOrderLines(SaleOrderLineMapper.toEntities(product.getSaleOrderLines(), true));
//            pdtProduct.setStkStockReserveds(StockReservedMapper.toEntities(product.getStockReserveds(), true));
//            pdtProduct.setRcpReceptionLineArcs(ReceptionLineArcMapper.toEntities(product.getReceptionLineArcs(), true));
//            pdtProduct.setPdtAliases(AliasMapper.toEntities(product.getAliases(), true));
//            pdtProduct.setRcpReceptionStockArcs(ReceptionStockArcMapper.toEntities(product.getReceptionStockArcs(), true));
//            pdtProduct.setStkStocks(StockMapper.toEntities(product.getStocks(), true));
//            pdtProduct.setRcpPurshaseOrderLines(PurshaseOrderLineMapper.toEntities(product.getPurshaseOrderLines(), true));
//            pdtProduct.setRcpPurshaseOrderLineArcs(PurshaseOrderLineArcMapper.toEntities(product.getPurshaseOrderLineArcs(), true));
            oneToMany(pdtProduct);
        }
        return pdtProduct;
    }

    public static void oneToMany(PdtProduct pdtProduct) {
        if (null != pdtProduct.getPdtProductPacks()) {
            pdtProduct.getPdtProductPacks().stream().forEach(il -> {
                il.setPdtProduct(pdtProduct);
                il.setPrmCurrency(pdtProduct.getPrmCurrencySale());
                il.setOwnOwner(pdtProduct.getOwnOwner());
                if (il.getPdtAlias() != null) {
                    il.getPdtAlias().setOwnOwner(pdtProduct.getOwnOwner());
                    il.getPdtAlias().setPdtProduct(pdtProduct);
                    il.getPdtAlias().setPdtUom(il.getPdtUom());
                }
                il.setPdtProductPackUpdateDate(EmsDate.getDateNow());
                if (0 >= il.getPdtProductPackId()) {
                    il.setPdtProductPackCreationDate(EmsDate.getDateNow());
                }
            });
        }
        if (null != pdtProduct.getPrmImages()) {
            pdtProduct.getPrmImages().stream().forEach(image -> {
                image.setPdtProduct(pdtProduct);
            });
        }
        if (null != pdtProduct.getPdtProductDimensions()) {
            pdtProduct.getPdtProductDimensions().stream().forEach(dimension -> {
                dimension.setPdtProduct(pdtProduct);
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
        product.setMaterialABCCode(pdtProduct.getPdtProductMaterialABCCode());
        product.setSupplier(SupplierMapper.toDto(pdtProduct.getRcpSupplier(), true));
        product.setBlockType(BlockTypeMapper.toDto(pdtProduct.getPrmBlockType(), true));
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
        product.setSuppOfLife(pdtProduct.getPdtProductSuppOfLife());
        product.setQualityOfControl(pdtProduct.getPdtProductQualityOfControl());
        product.setSamplingPercentage(pdtProduct.getPdtProductSamplingPercentage());
        product.setCapacity(pdtProduct.getPdtCapacity());
        product.setReception(pdtProduct.getPdtIsReception());
        product.setMinimalThreshold(pdtProduct.getPdtMinimalThreshold());
        product.setReqExp(pdtProduct.getPdtProductReqExp());
        product.setReqRec(pdtProduct.getPdtProductReqRec());
        product.setWeightControl(pdtProduct.getPdtProductControlWeight());
        product.setWarrantyManagement(pdtProduct.getPdtProductWarrantyManagement());
        product.setDiscount(pdtProduct.getPdtProductDiscount());
        product.setDimension(pdtProduct.getPdtProductDimension());
        product.setVersion(pdtProduct.getPdtProductVersion());
        if (!lazy) {
            product.setProcess(ProcessMapper.toDto(pdtProduct.getPdtProcess(),false));
            product.setCurrencyPurshase(CurrencyMapper.toDto(pdtProduct.getPrmCurrencyPurshase(), false));
            product.setProductForm(ProductFormMapper.toDto(pdtProduct.getPdtProductForm(), true));
            product.setCurrency(CurrencyMapper.toDto(pdtProduct.getPrmCurrencySale(), true));
            product.setWarrantyPeriod(WarrantyPeriodMapper.toDto(pdtProduct.getPrmWarrantyPeriod(), true));
            product.setProductPack(ProductPackMapper.toDto(pdtProduct.getPdtProductPack(), true));
            product.setPickingLocation(LocationMapper.toDto(pdtProduct.getPickingLocLocation(), true));
            product.setPickingUom(UomMapper.toDto(pdtProduct.getPickingPdtUom(), true));
            product.setAlias(AliasMapper.toDto(pdtProduct.getPdtAlias(), true));
            product.setOwner(OwnerMapper.toDto(pdtProduct.getOwnOwner(), true));
            product.setProductType(ProductTypeMapper.toDto(pdtProduct.getPdtProductTypeByPdtProductTypeId(), true));
            product.setProductSubType(ProductTypeMapper.toDto(pdtProduct.getPdtProductTypeByPdtProductSubTypeId(), true));
            product.setUomByProductUomBase(UomMapper.toDto(pdtProduct.getPdtUomByPdtProductUomBaseId(), true));
            product.setUomByProductUomPurshase(UomMapper.toDto(pdtProduct.getPdtUomByPdtProductUomPurshaseId(), true));
            product.setUomByProductUomSale(UomMapper.toDto(pdtProduct.getPdtUomByPdtProductUomSaleId(), true));
            product.setProduct(toDto(pdtProduct.getPdtProductParent(), true));
            product.setLocation(LocationMapper.toDto(pdtProduct.getLocLocation(), true));
            product.setWarehouse(WarehouseMapper.toDto(pdtProduct.getWrhWarehouse(), true));
            product.setImages(ImageMapper.toDtos(pdtProduct.getPrmImages(), false));
            product.setProductPacks(ProductPackMapper.toDtos(pdtProduct.getPdtProductPacks(), false));
            product.setProductDimensions(ProductDimensionMapper.toDtos(pdtProduct.getPdtProductDimensions(),false));
//            product.setSaleOrderLineArcs(SaleOrderLineArcMapper.toDtos(pdtProduct.getCmdSaleOrderLineArcs(), true));
//            product.setSaleOrderStocks(SaleOrderStockMapper.toDtos(pdtProduct.getCmdSaleOrderStocks(), true));
//            product.setReceptionStocks(ReceptionStockMapper.toDtos(pdtProduct.getRcpReceptionStocks(), true));
//            product.setSaleOrderStockArcs(SaleOrderStockArcMapper.toDtos(pdtProduct.getCmdSaleOrderStockArcs(), true));
//            product.setProducts(toDtos(pdtProduct.getPdtProducts(), true));
//            product.setReceptionLines(ReceptionLineMapper.toDtos(pdtProduct.getRcpReceptionLines(), true));
//            product.setProducts_1(toDtos(pdtProduct.getPdtProducts_1(), true));
//            product.setStockArcs(StockArcMapper.toDtos(pdtProduct.getStkStockArcs(), true));
//            product.setSaleOrderLines(SaleOrderLineMapper.toDtos(pdtProduct.getCmdSaleOrderLines(), true));
//            product.setStockReserveds(StockReservedMapper.toDtos(pdtProduct.getStkStockReserveds(), true));
//            product.setReceptionLineArcs(ReceptionLineArcMapper.toDtos(pdtProduct.getRcpReceptionLineArcs(), true));
//            product.setAliases(AliasMapper.toDtos(pdtProduct.getPdtAliases(), true));
//            product.setReceptionStockArcs(ReceptionStockArcMapper.toDtos(pdtProduct.getRcpReceptionStockArcs(), true));
//            product.setStocks(StockMapper.toDtos(pdtProduct.getStkStocks(), true));
//            product.setPurshaseOrderLines(PurshaseOrderLineMapper.toDtos(pdtProduct.getRcpPurshaseOrderLines(), true));
//            product.setPurshaseOrderLineArcs(PurshaseOrderLineArcMapper.toDtos(pdtProduct.getRcpPurshaseOrderLineArcs(), true));
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

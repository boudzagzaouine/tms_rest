package com.sinno.ems.mapper.wms;

import com.sinno.ems.entities.PdtProduct;
import com.sinno.ems.entities.PdtProductPack;
import com.sinno.wms.crud.model.pro.ProductHeaderPresentations;
import com.sinno.wms.crud.model.pro.ProductLineDetailPresentations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TM161 on 05/05/2016.
 */
public class ProductMapperWMS {
    private ProductMapperWMS() {
    }

    public static ProductHeaderPresentations toModel(PdtProduct p, String code, String operation) {
        if (null == p) {
            return null;
        }
        ProductHeaderPresentations productHeaderPresentations = new ProductHeaderPresentations();
        productHeaderPresentations.setOperation(operation);
        if (!code.equals("")) {
            productHeaderPresentations.setProductCode(code);
            productHeaderPresentations.setNewProductCode(p.getPdtProductCode());
        } else {
            productHeaderPresentations.setProductCode(p.getPdtProductCode());
        }

        if (null != p.getOwnOwner()) {
            productHeaderPresentations.setOwnerCode(p.getOwnOwner().getOwnOwnerCode());
        }
        if (null != p.getPdtAlias()) {
            productHeaderPresentations.setEanCode(p.getPdtAlias().getPdtAliasEanCode());
        }
        if (null != p.getPdtProductTypeByPdtProductTypeId()) {
            productHeaderPresentations.setProductTypeCode(p.getPdtProductTypeByPdtProductTypeId().getPdtProductTypeCode());
        }
        productHeaderPresentations.setChangeMaterialAbc(true);
        productHeaderPresentations.setMaterialAbcCode(p.getPdtProductMaterialABCCode());
        if (null != p.getRcpSupplier()) {
            productHeaderPresentations.setSupplierCode(p.getRcpSupplier().getRcpSupplierCode());
        }
        if (null != p.getPdtProductDlcControl() && p.getPdtProductDlcControl()) {
            productHeaderPresentations.setDateControl(1);
        } else if (null != p.getPdtProductDluoControl() && p.getPdtProductDluoControl()) {
            productHeaderPresentations.setDateControl(2);
        } else {
            productHeaderPresentations.setDateControl(0);
        }
        productHeaderPresentations.setSerialNoControl(p.getPdtProductSerialNoControl());
        productHeaderPresentations.setLotControl(p.getPdtProductLotControl());
        if (null != p.getPdtUomByPdtProductUomBaseId()) {
            productHeaderPresentations.setMovementPackType(p.getPdtUomByPdtProductUomBaseId().getPdtUomCode());
        }
        if (null != p.getPdtUomByPdtProductUomSaleId()) {
            productHeaderPresentations.setOrderPackSize(p.getPdtUomByPdtProductUomSaleId().getPdtUomCode());
        }
        if (null != p.getPdtUomByPdtProductUomSaleId()) {
            productHeaderPresentations.setShippingPackType(p.getPdtUomByPdtProductUomSaleId().getPdtUomCode());
            productHeaderPresentations.setProdDesc(p.getPdtProductDesc());
        }
        if (null != p.getPdtProductDaysOfLife()) {
            productHeaderPresentations.setShelfLife((double) p.getPdtProductDaysOfLife());
        }
        if (null != p.getPdtProductPack()) {
            productHeaderPresentations.setAvgCost(p.getPdtProductPack().getPdtProductSalePrice());
        }
        if (null != p.getPdtProductDaysOfLife()) {
            productHeaderPresentations.setReceiveLife((double) p.getPdtProductDaysOfLife());
        }
        if (p.getPdtProductContainerStack() != null) {
            productHeaderPresentations.setContainerStack((int) p.getPdtProductContainerStack());
        }
        productHeaderPresentations.setPickWarnMessage(p.getPdtProductPickMessage());
        productHeaderPresentations.setVerifyMetrics(false);
        if (null != p.getPdtUomByPdtProductUomBaseId()) {
            productHeaderPresentations.setUomBaseCode(p.getPdtUomByPdtProductUomBaseId().getPdtUomCode());
        }
        if (null != p.getPdtUomByPdtProductUomBaseId()) {
            productHeaderPresentations.setDescUomBaseCode(p.getPdtUomByPdtProductUomBaseId().getPdtUomDescription());
        }
        productHeaderPresentations.setAllowSplit(true);
        productHeaderPresentations.setAllowCommingle(true);
        if (null != p.getPdtProductTypeByPdtProductSubTypeId()) {
            productHeaderPresentations.setProductSubTypeCode(p.getPdtProductTypeByPdtProductSubTypeId().getPdtProductTypeCode());
        }
        productHeaderPresentations.setQualityControl(p.getPdtProductQualityOfControl());
        productHeaderPresentations.setPackag(false);
        // TODO productHeaderPresentations.setOutBoundLogic();
        productHeaderPresentations.setCoded(0);
        productHeaderPresentations.setReqLotRec(p.getPdtProductReqRec());
        productHeaderPresentations.setReqLotExp(p.getPdtProductReqExp());
        productHeaderPresentations.setReqManipulation(false);
        productHeaderPresentations.setManipulationDesc(p.getPdtProductManipulationDesc());
        if (null != p.getPdtProductMinTemp()) {
            productHeaderPresentations.setTempMin(p.getPdtProductMinTemp().doubleValue());
        }
        if (null != p.getPdtProductMaxTemp()) {
            productHeaderPresentations.setTempMax(p.getPdtProductMaxTemp().doubleValue());
        }
        if (null != p.getPdtProductMaxStock()) {
            productHeaderPresentations.setMaxStock(p.getPdtProductMaxStock().doubleValue());
        }
        if (null != p.getPdtProductMinStock()) {
            productHeaderPresentations.setMinStock(p.getPdtProductMinStock().doubleValue());
        }
        productHeaderPresentations.setLotControlNoExact(false);
        productHeaderPresentations.setSupplierControl(false);
        productHeaderPresentations.setDaysOfLifeControl(false);
        productHeaderPresentations.setSizeControl(false);
        productHeaderPresentations.setColorControl(p.getPdtProductColorControl());
        productHeaderPresentations.setSourceControl(false);
        productHeaderPresentations.setVersionControl(false);
        productHeaderPresentations.setProductionMethodControl(false);
        productHeaderPresentations.setPostProductionTreatControl(false);
        productHeaderPresentations.setAllowDinamicReplenish(true);
        productHeaderPresentations.setReplenishMode(0);
        if (null != p.getPrmBlockType()) {
            productHeaderPresentations.setReceptionStatus(p.getPrmBlockType().getPrmBlockTypeCode());
        }
        productHeaderPresentations.setReceptionCoded(1);
        productHeaderPresentations.setAllowReplNoProdLoc(1);
        List<ProductLineDetailPresentations> productLinesDetailPresentationsList = new ArrayList<>();
        ProductLineDetailPresentations productLineDetailPresentations;
        if (null == p.getPdtProductPacks()) {
            productHeaderPresentations.setLineCount(0);
        } else {
            productHeaderPresentations.setLineCount(p.getPdtProductPacks().size());

            for (PdtProductPack productPack : p.getPdtProductPacks()) {
                productLineDetailPresentations = new ProductLineDetailPresentations();
                if (operation.equals("F")) {
                    productLineDetailPresentations.setOperation("A");
                } else if (operation.equals("B")) {
                    productLineDetailPresentations.setOperation("B");
                }
                productLineDetailPresentations.setDetailLineStart("/");
                if (null != productPack.getPdtUom()) {
                    productLineDetailPresentations.setUomCode(productPack.getPdtUom().getPdtUomCode());
                }
                if (null != productPack.getPdtUom()) {
                    productLineDetailPresentations.setUomDesc(productPack.getPdtUom().getPdtUomDescription());
                }
                if (null != productPack.getPdtProductQuantity()) {
                    productLineDetailPresentations.setQuantity(productPack.getPdtProductQuantity().doubleValue());
                }
                if (null != productPack.getPdtProductPackWeight()) {
                    productLineDetailPresentations.setPackWeight(productPack.getPdtProductPackWeight().doubleValue());
                }
                if (null != productPack.getPdtProductPackLenght()) {
                    productLineDetailPresentations.setLength(productPack.getPdtProductPackLenght().doubleValue());
                }
                if (null != productPack.getPdtProductPackWidth()) {
                    productLineDetailPresentations.setWidth(productPack.getPdtProductPackWidth().doubleValue());
                }
                if (null != productPack.getPdtProductPackHeight()) {
                    productLineDetailPresentations.setHeight(productPack.getPdtProductPackHeight().doubleValue());
                }

                productLinesDetailPresentationsList.add(productLineDetailPresentations);
            }
            productHeaderPresentations.setListProductLineDetailPresentations(productLinesDetailPresentationsList);
        }
        return productHeaderPresentations;
    }
}

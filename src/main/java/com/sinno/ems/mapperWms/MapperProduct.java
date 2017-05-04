package com.sinno.ems.mapperWms;

import java.math.BigDecimal;
import java.util.Optional;

import com.sinno.ems.dto.*;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperProduct {


    public static com.sinno.wms.crud.modelbasic.products.Product convertToWmsDto(Product p) {

        com.sinno.wms.crud.modelbasic.products.Product pro = new com.sinno.wms.crud.modelbasic.products.Product();

        if (null != p.getCode())
            pro.setProduct_code(p.getCode());
        if (null != p.getOwner() && null != p.getOwner().getCode())
            pro.setOwner_code(p.getOwner().getCode());
        //pro.setOwner_code(Optional.of(p).map(Product::getOwner).map(Owner::getCode).get());
        if (null != p.getDesc())
            pro.setDescription(p.getDesc());
        if (null != p.getShortDesc())
            pro.setShort_description(p.getShortDesc());
        if (null != p.getPickMessage())
            pro.setPicker_warning_message(p.getPickMessage());
        if (null != p.getProductType() && null != p.getProductType().getCode())
            pro.setProduct_type_code(p.getProductType().getCode());
        if (null != p.getUomByProductUomBase() && null != p.getUomByProductUomBase().getCode())
            pro.setUom_base_code(p.getUomByProductUomBase().getCode());
        if (null != p.getMaterialABCCode())
            pro.setRotation_abc_code(p.getMaterialABCCode());
        if (null != p.getLotControl())
            pro.setLot_control(p.getLotControl());
        if (null != p.getPickingLocation() && null != p.getPickingLocation().getPicking())
            pro.setPicking_location(p.getPickingLocation().getPicking());
        if (null != p.getDlcControl())
            pro.setExpiration_date_control(p.getDlcControl());
        if(null!=p.getSerialNoControl())
            pro.setSerial_number_control(p.getSerialNoControl());

        if(null!=p.getWeightControl())
            pro.setWeight_control(p.getWeightControl());



      /*pro.setAllow_conmingle();
        pro.setAllow_crossdocking();
        pro.setNeeds_weight();
        pro.setRandom_weight();   */

        return pro;

    }

    public static Product convertToEmsDto(Product product, com.sinno.wms.crud.modelbasic.products.Product p) {

        //Product product = new Product();

        if (null != p.getProduct_code())
            product.setCode(p.getProduct_code());
        if (null != p.getDescription())
            product.setDesc(p.getDescription());
        if (null != p.getPicker_warning_message())
            product.setPickMessage(p.getPicker_warning_message());
        if (null != p.getShort_description())
            product.setShortDesc(p.getShort_description());

        product.setLotControl(p.getLot_control());
        product.setDlcControl(p.isExpiration_date_control());

        if (null != p.getRotation_abc_code())
            product.setMaterialABCCode(p.getRotation_abc_code());


//        if (null != p.getOwner_code()) {
//            Owner o = new Owner();
//            o.setCode(p.getOwner_code());
//            product.setOwner(o);
//        }
//        if (null != p.getProduct_code()) {
//            Product pr = new Product();
//            pr.setCode(p.getProduct_code());
//            product.setProduct(pr);
//        }
//
//        if (null != p.getUom_base_code()) {
//            Uom u = new Uom();
//            u.setCode(p.getUom_base_code());
//            product.setUomByProductUomBase(u);
//        }

        if(null!=p.getActive())
        product.setActive(p.getActive());
        if(null !=p.getWeight_control())
        product.setWeightControl(p.getWeight_control());
        if(null !=p.getColor_control())
        product.setColorControl(p.getColor_control());
        if(null!=p.getDlc_control())
        product.setDlcControl(p.getDlc_control());
        if(null!=p.getDluo_control())
        product.setDluoControl(p.getDluo_control());
        if(null!=p.getQuality_control())
        product.setQualityOfControl(p.getQuality_control());
        if(null!=p.getSerial_number_control())
        product.setSerialNoControl(p.getSerial_number_control());
        if(null!=p.getLot_control())
        product.setLotControl(p.getLot_control());
        if(null !=p.getRotation_abc_code())
        product.setMaterialABCCode(p.getRotation_abc_code());
        if(null!=p.getMaximal_temperature())
        product.setMaxTemp(BigDecimal.valueOf(Double.valueOf(p.getMaximal_temperature())));
        if(null!=p.getMinimal_temperature())
        product.setMinTemp(BigDecimal.valueOf(Double.valueOf(p.getMinimal_temperature())));
        if(null!=p.getMinimal_quantity())
        product.setMinStock(BigDecimal.valueOf(Double.valueOf(p.getMinimal_quantity())));
        if(null!=p.getMaximal_quantity())
        product.setMaxStock(BigDecimal.valueOf(Double.valueOf(p.getMaximal_quantity())));
        if(null!=p.getDay_of_life())
        product.setDaysOfLife(Integer.valueOf(p.getDay_of_life()));
        if(null!=p.getPicker_warning_message())
        product.setPickMessage(p.getPicker_warning_message());

   /*   product.setActive();
        product.setAlias();
        product.setAliases();
        product.setBlockType();
        product.setCapacity();
        product.setProduct();
        product.setProductType();
        product.setUserBoxCreationDate();
        product.setConditionningPrice();
        product.setOwner();
        product.setWarehouse();
        product.setContainerStack();


        product.setManipulationDesc();
        product.setImage();
        product.setPickingLocation();
        product.setPickingPrice();
        product.setPickingUom();
        product.setPickMessage();
        product.setSupplier();
        product.setUpdateDate();
        product.setKit();
        product.setMaterialABCCode();
        product.setColorControl();
        product.setDaysOfLife();
        product.setUomByProductUomBase();
        product.setUomByProductUomPurshase();
        product.setUomByProductUomSale();
        product.setProducts();
        product.setMinimalThreshold();
        product.setReceptionStockArcs();
        product.setSaleOrderStockArcs();
        product.setProductPacks();  */


        return product;

    }
}

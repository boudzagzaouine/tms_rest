package com.sinno.ems.mapperWms;

import com.sinno.ems.dto.Account;
import com.sinno.ems.dto.Owner;
import com.sinno.wms.crud.modelbasic.products.Product;
import com.sinno.wms.crud.modelbasic.products.ProductType;

/**
 * Created by Administrateur on 11/10/2016.
 */
public class MapperProductType {


    public static com.sinno.wms.crud.modelbasic.products.ProductType convertToWmsDto(com.sinno.ems.dto.ProductType p){

        com.sinno.wms.crud.modelbasic.products.ProductType proT = new com.sinno.wms.crud.modelbasic.products.ProductType();


        if(null!= p.getCode())
        proT.setProduct_type_code(p.getCode());
        if(null!=p.getDescription())
        proT.setDescription(p.getDescription());
        if(null != p.getOwner() && null != p.getOwner().getCode())
        proT.setOwner_code(p.getOwner().getCode());


        // proT.setIs_preferred();

        return proT;

    }

    public static com.sinno.ems.dto.ProductType convertToEmsDto(com.sinno.ems.dto.ProductType productTypee,com.sinno.wms.crud.modelbasic.products.ProductType p){

        com.sinno.ems.dto.ProductType productType=new com.sinno.ems.dto.ProductType();

        if(null !=p.getDescription())
        productType.setDescription(p.getDescription());
        if(null !=p.getProduct_type_code())
        productType.setCode(p.getProduct_type_code());

      /*  productType.setOwner();
          productType.setProductsForProductSubType();
          productType.setProductsForProductType();
          productType.setUpdateDate();
          productType.setProductsForProductType();
          productType.setProductType();
          productType.setProductTypes();   */



        return productType;

    }
}

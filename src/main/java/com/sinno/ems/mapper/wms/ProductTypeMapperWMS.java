package com.sinno.ems.mapper.wms;

import com.sinno.ems.dto.ProductType;
import com.sinno.wms.crud.model.tpr.ProductTypes;

public class ProductTypeMapperWMS {

	public ProductTypeMapperWMS() {
		
	}
	
	public ProductType toDto(ProductTypes productTypes){
		ProductType productTypeDto = new ProductType();
		/*TODO not exist in model
		 *  Set<Product> productsForProductType;
	        Set<Product> productsForProductSubType;
		 * creationDate
		 * updateDate
		 * code
		 * owner
		 * id
		 *  attributes dans le model
		 * */
		productTypeDto.setDescription(productTypes.getDescription());
		ProductType productType = new ProductType();
		productType.setCode(productTypes.getProductTypeCode());
		productTypeDto.setProductType(productType);
		
		
		
		
		return productTypeDto;
	}
}

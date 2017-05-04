package com.sinno.ems.service;

import com.sinno.ems.dto.ProductType;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductTypeService {

    public ProductType save(ProductType productType);

    public Long size();

    public Boolean isExist(Long id);

    public ProductType findById(Long id) throws IdNotFound;

    public List<ProductType> find(String search) throws AttributesNotFound, ErrorType;

    public List<ProductType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(ProductType productType);

    public List<ProductType> findAll();

    public List<ProductType> findAll(Pageable pageable);

    ProductType loadWmsProductType(com.sinno.wms.crud.modelbasic.products.ProductType productType);

    List<ProductType> exportWmsProductType(List<ProductType> productTypes);
}
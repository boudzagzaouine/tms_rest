package com.sinno.ems.service;

import com.sinno.ems.dto.Product;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.WarehouseException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface ProductService {

    public Product save(Product product);

    public Long size();

    public Boolean isExist(Long id);

    public Product findById(Long id) throws IdNotFound;

    public List<Product> find(String search) throws AttributesNotFound, ErrorType;

    public List<Product> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id) throws WarehouseException;

    public void delete(Product product);

    public List<Product> findAll() throws AttributesNotFound, ErrorType;

    public List<Product> findAll(int page, int size) throws AttributesNotFound, ErrorType;
    
    public BigInteger getNextVal();

    public Product loadWmsProduct(com.sinno.wms.crud.modelbasic.products.Product product);

    List<Product> exportWmsProduct(List<Product> products);

    BigDecimal stockQuantity(Long id);

    BigDecimal reservedQuantity(Long id);

    BigDecimal blockedQuantity(Long id);

    BigDecimal orderedQuantity(Long id);

    BigDecimal quantityToReceive(Long id);
}
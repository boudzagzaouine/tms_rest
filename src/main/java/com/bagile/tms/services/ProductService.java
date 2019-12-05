package com.bagile.tms.services;


import com.bagile.tms.dto.Product;
import com.bagile.tms.dto.ProductPack;
import com.bagile.tms.dto.Uom;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.exceptions.WarehouseException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface ProductService {

    Product save(Product product) throws IdNotFound;

    Long size();

    Boolean isExist(Long id);

    Product findById(Long id) throws IdNotFound;

    Product findOne(String search) throws AttributesNotFound, ErrorType;

    List<Product> find(String search) throws AttributesNotFound, ErrorType;

    List<Product> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id) throws WarehouseException;

    void delete(Product product) throws WarehouseException;

    List<Product> findAll() throws AttributesNotFound, ErrorType;

    List<Product> findAll(int page, int size) throws AttributesNotFound, ErrorType;
    
    BigInteger getNextVal();

    Product findByCode(String code);

    BigDecimal convertQuantityByUom(BigDecimal qte, ProductPack packExpected, ProductPack packServed);

    BigDecimal convertQuantityByUom(BigDecimal qte, Uom uom, Uom uomServed, Product product);

    Product saveKits(Product product) throws IdNotFound, AttributesNotFound, ErrorType;

    List<Long> getIds();

    List<String> getPendingProductsCodes();

    List<String> getProductsCode(String code);
}
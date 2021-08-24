package com.bagile.gmo.services;


import com.bagile.gmo.dto.*;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product save(Product product) throws IdNotFound, AttributesNotFound, ErrorType;

    Long size() throws AttributesNotFound, ErrorType;

    Boolean isExist(Long id);

    Product findById(Long id) throws IdNotFound;

    Product findOne(String search) throws AttributesNotFound, ErrorType;

    List<Product> find(String search) throws AttributesNotFound, ErrorType;

    List<Product> find(String search,Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    List<Product> findAll() throws AttributesNotFound, ErrorType;

    List<Product> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
    void delete(Long id);

    void delete(Product product);
    void deleteAll (List<Long> ids) throws AttributesNotFound, ErrorType;

    BigDecimal convertQuantityByUom(BigDecimal qte, Uom uom, Uom uomServed, Product product);
    BigDecimal convertQuantityByUom(BigDecimal qte, ProductPack packExpected, ProductPack packServed);

    void updatePurchasePrice(Long id, BigDecimal purchasePrice, ProductPack productPack, Supplier supplier, Currency currency);
    BigDecimal stockQuantity(Long id);



    List<Long> getIds();
}
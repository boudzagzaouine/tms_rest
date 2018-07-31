package com.bagile.tms.services;



import com.bagile.tms.dto.Product;
import com.bagile.tms.dto.ProductPack;
import com.bagile.tms.dto.Uom;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

public interface ProductService {

    Product save(Product product) throws IdNotFound;

    Boolean isExist(Long id);

    Product findById(Long id) throws IdNotFound;


    List<Product> find(String search) throws AttributesNotFound, ErrorType;

    List<Product> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id) throws CustomException;

    void delete(Product product) throws CustomException;

    List<Product> findAll() throws AttributesNotFound, ErrorType;

    List<Product> findAll(int page, int size) throws AttributesNotFound, ErrorType;
    
    String getNextVal();
    BigDecimal stockQuantity(Long id);

    BigDecimal reservedQuantity(Long id);

    BigDecimal blockedQuantity(Long id);

    BigDecimal orderedQuantity(Long id);

    BigDecimal quantityToReceive(Long id);


}
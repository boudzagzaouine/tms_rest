package com.bagile.tms.services;


import com.bagile.tms.dto.Product;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

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

    List<Product> findAll() throws AttributesNotFound, ErrorType;

    List<Product> findAll(int page, int size) throws AttributesNotFound, ErrorType;
}
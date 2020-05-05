package com.bagile.gmo.services;


import com.bagile.gmo.dto.Product;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

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
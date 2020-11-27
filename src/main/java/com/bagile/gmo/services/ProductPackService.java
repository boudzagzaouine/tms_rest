package com.bagile.gmo.services;


import com.bagile.gmo.dto.ProductPack;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductPackService {

    ProductPack save(ProductPack productPack) throws IdNotFound, AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    ProductPack findById(Long id) throws IdNotFound;

    ProductPack findOne(String search) throws AttributesNotFound, ErrorType;

    List<ProductPack> find(String search) throws AttributesNotFound, ErrorType;

    List<ProductPack> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ProductPack productPack);

    List<ProductPack> findAll();

    List<ProductPack> findAll(Pageable pageable);
}
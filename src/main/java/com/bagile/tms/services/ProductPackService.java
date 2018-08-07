package com.bagile.tms.services;

import com.bagile.tms.dto.ProductPack;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductPackService {
    @Transactional
    ProductPack save(ProductPack productPack);

    Long size();

    Boolean isExist(Long id);

    ProductPack findById(Long id) throws IdNotFound;

    List<ProductPack> find(String search) throws AttributesNotFound, ErrorType;

    List<ProductPack> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ProductPack productPack);

    List<ProductPack> findAll();

    List<ProductPack> findAll(Pageable pageable);
}

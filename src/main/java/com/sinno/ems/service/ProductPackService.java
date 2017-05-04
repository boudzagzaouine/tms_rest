package com.sinno.ems.service;

import com.sinno.ems.dto.ProductPack;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductPackService {

    public ProductPack save(ProductPack productPack);

    public Long size();

    public Boolean isExist(Long id);

    public ProductPack findById(Long id) throws IdNotFound;

    public List<ProductPack> find(String search) throws AttributesNotFound, ErrorType;

    public List<ProductPack> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(ProductPack productPack);

    public List<ProductPack> findAll();

    public List<ProductPack> findAll(Pageable pageable);
}
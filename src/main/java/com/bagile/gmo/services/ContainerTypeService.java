package com.bagile.gmo.services;


import com.bagile.gmo.dto.ContainerType;
import com.bagile.gmo.dto.ProductPack;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ContainerTypeService {
    ContainerType save(ContainerType containerType);

    Long size();

    Boolean isExist(Long id);

    ContainerType findById(Long id) throws IdNotFound;

    List<ContainerType> find(String search) throws AttributesNotFound, Error, ErrorType;

    ContainerType findOne(String search) throws AttributesNotFound, Error, ErrorType;

    List<ContainerType> find(String search, int page, int size) throws AttributesNotFound, Error, ErrorType;

    Long size(String search) throws AttributesNotFound, Error, ErrorType;

    void delete(Long id);

    void delete(ContainerType containerType);

    List<ContainerType> findAll();

    List<ContainerType> findAll(Pageable pageable);

    ContainerType findByCode(String code);

    boolean containerCanHandelProduct(ProductPack productPack, ContainerType containerType, BigDecimal quantity) throws AttributesNotFound, ErrorType;
}

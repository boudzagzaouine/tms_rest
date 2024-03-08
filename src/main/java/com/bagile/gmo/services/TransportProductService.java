package com.bagile.gmo.services;

import com.bagile.gmo.dto.TransportProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface TransportProductService {
    TransportProduct save(TransportProduct transportProduct);

    Long size();

    Boolean isExist(Long id);

    TransportProduct findById(Long id) throws IdNotFound;

    List<TransportProduct> find(String search) throws AttributesNotFound, ErrorType;

    List<TransportProduct> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TransportProduct transportProduct);
    void deleteAll (List<Long> ids);
    List<TransportProduct> findAll();

    List<TransportProduct> findAll(int page, int size);
}

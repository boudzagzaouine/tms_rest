package com.bagile.tms.services;

import com.bagile.tms.dto.CatalogTransportType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;


public interface CatalogTransportTypeService {
    CatalogTransportType save(CatalogTransportType transport);

    Long size();

    Boolean isExist(Long id);

    CatalogTransportType findById(Long id) throws IdNotFound;

    List<CatalogTransportType> find(String search) throws AttributesNotFound, ErrorType;

    List<CatalogTransportType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(CatalogTransportType transport);
    void deleteAll (List<Long> ids);
    List<CatalogTransportType> findAll();

    List<CatalogTransportType> findAll(int page, int size);
}

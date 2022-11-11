package com.bagile.gmo.services;

import com.bagile.gmo.dto.CatalogTransportType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

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

    String getNextVal();
}

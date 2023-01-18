package com.bagile.gmo.services;

import com.bagile.gmo.dto.CatalogService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface CatalogServiceService {
    CatalogService save(CatalogService catalogService);

    Long size();

    Boolean isExist(Long id);

    CatalogService findById(Long id) throws IdNotFound;

    List<CatalogService> find(String search) throws AttributesNotFound, ErrorType;

    List<CatalogService> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(CatalogService catalogService);
    void deleteAll (List<Long> ids);

    List<CatalogService> findAll();

    List<CatalogService> findAll(int page, int size);

	CatalogService findOne(String search) throws AttributesNotFound, ErrorType;

}

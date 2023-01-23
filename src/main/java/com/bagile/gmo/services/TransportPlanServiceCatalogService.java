package com.bagile.gmo.services;

import com.bagile.gmo.dto.TransportPlanServiceCatalog;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface TransportPlanServiceCatalogService {
    TransportPlanServiceCatalog save(TransportPlanServiceCatalog transporPlanService);

    Long size();

    Boolean isExist(Long id);

    TransportPlanServiceCatalog findById(Long id) throws IdNotFound;

    List<TransportPlanServiceCatalog> find(String search) throws AttributesNotFound, ErrorType;

    List<TransportPlanServiceCatalog> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TransportPlanServiceCatalog transporPlanService);
    void deleteAll (List<Long> ids);
    List<TransportPlanServiceCatalog> findAll();

    List<TransportPlanServiceCatalog> findAll(int page, int size);
}

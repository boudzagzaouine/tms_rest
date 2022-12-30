package com.bagile.gmo.services;

import com.bagile.gmo.dto.CatalogPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface CatalogPricingService {
    CatalogPricing save(CatalogPricing catalogPricing);
    List<CatalogPricing> saveAll(List<CatalogPricing> catalogPricings) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    CatalogPricing findById(Long id) throws IdNotFound;

    List<CatalogPricing> find(String search) throws AttributesNotFound, ErrorType;

    List<CatalogPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(CatalogPricing catalogPricing);
    void deleteAll (List<Long> ids);
    List<CatalogPricing> findAll();

    List<CatalogPricing> findAll(int page, int size);

}

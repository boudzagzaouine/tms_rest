package com.bagile.gmo.services;

import com.bagile.gmo.dto.CatalogTransportPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface CatalogTransportPricingService {
    CatalogTransportPricing save(CatalogTransportPricing catalogTransportPricing);
    List<CatalogTransportPricing> saveAll(List<CatalogTransportPricing> catalogTransportPricings) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    CatalogTransportPricing findById(Long id) throws IdNotFound;

    List<CatalogTransportPricing> find(String search) throws AttributesNotFound, ErrorType;

    List<CatalogTransportPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(CatalogTransportPricing catalogTransportPricing);
    void deleteAll (List<Long> ids);
    List<CatalogTransportPricing> findAll();

    List<CatalogTransportPricing> findAll(int page, int size);

    String getNextVal();
}

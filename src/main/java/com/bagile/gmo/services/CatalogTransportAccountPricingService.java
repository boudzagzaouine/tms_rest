package com.bagile.gmo.services;

import com.bagile.gmo.dto.CatalogTransportAccountPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface CatalogTransportAccountPricingService {
    CatalogTransportAccountPricing save(CatalogTransportAccountPricing catalogTransportAccountPricing);
    List<CatalogTransportAccountPricing> saveAll(List<CatalogTransportAccountPricing> catalogTransportAccountPricings) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    CatalogTransportAccountPricing findById(Long id) throws IdNotFound;

    List<CatalogTransportAccountPricing> find(String search) throws AttributesNotFound, ErrorType;

    List<CatalogTransportAccountPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(CatalogTransportAccountPricing catalogTransportAccountPricing);
    void deleteAll (List<Long> ids);
    List<CatalogTransportAccountPricing> findAll();

    List<CatalogTransportAccountPricing> findAll(int page, int size);

    String getNextVal();
}

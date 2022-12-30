package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.CatalogPricing;
import com.bagile.gmo.entities.TmsCatalogPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.CatalogPricingMapper;
import com.bagile.gmo.repositories.CatalogPricingRepository;
import com.bagile.gmo.services.CatalogPricingService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CatalogPricingServiceImpl implements CatalogPricingService {
    private final CatalogPricingRepository catalogPricingRepository;
    
    public CatalogPricingServiceImpl(CatalogPricingRepository catalogPricingRepository) {
        this.catalogPricingRepository = catalogPricingRepository;
    }

    @Override
    public CatalogPricing save(CatalogPricing transport) {
        return CatalogPricingMapper.toDto(catalogPricingRepository.saveAndFlush(CatalogPricingMapper.toEntity(transport, false)), false);
    }

    @Override
    public List<CatalogPricing> saveAll(List<CatalogPricing> catalogPricings) throws AttributesNotFound, ErrorType {

        List<CatalogPricing> transportTypeList = new ArrayList<>();

        for (CatalogPricing catalogPricing : catalogPricings) {
            transportTypeList.add(save(catalogPricing));
        }

        return transportTypeList;

    }
    @Override
    public Long size() {
        return catalogPricingRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return catalogPricingRepository.existsById(id);
    }

    @Override
    public CatalogPricing findById(Long id) throws IdNotFound {
        return CatalogPricingMapper.toDto(catalogPricingRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CatalogPricing> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CatalogPricingMapper.toDtos(catalogPricingRepository.findAll(Search.expression(search, TmsCatalogPricing.class)), false);
    }

    @Override
    public List<CatalogPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogPricingMapper.toDtos(catalogPricingRepository.findAll(Search.expression(search, TmsCatalogPricing.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return catalogPricingRepository.count(Search.expression(search, TmsCatalogPricing.class));
    }

    @Override
    public void delete(Long id) {
        catalogPricingRepository.deleteById(id);
    }

    @Override
    public void delete(CatalogPricing transport) {
        catalogPricingRepository.delete(CatalogPricingMapper.toEntity(transport, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            catalogPricingRepository.deleteById(id);        }
    }

    @Override
    public List<CatalogPricing> findAll() {
        return CatalogPricingMapper.toDtos(catalogPricingRepository.findAll(), false);
    }

    @Override
    public List<CatalogPricing> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogPricingMapper.toDtos(catalogPricingRepository.findAll(pageable), false);
    }



}


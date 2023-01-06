package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.CatalogTransportPricing;
import com.bagile.gmo.entities.TmsCatalogTransportPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.CatalogTransportPricingMapper;
import com.bagile.gmo.repositories.CatalogTransportPricingRepository;
import com.bagile.gmo.services.CatalogTransportPricingService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CatalogTransportPricingServiceImpl implements CatalogTransportPricingService {
    private final CatalogTransportPricingRepository catalogTransportPricingRepository;
    
    public CatalogTransportPricingServiceImpl(CatalogTransportPricingRepository catalogTransportPricingRepository) {
        this.catalogTransportPricingRepository = catalogTransportPricingRepository;
    }

    @Override
    public CatalogTransportPricing save(CatalogTransportPricing catalogTransportPricing) {
        return CatalogTransportPricingMapper.toDto(catalogTransportPricingRepository.saveAndFlush(CatalogTransportPricingMapper.toEntity(catalogTransportPricing, false)), false);
    }

    @Override
    public List<CatalogTransportPricing> saveAll(List<CatalogTransportPricing> catalogTransportPricings) throws AttributesNotFound, ErrorType {

        List<CatalogTransportPricing> catalogTransportPricingTypeList = new ArrayList<>();

        for (CatalogTransportPricing catalogTransportPricing : catalogTransportPricings) {
            catalogTransportPricingTypeList.add(save(catalogTransportPricing));
        }

        return catalogTransportPricingTypeList;

    }
    @Override
    public Long size() {
        return catalogTransportPricingRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return catalogTransportPricingRepository.existsById(id);
    }

    @Override
    public CatalogTransportPricing findById(Long id) throws IdNotFound {
        return CatalogTransportPricingMapper.toDto(catalogTransportPricingRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CatalogTransportPricing> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CatalogTransportPricingMapper.toDtos(catalogTransportPricingRepository.findAll(Search.expression(search, TmsCatalogTransportPricing.class)), false);
    }

    @Override
    public List<CatalogTransportPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportPricingMapper.toDtos(catalogTransportPricingRepository.findAll(Search.expression(search, TmsCatalogTransportPricing.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return catalogTransportPricingRepository.count(Search.expression(search, TmsCatalogTransportPricing.class));
    }

    @Override
    public void delete(Long id) {
        catalogTransportPricingRepository.deleteById(id);
    }

    @Override
    public void delete(CatalogTransportPricing catalogTransportPricing) {
        catalogTransportPricingRepository.delete(CatalogTransportPricingMapper.toEntity(catalogTransportPricing, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            catalogTransportPricingRepository.deleteById(id);        }
    }

    @Override
    public List<CatalogTransportPricing> findAll() {
        return CatalogTransportPricingMapper.toDtos(catalogTransportPricingRepository.findAll(), false);
    }

    @Override
    public List<CatalogTransportPricing> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportPricingMapper.toDtos(catalogTransportPricingRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        String value="CT" + catalogTransportPricingRepository.getNextVal().get(0);
        return value;


    }

}


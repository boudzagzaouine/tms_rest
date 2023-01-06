package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.CatalogTransportAccountPricing;
import com.bagile.gmo.entities.TmsCatalogTransportAccountPricing;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.CatalogTransportAccountPricingMapper;
import com.bagile.gmo.repositories.CatalogTransportAccountPricingRepository;
import com.bagile.gmo.services.CatalogTransportAccountPricingService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CatalogTransportAccountPricingServiceImpl implements CatalogTransportAccountPricingService {
    private final CatalogTransportAccountPricingRepository catalogTransportAccountPricingRepository;
    
    public CatalogTransportAccountPricingServiceImpl(CatalogTransportAccountPricingRepository catalogTransportAccountPricingRepository) {
        this.catalogTransportAccountPricingRepository = catalogTransportAccountPricingRepository;
    }

    @Override
    public CatalogTransportAccountPricing save(CatalogTransportAccountPricing catalogTransportAccountPricing) {
        return CatalogTransportAccountPricingMapper.toDto(catalogTransportAccountPricingRepository.saveAndFlush(CatalogTransportAccountPricingMapper.toEntity(catalogTransportAccountPricing, false)), false);
    }

    @Override
    public List<CatalogTransportAccountPricing> saveAll(List<CatalogTransportAccountPricing> catalogTransportAccountPricings) throws AttributesNotFound, ErrorType {

        List<CatalogTransportAccountPricing> catalogTransportAccountPricingTypeList = new ArrayList<>();

        for (CatalogTransportAccountPricing catalogTransportAccountPricing : catalogTransportAccountPricings) {
            catalogTransportAccountPricingTypeList.add(save(catalogTransportAccountPricing));
        }

        return catalogTransportAccountPricingTypeList;

    }
    @Override
    public Long size() {
        return catalogTransportAccountPricingRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return catalogTransportAccountPricingRepository.existsById(id);
    }

    @Override
    public CatalogTransportAccountPricing findById(Long id) throws IdNotFound {
        return CatalogTransportAccountPricingMapper.toDto(catalogTransportAccountPricingRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CatalogTransportAccountPricing> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CatalogTransportAccountPricingMapper.toDtos(catalogTransportAccountPricingRepository.findAll(Search.expression(search, TmsCatalogTransportAccountPricing.class)), false);
    }

    @Override
    public List<CatalogTransportAccountPricing> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportAccountPricingMapper.toDtos(catalogTransportAccountPricingRepository.findAll(Search.expression(search, TmsCatalogTransportAccountPricing.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return catalogTransportAccountPricingRepository.count(Search.expression(search, TmsCatalogTransportAccountPricing.class));
    }

    @Override
    public void delete(Long id) {
        catalogTransportAccountPricingRepository.deleteById(id);
    }

    @Override
    public void delete(CatalogTransportAccountPricing catalogTransportAccountPricing) {
        catalogTransportAccountPricingRepository.delete(CatalogTransportAccountPricingMapper.toEntity(catalogTransportAccountPricing, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            catalogTransportAccountPricingRepository.deleteById(id);        }
    }

    @Override
    public List<CatalogTransportAccountPricing> findAll() {
        return CatalogTransportAccountPricingMapper.toDtos(catalogTransportAccountPricingRepository.findAll(), false);
    }

    @Override
    public List<CatalogTransportAccountPricing> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportAccountPricingMapper.toDtos(catalogTransportAccountPricingRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        String value="CT" + catalogTransportAccountPricingRepository.getNextVal().get(0);
        return value;


    }

}


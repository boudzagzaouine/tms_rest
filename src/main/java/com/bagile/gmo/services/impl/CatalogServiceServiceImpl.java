package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.CatalogService;
import com.bagile.gmo.entities.TmsCatalogService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.CatalogServiceMapper;
import com.bagile.gmo.repositories.CatalogServiceRepository;
import com.bagile.gmo.services.CatalogServiceService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CatalogServiceServiceImpl implements CatalogServiceService {
    
    private final CatalogServiceRepository catalogServiceRepository;

    public CatalogServiceServiceImpl(CatalogServiceRepository catalogServiceRepository) {
        this.catalogServiceRepository = catalogServiceRepository;
    }

    @Override
    public CatalogService save(CatalogService catalogService) {
        return CatalogServiceMapper.toDto(catalogServiceRepository.saveAndFlush(CatalogServiceMapper.toEntity(catalogService, false)), false);
    }

    @Override
    public Long size() {
        return catalogServiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return catalogServiceRepository.existsById(id);
    }

    @Override
    public CatalogService findById(Long id) throws IdNotFound {
        return CatalogServiceMapper.toDto(catalogServiceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CatalogService> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CatalogServiceMapper.toDtos(catalogServiceRepository.findAll(Search.expression(search, TmsCatalogService.class)), false);
    }

    @Override
    public List<CatalogService> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogServiceMapper.toDtos(catalogServiceRepository.findAll(Search.expression(search, TmsCatalogService.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return catalogServiceRepository.count(Search.expression(search, TmsCatalogService.class));
    }

    @Override
    public void delete(Long id) {
        catalogServiceRepository.deleteById(id);
    }

    @Override
    public void delete(CatalogService catalogService) {
        catalogServiceRepository.delete(CatalogServiceMapper.toEntity(catalogService, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            catalogServiceRepository.deleteById(id);        }
    }


    @Override
    public List<CatalogService> findAll() {
        return CatalogServiceMapper.toDtos(catalogServiceRepository.findAll(), false);
    }

    @Override
    public List<CatalogService> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogServiceMapper.toDtos(catalogServiceRepository.findAll(pageable), false);
    }

    @Override
    public CatalogService findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}


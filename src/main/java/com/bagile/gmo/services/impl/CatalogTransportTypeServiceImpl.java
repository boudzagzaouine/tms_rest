package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.CatalogTransportType;
import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.entities.GmoCatalogTransportType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.CatalogTransportTypeMapper;
import com.bagile.gmo.repositories.CatalogTransportTypeRepository;
import com.bagile.gmo.services.CatalogTransportTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class CatalogTransportTypeServiceImpl implements CatalogTransportTypeService {
    private final CatalogTransportTypeRepository catalogTransportTypeRepository;
    
    public CatalogTransportTypeServiceImpl(CatalogTransportTypeRepository catalogTransportTypeRepository) {
        this.catalogTransportTypeRepository = catalogTransportTypeRepository;
    }

    @Override
    public CatalogTransportType save(CatalogTransportType transport) {
        return CatalogTransportTypeMapper.toDto(catalogTransportTypeRepository.saveAndFlush(CatalogTransportTypeMapper.toEntity(transport, false)), false);
    }

    @Override
    public List<CatalogTransportType> saveAll(List<CatalogTransportType> catalogTransportTypes) throws AttributesNotFound, ErrorType {

        List<CatalogTransportType> transportTypeList = new ArrayList<>();

        for (CatalogTransportType catalogTransportType : catalogTransportTypes) {
            transportTypeList.add(save(catalogTransportType));
        }

        return transportTypeList;

    }
    @Override
    public Long size() {
        return catalogTransportTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return catalogTransportTypeRepository.existsById(id);
    }

    @Override
    public CatalogTransportType findById(Long id) throws IdNotFound {
        return CatalogTransportTypeMapper.toDto(catalogTransportTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CatalogTransportType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CatalogTransportTypeMapper.toDtos(catalogTransportTypeRepository.findAll(Search.expression(search, GmoCatalogTransportType.class)), false);
    }

    @Override
    public List<CatalogTransportType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportTypeMapper.toDtos(catalogTransportTypeRepository.findAll(Search.expression(search, GmoCatalogTransportType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return catalogTransportTypeRepository.count(Search.expression(search, GmoCatalogTransportType.class));
    }

    @Override
    public void delete(Long id) {
        catalogTransportTypeRepository.deleteById(id);
    }

    @Override
    public void delete(CatalogTransportType transport) {
        catalogTransportTypeRepository.delete(CatalogTransportTypeMapper.toEntity(transport, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            catalogTransportTypeRepository.deleteById(id);        }
    }

    @Override
    public List<CatalogTransportType> findAll() {
        return CatalogTransportTypeMapper.toDtos(catalogTransportTypeRepository.findAll(), false);
    }

    @Override
    public List<CatalogTransportType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CatalogTransportTypeMapper.toDtos(catalogTransportTypeRepository.findAll(pageable), false);
    }

    @Override
    public String getNextVal() {
        String value="CT" + catalogTransportTypeRepository.getNextVal().get(0);
        return value;


    }

}


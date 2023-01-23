package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TransportPlanServiceCatalog;
import com.bagile.gmo.entities.TmsTransportPlanServiceCatalog;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportPlanServiceCatalogMapper;
import com.bagile.gmo.repositories.TransportPlanServiceCatalogRepository;
import com.bagile.gmo.services.TransportPlanServiceCatalogService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransportPlanServiceCatalogImpl implements TransportPlanServiceCatalogService {

    private final TransportPlanServiceCatalogRepository transportProductRepository;

    public TransportPlanServiceCatalogImpl(TransportPlanServiceCatalogRepository transportProductRepository) {
        this.transportProductRepository = transportProductRepository;
    }

    @Override
    public TransportPlanServiceCatalog save(TransportPlanServiceCatalog transportProduct) {
        return TransportPlanServiceCatalogMapper.toDto(transportProductRepository.saveAndFlush(TransportPlanServiceCatalogMapper.toEntity(transportProduct, false)), false);
    }

    @Override
    public Long size() {
        return transportProductRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportProductRepository.existsById(id);
    }

    @Override
    public TransportPlanServiceCatalog findById(Long id) throws IdNotFound {
        return TransportPlanServiceCatalogMapper.toDto(transportProductRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportPlanServiceCatalog> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportPlanServiceCatalogMapper.toDtos(transportProductRepository.findAll(Search.expression(search, TmsTransportPlanServiceCatalog.class)), false);
    }

    @Override
    public List<TransportPlanServiceCatalog> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanServiceCatalogMapper.toDtos(transportProductRepository.findAll(Search.expression(search, TmsTransportPlanServiceCatalog.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportProductRepository.count(Search.expression(search, TmsTransportPlanServiceCatalog.class));
    }

    @Override
    public void delete(Long id) {
        transportProductRepository.deleteById(id);
    }

    @Override
    public void delete(TransportPlanServiceCatalog transportProduct) {
        transportProductRepository.delete(TransportPlanServiceCatalogMapper.toEntity(transportProduct, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportProductRepository.deleteById(id);        }
    }


    @Override
    public List<TransportPlanServiceCatalog> findAll()
    {
        return TransportPlanServiceCatalogMapper.toDtos(transportProductRepository.findAll(), false);
    }

    @Override
    public List<TransportPlanServiceCatalog> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanServiceCatalogMapper.toDtos(transportProductRepository.findAll(pageable), false);
    }

}


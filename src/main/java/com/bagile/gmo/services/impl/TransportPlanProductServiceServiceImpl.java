package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TransportPlanProductService;
import com.bagile.gmo.entities.TmsTransportPlanProductService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportPlanProductServiceMapper;
import com.bagile.gmo.repositories.TransportPlanProductServiceRepository;
import com.bagile.gmo.services.TransportPlanProductServiceService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransportPlanProductServiceServiceImpl implements TransportPlanProductServiceService {

    private final TransportPlanProductServiceRepository transportPlanProductServiceRepository;

    public TransportPlanProductServiceServiceImpl(TransportPlanProductServiceRepository transportPlanProductServiceRepository) {
        this.transportPlanProductServiceRepository = transportPlanProductServiceRepository;
    }

    @Override
    public TransportPlanProductService save(TransportPlanProductService transportPlanProductService) {
        return TransportPlanProductServiceMapper.toDto(transportPlanProductServiceRepository.saveAndFlush(TransportPlanProductServiceMapper.toEntity(transportPlanProductService, false)), false);
    }

    @Override
    public Long size() {
        return transportPlanProductServiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportPlanProductServiceRepository.existsById(id);
    }

    @Override
    public TransportPlanProductService findById(Long id) throws IdNotFound {
        return TransportPlanProductServiceMapper.toDto(transportPlanProductServiceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportPlanProductService> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportPlanProductServiceMapper.toDtos(transportPlanProductServiceRepository.findAll(Search.expression(search, TmsTransportPlanProductService.class)), false);
    }

    @Override
    public List<TransportPlanProductService> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanProductServiceMapper.toDtos(transportPlanProductServiceRepository.findAll(Search.expression(search, TmsTransportPlanProductService.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportPlanProductServiceRepository.count(Search.expression(search, TmsTransportPlanProductService.class));
    }

    @Override
    public void delete(Long id) {
        transportPlanProductServiceRepository.deleteById(id);
    }

    @Override
    public void delete(TransportPlanProductService transportPlanProductService) {
        transportPlanProductServiceRepository.delete(TransportPlanProductServiceMapper.toEntity(transportPlanProductService, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportPlanProductServiceRepository.deleteById(id);        }
    }


    @Override
    public List<TransportPlanProductService> findAll()
    {
        return TransportPlanProductServiceMapper.toDtos(transportPlanProductServiceRepository.findAll(), false);
    }

    @Override
    public List<TransportPlanProductService> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanProductServiceMapper.toDtos(transportPlanProductServiceRepository.findAll(pageable), false);
    }

}


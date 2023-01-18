package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TransportService;
import com.bagile.gmo.entities.TmsTransportService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportServiceMapper;
import com.bagile.gmo.repositories.TransportServiceRepository;
import com.bagile.gmo.services.TransportServiceService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TransportServiceServiceImpl implements TransportServiceService {

    private final TransportServiceRepository transportServiceRepository;

    public TransportServiceServiceImpl(TransportServiceRepository transportServiceRepository) {
        this.transportServiceRepository = transportServiceRepository;
    }

    @Override
    public TransportService save(TransportService transportService) {
        return TransportServiceMapper.toDto(transportServiceRepository.saveAndFlush(TransportServiceMapper.toEntity(transportService, false)), false);
    }

    @Override
    public List<TransportService> saveAll(List<TransportService> transportServices) throws AttributesNotFound, ErrorType {

        List<TransportService> transportServiceList = new ArrayList<>();

        for (TransportService transportService : transportServices) {
            transportServiceList.add(save(transportService));
        }

        return transportServiceList;

    }

    @Override
    public Long size() {
        return transportServiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportServiceRepository.existsById(id);
    }

    @Override
    public TransportService findById(Long id) throws IdNotFound {
        return TransportServiceMapper.toDto(transportServiceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportService> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportServiceMapper.toDtos(transportServiceRepository.findAll(Search.expression(search, TmsTransportService.class)), false);
    }

    @Override
    public List<TransportService> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportServiceMapper.toDtos(transportServiceRepository.findAll(Search.expression(search, TmsTransportService.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportServiceRepository.count(Search.expression(search, TmsTransportService.class));
    }

    @Override
    public void delete(Long id) {
        transportServiceRepository.deleteById(id);
    }

    @Override
    public void delete(TransportService transportService) {
        transportServiceRepository.delete(TransportServiceMapper.toEntity(transportService, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportServiceRepository.deleteById(id);        }
    }


    @Override
    public List<TransportService> findAll() {
        return TransportServiceMapper.toDtos(transportServiceRepository.findAll(), false);
    }

    @Override
    public List<TransportService> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportServiceMapper.toDtos(transportServiceRepository.findAll(pageable), false);
    }

    @Override
    public TransportService findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}


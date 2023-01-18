package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TransportAccountService;
import com.bagile.gmo.entities.TmsTransportAccountService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportAccountServiceMapper;
import com.bagile.gmo.repositories.TransportAccountServiceRepository;
import com.bagile.gmo.services.TransportAccountServiceService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TransportAccountServiceServiceImpl implements TransportAccountServiceService {

    private final TransportAccountServiceRepository transportAccountServiceRepository;

    public TransportAccountServiceServiceImpl(TransportAccountServiceRepository transportAccountServiceRepository) {
        this.transportAccountServiceRepository = transportAccountServiceRepository;
    }

    @Override
    public TransportAccountService save(TransportAccountService transportAccountService) {
        return TransportAccountServiceMapper.toDto(transportAccountServiceRepository.saveAndFlush(TransportAccountServiceMapper.toEntity(transportAccountService, false)), false);
    }

    @Override
    public List<TransportAccountService> saveAll(List<TransportAccountService> transportAccountServices) throws AttributesNotFound, ErrorType {

        List<TransportAccountService> transportAccountServiceList = new ArrayList<>();

        for (TransportAccountService transportAccountService : transportAccountServices) {
            transportAccountServiceList.add(save(transportAccountService));
        }

        return transportAccountServiceList;

    }

    @Override
    public Long size() {
        return transportAccountServiceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportAccountServiceRepository.existsById(id);
    }

    @Override
    public TransportAccountService findById(Long id) throws IdNotFound {
        return TransportAccountServiceMapper.toDto(transportAccountServiceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportAccountService> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportAccountServiceMapper.toDtos(transportAccountServiceRepository.findAll(Search.expression(search, TmsTransportAccountService.class)), false);
    }

    @Override
    public List<TransportAccountService> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportAccountServiceMapper.toDtos(transportAccountServiceRepository.findAll(Search.expression(search, TmsTransportAccountService.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportAccountServiceRepository.count(Search.expression(search, TmsTransportAccountService.class));
    }

    @Override
    public void delete(Long id) {
        transportAccountServiceRepository.deleteById(id);
    }

    @Override
    public void delete(TransportAccountService transportAccountService) {
        transportAccountServiceRepository.delete(TransportAccountServiceMapper.toEntity(transportAccountService, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportAccountServiceRepository.deleteById(id);        }
    }


    @Override
    public List<TransportAccountService> findAll() {
        return TransportAccountServiceMapper.toDtos(transportAccountServiceRepository.findAll(), false);
    }

    @Override
    public List<TransportAccountService> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportAccountServiceMapper.toDtos(transportAccountServiceRepository.findAll(pageable), false);
    }

    @Override
    public TransportAccountService findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}


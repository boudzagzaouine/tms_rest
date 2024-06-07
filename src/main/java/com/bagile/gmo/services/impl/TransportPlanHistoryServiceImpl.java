package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TransportPlanHistory;
import com.bagile.gmo.entities.TmsTransportPlanHistory;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportPlanHistoryMapper;
import com.bagile.gmo.repositories.TransportPlanHistoryRepository;
import com.bagile.gmo.services.TransportPlanHistoryService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransportPlanHistoryServiceImpl implements TransportPlanHistoryService {
    
    private final TransportPlanHistoryRepository transportPlanHistoryRepository;

    public TransportPlanHistoryServiceImpl(TransportPlanHistoryRepository transportPlanHistoryRepository) {
        this.transportPlanHistoryRepository = transportPlanHistoryRepository;
    }

    @Override
    public TransportPlanHistory save(TransportPlanHistory transportPlanHistory) {
        return TransportPlanHistoryMapper.toDto(transportPlanHistoryRepository.saveAndFlush(TransportPlanHistoryMapper.toEntity(transportPlanHistory, false)), false);
    }

    @Override
    public Long size() {
        return transportPlanHistoryRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportPlanHistoryRepository.existsById(id);
    }

    @Override
    public TransportPlanHistory findById(Long id) throws IdNotFound {
        return TransportPlanHistoryMapper.toDto(transportPlanHistoryRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportPlanHistory> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportPlanHistoryMapper.toDtos(transportPlanHistoryRepository.findAll(Search.expression(search, TmsTransportPlanHistory.class)), false);
    }

    @Override
    public List<TransportPlanHistory> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanHistoryMapper.toDtos(transportPlanHistoryRepository.findAll(Search.expression(search, TmsTransportPlanHistory.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportPlanHistoryRepository.count(Search.expression(search, TmsTransportPlanHistory.class));
    }

    @Override
    public void delete(Long id) {
        transportPlanHistoryRepository.deleteById(id);
    }

    @Override
    public void deleteByOt(Long otId) throws ErrorType, AttributesNotFound {
        List<Long> history =find("orderTransport.id:"+ otId).stream().map(m-> m.getId()).collect(Collectors.toList());

        if(history.size()>0){
            deleteAll(history);

        }

    }

    @Override
    public void delete(TransportPlanHistory transportPlanHistory) {
        transportPlanHistoryRepository.delete(TransportPlanHistoryMapper.toEntity(transportPlanHistory, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportPlanHistoryRepository.deleteById(id);        }
    }


    @Override
    public List<TransportPlanHistory> findAll() {
        return TransportPlanHistoryMapper.toDtos(transportPlanHistoryRepository.findAll(), false);
    }

    @Override
    public List<TransportPlanHistory> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanHistoryMapper.toDtos(transportPlanHistoryRepository.findAll(pageable), false);
    }

    @Override
    public TransportPlanHistory findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public String getNextVal() {
        return null;


    }



}


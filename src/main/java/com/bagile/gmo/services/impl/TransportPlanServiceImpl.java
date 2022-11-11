package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TransportPlan;
import com.bagile.gmo.entities.TmsTransportPlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TransportPlanMapper;
import com.bagile.gmo.repositories.TransportPlanRepository;
import com.bagile.gmo.services.TransportPlanService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransportPlanServiceImpl implements TransportPlanService {
    
    private final TransportPlanRepository transportPlanRepository;

    public TransportPlanServiceImpl(TransportPlanRepository transportPlanRepository) {
        this.transportPlanRepository = transportPlanRepository;
    }

    @Override
    public TransportPlan save(TransportPlan transportPlan) {
        return TransportPlanMapper.toDto(transportPlanRepository.saveAndFlush(TransportPlanMapper.toEntity(transportPlan, false)), false);
    }

    @Override
    public Long size() {
        return transportPlanRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return transportPlanRepository.existsById(id);
    }

    @Override
    public TransportPlan findById(Long id) throws IdNotFound {
        return TransportPlanMapper.toDto(transportPlanRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TransportPlan> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TransportPlanMapper.toDtos(transportPlanRepository.findAll(Search.expression(search, TmsTransportPlan.class)), false);
    }

    @Override
    public List<TransportPlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanMapper.toDtos(transportPlanRepository.findAll(Search.expression(search, TmsTransportPlan.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return transportPlanRepository.count(Search.expression(search, TmsTransportPlan.class));
    }

    @Override
    public void delete(Long id) {
        transportPlanRepository.deleteById(id);
    }

    @Override
    public void delete(TransportPlan transportPlan) {
        transportPlanRepository.delete(TransportPlanMapper.toEntity(transportPlan, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            transportPlanRepository.deleteById(id);        }
    }


    @Override
    public List<TransportPlan> findAll() {
        return TransportPlanMapper.toDtos(transportPlanRepository.findAll(), false);
    }

    @Override
    public List<TransportPlan> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TransportPlanMapper.toDtos(transportPlanRepository.findAll(pageable), false);
    }

    @Override
    public TransportPlan findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public String getNextVal() {
        return null;


    }

}


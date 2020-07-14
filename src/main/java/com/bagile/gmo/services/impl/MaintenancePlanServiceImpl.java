package com.bagile.gmo.services.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.dto.MaintenancePlan;
import com.bagile.gmo.entities.GmoMaintenancePlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenancePlanMapper;
import com.bagile.gmo.repositories.MaintenancePlanRepository;
import com.bagile.gmo.services.MaintenancePlanService;
import com.bagile.gmo.util.Search;


@Service
@Transactional
public class MaintenancePlanServiceImpl implements MaintenancePlanService {

    private final MaintenancePlanRepository maintenancePlanRepository;
    public MaintenancePlanServiceImpl(MaintenancePlanRepository maintenancePlanRepository) {
        this.maintenancePlanRepository = maintenancePlanRepository;
    }

    @Override
    public MaintenancePlan save(MaintenancePlan maintenancePlan) {
        return MaintenancePlanMapper.toDto(maintenancePlanRepository.save(MaintenancePlanMapper.toEntity(maintenancePlan, false)), false);
    }

    @Override
    public Long size() {
        return maintenancePlanRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenancePlanRepository.existsById(id);
    }

    @Override
    public MaintenancePlan findById(Long id) throws IdNotFound {
        return MaintenancePlanMapper.toDto(maintenancePlanRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<MaintenancePlan> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(Search.expression(search, GmoMaintenancePlan.class)), false);
    }

    @Override
    public List<MaintenancePlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(Search.expression(search, GmoMaintenancePlan.class), pageable), false);
    }

    @Override
    public MaintenancePlan findOne(String search) throws AttributesNotFound, ErrorType {
        return MaintenancePlanMapper.toDto (maintenancePlanRepository.findOne (Search.expression (search, GmoMaintenancePlan.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return maintenancePlanRepository.count(Search.expression(search, GmoMaintenancePlan.class));
    }

    @Override
    public void delete(Long id) {
        maintenancePlanRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenancePlan maintenancePlan) {
        maintenancePlanRepository.delete(MaintenancePlanMapper.toEntity(maintenancePlan, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            maintenancePlanRepository.deleteById(id);        }
    }
    @Override
    public List<MaintenancePlan> findAll() {
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(), false);
    }

    @Override
    public List<MaintenancePlan> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenancePlanMapper.toDtos(maintenancePlanRepository.findAll(pageable), false);
    }



}


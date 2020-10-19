package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ActionLineMaintenance;
import com.bagile.gmo.entities.GmoActionLineMaintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ActionLineMaintenanceMapper;
import com.bagile.gmo.repositories.ActionLineMaintenanceRepository;
import com.bagile.gmo.services.ActionLineMaintenanceService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ActionLineMaintenanceServiceImpl implements ActionLineMaintenanceService {

    private final ActionLineMaintenanceRepository actionLineRepository;


    public ActionLineMaintenanceServiceImpl(ActionLineMaintenanceRepository actionLineRepository
                                          ) {
        this.actionLineRepository = actionLineRepository;

    }

    @Override
    public ActionLineMaintenance save(ActionLineMaintenance action) {
        return ActionLineMaintenanceMapper.toDto(actionLineRepository.saveAndFlush(ActionLineMaintenanceMapper.toEntity(action, false)), false);
    }

    @Override
    public Long size() {
        return actionLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionLineRepository.existsById(id);
    }

    @Override
    public ActionLineMaintenance findById(Long id) throws IdNotFound {
        return ActionLineMaintenanceMapper.toDto(actionLineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ActionLineMaintenance> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ActionLineMaintenanceMapper.toDtos(actionLineRepository.findAll(Search.expression(search, GmoActionLineMaintenance.class)), false);
    }

    @Override
    public List<ActionLineMaintenance> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionLineMaintenanceMapper.toDtos(actionLineRepository.findAll(Search.expression(search, GmoActionLineMaintenance.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionLineRepository.count(Search.expression(search, GmoActionLineMaintenance.class));
    }

    @Override
    public void delete(Long id) {
        actionLineRepository.deleteById(id);
    }

    @Override
    public void delete(ActionLineMaintenance action) {
        actionLineRepository.delete(ActionLineMaintenanceMapper.toEntity(action, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            actionLineRepository.deleteById(id);        }
    }


    @Override
    public List<ActionLineMaintenance> findAll() {
        return ActionLineMaintenanceMapper.toDtos(actionLineRepository.findAll(), false);
    }

    @Override
    public List<ActionLineMaintenance> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionLineMaintenanceMapper.toDtos(actionLineRepository.findAll(pageable), false);
    }

    @Override
    public ActionLineMaintenance findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }







}


package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ActionMaintenance;
import com.bagile.gmo.entities.GmoAction;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ActionMaintenanceMapper;
import com.bagile.gmo.repositories.ActionMaintenanceRepository;
import com.bagile.gmo.repositories.ActionRepository;
import com.bagile.gmo.services.ActionMaintenanceService;
import com.bagile.gmo.services.ActionService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ActionMaintenanceServiceImpl implements ActionMaintenanceService {

    private final ActionMaintenanceRepository actionMaintenanceRepository;

    public ActionMaintenanceServiceImpl(ActionMaintenanceRepository actionMaintenanceRepository) {
        this.actionMaintenanceRepository = actionMaintenanceRepository;
    }

    @Override
    public ActionMaintenance save(ActionMaintenance action) {
        return ActionMaintenanceMapper.toDto(actionMaintenanceRepository.saveAndFlush(ActionMaintenanceMapper.toEntity(action, false)), false);
    }

    @Override
    public List<ActionMaintenance> saveAll(List<ActionMaintenance> ActionMaintenance) {

        List<ActionMaintenance> actionList = new ArrayList<>( );
        for (ActionMaintenance action : ActionMaintenance) {
            actionList.add (save (action));
        }

        return actionList;

    }
    @Override
    public Long size() {
        return actionMaintenanceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionMaintenanceRepository.existsById(id);
    }

    @Override
    public ActionMaintenance findById(Long id) throws IdNotFound {
        return ActionMaintenanceMapper.toDto(actionMaintenanceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ActionMaintenance> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ActionMaintenanceMapper.toDtos(actionMaintenanceRepository.findAll(Search.expression(search, GmoAction.class)), false);
    }

    @Override
    public List<ActionMaintenance> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionMaintenanceMapper.toDtos(actionMaintenanceRepository.findAll(Search.expression(search, GmoAction.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionMaintenanceRepository.count(Search.expression(search, GmoAction.class));
    }

    @Override
    public void delete(Long id) {
        actionMaintenanceRepository.deleteById(id);
    }

    @Override
    public void delete(ActionMaintenance action) {
        actionMaintenanceRepository.delete(ActionMaintenanceMapper.toEntity(action, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            actionMaintenanceRepository.deleteById(id);        }
    }


    @Override
    public List<ActionMaintenance> findAll() {
        return ActionMaintenanceMapper.toDtos(actionMaintenanceRepository.findAll(), false);
    }

    @Override
    public List<ActionMaintenance> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionMaintenanceMapper.toDtos(actionMaintenanceRepository.findAll(pageable), false);
    }

    @Override
    public ActionMaintenance findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}


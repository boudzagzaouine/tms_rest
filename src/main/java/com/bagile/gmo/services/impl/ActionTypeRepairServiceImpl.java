package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ActionTypeRepair;
import com.bagile.gmo.entities.GmoActionTypeRepair;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ActionTypeRepairMapper;
import com.bagile.gmo.repositories.ActionTypeRepairRepository;
import com.bagile.gmo.services.ActionTypeRepairService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActionTypeRepairServiceImpl implements ActionTypeRepairService {
    
    private final ActionTypeRepairRepository actionTypeRepairRepository;

    public ActionTypeRepairServiceImpl(ActionTypeRepairRepository actionTypeRepairRepository) {
        this.actionTypeRepairRepository = actionTypeRepairRepository;
    }

    @Override
    public ActionTypeRepair save(ActionTypeRepair actionTypeRepair) {
        return ActionTypeRepairMapper.toDto(actionTypeRepairRepository.saveAndFlush(ActionTypeRepairMapper.toEntity(actionTypeRepair, false)), false);
    }

    @Override
    public Long size() {
        return actionTypeRepairRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionTypeRepairRepository.existsById(id);
    }

    @Override
    public ActionTypeRepair findById(Long id) throws IdNotFound {
        return ActionTypeRepairMapper.toDto(actionTypeRepairRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ActionTypeRepair> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ActionTypeRepairMapper.toDtos(actionTypeRepairRepository.findAll(Search.expression(search, GmoActionTypeRepair.class)), false);
    }

    @Override
    public List<ActionTypeRepair> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionTypeRepairMapper.toDtos(actionTypeRepairRepository.findAll(Search.expression(search, GmoActionTypeRepair.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionTypeRepairRepository.count(Search.expression(search, GmoActionTypeRepair.class));
    }

    @Override
    public void delete(Long id) {
        actionTypeRepairRepository.deleteById(id);
    }

    @Override
    public void delete(ActionTypeRepair actionTypeRepair) {
        actionTypeRepairRepository.delete(ActionTypeRepairMapper.toEntity(actionTypeRepair, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            actionTypeRepairRepository.deleteById(id);        }
    }


    @Override
    public List<ActionTypeRepair> findAll() {
        return ActionTypeRepairMapper.toDtos(actionTypeRepairRepository.findAll(), false);
    }

    @Override
    public List<ActionTypeRepair> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionTypeRepairMapper.toDtos(actionTypeRepairRepository.findAll(pageable), false);
    }

    @Override
    public ActionTypeRepair findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}


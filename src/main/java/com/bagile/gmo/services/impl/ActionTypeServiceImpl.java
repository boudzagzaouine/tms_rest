package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ActionType;
import com.bagile.gmo.entities.GmoActionType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ActionTypeMapper;
import com.bagile.gmo.repositories.ActionTypeRepository;
import com.bagile.gmo.services.ActionTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ActionTypeServiceImpl implements ActionTypeService {
    
    private final ActionTypeRepository actionTypeRepository;

    public ActionTypeServiceImpl(ActionTypeRepository actionTypeRepository) {
        this.actionTypeRepository = actionTypeRepository;
    }

    @Override
    public ActionType save(ActionType actionType) {
        return ActionTypeMapper.toDto(actionTypeRepository.saveAndFlush(ActionTypeMapper.toEntity(actionType, false)), false);
    }

    @Override
    public Long size() {
        return actionTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionTypeRepository.existsById(id);
    }

    @Override
    public ActionType findById(Long id) throws IdNotFound {
        return ActionTypeMapper.toDto(actionTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ActionType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ActionTypeMapper.toDtos(actionTypeRepository.findAll(Search.expression(search, GmoActionType.class)), false);
    }

    @Override
    public List<ActionType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionTypeMapper.toDtos(actionTypeRepository.findAll(Search.expression(search, GmoActionType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionTypeRepository.count(Search.expression(search, GmoActionType.class));
    }

    @Override
    public void delete(Long id) {
        actionTypeRepository.deleteById(id);
    }

    @Override
    public void delete(ActionType actionType) {
        actionTypeRepository.delete(ActionTypeMapper.toEntity(actionType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            actionTypeRepository.deleteById(id);        }
    }


    @Override
    public List<ActionType> findAll() {
        return ActionTypeMapper.toDtos(actionTypeRepository.findAll(), false);
    }

    @Override
    public List<ActionType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionTypeMapper.toDtos(actionTypeRepository.findAll(pageable), false);
    }

    @Override
    public ActionType findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}


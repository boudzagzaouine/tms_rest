package com.bagile.gmo.services.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.dto.Action;
import com.bagile.gmo.entities.GmoAction;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ActionMapper;
import com.bagile.gmo.repositories.ActionRepository;
import com.bagile.gmo.services.ActionService;
import com.bagile.gmo.util.Search;


@Service
@Transactional
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionPlanRepository;
    public ActionServiceImpl(ActionRepository actionPlanRepository) {
        this.actionPlanRepository = actionPlanRepository;
    }

    @Override
    public Action save(Action actionPlan) {
    	GmoAction gmoAction = actionPlanRepository.save(ActionMapper.toEntity(actionPlan, false));
        return ActionMapper.toDto(gmoAction, false);
    }

    @Override
    public Long size() {
        return actionPlanRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionPlanRepository.existsById(id);
    }

    @Override
    public Action findById(Long id) throws IdNotFound {
        return ActionMapper.toDto(actionPlanRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<Action> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ActionMapper.toDtos(actionPlanRepository.findAll(Search.expression(search, GmoAction.class)), false);
    }

    @Override
    public List<Action> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionMapper.toDtos(actionPlanRepository.findAll(Search.expression(search, GmoAction.class), pageable), false);
    }

    @Override
    public Action findOne(String search) throws AttributesNotFound, ErrorType {
        return ActionMapper.toDto (actionPlanRepository.findOne (Search.expression (search, GmoAction.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionPlanRepository.count(Search.expression(search, GmoAction.class));
    }

    @Override
    public void delete(Long id) {
        actionPlanRepository.deleteById(id);
    }

    @Override
    public void delete(Action actionPlan) {
        actionPlanRepository.delete(ActionMapper.toEntity(actionPlan, false));
    }

    @Override
    public List<Action> findAll() {
        return ActionMapper.toDtos(actionPlanRepository.findAll(), false);
    }

    @Override
    public List<Action> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionMapper.toDtos(actionPlanRepository.findAll(pageable), false);
    }



}


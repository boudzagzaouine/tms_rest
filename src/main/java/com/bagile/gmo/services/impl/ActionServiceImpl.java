package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Action;
import com.bagile.gmo.entities.GmoAction;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ActionMapper;
import com.bagile.gmo.repositories.ActionRepository;
import com.bagile.gmo.services.ActionService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;

    public ActionServiceImpl(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public Action save(Action action) {
        return ActionMapper.toDto(actionRepository.saveAndFlush(ActionMapper.toEntity(action, false)), false);
    }

    @Override
    public Long size() {
        return actionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionRepository.existsById(id);
    }

    @Override
    public Action findById(Long id) throws IdNotFound {
        return ActionMapper.toDto(actionRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Action> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ActionMapper.toDtos(actionRepository.findAll(Search.expression(search, GmoAction.class)), false);
    }

    @Override
    public List<Action> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionMapper.toDtos(actionRepository.findAll(Search.expression(search, GmoAction.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionRepository.count(Search.expression(search, GmoAction.class));
    }

    @Override
    public void delete(Long id) {
        actionRepository.deleteById(id);
    }

    @Override
    public void delete(Action action) {
        actionRepository.delete(ActionMapper.toEntity(action, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            actionRepository.deleteById(id);        }
    }


    @Override
    public List<Action> findAll() {
        return ActionMapper.toDtos(actionRepository.findAll(), false);
    }

    @Override
    public List<Action> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionMapper.toDtos(actionRepository.findAll(pageable), false);
    }

    @Override
    public Action findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}


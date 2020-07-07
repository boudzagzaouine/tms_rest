package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ActionLine;
import com.bagile.gmo.entities.GmoActionLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ActionLineMapper;
import com.bagile.gmo.repositories.ActionLineRepository;
import com.bagile.gmo.services.ActionLineService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ActionLineServiceImpl implements ActionLineService {

    private final ActionLineRepository actionLineRepository;

    public ActionLineServiceImpl(ActionLineRepository actionLineRepository) {
        this.actionLineRepository = actionLineRepository;
    }

    @Override
    public ActionLine save(ActionLine action) {
        return ActionLineMapper.toDto(actionLineRepository.saveAndFlush(ActionLineMapper.toEntity(action, false)), false);
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
    public ActionLine findById(Long id) throws IdNotFound {
        return ActionLineMapper.toDto(actionLineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ActionLine> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ActionLineMapper.toDtos(actionLineRepository.findAll(Search.expression(search, GmoActionLine.class)), false);
    }

    @Override
    public List<ActionLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionLineMapper.toDtos(actionLineRepository.findAll(Search.expression(search, GmoActionLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return actionLineRepository.count(Search.expression(search, GmoActionLine.class));
    }

    @Override
    public void delete(Long id) {
        actionLineRepository.deleteById(id);
    }

    @Override
    public void delete(ActionLine action) {
        actionLineRepository.delete(ActionLineMapper.toEntity(action, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            actionLineRepository.deleteById(id);        }
    }


    @Override
    public List<ActionLine> findAll() {
        return ActionLineMapper.toDtos(actionLineRepository.findAll(), false);
    }

    @Override
    public List<ActionLine> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ActionLineMapper.toDtos(actionLineRepository.findAll(pageable), false);
    }

    @Override
    public ActionLine findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}


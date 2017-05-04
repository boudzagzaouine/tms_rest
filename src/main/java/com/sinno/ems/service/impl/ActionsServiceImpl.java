package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Actions;
import com.sinno.ems.entities.UsrActions;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ActionsMapper;
import com.sinno.ems.repositories.ActionsRepository;
import com.sinno.ems.service.ActionsService;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionsServiceImpl implements ActionsService {

    @Autowired
    private ActionsRepository actionsRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ActionsService.class);

    @Override
    public Actions save(Actions actions) {
        LOGGER.info("save Actions");
        if (0 >= actions.getId()) {
            actions.setCreationDate(EmsDate.getDateNow());
        }
        return ActionsMapper.toDto(actionsRepository.saveAndFlush(ActionsMapper.toEntity(actions, false)), false);
    }

    @Override
    public Long size() {
        return actionsRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return actionsRepository.exists(id);
    }

    @Override
    public Actions findById(Long id) throws IdNotFound {
        Actions actions = ActionsMapper.toDto(actionsRepository.findOne(id), false);
        if (null != actions) {
            return actions;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Actions> find(String search) throws AttributesNotFound, ErrorType {
        return ActionsMapper.toDtos(actionsRepository.findAll(Search.expression(search, UsrActions.class)), false);
    }

    @Override
    public List<Actions> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ActionsMapper.toDtos(actionsRepository.findAll(Search.expression(search, UsrActions.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return actionsRepository.count(Search.expression(search, UsrActions.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Actions");
        actionsRepository.delete(id);
    }

    @Override
    public void delete(Actions actions) {
        LOGGER.info("delete Actions");
        actionsRepository.delete(ActionsMapper.toEntity(actions, false));
    }

    @Override
    public List<Actions> findAll() {
        return ActionsMapper.toDtos(actionsRepository.findAll(), false);
    }

    @Override
    public List<Actions> findAll(Pageable pageable) {
        return ActionsMapper.toDtos(actionsRepository.findAll(pageable), false);
    }
}
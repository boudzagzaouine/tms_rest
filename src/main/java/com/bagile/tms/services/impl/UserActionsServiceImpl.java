package com.bagile.tms.services.impl;

import com.sinno.ems.dto.UserActions;
import com.sinno.ems.entities.UsrUserActions;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.UserActionsMapper;
import com.sinno.ems.repositories.UserActionsRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.UserActionsService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActionsServiceImpl implements UserActionsService {

    @Autowired
    private UserActionsRepository userActionsRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserActionsService.class);

    @Override
    public UserActions save(UserActions userActions) {
        LOGGER.info("save UserActions");
        if (0 >= userActions.getId()) {
            userActions.setCreationDate(EmsDate.getDateNow());
        }
        return UserActionsMapper.toDto(userActionsRepository.saveAndFlush(UserActionsMapper.toEntity(userActions, false)), false);
    }

    @Override
    public Long size() {
        return userActionsRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return userActionsRepository.exists(id);
    }

    @Override
    public UserActions findById(Long id) throws IdNotFound {
        UserActions userActions = UserActionsMapper.toDto(userActionsRepository.findOne(id), false);
        if (null != userActions) {
            return userActions;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<UserActions> find(String search) throws AttributesNotFound, ErrorType {
        return UserActionsMapper.toDtos(userActionsRepository.findAll(Search.expression(search, UsrUserActions.class)), false);
    }

    @Override
    public List<UserActions> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return UserActionsMapper.toDtos(userActionsRepository.findAll(Search.expression(search, UsrUserActions.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return userActionsRepository.count(Search.expression(search, UsrUserActions.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete UserActions");
        userActionsRepository.delete(id);
    }

    @Override
    public void delete(UserActions userActions) {
        LOGGER.info("delete UserActions");
        userActionsRepository.delete(UserActionsMapper.toEntity(userActions, false));
    }

    @Override
    public List<UserActions> findAll() {
        return UserActionsMapper.toDtos(userActionsRepository.findAll(), false);
    }

    @Override
    public List<UserActions> findAll(Pageable pageable) {
        return UserActionsMapper.toDtos(userActionsRepository.findAll(pageable), false);
    }
}
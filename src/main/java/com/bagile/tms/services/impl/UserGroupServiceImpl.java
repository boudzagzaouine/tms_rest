package com.bagile.tms.services.impl;

import com.sinno.ems.dto.UserGroup;
import com.sinno.ems.entities.UsrUserGroup;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.UserGroupMapper;
import com.sinno.ems.repositories.UserGroupRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.UserGroupService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserGroupService.class);

    @Override
    public UserGroup save(UserGroup userGroup) {
        LOGGER.info("save UserGroup");
        userGroup.setType(1L);
        return UserGroupMapper.toDto(userGroupRepository.saveAndFlush(UserGroupMapper.toEntity(userGroup, false)), false);
    }

    @Override
    public Long size() {
        return userGroupRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return userGroupRepository.exists(id);
    }

    @Override
    public UserGroup findById(Long id) throws IdNotFound {
        UserGroup userGroup = UserGroupMapper.toDto(userGroupRepository.findOne(id), false);
        if (null != userGroup) {
            return userGroup;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<UserGroup> find(String search) throws AttributesNotFound, ErrorType {
        return UserGroupMapper.toDtos(userGroupRepository.findAll(Search.expression(search, UsrUserGroup.class)), false);
    }

    @Override
    public List<UserGroup> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return UserGroupMapper.toDtos(userGroupRepository.findAll(Search.expression(search, UsrUserGroup.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return userGroupRepository.count(Search.expression(search, UsrUserGroup.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete UserGroup");
        userGroupRepository.delete(id);
    }

    @Override
    public void delete(UserGroup userGroup) {
        LOGGER.info("delete UserGroup");
        userGroupRepository.delete(UserGroupMapper.toEntity(userGroup, false));
    }

    @Override
    public List<UserGroup> findAll() {
        return UserGroupMapper.toDtos(userGroupRepository.findAll(), false);
    }

    @Override
    public List<UserGroup> findAll(Pageable pageable) {
        return UserGroupMapper.toDtos(userGroupRepository.findAll(pageable), false);
    }
}
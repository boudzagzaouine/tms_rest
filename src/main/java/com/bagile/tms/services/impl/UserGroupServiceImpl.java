package com.bagile.tms.services.impl;

import com.bagile.tms.dto.UserGroup;
import com.bagile.tms.entities.UsrUserGroup;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.UserGroupMapper;
import com.bagile.tms.repositories.UserGroupRepository;
import com.bagile.tms.services.UserGroupService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
        return userGroupRepository.existsById(id);
    }

    @Override
    public UserGroup findById(Long id) throws IdNotFound {
        UserGroup userGroup = UserGroupMapper.toDto(userGroupRepository.findById(id).get(), false);
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
        userGroupRepository.deleteById(id);
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
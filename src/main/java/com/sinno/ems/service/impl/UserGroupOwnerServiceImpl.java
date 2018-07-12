package com.sinno.ems.service.impl;

import com.sinno.ems.dto.UserGroupOwner;
import com.sinno.ems.entities.UsrUserGroupOwner;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.UserGroupOwnerMapper;
import com.sinno.ems.repositories.UserGroupOwnerRepository;
import com.sinno.ems.service.UserGroupOwnerService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupOwnerServiceImpl implements UserGroupOwnerService {

    @Autowired
    private UserGroupOwnerRepository userGroupOwnerRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserGroupOwnerService.class);

    @Override
    public UserGroupOwner save(UserGroupOwner userGroupOwner) {
        LOGGER.info("save UserGroupOwner");
        return UserGroupOwnerMapper.toDto(userGroupOwnerRepository.saveAndFlush(UserGroupOwnerMapper.toEntity(userGroupOwner, false)), false);
    }

    @Override
    public Long size() {
        return userGroupOwnerRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return userGroupOwnerRepository.exists(id);
    }

    @Override
    public UserGroupOwner findById(Long id) throws IdNotFound {
        UserGroupOwner userGroupOwner = UserGroupOwnerMapper.toDto(userGroupOwnerRepository.findOne(id), false);
        if (null != userGroupOwner) {
            return userGroupOwner;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<UserGroupOwner> find(String search) throws AttributesNotFound, ErrorType {
        return UserGroupOwnerMapper.toDtos(userGroupOwnerRepository.findAll(Search.expression(search, UsrUserGroupOwner.class)), false);
    }

    @Override
    public List<UserGroupOwner> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return UserGroupOwnerMapper.toDtos(userGroupOwnerRepository.findAll(Search.expression(search, UsrUserGroupOwner.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return userGroupOwnerRepository.count(Search.expression(search, UsrUserGroupOwner.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete UserGroupOwner");
        userGroupOwnerRepository.delete(id);
    }

    @Override
    public void delete(UserGroupOwner userGroupOwner) {
        LOGGER.info("delete UserGroupOwner");
        userGroupOwnerRepository.delete(UserGroupOwnerMapper.toEntity(userGroupOwner, false));
    }

    @Override
    public List<UserGroupOwner> findAll() {
        return UserGroupOwnerMapper.toDtos(userGroupOwnerRepository.findAll(), false);
    }

    @Override
    public List<UserGroupOwner> findAll(Pageable pageable) {
        return UserGroupOwnerMapper.toDtos(userGroupOwnerRepository.findAll(pageable), false);
    }
}
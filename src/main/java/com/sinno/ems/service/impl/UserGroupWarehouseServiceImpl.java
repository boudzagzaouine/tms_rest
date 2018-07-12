package com.sinno.ems.service.impl;

import com.sinno.ems.entities.UsrUserGroupWarehouse;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.UserGroupWarehouseMapper;
import com.sinno.ems.repositories.UserGroupWarehouseRepository;
import com.sinno.ems.service.UserGroupWarehouseService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupWarehouseServiceImpl implements UserGroupWarehouseService {

    @Autowired
    private UserGroupWarehouseRepository userGroupWarehouseRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserGroupWarehouseService.class);

    @Override
    public UserGroupWarehouse save(UserGroupWarehouse userGroupWarehouse) {
        LOGGER.info("save UserGroupWareHouse");
        return UserGroupWarehouseMapper.toDto(userGroupWarehouseRepository.saveAndFlush(UserGroupWarehouseMapper.toEntity(userGroupWarehouse, false)), false);
    }

    @Override
    public Long size() {
        return userGroupWarehouseRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return userGroupWarehouseRepository.exists(id);
    }

    @Override
    public UserGroupWarehouse findById(Long id) throws IdNotFound {
        UserGroupWarehouse userGroupWarehouse = UserGroupWarehouseMapper.toDto(userGroupWarehouseRepository.findOne(id), false);
        if (null != userGroupWarehouse) {
            return userGroupWarehouse;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<UserGroupWarehouse> find(String search) throws AttributesNotFound, ErrorType {
        return UserGroupWarehouseMapper.toDtos(userGroupWarehouseRepository.findAll(Search.expression(search, UsrUserGroupWarehouse.class)), false);
    }

    @Override
    public List<UserGroupWarehouse> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return UserGroupWarehouseMapper.toDtos(userGroupWarehouseRepository.findAll(Search.expression(search, UsrUserGroupWarehouse.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return userGroupWarehouseRepository.count(Search.expression(search, UsrUserGroupWarehouse.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete UserGroupWarehouse");
        userGroupWarehouseRepository.delete(id);
    }

    @Override
    public void delete(UserGroupWarehouse userGroupWarehouse) {
        LOGGER.info("delete UserGroupWarehouse");
        userGroupWarehouseRepository.delete(UserGroupWarehouseMapper.toEntity(userGroupWarehouse, false));
    }

    @Override
    public List<UserGroupWarehouse> findAll() {
        return UserGroupWarehouseMapper.toDtos(userGroupWarehouseRepository.findAll(), false);
    }

    @Override
    public List<UserGroupWarehouse> findAll(Pageable pageable) {
        return UserGroupWarehouseMapper.toDtos(userGroupWarehouseRepository.findAll(pageable), false);
    }
}
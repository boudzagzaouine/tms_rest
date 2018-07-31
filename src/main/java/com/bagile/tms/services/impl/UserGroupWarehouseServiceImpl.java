package com.bagile.tms.services.impl;

import com.bagile.tms.dto.UserGroupWarehouse;
import com.bagile.tms.entities.UsrUserGroupWarehouse;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.UserGroupWarehouseMapper;
import com.bagile.tms.repositories.UserGroupWarehouseRepository;
import com.bagile.tms.services.UserGroupWarehouseService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
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
        return userGroupWarehouseRepository.existsById(id);
    }

    @Override
    public UserGroupWarehouse findById(Long id) throws IdNotFound {
        UserGroupWarehouse userGroupWarehouse = UserGroupWarehouseMapper.toDto(userGroupWarehouseRepository.findById(id).get(), false);
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
        userGroupWarehouseRepository.deleteById(id);
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
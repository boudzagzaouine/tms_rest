package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.UserGroupOwner;
import com.bagile.gmo.entities.UsrUserGroupOwner;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.UserGroupOwnerMapper;
import com.bagile.gmo.repositories.UserGroupOwnerRepository;
import com.bagile.gmo.services.UserGroupOwnerService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserGroupOwnerServiceImpl implements UserGroupOwnerService {

    private final UserGroupOwnerRepository userGroupOwnerRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserGroupOwnerService.class);

    public UserGroupOwnerServiceImpl(UserGroupOwnerRepository userGroupOwnerRepository) {
        this.userGroupOwnerRepository = userGroupOwnerRepository;
    }

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
        return userGroupOwnerRepository.existsById(id);
    }

    @Override
    public UserGroupOwner findById(Long id) throws IdNotFound {
        UserGroupOwner userGroupOwner = UserGroupOwnerMapper.toDto(userGroupOwnerRepository.findById(id).get(), false);
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
        userGroupOwnerRepository.deleteById(id);
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
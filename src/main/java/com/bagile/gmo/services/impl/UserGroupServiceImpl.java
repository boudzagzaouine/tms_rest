package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.UserGroup;
import com.bagile.gmo.dto.UserGroup;
import com.bagile.gmo.entities.UsrUserGroup;
import com.bagile.gmo.entities.UsrUserGroup;
import com.bagile.gmo.entities.UsrUserGroup;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.UserGroupMapper;
import com.bagile.gmo.mapper.UserGroupMapper;
import com.bagile.gmo.repositories.UserGroupRepository;
import com.bagile.gmo.services.UserGroupService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService {

    private final UserGroupRepository userGroupRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserGroupService.class);

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

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
        return UserGroupMapper.toDto(userGroupRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<UserGroup> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return UserGroupMapper.toDtos(userGroupRepository.findAll(Search.expression(search, UsrUserGroup.class)), false);
    }

    @Override
    public List<UserGroup> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return UserGroupMapper.toDtos(userGroupRepository.findAll(Search.expression(search, UsrUserGroup.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return userGroupRepository.count(Search.expression(search, UsrUserGroup.class));
    }

    @Override
    public void delete(Long id) {
        userGroupRepository.deleteById(id);
    }

    @Override
    public void delete(UserGroup userGroup) {
        userGroupRepository.delete(UserGroupMapper.toEntity(userGroup, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            userGroupRepository.deleteById(id);        }
    }


    @Override
    public List<UserGroup> findAll() {
        return UserGroupMapper.toDtos(userGroupRepository.findAll(), false);
    }

    @Override
    public List<UserGroup> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return UserGroupMapper.toDtos(userGroupRepository.findAll(pageable), false);
    }
}
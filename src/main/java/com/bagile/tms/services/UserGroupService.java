package com.bagile.tms.services;

import com.sinno.ems.dto.UserGroup;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserGroupService {

    public UserGroup save(UserGroup userGroup);

    public Long size();

    public Boolean isExist(Long id);

    public UserGroup findById(Long id) throws IdNotFound;

    public List<UserGroup> find(String search) throws AttributesNotFound, ErrorType;

    public List<UserGroup> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(UserGroup userGroup);

    public List<UserGroup> findAll();

    public List<UserGroup> findAll(Pageable pageable);
}